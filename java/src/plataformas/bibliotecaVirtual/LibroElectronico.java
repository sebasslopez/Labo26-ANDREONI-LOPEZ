package plataformas.bibliotecaVirtual;

import edificaciones.biblioteca.Editorial;
import edificaciones.biblioteca.Libro;
import personas.Persona;
import utils.Fecha;

public class LibroElectronico extends Libro {
    public static final int DESCARGAS_INICIALES = 145;

    private Genero genero;
    private String nombreArchivoPdf;
    private int descargasDisponibles;

    public LibroElectronico(String titulo, Autor autor, int isbn, int paginas, Editorial editorial, Fecha fecha, Genero genero, String nombreArchivoPdf){
        super(titulo, autor, isbn, paginas, editorial, fecha);
        this.genero = genero;
        this.nombreArchivoPdf = nombreArchivoPdf;
        this.descargasDisponibles = DESCARGAS_INICIALES;
        autor.agregarLibroALaBibliografia(this);
    }

    public LibroElectronico(String titulo, Autor autor, Editorial editorial, Fecha fecha, Genero genero, String nombreArchivoPdf){
        this(titulo, autor, -1, -1, editorial, fecha, genero, nombreArchivoPdf);
    }

    @Override
    public Autor getAutor(){
        return (Autor) super.getAutor();
    }

    public void setAutor(Autor autor){
        getAutor().quitarLibroDeLaBibliografia(this);
        setAutor((Persona) autor);
        autor.agregarLibroALaBibliografia(this);
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }

    public int getDescargasDisponibles() {
        return descargasDisponibles;
    }

    public void setDescargasDisponibles(int descargasDisponibles) {
        this.descargasDisponibles = descargasDisponibles;
    }

    public boolean tieneDescargasDisponibles(){
        return descargasDisponibles > 0;
    }

    public void registrarDescarga(){
        if (descargasDisponibles > 0){
            descargasDisponibles--;
        }
    }

    public void mostrarInfo(){
        System.out.println("Titulo: " + getTitulo());
        System.out.println("   Autor: " + getAutor());
        System.out.println("   Genero: " + genero);
        System.out.println("   Editorial: " + getEditorial());
        System.out.println("   Archivo pdf: " + nombreArchivoPdf);
        System.out.println("   Descargas disponibles: " + descargasDisponibles);
    }

    @Override
    public String toString() {
        return getTitulo() + " de " + getAutor().getNombre() + " | " + genero + " | descargas disponibles: " + descargasDisponibles;
    }
}
