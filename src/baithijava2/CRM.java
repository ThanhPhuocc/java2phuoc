package baithijava2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CRM {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, Customer> customers = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    displayAll();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter customer email: ");
        String email = sc.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(name, email, phone);
        customers.put(name, customer);

        System.out.println("Customer added successfully.");
    }

    private static void findByName() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        Customer customer = customers.get(name);
        if (customer == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        }
    }

    private static void displayAll() {
        System.out.println("All customers:");
        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            System.out.println("Name: " + entry.getKey());
            System.out.println("Email: " + entry.getValue().getEmail());
            System.out.println("Phone: " + entry.getValue().getPhone());
            System.out.println();
        }
    }
}