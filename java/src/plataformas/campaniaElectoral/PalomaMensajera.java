package plataformas.campaniaElectoral;

import transporte.Color;

public class PalomaMensajera extends Ave implements Activista {
    private boolean vuela;

    public PalomaMensajera(String nombre,boolean vuela){
        super(Color.GRIS,nombre,"Paloma");
        this.vuela = vuela;
    }

    public boolean isVuela() {
        return vuela;
    }

    public void aprendióAVolar() {
        this.vuela = true;
    }

    @Override
    public void enviarMensaje(String msj) {
        if(vuela) System.out.println("Lanzando un papelito que dice: "+msj);
    }
}
