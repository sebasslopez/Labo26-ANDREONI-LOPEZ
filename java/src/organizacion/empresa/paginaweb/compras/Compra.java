package organizacion.empresa.paginaweb.compras;

import organizacion.empresa.paginaweb.Computadora;
import organizacion.empresa.paginaweb.componentes.CPU;
import organizacion.empresa.paginaweb.componentes.Componente;
import organizacion.empresa.paginaweb.componentes.dispositivo.entrada.DispositivosEntrada;
import organizacion.empresa.paginaweb.componentes.dispositivo.salida.DispositivosSalida;
import organizacion.empresa.paginaweb.compras.metodoDePago.MetodoDePago;
import personas.Cliente;

public class Compra {
    private Cliente cliente;
    private MetodoDePago mdp;
    private Computadora compu;

    public Compra(Cliente cliente, MetodoDePago mdp, Computadora compu) {
        this.cliente = cliente;
        this.mdp = mdp;
        this.compu = compu;
    }

    public boolean sePuedeComprar(){
        return hayCPU() && hayDispDeEntrada() && hayDispDeSalida();
    }

    private boolean hayCPU(){
        boolean hay = false;
        for(Componente c : compu.getComponentes()){
            if(c instanceof CPU cpu){
                hay = true;
            }
        }
        return hay;
    }
    private boolean hayDispDeEntrada(){
        boolean hay = false;
        for(Componente c : compu.getComponentes()){
            if(c instanceof DispositivosEntrada){
                hay = true;
            }
        }
        return hay;
    }
    private boolean hayDispDeSalida(){
        boolean hay = false;
        for(Componente c : compu.getComponentes()){
            if(c instanceof DispositivosSalida){
                hay = true;
            }
        }
        return hay;
    }

}
