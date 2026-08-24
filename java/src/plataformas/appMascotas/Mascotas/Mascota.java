package plataformas.appMascotas.Mascotas;

import personas.Persona;

public abstract class Mascota {
    private String nombre;
    private Persona dueno;
    private int alegria;

    public Mascota(String nombre,Persona dueno){
        this.dueno = dueno;
        this.nombre = nombre;
    }
    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueno) {
        this.dueno = dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void saludar(String dueno){
        for(int i = 0;i<alegria;i++){
            System.out.println(esSuDueño(dueno)? getSonido() : getSonido().toUpperCase()+"!" );
        }
        if(alegria > 1){
            alegria--;
        }
    }

    public boolean esDeEseTipo(TipoMascota tipo) {
        return tipo.equals(getTipo());
    }

    public boolean esSuDueño(String nombre){
        return dueno.getNombre().equalsIgnoreCase(nombre);
    }

    public boolean tieneEseNombre(String nombre){
        return this.nombre.equalsIgnoreCase(nombre);
    }

    public String getSonido() {
        return getTipo().getSonido();
    }

    public abstract TipoMascota getTipo();

    public boolean hayQueEliminar(){
        return false;
    }

    public void alimentar(){
        alegria++;
    }

}
