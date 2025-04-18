package models;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grades implements Serializable {
    private static final long serialVersionUID = 1L;

    private int grdId;
    private int stdId;
    private int crsId;
    private float grdMt;
    private float grdHw;
    private float grdFinal;
    private String grdLgrade;

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

    public static List<Grades> grades = new ArrayList<>();

    public static void addGrade(int grdId, int stdId, int crsId, float grdMt, float grdHw, float grdFinal, String grdLgrade) {
        Grades grade = new Grades();
        grade.setGrdId(grdId);
        grade.setStdId(stdId);
        grade.setCrsId(crsId);
        grade.setGrdMt(grdMt);
        grade.setGrdHw(grdHw);
        grade.setGrdFinal(grdFinal);
        grade.setGrdLgrade(grdLgrade);
        grades.add(grade);
        System.out.println("Grade ID " + grdId + " added successfully!");
    }

    public static void editGrade(int grdId, int stdId, int crsId, float grdMt, float grdHw, float grdFinal, String grdLgrade) {
        for (Grades grade : grades) {
            if (grade.getGrdId() == grdId) {
                grade.setStdId(stdId);
                grade.setCrsId(crsId);
                grade.setGrdMt(grdMt);
                grade.setGrdHw(grdHw);
                grade.setGrdFinal(grdFinal);
                grade.setGrdLgrade(grdLgrade);
                System.out.println("Grade ID " + grdId + " updated successfully!");
                return;
            }
        }
        System.out.println("Grade ID " + grdId + " not found.");
    }

    public static void listGrade(int grdId) {
        for (Grades grade : grades) {
            if (grade.getGrdId() == grdId) {
                System.out.println("Grade ID: " + grade.getGrdId() +
                                   ", Student ID: " + grade.getStdId() +
                                   ", Course ID: " + grade.getCrsId() +
                                   ", Midterm: " + grade.getGrdMt() +
                                   ", Homework: " + grade.getGrdHw() +
                                   ", Final: " + grade.getGrdFinal() +
                                   ", Letter Grade: " + grade.getGrdLgrade());
                return;
            }
        }
        System.out.println("Grade ID " + grdId + " not found.");
    }

    public static void listAllGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        for (Grades grade : grades) {
            System.out.println("Grade ID: " + grade.getGrdId() +
                               ", Student ID: " + grade.getStdId() +
                               ", Course ID: " + grade.getCrsId() +
                               ", Midterm: " + grade.getGrdMt() +
                               ", Homework: " + grade.getGrdHw() +
                               ", Final: " + grade.getGrdFinal() +
                               ", Letter Grade: " + grade.getGrdLgrade());
        }
    }

    public static void deleteGrade(int grdId) {
        Iterator<Grades> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Grades grade = iterator.next();
            if (grade.getGrdId() == grdId) {
                iterator.remove();
                System.out.println("Grade ID " + grdId + " deleted successfully!");
                return;
            }
        }
        System.out.println("Grade ID " + grdId + " not found.");
    }

    public static void backupGrades() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("grades_backup.dat"))) {
            oos.writeObject(grades);
            System.out.println(grades.size() + " grades have been backed up!");
        } catch (IOException e) {
            System.out.println("Error during backup: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreGrades() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("grades_backup.dat"))) {
            grades = (List<Grades>) ois.readObject();
            System.out.println(grades.size() + " grades have been restored!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during restore: " + e.getMessage());
        }
    }
}
