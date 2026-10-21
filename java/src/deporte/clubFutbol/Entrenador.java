package deporte.clubFutbol;

import utils.Fecha;

public class Entrenador extends IntegranteTecnico{
    private int cantCampeonatos;
    private boolean licenciaVigente;
    public Entrenador(String nombre, String apellido, Fecha f, String titulo, int experiencia) {
        super(nombre, apellido, f, titulo, experiencia);
    }

    public int getCantCampeonatos() {
        return cantCampeonatos;
    }

    public void setCantCampeonatos(int cantCampeonatos) {
        this.cantCampeonatos = cantCampeonatos;
    }

    public boolean isLicenciaVigente() {
        return licenciaVigente;
    }

    public void setLicenciaVigente(boolean licenciaVigente) {
        this.licenciaVigente = licenciaVigente;
    }

    @Override
    public void contratar(ClubDeFutbol c) throws NoPuedeContratarException {
        super.contratar(c);
        if(!licenciaVigente || this.getExperiencia() < 3) throw new NoPuedeContratarException("El entrenador no tiene la experiencia necesaria o no tiene la licencia vigente.");
    }

    @Override
    public void renovar(ClubDeFutbol club) throws NoPuedeRenovarException {
        super.renovar(club);
        if(!licenciaVigente) throw new NoPuedeRenovarException("El Entrenador no tiene la licencia vigente");
    }
}
