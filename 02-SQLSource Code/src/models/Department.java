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

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    private int deptId;
    private String deptName;

    // Default Constructor
    public Department() {}

    // Getters and Setters
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // Database Operations

    // Add Department
    public static void addDepartment(String deptName) throws SQLException {
        String query = "INSERT INTO departments (dept_name) VALUES (?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, deptName);
            statement.executeUpdate();
            System.out.println("Department added successfully!");
        }
    }

    // Edit Department
    public static void editDepartment(int deptId, String deptName) throws SQLException {
        String query = "UPDATE departments SET dept_name = ? WHERE dept_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, deptName);
            statement.setInt(2, deptId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Department updated successfully!");
            } else {
                System.out.println("Department ID not found.");
            }
        }
    }

    // List a single Department
    public static void listDepartment(int deptId) throws SQLException {
        String query = "SELECT * FROM departments WHERE dept_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, deptId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Department ID: " + resultSet.getInt("dept_id") +
                                   ", Department Name: " + resultSet.getString("dept_name"));
            } else {
                System.out.println("Department ID not found.");
            }
        }
    }

    // List all Departments
    public static List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM departments";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Department department = new Department();
                department.setDeptId(resultSet.getInt("dept_id"));
                department.setDeptName(resultSet.getString("dept_name"));
                departments.add(department);
            }
        }
        return departments;
    }

    // Delete Department
    public static void deleteDepartment(int deptId) throws SQLException {
        String query = "DELETE FROM departments WHERE dept_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, deptId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Department deleted successfully!");
            } else {
                System.out.println("Department ID not found.");
            }
        }
    }

public static void backupDepartments() {
    try {
        List<Department> departments = getAllDepartments();
        if (departments.isEmpty()) {
            System.out.println("No department records to back up.");
            return;
        }

        File dir = new File("backups");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backups/departments_backup.dat"))) {
            oos.writeObject(departments);
            System.out.println("Departments backed up successfully!");
        }
    } catch (IOException | SQLException e) {
        System.out.println("Error during department backup: " + e.getMessage());
    }
}


// Restore Departments
public static void restoreDepartments() throws SQLException {
    File backupFile = new File("backups/departments_backup.dat");
    if (!backupFile.exists()) {
        System.out.println("Backup file not found. Restore aborted.");
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backupFile))) {
        List<Department> departments = (List<Department>) ois.readObject();
        try (Connection connection = DatabaseConnection.connect()) {
            for (Department department : departments) {
                String query = "INSERT INTO departments (dept_id, dept_name) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, department.getDeptId()); // Backup'taki ID kullanılıyor
                    statement.setString(2, department.getDeptName());
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error restoring department: " +
                                       "Dept ID: " + department.getDeptId() +
                                       ", Dept Name: " + department.getDeptName());
                    e.printStackTrace(); // Hata detayları için
                }
            }
        }
        System.out.println("Departments restored successfully!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error during departments restore: " + e.getMessage());
        e.printStackTrace();
    }
}

  
}
