import java.util.ArrayList;

public class Catalogo{
    private static ArrayList<Producto> catalogo = new ArrayList<>();

    public Catalogo(){
        catalogo = getCatalogo();
    }
    public static boolean isEmpty(){
        return catalogo.isEmpty();
    }
    public static void categoryList(){
        System.out.println("Las categorias disponibles son: ");
        for(Categorias categoria: Categorias.values()){
            if(categoria == Categorias.NULL){
                continue;
            }
            System.out.println(categoria.ordinal() + 1 + ". " + categoria);
        }
    }
    public static int size(){
        return catalogo.size();
    }
    public static void addProduct(Producto producto){
        catalogo.add(producto);
    }
    public static Producto getProduct(int numProducto){
        return catalogo.get(numProducto);
    }
    public static String getCategoriaProducto(int numProducto){


        return catalogo.get(numProducto).getCategoria().name();
    }
    public static ArrayList getCatalogo(){
        return catalogo;
    }

    public static void getListaProductos(){
        System.out.println("El catalogo de productos es el siguiente: ");
        int count = 0;
        for(int o = 0; o < catalogo.size(); o++){
            count++;
            System.out.println("Producto N° " +  count + ": ");
            System.out.println(catalogo.get(o));
            System.out.print(";");
            System.out.println("----------------------------------");
        }
    }

    public static int getCantidadProducto(int numProducto){
        return catalogo.get(numProducto).getCantidad();
    }

    public static void setCantidadProductoNueva(int numProducto, int cantidadComprada){
        catalogo.get(numProducto).setCantidad(getCantidadProducto(numProducto) - cantidadComprada);
    }

    public static String getNombreProducto(int numProducto){
        return catalogo.get(numProducto).getNombre();
    }
    public static int getPrecioProducto(int numProducto){
        return catalogo.get(numProducto).getPrecio();
    }
}

