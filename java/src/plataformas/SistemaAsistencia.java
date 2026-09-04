package plataformas;

import personas.empleados.EmpleadoConAsistencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class SistemaAsistencia {
    private HashMap<Integer, EmpleadoConAsistencia> empleados;

    public SistemaAsistencia(){
        empleados = new HashMap<>();
    }

    public void agregarEmpleado(EmpleadoConAsistencia e){
        empleados.put(empleados.size()+1,e);
    }

    public void registrarAsistencia(EmpleadoConAsistencia e,LocalDateTime date){
        e.registrarIngreso(date);
    }

    public EmpleadoConAsistencia obtenerEmpleado(int legajo){
        return empleados.get(legajo);
    }

    public void consultarPorcentajeAsistencia(EmpleadoConAsistencia e, int mes, int anio){
        System.out.println("Asistencia en el "+mes+"/"+anio+" : " + e.porcentajeAsistencia(mes,anio));
    }

    public ArrayList<EmpleadoConAsistencia> obtenerEmpleadosCon80PorcientoAsistencia(int mes, int anio){
        ArrayList<EmpleadoConAsistencia> ems = new ArrayList<>();
        for(EmpleadoConAsistencia e : empleados.values()){
            if(e.tieneMasDel80Porciento(mes,anio)) ems.add(e);
        }
        return ems;
    }

    static void main(String[] args){

    }
}
