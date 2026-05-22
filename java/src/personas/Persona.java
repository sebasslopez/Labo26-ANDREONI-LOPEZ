package personas;

import utils.Fecha;

public class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private Fecha fechan;
    private int dni;
    private String pais;



    public Persona(String nombre, String apellido, int dni, Fecha fechan) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechan = fechan;
    }

    public Persona(String nombre, String apellido, int dni, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.pais = pais;
    }

    public Persona(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Persona(String nombre, String apellido, String direccion, Fecha fechan, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechan = fechan;
        this.dni = dni;
    }

    public Persona(String nombre, String apellido, Fecha f) {
        this.nombre = nombre;
        this.fechan = f;
        this.apellido = apellido;
        this.direccion="Leandro N Alem 7866";
        this.dni = 49439226;
    }
    public Persona(String nombre, String apellido,Fecha f,String direccion) {
        this.nombre = nombre;
        this.fechan = f;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = 49439226;
    }
    public Persona(String nombre,String apellido){
        this.apellido=apellido;
        this.nombre=nombre;
        this.fechan= new Fecha();
        this.direccion="Leandro N Alem 7866";
        this.dni = 49439226;
    }
    public Persona(){
        this.apellido="Barbieri";
        this.nombre="Martín";
        this.fechan= new Fecha();
        this.direccion="Leandro N Alem 7866";
        this.dni = 49439226;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return fechan.tiempoEntreFechaFin(new Fecha()).getYear();
    }

    public void setFechan(Fecha f) {
        this.fechan = f;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Fecha getFechan() {
        return fechan;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String datos() {
        return "Nombre:" + nombre + " " + apellido + " Edad:" + getEdad() + " Dirección:" + direccion +" DNI: "+dni;
    }

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

    public boolean tieneMismoDniQue(int dni) {
        return this.dni == dni;
    }

    public boolean viveEnElMismoPaisQue(Persona otraPersona) {
        return this.pais.equalsIgnoreCase(otraPersona.getPais());
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Raquel", "Constituyentes 5848",new Fecha() );
        System.out.println(persona.datos());

    }
}

