import java.util.HashSet;
import java.util.Random;

public class OrderData {
    private static HashSet<String> usedOrderIds = new HashSet<>();

     static String generateOrderId() {

        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'A');
        int randomNumber = random.nextInt(1000);

        String newOrderId = randomChar + String.valueOf(randomNumber);
        if (usedOrderIds.isEmpty()) {
            usedOrderIds.add(newOrderId);
            return newOrderId;
        } while (usedOrderIds.contains(newOrderId)) {
            randomChar = (char) (random.nextInt(26) + 'A');
            randomNumber = random.nextInt(1000);
            newOrderId = randomChar + String.valueOf(randomNumber);
        }
        usedOrderIds.add(newOrderId);
        return newOrderId;
    }

}
