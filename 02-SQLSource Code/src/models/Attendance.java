package models;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    private int attId;
    private int stdId;
    private int crsId;
    private Date attDate;

    // Default constructor
    public Attendance() {}

    // Getters and Setters
    public int getAttId() {
        return attId;
    }

    public void setAttId(int attId) {
        this.attId = attId;
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

    public Date getAttDate() {
        return attDate;
    }

    public void setAttDate(Date attDate) {
        this.attDate = attDate;
    }

    // Database Operations

    // Add Attendance with duplicate check
    public static void addAttendance(int stdId, int crsId, Date attDate) throws SQLException {
        String checkQuery = "SELECT * FROM attendance WHERE std_id = ? AND crs_id = ? AND att_date = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, stdId);
            checkStmt.setInt(2, crsId);
            checkStmt.setDate(3, attDate);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                System.out.println("Attendance record already exists. Skipping.");
                return;
            }
        }

        String query = "INSERT INTO attendance (std_id, crs_id, att_date) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stdId);
            statement.setInt(2, crsId);
            statement.setDate(3, attDate);
            statement.executeUpdate();
            System.out.println("Attendance added successfully!");
        }
    }

    // Edit Attendance
    public static void editAttendance(int attId, int stdId, int crsId, Date attDate) throws SQLException {
        String query = "UPDATE attendance SET std_id = ?, crs_id = ?, att_date = ? WHERE att_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stdId);
            statement.setInt(2, crsId);
            statement.setDate(3, attDate);
            statement.setInt(4, attId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Attendance updated successfully!");
            } else {
                System.out.println("Attendance ID not found.");
            }
        }
    }

    // List a single Attendance record
    public static void listAttendance(int attId) throws SQLException {
        String query = "SELECT * FROM attendance WHERE att_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, attId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Attendance ID: " + resultSet.getInt("att_id") +
                                   ", Student ID: " + resultSet.getInt("std_id") +
                                   ", Course ID: " + resultSet.getInt("crs_id") +
                                   ", Attendance Date: " + resultSet.getDate("att_date"));
            } else {
                System.out.println("Attendance ID not found.");
            }
        }
    }

    // List all Attendance records
    public static List<Attendance> getAllAttendances() throws SQLException {
        List<Attendance> attendances = new ArrayList<>();
        String query = "SELECT * FROM attendance";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Attendance attendance = new Attendance();
                attendance.setAttId(resultSet.getInt("att_id"));
                attendance.setStdId(resultSet.getInt("std_id"));
                attendance.setCrsId(resultSet.getInt("crs_id"));
                attendance.setAttDate(resultSet.getDate("att_date"));
                attendances.add(attendance);
            }
        }
        return attendances;
    }

    // Delete Attendance
    public static void deleteAttendance(int attId) throws SQLException {
        String query = "DELETE FROM attendance WHERE att_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, attId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Attendance deleted successfully!");
            } else {
                System.out.println("Attendance ID not found.");
            }
        }
    }

    // Backup Attendances
    public static void backupAttendances() {
        try {
            List<Attendance> attendances = getAllAttendances();
            if (attendances.isEmpty()) {
                System.out.println("No attendance records to back up.");
                return;
            }

            File dir = new File("backups");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backups/attendances_backup.dat"))) {
                oos.writeObject(attendances);
                System.out.println("Attendances backed up successfully!");
            }
        } catch (IOException | SQLException e) {
            System.out.println("Error during attendance backup: " + e.getMessage());
        }
    }

public static void restoreAttendances() throws SQLException {
    File backupFile = new File("backups/attendances_backup.dat");
    if (!backupFile.exists()) {
        System.out.println("Backup file not found. Restore aborted.");
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backupFile))) {
        List<Attendance> attendances = (List<Attendance>) ois.readObject();
        try (Connection connection = DatabaseConnection.connect()) {
            for (Attendance attendance : attendances) {
                String query = "INSERT INTO attendance (std_id, crs_id, att_date) VALUES (?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, attendance.getStdId());   // Backup'taki std_id
                    statement.setInt(2, attendance.getCrsId());   // Backup'taki crs_id
                    statement.setDate(3, attendance.getAttDate()); // Backup'taki att_date
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error restoring attendance: " +
                                       "Std ID: " + attendance.getStdId() +
                                       ", Crs ID: " + attendance.getCrsId() +
                                       ", Date: " + attendance.getAttDate());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Attendances restored successfully!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error during attendance restore: " + e.getMessage());
        e.printStackTrace();
    }
}

}


