import java.util.Collection;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.Set;

public class Order {

    private String customer;
    private int discountAmount = 0, totalAmount = 0;
    private String orderId, productDescriptions;
    private HashMap<String, int[]> orderItems = new HashMap<>();
    private LocalDate currentTime = LocalDate.now();


    public Order(HashMap products, Customer customer) {
        orderId = OrderData.generateOrderId();
        this.totalAmount = calculateTotalAmount(products)[0];
        this.currentTime = LocalDate.now();
        this.customer = customer.toString();
        this.productDescriptions = generateProductDescriptions(products);
        this.discountAmount = calculateTotalAmount(products)[1];

    }

    public static int[] calculateTotalAmount(HashMap products) {
        int totalSum = 0;
        int discountAmount = 0;
        int[] priceData = new int[2];
        Collection<int[]> prices = products.values();
        for (int[] price : prices) {
            totalSum += price[0] * price[1];
        }
        if (totalSum >= 30000 && totalSum <= 80000) {
            totalSum *= 0.95;
            discountAmount = 5;
        } else if (totalSum > 80000 && totalSum <= 150000) {
            totalSum *= 0.9;
            discountAmount = 10;
        } else if (totalSum > 150000) {
            totalSum *= 0.8;
            discountAmount = 20;
        }
        priceData[0] = totalSum;
        priceData[1] = discountAmount;
        return priceData;
    }

    public void getDiscount() {
        switch (this.discountAmount) {
            case 0:
                System.out.println("The order does not qualify for a discount.");
                break;
            case 5:
                System.out.println("The order is eligible for a 5% discount.");
                break;
            case 10:
                System.out.println("The order is eligible for a 10% discount.");
                break;
            case 20:
                System.out.println("The order is eligible for a 20% discount.");
                break;
            default:
                System.out.println("Error: The applied discount is out of the valid range.");
        }
    }

    private String generateProductDescriptions(HashMap products) {
        StringBuilder descriptions = new StringBuilder();
        String[] productData = new String[2];
        Set<String[]> keys = products.keySet();
        for (String[] key : keys) {
            descriptions.append(key[0]).append("\n");
            descriptions.append(key[1]).append("\n");
        }
        return descriptions.toString();
    }

    public String toString(){
        return "Order ID: " + orderId + "\n" +
                "Customer: " + customer + "\n" +
                "Date: " + currentTime + "\n" +
                "Product descriptions: " + productDescriptions + "\n" +
                "Total amount: " + totalAmount + "\n" +
                "Discount: " + discountAmount + "%" + "\n";
    }
}
