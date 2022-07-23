package com.marketplace;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        String flag = "y";

        finish: while(flag.equals("y")){
            System.out.println("Please make your choice" +
                    "\t\n1 - Display lis of all users;" +
                    "\t\n2 - Display list of all products;" +
                    "\t\n3 - Make deal;" +
                    "\t\n4 - Display list of user products by user id;" +
                    "\t\n5 - Display list of users that bought by product id;" +
                    "\t\n6 - Add new user;" +
                    "\t\n7 - Add new product;" +
                    "\t\n8 - Delete user;" +
                    "\t\n9 - Delete product;" +
                    "\t\n0 - Exit;"
            );
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1: menu.displayListOfAllUsers(); break;
                case 2: menu.displayListOfAllProducts(); break;
                case 3:
                    System.out.println("Enter user Id");
                    int userId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter product Id");
                    int productId = Integer.parseInt(scanner.nextLine());
                    menu.makePurchase(userId, productId); break;
                case 4:
                    System.out.println("Enter user Id");
                    int uId = Integer.parseInt(scanner.nextLine());
                    ArrayList<Product> products = menu.getPurchasesByUserId(uId);
                    for (Product product : products){
                        System.out.println(product);
                    }break;
                case 5:
                    System.out.println("Enter product Id");
                    int pId = Integer.parseInt(scanner.nextLine());
                    ArrayList<User> users = menu.getPurchasesByProductId(pId);
                    for (User user : users){
                        System.out.println(user);
                    }break;
                case 6:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter amount of money: ");
                    double amountOfMoney = Double.parseDouble(scanner.nextLine());
                    menu.addNewUser(firstName, lastName, amountOfMoney); break;
                case 7:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    menu.addNewProduct(name, price); break;
                case 8:
                    System.out.print("Enter user id to delete: ");
                    int uIdToDelete = Integer.parseInt(scanner.nextLine());
                    menu.deleteUser(uIdToDelete); break;
                case 9:
                    System.out.print("Enter product id to delete: ");
                    int pIdToDelete = Integer.parseInt(scanner.nextLine());
                    menu.deleteProduct(pIdToDelete); break;
                default: break finish;
            }
            System.out.println("Do you want to continue? y/n");
//            scanner.nextLine();
            flag = scanner.nextLine();
        }
        System.out.println("You have exited!");
        scanner.close();
//        menu.makePurchase(0,0);
//        menu.makePurchase(0,1);
//        menu.makePurchase(0,2);

//        menu.displayListOfAllProducts();
//        menu.displayListOfAllUsers();
//        ArrayList<Product> purchases = menu.getPurchasesByUserId(0);
//        for (Product product : purchases){
//            System.out.println(product);
//        }
////        System.out.println(menu.getProductById(0));
    }
}
