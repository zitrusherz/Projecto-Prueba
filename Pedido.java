import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.Random;
public class Pedido {
    private int monto_desc = 0;
    private int total = 0;
    private static HashSet<String> usedId = new HashSet<>();
    private HashMap<String, String[]> pedido = new HashMap<>();
    private String id;
    private LocalDate currentTime = LocalDate.now();
    private Random random = new Random();
    private char rand_char = (char) (random.nextInt(26) + 'A');
    private int rand_num = random.nextInt(1000);
    private String cliente;
    private String descripcionProductos;

    public Pedido(HashMap productos ,Cliente cliente){
        this.id = setIdGenerator();
        this.total = setTotal(productos);
        this.currentTime = LocalDate.now();
        this.cliente = cliente.toString();
        this.descripcionProductos = descripcionProductos;

    }

    public HashMap getPedido(){

        return pedido;
    }
    private String setIdGenerator(){

        String new_id = rand_char + String.valueOf(rand_num);
        if (usedId.isEmpty()){
            usedId.add(new_id);
            return new_id;
        } else if(usedId.contains(new_id)){
            setIdGenerator();
        }
        usedId.add(new_id);
        return new_id;
    }

    public int setTotal(HashMap productos){
        int totalSum = 0;
        Collection<int[]> precios = productos.values();
        for(int[] precio: precios){
            totalSum += precio[0] * precio[1];
        }
        if(totalSum >= 30000 && totalSum <= 80000){
            totalSum *= 0.95;
            this.monto_desc = 5;
        }else if(totalSum > 80000 && totalSum <= 150000){
            totalSum *= 0.9;
            this.monto_desc = 10;
        }else if(totalSum > 150000){
            totalSum *= 0.8;
            this.monto_desc = 20;
        }

        this.total = totalSum;
        return this.total;
    }

    public void getDescuento(){

        switch (this.monto_desc){
            case 0:
                System.out.println("El pedido no cuenta con el monto suficiente para un descuento");
                break;
            case 5:
                System.out.println("El pedido tiene un 5% de descuento");
                break;
            case 10:
                System.out.println("El pedido tiene un 10% de descuento");
                break;
            case 20:
                System.out.println("El pedido tiene un 20% de descuento");
                break;
            default:
                System.out.println("Error, el descuento aplicado esta fuera del rango");
        }
    }

}
