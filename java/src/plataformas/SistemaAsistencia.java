package plataformas;

import personas.empleados.DiaLaboral;
import personas.empleados.EmpleadoConAsistencia;
import utils.Print;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
        EmpleadoConAsistencia e1 = new EmpleadoConAsistencia("Martina Juana","Andreoni Duchowny","+5491148689685", LocalDate.of(2026,11,7),new HashSet<>(Set.of(DiaLaboral.JUEVES,DiaLaboral.LUNES)));
        EmpleadoConAsistencia e2 = new EmpleadoConAsistencia("Yo","yo","+5491148679685", LocalDate.of(2026,5,7),new HashSet<>(Set.of(DiaLaboral.MIERCOLES,DiaLaboral.VIERNES)));

        SistemaAsistencia s = new SistemaAsistencia();
        s.agregarEmpleado(e1);
        s.agregarEmpleado(e2);

        s.registrarAsistencia(e1,LocalDateTime.of(2026,9,1,15,0));
        s.registrarAsistencia(e1,LocalDateTime.of(2026,9,2,15,5));
        s.registrarAsistencia(e1,LocalDateTime.of(2026,9,3,15,4));
        s.registrarAsistencia(e1,LocalDateTime.of(2026,9,4,15,7));
        s.registrarAsistencia(e2,LocalDateTime.of(2026,9,1,15,2));
        s.registrarAsistencia(e2,LocalDateTime.of(2026,9,2,15,15));
        s.registrarAsistencia(e2,LocalDateTime.of(2026,9,3,15,30));
        s.registrarAsistencia(e2,LocalDateTime.of(2026,9,4,15,2));

        System.out.println(s.obtenerEmpleado(1));

        s.consultarPorcentajeAsistencia(e1,9,2026);

        Print.printArray(s.obtenerEmpleadosCon80PorcientoAsistencia(9,2026));
    }
}
