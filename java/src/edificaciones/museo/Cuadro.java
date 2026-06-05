package edificaciones.museo;

import personas.Persona;

public class Cuadro {
    String titulo;
    Persona pintor;
    int aniodecreacion;
    EstadoDeConservacion estadodeconservacion;

    public Cuadro(String titulo, Persona pintor, int aniodecreacion, EstadoDeConservacion estadodeconservacion) {
        this.titulo = titulo;
        this.pintor = pintor;
        this.aniodecreacion = aniodecreacion;
        this.estadodeconservacion = estadodeconservacion;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String t) {
        titulo = t;
    }
    public Persona getPintor() {
        return pintor;
    }
    public void setPintor(Persona p) {
        pintor = p;
    }
    public int getAniodecreacion() {
        return aniodecreacion;
    }
    public void setAniodecreacion(int a) {
        if(a >=0){
            aniodecreacion = a;
        }
    }
    public EstadoDeConservacion getEstadodeconservacion() {
        return estadodeconservacion;
    }
    public void setEstadodeconservacion(EstadoDeConservacion a) {
        estadodeconservacion = a;
    }

}
