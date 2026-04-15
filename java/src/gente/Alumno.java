package gente;

import fecha.Fecha;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String apellido;
    private Fecha fechan;
    private ArrayList<Integer> notas;
    private ArrayList<Materia> materias;

    public Alumno(String nombre, String apellido, Fecha fechan){
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechan=fechan;
        this.notas=new ArrayList<>();
        this.materias=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    public Fecha getFechan() {
        return fechan;
    }

    public void setFechan(Fecha fechan) {
        this.fechan = fechan;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<String> getMaterias() {
        return materias;
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
}
