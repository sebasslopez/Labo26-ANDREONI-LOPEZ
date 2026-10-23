package plataformas.fundacionEndocrinologica;

import plataformas.fundacionEndocrinologica.pacientes.*;
import utils.Fecha;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Mainf{

    static void main(String[] args) {
        Joven j1 =new Joven("mar","tina",new Fecha (12,11,2026),"femenino",TipoDeSangre.A_NEGATIVO,new HashSet<String>(Set.of("futbol","natacion","acrobacia en tela")));
        Joven j2 =new Joven("juana","duchowny",new Fecha (12,12,2012),"femenino",TipoDeSangre.O_POSITIVO,new HashSet<String>(Set.of("futbol","natacion","acrobacia en tela")));
        Niño n1= new Niño("luca","mateo",new Fecha(1,1,2023),"masculino",TipoDeSangre.AB_POSITIVO,3);
        Niño n2= new Niño("mateo","orgoroso",new Fecha(11,7,2023),"masculino",TipoDeSangre.AB_POSITIVO,6);
        Adulto a1= new Adulto("franco","andreoni",new Fecha(22,5,1983),"masculino",TipoDeSangre.AB_POSITIVO);
        Adulto a2= new Adulto("franco","andreoni",new Fecha(22,5,1983),"masculino",TipoDeSangre.AB_POSITIVO);
        Geronte g1= new Geronte("edgardo","d",new Fecha(1,2,1950),"m",TipoDeSangre.O_POSITIVO);
        Geronte g2= new Geronte("edgardo","d",new Fecha(1,2,1950),"m",TipoDeSangre.O_POSITIVO);

        sistemaModificarSangre s = new sistemaModificarSangre(new HashSet<Paciente>(),new HashMap<Aplicable,Integer>());
        s.agregarPaciente(g1);
        s.agregarEntratamiento(j1);
        s.agregarEntratamiento(n1);
        s.agregarPaciente(a1);

        s.cantNoAplicables();

        j1.tiempocat();
        j1.cantdep();
        j1.costoTratamiento();

        n1.aplicable();
        n1.costoTratamiento();

    }
}
