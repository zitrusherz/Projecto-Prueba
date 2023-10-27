import java.util.Scanner;

public class ControlUser extends Control{

    private static Scanner sc = new Scanner(System.in);

    protected static String nameOrSurname(){

        String dato = sc.next();
        dato = controlNoNull(dato, "nombre");
        dato = controlLength(dato, "El nombre debe tener entre 3 y 30 caracteres", 2, 30);
        return dato;
    }

    protected static String run(){

        String dato = sc.next();
        dato = controlNoNull(dato, "run");
        dato = controlLength(dato, "El run debe tener entre 7 y 8 caracteres", 7, 8);
        return dato;
    }
    public static String dv(String tipo_de_dato){

        String dato = sc.next();
        dato = controlNoNull(dato, tipo_de_dato);
        dato = controlLength(dato, "El digito verificador debe tener 1 caracter", 1, 1);
        return dato;
    }
}
