package plataformas.fundacionEndocrinologica.pacientes;

import personas.Persona;
import plataformas.fundacionEndocrinologica.TipoDeSangre;
import utils.Fecha;

public abstract class Paciente extends Persona {
    private String genero;
    private TipoDeSangre tipodesangre;

    public Paciente(String nombre, String apellido, Fecha f, String genero, TipoDeSangre tipodesangre) {
        super(nombre, apellido, f);
        this.genero = genero;
        this.tipodesangre = tipodesangre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public TipoDeSangre getTipodesangre() {
        return tipodesangre;
    }

    public void setTipodesangre(TipoDeSangre tipodesangre) {
        this.tipodesangre = tipodesangre;
    }

}
