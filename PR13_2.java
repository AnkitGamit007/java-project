package com.example.pract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

interface Branch{
    int IFSC_Code = 12;
    void search();
}
class Account implements  Branch{
    int Ac_no;
    static int counter = 0;
    String Name;
    int Balance;
    static Collection<Account> list = new ArrayList<>();

    Account()
    {
        System.out.println("Welcome to the bank");
    }

    Account(int Ac_no, int Balance, String name)
    {
        counter++;
        this.Ac_no = Ac_no;
        this.Balance = Balance;
        this.Name = name;
    }


    static void add(Account t)
    {
        list.add(t);
    }

    void setData(int Ac_no, int Balance, String name)
    {
        this.Ac_no = Ac_no;
        this.Balance = Balance;
        this.Name = name;
    }

   static void display()
    {
        for(Account i : list) {
            System.out.println("Account Number is " + i.Ac_no);
            System.out.println("Name is " + i.Name);
            System.out.println("Balance is " + i.Balance);
        }
    }

    static void withdraw()
    {
        System.out.println("Enter Account number");
        int no = new Scanner(System.in).nextInt();
        for(Account i : list)
        {
            if(i.Ac_no == no)
            {
                System.out.println("Money withdrawn");
                i.Balance -= 1000;
                return;
            }
        }
        System.out.println("No Account Found");
    }

    static void find()
    {
        System.out.println("Enter Account number To find");
        int no = new Scanner(System.in).nextInt();
        for(Account i : list)
        {
            if(i.Ac_no == no)
            {
                System.out.println("Account Found");
                return;
            }
        }
        System.out.println("No Account Found");
    }

    static void delete()
    {
        System.out.println("Enter Account number To Delete");
        int no = new Scanner(System.in).nextInt();
        for(Account i : list)
        {
            if(i.Ac_no == no)
            {
                System.out.println("Account removed");
                list.remove(i);
                return;
            }
        }
        System.out.println("No Account Found");
    }
    @Override
    public void search() {
        System.out.println("Ac_no = " + Ac_no + "  Name = " + Name + " Branch = " + IFSC_Code);
    }
}


public class PR13_2 {
    public static void main(String[] args) {
        int choice = 0;
        while(choice < 6)
        {
            System.out.println("Press 1 to add Account and set its quantity and mrp");
            System.out.println("Press 2 to withdraw a Account");
            System.out.println("Press 3 search a Account");
            System.out.println("Press 4 to delete a Account");
            System.out.println("Press 5 to show stored data");
            choice = new Scanner(System.in).nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Account name, Balance and account no.");
                    String name = new Scanner(System.in).nextLine();
                    int bal = new Scanner(System.in).nextInt();
                    int ac_no = new Scanner(System.in).nextInt();
                    Account t =new Account(ac_no, bal, name);
                    Account.add(t);
                    break;
                case 2:
                    Account.withdraw();
                    break;
                case 3:
                    Account.find();
                    break;
                case 4:
                    Account.delete();
                    break;
                case 5:
                    Account.display();
                    break;
                default:
                    choice = 7;
                    break;
            }
        }
    }
}
