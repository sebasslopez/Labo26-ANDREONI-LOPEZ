package transporte;

public enum Color {
    AMARILLO("#"),
    ROJO("#FF0000"),
    VERDE("#00FF00"),
    AZUL("#0000FF"),
    GRIS("#676767"),
    NEGRO("#000000"),
    CYAN("#00FFFF"),
    ROSA("#FF3898"),
    BLANCO("#FFFFFF"),
    VIOLETA("#8400E0"),
    NARANJA("#FFD600"),
    MARRON("#46220F");

    private String codigoHexa;

    private Color(String codigoHexa){
        this.codigoHexa = codigoHexa;
    }

    public String getCodigoHexa() {
        return codigoHexa;
    }
}
