package gente;

import decoracion.Cuadro;
import fecha.Fecha;

public class Restaurador {
    private String nombre;
    private String apellido;
    private int dni;
    private Fecha fecha;
    private int aniosdeexp;
    public Restaurador(String nombre, String apellido, int dni, int aniosdeexp) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.aniosdeexp = aniosdeexp;
    }
    public void restaurar(Cuadro c){
        Cuadro antes = c;
        if(c.getAniodecreacion() > 25){
            if(c.getEstadodeconservacion() + 2 > 10) c.setEstadodeconservacion(10);
            else c.setEstadodeconservacion(c.getEstadodeconservacion() + 2);
        }
        else{
            if(c.getEstadodeconservacion() + 3 > 10) c.setEstadodeconservacion(10);
            else c.setEstadodeconservacion(c.getEstadodeconservacion() + 3);
        }
        System.out.println("Antes: Titulo: "+antes.getTitulo()+" Pintor: "+antes.getPintor().datos()+" Año de creación: "+antes.getAniodecreacion()+" Estado de conservación: "+antes.getEstadodeconservacion());
        System.out.println("Ahora: Titulo: "+c.getTitulo()+" Pintor: "+c.getPintor().datos()+" Año de creación: "+c.getAniodecreacion()+" Estado de conservación: "+c.getEstadodeconservacion());
    }
}
