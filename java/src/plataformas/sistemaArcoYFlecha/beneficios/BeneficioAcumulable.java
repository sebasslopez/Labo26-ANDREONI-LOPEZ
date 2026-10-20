package plataformas.sistemaArcoYFlecha.beneficios;

public abstract class BeneficioAcumulable extends Beneficio{
    public BeneficioAcumulable(String nombre, String creador) {
        super(nombre, creador);
    }

    public abstract float calcularDescuentoExtra();

}
