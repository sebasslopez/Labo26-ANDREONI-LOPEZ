import gente.Alumno;

import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<String> contenidos;
    private Alumno alumnos;

    public Materia(String nombre, Alumno alumnos){
        this.nombre=nombre;
        this.alumnos=alumnos;
        this.contenidos=new ArrayList<>();
    }
}
