package practica_examen;
import practica_examen.CohereM;

public class Tecnicos {
    private String nombre;
    private String apellido;
    private int fn;
    private String especialidad;
    private CohereM coheteasig;

    public Tecnicos(String nombre, String apellido, int fn, String especialidad, CohereM coheteasig) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fn = fn;
        this.especialidad = especialidad;
        this.coheteasig = coheteasig;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getFn() {
        return fn;
    }

    public void setFn(int fn) {
        this.fn = fn;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public CohereM getCoheteasig() {
        return coheteasig;
    }

    public void setCoheteasig(CohereM coheteasig) {
        this.coheteasig = coheteasig;
    }

    public void activarp(int cant){
        System.out.println("activar propulsores");
        coheteasig.activar(cant);
    }

    public boolean cambioC (CohereM nuevoCohete){
        if(estaCap(nuevoCohete)){
            this.coheteasig=nuevoCohete;
            return true;
        }
        return false;
    }

    public boolean estaCap(CohereM cohete){
        switch (especialidad) {
            case "Propulsión":
                return cohete.getPropulsores() >= 4;
            case "Navegación":
                return cohete.getVelmax() > 28000;
            case "Estructura":
                return cohete.getLargo() > 70;
            default:
                return false;
        }
    }
}

