
public class Montania {
    int id;
    String nombre;
    float altura;
    String dificultad;

    public Montania(int id, String nombre, float altura, String dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
        this.dificultad = dificultad;
    }

    public void mostrarInfo() {
        System.out.println("Montaña: " + nombre + " | Altura: " + altura + "m | Dificultad: " + dificultad);
    }
}