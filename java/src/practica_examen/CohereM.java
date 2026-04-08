package practica_examen;

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

    public void activar(int cant) {
        if (cant > propulsores) {
            System.out.println("no podes activar mas propulsores de los que tenes");
        }else if (vuelaono()){
            for (int i = 0; i < cant; i++) {
                System.out.println("Propulsor " + i + " activado");
            }
        }
    }

    public int tiempoViaje(int distancia){
        if(distancia <=0){
            return -1;
        }   else{
            int resu = distancia/ velmax;
            return resu;
        }
}





}

