package plataformas.bibliotecaVirtual;

import exceptions.LimiteDePrestamosAlcanzadoException;
import exceptions.MembresiaException;
import exceptions.SinComponenteException;
import exceptions.UsuarioNoEncontradoException;
import exceptions.UsuarioYaRegistradoException;

import java.util.ArrayList;

public class Sistema {
    private Biblioteca biblioteca;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Bibliotecario> bibliotecarios;

    public Sistema(){
        this.biblioteca = new Biblioteca();
        this.usuarios = new ArrayList<>();
        this.bibliotecarios = new ArrayList<>();
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(ArrayList<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public void registrarBibliotecario(Bibliotecario b){
        if (b == null || existeBibliotecarioConDni(b.getDni())){
            System.out.println("No se puede registrar al bibliotecario: el dni ya esta en uso o el bibliotecario es null");
            return;
        }
        bibliotecarios.add(b);
        System.out.println("Bibliotecario " + b.getNombreCompleto() + " (dni " + b.getDni() + ") registrado");
    }

    private boolean existeBibliotecarioConDni(int dni){
        for (Bibliotecario b : bibliotecarios){
            if (b.getDni() == dni) return true;
        }
        return false;
    }

    public void registrarUsuario(Usuario u) throws UsuarioYaRegistradoException {
        Usuario existente = obtenerUsuarioPorDni(u.getDni());
        if (existente != null){
            throw new UsuarioYaRegistradoException(u.getDni(), existente.getNombreCompleto());
        }
        usuarios.add(u);
        System.out.println("Usuario " + u.getNombreCompleto() + " (dni " + u.getDni() + ", membresia " + u.getMembresia() + ") registrado");
    }

    public void removerUsuario(Usuario u){
        usuarios.remove(u);
    }

    public boolean existeUsuarioConDni(int dni){
        return obtenerUsuarioPorDni(dni) != null;
    }

    public Usuario obtenerUsuarioPorDni(int dni){
        for (Usuario u : usuarios){
            if (u.getDni() == dni) return u;
        }
        return null;
    }

    public Usuario obtenerUsuarioRegistradoPorDni(int dni) throws UsuarioNoEncontradoException {
        Usuario u = obtenerUsuarioPorDni(dni);
        if (u == null){
            throw new UsuarioNoEncontradoException(dni);
        }
        return u;
    }

    public void agregarLibro(LibroElectronico libro){
        biblioteca.agregarLibro(libro);
    }

    public boolean borrarLibro(LibroElectronico libro){
        return biblioteca.borrarLibro(libro);
    }

    public void modificarLibro(LibroElectronico libro, String titulo, Genero genero, String nombreArchivoPdf, Autor autor){
        biblioteca.modificarLibro(libro, titulo, genero, nombreArchivoPdf, autor);
    }

    public LibroElectronico buscarLibroPorTitulo(String titulo) throws SinComponenteException {
        LibroElectronico libro = biblioteca.buscarPorTitulo(titulo);
        if (libro == null){
            throw new SinComponenteException("ERROR: el libro '" + titulo + "' no esta en el catalogo");
        }
        return libro;
    }

    public Prestamo prestar(Bibliotecario bibliotecario, Usuario usuario, LibroElectronico libro) throws UsuarioNoEncontradoException, MembresiaException, LimiteDePrestamosAlcanzadoException {
        Usuario registrado = obtenerUsuarioPorDni(usuario.getDni());
        if (registrado == null || registrado != usuario){
            throw new UsuarioNoEncontradoException(usuario.getDni());
        }
        return bibliotecario.prestarLibro(registrado, libro);
    }

    public Prestamo prestarPorDni(Bibliotecario bibliotecario, int dni, String tituloLibro) throws UsuarioNoEncontradoException, SinComponenteException, MembresiaException, LimiteDePrestamosAlcanzadoException {
        Usuario u = obtenerUsuarioRegistradoPorDni(dni);
        LibroElectronico libro = buscarLibroPorTitulo(tituloLibro);
        return bibliotecario.prestarLibro(u, libro);
    }

    public boolean devolver(Bibliotecario bibliotecario, Usuario usuario, LibroElectronico libro){
        return bibliotecario.devolverLibro(usuario, libro);
    }

    public ArrayList<Prestamo> obtenerPrestamosActivos(){
        ArrayList<Prestamo> activos = new ArrayList<>();
        for (Usuario u : usuarios){
            for (Prestamo p : u.getPrestamos()){
                if (p.esActivo()){
                    activos.add(p);
                }
            }
        }
        return activos;
    }

    public int totalDePrestamosActivos(){
        return obtenerPrestamosActivos().size();
    }

    public void mostrarCatalogo(){
        biblioteca.mostrarLibros();
    }

    public void mostrarUsuarios(){
        System.out.println("Usuarios de la plataforma (" + usuarios.size() + "):");
        for (Usuario u : usuarios){
            System.out.println("   " + u + " | prestamos activos: " + u.getCantidadDePrestamosActivos() + "/" + u.getCupoDePrestamos());
        }
    }

    public void mostrarPrestamosActivos(){
        System.out.println("Prestamos activos de la plataforma (" + totalDePrestamosActivos() + "):");
        for (Prestamo p : obtenerPrestamosActivos()){
            System.out.println("   " + p.getUsuario().getNombreCompleto() + " - " + p);
        }
    }
}
