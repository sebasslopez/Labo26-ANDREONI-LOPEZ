package bibliotecaVirtual;

import exeptions.LimiteDePrestamosAlcanzadoException;
import exeptions.MembresiaException;
import utils.Fecha;

public class Main {

    public static void main(String[] args) {
        Autor dickens = new Autor("Charles Dickens", new Fecha(7, 2, 1812), 12345678);
        Autor lem = new Autor("Stanislaw Lem", new Fecha(12, 9, 1921), 87654321);
        Autor greene = new Autor("Graham Greene", new Fecha(2, 10, 1904), 11223344);

        LibroElectronico taleOfTwoCities = new LibroElectronico("Un cuento de dos ciudades", dickens, Genero.FICCION, "un_cuento_de_dos_ciudades.pdf");
        LibroElectronico hardToBeARobot = new LibroElectronico("Hard to Be a Robot", lem, Genero.CIENCIA_FICCION, "hard_to_be_a_robot.pdf");
        LibroElectronico elPlanetario = new LibroElectronico("El planetario", lem, Genero.AVENTURA, "el_planetario.pdf");
        LibroElectronico fourthMan = new LibroElectronico("The Fourth Man", greene, Genero.NO_FICCION, "the_fourth_man.pdf");
        LibroElectronico elAmanteDeLadyChesney = new LibroElectronico("El amante de Lady Chesney", greene, Genero.ROMANCE, "el_amante_de_lady_chesney.pdf");
        LibroElectronico gracias = new LibroElectronico("Gracias", greene, Genero.SAGA, "gracias.pdf");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(taleOfTwoCities);
        biblioteca.agregarLibro(hardToBeARobot);
        biblioteca.agregarLibro(elPlanetario);
        biblioteca.agregarLibro(fourthMan);
        biblioteca.agregarLibro(elAmanteDeLadyChesney);
        biblioteca.agregarLibro(gracias);

        Usuario ana = new Usuario("Ana", "Ruiz", new Fecha(15, 4, 1995), 30111222, "ana@mail.com", Membresia.BRONCE);
        Usuario bruno = new Usuario("Bruno", "Diaz", new Fecha(3, 11, 1988), 30444555, "bruno@mail.com", Membresia.PLATA);
        Usuario carla = new Usuario("Carla", "Sosa", new Fecha(20, 6, 1992), 30777888, "carla@mail.com", Membresia.ORO);

        Bibliotecario bibliotecario = new Bibliotecario("Marta", "Baret", new Fecha(11, 6, 1980), 32000111, "marta@biblioteca.com");

        System.out.println("--- Biblioteca cargada ---");
        biblioteca.mostrarLibros();
        lem.mostrarBibliografia();

        System.out.println();
        System.out.println("--- Prestamos ---");
        try {
            bibliotecario.prestarLibro(bruno, hardToBeARobot);
        } catch (MembresiaException | LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        }

        try {
            bibliotecario.prestarLibro(bruno, elPlanetario);
        } catch (MembresiaException | LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        }

        try {
            bibliotecario.prestarLibro(ana, taleOfTwoCities);
        } catch (MembresiaException | LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Devoluciones ---");
        bibliotecario.devolverLibro(bruno, hardToBeARobot);
        bibliotecario.devolverLibro(bruno, hardToBeARobot);

        try {
            bibliotecario.prestarLibro(bruno, hardToBeARobot);
        } catch (MembresiaException | LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Usuario bronce que supera su cupo de 5 prestamos ---");
        LibroElectronico[] paraAna = {elPlanetario, fourthMan, elAmanteDeLadyChesney, gracias};
        try {
            for (LibroElectronico libro : paraAna){
                bibliotecario.prestarLibro(ana, libro);
            }
        } catch (MembresiaException | LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        }

        try {
            bibliotecario.prestarLibro(ana, hardToBeARobot);
        } catch (MembresiaException | LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Libro sin descargas disponibles ---");
        gracias.setDescargasDisponibles(0);
        try {
            bibliotecario.prestarLibro(carla, gracias);
        } catch (MembresiaException | LimiteDePrestamosAlcanzadoException e) {
            System.out.println("Prestamo rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Alta, modificacion y baja de libros ---");
        LibroElectronico nuevo = new LibroElectronico("Cien anios de soledad", greene, Genero.SAGA, "cien_anios_de_soledad.pdf");
        biblioteca.agregarLibro(nuevo);
        biblioteca.modificarLibro(nuevo, "Cien anos de soledad (edicion 2026)", Genero.FICCION, "cien_anios_2026.pdf", null);
        nuevo.mostrarInfo();
        biblioteca.borrarLibro(nuevo);
        greene.mostrarBibliografia();

        System.out.println();
        System.out.println("--- Estado final ---");
        biblioteca.mostrarLibros();
        ana.mostrarPrestamosActivos();
        bruno.mostrarPrestamosActivos();
        carla.mostrarPrestamosActivos();
    }
}
