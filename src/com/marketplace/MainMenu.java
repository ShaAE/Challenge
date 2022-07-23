package com.marketplace;

import java.util.ArrayList;
import java.util.HashMap;

public class MainMenu {
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Product> products = new ArrayList<>();
    private final HashMap<Integer, ArrayList<Product>> purchases = new HashMap<>();
    MainMenu(){
        autoFill();
    }
    private void autoFill() {
        users.add(new User("Anton", "Antonov", 50_000));
        users.add(new User("Antonio", "Brown", 500_000));
        users.add(new User("Albert", "Einstein", 700_000));

        purchases.put(users.get(0).getId(), new ArrayList<>());
        purchases.put(users.get(1).getId(), new ArrayList<>());
        purchases.put(users.get(2).getId(), new ArrayList<>());

        products.add(new Product("Laptop", 3000));
        products.add(new Product("Smartphone", 2000));
        products.add(new Product("Computer", 1_000_000));
    }

    public void displayListOfAllUsers(){
        System.out.println("List of all users: ");
        for(User user : users){
            System.out.println("\t" + user);
        }
    }

    public void displayListOfAllProducts(){
        System.out.println("List of all products: ");
        for(Product product : products){
            System.out.println("\t" + product);
        }
    }

    public void makePurchase(int userId, int productId) {
        Product product = getProductById(productId);
        try{
            getUserById(userId).withdrawals(product.getPrice());
            purchases.get(userId).add(product);
            System.out.println("The deal went though! User with Id" + userId + " has bought the product with Id" + productId +"!");
        } catch (NotEnoughMoneyException e){
            System.out.println(e);
        }
    }

    public User getUserById(int id) {
        for (User user : users) {
            if(user.getId() == id) return user;
        }
        return null;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if(product.getId() == id) return product;
        }

        return null;
    }

    public ArrayList<Product> getPurchasesByUserId(int userId) {
        ArrayList<Product> result = this.purchases.get(userId);
        return result;
    }

    public ArrayList<User> getPurchasesByProductId(int productId) {
        ArrayList<User> result = new ArrayList<>();
        for(int i = 0; i < purchases.size(); i++) {
             if(purchases.get(i).contains(getProductById(productId))) {
                 result.add(getUserById(i));
             }
        }
        return result;
    }

    public void addNewUser(String firstName, String lastName, double amountOfMoney) {
        User user = new User(firstName, lastName, amountOfMoney);
        users.add(user);
        purchases.put(user.getId(), new ArrayList<>());
        System.out.println("New user was added");
    }

    public void addNewProduct(String name, double price) {
        products.add(new Product(name, price));
        System.out.println("New product was added");
    }

    public void deleteUser(int userId) {
        User user = getUserById(userId);
        users.remove(user);
//        purchases.remove(userId);

        System.out.println(user + " was deleted!");
    }

    public void deleteProduct(int productId) {
        Product product = getProductById(productId);
        products.remove(product);
        for(int i = 0; i < purchases.size(); i++) {
            if(purchases.get(i).contains(product)) {
                purchases.get(i).remove(product);
            }
        }
        System.out.println(product + " was deleted!");
    }
}