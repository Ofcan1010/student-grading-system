package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Grades implements Serializable {
    private static final long serialVersionUID = 1L;
    private int grdId;
    private int stdId;
    private int crsId;
    private float grdMt;
    private float grdHw;
    private float grdFinal;
    private String grdLgrade;

    // Default Constructor
    public Grades() {}

    // Getters and Setters
    public int getGrdId() {
        return grdId;
    }

    public void setGrdId(int grdId) {
        this.grdId = grdId;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public int getCrsId() {
        return crsId;
    }

    public void setCrsId(int crsId) {
        this.crsId = crsId;
    }

    public float getGrdMt() {
        return grdMt;
    }

    public void setGrdMt(float grdMt) {
        this.grdMt = grdMt;
    }

    public float getGrdHw() {
        return grdHw;
    }

    public void setGrdHw(float grdHw) {
        this.grdHw = grdHw;
    }

    public float getGrdFinal() {
        return grdFinal;
    }

    public void setGrdFinal(float grdFinal) {
        this.grdFinal = grdFinal;
    }

    public String getGrdLgrade() {
        return grdLgrade;
    }

    public void setGrdLgrade(String grdLgrade) {
        this.grdLgrade = grdLgrade;
    }

    // Database Operations

    // Add Grade
    public static void addGrade(int stdId, int crsId, float grdMt, float grdHw, float grdFinal, String grdLgrade) throws SQLException {
        String query = "INSERT INTO grades (std_id, crs_id, grd_mt, grd_hw, grd_final, grd_lgrade) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stdId);
            statement.setInt(2, crsId);
            statement.setFloat(3, grdMt);
            statement.setFloat(4, grdHw);
            statement.setFloat(5, grdFinal);
            statement.setString(6, grdLgrade);
            statement.executeUpdate();
            System.out.println("Grade added successfully!");
        }
    }

    // Edit Grade
    public static void editGrade(int grdId, int stdId, int crsId, float grdMt, float grdHw, float grdFinal, String grdLgrade) throws SQLException {
        String query = "UPDATE grades SET std_id = ?, crs_id = ?, grd_mt = ?, grd_hw = ?, grd_final = ?, grd_lgrade = ? WHERE grd_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stdId);
            statement.setInt(2, crsId);
            statement.setFloat(3, grdMt);
            statement.setFloat(4, grdHw);
            statement.setFloat(5, grdFinal);
            statement.setString(6, grdLgrade);
            statement.setInt(7, grdId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Grade updated successfully!");
            } else {
                System.out.println("Grade ID not found.");
            }
        }
    }

    // List a single Grade
    public static void listGrade(int grdId) throws SQLException {
        String query = "SELECT * FROM grades WHERE grd_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, grdId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Grade ID: " + resultSet.getInt("grd_id") +
                                   ", Student ID: " + resultSet.getInt("std_id") +
                                   ", Course ID: " + resultSet.getInt("crs_id") +
                                   ", Midterm: " + resultSet.getFloat("grd_mt") +
                                   ", Homework: " + resultSet.getFloat("grd_hw") +
                                   ", Final: " + resultSet.getFloat("grd_final") +
                                   ", Letter Grade: " + resultSet.getString("grd_lgrade"));
            } else {
                System.out.println("Grade ID not found.");
            }
        }
    }

    // List all Grades
    public static List<Grades> getAllGrades() throws SQLException {
        List<Grades> gradesList = new ArrayList<>();
        String query = "SELECT * FROM grades";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Grades grade = new Grades();
                grade.setGrdId(resultSet.getInt("grd_id"));
                grade.setStdId(resultSet.getInt("std_id"));
                grade.setCrsId(resultSet.getInt("crs_id"));
                grade.setGrdMt(resultSet.getFloat("grd_mt"));
                grade.setGrdHw(resultSet.getFloat("grd_hw"));
                grade.setGrdFinal(resultSet.getFloat("grd_final"));
                grade.setGrdLgrade(resultSet.getString("grd_lgrade"));
                gradesList.add(grade);
            }
        }
        return gradesList;
    }

    // Delete Grade
    public static void deleteGrade(int grdId) throws SQLException {
        String query = "DELETE FROM grades WHERE grd_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, grdId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Grade deleted successfully!");
            } else {
                System.out.println("Grade ID not found.");
            }
        }
    }

    // Backup Grades
    public static void backupGrades() {
        try {
            List<Grades> grades = getAllGrades();
            File dir = new File("backups");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backups/grades_backup.dat"))) {
                oos.writeObject(grades);
                System.out.println("Grades backed up successfully!");
            }
        } catch (IOException | SQLException e) {
            System.out.println("Error during grades backup: " + e.getMessage());
        }
    }


    // Restore Grades
public static void restoreGrades() throws SQLException {
    File backupFile = new File("backups/grades_backup.dat");
    if (!backupFile.exists()) {
        System.out.println("Backup file not found. Restore aborted.");
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backupFile))) {
        List<Grades> gradesList = (List<Grades>) ois.readObject();
        try (Connection connection = DatabaseConnection.connect()) {
            for (Grades grade : gradesList) {
                String query = "INSERT INTO grades (grd_id, std_id, crs_id, grd_mt, grd_hw, grd_final, grd_lgrade) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, grade.getGrdId());         // Backup'taki grd_id
                    statement.setInt(2, grade.getStdId());         // Backup'taki std_id
                    statement.setInt(3, grade.getCrsId());         // Backup'taki crs_id
                    statement.setFloat(4, grade.getGrdMt());       // Backup'taki grd_mt
                    statement.setFloat(5, grade.getGrdHw());       // Backup'taki grd_hw
                    statement.setFloat(6, grade.getGrdFinal());    // Backup'taki grd_final
                    statement.setString(7, grade.getGrdLgrade());  // Backup'taki grd_lgrade
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error restoring grade: " +
                                       "Grade ID: " + grade.getGrdId() +
                                       ", Std ID: " + grade.getStdId() +
                                       ", Crs ID: " + grade.getCrsId() +
                                       ", Midterm: " + grade.getGrdMt() +
                                       ", Homework: " + grade.getGrdHw() +
                                       ", Final: " + grade.getGrdFinal() +
                                       ", Letter Grade: " + grade.getGrdLgrade());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Grades restored successfully!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error during grades restore: " + e.getMessage());
        e.printStackTrace();
    }
}


}
