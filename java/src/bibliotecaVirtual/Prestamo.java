package bibliotecaVirtual;

import utils.Fecha;

public class Prestamo {
    private Usuario usuario;
    private LibroElectronico libro;
    private Fecha fechaPrestamo;
    private boolean devuelto;

    public Prestamo(Usuario usuario, LibroElectronico libro, Fecha fechaPrestamo){
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LibroElectronico getLibro() {
        return libro;
    }

    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public boolean esActivo(){
        return !devuelto;
    }

    public void marcarComoDevuelto(){
        this.devuelto = true;
    }

    @Override
    public String toString() {
        return libro.getTitulo() + " (" + fechaPrestamo.corta() + ")" + (devuelto ? " - devuelto" : " - activo");
    }
}
