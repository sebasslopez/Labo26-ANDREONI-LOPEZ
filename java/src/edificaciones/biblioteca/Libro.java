package edificaciones.biblioteca;

import plataformas.prestamos.Prestable;
import plataformas.prestamos.materialLectura.Material_de_lectura;
import utils.Fecha;
import personas.Persona;

public class  Libro extends Material_de_lectura implements Prestable {
    private Persona autor;
    private int paginasxcap;
    private Editorial editorial;
    private int capstotales;


    public Libro(String titulo, Fecha fecha, int isbn, Persona autor, int paginasxcap, Editorial editorial) {
        super(titulo, fecha, isbn);
        this.autor = autor;
        this.paginasxcap = paginasxcap;
        this.editorial = editorial;
    }

    public Libro(String titulo, Fecha fecha, int isbn, Editorial editorial, int paginasxcap, Persona autor) {
        super(titulo, fecha, isbn);
        this.editorial = editorial;
        this.paginasxcap = -1;
        this.autor = autor;
    }

    public Libro(String titulo, Fecha fecha, int isbn, Persona autor, Editorial editorial, int paginasxcap) {
        super(titulo, fecha, isbn=-1);
        this.autor = autor;
        this.editorial = editorial;
        this.paginasxcap = -1;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getPaginasxcap() {
        return paginasxcap;
    }

    public void setPaginasxcap(int paginasxcap) {
        this.paginasxcap = paginasxcap;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public static void mostrareditoriales(){
        for(Editorial e : Editorial.values()){
            System.out.println(e);
        }
    }
    public void mostrarLibroCorto(){
        System.out.printf("Titulo: "+getTitulo()+" Autor: "+autor+" paginas: "+paginasxcap+" editorial: " +editorial.name());
    }
    public void mostrarLibroLargo(){
        System.out.printf("Titulo: "+getTitulo()+" Autor: "+autor+" isbn: "+ getIsbn()+" paginas: "+paginasxcap+" editorial: "+editorial.name()+" Fecha: "+getFecha().corta());
    }
    public boolean esAnterior(Libro otroLibro){
        return this.getFecha().menorQue(otroLibro.getFecha());
    }



    @Override
    public void prestar() {
        if(puedePrestarse()){
            System.out.println("el libro se dara prestado");
        }
    }

    @Override
    public boolean puedePrestarse() {
        if((capstotales/2)!=0){
           return true;
        }
        return false;
    }

    @Override
    public void devolver() {

    }
}
