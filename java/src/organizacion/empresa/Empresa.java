package organizacion.empresa;

import organizacion.empresa.sistemaLlamada.SistemaLlamadas;
import personas.Empleado;
import transporte.Bicicleta;
import transporte.Camion;
import transporte.Coche;
import transporte.Vehiculo;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Vehiculo> vehiculo;
    private ArrayList<Empleado> empleados;
    private SistemaLlamadas sistema;


    public Empresa(ArrayList<Vehiculo> vehiculo, ArrayList<Empleado> empleados) {
        this.vehiculo = vehiculo;
        this.empleados = empleados;
    }
    public Empresa(){
        this.empleados = new ArrayList<>();
        this.vehiculo = new ArrayList<>();
        this.sistema = new SistemaLlamadas();
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

    public SistemaLlamadas getSistema() {
        return sistema;
    }

    public void setSistema(SistemaLlamadas sistema) {
        this.sistema = sistema;
    }

    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }
}
