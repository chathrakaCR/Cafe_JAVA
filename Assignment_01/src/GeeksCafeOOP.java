import java.util.Scanner;

public class GeeksCafeOOP {
    private static final Scanner scanner = new Scanner(System.in);

    // Product Prices
    private static Muffin muffin = new Muffin(2.00, 25);
    private static Shake shake = new Shake(3.00);
    private static Coffee coffee = new Coffee(2.50);

    public static void main(String[] args) {
        while (true) {
            // Main Menu
            System.out.println("\n===============================================================\n" +
                    "The Geek Cafe\n" +
                    "===============================================================\n");
            System.out.println("a) Order");
            System.out.println("b) Bake muffins");
            System.out.println("c) Show sales report");
            System.out.println("d) Update prices");
            System.out.println("e) Exit");
            System.out.print("Select option: ");

            String option = scanner.nextLine().trim().toLowerCase();

            switch (option) {
                case "a": orderItems(); break;
                case "b": bakeMuffins(); break;
                case "c": showSalesReport(); break;
                case "d": updatePrices(); break;
                case "e": System.out.println("Exiting System!"); return;
                default: System.out.println("Invalid option! Try Again!");
            }
        }
    }

    // Method to Order food items
    private static void orderItems() {
        double totCost = 0.0;
        int iteration = 0;

        while (true) {
            iteration++;
            System.out.println("\n----------Order Menu----------");
            System.out.println("1. Muffin ($" + muffin.getPrice() + ")");
            System.out.println("2. Shake ($" + shake.getPrice() + ")");
            System.out.println("3. Coffee ($" + coffee.getPrice() + ")");
            System.out.println("4. Combo (Coffee + Muffin) ($" + (muffin.getPrice() + coffee.getPrice() - 1) + ")");
            System.out.println("5. Combo (Shake + Muffin) ($" + (muffin.getPrice() + shake.getPrice() - 1) + ")");
            if (iteration > 1) System.out.println("6. No more");

            System.out.print("Please Select: ");
            int choice = Integer.parseInt(scanner.nextLine().trim());

            if (iteration > 1 && choice == 6) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity: ");
                    int mQty = Integer.parseInt(scanner.nextLine().trim());
                    if (!muffin.order(mQty)) {
                        System.out.println("Only " + muffin.getStock() + " Muffins left.");
                    } else {
                        totCost += mQty * muffin.getPrice();
                    }
                    break;

                case 2:
                    System.out.print("Enter quantity: ");
                    int sQty = Integer.parseInt(scanner.nextLine().trim());
                    totCost += sQty * shake.getPrice();
                    break;

                case 3:
                    System.out.print("Enter quantity: ");
                    int cQty = Integer.parseInt(scanner.nextLine().trim());
                    totCost += cQty * coffee.getPrice();
                    break;

                case 4:
                    Combo combo1 = new Combo(coffee, muffin);
                    System.out.print("Enter quantity: ");
                    int combo1Qty = Integer.parseInt(scanner.nextLine().trim());
                    for (int i = 0; i < combo1Qty; i++) {
                        if (combo1.order()) {
                            totCost += combo1.getComboPrice();
                        } else {
                            System.out.println("Not enough stock for Combo (Coffee + Muffin).");
                            break;
                        }
                    }
                    break;

                case 5:
                    Combo combo2 = new Combo(shake, muffin);
                    System.out.print("Enter quantity: ");
                    int combo2Qty = Integer.parseInt(scanner.nextLine().trim());
                    for (int i = 0; i < combo2Qty; i++) {
                        if (combo2.order()) {
                            totCost += combo2.getComboPrice();
                        } else {
                            System.out.println("Not enough stock for Combo (Shake + Muffin).");
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        // Payment Gateway
        while (true) {
            System.out.print("Please Enter Money for Payment: ");
            double payment = Double.parseDouble(scanner.nextLine().trim());

            if (totCost > payment) {
                System.out.println("Insufficient payment. Try again.");
            } else {
                double change = payment - totCost;
                System.out.printf("Change Returned: $%.2f ", change);
                break;
            }
        }
    }

    // Method to Bake Muffins
    private static void bakeMuffins() {
        muffin.addStock(25);
        System.out.println("Ok, 25 Muffins added. Total muffins in café is now " + muffin.getStock());
    }

    // Method to Show Sales Report
    private static void showSalesReport() {
        System.out.println("\nTotal Sales:");
        System.out.printf("Muffin: %d $%.2f\n", muffin.getTotSold(), muffin.getTotSales());
        System.out.printf("Shake: %d $%.2f\n", shake.getTotSold(), shake.getTotSales());
        System.out.printf("Coffee: %d $%.2f\n", coffee.getTotSold(), coffee.getTotSales());
        System.out.println("--------------------------------------");
        int totalItems = muffin.getTotSold() + shake.getTotSold() + coffee.getTotSold();
        double totalValue = muffin.getTotSales() + shake.getTotSales() + coffee.getTotSales();
        System.out.printf("%d $%.2f\n", totalItems, totalValue);
    }

    // Method to Update Prices
    private static void updatePrices() {
        System.out.println("\n--- Update Prices ---");
        System.out.print("Enter new muffin price: ");
        muffin.setPrice(Double.parseDouble(scanner.nextLine().trim()));

        System.out.print("Enter new shake price: ");
        shake.setPrice(Double.parseDouble(scanner.nextLine().trim()));

        System.out.print("Enter new coffee price: ");
        coffee.setPrice(Double.parseDouble(scanner.nextLine().trim()));

        System.out.println("Prices updated successfully!");
    }
}
