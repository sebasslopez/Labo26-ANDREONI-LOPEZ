package plataformas.bibliotecaVirtual;

import edificaciones.biblioteca.Editorial;
import exceptions.LimiteDePrestamosAlcanzadoException;
import exceptions.MembresiaException;
import exceptions.SinComponenteException;
import exceptions.UsuarioNoEncontradoException;
import exceptions.UsuarioYaRegistradoException;
import utils.Fecha;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        Autor dickens = new Autor("Charles Dickens", new Fecha(7, 2, 1812), 12345678);
        Autor lem = new Autor("Stanislaw Lem", new Fecha(12, 9, 1921), 87654321);
        Autor greene = new Autor("Graham Greene", new Fecha(2, 10, 1904), 11223344);

        LibroElectronico taleOfTwoCities = new LibroElectronico("Un cuento de dos ciudades", dickens, Editorial.KAPELUSZ, new Fecha(15, 4, 1859), Genero.FICCION, "un_cuento_de_dos_ciudades.pdf");
        LibroElectronico hardToBeARobot = new LibroElectronico("Hard to Be a Robot", lem, Editorial.SUR, new Fecha(6, 6, 1954), Genero.CIENCIA_FICCION, "hard_to_be_a_robot.pdf");
        LibroElectronico elPlanetario = new LibroElectronico("El planetario", lem, Editorial.SUR, new Fecha(2, 2, 1973), Genero.AVENTURA, "el_planetario.pdf");
        LibroElectronico fourthMan = new LibroElectronico("The Fourth Man", greene, Editorial.ALIANZA, new Fecha(18, 3, 1935), Genero.NO_FICCION, "the_fourth_man.pdf");
        LibroElectronico elAmanteDeLadyChesney = new LibroElectronico("El amante de Lady Chesney", greene, Editorial.ALIANZA, new Fecha(2, 9, 1951), Genero.ROMANCE, "el_amante_de_lady_chesney.pdf");
        LibroElectronico gracias = new LibroElectronico("Gracias", greene, Editorial.SUDAMERICANA, new Fecha(28, 5, 1952), Genero.SAGA, "gracias.pdf");

        sistema.agregarLibro(taleOfTwoCities);
        sistema.agregarLibro(hardToBeARobot);
        sistema.agregarLibro(elPlanetario);
        sistema.agregarLibro(fourthMan);
        sistema.agregarLibro(elAmanteDeLadyChesney);
        sistema.agregarLibro(gracias);

        Usuario ana = new Usuario("Ana", "Ruiz", new Fecha(15, 4, 1995), 30111222, "ana@mail.com", Membresia.BRONCE);
        Usuario bruno = new Usuario("Bruno", "Diaz", new Fecha(3, 11, 1988), 30444555, "bruno@mail.com", Membresia.PLATA);
        Usuario carla = new Usuario("Carla", "Sosa", new Fecha(20, 6, 1992), 30777888, "carla@mail.com", Membresia.ORO);

        Bibliotecario bibliotecario = new Bibliotecario("Marta", "Baret", new Fecha(11, 6, 1980), 32000111, "marta@biblioteca.com");
        sistema.registrarBibliotecario(bibliotecario);

        System.out.println();
        System.out.println("--- Alta de usuarios ---");
        try {
            sistema.registrarUsuario(ana);
        } catch (UsuarioYaRegistradoException e) {
            System.out.println("Alta rechazada: " + e.getMessage());
        }

        try {
            sistema.registrarUsuario(bruno);
        } catch (UsuarioYaRegistradoException e) {
            System.out.println("Alta rechazada: " + e.getMessage());
        }

        try {
            sistema.registrarUsuario(carla);
        } catch (UsuarioYaRegistradoException e) {
            System.out.println("Alta rechazada: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Alta de usuario con dni repetido ---");
        Usuario duplicado = new Usuario("Tomas", "Gomez", new Fecha(2, 2, 1990), 30111222, "tomas@mail.com", Membresia.PLATA);
        try {
            sistema.registrarUsuario(duplicado);
        } catch (UsuarioYaRegistradoException e) {
            System.out.println("Alta rechazada: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Prestamo de usuario no registrado ---");
        try {
            sistema.prestar(bibliotecario, duplicado, taleOfTwoCities);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Prestamos ---");
        try {
            sistema.prestar(bibliotecario, bruno, hardToBeARobot);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        try {
            sistema.prestar(bibliotecario, bruno, elPlanetario);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        try {
            sistema.prestar(bibliotecario, ana, taleOfTwoCities);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Prestamo buscando por dni y por titulo ---");
        try {
            sistema.prestarPorDni(bibliotecario, 30444555, "The Fourth Man");
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (SinComponenteException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Devoluciones ---");
        sistema.devolver(bibliotecario, bruno, hardToBeARobot);
        sistema.devolver(bibliotecario, bruno, hardToBeARobot);

        try {
            sistema.prestar(bibliotecario, bruno, hardToBeARobot);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Usuario bronce que supera su cupo de 5 prestamos ---");
        LibroElectronico[] paraAna = {elPlanetario, elAmanteDeLadyChesney, gracias, fourthMan};
        for (LibroElectronico libro : paraAna){
            try {
                sistema.prestar(bibliotecario, ana, libro);
            } catch (UsuarioNoEncontradoException e) {
                System.out.println("Prestamo rechazado: " + e.getMessage());
            } catch (MembresiaException e) {
                System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
            } catch (LimiteDePrestamosAlcanzadoException e) {
                System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
            }
        }

        try {
            sistema.prestar(bibliotecario, ana, hardToBeARobot);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Libro sin descargas disponibles ---");
        gracias.setDescargasDisponibles(0);
        try {
            sistema.prestar(bibliotecario, carla, gracias);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        } catch (MembresiaException e) {
            System.out.println("Prestamo rechazado por membresia: " + e.getMessage());
        } catch (LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado por descargas: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Alta, modificacion y baja de libros ---");
        LibroElectronico nuevo = new LibroElectronico("Cien anios de soledad", greene, Editorial.SUDAMERICANA, new Fecha(30, 5, 1967), Genero.SAGA, "cien_anios_de_soledad.pdf");
        sistema.agregarLibro(nuevo);
        sistema.modificarLibro(nuevo, "Cien anos de soledad (edicion 2026)", Genero.FICCION, "cien_anios_2026.pdf", null);
        nuevo.mostrarInfo();
        sistema.borrarLibro(nuevo);
        greene.mostrarBibliografia();

        System.out.println();
        System.out.println("--- Estado final ---");
        sistema.mostrarCatalogo();
        sistema.mostrarUsuarios();
        sistema.mostrarPrestamosActivos();
        lem.mostrarBibliografia();
    }
}
