package deporte.clubFutbol;

import utils.Fecha;

public class JugadorDeCampo extends JugadorFutbol {
   private float porcentajeGolesConvertidos;
   private int asistenciasRealizadas;

    public JugadorDeCampo(String nombre, String apellido, Fecha date, int numCamiseta,Posicion pos, String provincia,float por,int asis) {
        super(nombre, apellido, date, numCamiseta, pos, provincia);
        this.porcentajeGolesConvertidos= por;
        this.asistenciasRealizadas = asis;
    }

    public float getPorcentajeGolesConvertidos() {
        return porcentajeGolesConvertidos;
    }

    public void setPorcentajeGolesConvertidos(float porcentajeGolesConvertidos) {
        this.porcentajeGolesConvertidos = porcentajeGolesConvertidos;
    }

    public int getAsistenciasRealizadas() {
        return asistenciasRealizadas;
    }

    public void setAsistenciasRealizadas(int asistenciasRealizadas) {
        this.asistenciasRealizadas = asistenciasRealizadas;
    }

    @Override
    public void contratar(ClubDeFutbol c) throws NoPuedeContratarException {
        super.contratar(c);
        if(porcentajeGolesConvertidos <= 30 || asistenciasRealizadas <= 10) throw new NoPuedeContratarException("El porcentaje de atajadas es menor a 60 o la cantidad de goles en la ultima temporada es mayor a 10");
    }

}
