package plataformas.campaniaElectoral;

public class TelefonoMensajero extends TelefonoMovil implements Activista {
    private CompaniaTelefonica compania;

    public TelefonoMensajero(int numeroSerie, String fabricante, String modelo, int fono, CompaniaTelefonica c) {
        super(numeroSerie, fabricante, modelo, fono);
        this.compania = c;
    }

    public CompaniaTelefonica getCompania() {
        return compania;
    }

    public void setCompania(CompaniaTelefonica compania) {
        this.compania = compania;
    }

    @Override
    public void enviarMensaje(String msj) {
        System.out.println("Conectando con la antena más cercana...");
        System.out.println(msj);
    }
}
