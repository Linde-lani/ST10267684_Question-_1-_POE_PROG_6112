/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagmentapp;

import java.util.Scanner;
import java.util.*;

public class StudentManagementApp {
    public ArrayList<Student>students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    //This is the first prompt that the user will see when they first enter
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        while (true){
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String input = scanner.nextLine();
            if(!input.equals("1")){
                System.out.println("Exiting Application");
                break;
            }
            displayMenu();
        }
    }   
        //After the first prompt to launch the menu the user will see 
        public static void displayMenu() {
            System.out.println("\n************ ABC College************");
            
            System.out.println("Please select one of the following menu items:");
            System.out.println("Option 1) Capture a new student");
            System.out.println("Option 2) Search for a student");
            System.out.println("Option 3) Delete a student");
            System.out.println("Option 4) Print student report");
            System.out.println("Option 5) Exit application");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline
            StudentManagementApp find = new StudentManagementApp();
            
            switch (choice) {
                case 1 :
                    find.saveStudent();
                    
                    break;
                case 2:
                    System.out.print("Enter student ID to search for: ");
                String id = scanner.nextLine();
                    find.searchStudent(id);
                    
                    break;

                case 3:
                    System.out.print("Enter student ID to search to delete: ");
        String id_delete = scanner.nextLine();
                    find.deleteStudent(id_delete);
                    break;
                case 4:
                    
                    find.studentReport();
                    
                    break;
                case 5:
                    find.exitStudentApplication();
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        //This method will save the student's details
        public void saveStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        int age = 0;
        while (true) {
            System.out.print("Enter student age (>= 16): ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age. Please re-enter.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid student age. Please re-enter.");
            }
        }

        System.out.print("Please enter student email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println("Student details have been successfully saved.");
    }
    //This method will search for the student's details  
    public  void searchStudent( String id) {
        System.out.print("Enter the student ID to search: ");
        id = scanner.nextLine();
        Student foundStudent = null;

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            foundStudent.displayDetails();
        } else {
            System.out.println("Student with Student Id: " + id + " was not found.");
        }
    }
    //This method will delete the student's details
    public void deleteStudent(String id) {
        System.out.print("Enter the student ID to delete: ");
        id = scanner.nextLine();
        Student studentToDelete = null;

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete != null) {
            System.out.print("Are you sure you want to delete student " + id + " from the system? (Yes(y) or No(n)): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                students.remove(studentToDelete);
                System.out.println("Student with Student Id: " + id + " was deleted.");
            }
        } else {
            System.out.println("Student with Student Id: " + id + " was not found.");
        }
    }

    public void studentReport() {
        System.out.println("---- Student Report ----");
        for (Student student : students) {
            student.displayDetails();
            System.out.println("-------------------------");
        }
    }

    public void exitStudentApplication() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }
    public boolean isAgeValid(int age) {
        
        while (true) {
            System.out.print("Enter student age (>= 16): ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age. Please re-enter.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid student age. Please re-enter.");
            }
        }
        return false;}
}
