package edificaciones.biblioteca;

import plataformas.prestamos.Prestable;
import plataformas.prestamos.materialLectura.Material_de_lectura;
import utils.Fecha;
import personas.Persona;

import java.util.HashMap;

public class  Libro extends Material_de_lectura implements Prestable {
    private Persona autor;
    private HashMap<Integer,Integer>pagsxcap;
    private Editorial editorial;



    public Libro(String titulo, Fecha fecha, int isbn, Persona autor, HashMap paginasxcap, Editorial editorial) {
        super(titulo, fecha, isbn);
        this.autor = autor;
        this.pagsxcap = paginasxcap;
        this.editorial = editorial;
    }

    public Libro(String titulo, Fecha fecha, int isbn, Editorial editorial, Persona autor) {
        super(titulo, fecha, isbn);
        this.editorial = editorial;
        this.autor = autor;
    }

    public Libro(String titulo, Fecha fecha, int isbn, Persona autor, Editorial editorial) {
        super(titulo, fecha, isbn=-1);
        this.autor = autor;
        this.editorial = editorial;

    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public HashMap getPagsxcap() {
        return pagsxcap;
    }

    public void setPaginasxcap(HashMap pagsxcap) {
        this.pagsxcap = pagsxcap;
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
        System.out.printf("Titulo: "+getTitulo()+" Autor: "+autor+" paginas: "+pagsxcap+" editorial: " +editorial.name());
    }
    public void mostrarLibroLargo(){
        System.out.printf("Titulo: "+getTitulo()+" Autor: "+autor+" isbn: "+ getIsbn()+" paginas: "+pagsxcap+" editorial: "+editorial.name()+" Fecha: "+getFecha().corta());
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
       if( (pagsxcap.size()%2)!=0){
           return true;
        }
        return false;
    }

    @Override
    public void devolver() {
        System.out.println("devolver");
    }

    @Override
    public String toString() {
        return autor+" "+pagsxcap+" "+editorial+" "+pagsxcap+" ";
    }
}
