package bibliotecaVirtual;

import exeptions.LimiteDePrestamosAlcanzadoException;
import exeptions.MembresiaException;
import personas.Persona;
import utils.Fecha;

import java.time.LocalDate;

public class Bibliotecario extends Persona {
    private String mail;

    public Bibliotecario(String nombre, String apellido, Fecha fechaNacimiento, int dni, String mail){
        super(nombre, apellido, dni, fechaNacimiento);
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Prestamo prestarLibro(Usuario usuario, LibroElectronico libro) throws LimiteDePrestamosAlcanzadoException, MembresiaException {
        if (usuario.tienePrestado(libro)){
            System.out.println(usuario.getNombreCompleto() + " ya tiene prestado '" + libro.getTitulo() + "'");
            return null;
        }
        if (usuario.alcanzoElCupo()){
            throw new MembresiaException(usuario.getNombreCompleto(), usuario.getMembresia().toString(), usuario.getCupoDePrestamos());
        }
        if (!libro.tieneDescargasDisponibles()){
            throw new LimiteDePrestamosAlcanzadoException(libro.getTitulo(), libro.getDescargasDisponibles());
        }
        Prestamo prestamo = new Prestamo(usuario, libro, new Fecha(LocalDate.now()));
        usuario.agregarPrestamo(prestamo);
        libro.registrarDescarga();
        System.out.println("Prestamo de '" + libro.getTitulo() + "' a " + usuario.getNombreCompleto() + " generado por " + getNombreCompleto());
        return prestamo;
    }

    public boolean devolverLibro(Usuario usuario, Prestamo prestamo){
        if (prestamo == null || !usuario.getPrestamos().contains(prestamo)){
            return false;
        }
        if (prestamo.isDevuelto()){
            return false;
        }
        prestamo.marcarComoDevuelto();
        System.out.println("Devolucion de '" + prestamo.getLibro().getTitulo() + "' registrada por " + getNombreCompleto());
        return true;
    }

    public boolean devolverLibro(Usuario usuario, LibroElectronico libro){
        for (Prestamo p : usuario.getPrestamos()){
            if (p.esActivo() && p.getLibro() == libro){
                return devolverLibro(usuario, p);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (dni " + getDni() + ", " + mail + ")";
    }
}
