package com.mycompany.finalfuneral;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class FinalFuneral {

    private static ArrayList<String> history = new ArrayList<>();
    private static ArrayList<String> products = new ArrayList<>();
    private static ArrayList<Double> productPrices = new ArrayList<>();
    private static ArrayList<String> services = new ArrayList<>();
    private static ArrayList<Double> servicePrices = new ArrayList<>();
    private static ArrayList<String> pending = new ArrayList<>();
    private static ArrayList<String> pendingH = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    // MAIN METHOD =================================================
    public static void main(String[] args) {
        services.add("Cremation Service");
        servicePrices.add(1000.0);
        services.add("Funeral Service");
        servicePrices.add(1000.0);

        products.add("Modern Casket");
        productPrices.add(300.0);
        products.add("Flowers");
        productPrices.add(50.0);
        products.add("Candle");
        productPrices.add(20.0);

        System.out.println("===== Welcome to the Eternal Care: Funeral Home =====");
        System.out.println("\n\"Together in remembrance, forever in peace.\"\n\nWe provide personalized funeral arrangements, \nincluding caskets and products, with care and compassion.");
        System.out.print("\nPress (ENTER) if you're ready to proceed. ");
        String proceed = scan.nextLine();
        Submain();
    }

    // Sub method - main menu ======================================
    private static void Submain() {
        String service;
        int choice;

        System.out.println("\n================== WELCOME TO THE MAIN MENU ==================\n");
        System.out.println("Please choose an option by entering the corresponding number\n");
        System.out.println("1. Customer - Explore and avail of our offerings.");
        System.out.println("2. Employee - Approve forms and Inventory (Passcode required).");
        System.out.println("3. Admin - Manage Products, Inventory, and Approve forms (Passcode required).");
        System.out.println("4. Exit System - Close the system.\n");

        while (true) {
            System.out.print("Enter your choice: ");
            service = scan.next();
            try {
                choice = Integer.parseInt(service);
                if (choice >= 1 && choice <= 4) {
                    break;
                }
                System.out.println("Invalid Input.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        switch (choice) {
            case 1:
                Customer();
                break;
            case 2:
                Employee();
                break;
            case 3:
                Admin();
                break;
            case 4:
                System.out.println("");
                String g = scan.nextLine();
                while (true) {
                    System.out.print("Proceed to checkout? (yes/no): ");
                    String proceed = scan.nextLine();
                    if (proceed.equalsIgnoreCase("no")) {
                        Submain();
                    } else if (proceed.equalsIgnoreCase("yes")) {
                        System.out.println("Exiting system. Goodbye!");
                        System.exit(0);
                    }
                }
            default:
                System.out.println("Invalid! Try again.");
                break;
        }
    }

    // Customer Method =============================================
    private static void Customer() {
        double totalCost = 0;
        String selectedService = "No service selected";

        System.out.println("==============================================================");
        System.out.println("\nThese are the available Services.\n");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i) + " - $" + servicePrices.get(i));
        }
        System.out.println("0. To Skip Service selection\n");

        int serviceChoice = -1;
        while (true) {
            System.out.print("Enter the number of your preferred Service: ");
            try {
                serviceChoice = scan.nextInt();
                scan.nextLine();
                if (serviceChoice >= 0 && serviceChoice <= services.size()) {
                    break;
                }
                System.out.println("Invalid Input.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        if (serviceChoice > 0 && serviceChoice <= services.size()) {
            selectedService = services.get(serviceChoice - 1) + " ($" + servicePrices.get(serviceChoice - 1) + ")";
            totalCost += servicePrices.get(serviceChoice - 1);
        } else if (serviceChoice == 0) {
            System.out.println("Skipping Service selection.");
        }

        ArrayList<String> selectedProducts = new ArrayList<>();
        System.out.println("==============================================================");
        System.out.println("\nThese are the available Products.");
        System.out.println("= Note: Casket is measure base on the deceased. =\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i) + " - $" + productPrices.get(i));
        }
        System.out.println("");

        int productChoice = -1;
        while (true) {
            while (true) {
                System.out.print("Choose the number of preferred Product. Enter (0) to stop choosing: ");
                try {
                    productChoice = scan.nextInt();
                    scan.nextLine();
                    if (productChoice >= 0 && productChoice <= products.size()) {
                        break;
                    }
                    System.out.println("Invalid Input.");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input.");
                    scan.nextLine();
                }
            }

            if (productChoice == 0) break;

            if (productChoice > 0 && productChoice <= products.size()) {
                String product = products.get(productChoice - 1);
                double price = productPrices.get(productChoice - 1);
                selectedProducts.add(product + " ($" + price + ")");
                totalCost += price;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        if (selectedService.equals("No service selected") && selectedProducts.isEmpty()) {
            System.out.println("No items selected. Returning to menu.");
            Submain();
        }

        System.out.println("==============================================================");
        System.out.println("\nSelected items:\n");
        System.out.println("Service : " + selectedService);
        System.out.println("Products : " + String.join(", ", selectedProducts));
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("");

        boolean repeat = false;
        while (!repeat) {
            System.out.print("Proceed to put your Info? (yes/no):");
            String proceed = scan.nextLine();
            if (proceed.equalsIgnoreCase("yes")) {
                repeat = true;
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("==============================================================");
                Submain();
            }
        }

        System.out.println("==============================================================");
        System.out.println("\n--- Customer Information ---\n");
        System.out.println("Enter your personal information below.");
        System.out.println("Note: Just press (Enter) to leave it blank (only for optional).");
        System.out.print("\nEnter your name: ");
        String customerName = scan.nextLine();

        while (!customerName.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
            System.out.print("Invalid input. \nEnter your name again: ");
            customerName = scan.nextLine();
        }

        System.out.print("Enter your contact number: (+63)");
        String contactNumber = scan.nextLine();
        while (!contactNumber.matches("\\d{10}")) {
            System.out.print("Invalid input. \nEnter contact number again : (+63)");
            contactNumber = scan.next();
            scan.nextLine();
        }

        System.out.print("Enter the name of the deceased(Optional): ");
        String deceased = scan.nextLine();
        System.out.print("Enter your relationship to the deceased(Optional): ");
        String relationship = scan.nextLine();

        String formDetails = String.format(
            "\nCustomer : %s\nContact : (+63)%s\nDeceased : %s\nRelationship: %s\nService : %s\nProducts : %s\nTotal Cost : $%.2f\n",
            customerName, contactNumber, deceased, relationship,
            selectedService, String.join(", ", selectedProducts), totalCost
        );

        System.out.println("\n-- Customer's Info --");
        System.out.println(formDetails);

        while (true) {
            System.out.print("Proceed to checkout? (yes/no):\n");
            String proceed = scan.nextLine();
            if (proceed.equalsIgnoreCase("yes")) {
                System.out.println("\nYour request has been submitted. We will contact you soon.");
                System.out.println("Note: 2 days without respond, your request is denied and must try again.");
                System.out.println("==============================================================");
                pending.add(formDetails);
                Submain();
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("\nRequest not submitted. Returning to menu.");
                System.out.println("\n==============================================================");
                Submain();
            }
        }
    }

    // Employee Method =============================================
    private static void Employee() {
        System.out.println("==============================================================");
        System.out.println("\nEmployee's Menu. ");
        String passwords = scan.nextLine();
        System.out.print("Enter Employee's password: ");
        String password = scan.nextLine();

        if (password.equals("employee123")) {
            System.out.println("\nAccess granted.");
            while (true) {
                String service;
                int choice = 0;

                System.out.println("==============================================================");
                System.out.println("\n=============== WELCOME TO THE EMPLOYEE'S MENU ===============\n");
                System.out.println("1. Update Offers - Update service and product's name or price.");
                System.out.println("2. Approve Forms - Option to view request.");
                System.out.println("3. View Approved Forms - Option to view already approved forms.");
                System.out.println("4. Check Inventory - To view Services, Inventory, and Products.");
                System.out.println("5. Exit Employee's Menu - Back to Main Menu.\n");

                while (true) {
                    System.out.print("Choose an option: ");
                    service = scan.next();
                    try {
                        choice = Integer.parseInt(service);
                        if (choice >= 1 && choice <= 5) {
                            break;
                        }
                        System.out.println("Invalid Input.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input.");
                        scan.nextLine();
                    }
                }

                switch (choice) {
                    case 1:
                        Update();
                        break;
                    case 2:
                        ApproveForm();
                        break;
                    case 3:
                        PendingHistory();
                        break;
                    case 4:
                        ViewInventory();
                        break;
                    case 5:
                        System.out.println("\nYou chose to Exit Employee's Menu. ");
                        System.out.println("\n==============================================================");
                        Submain();
                        break;
                    default:
                        System.out.println("\nInvalid option. Please Try Again. ");
                        break;
                }
            }
        } else {
            System.out.println("\nIncorrect password. Access denied.");
            System.out.println("\n==============================================================");
            Submain();
        }
    }

    // Admin Method ================================================
    private static void Admin() {
        System.out.println("==============================================================");
        System.out.println("\nAdmin's Menu. ");
        String passwords = scan.nextLine();
        System.out.print("Enter Admin password: ");
        String password = scan.nextLine();

        if (password.equals("admin123")) {
            System.out.println("\nAccess granted.");
            while (true) {
                String service;
                int choice = 0;

                System.out.println("\n==============================================================");
                System.out.println("\n================= WELCOME TO THE ADMIN'S MENU ================\n");
                System.out.println("1. Create New Offers - Create new service or product.");
                System.out.println("2. Delete Offers - Delete service or product.");
                System.out.println("3. Update Offers - Update service and product's name or price.");
                System.out.println("4. Approve Forms - Option to view request.");
                System.out.println("5. View Approved Forms - Option to view already approved forms.");
                System.out.println("6. Check Inventory - To view Services, Inventory, and Products.");
                System.out.println("7. Exit Admin's Menu - Back to Main Menu.");

                while (true) {
                    System.out.print("\nChoose an option: ");
                    service = scan.next();
                    try {
                        choice = Integer.parseInt(service);
                        if (choice >= 1 && choice <= 7) {
                            break;
                        }
                        System.out.println("Invalid Input.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input.");
                        scan.nextLine();
                    }
                }

                switch (choice) {
                    case 1:
                        Create();
                        break;
                    case 2:
                        Delete();
                        break;
                    case 3:
                        Update();
                        break;
                    case 4:
                        ApproveForm();
                        break;
                    case 5:
                        PendingHistory();
                        break;
                    case 6:
                        ViewInventory();
                        break;
                    case 7:
                        System.out.println("\nYou chose to Exit Admin's Menu.");
                        System.out.println("\n==============================================================");
                        Submain();
                        break;
                    default:
                        System.out.println("\nInvalid option. Try again.");
                }
            }
        } else {
            System.out.println("\nIncorrect password. Access denied.");
            System.out.println("\n==============================================================");
            Submain();
        }
    }

    // Create Method ===============================================
    private static void Create() {
        String service;
        int choice;

        System.out.println("\n==============================================================");
        System.out.println("\n=============== CREATING NEW SERVICE AND PRODUCT =============\n");
        System.out.println("1. Create New Service -");
        System.out.println("2. Create New Product -");
        System.out.println("0. Exit Creating -");

        while (true) {
            System.out.print("\nChoose an option: ");
            service = scan.next();
            try {
                choice = Integer.parseInt(service);
                if (choice >= 0 && choice <= 2) {
                    break;
                }
                System.out.println("Invalid Input.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        switch (choice) {
            case 1:
                CreateService();
                break;
            case 2:
                CreateProduct();
                break;
            case 0:
                System.out.println("Returning...");
                return;
        }
    }

    private static void CreateProduct() {
        System.out.println("\n==============================================================\n");
        System.out.println("\nYour about to Create Product.");
        String namedekoy = scan.nextLine();
        System.out.print("Enter product name: ");
        String name = scan.nextLine();

        while (!name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
            System.out.print("Invalid input. Enter product name again: ");
            name = scan.nextLine();
        }

        System.out.print("Enter product price: ");
        double price = scan.nextDouble();

        boolean repeat = false;
        while (!repeat) {
            String proceeds = scan.nextLine();
            System.out.print("\nYou want to add this product? (yes/no):");
            String proceed = scan.nextLine();
            if (proceed.equalsIgnoreCase("yes")) {
                products.add(name);
                productPrices.add(price);
                System.out.println("\nSuccessfully added the Product. ");
                System.out.println("==============================================================");
                return;
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("\nYou cancel adding the Product. ");
                System.out.println("==============================================================");
                return;
            }
        }
    }

    private static void CreateService() {
        System.out.println("==============================================================\n");
        System.out.println("\nYour about to Create New Service.");
        String namedekoy = scan.nextLine();
        System.out.print("Enter Service name: ");
        String name = scan.nextLine();

        while (!name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
            System.out.print("Invalid input. Enter service name again: ");
            name = scan.nextLine();
        }

        System.out.print("Enter Service price: ");
        double price = scan.nextDouble();

        boolean repeat = false;
        while (!repeat) {
            String proceeds = scan.nextLine();
            System.out.print("\nYou want to add this Service? (yes/no):");
            String proceed = scan.nextLine();
            if (proceed.equalsIgnoreCase("yes")) {
                services.add(name);
                servicePrices.add(price);
                System.out.println("\nSuccessfully added the Service. ");
                System.out.println("==============================================================");
                return;
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("\nYou cancel adding the Service. ");
                System.out.println("==============================================================");
                return;
            }
        }
    }

    // Delete Method ===============================================
    private static void Delete() {
        String service;
        int choice;

        System.out.println("==============================================================");
        System.out.println("\n=============== DELETING NEW SERVICE AND PRODUCT =============\n");
        System.out.println("1. Delete Service -");
        System.out.println("2. Delete Product -");
        System.out.println("0. Exit Deleting -\n");

        while (true) {
            System.out.print("Choose an option: ");
            service = scan.next();
            try {
                choice = Integer.parseInt(service);
                if (choice >= 0 && choice <= 2) {
                    break;
                }
                System.out.println("Invalid Input.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        switch (choice) {
            case 1:
                DeleteService();
                break;
            case 2:
                DeleteProduct();
                break;
            case 0:
                System.out.println("Returning...");
                return;
        }
    }

    private static void DeleteProduct() {
        System.out.println("==============================================================");
        System.out.println("\nAvailable products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i) + " - $" + productPrices.get(i));
        }
        System.out.println("0. Exit Delete Menu\n");

        int choice = -1;
        while (true) {
            System.out.print("Enter the number of the Product you want to delete: ");
            try {
                choice = scan.nextInt();
                scan.nextLine();
                if (choice >= 0 && choice <= products.size()) {
                    break;
                }
                System.out.println("Invalid Input.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        if (choice == 0) return;

        while (true) {
            System.out.print("You want to Delete this product? (yes/no)");
            String proceed = scan.nextLine();
            if (proceed.equalsIgnoreCase("yes")) {
                products.remove(choice - 1);
                productPrices.remove(choice - 1);
                System.out.println("\nSuccessfully deleted the Product. ");
                return;
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("\nYou cancel deleting the Product. ");
                return;
            }
        }
    }

    private static void DeleteService() {
        System.out.println("==============================================================");
        System.out.println("\nAvailable Services:");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i) + " - $" + servicePrices.get(i));
        }
        System.out.println("0. Exit Delete Menu\n");

        int choice = -1;
        while (true) {
            System.out.print("Enter the number of the Service you want to delete: ");
            try {
                choice = scan.nextInt();
                scan.nextLine();
                if (choice >= 0 && choice <= services.size()) {
                    break;
                }
                System.out.println("Invalid Input.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        if (choice == 0) return;

        while (true) {
            System.out.print("You want to Delete this Service? (yes/no)");
            String proceed = scan.nextLine();
            if (proceed.equalsIgnoreCase("yes")) {
                services.remove(choice - 1);
                servicePrices.remove(choice - 1);
                System.out.println("\nSuccessfully deleted the Service. ");
                System.out.println("==============================================================");
                return;
            } else if (proceed.equalsIgnoreCase("no")) {
                System.out.println("\nYou cancel deleting the Service. ");
                System.out.println("==============================================================");
                return;
            }
        }
    }

    // Update Method ===============================================
    private static void Update() {
        String service;
        int choice;

        System.out.println("==============================================================");
        System.out.println("\n=============== UPDATING NEW SERVICE AND PRODUCT =============\n");
        System.out.println("1. Update Service -");
        System.out.println("2. Update Product -");
        System.out.println("0. Exit Updating -\n");

        while (true) {
            System.out.print("Choose an option: ");
            service = scan.next();
            try {
                choice = Integer.parseInt(service);
                if (choice >= 0 && choice <= 2) {
                    break;
                }
                System.out.println("Invalid Input.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        switch (choice) {
            case 1:
                UpdateService();
                break;
            case 2:
                UpdateProduct();
                break;
            case 0:
                System.out.println("Returning...");
                return;
        }
    }

    private static void UpdateService() {
        if (services.isEmpty()) {
            System.out.println("==============================================================");
            System.out.println("No services available to update.");
            System.out.println("==============================================================");
            return;
        }

        System.out.println("==============================================================");
        System.out.println("\n =============== Current Services ================ \n");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i) + " - $" + servicePrices.get(i));
        }
        System.out.println("0. Exit\n");

        int index = -1;
        while (true) {
            System.out.print("Enter the number of the Service to update: ");
            try {
                index = scan.nextInt();
                scan.nextLine();
                if (index == 0) return;
                index--;
                if (index >= 0 && index < services.size()) break;
                System.out.println("Invalid Input.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        String choice;
        int option;

        System.out.println("==============================================================\n");
        System.out.println(" " + services.get(index) + " - $" + servicePrices.get(index));
        System.out.println("\n1. Update Service Name -");
        System.out.println("2. Update Service Price -");
        System.out.println("0. Exit Service Update -\n");

        while (true) {
            System.out.print("Enter your choice: ");
            choice = scan.next();
            try {
                option = Integer.parseInt(choice);
                if (option >= 0 && option <= 2) break;
                System.out.println("Invalid Input.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        switch (option) {
            case 1:
                String newNames = scan.nextLine();
                System.out.print("\nEnter the new name: ");
                String newName = scan.nextLine();
                services.set(index, newName);
                System.out.println("Service name updated successfully.");
                break;
            case 2:
                System.out.print("Enter the new price: ");
                try {
                    double newPrice = scan.nextDouble();
                    scan.nextLine();
                    servicePrices.set(index, newPrice);
                    System.out.println("Service price updated successfully.");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input.");
                    scan.nextLine();
                }
                break;
            case 0:
                System.out.println("Exiting...");
                return;
        }
    }

    private static void UpdateProduct() {
        if (products.isEmpty()) {
            System.out.println("==============================================================");
            System.out.println("No products available to update.");
            System.out.println("==============================================================");
            return;
        }

        System.out.println("==============================================================");
        System.out.println("\n =============== Current Products ================\n");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i) + " - $" + productPrices.get(i));
        }
        System.out.println("0. Exit\n");

        int index = -1;
        while (true) {
            System.out.print("Enter the number of the Product to update: ");
            try {
                index = scan.nextInt();
                scan.nextLine();
                if (index == 0) return;
                index--;
                if (index >= 0 && index < products.size()) break;
                System.out.println("Invalid Input.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                scan.nextLine();
            }
        }

        String choice;
        int option;

        System.out.println("==============================================================\n");
        System.out.println(" " + products.get(index) + " - $" + productPrices.get(index));
        System.out.println("\n1. Update Product Name -");
        System.out.println("2. Update Product Price -");
        System.out.println("0. Exit Product Update -\n");

        while (true) {
            System.out.print("Enter your choice: ");
            choice = scan.nextLine();
            try {
                option = Integer.parseInt(choice);
                if (option >= 0 && option <= 2) break;
                System.out.println("Invalid Input.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input.");
            }
        }

        switch (option) {
            case 1:
                System.out.print("\nEnter the new name: ");
                String newName = scan.nextLine();
                products.set(index, newName);
                System.out.println("Product name updated successfully.");
                break;
            case 2:
                System.out.print("\nEnter the new price: ");
                try {
                    double newPrice = scan.nextDouble();
                    scan.nextLine();
                    productPrices.set(index, newPrice);
                    System.out.println("Product price updated successfully.");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input.");
                    scan.nextLine();
                }
                break;
            case 0:
                System.out.println("Exiting...");
                return;
        }
    }

    // Approve Form Method =========================================
    private static void ApproveForm() {
        if (pending.isEmpty()) {
            System.out.println("==============================================================");
            System.out.println("");
            System.out.println("No pending forms.");
            System.out.println("");
            return;
        } else {
            while (true) {
                System.out.println("==============================================================");
                System.out.println("\nPending forms:\n");
                for (int i = 0; i < pending.size(); i++) {
                    System.out.println((i + 1) + ". " + pending.get(i));
                }

                int choice = -1;
                while (true) {
                    System.out.print("Enter form number to approve (0 to Exit): ");
                    try {
                        choice = scan.nextInt();
                        scan.nextLine();
                        if (choice >= 0 && choice <= pending.size()) break;
                        System.out.println("Invalid Input.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input.");
                        scan.nextLine();
                    }
                }

                if (choice > 0 && choice <= pending.size()) {
                    String approvedForm = pending.remove(choice - 1);
                    pendingH.add(approvedForm);
                    System.out.println("\nYou Approved Customer's Form:\n" + approvedForm);
                } else if (choice == 0) {
                    return;
                }
                return;
            }
        }
    }

    // Pending History Method ======================================
    private static void PendingHistory() {
        if (pendingH.isEmpty()) {
            System.out.println("==============================================================");
            System.out.println("\nNo Approve forms yet.\n");
        } else {
            System.out.println("==============================================================");
            System.out.println("\nApproved Forms: ");
            for (String record : pendingH) {
                System.out.println(record);
            }
            String answers = scan.nextLine();
            System.out.print("Press (ENTER) if done checking Approved Forms. ");
            String answer = scan.nextLine();
            return;
        }
    }

    // View Inventory Method =======================================
    private static void ViewInventory() {
        if (services.isEmpty()) {
            System.out.println("==============================================================");
            System.out.println("");
            System.out.println("\nService is empty.");
            System.out.println("");
            System.out.println("==============================================================");
            Submain();
        } else {
            System.out.println("==============================================================");
            System.out.println("\nCurrent Services:\n");
            for (int i = 0; i < services.size(); i++) {
                System.out.println((i + 1) + ". " + services.get(i) + " - $" + servicePrices.get(i));
            }
        }

        if (products.isEmpty()) {
            System.out.println("==============================================================");
            System.out.println("");
            System.out.println("\nInventory is empty.");
            System.out.println("");
            System.out.println("==============================================================");
        } else {
            System.out.println("\nCurrent Products:\n");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i) + " - $" + productPrices.get(i));
            }
        }

        String answers = scan.nextLine();
        System.out.print("\nPress (ENTER) if done checking the Inventory. ");
        String answer = scan.nextLine();
        return;
    }
}
