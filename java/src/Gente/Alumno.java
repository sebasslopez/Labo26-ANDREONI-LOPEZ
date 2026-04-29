package Gente;

import Colegio.Materia;
import Utils.Fecha;

import java.util.ArrayList;

public class Alumno extends Persona {
    private ArrayList<Integer> notas;
    private ArrayList<Materia> materias;

    public Alumno(String nombre, String apellido, Fecha fechan){
        super(nombre,apellido,fechan);
        this.notas=new ArrayList<>();
        this.materias=new ArrayList<>();
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    public ArrayList<Materia> getMaterias() {
        return this.materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public void agregar(int nota){
        notas.add(nota);
    }
    public boolean menor(int nota, int posicion){
        if(nota < notas.get(posicion)){
            return true;
        }else return false;
    }
    public boolean mayor(int nota, int posicion){
        if(nota > notas.get(posicion)){
            return true;
        }else return false;
    }
    public void agregarMateria(Materia m){
        if(!materias.contains(m)) this.materias.add(m);
    }
}
