package com.pluralsight;

import java.util.Scanner;

public class OnlineStore {
    static Scanner input = new Scanner(System.in);

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
            """);
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Display Products Screen");
                    break;

                case 2:
                    System.out.println("Display Cart Screen");
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }
}
