import java.util.*;

public class Expedicion {
    private int id;
    private String nombre;
    private Date fecha;
    private Montania montania;
    private List<Participacion> participantes;

    public Expedicion(int id, String nombre, Date fecha, Montania montania) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.montania = montania;
        this.participantes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getNombre(){
        return nombre;
    }

    public void agregarParticipante(Participacion p) {
        participantes.add(p);
    }

    public void listarParticipantes() {
        System.out.println("Participantes en expedición " + nombre + ":");
        if (participantes.isEmpty()) {
            System.out.println("  0 participantes");
        } else {
            for (Participacion p : participantes) {
                System.out.print("- ");
                p.expedicionario.mostrarInfo();
                System.out.println("  Rol: " + p.rol);
            }
        }
    }
}

