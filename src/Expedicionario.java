public abstract class Expedicionario {
    protected int id;
    protected String nombre, email, telefono;

    public Expedicionario(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarInfo();
}