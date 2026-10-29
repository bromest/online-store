package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class OnlineStore {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        homeScreen();
    }

    public static void homeScreen() {

        int choice;

        do {
            System.out.println(
                    """
                            === ONLINE STORE ===
                            1. Display Products
                            2. Display Cart
                            3. Exit
                            Choose an option:
                            """);

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;

                case 2:
                    displayCart();

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    public static void displayProducts() {

        try {
            Scanner fileScanner = new Scanner(new FileReader("products.csv"));

            // Skip header line
            fileScanner.nextLine();

            System.out.println("\n=== PRODUCTS ===");

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] productData = line.split("\\|");

                String sku = productData[0];
                String productName = productData[1];
                double price = Double.parseDouble(productData[2]);
                String department = productData[3];

                System.out.printf(
                        "SKU: %s | Product: %s | Price: $%.2f | Department: %s%n",
                        sku, productName, price, department
                );
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error reading products file.");
        }
    }
    public static void displayCart() {

        int choice;

        do {
            System.out.println("\n=== SHOPPING CART ===");

            double total = 0;

            if (cart.isEmpty()) {
                System.out.println("Your cart is empty.");
            } else {

                for (int i = 0; i < cart.size(); i++) {

                    Product product = cart.get(i);

                    System.out.println((i + 1) + ". "
                            + product.getProductName()
                            + " - $" + product.getPrice());

                    total += product.getPrice();
                }

                System.out.printf("\nCart Total: $%.2f%n", total);
            }

            System.out.println(
            """
            1. Check Out");
            2. Remove Product");
            3. Go Back");
            Choose an option:
            """);

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Checkout feature coming soon!");
                    break;

                case 2:
                    removeProduct();
                    break;

                case 3:
                    System.out.println("Returning to Home Screen...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }
    public static void removeProduct() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.print("Enter the item number to remove: ");
        int itemNumber = input.nextInt();

        if (itemNumber >= 1 && itemNumber <= cart.size()) {

            Product removedProduct = cart.remove(itemNumber - 1);

            System.out.println(removedProduct.getProductName()
                    + " removed from cart.");

        } else {
            System.out.println("Invalid item number.");
        }
    }
}
