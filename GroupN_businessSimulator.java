public class GroupN_businessSimulator {

    public static void main(String[] args) {
        // Store names and prices
        String[] items = {"Airtime", "Data Bundle", "MoMo Withdrawal", "SIM Card"};
        double[] prices = {5000.0, 10000.0, 1000.0, 2000.0};

        // Set quantities
        int[] quantities = {4, 2, 9, 3};

        // Display price list
        System.out.println("ZIPPY KIOSK");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - UGX " + prices[i]);
        }
        System.out.println();

        // Generate Reciept
        printReceipt(items, prices, quantities);
    }
        //Method 2: Prints itemized receipt and calculates grand total
    public static void printReceipt(String[] items, double[] prices, int[] quantities) {
        System.out.println("RECEIPT");
        double grandTotal = 0.0;

        for (int i = 0; i < items.length; i++) {
            double itemSubtotal = calculateItemSubtotal(i, prices[i], quantities[i]);
            grandTotal += itemSubtotal;

            // Check if a discount was actually applie
            String note = getDiscountStatus(i, quantities[i]);

            System.out.println(items[i] + " x " + quantities[i] + " = UGX " + itemSubtotal + " : " + note);
        }

        System.out.println("----------------------------------------");
        System.out.println("TOTAL = UGX " + grandTotal);
    }
    // Method 1: Calculates discounted subtotal for one item
    public static double calculateItemSubtotal(int itemIndex, double price, int qty) {
        double total = price * qty;

        // Apply discount rules based on item index
        if (itemIndex == 0 && qty >= 5) {
            total = total * 0.95; // 5% off
        } else if (itemIndex == 2 && qty >= 10) {
            total = total - 500;  // UGX500 off
        } else if (itemIndex == 3 && qty >= 3) {
            total = total * 0.90; // 10% off
        }

        return total;
    }
     // Method for receipt messages
    public static String getDiscountStatus(int itemIndex, int qty) {
        if (itemIndex == 0) {
            return (qty >= 5) ? "(5% discount applied)" : "(no discount - fewer than 5)";
        } else if (itemIndex == 1) {
            return "(no discount)";
        } else if (itemIndex == 2) {
            return (qty >= 10) ? "(UGX 500 discount applied)" : "(no discount - fewer than 10)";
        } else if (itemIndex == 3) {
            return (qty >= 3) ? "(10% discount applied)" : "(no discount - fewer than 3)";
        }
        return "";
    }
}
}
