import java.util.ArrayList;
import java.util.List;

public class Montania {
    private int id;
    private String nombre;
    private float altura;
    private String dificultad;
    private List<Expedicion> expediciones;

    public Montania(int id, String nombre, float altura, String dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
        this.dificultad = dificultad;
        this.expediciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void anadirExpedicion(Expedicion e){
        // Precondición: La expedición no debe ser nula
        if (e == null) {
            throw new IllegalArgumentException("La expedición no puede ser nula.");
        }

        // Añadimos la expedición a la lista de expediciones
        expediciones.add(e);

        // Postcondición: La expedición se debe haber añadido a la lista de expediciones
        assert expediciones.contains(e) : "La expedición no ha sido añadida correctamente.";

    }

    public void mostrarInfo() {
        // Precondición: La lista de expediciones no debe ser nula
        assert expediciones != null : "La lista de expediciones no debe ser nula.";
        //Mostramos la información de la montaña
        System.out.print("Montaña: " + nombre + " | Altura: " + altura + "m | Dificultad: " + dificultad + " | ");
        System.out.print("Expediciones Asociadas: ");
        //Postcondición: Si la  lista de expediciones esta vacia, de debe imprimir "Ninguna"
        if (expediciones.isEmpty()) {
            System.out.println("Ninguna");
        } else {
            for (Expedicion e : expediciones) {
                System.out.print(e.getNombre() + ", ");
            }
            System.out.println();  // Salto de línea después de las expediciones
        }
    }
}