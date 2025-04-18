package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int stdId;
    private String stdNo;
    private String name;
    private String surname;
    private char gender;
    private String nationality;
    private String birthday;

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

    public static List<Student> students = new ArrayList<>();

    public static void addStudent(int id, String stdNo, String name, String surname, char gender, String nationality, String birthday) {
        Student student = new Student();
        student.setStdId(id);
        student.setStdNo(stdNo);
        student.setName(name);
        student.setSurname(surname);
        student.setGender(gender);
        student.setNationality(nationality);
        student.setBirthday(birthday);
        students.add(student);
        System.out.println("Student ID " + id + " added successfully!");
    }

    public static void editStudent(int id, String stdNo, String name, String surname, char gender, String nationality, String birthday) {
        for (Student student : students) {
            if (student.getStdId() == id) {
                student.setStdNo(stdNo);
                student.setName(name);
                student.setSurname(surname);
                student.setGender(gender);
                student.setNationality(nationality);
                student.setBirthday(birthday);
                System.out.println("Student ID " + id + " updated successfully!");
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    public static void listStudent(int id) {
        for (Student student : students) {
            if (student.getStdId() == id) {
                System.out.println("ID: " + student.getStdId() +
                                   ", Student No: " + student.getStdNo() +
                                   ", Name: " + student.getName() +
                                   ", Surname: " + student.getSurname() +
                                   ", Gender: " + student.getGender() +
                                   ", Nationality: " + student.getNationality() +
                                   ", Birthday: " + student.getBirthday());
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    public static void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println("ID: " + student.getStdId() +
                               ", Student No: " + student.getStdNo() +
                               ", Name: " + student.getName() +
                               ", Surname: " + student.getSurname() +
                               ", Gender: " + student.getGender() +
                               ", Nationality: " + student.getNationality() +
                               ", Birthday: " + student.getBirthday());
        }
    }

    public static void deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStdId() == id) {
                iterator.remove();
                System.out.println("Student ID " + id + " deleted successfully!");
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    public static void backupStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students_backup.dat"))) {
            oos.writeObject(students);
            System.out.println(students.size() + " students have been backed up!");
        } catch (IOException e) {
            System.out.println("Error during backup: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students_backup.dat"))) {
            students = (List<Student>) ois.readObject();
            System.out.println(students.size() + " students have been restored!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during restore: " + e.getMessage());
        }
    }
}
