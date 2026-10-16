package clubFutbol;

import utils.Fecha;

public class Arquero extends JugadorFutbol {
    private float porcentajeAtajadas;
    private int cantGoles;
    public Arquero(String nombre, String apellido, Fecha date, int numCamiseta, String provincia,float por,int goles) {
        super(nombre, apellido, date, numCamiseta, Posicion.ARQUERO, provincia);
        this.porcentajeAtajadas = por;
        this.cantGoles = goles;
    }

    public float getPorcentajeAtajadas() {
        return porcentajeAtajadas;
    }

    public void setPorcentajeAtajadas(float porcentajeAtajadas) {
        this.porcentajeAtajadas = porcentajeAtajadas;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    @Override
    public void contratar(ClubDeFutbol c) throws NoPuedeContratarException {
        super.contratar(c);
        if(porcentajeAtajadas <= 60 || cantGoles >= 10) throw new NoPuedeContratarException("El porcentaje de atajadas es menor a 60 o la cantidad de goles en la ultima temporada es mayor a 10");
    }
}
