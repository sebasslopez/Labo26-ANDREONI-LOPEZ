package personas.empleados;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

public class EmpleadoConAsistencia extends Empleado{
    private HashSet<DiaLaboral> diasAsiste;
    private HashSet<LocalDateTime> diasAsistidos;

    public EmpleadoConAsistencia(String nombre, String apellido, String telefono, LocalDate date, HashSet<DiaLaboral> diasAsiste){
        super(nombre,apellido,telefono,date);
        this.diasAsiste = diasAsiste;
        diasAsistidos = new HashSet<>();
    }

    public void registrarIngreso(LocalDateTime fecha) {
        diasAsistidos.add(fecha);
    }

    public int porcentajeAsistencia(int mes,int anio){
        return (this.diasAistidos(mes,anio) * 100) / this.getDiasAAsistirAnio();
    }

    private int getDiasAAsistirMes(){
        return diasAsiste.size() * 4;
    }

    private int getDiasAAsistirAnio(){
        return getDiasAAsistirMes() * 12;
    }

    private int diasAistidos(int mes,int anio){
        int contador = 0;
        for(LocalDateTime time : diasAsistidos){
            if(time.getMonthValue() == mes && time.getYear() == anio) contador++;
        }
        return contador;
    }

    public boolean tieneMasDel80Porciento(int mes,int anio){
        return porcentajeAsistencia(mes,anio) > 80;
    }

    @Override
    public String datos() {
        return "";
    }
}
