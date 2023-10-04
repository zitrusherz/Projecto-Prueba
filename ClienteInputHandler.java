import java.util.Scanner;
public class ClienteInputHandler{
    private final Control controlador = new Control();
    private final Scanner sc = new Scanner(System.in);

    public Cliente obtenerDatosCliente() {
        System.out.print("Por favor ingrese su nombre: ");
        String nombre = sc.nextLine();
                nombre = controlador.controlNoNull(nombre,"nombre");

        System.out.print("Por favor ingrese su apellido: ");
        String apellido = sc.nextLine();
                apellido = controlador.controlNoNull(apellido,"apellido");

        System.out.print("Por favor ingrese su correo: ");
        String correo = controlador.controlCustomerEmail();

        System.out.print("Por favor ingrese su telefono (Sin codigo de area ni el 9): ");
        String telefono = controlador.controlCustomerPhone();

        System.out.print("Por favor ingrese su run(sin digito verificador): ");
        String run = controlador.controlRun();

        System.out.print("Por favor ingrese su digito verificador: ");
        String dv = controlador.controlDv("dv");

        return new Cliente(nombre, apellido, correo, telefono, run, dv);
    }


}