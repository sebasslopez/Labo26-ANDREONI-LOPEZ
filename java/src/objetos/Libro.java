package objetos;

import fecha.Fecha;
import gente.Persona;

public class Libro {
    private String titulo;
    private Persona autor;
    private int isbn;
    private int paginas;
    private String editorial;
    private Fecha fecha;

    public Libro(String titulo, Persona autor, int isbn, int paginas, String editorial, Fecha fecha){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.editorial = editorial;
        this.fecha = fecha;
    }
    public Libro(String titulo, Persona autor, int isbn, String editorial, Fecha fecha){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = -1;
        this.editorial = editorial;
        this.fecha = fecha;
    }
    public Libro(String titulo, Persona autor, String editorial, Fecha fecha){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = -1;
        this.paginas = -1;
        this.editorial = editorial;
        this.fecha = fecha;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(Persona autor){
        this.autor = autor;
    }
    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    public void setPaginas(int paginas){
        this.paginas = paginas;
    }
    public void setEditorial(String editorial){
        this.editorial = editorial;
    }
    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }
    public String getTitulo(){
        return titulo;
    }
    public Persona getAutor(){
        return autor;
    }
    public int getIsbn(){
        return isbn;
    }
    public int getPaginas(){
        return paginas;
    }
    public String getEditorial(){
        return editorial;
    }
    public Fecha getFecha(){
        return fecha;
    }
    public void mostrarLibroCorto(){
        System.out.printf("Titulo: "+titulo+" Autor: "+autor+"paginas: "+paginas+" editorial: "+editorial);
    }
    public void mostrarLibroLargo(){
        System.out.printf("Titulo: "+titulo+" Autor: "+autor+" isbn: "+ isbn+" paginas: "+paginas+" editorial: "+editorial+" fecha.Fecha: "+fecha);
    }
    public boolean esAnterior(Libro otroLibro){
        return this.fecha.menorQue(otroLibro.fecha);
    }

    public static void main(String[] args) {

    }
}
