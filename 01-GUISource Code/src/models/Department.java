package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    private int deptId;
    private String deptName;

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

    public static List<Department> departments = new ArrayList<>();

    public static void addDepartment(int deptId, String deptName) {
        Department department = new Department();
        department.setDeptId(deptId);
        department.setDeptName(deptName);
        departments.add(department);
        System.out.println("Department ID " + deptId + " added successfully!");
    }

    public static void editDepartment(int deptId, String deptName) {
        for (Department department : departments) {
            if (department.getDeptId() == deptId) {
                department.setDeptName(deptName);
                System.out.println("Department ID " + deptId + " updated successfully!");
                return;
            }
        }
        System.out.println("Department ID " + deptId + " not found.");
    }

    public static void listDepartment(int deptId) {
        for (Department department : departments) {
            if (department.getDeptId() == deptId) {
                System.out.println("Department ID: " + department.getDeptId() +
                                   ", Name: " + department.getDeptName());
                return;
            }
        }
        System.out.println("Department ID " + deptId + " not found.");
    }

    public static void listAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }
        for (Department department : departments) {
            System.out.println("Department ID: " + department.getDeptId() +
                               ", Name: " + department.getDeptName());
        }
    }

    public static void deleteDepartment(int deptId) {
        Iterator<Department> iterator = departments.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.getDeptId() == deptId) {
                iterator.remove();
                System.out.println("Department ID " + deptId + " deleted successfully!");
                return;
            }
        }
        System.out.println("Department ID " + deptId + " not found.");
    }

    public static void backupDepartments() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("departments_backup.dat"))) {
            oos.writeObject(departments);
            System.out.println(departments.size() + " departments have been backed up!");
        } catch (IOException e) {
            System.out.println("Error during backup: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void restoreDepartments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("departments_backup.dat"))) {
            departments = (List<Department>) ois.readObject();
            System.out.println(departments.size() + " departments have been restored!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during restore: " + e.getMessage());
        }
    }
}
