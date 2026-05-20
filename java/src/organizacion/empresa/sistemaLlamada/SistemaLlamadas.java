package organizacion.empresa.sistemaLlamada;

import personas.Empleado;
import organizacion.empresa.Empresa;

import java.util.ArrayList;

public class SistemaLlamadas {
    private ArrayList<Llamada> llamadas;

    public SistemaLlamadas() {
        this.llamadas = new ArrayList<>();
    }

    public Llamada addLlamada(Empleado origen, int numero, String franjaHoraria) {
        Empleado destino = null;
        for (Empleado empleado : origen.getEmpresa().getEmpleados()) {
            if (empleado.getTelefono() == numero) {
                destino = empleado;
                break;
            }
        }
        if (destino == null) {
            return null;
        }

        Llamada llamada;
        if (origen.getPais().equals(destino.getPais())) {
            llamada = new LlamadaNacional(origen, destino);
        } else {
            llamada = new LlamadaInternacional(origen, destino, franjaHoraria);
        }
        return llamada;
    }

    public void registrarLlamada(Llamada llamada, double duracion) {
        llamada.setDuracion(duracion);
        llamada.calcCosto();
        this.llamadas.add(llamada);
    }

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(ArrayList<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Empleado emp1 = new Empleado("García", "Carlos", 12345678, "Argentina", 111, empresa, "Buenos Aires");
        Empleado emp2 = new Empleado("López", "Ana", 87654321, "Argentina", 222, empresa, "Córdoba");
        Empleado emp3 = new Empleado("Smith", "John", 99999999, "Brasil", 333, empresa, "São Paulo");

        empresa.addEmpleado(emp1);
        empresa.addEmpleado(emp2);
        empresa.addEmpleado(emp3);

        System.out.println("=== Empleados registrados ===");
        for (Empleado e : empresa.getEmpleados()) {
            System.out.println(e.getNombre() + " " + e.getApellido()
                    + " | País: " + e.getPais()
                    + " | Provincia: " + e.getProvincia()
                    + " | Tel: " + e.getTelefono());
        }

        SistemaLlamadas sistema = empresa.getSistema();

        System.out.println("\n=== Llamada Nacional (Argentina → Argentina) ===");
        Llamada nacional = sistema.addLlamada(emp1, 222, null);
        if (nacional != null) {
            sistema.registrarLlamada(nacional, 5.0);
            System.out.println("Tipo     : " + nacional.getClass().getSimpleName());
            System.out.println("Origen   : " + nacional.getPersonaOrigen().getNombre());
            System.out.println("Destino  : " + nacional.getPersonaDestino().getNombre());
            System.out.println("Duración : " + nacional.getDuracion() + " min");
            System.out.println("Costo    : $" + nacional.getCosto());
            System.out.println("Fecha    : " + nacional.getFecha());
        }

        System.out.println("\n=== Llamada Internacional (Argentina → Brasil) ===");
        Llamada internacional = sistema.addLlamada(emp1, 333, "UTC-3");
        if (internacional != null) {
            sistema.registrarLlamada(internacional, 3.0);
            System.out.println("Tipo     : " + internacional.getClass().getSimpleName());
            System.out.println("Origen   : " + internacional.getPersonaOrigen().getNombre());
            System.out.println("Destino  : " + internacional.getPersonaDestino().getNombre());
            System.out.println("Duración : " + internacional.getDuracion() + " min");
            System.out.println("Franja   : " + ((LlamadaInternacional) internacional).getFranjaHoraria());
            System.out.println("Costo    : $" + internacional.getCosto());
            System.out.println("Fecha    : " + internacional.getFecha());
        }

        System.out.println("\n=== Llamada a número inexistente (tel: 999) ===");
        Llamada inexistente = sistema.addLlamada(emp1, 999, null);
        System.out.println("Resultado: " + (inexistente == null ? "null — número no encontrado en la empresa" : "encontrada"));

        System.out.println("\n=== Empleado.llamar() — emp2 llama a emp3 ===");
        emp2.llamar(333);
        System.out.println("Llamada registrada vía Empleado.llamar()");

        System.out.println("\n=== Todas las llamadas registradas ===");
        for (Llamada l : sistema.getLlamadas()) {
            System.out.println(l.getClass().getSimpleName()
                    + " | " + l.getPersonaOrigen().getNombre() + " → " + l.getPersonaDestino().getNombre()
                    + " | Duración: " + l.getDuracion()
                    + " | Costo: $" + l.getCosto()
                    + " | Fecha: " + l.getFecha());
        }
    }
}
