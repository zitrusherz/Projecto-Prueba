import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    static Catalogo catalogoDelMenu = new Catalogo();//creamos un catalogo para el menu


    public static Order menuCliente(Catalogo catalogoDelMenu, Customer nuevoCliente){
        HashMap<String[], int[]> listaDeProductos = new HashMap<>();//creamos una lista de productos, donde la key es el nombre del producto y el value es un arraylist con la cantidad y el precio

        System.out.println("Bienvenido " + nuevoCliente.getNameAndLastname() + " a We are");
        int endProductSelection = -1;
        while (endProductSelection != 0) {
            Catalogo.getListaProductos();//mostramos el catalogo de productos
            System.out.println("Por favor ingrese el numero correspondiente de los productos que desea comprar, para terminar ingrese 0");

            int posicionProducto = Control.controlGeneralChoices(1,catalogoDelMenu.size());//controlamos que la posicion del producto que ingrese el usuario sea valida dentro de nuestro arrayList
            System.out.println("Usted ha elegido el producto: " + catalogoDelMenu.getNombreProducto(posicionProducto - 1) + "\nDe la categoria: " + catalogoDelMenu.getCategoriaProducto(posicionProducto - 1) + "\n");
            System.out.print("Por favor ingrese la cantidad de productos que desea comprar: ");
            //almacenamos el nombre y la categoria del producto en el array
            String[] nombreProductoYCategoria = {catalogoDelMenu.getNombreProducto(posicionProducto - 1), catalogoDelMenu.getCategoriaProducto(posicionProducto - 1)};

            int quantityOfProductEntered = ControlMenu.stockOfProducts(posicionProducto - 1, catalogoDelMenu);//controlamos que la cantidad de productos que ingrese el usuario no sea nula
            int[] cantidadYprecio = {quantityOfProductEntered, Catalogo.getPrecioProducto(posicionProducto - 1)};//creamos un array para almacenar la cantidad y el precio del producto
            System.out.println("El precio del producto es: " + Catalogo.getPrecioProducto(posicionProducto - 1) + "\nY el subtotal es: " + cantidadYprecio[0] * cantidadYprecio[1] + "\n");
            listaDeProductos.put(nombreProductoYCategoria, cantidadYprecio);//agregamos el nombre del producto como key y el arraylist como value al hashmap
            catalogoDelMenu.setCantidadProductoNueva(posicionProducto - 1, quantityOfProductEntered);//actualizamos la cantidad de productos en stock
            System.out.println("Si desea terminar de elegir productos ingrese 0, si desea seguir eligiendo productos ingrese 1");
            endProductSelection = Control.controlGeneralChoices(0, 1);//controlamos que la eleccion del usuario sea valida
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println("Gracias por comprar en We are, su compra ha sido realizada con exito");
        return new Order(listaDeProductos, nuevoCliente);//retornamos una nueva orden con el hashmap y el cliente
    }

    public static void colaboradorMenu(){

        System.out.println("Por favor ingrese los datos del producto que desea agregar al catalogo");
        Producto newProduct = ProductoInputHandler.obtenerDatosProducto();//obtenemos los datos del producto y creamos un nuevo producto
        Catalogo.addProduct(newProduct);//agregamos el producto al catalogo
        System.out.println("El producto ha sido agregado al catalogo" +
                            "\nSi desea agregar otro producto ingrese 1, si desea salir del programa ingrese 0");
        int eleccion = Control.controlGeneralChoices(0, 1);
        while(eleccion == 1) {
            System.out.println("Por favor ingrese los datos del producto que desea agregar al catalogo:");
            newProduct = ProductoInputHandler.obtenerDatosProducto();//obtenemos los datos del producto y creamos un nuevo producto
            Catalogo.addProduct(newProduct);//agregamos el producto al catalogo
            System.out.println("El producto ha sido agregado al catalogo" +
                    "\nSi desea agregar otro producto ingrese 1, si desea salir del programa ingrese 0");
            eleccion = Control.controlGeneralChoices( 0, 1);
        }
        System.out.println("Gracias por usar We are");

    }
    public static int runMenu() {
        int exit = -1;

        if(catalogoDelMenu.isEmpty()){//si el catalogo esta vacio, le pedimos al colaborador que ingrese los datos de los productos
            System.out.println("El catalogo de productos esta vacio, por favor ingrese los datos de los productos que desea agregar al catalogo");
            colaboradorMenu();
        }else{
            System.out.println("Bienvenido a We are");
        }

        while (exit != 0) {

            System.out.println("Bienvenido al menú de We are, por favor seleccione alguna de las siguientes alternativas\n"
                    + "Si usted es cliente ingrese 1\n"
                    + "Si usted es colaborador de We are ingrese 2\n"
                    + "Si desea salir del menú ingrese 0");

            exit = ControlMenu.menu();

            switch (exit) {

                case 1:
                    Customer nuevoCliente = new Customer("Juan", "Perez", "JP@gmail.com", "51103274", "19902009", "9");//creamos un nuevo cliente ejemplo
                    //Customer nuevoCliente = CustomerInputHandler.obtenerDatosCliente();//creamos un nuevo cliente
                    Order newOrder = menuCliente(catalogoDelMenu, nuevoCliente);//creamos una nueva orden
                    System.out.println(newOrder.toString());//mostramos la orden
                    break;
            //-------------------------------------------------------------------------------------------------------------------------------------------------
                case 2:
                    colaboradorMenu();//llamamos al metodo colaboradorMenu
                    break;
            }
        }return 0;
    }
    public static void main (String[]args){
            Producto nuevoProducto = new Producto("123abc","Komi-san" , Categorias.MANGA, 9_990, 100);
            Producto nuevoProducto2 = new Producto("111aaa","Kaguya-Sama" , Categorias.FIGURA, 23_000, 50);
            Producto nuevoProducto3 = new Producto("144ccc","Nagatoro" , Categorias.FIGURA, 30_000, 70);
            Producto nuevoProducto4 = new Producto("155ddd","Dragon Ball Z" , Categorias.MANGA, 8_990, 200);
            Producto nuevoProducto5 = new Producto("166eee","Naruto" , Categorias.MANGA, 7_990, 150);
            catalogoDelMenu.addProduct(nuevoProducto);
            catalogoDelMenu.addProduct(nuevoProducto2);
            catalogoDelMenu.addProduct(nuevoProducto3);
            catalogoDelMenu.addProduct(nuevoProducto4);
            catalogoDelMenu.addProduct(nuevoProducto5);
            runMenu();
        }

    }



