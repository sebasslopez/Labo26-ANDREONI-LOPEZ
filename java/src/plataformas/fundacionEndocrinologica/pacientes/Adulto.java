package plataformas.fundacionEndocrinologica.pacientes;

import plataformas.fundacionEndocrinologica.TipoDeSangre;
import utils.Fecha;

public class Adulto extends Paciente{
    public Adulto(String nombre, String apellido, Fecha f, String genero, TipoDeSangre tipodesangre) {
        super(nombre, apellido, f, genero, tipodesangre);
    }
}
