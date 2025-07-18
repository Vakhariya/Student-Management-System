package com.studentregistration.main;

import com.studentregistration.model.Student;
import com.studentregistration.dao.StudentDao;
import com.studentregistration.dao.StudentDaoInterface;

import java.util.Scanner;

public class Client {
    public static void main(String[] Args)
    {
        Scanner sc = new Scanner(System.in);

        StudentDaoInterface dao = new StudentDao();

        System.out.println("Welcome to Student Management application");

        while(true){
                System.out.println("\n1.Add Student" +
                        "\n2.Show All Students+" +
                        "\n3.Get student based on roll number+" +
                        "\n4.Delete Student"+
                        "\n5.Update Student" +
                        "\n6.Exit");

                System.out.println("Enter choice");
                int ch = sc.nextInt();

                switch (ch){
                    case 1:
                      System.out.println("Add Student");

                      System.out.println("Enter student name");

                      String name = sc.next();
                      System.out.println("Enter student clg name");

                      String clgName = sc.next();
                      System.out.println("Enter city");

                      String city = sc.next();
                      System.out.println("Enter Percentage");

                      double percentage = sc.nextDouble();
                      Student st = new Student(name,clgName,city,percentage);

                      boolean ans = dao.insertStudent(st);
                      
                      if(ans)
                          System.out.println("Record inserted Successfully!!!");
                      else
                          System.out.println("something went wrong, please try again");

                      break;

                    case 2:
                      System.out.println("Show all students ");
                      dao.showAllStudent();
                      break;

                    case 3:
                      System.out.println("Get student based on roll number");
                      System.out.println("Enter roll number");
                      int roll = sc.nextInt();

                      boolean student = dao.showStudentById(roll);

                      if(!student)
                        System.out.println("Student with this id is not available in our system");

                      break;

                    case 4:
                      System.out.println("Delete the Student");

                      System.out.println("Enter roll number to delete");
                      int rollnum = sc.nextInt();

                      boolean delStudent = dao.delete(rollnum);

                      if(delStudent)
                          System.out.println("Record deleted successfully...");
                      else
                          System.out.println("Something went wrong");

                      break;

                    case 5:
                      System.out.println("Update the Student");
                      System.out.println("\n1.Update name\n2.Update clgName");
                      System.out.println("enter your choice");
                      int choice = sc.nextInt();

                      if(choice == 1) {
                          System.out.println("enter roll number");
                          int rnum = sc.nextInt();

                          System.out.println("Enter new name");
                          String sname = sc.next();

                          Student std = new Student();
                          std.setName(sname);

                          boolean flag = dao.update(rnum,sname,choice,std);

                          if(flag)
                              System.out.println("Name updated successfully");
                          else
                              System.out.println("Something went wrong...");
                      }

                      break;
                    
                    case 6:
                      System.out.println("Thank You for using Student management application!!");
                      sc.close();
                      System.exit(0);
                      break;
                    
                    default:
                      System.out.println("Enter a valid choice");
                }
        }
    }
}