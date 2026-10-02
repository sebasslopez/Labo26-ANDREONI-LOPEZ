package plataformas.bibliotecaVirtual;

import personas.Persona;
import utils.Fecha;

import java.util.ArrayList;

public class Usuario extends Persona {
    private String mail;
    private Membresia membresia;
    private ArrayList<Prestamo> prestamos;

    public Usuario(String nombre, String apellido, Fecha fechaNacimiento, int dni, String mail, Membresia membresia){
        super(nombre, apellido, dni, fechaNacimiento);
        this.mail = mail;
        this.membresia = membresia;
        this.prestamos = new ArrayList<>();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public int getCantidadDePrestamosActivos(){
        int cantidad = 0;
        for (Prestamo p : prestamos){
            if (p.esActivo()){
                cantidad++;
            }
        }
        return cantidad;
    }

    public int getCupoDePrestamos(){
        return membresia.getMaxPrestamos();
    }

    public int getCupoDisponible(){
        return getCupoDePrestamos() - getCantidadDePrestamosActivos();
    }

    public boolean alcanzoElCupo(){
        return getCantidadDePrestamosActivos() >= getCupoDePrestamos();
    }

    public boolean tienePrestado(LibroElectronico libro){
        for (Prestamo p : prestamos){
            if (p.esActivo() && p.getLibro() == libro){
                return true;
            }
        }
        return false;
    }

    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    public void quitarPrestamo(Prestamo prestamo){
        prestamos.remove(prestamo);
    }

    public void mostrarPrestamosActivos(){
        System.out.println("Prestamos activos de " + getNombreCompleto() + " (" + getCantidadDePrestamosActivos() + "/" + getCupoDePrestamos() + "):");
        for (Prestamo p : prestamos){
            if (p.esActivo()){
                System.out.println("   " + p);
            }
        }
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (dni " + getDni() + ", " + mail + ", membresia " + membresia + ")";
    }
}
