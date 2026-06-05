package electro.multimedia;

public enum Calidad {
    ULTRA_HD("3840x2160"),
    CUATRO_K("4096x2160"),
    FULL_HD("1920x1080");

    private String resolucion;

    private Calidad (String resolucion){
        this.resolucion = resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

}
