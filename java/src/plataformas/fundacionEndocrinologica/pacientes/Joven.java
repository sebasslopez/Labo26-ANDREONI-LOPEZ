package plataformas.fundacionEndocrinologica.pacientes;

import plataformas.fundacionEndocrinologica.TipoDeSangre;
import utils.Fecha;

import java.util.HashSet;

public class Joven extends Paciente{

     static int edadmin=20;
     static int edadmax=30;
     private HashSet<String> actdep;

    public Joven(String nombre, String apellido, Fecha f, String genero, TipoDeSangre tipodesangre, HashSet<String> actdep) {
        super(nombre, apellido, f, genero, tipodesangre);
        this.actdep = actdep;
    }

    public static int getEdadmax() {
        return edadmax;
    }

    public static void setEdadmax(int edadmax) {
        Joven.edadmax = edadmax;
    }

    public static int getEdadmin() {
        return edadmin;
    }

    public static void setEdadmin(int edadmin) {
        Joven.edadmin = edadmin;
    }

    public HashSet<String> getActdep() {
        return actdep;
    }

    public void setActdep(HashSet<String> actdep) {
        this.actdep = actdep;
    }
}
