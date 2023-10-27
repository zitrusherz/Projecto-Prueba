import java.util.Scanner;

public class ControlProduct extends Control{

    private static Scanner sc = new Scanner(System.in);

    public static String setNameOfProduct(String typeOfData){
        System.out.print("Por favor ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        nombre = controlNoNull(nombre, typeOfData);//Controlamos que no sea nulo
        nombre = controlLength(nombre, "nombre del producto tiene un largo fuera del rango", 1, 25);//Controlamos su largo
        return nombre;
    }

    public static String id(){//Control de ID de producto

        String idProduct = sc.next();
        idProduct = controlNoNull(idProduct, "ID/codigo del producto");//Controlamos que no sea nulo
        idProduct = controlLength(idProduct, "ID/codigo del producto tiene un largo fuera del rango", 6, 8);//Controlamos su largo
        return idProduct;
    }
    public static int price(){//Control de precio de producto
        int precio = controlInt("el precio", 0, 999999999);
        while(precio <= 0){
            System.out.println("El precio no puede ser menor o igual a 0.\nPor favor ingreselo nuevamente: ");
            precio = controlInt("el precio", 0, 999999999);
        }
        return precio;
    }
    //Metodo de control de categoria
    public static Enum categoria(){

        Catalogo.categoryList();
        System.out.println("Por favor ingrese el numero correspondiente a la categoria del producto: ");
        int eleccion = controlGeneralChoices(1, 3);
        Enum categoria = Categorias.values()[eleccion - 1];
        return categoria;
    }
    //Metodo de control de cantidad de productos
    public static int noNullStockOfProductsInput(){
        int cantidadProducto = controlInt("la cantidad de productos", 1, 999999999);
        while (cantidadProducto <= 0){
            System.out.println("La cantidad de productos no puede ser menor o igual a 0.\nPor favor ingresela nuevamente: ");
            cantidadProducto = controlInt("la cantidad de productos", 1, 999999999);
        }
        return cantidadProducto;
    }
}
