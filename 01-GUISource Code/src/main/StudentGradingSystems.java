package main;

import models.*;

public class StudentGradingSystems {
    public static void main(String[] args) {
        // 1. Add all data
        System.out.println("1. Adding data for all classes...");
        Student.addStudent(1, "189222", "Ayse", "Cengiz", 'F', "Turkey", "2002-03-28");
        Student.addStudent(2, "193342", "Philip", "Udoye", 'M', "Nigeria", "2003-09-16");
        Student.addStudent(3, "189931", "Kemal", "Salih", 'M', "TRNC", "2002-05-17");
        Student.addStudent(4, "188883", "Fathima", "Mohammad", 'F', "Syria", "2001-11-22");

        Course.addCourse(1, 1, "ITEC314", "Multi Platform Programming");
        Course.addCourse(2, 1, "ITEC413", "Information Systems Security");
        Course.addCourse(3, 2, "ECON101", "Introduction to Economics");
        Course.addCourse(4, 3, "BUSS103", "Fundamentals of Business Administration");

        Department.addDepartment(1, "Information Technologies");
        Department.addDepartment(2, "Economics");
        Department.addDepartment(3, "Business");

        Grades.addGrade(1, 1, 1, 90f, 88f, 96f, "A");
        Grades.addGrade(2, 2, 1, 80f, 85f, 82f, "B+");
        Grades.addGrade(3, 3, 2, 75f, 80f, 77f, "B-");
        Grades.addGrade(4, 4, 2, 69f, 75f, 66f, "C+");

        Attendance.addAttendance(1, 1, 1, "2021-04-09");
        Attendance.addAttendance(2, 2, 1, "2021-04-09");
        Attendance.addAttendance(3, 3, 2, "2021-04-09");
        Attendance.addAttendance(4, 4, 2, "2021-04-09");

        // 2. List all data
        System.out.println("\n2. Listing all data...");
        Student.listAllStudents();
        Course.listAllCourses();
        Department.listAllDepartments();
        Grades.listAllGrades();
        Attendance.listAllAttendances();

        // 3. Edit the 2nd object in all classes
        System.out.println("\n3. Editing the 2nd object for all classes...");
        Student.editStudent(2, "193342", "Philip", "Udoye Jr.", 'M', "Nigeria", "2003-09-16");
        Course.editCourse(2, 1, "ITEC413", "Cyber Security Basics");
        Department.editDepartment(2, "Applied Economics");
        Grades.editGrade(2, 2, 1, 85f, 90f, 87f, "A-");
        Attendance.editAttendance(2, 2, 1, "2021-04-10");

        // 4. List all data after editing
        System.out.println("\n4. Listing all data after editing...");
        Student.listAllStudents();
        Course.listAllCourses();
        Department.listAllDepartments();
        Grades.listAllGrades();
        Attendance.listAllAttendances();

        // 5. Backup all data
        System.out.println("\n5. Backing up all data...");
        Student.backupStudents();
        Course.backupCourses();
        Department.backupDepartments();
        Grades.backupGrades();
        Attendance.backupAttendances();

        // 6. Delete the 3rd object in all classes
        System.out.println("\n6. Deleting the 3rd object for all classes...");
        Student.deleteStudent(3);
        Course.deleteCourse(3);
        Department.deleteDepartment(3);
        Grades.deleteGrade(3);
        Attendance.deleteAttendance(3);

        // 7. List all data after deletion
        System.out.println("\n7. Listing all data after deletion...");
        Student.listAllStudents();
        Course.listAllCourses();
        Department.listAllDepartments();
        Grades.listAllGrades();
        Attendance.listAllAttendances();

        // 8. Restore all data
        System.out.println("\n8. Restoring all data...");
        Student.restoreStudents();
        Course.restoreCourses();
        Department.restoreDepartments();
        Grades.restoreGrades();
        Attendance.restoreAttendances();

        // 9. List all data after restoring
        System.out.println("\n9. Listing all data after restoring...");
        Student.listAllStudents();
        Course.listAllCourses();
        Department.listAllDepartments();
        Grades.listAllGrades();
        Attendance.listAllAttendances();
    }
}
