package plataformas.fundacionEndocrinologica.pacientes;

import plataformas.fundacionEndocrinologica.TipoDeSangre;
import utils.Fecha;

import java.util.HashSet;

public class Joven extends Paciente implements Aplicable{

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

    public boolean cantdep(){
        if(actdep.size()%2==0){
            return true;
        }
        return false;
    }

    public boolean tiempocat(){
        if((edadmax-getEdad())<=2){
            return false;
        }
        return true;
    }
    @Override
    public void aplicable() {
        if(!tiempocat() && !cantdep() ){
            System.out.println("Lamentamos comunicarte que tu sangre aun no va a poder ser modificada");
        }else{
            System.out.println("Sera un tratamiento costoso, pero lo vamos a lograr");
        }
    }

    @Override
    public int costoTratamiento() {
      if((getFechan().getYear()%2)==0){
            return getFechan().getDia()*145400;
        }
      return getFechan().getMes()*760000;
    }

    @Override
    public String getTipoDeSangre() {
        return "";
    }


}
