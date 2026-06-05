package deporte;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int dia;
    private Turno turno;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int dia, Turno turno) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.dia = dia;
        this.turno = turno;
    }

    public Equipo getEquipoLocal() { return equipoLocal; }
    public Equipo getEquipoVisitante() { return equipoVisitante; }
    public int getDia() { return dia; }
    public Turno getTurno() { return turno; }
    public String mostrarPartido(){
        return "Equipo Local: "+equipoLocal.getNombre()+", Equipo Visitante: "+equipoVisitante.getNombre()+", Dia: "+dia+", Turno: "+turno.name();
    }
}
