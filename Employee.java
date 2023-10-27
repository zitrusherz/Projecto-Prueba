public class Employee extends UserAbstract {

    private String nombre, apellido;
    private String correo;
    private String run;
    private String dv;
    private String cargo;

    public Employee(String nombre, String apellido, String correo, String run, String dv, String cargo){
        super(nombre, apellido, correo, run, dv);

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.run = run;
        this.dv = dv;
        this.cargo = cargo;
    }

    @Override
    public String getNameAndLastname() {
        return this.nombre + ' ' + this.apellido;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + "\n"
                + "Correo: " + this.correo + "\n"
                + "Cargo: " + this.cargo + "\n"
                + "Rut: " + this.run + '-' + this.dv;
    }
}
