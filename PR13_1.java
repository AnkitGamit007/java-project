package com.example.pract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;



interface place
{
    int block_no = 12;
    void search();
}

class Product implements place{
        String name;
        int mrp;
        static int counter = 0;
        int quantity;
        static Collection<Product> avail = new ArrayList<>();

        Product()
        {
            System.out.println("Welcome to the super market");
            avail = new ArrayList<>();
            counter++;
        }

        Product(int mrp, int quantity, String name)
        {
            setData(mrp, quantity, name);
        }

         void setData(int mrp, int quantity, String name)
        {
            this.name = name;
            this.mrp = mrp;
            this.quantity = quantity;
        }

        static void display()
        {
            for(Product i : avail){
                System.out.println("Produce Name :" + i.name + " Product Quantity :" + i.quantity + " Product Price "+ i.mrp);
            }
        }

        static void add(Product t)
        {
            avail.add(t);
        }

        static void delete(){
            System.out.println("Enter Product you want to search");
            String name = new Scanner(System.in).nextLine();
            for(Product i : avail) {
                if (i.name.equals(name)) {
                    avail.remove(i);
                    System.out.println("Item Removed from system.");
                }
            }
        }

        static void buy(){
            System.out.println("Enter Item you want to purchase");
            String name = new Scanner(System.in).nextLine();
            for(Product i : avail)
            {
                if(i.name.equals(name))
                {
                    System.out.println("Item Bougth");
                }
                else
                    System.out.println("No such item found");
            }
        }

        static void find()
        {
            System.out.println("Enter Product you want to search");
            String name = new Scanner(System.in).nextLine();
            for(Product i : avail)
            {
                if(i.name.equals(name)) {
                    System.out.println("Item Found");
                    return;
                }
            }
            System.out.println("Item not Found");
        }
        public void search() {
            System.out.println("Searching");
    }
}
    public class PR13_1 {
        public static void main(String[] args) {
            int choice = 0;
            while(choice < 6)
            {
                System.out.println("Press 1 to add product and set its quantity and mrp");
                System.out.println("Press 2 to buy a product");
                System.out.println("Press 3 search a product");
                System.out.println("Press 4 to delete a product");
                System.out.println("Press 5 to show stored data");
             choice = new Scanner(System.in).nextInt();
             switch (choice)
             {
                 case 1:
                     System.out.println("Enter Product name, Quantity and Price");
                     String name = new Scanner(System.in).nextLine();
                     int qty = new Scanner(System.in).nextInt();
                     int price = new Scanner(System.in).nextInt();
                     Product t =new Product(price, qty, name);
                     Product.add(t);
                     break;
                 case 2:
                     Product.buy();
                     break;
                 case 3:
                     Product.find();
                     break;
                 case 4:
                     Product.delete();
                     break;
                 case 5:
                     Product.display();
                     break;
                 default:
                     choice = 7;
                     break;
                 }
            }
        }
    }
