package Deporte;
import Gente.Jugador;
import Utils.Fecha;

import java.util.ArrayList;

public class Torneo {
        private ArrayList<Equipo> equipos;
        private ArrayList<Partido> fixture;
        private int dia = 1;
        private String[] TURNOS = {"mañana", "tarde", "noche"};
        public Torneo() {
            this.equipos = new ArrayList<>();
            this.fixture = new ArrayList<>();
        }
        public void agregarEquipo(Equipo equipo) {
            equipos.add(equipo);
        }
        public ArrayList<Equipo> getEquipos() {
            return equipos;
        }
        public void generarFixture() {
            fixture.clear();
            for (int i = 0; i < equipos.size(); i++) {
                if(!(i+1<equipos.size())) {
                    System.out.println("Partido no programado.");
                    return;
                }
                Equipo local = equipos.get(i);
                Equipo visitante = equipos.get(i+1);
                if (!local.esValido() || !visitante.esValido()) {
                    System.out.println("Partido no programado: " + local.getNombre() + " vs " + visitante.getNombre() + " (uno o ambos equipos no son válidos).");
                    return;
                }
                String turnoElegido = buscarTurnoComun(local, visitante);
                if (turnoElegido == null) {
                    System.out.println("Partido no programado: " + local.getNombre() + " vs " + visitante.getNombre() + " (no comparten ningún turno disponible).");
                    return;
                }
                int dia = buscarDiaDisponible(local, visitante);
                Partido partido = new Partido(local, visitante, dia, turnoElegido);
                fixture.add(partido);
            }
        }

        private String buscarTurnoComun(Equipo e1, Equipo e2) {
            for (String turno : TURNOS) {
                if (e1.getTurnosDisponibles().contains(turno)
                        && e2.getTurnosDisponibles().contains(turno)) {
                    return turno;
                }
            }
            return null;
        }

        private int buscarDiaDisponible(Equipo e1, Equipo e2) {
            boolean diaLibre = false;
            while (!diaLibre) {
                boolean e1Ocupa = false;
                boolean e2Ocupa = false;
                for (Partido p : fixture) {
                    if (p.getDia() == dia) {
                        if (p.getEquipoLocal() == e1 || p.getEquipoVisitante() == e1) {
                            e1Ocupa = true;
                        }
                        if (p.getEquipoLocal() == e2 || p.getEquipoVisitante() == e2) {
                            e2Ocupa = true;
                        }
                    }
                }
                if (!e1Ocupa && !e2Ocupa) {
                    diaLibre = true;
                } else {
                    dia++;
                }
            }
            return dia;
        }


        public void mostrarFixture() {
            if (fixture.isEmpty()) {
                System.out.println("El fixture está vacío.");
                return;
            }
            for (Partido p : fixture) {
                System.out.println(p.mostrarPartido());
            }
        }


        public static void main(String[] args) {
            Equipo equipoA = new Equipo("Curling A");
            equipoA.agregarJugador(new Jugador("Ana",      "García",    new Fecha(1,  1,  2000), 1,  true));
            equipoA.agregarJugador(new Jugador("Luis",     "Pérez",     new Fecha(2,  2,  2001), 2,  false));
            equipoA.agregarJugador(new Jugador("María",    "López",     new Fecha(3,  3,  2002), 3,  false));
            equipoA.agregarJugador(new Jugador("Carlos",   "Martínez",  new Fecha(4,  4,  2001), 4,  false));
            equipoA.agregarJugador(new Jugador("Sofía",    "Rodríguez", new Fecha(5,  5,  2003), 5,  false));
            equipoA.agregarJugador(new Jugador("Pedro",    "Sánchez",   new Fecha(6,  6,  2000), 6,  false));
            equipoA.agregarJugador(new Jugador("Laura",    "González",  new Fecha(7,  7,  2002), 7,  false));
            equipoA.agregarJugador(new Jugador("Diego",    "Herrera",   new Fecha(8,  8,  2001), 8,  false));
            equipoA.agregarJugador(new Jugador("Valeria",  "Torres",    new Fecha(9,  9,  2003), 9,  false));
            equipoA.agregarJugador(new Jugador("Marcos",   "Flores",    new Fecha(10, 10, 2000), 10, false));
            equipoA.agregarJugador(new Jugador("Julia",    "Díaz",      new Fecha(11, 11, 2002), 11, false));
            equipoA.agregarTurno("mañana");
            equipoA.agregarTurno("tarde");
            Equipo equipoB = new Equipo("Curling B");
            equipoB.agregarJugador(new Jugador("Roberto",  "Vargas",    new Fecha(12, 12, 2001), 1,  true));
            equipoB.agregarJugador(new Jugador("Elena",    "Moreno",    new Fecha(13, 1,  2002), 2,  false));
            equipoB.agregarJugador(new Jugador("Pablo",    "Jiménez",   new Fecha(14, 2,  2000), 3,  false));
            equipoB.agregarJugador(new Jugador("Lucía",    "Ruiz",      new Fecha(15, 3,  2003), 4,  false));
            equipoB.agregarJugador(new Jugador("Andrés",   "Álvarez",   new Fecha(16, 4,  2001), 5,  false));
            equipoB.agregarJugador(new Jugador("Natalia",  "Romero",    new Fecha(17, 5,  2002), 6,  false));
            equipoB.agregarJugador(new Jugador("Fernando", "Serrano",   new Fecha(18, 6,  2000), 7,  false));
            equipoB.agregarJugador(new Jugador("Camila",   "Torres",    new Fecha(19, 7,  2003), 8,  false));
            equipoB.agregarJugador(new Jugador("Gonzalo",  "Méndez",    new Fecha(20, 8,  2001), 9,  false));
            equipoB.agregarJugador(new Jugador("Beatriz",  "Castro",    new Fecha(21, 9,  2002), 10, false));
            equipoB.agregarJugador(new Jugador("Ignacio",  "Ortega",    new Fecha(22, 10, 2000), 11, false));
            equipoB.agregarTurno("tarde");
            equipoB.agregarTurno("noche");
            Equipo equipoC = new Equipo("Curling C");
            equipoC.agregarJugador(new Jugador("Hugo",     "Blanco",    new Fecha(1,  1,  1999), 1,  true));
            equipoC.agregarJugador(new Jugador("Rosa",     "Navarro",   new Fecha(2,  2,  2000), 2,  false));
            equipoC.agregarJugador(new Jugador("Oscar",    "Prieto",    new Fecha(3,  3,  2001), 3,  false));
            equipoC.agregarJugador(new Jugador("Gloria",   "Delgado",   new Fecha(4,  4,  2002), 4,  false));
            equipoC.agregarJugador(new Jugador("Raúl",     "Molina",    new Fecha(5,  5,  1999), 5,  false));
            equipoC.agregarJugador(new Jugador("Isabel",   "Rubio",     new Fecha(6,  6,  2000), 6,  false));
            equipoC.agregarJugador(new Jugador("Tomás",    "Sanz",      new Fecha(7,  7,  2001), 7,  false));
            equipoC.agregarJugador(new Jugador("Pilar",    "Gil",       new Fecha(8,  8,  2002), 8,  false));
            equipoC.agregarJugador(new Jugador("Arturo",   "Peña",      new Fecha(9,  9,  1999), 9,  false));
            equipoC.agregarJugador(new Jugador("Marta",    "Iglesias",  new Fecha(10, 10, 2000), 10, false));
            equipoC.agregarJugador(new Jugador("Emilio",   "Santos",    new Fecha(11, 11, 2001), 11, false));

            Torneo campeonato = new Torneo();
            campeonato.agregarEquipo(equipoA);
            campeonato.agregarEquipo(equipoB);
            campeonato.agregarEquipo(equipoC);
            for (Equipo e : campeonato.getEquipos()) {
                System.out.println(e.getNombre());
            }
            campeonato.generarFixture();
            campeonato.mostrarFixture();
        }
}
