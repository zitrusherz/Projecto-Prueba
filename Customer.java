

public class Customer extends UserAbstract{
    private String nombre, apellido;
    private String correo;
    private String telefono;
    private String run;
    private String dv;

    public Customer(String nombre, String apellido, String correo, String telefono, String run, String dv){
        super(nombre, apellido, correo, run, dv);

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.run = run;
        this.dv = dv;
    }


    @Override
    public String getNameAndLastname() {
        return this.nombre + ' ' + this.apellido;
    }

    public String toString() {
        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + "\n"
                + "Correo: " + this.correo + "\n"
                + "Telefono: " + this.telefono + "\n"
                + "Rut: " + this.run + '-' + this.dv;
    }
}
