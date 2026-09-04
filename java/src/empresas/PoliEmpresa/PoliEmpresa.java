package empresas.PoliEmpresa;

import empresas.Empresa;
import empresas.PoliEmpresa.llamada.FranjaHoraria;
import empresas.PoliEmpresa.llamada.Llamada;
import empresas.PoliEmpresa.llamada.LlamadaInternacional;
import empresas.PoliEmpresa.llamada.LlamadaLocal;
import personas.empleados.EmpleadoSinAsistencia;
import transporte.Bicicleta;
import transporte.Camion;
import transporte.Coche;
import transporte.Vehiculo;

import java.util.ArrayList;

public class PoliEmpresa extends Empresa {
    private ArrayList<Vehiculo> vehiculo;
    private ArrayList<EmpleadoSinAsistencia> empleados;
    private ArrayList<Llamada> llamadas;

    public PoliEmpresa(ArrayList<Vehiculo> vehiculo, ArrayList<EmpleadoSinAsistencia> empleados) {
        super("PoliEmpresa");
        this.vehiculo = vehiculo;
        this.empleados = empleados;
        this.llamadas = new ArrayList<>();
    }

    public PoliEmpresa(String nombre) {
       super(nombre);
        this.empleados = new ArrayList<>();
        this.llamadas = new ArrayList<>();
        this.vehiculo = new ArrayList<>();
    }

    public PoliEmpresa(){
        super("PoliEmpresa");
        this.vehiculo = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.llamadas = new ArrayList<>();
    }

    public ArrayList<EmpleadoSinAsistencia> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<EmpleadoSinAsistencia> empleados) {
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

    public boolean agregarEmpleado(EmpleadoSinAsistencia empleado) {
        if (existeDni(empleado.getDni()) || existeTelefono(empleado.getTelefono())) {
            return false;
        }
        empleados.add(empleado);
        return true;
    }

    public boolean registrarLlamada(EmpleadoSinAsistencia origen, String telefonoDestino, int duracionMinutos) {
        if (origen == null || telefonoDestino == null || duracionMinutos <= 0) {
            return false;
        }

        if (!existeEmpleado(origen)) {
            return false;
        }

        EmpleadoSinAsistencia destino = buscarEmpleadoPorTelefono(telefonoDestino);

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

    public Llamada crearLlamada(EmpleadoSinAsistencia origen, EmpleadoSinAsistencia destino, int duracionMinutos) {
        if (origen.viveEnElMismoPaisQue(destino)) {
            return new LlamadaLocal(origen, destino, duracionMinutos);
        }

        return new LlamadaInternacional(origen, destino, duracionMinutos);
    }

    public ArrayList<Llamada> obtenerLlamadasDe(EmpleadoSinAsistencia empleado) {
        ArrayList<Llamada> llamadasDelEmpleado = new ArrayList<>();

        for (Llamada llamada : llamadas) {
            if (llamada.fueRealizadaPor(empleado)) {
                llamadasDelEmpleado.add(llamada);
            }
        }
        return llamadasDelEmpleado;
    }

    public void mostrarRankingEmpleadosQueMasTiempoLlamaronAlExterior() {
        ArrayList<EmpleadoSinAsistencia> empleadosRanking = new ArrayList<>();
        ArrayList<Integer> minutosRanking = new ArrayList<>();

        cargarMinutosAlExterior(empleadosRanking, minutosRanking);

        if (empleadosRanking.isEmpty()) {
            System.out.println("No se registraron llamadas al exterior.");
            return;
        }

        ordenarRankingPorMinutosDescendente(empleadosRanking, minutosRanking);
        imprimirRankingExterior(empleadosRanking, minutosRanking);
    }

    public void cargarMinutosAlExterior(ArrayList<EmpleadoSinAsistencia> empleadosRanking,
                                        ArrayList<Integer> minutosRanking) {

        for (EmpleadoSinAsistencia empleado : empleados) {
            int minutos = calcularMinutosAlExteriorDe(empleado);

            if (minutos > 0) {
                empleadosRanking.add(empleado);
                minutosRanking.add(minutos);
            }
        }
    }
    public int calcularMinutosAlExteriorDe(EmpleadoSinAsistencia empleado) {
        int total = 0;

        for (Llamada llamada : llamadas) {

            total = total + llamada.obtenerMinutosAlExteriorDe(empleado);
        }

        return total;
    }

    public void ordenarRankingPorMinutosDescendente(ArrayList<EmpleadoSinAsistencia> empleadosRanking,
                                                    ArrayList<Integer> minutosRanking) {
        //TODO: Teniendo en cuenta los dos arreglos,
        // ordenar desde el empleado que tiene mayor cantidad de minutos
        // al exterior al menor.

        boolean ordenado = false;
        while (!ordenado) {
            ordenado = true;
            for(int i = 1; i < minutosRanking.size(); i++) {
                if (minutosRanking.get(i-1) < minutosRanking.get(i)) {
                    EmpleadoSinAsistencia aux = empleadosRanking.get(i-1);
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

    private void imprimirRankingExterior(ArrayList<EmpleadoSinAsistencia> empleadosRanking,
                                         ArrayList<Integer> minutosRanking) {

        System.out.println("Ranking de empleados que mas tiempo llamaron al exterior:");
        //TODO: Mostrar el ranking ordenado concatenando el empleado con los minutos
        for (EmpleadoSinAsistencia empleado : empleadosRanking) {
            System.out.println("Empleado: " + empleado.getNombreCompleto() + ", Minutos: " + minutosRanking.get(empleadosRanking.indexOf(empleado)));
        }
    }

    public void mostrarLlamadasDe(EmpleadoSinAsistencia empleado) {
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
        for(EmpleadoSinAsistencia empleado : empleados){
            mostrarLlamadasDe(empleado);
        }
    }

    public boolean existeEmpleado(EmpleadoSinAsistencia empleado) {
        for (EmpleadoSinAsistencia empleadoActual : empleados) {
            if (empleadoActual.tieneMismoDniQue(empleado.getDni())) {
                return true;
            }
        }

        return false;
    }

    public boolean existeDni(int dni) {
        for (EmpleadoSinAsistencia empleado : empleados) {
            if (empleado.tieneMismoDniQue(dni)) {
                return true;
            }
        }

        return false;
    }

    public boolean existeTelefono(String telefono) {
        return buscarEmpleadoPorTelefono(telefono) != null;
    }

    public EmpleadoSinAsistencia buscarEmpleadoPorTelefono(String telefono) {
        for (EmpleadoSinAsistencia empleado : empleados) {
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
        PoliEmpresa poliEmpresa = new PoliEmpresa("IPM Sistemas");

        EmpleadoSinAsistencia ana = new EmpleadoSinAsistencia("Ana", "Lopez", 111, "Argentina", "1111", "Buenos Aires", "+54", FranjaHoraria.GMT_MENOS3);
        EmpleadoSinAsistencia juan = new EmpleadoSinAsistencia("Juan", "Perez", 222, "Argentina", "2222", "Cordoba", "+54", FranjaHoraria.GMT_MENOS3);
        EmpleadoSinAsistencia maria = new EmpleadoSinAsistencia("Maria", "Silva", 333, "Uruguay", "3333", "Montevideo", "+598", FranjaHoraria.GMT_MENOS3);
        EmpleadoSinAsistencia lucas = new EmpleadoSinAsistencia("Lucas", "Gomez", 444, "Argentina", "4444", "Rosario", "+54", FranjaHoraria.GMT_MENOS3);
        EmpleadoSinAsistencia sofia = new EmpleadoSinAsistencia("Sofia", "Martinez", 555, "Chile", "5555", "Santiago", "+56", FranjaHoraria.GMT_MENOS4);
        EmpleadoSinAsistencia carlos = new EmpleadoSinAsistencia("Carlos", "Fernandez", 666, "Brasil", "6666", "Rio de Janeiro", "+55", FranjaHoraria.GMT_MENOS3);

        poliEmpresa.agregarEmpleado(ana);
        poliEmpresa.agregarEmpleado(juan);
        poliEmpresa.agregarEmpleado(maria);
        poliEmpresa.agregarEmpleado(lucas);
        poliEmpresa.agregarEmpleado(sofia);
        poliEmpresa.agregarEmpleado(carlos);

        // Ana llama a Juan. Como ambos son de Argentina, se crea una LlamadaLocal.
        poliEmpresa.registrarLlamada(ana, "2222", 5);

        // Ana llama a Maria. Como son de paises distintos, se crea una LlamadaInternacional.
        poliEmpresa.registrarLlamada(ana, "3333", 3);

        // Juan llama a Sofia -> llamada internacional
        poliEmpresa.registrarLlamada(juan, "5555", 7);

        // Sofia llama a Carlos -> llamada internacional
        poliEmpresa.registrarLlamada(sofia, "6666", 4);

        // Carlos llama a Maria -> llamada internacional
        poliEmpresa.registrarLlamada(carlos, "3333", 8);

        // Maria llama a Lucas -> llamada internacional
        poliEmpresa.registrarLlamada(maria, "4444", 6);

        // No se registra porque el numero no pertenece a ningun empleado cargado.
        boolean seRegistro = poliEmpresa.registrarLlamada(ana, "9999", 10);
        System.out.println("Se registro la llamada al 9999? " + seRegistro);
        System.out.println();

        poliEmpresa.mostrarTodasLasLlamadas();
        poliEmpresa.mostrarLlamadasDe(ana);

        poliEmpresa.mostrarRankingEmpleadosQueMasTiempoLlamaronAlExterior();
    }
}
