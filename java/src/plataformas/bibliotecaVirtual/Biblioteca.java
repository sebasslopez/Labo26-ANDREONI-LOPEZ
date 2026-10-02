package plataformas.bibliotecaVirtual;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<LibroElectronico> libros;

    public Biblioteca(){
        this.libros = new ArrayList<>();
    }

    public ArrayList<LibroElectronico> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<LibroElectronico> libros) {
        this.libros = libros;
    }

    public void agregarLibro(LibroElectronico libro){
        if (libro == null || buscarPorTitulo(libro.getTitulo()) != null){
            System.out.println("No se puede agregar '" + (libro == null ? "null" : libro.getTitulo()) + "': ya existe en la biblioteca");
            return;
        }
        libros.add(libro);
        System.out.println("Libro '" + libro.getTitulo() + "' agregado a la biblioteca");
    }

    public boolean borrarLibro(LibroElectronico libro){
        if (libros.remove(libro)){
            libro.getAutor().quitarLibroDeLaBibliografia(libro);
            System.out.println("Libro '" + libro.getTitulo() + "' eliminado de la biblioteca");
            return true;
        }
        return false;
    }

    public boolean borrarLibroPorTitulo(String titulo){
        return borrarLibro(buscarPorTitulo(titulo));
    }

    public void modificarLibro(LibroElectronico libro, String titulo, Genero genero, String nombreArchivoPdf, Autor autor){
        if (!libros.contains(libro)){
            System.out.println("El libro '" + libro.getTitulo() + "' no pertenece a la biblioteca");
            return;
        }
        if (titulo != null && !titulo.isBlank() && !titulo.equalsIgnoreCase(libro.getTitulo())){
            LibroElectronico otro = buscarPorTitulo(titulo);
            if (otro != null && otro != libro){
                System.out.println("Ya existe otro libro con el titulo '" + titulo + "'");
                return;
            }
            libro.setTitulo(titulo);
        }
        if (genero != null){
            libro.setGenero(genero);
        }
        if (nombreArchivoPdf != null && !nombreArchivoPdf.isBlank()){
            libro.setNombreArchivoPdf(nombreArchivoPdf);
        }
        if (autor != null){
            libro.setAutor(autor);
        }
        System.out.println("Libro '" + libro.getTitulo() + "' modificado");
    }

    public LibroElectronico buscarPorTitulo(String titulo){
        for (LibroElectronico libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)){
                return libro;
            }
        }
        return null;
    }

    public boolean existeLibro(String titulo){
        return buscarPorTitulo(titulo) != null;
    }

    public ArrayList<LibroElectronico> librosPorGenero(Genero genero){
        ArrayList<LibroElectronico> resultado = new ArrayList<>();
        for (LibroElectronico libro : libros){
            if (libro.getGenero() == genero){
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public int cantidadDeLibros(){
        return libros.size();
    }

    public void mostrarLibros(){
        System.out.println("Libros de la biblioteca (" + libros.size() + "):");
        for (LibroElectronico libro : libros){
            System.out.println("   " + libro);
        }
    }
}
