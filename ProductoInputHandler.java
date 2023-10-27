import java.util.Scanner;
public class ProductoInputHandler {

    public static Producto obtenerDatosProducto() {

        System.out.print("Por favor ingrese el nombre del producto: ");
        String nombre = ControlProduct.setNameOfProduct("nombre del producto");

        System.out.print("Por favor ingrese el ID del producto: ");
        String id = ControlProduct.id();

        System.out.println("Por favor ingrese la categoria del producto: ");
        Enum categoria = ControlProduct.categoria();

        System.out.print("Por favor ingrese el precio del producto: ");
        int precio = ControlProduct.price();

        System.out.print("Por favor ingrese la cantidad de productos: ");
        int cantidad = ControlProduct.noNullStockOfProductsInput();

        return new Producto(id, nombre,(Categorias) categoria, precio, cantidad);
    }
}
