// Purpose: Contiene los metodos de control de datos ingresados por el usuario.
// Date: 23/09/2020

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Control {

    private static Scanner scInt = new Scanner(System.in);
    private static Scanner scString = new Scanner(System.in);

    //Metodos de control de datos ingresados por el usuario
    //Metodo de control de datos general
    public static int controlInt(String tipo_de_dato, int minLimit, int maxLimit) {//Control de datos de tipo int
        int data = -1;
        while (true) {//comprobamos que el numero no sea menor que 0, en un menú de compras no hay cantidades negativas de nada
            try {//intentamos que el usuario ingrese un entero, según el tipo de dato que se le pida
                data = scInt.nextInt();
                data = minLimitAndMaxToinT(data, minLimit, maxLimit);
                return data;
            } catch (InputMismatchException e) {/*se lanza cuando se espera un tipo de dato específico, como un número entero, pero el valor proporcionado no coincide con el tipo de dato esperado.
             Esto ocurre comúnmente cuando se utilizan clases como Scanner para leer datos del usuario.*/
                System.err.println("Se ha producido un error de tipo: " + e.getClass().getSimpleName());
                ;//imprime el tipo de error que se produjo
                System.err.println("Descripción del error: " + e.getMessage());//imprime la descripción del error
                System.out.printf("Dato ingresado necesario, %s es erróneo.\nPor favor ingrese su %s: ", tipo_de_dato, tipo_de_dato);
                System.out.println("Ingrese un numero entero: ");
                scInt.nextLine(); // Limpieza del buffer de entrada
            }
        return data;
        }
    }
    public static String controlNoNull(String data, String typeOfData){//Control para no permitir datos nulos o lleno de espacios

        while(data == null || data.trim().isEmpty()) {//Usamos ciclo while para que el usuario no pueda saltarse este control hasta que ingrese un dato valido
            System.out.printf("Dato ingresado necesario, el %s no puede estar vacio.\nPor favor ingrese tu %s: ", typeOfData, typeOfData);
            data = scString.next();
            System.out.println();
        }
        return data;
    }

    public static String controlLength(String data ,String messageError, int minLength, int maxLength){//Control de largo de datos

        while(minLength > data.length() || data.length() > maxLength) {//Usamos ciclo while para que el usuario no pueda saltarse este control hasta que ingrese una longitud valida de datos.
            System.out.println(messageError + "\nPor favor ingrese nuevamente: ");
            data = scString.next();
            System.out.println();
        }
        return data;
    }

    public static int controlStringToIntValue(String valueToInt){//Control para convertir un string a int

        int value = -1;
        while(value < 0) {//Utilizamos el ciclo while para que el usuario no pueda saltarse este control hasta que ingrese un String valido para ser convertido a int y este sea mayor que 0
            try {//intentamos convertir el string a int
                value = Integer.parseInt(valueToInt);
            } catch (NumberFormatException e) {/*se lanza este error cuando se intenta convertir una cadena (String) a un tipo numérico, como int, double, etc., y la cadena no tiene un formato numérico válido.*/
                System.err.println("Se ha producido un error de tipo: " + e.getClass().getSimpleName());//imprime el tipo de error que se produjo
                System.err.println("Descripción del error: " + e.getMessage());//imprime la descripción del error
                System.out.println("El valor ingresado no es un numero entero, por favor intentelo nuevamente: ");
                valueToInt = scString.next();
            }
        }
        return value;
    }

    public static double controlStringToDoubleValue(String valueToDouble){//Control para convertir un string a double

        double value = -1;
        while(value < 0) {//Utilizamos el ciclo while para que el usuario no pueda saltarse este control hasta que ingrese un String valido para ser convertido a double y este sea mayor que 0
            try {//intentamos convertir el string a double
                value = Double.parseDouble(valueToDouble);
            } catch (NumberFormatException e) {/*se lanza este error cuando se intenta convertir una cadena (String) a un tipo numérico, como int, double, etc., y la cadena no tiene un formato numérico válido.*/
                System.err.println("Se ha producido un error de tipo: " + e.getClass().getSimpleName());//imprime el tipo de error que se produjo
                System.err.println("Descripción del error: " + e.getMessage());//imprime la descripción del error
                System.out.println("El valor ingresado no es un numero, por favor intentelo nuevamente: ");
                valueToDouble = scString.next();
            }
        }
        return value;
    }

    public static int controlGeneralChoices(int minLimit, int maxLimit){
        int choice = controlInt("la eleccion", minLimit, maxLimit);
        while(choice < minLimit || choice > maxLimit){
            System.out.println("La eleccion no es valida, por favor intentelo nuevamente: ");
            choice = controlInt("la eleccion", minLimit, maxLimit);
        }
        return choice;
    }

    public static int minLimitAndMaxToinT(int data, int minLimit, int maxLimit){
        while(data < minLimit || data > maxLimit){
            if (data < minLimit){
                System.out.printf("El numero ingresado no puede ser menor que %i, por favor intentelo nuevamente: ", minLimit);
                data = scInt.nextInt();
            }else{
                System.out.printf("El numero ingresado no puede ser mayor que %i, por favor intentelo nuevamente: ", maxLimit);
                data = scInt.nextInt();
            }

        }
        return data;
    }

}







