public class EmployeeInputHandler {
    public static Employee createEmployee() {
        String nombre, apellido, correo, run, dv, cargo;

        System.out.print("Por favor ingrese su nombre: ");
        nombre = ControlUser.nameOrSurname();

        System.out.print("Por favor ingrese su apellido: ");
        apellido = ControlUser.nameOrSurname();

        System.out.print("Por favor ingrese su correo: ");
        correo = ControlEmployee.email();

        System.out.print("Por favor ingrese su run(sin digito verificador): ");
        run = ControlUser.run();

        System.out.print("Por favor ingrese su digito verificador: ");
        dv = ControlUser.dv("dv");

        System.out.print("Por favor ingrese su cargo: ");
        cargo = ControlEmployee.cargo();

        return new Employee(nombre, apellido, correo, run, dv, cargo);
    }
}
