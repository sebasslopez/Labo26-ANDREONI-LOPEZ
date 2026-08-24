package plataformas.appMascotas.Mascotas;

public enum TipoMascota {
    PERRO("guau"),
    GATO("miau"),
    PAJAROCANTOR("pio"),
    PAJARONOCANTOR(""),
    PEZ("");

    private String sonido;

    TipoMascota(String sonido){
        this.sonido = sonido;
    }

    public String getSonido() {
        return sonido;
    }
}
