package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;

    private int attId;
    private int stdId;
    private int crsId;
    private String attDate;

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

    public String getAttDate() {
        return attDate;
    }

    public void setAttDate(String attDate) {
        this.attDate = attDate;
    }

    public static List<Attendance> attendances = new ArrayList<>();

    public static void addAttendance(int attId, int stdId, int crsId, String attDate) {
        Attendance attendance = new Attendance();
        attendance.setAttId(attId);
        attendance.setStdId(stdId);
        attendance.setCrsId(crsId);
        attendance.setAttDate(attDate);
        attendances.add(attendance);
        System.out.println("Attendance ID " + attId + " added successfully!");
    }

    public static void editAttendance(int attId, int stdId, int crsId, String attDate) {
        for (Attendance attendance : attendances) {
            if (attendance.getAttId() == attId) {
                attendance.setStdId(stdId);
                attendance.setCrsId(crsId);
                attendance.setAttDate(attDate);
                System.out.println("Attendance ID " + attId + " updated successfully!");
                return;
            }
        }
        System.out.println("Attendance ID " + attId + " not found.");
    }

    public static void listAttendance(int attId) {
        for (Attendance attendance : attendances) {
            if (attendance.getAttId() == attId) {
                System.out.println("Attendance ID: " + attendance.getAttId() +
                                   ", Student ID: " + attendance.getStdId() +
                                   ", Course ID: " + attendance.getCrsId() +
                                   ", Attendance Date: " + attendance.getAttDate());
                return;
            }
        }
        System.out.println("Attendance ID " + attId + " not found.");
    }

    public static void listAllAttendances() {
        if (attendances.isEmpty()) {
            System.out.println("No attendance records available.");
            return;
        }
        for (Attendance attendance : attendances) {
            System.out.println("Attendance ID: " + attendance.getAttId() +
                               ", Student ID: " + attendance.getStdId() +
                               ", Course ID: " + attendance.getCrsId() +
                               ", Attendance Date: " + attendance.getAttDate());
        }
    }

    public static void deleteAttendance(int attId) {
        Iterator<Attendance> iterator = attendances.iterator();
        while (iterator.hasNext()) {
            Attendance attendance = iterator.next();
            if (attendance.getAttId() == attId) {
                iterator.remove();
                System.out.println("Attendance ID " + attId + " deleted successfully!");
                return;
            }
        }
        System.out.println("Attendance ID " + attId + " not found.");
    }

    public static void backupAttendances() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("attendances_backup.dat"))) {
            oos.writeObject(attendances);
            System.out.println(attendances.size() + " attendances have been backed up!");
        } catch (IOException e) {
            System.out.println("Error during backup: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreAttendances() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("attendances_backup.dat"))) {
            attendances = (List<Attendance>) ois.readObject();
            System.out.println(attendances.size() + " attendances have been restored!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during restore: " + e.getMessage());
        }
    }
}
