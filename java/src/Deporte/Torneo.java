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
        public boolean yaHayPArtidoConEsosEquipos(Equipo e1,Equipo e2){
            for(Partido p:fixture){
                if((p.getEquipoVisitante().equals(e1) || p.getEquipoLocal().equals(e1)) && (p.getEquipoVisitante().equals(e2) || p.getEquipoLocal().equals(e2)))
                    return true;
            }
            return false;
        }
        public void generarFixture() {
            fixture.clear();
            for(Equipo e1: equipos){
                for(Equipo e2: equipos){
                    if(!e1.equals(e2) && !yaHayPArtidoConEsosEquipos(e1,e2)) {
                        if(e2.esValido() && e1.esValido()){
                            String turnoElegido = buscarTurnoComun(e2, e2);
                            if (turnoElegido == null) {
                                System.out.println("Partido no programado: " + e1.getNombre() + " vs " + e2.getNombre() + " (no comparten ningún turno disponible).");
                            }
                            else {
                                int dia = buscarDiaDisponible();
                                Partido partido = new Partido(e1, e2, dia, turnoElegido);
                                fixture.add(partido);
                            }
                        }
                        else{
                            System.out.println("Partido no programado: " + e1.getNombre() + " vs " + e2.getNombre() + " (uno o ambos equipos no son válidos).");
                        }
                    }
                }
            }
        }

        private String buscarTurnoComun(Equipo e1, Equipo e2) {
            for (String turno : TURNOS) {
                if (e1.getTurnosDisponibles().contains(turno) && e2.getTurnosDisponibles().contains(turno)) {
                    return turno;
                }
            }
            return null;
        }
        private boolean hayPartidoEnEsaFecha(int dia){
            for (Partido p: fixture){
                if(p.getDia() == dia) return true;
            }
            return false;
        }

        private int buscarDiaDisponible() {
            while (hayPartidoEnEsaFecha(dia)){
                dia++;
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
            equipoA.agregarJugador(new Jugador("Ana",      "García",    new Fecha(1,  1,  2000), 1));
            equipoA.agregarJugador(new Jugador("Luis",     "Pérez",     new Fecha(2,  2,  2001), 2));
            equipoA.agregarJugador(new Jugador("María",    "López",     new Fecha(3,  3,  2002), 3));
            equipoA.agregarJugador(new Jugador("Carlos",   "Martínez",  new Fecha(4,  4,  2001), 4));
            equipoA.agregarJugador(new Jugador("Sofía",    "Rodríguez", new Fecha(5,  5,  2003), 5));
            equipoA.agregarJugador(new Jugador("Pedro",    "Sánchez",   new Fecha(6,  6,  2000), 6));
            equipoA.agregarJugador(new Jugador("Laura",    "González",  new Fecha(7,  7,  2002), 7));
            equipoA.agregarJugador(new Jugador("Diego",    "Herrera",   new Fecha(8,  8,  2001), 8));
            equipoA.agregarJugador(new Jugador("Valeria",  "Torres",    new Fecha(9,  9,  2003), 9));
            equipoA.agregarJugador(new Jugador("Marcos",   "Flores",    new Fecha(10, 10, 2000), 10));
            equipoA.agregarJugador(new Jugador("Julia",    "Díaz",      new Fecha(11, 11, 2002), 11));
            equipoA.agregarTurno("mañana");
            equipoA.agregarTurno("tarde");
            Equipo equipoB = new Equipo("Curling B");
            equipoB.agregarJugador(new Jugador("Roberto",  "Vargas",    new Fecha(12, 12, 2001), 1));
            equipoB.agregarJugador(new Jugador("Elena",    "Moreno",    new Fecha(13, 1,  2002), 2));
            equipoB.agregarJugador(new Jugador("Pablo",    "Jiménez",   new Fecha(14, 2,  2000), 3));
            equipoB.agregarJugador(new Jugador("Lucía",    "Ruiz",      new Fecha(15, 3,  2003), 4));
            equipoB.agregarJugador(new Jugador("Andrés",   "Álvarez",   new Fecha(16, 4,  2001), 5));
            equipoB.agregarJugador(new Jugador("Natalia",  "Romero",    new Fecha(17, 5,  2002), 6));
            equipoB.agregarJugador(new Jugador("Fernando", "Serrano",   new Fecha(18, 6,  2000), 7));
            equipoB.agregarJugador(new Jugador("Camila",   "Torres",    new Fecha(19, 7,  2003), 8));
            equipoB.agregarJugador(new Jugador("Gonzalo",  "Méndez",    new Fecha(20, 8,  2001), 9));
            equipoB.agregarJugador(new Jugador("Beatriz",  "Castro",    new Fecha(21, 9,  2002), 10));
            equipoB.agregarJugador(new Jugador("Ignacio",  "Ortega",    new Fecha(22, 10, 2000), 11));
            equipoB.agregarTurno("tarde");
            equipoB.agregarTurno("noche");
            Equipo equipoC = new Equipo("Curling C");
            equipoC.agregarJugador(new Jugador("Hugo",     "Blanco",    new Fecha(1,  1,  1999), 1));
            equipoC.agregarJugador(new Jugador("Rosa",     "Navarro",   new Fecha(2,  2,  2000), 2));
            equipoC.agregarJugador(new Jugador("Oscar",    "Prieto",    new Fecha(3,  3,  2001), 3));
            equipoC.agregarJugador(new Jugador("Gloria",   "Delgado",   new Fecha(4,  4,  2002), 4));
            equipoC.agregarJugador(new Jugador("Raúl",     "Molina",    new Fecha(5,  5,  1999), 5));
            equipoC.agregarJugador(new Jugador("Isabel",   "Rubio",     new Fecha(6,  6,  2000), 6));
            equipoC.agregarJugador(new Jugador("Tomás",    "Sanz",      new Fecha(7,  7,  2001), 7));
            equipoC.agregarJugador(new Jugador("Pilar",    "Gil",       new Fecha(8,  8,  2002), 8));
            equipoC.agregarJugador(new Jugador("Arturo",   "Peña",      new Fecha(9,  9,  1999), 9));
            equipoC.agregarJugador(new Jugador("Marta",    "Iglesias",  new Fecha(10, 10, 2000), 10));
            equipoC.agregarJugador(new Jugador("Emilio",   "Santos",    new Fecha(11, 11, 2001), 11));
            equipoC.agregarTurno("mañana");
            equipoC.agregarTurno("noche");
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
