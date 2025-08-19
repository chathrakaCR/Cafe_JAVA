import java.util.Scanner;

public class GeeksCafe {
    // Product Prices
    private static double pMuffin = 2.00;
    private static double pShake = 3.00;
    private static double pCoffee = 2.50;

    // Inventory
    private static int sMuffin = 25;

    // Sales Tracking
    private static int totMuffinSold = 0;
    private static int totShakeSold = 0;
    private static int totCoffeeSold = 0;

    private static double totalSales = 0.00;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            // Main Menu
            System.out.println("\n===============================================================\n" +
                    "The Geek Cafe\n" +
                    "===============================================================\n");
            System.out.println("a) Order");
            System.out.println("b) Bake muffins");
            System.out.println("c) Show sales report");
            System.out.println("d) Update prices");
            System.out.println("e) Exit\n");
            System.out.print("Select option: ");
            String option = scanner.nextLine().trim().toLowerCase();

            switch (option){
                case "a":
                    orderItems();
                    break;
                case "b":
                    bakeMuffins();
                    break;
                case "c":
                    showSalesRep();
                    break;
                case "d":
                    updatePrices();
                    break;
                case "e":
                    System.out.println("Exiting System!");
                    return;
                default:
                    System.out.println("Invalid option! Try Again!");
            }

        }
    }

    // Method to Order food items
    private static void orderItems() {
        int orderMuffins = 0;
        int orderShakes = 0;
        int orderCoffees = 0;
        double totCost = 0.00;
        int iteration = 0;

        while (true) {
            iteration++;
            System.out.println("\n----------Order Menu----------");
            System.out.println("1. Muffin ($" + String.format("%.2f", pMuffin) + ")");
            System.out.println("2. Shake ($" + String.format("%.2f", pShake) + ")");
            System.out.println("3. Coffee ($" + String.format("%.2f", pCoffee) + ")");

            if (iteration > 1) {
                System.out.println("4. No more");
            }

            System.out.print("Please Select: ");
            int itemOption = Integer.parseInt(scanner.nextLine().trim());

            if (iteration > 1 && itemOption == 4) break;

            System.out.print("Enter quantity: ");
            int itemQty = Integer.parseInt(scanner.nextLine().trim());

            switch (itemOption) {
                case 1:
                    if (itemQty > sMuffin) {
                        System.out.println("Only " + sMuffin + " Muffins available. Order Again");
                        return;
                    }
                    orderMuffins += itemQty;
                    sMuffin -= orderMuffins;
                    break;

                case 2:
                    orderShakes += itemQty;
                    break;

                case 3:
                    orderCoffees += itemQty;
                    break;

                default:
                    System.out.println("Invalid Item Selection.");
                    return;
            }
        }

        totMuffinSold += orderMuffins;
        totShakeSold += orderShakes;
        totCoffeeSold += orderCoffees;

        totCost = (orderMuffins*pMuffin) + (orderShakes*pShake) + (orderCoffees*pCoffee);
        totalSales += totCost;

        System.out.printf("Total Cost of Order is: $%.2f ", totCost);

        // payment Gateway
        while (true){
            System.out.print("Please Enter Money for Payment: ");
            double payment = Double.parseDouble(scanner.nextLine().trim());

            if (totCost > payment){
                System.out.println("Insufficient payment. Try again.");
            }
            else{
                double change = payment - totCost;
                System.out.printf("Change Returned: $%.2f ", change);
                break;
            }
        }
    }

    // Method to Bake Muffins
    private static void bakeMuffins(){
        sMuffin += 25;
        System.out.println("Ok, 25 Muffins added. Total muffins in café is now " + sMuffin);
    }

    // Method to Show Sales Report
    private static void showSalesRep(){
        System.out.println("Unsold Muffins: " + sMuffin);
        System.out.println("\nTotal Sales: ");
        System.out.printf("Muffin: %d $%.2f\n", totMuffinSold, totMuffinSold * pMuffin);
        System.out.printf("Shake: %d $%.2f\n", totShakeSold, totShakeSold * pShake);
        System.out.printf("Coffee: %d $%.2f\n", totCoffeeSold, totCoffeeSold * pCoffee);
        System.out.println("--------------------------------------");
        int totalItems = totMuffinSold + totShakeSold + totCoffeeSold;
        System.out.printf("%d $%.2f\n", totalItems, totalSales);
    }

    // Method to Update Food Items prices
    private static void updatePrices(){
        System.out.println("\n--- Update Prices ---");
        System.out.print("Enter new muffin price: ");
        pMuffin = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter new shake price: ");
        pShake = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter new coffee price: ");
        pCoffee = Double.parseDouble(scanner.nextLine().trim());

        System.out.println("Prices updated successfully!");
    }
}