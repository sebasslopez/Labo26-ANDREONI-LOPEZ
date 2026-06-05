package electro.componentes;

import edificaciones.tiendas.tiendaElectronica.Producto;
import electro.componentes.dispositivo.entrada.DispositivosEntrada;
import electro.componentes.dispositivo.salida.DispositivosSalida;

public class Componente extends Producto {
    private String nomfab;


    public Componente(int stock, Double precioventa, String modelo, String nomfab) {
        super(modelo,precioventa,stock);
        this.nomfab = nomfab;
    }

    public String getNomfab() {
        return nomfab;
    }

    public void setNomfab(String nomfab) {
        this.nomfab = nomfab;
    }

    public boolean esDispDeEntrada(){
        return this instanceof DispositivosEntrada;
    }

    public boolean esDispDeSalida(){
        return this instanceof DispositivosSalida;
    }

    public String mostrarNombreYModelo(){
        return nomfab + " " +mostrarNombre();
    }

}
