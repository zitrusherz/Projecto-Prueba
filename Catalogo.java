import java.util.ArrayList;

public class Catalogo extends Producto{
    private static ArrayList<Producto> catalogo = new ArrayList<>();

    public Catalogo(Producto producto){
        super(producto.getId(), producto.getNombre(), producto.getCategoria(), producto.getPrecio(), producto.getCantidad());
        catalogo.add(producto);
        this.catalogo = catalogo;
    }
    public Catalogo(){
        super("0", "0", Categorias.NULL, 0, 0);
        this.catalogo = null;
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
    public int size(){
        return catalogo.size();
    }
    public void addProduct(Producto producto){
        catalogo.add(producto);
    }
    public Producto getProduct(int numProducto){
        return catalogo.get(numProducto);
    }

    public static ArrayList getCatalogo(){
        return catalogo;
    }

    public static void getListaProductos(){
        System.out.println("El catalogo de productos es el siguiente: ");
        int num_of_products = 0;
        for(int o = 0; o < catalogo.size(); o++){
            System.out.println("Producto N° " + o + 1);
            num_of_products += 1;
            System.out.println(catalogo.get(o));
            System.out.print(";");
            System.out.println("----------------------------------");
        }
    }

    public int getCantidadProducto(int numProducto, ArrayList<Producto> catalogo){

        return catalogo.get(numProducto).getCantidad();
    }

    public void setCantidadProductoNueva(int numProducto, int cantidadComprada, ArrayList<Producto> catalogo){
        catalogo.get(numProducto).setCantidad(getCantidadProducto(numProducto, catalogo) - cantidadComprada);
    }

}
