package plataformas.fundacionEndocrinologica.pacientes;

import plataformas.fundacionEndocrinologica.TipoDeSangre;
import utils.Fecha;

public class Niño extends Paciente implements Aplicable{
    private int niveltolerancia;

    public Niño(String nombre, String apellido, Fecha f, String genero, TipoDeSangre tipodesangre, int niveltolerancia) {
        super(nombre, apellido, f, genero, tipodesangre);
        this.niveltolerancia = niveltolerancia;
    }

    public int getNiveltolerancia() {
        return niveltolerancia;
    }

    public void setNiveltolerancia(int niveltolerancia) {
        this.niveltolerancia = niveltolerancia;
    }

    @Override
    public void aplicable() {
        if(getEdad()>3){
            System.out.println("Tu tratamiento tardara esta cantidad de dias: "+(niveltolerancia*2));
        }else{
            System.out.println("Aun es chico para probar el tratamiento");
        }
    }

    @Override
    public int costoTratamiento() {
        return niveltolerancia*450000;
    }

    @Override
    public String getTipoDeSangre() {
        return "";
    }

}
