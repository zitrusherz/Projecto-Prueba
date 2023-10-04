import java.util.Scanner;
import java.util.ArrayList;
public class Menu {
    Control controlador = new Control();
    final Catalogo catalogoNull = new Catalogo();
    Catalogo catalogoDelMenu = controlador.controlNoNullListOfProducts(catalogoNull.getCatalogo());
    ProductoInputHandler productoInputHandler = new ProductoInputHandler();
    Scanner sc = new Scanner(System.in);
    ClienteInputHandler clienteInputHandler = new ClienteInputHandler();
    public Pedido menuCliente(){
        ArrayList<Producto> pedidoCliente = new ArrayList<>();
        Cliente nuevoCliente = clienteInputHandler.obtenerDatosCliente();
        System.out.println("Bienvenido " + nuevoCliente.toString() + " a We are");
        Catalogo.getListaProductos();
        System.out.println("Por favor ingrese el numero correspondiente de los productos que desea comprar, para terminar ingrese 0");
        int terminar_elecc_products = -1;
        int numeroProducto = controlador.controlNumOfProducts(catalogoDelMenu.size());
        while (terminar_elecc_products != 0) {

            System.out.print("Por favor ingrese la cantidad de productos que desea comprar: ");
            int cantidadProductoInput = controlador.controlStockOfProductsInput();

            controlador.controlStockOfProducts(cantidadProductoInput, numeroProducto - 1, catalogoDelMenu);
            catalogoDelMenu.setCantidadProductoNueva(numeroProducto - 1, cantidadProductoInput, catalogoDelMenu.getCatalogo());
            System.out.println("Si desea terminar de elegir productos ingrese 0, si desea seguir eligiendo productos ingrese 1");
            terminar_elecc_products = controlador.controlInt("la eleccion");
            terminar_elecc_products = controlador.controlGeneralChoices(terminar_elecc_products, 0, 1);
            if(terminar_elecc_products == 1){Catalogo.getListaProductos();}
            System.out.println();

        }
        System.out.println("Gracias por comprar en We are, su compra ha sido realizada con exito");
    }

    public Catalogo colaboradorMenu(){

        System.out.println("Por favor ingrese los datos del producto que desea agregar al catalogo:");
        Producto nuevoProducto = productoInputHandler.obtenerDatosProducto();
        Catalogo catalogo = new Catalogo(nuevoProducto);
        System.out.println("El producto ha sido agregado al catalogo" +
                            "\nSi desea agregar otro producto ingrese 1, si desea salir del programa ingrese 0");
        int eleccion = controlador.controlInt("la eleccion");
        eleccion = controlador.controlGeneralChoices(eleccion, 0, 1);
        if(eleccion == 1) {
            colaboradorMenu();
        }
        return catalogo;
    }
    public int runMenu() {
        int exit = -1;

        if(catalogoDelMenu == null){
            System.out.println("Gracias por usar We are");
            return 0;
        }else{
            System.out.println("Bienvenido a We are");
        }

        while (exit != 0) {

            System.out.println("Bienvenido al menú de We are, por favor seleccione alguna de las siguientes alternativas\n"
                    + "Si usted es cliente ingrese 1\n"
                    + "Si usted es colaborador de We are ingrese 2\n"
                    + "Si desea salir del menú ingrese 0");

            exit = controlador.controlMenu();

            switch (exit) {

                case 1:
                    menuCliente();
                    break;
            //-------------------------------------------------------------------------------------------------------------------------------------------------
                case 2:
                    colaboradorMenu();
                    break;
            }
        }return 0;
    }
    public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            Control controlador = new Control();
            Menu menuRuning = new Menu();
            menuRuning.runMenu();

            sc.close();
        }

    }



