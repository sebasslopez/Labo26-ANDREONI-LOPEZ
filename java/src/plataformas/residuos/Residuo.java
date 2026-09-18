package plataformas.residuos;

public class Residuo {
    private String nombre;
    private boolean reciclable;
    private String descripcion;
    static int peso = 8;

    public Residuo(String nombre, boolean reciclable, String descripcion) {
        this.nombre = nombre;
        this.reciclable = reciclable;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isReciclable() {
        return reciclable;
    }

    public void setReciclable(boolean reciclable) {
        this.reciclable = reciclable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean esDelMismoTipo(Residuo r){
        return r.getNombre().equalsIgnoreCase(this.nombre);
    }
}
