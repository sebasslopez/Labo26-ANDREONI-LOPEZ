package practica_examen;

public class Main{
    public static void main(String[] args) {
        CohereM orion = new CohereM("Orión V", 30000, 75, 9, 5);
        CohereM lunar = new CohereM("Lunar X", 27500, 68, 8, 4);
        CohereM cosmos = new CohereM("Cosmos Max", 35000, 90, 11, 8);

        Tecnicos tecnico1 = new Tecnicos("Juan", "Pérez", 1, "Propulsión", lunar);
        Tecnicos tecnico2 = new Tecnicos("María", "Gómez", 6, "Navegación", orion);

        tecnico1.activarp(3);
        tecnico2.activarp(6);

        int tiempo = orion.tiempoViaje(600000); // distancia en km
        System.out.println("Tiempo de viaje Orión V: " + tiempo + " horas");

        boolean cambio1 = tecnico1.cambioC(cosmos);
        System.out.println("¿Juan pudo cambiar a Cosmos Max? " + cambio1);
        boolean cambio2 = tecnico2.cambioC(lunar);
        System.out.println("¿María pudo cambiar a Lunar X? " + cambio2);
        System.out.println(orion.equals(lunar));
    }
}