import java.lang.reflect.Array;
import java.util.ArrayList;
public class Producto {
    protected String id;
    protected String nombre;
    protected Categorias categoria;
    protected int precio;
    protected int cantidad;

    public Producto (String id, String nombre, Categorias categoria, int precio, int cantidad){

        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public Categorias getCategoria(){
        return this.categoria;
    }

    public void setCategoria(Categorias categoria){
        this.categoria = categoria;
    }
    public int getPrecio(){
        return this.precio;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public String toString() {
        return "nombre: " + nombre + ' ' +
                ", categoria: " + categoria + ' ' +
                ", precio: " + precio +
                ", cantidad: " + cantidad;
    }

}
