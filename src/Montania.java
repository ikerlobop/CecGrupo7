import java.util.ArrayList;
import java.util.List;

public class Montania {
    int id;
    String nombre;
    float altura;
    String dificultad;
    List<Expedicion> expediciones;

    public Montania(int id, String nombre, float altura, String dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
        this.dificultad = dificultad;
        this.expediciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void anadirExpedicion(Expedicion e){
        expediciones.add(e);
    }

    public void mostrarInfo() {
        System.out.print("Montaña: " + nombre + " | Altura: " + altura + "m | Dificultad: " + dificultad + " | ");
        System.out.print("Expediciones Asociadas: ");
        if (expediciones.isEmpty()) {
            System.out.println("Ninguna");
        } else {
            for (Expedicion e : expediciones) {
                System.out.print(e.nombre + ", ");
            }
            System.out.println();  // Salto de línea después de las expediciones
        }
    }
}