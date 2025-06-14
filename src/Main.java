import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Expedicionario> expedicionarios = new ArrayList<>();
        List<Montania> montanias = new ArrayList<>();
        List<Expedicion> expediciones = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n=== MENÚ EXPEDICIÓN ===");
            System.out.println("1. Añadir alpinista");
            System.out.println("2. Añadir médico");
            System.out.println("3. Añadir montaña");
            System.out.println("4. Crear expedición");
            System.out.println("5. Añadir participación");
            System.out.println("6. Ver participantes de expedición");
            System.out.println("7. Listar expedicionarios");
            System.out.println("8. Listar montañas y expediones asociadas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Nivel experiencia: ");
                    String nivel = sc.nextLine();
                    expedicionarios.add(new Alpinista(expedicionarios.size() + 1, nombre, email, telefono, nivel));
                }
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = sc.nextLine();
                    System.out.print("Años de experiencia: ");
                    int años = sc.nextInt(); sc.nextLine();
                    expedicionarios.add(new Medico(expedicionarios.size() + 1, nombre, email, telefono, esp, años));
                }
                case 3 -> {
                    System.out.print("Nombre montaña: ");
                    String nombre = sc.nextLine();
                    System.out.print("Altura: ");
                    float altura = sc.nextFloat(); sc.nextLine();
                    System.out.print("Dificultad: ");
                    String dificultad = sc.nextLine();
                    montanias.add(new Montania(montanias.size() + 1, nombre, altura, dificultad));
                }
                case 4 -> {
                    System.out.println("--MONTAÑAS DISPONIBLES PARA EXPEDICIONES--");
                    for (Montania m : montanias)
                        System.out.println(m.id + " - " + m.nombre);
                    System.out.print("Nombre expedición: ");
                    String nombre = sc.nextLine();
                    System.out.print("Fecha (dd/mm/yyyy): ");
                    String fechaStr = sc.nextLine();
                    try {
                        Date fecha = new GregorianCalendar(
                                Integer.parseInt(fechaStr.substring(6)),
                                Integer.parseInt(fechaStr.substring(3, 5)) - 1,
                                Integer.parseInt(fechaStr.substring(0, 2))
                        ).getTime();
                        if (montanias.isEmpty()) {
                            System.out.println("No hay montañas disponibles.");
                            break;
                        }
                        System.out.println("ID Montaña:");
                        for (Montania m : montanias)
                            System.out.println(m.id + " - " + m.nombre);
                        int idMontania = sc.nextInt(); sc.nextLine();
                        Montania montania = montanias.get(idMontania - 1);
                        Expedicion nuevaExpedicion =new Expedicion(expediciones.size() + 1, nombre, fecha, montania);
                        expediciones.add(nuevaExpedicion);
                        montania.anadirExpedicion(nuevaExpedicion);

                    } catch (Exception e) {
                        System.out.println("Fecha inválida o montaña no encontrada.");
                    }
                }
                case 5 -> {
                    if (expediciones.isEmpty()) {
                        System.out.println("No hay expediciones disponibles.");
                        break;
                    }
                    if (expedicionarios.isEmpty()) {
                        System.out.println("No hay expedicionarios disponibles.");
                        break;
                    }
                    for (Expedicion e : expediciones)
                        System.out.println(e.id + " - " + e.nombre );
                    System.out.print("ID Expedición: ");
                    int idExp = sc.nextInt(); sc.nextLine();
                    if (idExp <= 0 || idExp > expediciones.size()) {
                        System.out.println("ID de expedición no válido.");
                        break;
                    }
                    for (Expedicionario ex : expedicionarios) {
                        String rol = (ex instanceof Alpinista) ? "Alpinista" : "Médico";
                        System.out.println(ex.getId() + " - " + ex.getNombre() + " Especialidad " + rol);
                    }
                    System.out.print("ID Expedicionario: ");
                    int idExped = sc.nextInt(); sc.nextLine();
                    if (idExped <= 0 || idExped > expedicionarios.size()) {
                        System.out.println("ID de expedicionario no válido.");
                        break;
                    }
                    System.out.print("Rol: ");
                    String rol = sc.nextLine();
                    expediciones.get(idExp - 1).agregarParticipante(new Participacion(expedicionarios.get(idExped - 1), rol));
                }
                case 6 -> {
                    if (expediciones.isEmpty()) {
                        System.out.println("No hay expediciones disponibles.");
                        break;
                    }
                    for (Expedicion e : expediciones)
                        System.out.println(e.id + " - " + e.nombre);
                    System.out.print("ID expedición: ");
                    int id = sc.nextInt(); sc.nextLine();
                    if (id <= 0 || id > expediciones.size()) {
                        System.out.println("ID de expedición no válido.");
                        break;
                    }
                    expediciones.get(id - 1).listarParticipantes();
                }
                case 7 -> {
                    System.out.println("\nLista de Expedicionarios:");
                    if (expedicionarios.isEmpty()) {
                        System.out.println("  0 expedicionarios registrados");
                    } else {
                        for (Expedicionario e : expedicionarios) {
                            e.mostrarInfo();
                        }
                    }
                }
                case 8 -> {
                    System.out.println("\nLista de Montañas:");
                    if (montanias.isEmpty()) {
                        System.out.println("  0 montañas registradas");
                    } else {
                        for (Montania m : montanias)  {
                            m.mostrarInfo();
                        }
                    }
                }
            }
        } while (opcion != 0);

        System.out.println("Saliendo...");
    }
}
