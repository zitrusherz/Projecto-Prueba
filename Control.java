// Purpose: Contiene los metodos de control de datos ingresados por el usuario.
// Date: 23/09/2020

import java.util.ArrayList;
import java.util.Scanner;
public class Control {

    private final Scanner sc = new Scanner(System.in);

    //Metodos de control de datos ingresados por el usuario
    //Metodo de control de datos general
    public int controlInt(String tipo_de_dato) {//Control de datos de tipo int
        int dato = -1;

        try {
            dato = sc.nextInt();
            return dato;
        } catch (Exception e) {
            System.out.checkError();
            System.out.printf("Dato ingresado necesario, %s es erroneo.\nPor favor ingresa tu %s: ", tipo_de_dato, tipo_de_dato);
            System.out.println("Ingrese un numero entero: ");
            controlInt(tipo_de_dato);
        }
        return dato;
    }
    public String controlNoNull(String data, String typeOfData){//Control para no permitir datos nulos

        if(data == null || data.equals(" ")) {
            System.out.printf("Dato ingresado necesario, el %s no puede estar vacio.\nPor favor ingrese tu %s: ", typeOfData, typeOfData);
            data = sc.next();
            controlNoNull(data, typeOfData);
            System.out.println();
        }
        return data;
    }

    public String controlLength(String data ,String messageError, int minLength, int maxLength){//Control de largo de datos

        if(data.length() < minLength || data.length() > maxLength) {
            System.out.println(messageError + "\nPor favor ingrese nuevamente: ");
            data = sc.next();
            controlLength(data, messageError, minLength, maxLength);
            System.out.println();
        }
        return data;
    }

    public int controlStringToIntValue(String valueToInt){//Control para convertir un string a int
        int value = -1;
        try{
            value = Integer.parseInt(valueToInt);
        }catch (Exception e){
            System.out.println("El valor ingresado no es un numero entero, por favor intentelo nuevamente: ");
            valueToInt = sc.next();
            value = controlStringToIntValue(valueToInt);
        }
        return value;
    }

    public double controlStringToDoubleValue(String valueToDouble){//Control para convertir un string a double
        double value = -1;
        try{
            value = Double.parseDouble(valueToDouble);
        }catch (Exception e){
            System.out.println("El valor ingresado no es un numero, por favor intentelo nuevamente: ");
            valueToDouble = sc.next();
            value = controlStringToDoubleValue(valueToDouble);
        }
        return value;
    }
    //---------------------------------------------------------------------------------------------------------------
    //Metodo de control de producto
    public String controlId(){//Control de ID de producto
        String idProduct = sc.next();
        idProduct = controlNoNull(idProduct, "ID/codigo del producto");
        idProduct = controlLength(idProduct, "ID/codigo del producto tiene un largo fuera del rango", 6, 8);
        return idProduct;
    }
    public int controlPrice(){//Control de precio de producto
        int precio = controlInt("el precio");
        if(precio <= 0){
            System.out.println("El precio no puede ser menor o igual a 0.\nPor favor ingreselo nuevamente: ");
            return controlPrice();
        }
        return precio;
    }
    //Metodo de control de categoria
    public Enum controlCategoria(){

        Catalogo.categoryList();
        System.out.println("Por favor ingrese el numero correspondiente a la categoria del producto: ");
        int eleccion = controlInt("la eleccion");
        eleccion = controlGeneralChoices(eleccion, 1, 3);
        Enum categoria = Categorias.values()[eleccion - 1];
        return categoria;
    }
    //Metodo de control de cantidad de productos
    public int controlStockOfProductsInput(){
        int cantidadProducto = controlInt("la cantidad de productos");
        if (cantidadProducto <= 0){
            System.out.println("La cantidad de productos no puede ser menor o igual a 0.\nPor favor ingresela nuevamente: ");
            return controlStockOfProductsInput();
        }
        return cantidadProducto;
    }
    //Metodo de control de cliente
    public String controlCustomerPhone(){
        String customerNumber = sc.next();
        customerNumber = controlLength(customerNumber, "El numero no puede tener mas de 8 digitos", 8, 8);
        customerNumber = controlNoNull(customerNumber, "numero de telefono");
        return customerNumber;
    }

    public String controlCustomerEmail(){
        String customerEmail = sc.next();
        customerEmail = controlNoNull(customerEmail,"correo");
        customerEmail = controlLength(customerEmail, "El correo no puede tener mas de 30 caracteres ni menos de 5", 5, 40);
        if(!customerEmail.contains("@") || !customerEmail.contains(".") || customerEmail.lastIndexOf(".") < customerEmail.indexOf("@")){
            System.out.println("El correo ingresado no es valido, intentelo nuevamente: ");
            return controlCustomerEmail();
        }
        return customerEmail;
    }

    public String controlRun(){

        String dato = sc.next();
        dato = controlNoNull(dato, "run");
        dato = controlLength(dato, "El run debe tener entre 7 y 8 caracteres", 7, 8);
        return dato;
    }
    public String controlDv(String tipo_de_dato){

        String dato = sc.next();
        dato = controlNoNull(dato, tipo_de_dato);
        dato = controlLength(dato, "El digito verificador debe tener 1 caracter", 1, 1);
        return dato;
    }
    //Metodo de control del menu
    public int controlMenu(){
        int eleccion = controlInt("la eleccion");
        eleccion = controlGeneralChoices(eleccion, 0, 2);
        return eleccion;
    }
    public Catalogo controlNoNullListOfProducts(ArrayList<Producto> catalogoInput){

        int eleccion;
        ProductoInputHandler productoInputHandler = new ProductoInputHandler();

        if(catalogoInput == null || catalogoInput.isEmpty()) {
            System.out.println("No hay productos para comprar, por favor ingrese 1 para agregar un producto al catalogo, o ingrese 0 para salir del programa:");
            eleccion = controlInt("la eleccion");
            eleccion = controlGeneralChoices(eleccion, 0, 1);
            System.out.println();
            if (eleccion == 0) {
                return null;
            } else if (eleccion == 1) {
                System.out.println("Bienvenido a We are.\nPor favor ingrese los datos del producto que desea agregar al catalogo");
                Producto nuevoProducto = productoInputHandler.obtenerDatosProducto();
                Catalogo catalogo = new Catalogo(nuevoProducto);
                System.out.println("El producto ha sido agregado al catalogo");
                return catalogo;
            }
        }
        return null;
    }

    public int controlNumOfProducts(int NumOfProducts){
        int inputUser = controlInt("el numero de producto");
        if (inputUser < 0 || inputUser > NumOfProducts){
            System.out.println("El numero del producto no es valido, por favor intentelo nuevamente: ");
            return controlNumOfProducts(NumOfProducts);
        }
        return inputUser;

    }

    public int controlStockOfProducts(int quantityToPurchase, int numOfProducts, Catalogo catalogo){
        quantityToPurchase = controlInt("la cantidad de productos a comprar");
        if(quantityToPurchase > catalogo.getCantidadProducto(numOfProducts, catalogo.getCatalogo())){
            System.out.println("La cantidad de productos a comprar es mayor a la cantidad de productos en stock\nPor favor ingrese una cantidad valida: ");
            return controlStockOfProducts(quantityToPurchase, numOfProducts, catalogo);
        }
        return quantityToPurchase;
    }

    //Prueba control de eleccion general

    public int controlGeneralChoices(int choice, int minLimit, int maxLimit){
        if(choice < minLimit || choice > maxLimit){
            System.out.println("La eleccion no es valida, por favor intentelo nuevamente: ");
            choice = sc.nextInt();
            return controlGeneralChoices(choice, minLimit, maxLimit);
        }
        return choice;
    }

}







