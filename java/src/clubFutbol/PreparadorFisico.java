package clubFutbol;

import utils.Fecha;

public class PreparadorFisico extends IntegranteTecnico {
    private String especialidad;
    private boolean matricula;

    public PreparadorFisico(String nombre, String apellido, Fecha f, String titulo, int experiencia, String especialidad, boolean matricula) {
        super(nombre, apellido, f, titulo, experiencia);
        this.especialidad = especialidad;
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isMatricula() {
        return matricula;
    }

    public void setMatricula(boolean matricula) {
        this.matricula = matricula;
    }

    @Override
    public void contratar(ClubDeFutbol c) throws NoPuedeContratarException {
        super.contratar(c);
        if(!matricula || this.getExperiencia() < 2) throw new NoPuedeContratarException("El preparador Físico no tiene la experiencia necesaria o no tiene la matricula habilitada.");
    }

    @Override
    public void renovar(ClubDeFutbol club) throws NoPuedeRenovarException {
        super.renovar(club);
        if(!matricula) throw new NoPuedeRenovarException("El Preparador Físico no tiene la matricula habilitada");
    }
}
