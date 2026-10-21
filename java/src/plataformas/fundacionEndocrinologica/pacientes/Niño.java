package plataformas.fundacionEndocrinologica.pacientes;

import plataformas.fundacionEndocrinologica.TipoDeSangre;
import utils.Fecha;

public class Niño extends Paciente{
    private NivelDeTolerancia nivel;

    public Niño(String nombre, String apellido, Fecha f, String genero, TipoDeSangre tipodesangre, NivelDeTolerancia nivel) {
        super(nombre, apellido, f, genero, tipodesangre);
        this.nivel = nivel;
    }

    public NivelDeTolerancia getNivel() {
        return nivel;
    }

    public void setNivel(NivelDeTolerancia nivel) {
        this.nivel = nivel;
    }

}
