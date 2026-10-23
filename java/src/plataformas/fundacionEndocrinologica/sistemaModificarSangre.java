package plataformas.fundacionEndocrinologica;

import plataformas.fundacionEndocrinologica.pacientes.Aplicable;
import plataformas.fundacionEndocrinologica.pacientes.Paciente;

import java.util.HashMap;
import java.util.HashSet;

public class sistemaModificarSangre{

    private HashSet<Paciente> pacientes;
    private HashMap<Aplicable, Integer> entratamiento;


    public sistemaModificarSangre(HashSet<Paciente> pacientes, HashMap<Aplicable, Integer> entratamiento) {
        this.pacientes = pacientes;
        this.entratamiento = entratamiento;
    }

    public HashMap<Aplicable, Integer> getEntratamiento() {
        return entratamiento;
    }

    public void setEntratamiento(HashMap<Aplicable, Integer> entratamiento) {
        this.entratamiento = entratamiento;
    }

    public HashSet<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(HashSet<Paciente> pacientes) {
        this.pacientes = pacientes;
    }



    public void agregarPaciente(Paciente p){
        pacientes.add(p);
    }
    public void agregarEntratamiento(Aplicable a){
        entratamiento.put(a,1);
    }
    public int cantNoAplicables (){
        return entratamiento.size()-pacientes.size();
    }


}
