import java.util.Random;
import java.util.ArrayList;
import java.time.LocalDate;
public class Pedido {
    private int monto_desc = 0;
    private int total = 0;
    private ArrayList<String> used_id = new ArrayList<>();
    private ArrayList<String> pedido = new ArrayList<>();
    private String id;
    private LocalDate currentTime = LocalDate.now();
    private Random random = new Random();
    private char rand_char1 = (char) (random.nextInt(26) + 'A');
    private int rand_num = random.nextInt(1000);
    private String cliente;
    private String descripcionProductos;

    public Pedido(int[] precioProductos, Cliente cliente, String descripcionProductos){
        this.id = setIdGenerator();
        this.total = setTotal(precioProductos);
        this.currentTime = LocalDate.now();
        this.cliente = cliente.toString();
        this.descripcionProductos = descripcionProductos;

        pedido.add(this.id);
        pedido.add(String.valueOf(this.total));
        pedido.add(this.currentTime.toString());
        pedido.add(this.cliente);
        pedido.add(this.descripcionProductos);
    }

    public ArrayList<String> getPedido(){

        return pedido;
    }
    private String setIdGenerator(){

        String new_id = rand_char1 + String.valueOf(rand_num);
        if (used_id.isEmpty() || !used_id.contains(new_id)){
            used_id.add(new_id);
            return new_id;
        } else if(used_id.contains(new_id)){
            setIdGenerator();
        }
        used_id.add(new_id);
        return new_id;
    }

    public int setTotal(int[] productos){
        int suma_total = 0;

        for(int producto: productos){
            suma_total += producto;
        }
        if(suma_total >= 30000 && suma_total <= 80000){
            suma_total *= 0.95;
            this.monto_desc = 5;
        }else if(suma_total > 80000 && suma_total <= 150000){
            suma_total *= 0.9;
            this.monto_desc = 10;
        }else if(suma_total > 150000){
            suma_total *= 0.8;
            this.monto_desc = 20;
        }

        this.total = suma_total;
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
