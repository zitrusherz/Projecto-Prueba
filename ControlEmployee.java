import java.util.Scanner;

public class ControlEmployee extends ControlUser{

    private static Scanner sc = new Scanner(System.in);

    public static String email(){

        String employeeEmail = sc.next();
        employeeEmail = controlNoNull(employeeEmail,"correo");
        employeeEmail = controlLength(employeeEmail, "El correo no puede tener mas de 30 caracteres ni menos de 5", 5, 40);
        while(!employeeEmail.contains("zitrusmail") || !employeeEmail.contains("@") || !employeeEmail.contains(".") || employeeEmail.lastIndexOf(".") < employeeEmail.indexOf("@")){
            System.out.println("El correo ingresado no es valido, intentelo nuevamente: ");
            employeeEmail = sc.next();
            employeeEmail = controlNoNull(employeeEmail,"correo");
            employeeEmail = controlLength(employeeEmail, "El correo no puede tener mas de 30 caracteres ni menos de 5", 5, 40);
        }
        return employeeEmail;
    }

    public static String cargo(){

        String cargo = sc.next();
        cargo = controlNoNull(cargo, "cargo");
        cargo = controlLength(cargo, "El cargo no puede tener mas de 30 caracteres ni menos de 5", 4, 30);
        return cargo;
    }
}
