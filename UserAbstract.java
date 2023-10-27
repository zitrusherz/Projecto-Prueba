public abstract class  UserAbstract {
    private String nombre, apellido;
    private String correo;
    private String run;
    private String dv;

    public UserAbstract(String nombre, String apellido, String correo, String run, String dv){

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.run = run;
        this.dv = dv;
    }

    public abstract String getNameAndLastname();

    public abstract String toString();
}
