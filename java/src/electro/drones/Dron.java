package electro.drones;

import utils.Fecha;

public abstract class Dron {
    private String modelo;
    private Fecha fechaad;
    private int id;
    private static int contador=0;
    private Estado estado;
    private int bateria;
    static double latitudOG=34.573195;
    static double longitudOG=-58.504111;
    private double latituddest;
    private double longituddest;



    public Dron(String modelo, Fecha fechaad, Estado estado, int bateria, double latituddest, double longituddest) {
        this.modelo = modelo;
        this.fechaad = fechaad;
        this.id = contador;
        contador ++;
        this.estado = estado;
        this.bateria = bateria;
        this.latituddest= latituddest;
    }



    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Fecha getFechaad() {
        return fechaad;
    }

    public void setFechaad(Fecha fechaad) {
        this.fechaad = fechaad;
    }

    public double getLatituddest() {
        return latituddest;
    }

    public void setLatituddest(double latituddest) {
        this.latituddest = latituddest;
    }

    public double getLongituddest() {
        return longituddest;
    }

    public void setLongituddest(double longituddest) {
        this.longituddest = longituddest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }


    public void Recarga() {
        if (bateria < 20) {
            bateria = 100;
        } else {
            bateria += 10;
        }
    }
    public double calculardist(){

        double lat1Rad = Math.toRadians(latitudOG);
        double lon1Rad = Math.toRadians(longitudOG);
        double lat2Rad = Math.toRadians(this.getLatituddest());
        double lon2Rad = Math.toRadians(this.getLongituddest());

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double radioTierraKm = 6371;
        return radioTierraKm * c;
    }

    public abstract void sepuede();

}
