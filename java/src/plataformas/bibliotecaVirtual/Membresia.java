package plataformas.bibliotecaVirtual;

public enum Membresia {
    BRONCE(5), PLATA(15), ORO(50);

    private final int maxPrestamos;

    Membresia(int maxPrestamos){
        this.maxPrestamos = maxPrestamos;
    }

    public int getMaxPrestamos(){
        return maxPrestamos;
    }
}
