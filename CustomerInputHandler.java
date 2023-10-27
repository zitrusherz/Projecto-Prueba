
public class CustomerInputHandler{

    public static Customer obtenerDatosCliente() {

        System.out.print("Por favor ingrese su nombre: ");
        String nombre = ControlUser.nameOrSurname();


        System.out.print("Por favor ingrese su apellido: ");
        String apellido = ControlUser.nameOrSurname();

        System.out.print("Por favor ingrese su correo: ");
        String correo = ControlCustomer.email();

        System.out.print("Por favor ingrese su telefono (Sin codigo de area ni el 9): ");
        String telefono = ControlCustomer.phone();

        System.out.print("Por favor ingrese su run(sin digito verificador): ");
        String run = ControlUser.run();

        System.out.print("Por favor ingrese su digito verificador: ");
        String dv = ControlUser.dv("dv");

        return new Customer(nombre, apellido, correo, telefono, run, dv);
    }


}