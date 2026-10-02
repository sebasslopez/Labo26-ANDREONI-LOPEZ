package bibliotecaVirtual;

public class LibroElectronico {
    public static final int DESCARGAS_INICIALES = 145;

    private String titulo;
    private Autor autor;
    private Genero genero;
    private String nombreArchivoPdf;
    private int descargasDisponibles;

    public LibroElectronico(String titulo, Autor autor, Genero genero, String nombreArchivoPdf){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.nombreArchivoPdf = nombreArchivoPdf;
        this.descargasDisponibles = DESCARGAS_INICIALES;
        autor.agregarLibroALaBibliografia(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor.quitarLibroDeLaBibliografia(this);
        this.autor = autor;
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
        System.out.println("Titulo: " + titulo);
        System.out.println("   Autor: " + autor);
        System.out.println("   Genero: " + genero);
        System.out.println("   Archivo pdf: " + nombreArchivoPdf);
        System.out.println("   Descargas disponibles: " + descargasDisponibles);
    }

    @Override
    public String toString() {
        return titulo + " de " + autor.getNombre() + " | " + genero + " | descargas disponibles: " + descargasDisponibles;
    }
}
