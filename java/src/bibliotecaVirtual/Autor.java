package bibliotecaVirtual;

import personas.Persona;
import utils.Fecha;

import java.util.ArrayList;

public class Autor extends Persona {
    private ArrayList<LibroElectronico> bibliografia;

    public Autor(String nombre, Fecha fechaNacimiento, int dni){
        super(nombre, "", dni, fechaNacimiento);
        this.bibliografia = new ArrayList<>();
    }

    public ArrayList<LibroElectronico> getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(ArrayList<LibroElectronico> bibliografia) {
        this.bibliografia = bibliografia;
    }

    public void agregarLibroALaBibliografia(LibroElectronico libro){
        if (!bibliografia.contains(libro)){
            bibliografia.add(libro);
        }
    }

    public void quitarLibroDeLaBibliografia(LibroElectronico libro){
        bibliografia.remove(libro);
    }

    public int cantidadDeLibrosEscritos(){
        return bibliografia.size();
    }

    public boolean escribio(LibroElectronico libro){
        return bibliografia.contains(libro);
    }

    public void mostrarBibliografia(){
        System.out.println("Bibliografia de " + getNombre() + " (" + cantidadDeLibrosEscritos() + " libros):");
        for (LibroElectronico libro : bibliografia){
            System.out.println("   " + libro.getTitulo() + " - " + libro.getGenero());
        }
    }

    @Override
    public String toString() {
        return getNombre() + " (dni " + getDni() + ", nac. " + getFechan().corta() + ")";
    }
}
