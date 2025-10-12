package view;

import controller.StudentController;
import model.Student;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        try {
            StudentController controller = new StudentController();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\nStudent Management Menu:");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Dept: "); String
