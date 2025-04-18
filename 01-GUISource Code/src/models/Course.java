package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private int crsId;
    private int deptId;
    private String crsCode;
    private String crsName;

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

    public static List<Course> courses = new ArrayList<>();

    public static void addCourse(int crsId, int deptId, String crsCode, String crsName) {
        Course course = new Course();
        course.setCrsId(crsId);
        course.setDeptId(deptId);
        course.setCrsCode(crsCode);
        course.setCrsName(crsName);
        courses.add(course);
        System.out.println("Course ID " + crsId + " added successfully!");
    }

    public static void editCourse(int crsId, int deptId, String crsCode, String crsName) {
        for (Course course : courses) {
            if (course.getCrsId() == crsId) {
                course.setDeptId(deptId);
                course.setCrsCode(crsCode);
                course.setCrsName(crsName);
                System.out.println("Course ID " + crsId + " updated successfully!");
                return;
            }
        }
        System.out.println("Course ID " + crsId + " not found.");
    }

    public static void listCourse(int crsId) {
        for (Course course : courses) {
            if (course.getCrsId() == crsId) {
                System.out.println("ID: " + course.getCrsId() +
                                   ", Dept ID: " + course.getDeptId() +
                                   ", Code: " + course.getCrsCode() +
                                   ", Name: " + course.getCrsName());
                return;
            }
        }
        System.out.println("Course ID " + crsId + " not found.");
    }

    public static void listAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course course : courses) {
            System.out.println("ID: " + course.getCrsId() +
                               ", Dept ID: " + course.getDeptId() +
                               ", Code: " + course.getCrsCode() +
                               ", Name: " + course.getCrsName());
        }
    }

    public static void deleteCourse(int crsId) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getCrsId() == crsId) {
                iterator.remove();
                System.out.println("Course ID " + crsId + " deleted successfully!");
                return;
            }
        }
        System.out.println("Course ID " + crsId + " not found.");
    }

    public static void backupCourses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("courses_backup.dat"))) {
            oos.writeObject(courses);
            System.out.println(courses.size() + " courses have been backed up!");
        } catch (IOException e) {
            System.out.println("Error during backup: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreCourses() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("courses_backup.dat"))) {
            courses = (List<Course>) ois.readObject();
            System.out.println(courses.size() + " courses have been restored!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during restore: " + e.getMessage());
        }
    }
}
