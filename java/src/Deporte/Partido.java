package Deporte;

public class Partido {

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int dia;
    private String turno;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int dia, String turno) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.dia = dia;
        this.turno = turno;
    }

    public Equipo getEquipoLocal() { return equipoLocal; }
    public Equipo getEquipoVisitante() { return equipoVisitante; }
    public int getDia() { return dia; }
    public String getTurno() { return turno; }

}
