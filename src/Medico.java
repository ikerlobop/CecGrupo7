public class Medico extends Expedicionario {
    private String especialidad;
    private int añosExperiencia;

    public Medico(int id, String nombre, String email, String telefono, String especialidad, int añosExp) {
        super(id, nombre, email, telefono);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExp;
    }

    public void asignarEspecialidad(String nueva) {
        this.especialidad = nueva;
    }

    public void mostrarInfo() {
        System.out.println("Médico: " + nombre + " | Especialidad: " + especialidad + " | Experiencia: " + añosExperiencia + " años");
    }
}