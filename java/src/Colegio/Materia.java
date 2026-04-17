package Colegio;

import Gente.Alumno;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<String> contenidos;
    private ArrayList<Alumno> alumnos;

    public Materia(String nombre){
        this.nombre=nombre;
        this.alumnos=new ArrayList<>();
        this.contenidos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getContenidos() {
        return contenidos;
    }

    public void setContenidos(ArrayList<String> contenidos) {
        this.contenidos = contenidos;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public int promedioEdad(){
        int total = 0;
        for(int i=0; i<alumnos.size();i++){
            total+=(Period.between(LocalDate.of(alumnos.get(i).getFechan().getYear(),alumnos.get(i).getFechan().getMes(),alumnos.get(i).getFechan().getDia()), LocalDate.now()).getYears());
        }
        return total/alumnos.size();
    }
    public int promedioNotas(){
        int total = 0;
        int contador = 0;
        for (int j = 0; j<alumnos.size();j++){
            for(int i =0;i<alumnos.get(j).getNotas().size();i++){
                total += alumnos.get(j).getNotas().get(i);
                contador++;
            }
        }
        return total/contador;
    }
    public void agregarAlumno(Alumno a){
        if(alumnos.contains(a)) return;
        this.alumnos.add(a);
        ArrayList<Materia> m = a.getMaterias();
        m.add(this);
        a.setMaterias(m);
    }
    public void anadirContenido(String contenido){
        this.contenidos.add(contenido);
    }
    public void listarAlumnos(){
        for(Alumno a : alumnos){
            System.out.println("Nombre: "+a.getNombre()+"Apellido: "+a.getApellido());
        }
    }
}