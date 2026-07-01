package musica;

public class Cancion {
private String autor;
private String titulo;

public Cancion(){
    this.autor="Ellie Goulding";
    this.titulo="Love Me Like You Do";
}
public Cancion(String autor, String titulo){
    this.autor=autor;
    this.titulo=titulo;

}

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String sautor(){
        return "nombre autor:"+autor;
    }
    public String stitulo(){
        return "titulo de la canción:"+titulo;
}
    public static void main(String[] args) {
    Cancion cancion =new Cancion("Zara Larsson","Midnight Sun");
        System.out.println(cancion.sautor());
        System.out.println(cancion.stitulo());
    }




}
