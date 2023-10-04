public class Cliente {
    private String nombre, apellido;
    private String correo;
    private String telefono;
    private String run;
    private String dv;

    public Cliente(String nombre, String apellido, String correo, String telefono, String run, String dv){

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.run = run;
        this.dv = dv;
    }
    public static void getNameAndLastname(Cliente cliente){
        System.out.println(cliente.nombre + ' ' + cliente.apellido);
    }
    public String toString() {
        return "Nombre: " + nombre + " Apellido: " + apellido + "\n"
                + "Correo: " + correo + "\n"
                + "Telefono: " + telefono + "\n"
                + "Rut: " + run + '-' + dv;
    }
}
