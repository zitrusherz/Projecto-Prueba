import java.util.Scanner;
public class ProductoInputHandler {




    public static Producto obtenerDatosProducto() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
                nombre = Control.controlNoNull(nombre,"nombre del producto");


        System.out.print("Por favor ingrese el ID del producto: ");
        String id = Control.controlId();

        System.out.println("Por favor ingrese la categoria del producto: ");
        Enum categoria = Control.controlCategoria();

        System.out.print("Por favor ingrese el precio del producto: ");
        int precio = Control.controlPrice();

        System.out.print("Por favor ingrese la cantidad de productos: ");
        int cantidad = Control.controlStockOfProductsInput();
        sc.close();
        return new Producto(id, nombre,(Categorias) categoria, precio, cantidad);
    }
}
