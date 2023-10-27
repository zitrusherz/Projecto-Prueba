import java.util.Scanner;

public class ControlCustomer extends ControlUser{

    private static Scanner sc = new Scanner(System.in);
    public static String phone(){

        String customerNumber = sc.next();
        customerNumber = controlLength(customerNumber, "El numero no puede tener mas de 8 digitos", 8, 8);
        customerNumber = controlNoNull(customerNumber, "numero de telefono");
        return customerNumber;
    }

    public static String email(){

        String customerEmail = sc.next();
        customerEmail = controlNoNull(customerEmail,"correo");
        customerEmail = controlLength(customerEmail, "El correo no puede tener mas de 30 caracteres ni menos de 5", 5, 40);
        while(!customerEmail.contains("@") || !customerEmail.contains(".") || customerEmail.lastIndexOf(".") < customerEmail.indexOf("@")){
            System.out.println("El correo ingresado no es valido, intentelo nuevamente: ");
            customerEmail = sc.next();
        }
        return customerEmail;
    }
}
