package src.eMart;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    static IInventoryManager manager;

    public static void main(String[] args) {
        DBHelper.createTables();
        manager = new InventoryManager();

        scan = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n\n\n1.addItem\n2.removeItem\n3.generateReport\n4.exit");
            option = scan.nextInt();
            scan.nextLine();// empty space
            if (option == 1)
                addItem();
            else if (option == 2)
                removeItem();
            else if (option == 3)
                manager.generateReport();
        } while (option != 4);
        // Adding items
        // manager.addItem(new Item(0, "Apple", 50, 0.5));
        // manager.addItem(new Item(0, "Banana", 30, 0.2));
        // manager.addItem(new Item(0, "Milk", 20, 1.5));

        // Generating report

    }

    private static void removeItem() {
        System.out.println("enter the item Id :");
        int id = scan.nextInt();

        scan.nextLine();// empty line
        manager.removeItem(id);
    }

    private static void addItem() {
        System.out.println("enter the item Name :");
        String name = scan.nextLine();
        System.out.println("enter the quantity :");
        int quantity = scan.nextInt();
        System.out.println("enter the price :");
        int price = scan.nextInt();
        manager.addItem(new Item(0, name, quantity, price));
    }
}
