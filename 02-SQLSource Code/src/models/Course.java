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

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private int crsId;
    private int deptId;
    private String crsCode;
    private String crsName;

    // Default Constructor
    public Course() {}

    // Getters and Setters
    public int getCrsId() {
        return crsId;
    }

    public void setCrsId(int crsId) {
        this.crsId = crsId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getCrsCode() {
        return crsCode;
    }

    public void setCrsCode(String crsCode) {
        this.crsCode = crsCode;
    }

    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }

    // Database Operations

    // Add Course
    public static void addCourse(int deptId, String crsCode, String crsName) throws SQLException {
        String query = "INSERT INTO courses (dept_id, crs_code, crs_name) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, deptId);
            statement.setString(2, crsCode);
            statement.setString(3, crsName);
            statement.executeUpdate();
            System.out.println("Course added successfully!");
        }
    }

    // Edit Course
    public static void editCourse(int crsId, int deptId, String crsCode, String crsName) throws SQLException {
        String query = "UPDATE courses SET dept_id = ?, crs_code = ?, crs_name = ? WHERE crs_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, deptId);
            statement.setString(2, crsCode);
            statement.setString(3, crsName);
            statement.setInt(4, crsId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Course updated successfully!");
            } else {
                System.out.println("Course ID not found.");
            }
        }
    }

    // List a single Course
    public static void listCourse(int crsId) throws SQLException {
        String query = "SELECT * FROM courses WHERE crs_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, crsId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Course ID: " + resultSet.getInt("crs_id") +
                                   ", Department ID: " + resultSet.getInt("dept_id") +
                                   ", Course Code: " + resultSet.getString("crs_code") +
                                   ", Course Name: " + resultSet.getString("crs_name"));
            } else {
                System.out.println("Course ID not found.");
            }
        }
    }

    // List all Courses
    public static List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Course course = new Course();
                course.setCrsId(resultSet.getInt("crs_id"));
                course.setDeptId(resultSet.getInt("dept_id"));
                course.setCrsCode(resultSet.getString("crs_code"));
                course.setCrsName(resultSet.getString("crs_name"));
                courses.add(course);
            }
        }
        return courses;
    }

    // Delete Course
    public static void deleteCourse(int crsId) throws SQLException {
        String query = "DELETE FROM courses WHERE crs_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, crsId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("Course ID not found.");
            }
        }
    }

    // Backup Courses
    public static void backupCourses() {
        try {
            List<Course> courses = getAllCourses();
            File dir = new File("backups");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backups/courses_backup.dat"))) {
                oos.writeObject(courses);
                System.out.println("Courses backed up successfully!");
            }
        } catch (IOException | SQLException e) {
            System.out.println("Error during course backup: " + e.getMessage());
        }
    }

// Restore Courses
public static void restoreCourses() throws SQLException {
    File backupFile = new File("backups/courses_backup.dat");
    if (!backupFile.exists()) {
        System.out.println("Backup file not found. Restore aborted.");
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backupFile))) {
        List<Course> courses = (List<Course>) ois.readObject();
        try (Connection connection = DatabaseConnection.connect()) {
            for (Course course : courses) {
                String query = "INSERT INTO courses (crs_id, dept_id, crs_code, crs_name) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, course.getCrsId());       // Backup'taki crs_id
                    statement.setInt(2, course.getDeptId());     // Backup'taki dept_id
                    statement.setString(3, course.getCrsCode()); // Backup'taki crs_code
                    statement.setString(4, course.getCrsName()); // Backup'taki crs_name
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error restoring course: " +
                                       "Course ID: " + course.getCrsId() +
                                       ", Dept ID: " + course.getDeptId() +
                                       ", Course Code: " + course.getCrsCode() +
                                       ", Course Name: " + course.getCrsName());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Courses restored successfully!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error during courses restore: " + e.getMessage());
        e.printStackTrace();
    }
}


}
