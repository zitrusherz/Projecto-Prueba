import java.util.Scanner;
public class ClienteInputHandler{

    public static Cliente obtenerDatosCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor ingrese su nombre: ");
        String nombre = sc.nextLine();
                nombre = Control.controlNoNull(nombre,"nombre");

        System.out.print("Por favor ingrese su apellido: ");
        String apellido = sc.nextLine();
                apellido = Control.controlNoNull(apellido,"apellido");

        System.out.print("Por favor ingrese su correo: ");
        String correo = Control.controlCustomerEmail();

        System.out.print("Por favor ingrese su telefono (Sin codigo de area ni el 9): ");
        String telefono = Control.controlCustomerPhone();

        System.out.print("Por favor ingrese su run(sin digito verificador): ");
        String run = Control.controlRun();

        System.out.print("Por favor ingrese su digito verificador: ");
        String dv = Control.controlDv("dv");
        sc.close();
        return new Cliente(nombre, apellido, correo, telefono, run, dv);
    }


}
