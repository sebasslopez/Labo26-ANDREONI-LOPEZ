package plataformas.prestamos.materialLectura;

import utils.Fecha;

public class Material_de_lectura {
    private String titulo;
    private int isbn;
    private Fecha fecha;

    public Material_de_lectura(String titulo, Fecha fecha, int isbn) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
