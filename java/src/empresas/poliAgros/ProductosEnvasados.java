package empresas.poliAgros;

import utils.Fecha;

public class ProductosEnvasados {
    private Fecha fechaven;
    private int nlote;
    private String nombre;
    private int codigo;
    private PaisOG paisog;
    private Fecha fechaenv;


    public ProductosEnvasados(Fecha fechaven, Fecha fechaenv, PaisOG paisog, int codigo, String nombre, int nlote) {
        this.fechaven = fechaven;
        this.fechaenv = fechaenv;
        this.paisog = paisog;
        this.codigo = codigo;
        this.nombre = nombre;
        this.nlote = nlote;
    }

    public Fecha getFechaven() {
        return fechaven;
    }

    public void setFechaven(Fecha fechaven) {
        this.fechaven = fechaven;
    }

    public int getNlote() {
        return nlote;
    }

    public Fecha getFechaenv() {
        return fechaenv;
    }

    public void setFechaenv(Fecha fechaenv) {
        this.fechaenv = fechaenv;
    }

    public void setNlote(int nlote) {
        this.nlote = nlote;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PaisOG getPaisog() {
        return paisog;
    }

    public void setPaisog(PaisOG paisog) {
        this.paisog = paisog;
    }


}
