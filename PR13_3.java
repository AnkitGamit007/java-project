package com.example.pract;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

interface Result{
     int percentage = 0;

     void getMarks();
 }
class Student implements Result{
     int Enroll = 0;
    static int counter = 0;
    String Name;
    static Collection<Student> ls = new ArrayList<>();
    Student()
    {
        counter++;
        System.out.println("Welcome to the Student Information System");
    }

    Student (int Enroll, String name)
    {
        this();
        this.Enroll = Enroll;
        this.Name = name;
//        try {
//            FileWriter record = new FileWriter("Student.txt", true);
//            record.write("Enrollment number = " + Enroll + " Student Name = " + Name + "\n");
//            record.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
    void setData(String name)
    {
        this.Name = name;
    }

    static void add(Student s)
    {
        ls.add(s);
        System.out.println("Student Added");
    }

    static void Update()
    {
        System.out.println("Enter roll number to Update");
        int enroll = new Scanner(System.in).nextInt();
        for(Student sc : ls)
        {
            if(sc.Enroll == enroll)
            {
                System.out.println("Enter Name to update");
                sc.Name = new Scanner(System.in).nextLine();
                System.out.println("Detail Updated");
                return;
            }
        }
        System.out.println("No such student found");
    }

    static void find()
    {
        System.out.println("Enter roll number to Find");
        int enroll = new Scanner(System.in).nextInt();
        for(Student sc : ls)
        {
            if(sc.Enroll == enroll)
            {
                System.out.println("Student found in system.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void delete()
    {
        System.out.println("Enter roll number to Delete");
        int enroll = new Scanner(System.in).nextInt();
        for(Student sc : ls)
        {
            if(sc.Enroll == enroll)
            {
                ls.remove(sc);
                System.out.println("Student Removed");
                return;
            }
        }
        System.out.println("Student not found.");
    }


    static void display()
    {
        for(Student sc : ls) {
            System.out.println("Enrollment : " + sc.Enroll + " Name : " + sc.Name);
        }
    }


    public void getMarks() {
        System.out.println("Enter marks of 3 subjects");
        int m1 = new Scanner(System.in).nextInt();
        int m2 = new Scanner(System.in).nextInt();
        int m3 = new Scanner(System.in).nextInt();
        System.out.println("Average marks are " + ((m1+m2+m3)/3));
    }
}

public class PR13_3 {
    public static void main(String[] args) {
        int choice = 0;
        while(choice < 6)
        {
            System.out.println("Press 1 to add Student");
            System.out.println("Press 2 to Update details");
            System.out.println("Press 3 search a Student");
            System.out.println("Press 4 to delete a Student");
            System.out.println("Press 5 to show stored data");
            choice = new Scanner(System.in).nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Student name and enrollment no");
                    String name = new Scanner(System.in).nextLine();
                    int price = new Scanner(System.in).nextInt();
                    Student t =new Student(price,  name);
                    Student.add(t);
                    break;
                case 2:
                    Student.Update();
                    break;
                case 3:
                    Student.find();
                    break;
                case 4:
                    Student.delete();
                    break;
                case 5:
                    Student.display();
                    break;
                default:
                    choice = 7;
                    break;
            }
        }
    }
}
