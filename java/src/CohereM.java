import java.time.LocalDate;

public class CohereM {
    private String nombre;
    private int velmax;
    private int largo;
    private int ancho;
    private int propulsores;


    public CohereM(String nombre, int velmax, int largo, int ancho, int propulsores){
        this.nombre=nombre;
        this.velmax=velmax;
        this.largo=largo;
        this.ancho=ancho;
        this.propulsores=propulsores;

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVelmax() {
        return velmax;
    }
    public void setVelmax(int velmax) {
        this.velmax = velmax;
    }
    public int getLargo() {
        return largo;
    }
    public void setLargo(int largo) {
        this.largo = largo;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getPropulsores() {
        return propulsores;
    }
    public void setPropulsores(int propulsores) {
        this.propulsores = propulsores;
    }
    public boolean vuelaono(){
        return propulsores >= 2 && velmax>25000;
    }
    public void activar(int cant){
        if(cant>propulsores){
            System.out.println("no podes activar mas propulsores de los que tenes");
        }
            for (int i = 0; i < cant; i++) {
                System.out.println("Propulsor " + i + " activado");
            }
        }


    public int tiempoViaje(int distancia,int velmax){
        if(distancia <=0){
            return -1;
        }   else{
            int resu = distancia/ velmax;
            return resu;
        }
}





}
 class Tecnicos {
    private String nombre;
    private String apellido;
    private int fn;
    private String especialidad;
    private CohereM coheteasig;

    public Tecnicos(String nombre, String apellido, int fn, String especialidad, CohereM coheteasig) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fn = fn;
        this.especialidad = especialidad;
        this.coheteasig = coheteasig;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getFn() {
        return fn;
    }

    public void setFn(int fn) {
        this.fn = fn;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public CohereM getCoheteasig() {
        return coheteasig;
    }

    public void setCoheteasig(CohereM coheteasig) {
        this.coheteasig = coheteasig;
    }

public void activarp(int cant){
    System.out.println("activar propulsores");
        coheteasig.activar(cant);
}

public boolean cambioC (CohereM nuevoCohete){
        if(estaCap(nuevoCohete)){
            this.coheteasig=nuevoCohete;
            return true;
        }
        return false;
}

public boolean estaCap(CohereM cohete){
    switch (especialidad) {
        case "Propulsión":
            return cohete.getPropulsores() >= 4;
        case "Navegación":
            return cohete.getVelmax() > 28000;
        case "Estructura":
            return cohete.getLargo() > 70;
        default:
            return false;
    }
}
}
 class Main{
    public void main(String[] args) {
        CohereM orion = new CohereM("Orión V", 30000, 75, 9, 5);
        CohereM lunar = new CohereM("Lunar X", 27500, 68, 8, 4);
        CohereM cosmos = new CohereM("Cosmos Max", 35000, 90, 11, 8);


        Tecnicos tecnico1 = new Tecnicos("Juan", "Pérez", 1, "Propulsión", lunar);
        Tecnicos tecnico2 = new Tecnicos("María", "Gómez", 6, "Navegación", orion);

        tecnico1.activarp(3);
        tecnico2.activarp(6);

        int tiempo = orion.tiempoViaje(600000,56000); // distancia en km
        System.out.println("Tiempo de viaje Orión V: " + tiempo + " horas");

        boolean cambio1 = tecnico1.cambioC(cosmos);
        System.out.println("¿Juan pudo cambiar a Cosmos Max? " + cambio1);
        boolean cambio2 = tecnico2.cambioC(lunar);
        System.out.println("¿María pudo cambiar a Lunar X? " + cambio2);
    }
}