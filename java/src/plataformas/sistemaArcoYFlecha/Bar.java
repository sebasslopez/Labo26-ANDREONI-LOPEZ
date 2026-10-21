package plataformas.sistemaArcoYFlecha;

import plataformas.sistemaArcoYFlecha.beneficios.Beneficio;
import plataformas.sistemaArcoYFlecha.beneficios.BeneficioAcumulable;
import plataformas.sistemaArcoYFlecha.beneficios.BeneficioComida;
import plataformas.sistemaArcoYFlecha.beneficios.BeneficioGaseosa;
import plataformas.sistemaArcoYFlecha.beneficios.BeneficioTragos;
import plataformas.sistemaArcoYFlecha.dianas.ColorDiana;
import plataformas.sistemaArcoYFlecha.dianas.DianaCircular;
import plataformas.sistemaArcoYFlecha.dianas.DianaCuadrada;
import plataformas.sistemaArcoYFlecha.dianas.Diana;
import plataformas.sistemaArcoYFlecha.dianas.DianaRectangular;
import plataformas.recetas.platos.NivelDeDificultad;
import plataformas.sistema_de_alimentacion.PlatoComida;

import java.util.HashSet;

public class Bar {
    private HashSet<Diana> dianas;
    private int clientesJugadores;
    private float plata;
    private HashSet<Beneficio> beneficios;
    private HashSet<BeneficioAcumulable> acumulables;

    public Bar(int clientesJugadores, float plata) {
        this.clientesJugadores = clientesJugadores;
        this.plata = plata;
        dianas = new HashSet<>();
        beneficios = new HashSet<>();
        acumulables = new HashSet<>();
    }

    public HashSet<Diana> getDianas() {
        return dianas;
    }

    public void setDianas(HashSet<Diana> dianas) {
        this.dianas = dianas;
    }

    public int getClientesJugadores() {
        return clientesJugadores;
    }

    public void setClientesJugadores(int clientesJugadores) {
        this.clientesJugadores = clientesJugadores;
    }

    public float getPlata() {
        return plata;
    }

    public void setPlata(float plata) {
        this.plata = plata;
    }

    public HashSet<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(HashSet<Beneficio> implementar) {
        this.beneficios = implementar;
    }

    public HashSet<BeneficioAcumulable> getAcumulables() {
        return acumulables;
    }

    public void setAcumulables(HashSet<BeneficioAcumulable> acumulables) {
        this.acumulables = acumulables;
    }

    public int obtenerCantTragos(){
        int cant = 0;
        for(Beneficio b : beneficios) if(!acumulables.contains(b)) cant++;
        return cant;
    }

    public Diana obtenerDianaConMasPuntajes(){
        Diana mayor = null;
        for (Diana d : dianas) if(mayor == null || d.getCantPuntajes() > mayor.getCantPuntajes()) mayor = d;
        return mayor;
    }

    public static void main(String[] args) {
        Bar bar = new Bar(25, 150000);

        DianaCircular dianaCircular = new DianaCircular("Diana circular", NivelDeDificultad.FACIL);
        dianaCircular.getPuntaje().put(10, ColorDiana.ROJO);
        dianaCircular.getPuntaje().put(20, ColorDiana.VERDE);

        DianaRectangular dianaRectangular = new DianaRectangular("Diana rectangular", NivelDeDificultad.MEDIO, 40, 60);
        dianaRectangular.getPuntaje().put(10, ColorDiana.ROJO);
        dianaRectangular.getPuntaje().put(20, ColorDiana.VERDE);
        dianaRectangular.getPuntaje().put(30, ColorDiana.AMARILLO);

        DianaCuadrada dianaCuadrada = new DianaCuadrada("Diana cuadrada", NivelDeDificultad.AVANZADO, 50);
        dianaCuadrada.getPuntaje().put(10, ColorDiana.ROJO);

        bar.getDianas().add(dianaCircular);
        bar.getDianas().add(dianaRectangular);
        bar.getDianas().add(dianaCuadrada);

        BeneficioGaseosa beneficioGaseosa = new BeneficioGaseosa("Gaseosa gratis", "Ana");
        beneficioGaseosa.anadirGaseosa(new Gaseosa("Cola"));

        BeneficioComida beneficioComida = new BeneficioComida("Comida gratis", "Bruno");
        beneficioComida.anadirComida(new PlatoComida("Hamburguesa", new HashSet<>(), 800));

        BeneficioTragos beneficioTragos = new BeneficioTragos("Trago gratis", "Carla");
        beneficioTragos.anadirTrago(new Trago("Gin tonic"));

        bar.getBeneficios().add(beneficioGaseosa);
        bar.getBeneficios().add(beneficioComida);
        bar.getBeneficios().add(beneficioTragos);
        bar.getAcumulables().add(beneficioGaseosa);
        bar.getAcumulables().add(beneficioComida);

        System.out.println(dianaCircular.calcularRadio());
        System.out.println(dianaRectangular.calcularRadio());
        System.out.println(dianaCuadrada.calcularRadio());
        System.out.println(beneficioGaseosa.calcularDescuentoExtra());
        System.out.println(beneficioComida.calcularDescuentoExtra());
        System.out.println(bar.obtenerCantTragos());
        System.out.println(bar.obtenerDianaConMasPuntajes().getNombre());

    }
}
