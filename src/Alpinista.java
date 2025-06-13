public class Alpinista extends Expedicionario {
    private String nivelExp;
    private int numAscensos;

    public Alpinista(int id, String nombre, String email, String telefono, String nivelExp) {
        super(id, nombre, email, telefono);
        this.nivelExp = nivelExp;
        this.numAscensos = 0;
    }

    public void registrarAscenso() {
        numAscensos++;
    }

    public void mostrarInfo() {
        System.out.println("Alpinista: " + nombre + " | Nivel: " + nivelExp + " | Ascensos: " + numAscensos);
    }
}