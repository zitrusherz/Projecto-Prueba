import java.util.Scanner;
public class ProductoInputHandler {

    private final Control controlador = new Control();
    private final Scanner sc = new Scanner(System.in);

    public Producto obtenerDatosProducto() {

        System.out.print("Por favor ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
                nombre = controlador.controlNoNull(nombre,"nombre del producto");


        System.out.print("Por favor ingrese el ID del producto: ");
        String id = controlador.controlId();

        System.out.println("Por favor ingrese la categoria del producto: ");
        Enum categoria = controlador.controlCategoria();

        System.out.print("Por favor ingrese el precio del producto: ");
        int precio = controlador.controlPrice();

        System.out.print("Por favor ingrese la cantidad de productos: ");
        int cantidad = controlador.controlStockOfProductsInput();

        return new Producto(id, nombre,(Categorias) categoria, precio, cantidad);
    }
}
