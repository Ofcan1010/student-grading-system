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

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int stdId;
    private String stdNo;
    private String name;
    private String surname;
    private char gender;
    private String nationality;
    private String birthday;

    // Default Constructor
    public Student() {}

    // Getters and Setters
    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // Database Operations

    // Add Student
    public static void addStudent(String stdNo, String name, String surname, char gender, String nationality, String birthday) throws SQLException {
        String query = "INSERT INTO students (std_no, name, surname, gender, nationality, birthday) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, stdNo);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setString(4, String.valueOf(gender));
            statement.setString(5, nationality);
            statement.setString(6, birthday);
            statement.executeUpdate();
            System.out.println("Student added successfully!");
        }
    }

    // Edit Student
    public static void editStudent(int stdId, String stdNo, String name, String surname, char gender, String nationality, String birthday) throws SQLException {
        String query = "UPDATE students SET std_no = ?, name = ?, surname = ?, gender = ?, nationality = ?, birthday = ? WHERE std_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, stdNo);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.setString(4, String.valueOf(gender));
            statement.setString(5, nationality);
            statement.setString(6, birthday);
            statement.setInt(7, stdId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }

    // List a single Student
    public static void listStudent(int stdId) throws SQLException {
        String query = "SELECT * FROM students WHERE std_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stdId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("std_id") +
                                   ", Student No: " + resultSet.getString("std_no") +
                                   ", Name: " + resultSet.getString("name") +
                                   ", Surname: " + resultSet.getString("surname") +
                                   ", Gender: " + resultSet.getString("gender") +
                                   ", Nationality: " + resultSet.getString("nationality") +
                                   ", Birthday: " + resultSet.getString("birthday"));
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }

    // List all Students
    public static List<Student> getAllStudents() throws SQLException {
        List<Student> studentsList = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setStdId(resultSet.getInt("std_id"));
                student.setStdNo(resultSet.getString("std_no"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setGender(resultSet.getString("gender").charAt(0));
                student.setNationality(resultSet.getString("nationality"));
                student.setBirthday(resultSet.getString("birthday"));
                studentsList.add(student);
            }
        }
        return studentsList;
    }

    // Delete Student
    public static void deleteStudent(int stdId) throws SQLException {
        String query = "DELETE FROM students WHERE std_id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stdId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }

    // Backup Students
    public static void backupStudents() {
        try {
            List<Student> students = getAllStudents();
            File dir = new File("backups");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backups/students_backup.dat"))) {
                oos.writeObject(students);
                System.out.println("Students backed up successfully!");
            }
        } catch (IOException | SQLException e) {
            System.out.println("Error during student backup: " + e.getMessage());
        }
    }

// Restore Students
public static void restoreStudents() throws SQLException {
    File backupFile = new File("backups/students_backup.dat");
    if (!backupFile.exists()) {
        System.out.println("Backup file not found. Restore aborted.");
        return;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backupFile))) {
        List<Student> students = (List<Student>) ois.readObject();
        try (Connection connection = DatabaseConnection.connect()) {
            for (Student student : students) {
                String query = "INSERT INTO students (std_id, std_no, name, surname, gender, nationality, birthday) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, student.getStdId());           // Backup'taki std_id
                    statement.setString(2, student.getStdNo());       // Backup'taki std_no
                    statement.setString(3, student.getName());        // Backup'taki name
                    statement.setString(4, student.getSurname());     // Backup'taki surname
                    statement.setString(5, String.valueOf(student.getGender())); // Backup'taki gender
                    statement.setString(6, student.getNationality()); // Backup'taki nationality

                    // Tarihi uygun şekilde java.sql.Date formatına dönüştür
                    if (student.getBirthday() != null && !student.getBirthday().isEmpty()) {
                        statement.setDate(7, java.sql.Date.valueOf(student.getBirthday())); // String -> java.sql.Date
                    } else {
                        statement.setNull(7, java.sql.Types.DATE); // Nullsa veritabanına null ekle
                    }

                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error restoring student: " +
                                       "Std ID: " + student.getStdId() +
                                       ", Std No: " + student.getStdNo() +
                                       ", Name: " + student.getName() +
                                       ", Surname: " + student.getSurname());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Students restored successfully!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error during student restore: " + e.getMessage());
        e.printStackTrace();
    }
}

}
