package personas.empleados;

import personas.Persona;

import java.time.LocalDate;

public abstract class Empleado extends Persona {
    private String telefono;

    public Empleado(String nombre, String Apellido, String Telefono, LocalDate date){
        super(nombre,Apellido,date);
        this.telefono = Telefono;
    }

    public Empleado(String nombre,String Apellido,int dni,String pais,String Telefono){
        super(nombre,Apellido,dni,Telefono);
        this.telefono = Telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean tieneTelefono(String telefono) {
        return this.telefono.equals(telefono);
    }
}
