package utils;

public class Posicion {
    private double latitud;
    private double longitud;

    public Posicion(double lat,double lon){
        this.latitud = lat;
        this.longitud = lon;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public static double calcularDistancia(Posicion p1, Posicion p2){
        double lat1Rad = Math.toRadians(p1.getLatitud());
        double lon1Rad = Math.toRadians(p1.getLongitud());
        double lat2Rad = Math.toRadians(p2.getLatitud());
        double lon2Rad = Math.toRadians(p2.getLongitud());

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double radioTierraKm = 6371;
        return radioTierraKm * c;
    }
}
