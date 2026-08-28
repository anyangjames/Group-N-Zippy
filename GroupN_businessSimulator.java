public class GroupN_businessSimulator {

    public static void main(String[] args) {
        // Store names and prices
        String[] items = {"Airtime", "Data Bundle", "MoMo Withdrawal", "SIM Card"};
        double[] prices = {5000.0, 10000.0, 1000.0, 2000.0};

        // Set quantities
        int[] quantities = {4, 2, 9, 3};

        // Display price list
        System.out.println("==== ZIPPY KIOSK ====");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - UGX " + prices[i]);
        }
        System.out.println();

        // Generate Reciept
        printReceipt(items, prices, quantities);
    }
}
