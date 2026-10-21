package plataformas.sistemaArcoYFlecha.beneficios;

public abstract class Beneficio {
    private String nombre;
    private String creador;

    public Beneficio(String nombre, String creador) {
        this.nombre = nombre;
        this.creador = creador;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
