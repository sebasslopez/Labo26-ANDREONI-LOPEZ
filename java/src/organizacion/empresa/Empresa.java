package organizacion.empresa;

import organizacion.empresa.llamada.FranjaHoraria;
import organizacion.empresa.llamada.Llamada;
import organizacion.empresa.llamada.LlamadaInternacional;
import organizacion.empresa.llamada.LlamadaLocal;
import personas.Empleado;
import transporte.Bicicleta;
import transporte.Camion;
import transporte.Coche;
import transporte.Vehiculo;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Vehiculo> vehiculo;
    private ArrayList<Empleado> empleados;
    private String nombre;
    private ArrayList<Llamada> llamadas;

    public Empresa(ArrayList<Vehiculo> vehiculo, ArrayList<Empleado> empleados) {
        this.vehiculo = vehiculo;
        this.empleados = empleados;
        this.nombre = "PoliEmpresa";
        this.llamadas = new ArrayList<>();
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
        this.llamadas = new ArrayList<>();
        this.vehiculo = new ArrayList<>();
    }

    public Empresa(){
        this.vehiculo = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.nombre = "PoliEmpresa";
        this.llamadas = new ArrayList<>();
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean agregarCarga (Camion c, int cantkg){
        if(cantkg > c.getCapkg()){
            return false;
        }
        c.setCapkg(cantkg);
        return true;
    }

    public int porcentajeDesc(){
        int coches = 0,desca = 0;
        for( Vehiculo v : vehiculo){
            if(v instanceof Coche c){
                coches++;
                if(c.isDescapotable()) desca++;
            }
        }
        return (desca/coches)*100;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        if (existeDni(empleado.getDni()) || existeTelefono(empleado.getTelefono())) {
            return false;
        }
        empleados.add(empleado);
        return true;
    }

    public boolean registrarLlamada(Empleado origen, String telefonoDestino, int duracionMinutos) {
        if (origen == null || telefonoDestino == null || duracionMinutos <= 0) {
            return false;
        }

        if (!existeEmpleado(origen)) {
            return false;
        }

        Empleado destino = buscarEmpleadoPorTelefono(telefonoDestino);

        if (destino == null) {
            return false;
        }

        if (origen.tieneMismoDniQue(destino.getDni())) {
            return false;
        }

        Llamada llamada = crearLlamada(origen, destino, duracionMinutos);
        llamadas.add(llamada);
        return true;
    }

    public Llamada crearLlamada(Empleado origen, Empleado destino, int duracionMinutos) {
        if (origen.viveEnElMismoPaisQue(destino)) {
            return new LlamadaLocal(origen, destino, duracionMinutos);
        }

        return new LlamadaInternacional(origen, destino, duracionMinutos);
    }

    public ArrayList<Llamada> obtenerLlamadasDe(Empleado empleado) {
        ArrayList<Llamada> llamadasDelEmpleado = new ArrayList<>();

        for (Llamada llamada : llamadas) {
            if (llamada.fueRealizadaPor(empleado)) {
                llamadasDelEmpleado.add(llamada);
            }
        }
        return llamadasDelEmpleado;
    }

    public void mostrarRankingEmpleadosQueMasTiempoLlamaronAlExterior() {
        ArrayList<Empleado> empleadosRanking = new ArrayList<>();
        ArrayList<Integer> minutosRanking = new ArrayList<>();

        cargarMinutosAlExterior(empleadosRanking, minutosRanking);

        if (empleadosRanking.isEmpty()) {
            System.out.println("No se registraron llamadas al exterior.");
            return;
        }

        ordenarRankingPorMinutosDescendente(empleadosRanking, minutosRanking);
        imprimirRankingExterior(empleadosRanking, minutosRanking);
    }

    public void cargarMinutosAlExterior(ArrayList<Empleado> empleadosRanking,
                                        ArrayList<Integer> minutosRanking) {

        for (Empleado empleado : empleados) {
            int minutos = calcularMinutosAlExteriorDe(empleado);

            if (minutos > 0) {
                empleadosRanking.add(empleado);
                minutosRanking.add(minutos);
            }
        }
    }
    public int calcularMinutosAlExteriorDe(Empleado empleado) {
        int total = 0;

        for (Llamada llamada : llamadas) {

            total = total + llamada.obtenerMinutosAlExteriorDe(empleado);
        }

        return total;
    }

    public void ordenarRankingPorMinutosDescendente(ArrayList<Empleado> empleadosRanking,
                                                    ArrayList<Integer> minutosRanking) {
        //TODO: Teniendo en cuenta los dos arreglos,
        // ordenar desde el empleado que tiene mayor cantidad de minutos
        // al exterior al menor.

        boolean ordenado = false;
        while (!ordenado) {
            ordenado = true;
            for(int i = 1; i < minutosRanking.size(); i++) {
                if (minutosRanking.get(i-1) < minutosRanking.get(i)) {
                    Empleado aux = empleadosRanking.get(i-1);
                    int minAux = minutosRanking.get(i-1);
                    minutosRanking.set(i-1, minutosRanking.get(i));
                    empleadosRanking.set(i-1, empleadosRanking.get(i));
                    minutosRanking.set(i,minAux);
                    empleadosRanking.set(i,aux);
                    ordenado = false;
                }
            }
        }
    }

    private void imprimirRankingExterior(ArrayList<Empleado> empleadosRanking,
                                         ArrayList<Integer> minutosRanking) {

        System.out.println("Ranking de empleados que mas tiempo llamaron al exterior:");
        //TODO: Mostrar el ranking ordenado concatenando el empleado con los minutos
        for (Empleado empleado : empleadosRanking) {
            System.out.println("Empleado: " + empleado.getNombreCompleto() + ", Minutos: " + minutosRanking.get(empleadosRanking.indexOf(empleado)));
        }
    }

    public void mostrarLlamadasDe(Empleado empleado) {
        //TODO: Implementar un método que reciba un empleado y muestre
        // todas las llamadas que haya hecho ese empleado. Luego, mostrar el costo total
        double total = 0;
        System.out.println("Llamadas de: "+ empleado.getNombreCompleto());
        for(Llamada llamada : llamadas) {
            if(llamada.fueRealizadaPor(empleado)){
                System.out.println(llamada.obtenerDetalle());
                total += llamada.calcularCosto();
            }
        }
        System.out.println("Costo total: " + total);
    }

    public void mostrarTodasLasLlamadas() {
        //TODO: Ver el detalle de todas las llamadas de la empresa por empleado
        for(Empleado empleado : empleados){
            mostrarLlamadasDe(empleado);
        }
    }

    public boolean existeEmpleado(Empleado empleado) {
        for (Empleado empleadoActual : empleados) {
            if (empleadoActual.tieneMismoDniQue(empleado.getDni())) {
                return true;
            }
        }

        return false;
    }

    public boolean existeDni(int dni) {
        for (Empleado empleado : empleados) {
            if (empleado.tieneMismoDniQue(dni)) {
                return true;
            }
        }

        return false;
    }

    public boolean existeTelefono(String telefono) {
        return buscarEmpleadoPorTelefono(telefono) != null;
    }

    public Empleado buscarEmpleadoPorTelefono(String telefono) {
        for (Empleado empleado : empleados) {
            if (empleado.tieneTelefono(telefono)) {
                return empleado;
            }
        }

        return null;
    }

    public String cualTieneMas(){
        int coches = 0,camiones = 0,bicis= 0;
        for(Vehiculo v : vehiculo){
            switch (v) {
                case Camion c -> camiones++;
                case Coche c -> coches++;
                case Bicicleta b -> bicis++;
                default ->{}
            }
        }
        if(coches > camiones && coches > bicis)return "COCHEs";
        else if(camiones > coches && camiones > bicis) return "CAMI oN";
        return "BICIs";
    }

    public boolean seRepite(){
        for(int i=0; i< vehiculo.size(); i++){
            for(int j = i;j<vehiculo.size();j++){
                if(vehiculo.get(i).getPatente()== vehiculo.get(j).getPatente()){
                    return true;
                }

            }
        }
        return false;

    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa("IPM Sistemas");

        Empleado ana = new Empleado("Ana", "Lopez", 111, "Argentina", "1111", "Buenos Aires", "+54", FranjaHoraria.GMT_MENOS3);
        Empleado juan = new Empleado("Juan", "Perez", 222, "Argentina", "2222", "Cordoba", "+54", FranjaHoraria.GMT_MENOS3);
        Empleado maria = new Empleado("Maria", "Silva", 333, "Uruguay", "3333", "Montevideo", "+598", FranjaHoraria.GMT_MENOS3);
        Empleado lucas = new Empleado("Lucas", "Gomez", 444, "Argentina", "4444", "Rosario", "+54", FranjaHoraria.GMT_MENOS3);
        Empleado sofia = new Empleado("Sofia", "Martinez", 555, "Chile", "5555", "Santiago", "+56", FranjaHoraria.GMT_MENOS4);
        Empleado carlos = new Empleado("Carlos", "Fernandez", 666, "Brasil", "6666", "Rio de Janeiro", "+55", FranjaHoraria.GMT_MENOS3);

        empresa.agregarEmpleado(ana);
        empresa.agregarEmpleado(juan);
        empresa.agregarEmpleado(maria);
        empresa.agregarEmpleado(lucas);
        empresa.agregarEmpleado(sofia);
        empresa.agregarEmpleado(carlos);

        // Ana llama a Juan. Como ambos son de Argentina, se crea una LlamadaLocal.
        empresa.registrarLlamada(ana, "2222", 5);

        // Ana llama a Maria. Como son de paises distintos, se crea una LlamadaInternacional.
        empresa.registrarLlamada(ana, "3333", 3);

        // Juan llama a Sofia -> llamada internacional
        empresa.registrarLlamada(juan, "5555", 7);

        // Sofia llama a Carlos -> llamada internacional
        empresa.registrarLlamada(sofia, "6666", 4);

        // Carlos llama a Maria -> llamada internacional
        empresa.registrarLlamada(carlos, "3333", 8);

        // Maria llama a Lucas -> llamada internacional
        empresa.registrarLlamada(maria, "4444", 6);

        // No se registra porque el numero no pertenece a ningun empleado cargado.
        boolean seRegistro = empresa.registrarLlamada(ana, "9999", 10);
        System.out.println("Se registro la llamada al 9999? " + seRegistro);
        System.out.println();

        empresa.mostrarTodasLasLlamadas();
        empresa.mostrarLlamadasDe(ana);

        empresa.mostrarRankingEmpleadosQueMasTiempoLlamaronAlExterior();
    }
}
