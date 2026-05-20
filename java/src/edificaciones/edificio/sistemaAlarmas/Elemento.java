package edificaciones.edificio.sistemaAlarmas;

public class Elemento {
    private boolean conectado;
    private float medida;
    private float umbral;
    private int anio;

    public Elemento(boolean conectado, float umbral, int anio) {
        this.conectado = conectado;
        this.medida = medida;
        this.umbral = umbral;
        this.anio = anio;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public float getMedida() {
        return medida;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }

    public float getUmbral() {
        return umbral;
    }

    public void setUmbral(float umbral) {
        this.umbral = umbral;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void dispararAlarma(){
    }
}
