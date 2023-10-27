import java.util.ArrayList;

public class ControlMenu extends Control {


    public static int menu(){
        int eleccion = controlGeneralChoices(0, 2);
        return eleccion;
    }


    public static int stockOfProducts(int numOfProducts, Catalogo catalogo){//Control de stock de productos
        int quantityToPurchase = controlInt("la cantidad de productos a comprar", 1, catalogo.getCantidadProducto(numOfProducts));
        while(quantityToPurchase > catalogo.getCantidadProducto(numOfProducts) || quantityToPurchase == 0){
            System.out.println("La cantidad de productos a comprar es mayor a la cantidad de productos en stock\nPor favor ingrese una cantidad valida: ");
            quantityToPurchase = controlInt("la cantidad de productos a comprar", 1, catalogo.getCantidadProducto(numOfProducts));
        }
        return quantityToPurchase;
    }
}
