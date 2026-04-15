package colegio;

import gente.Alumno;

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
    public int promedioEdad(){
        int total = 0;
        for(Alumno a : alumnos){

        }
    }
}