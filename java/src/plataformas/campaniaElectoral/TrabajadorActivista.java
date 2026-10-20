package plataformas.campaniaElectoral;

import personas.Persona;
import utils.Fecha;

public class TrabajadorActivista extends Persona implements Activista{
    private float sueldo;
    private String cuil;

    public TrabajadorActivista(String nombre, String apellido, String direccion, Fecha fechan, int dni, float sueldo, String cuil) {
        super(nombre, apellido, direccion, fechan, dni);
        this.sueldo = sueldo;
        this.cuil = cuil;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }


    @Override
    public void enviarMensaje(String msj) {
        System.out.println("Yo, "+getNombreCompleto()+" te invito a que "+msj);
    }
}
