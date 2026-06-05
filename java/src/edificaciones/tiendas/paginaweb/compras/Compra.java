package edificaciones.tiendas.paginaweb.compras;

import electro.Computadora;
import electro.componentes.CPU;
import electro.componentes.Componente;
import electro.componentes.dispositivo.entrada.DispositivosEntrada;
import electro.componentes.dispositivo.salida.DispositivosSalida;
import edificaciones.tiendas.paginaweb.compras.metodoDePago.MetodoDePago;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Computadora getCompu() {
        return compu;
    }

    public void setCompu(Computadora compu) {
        this.compu = compu;
    }

    public MetodoDePago getMdp() {
        return mdp;
    }

    public void setMdp(MetodoDePago mdp) {
        this.mdp = mdp;
    }

    public boolean sePuedeComprar(){
        return hayCPU() && hayDispDeEntrada() && hayDispDeSalida() && hayStock();
    }

    private boolean hayStock(){
        boolean hayStock = true;
        for (Componente c :  compu.getComponentes()){
            if(!c.hayStockSuficiente(1)) hayStock = false;
        }
        return hayStock;
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

    public void disminuirStock(){
        for(Componente c : compu.getComponentes()){
            c.setStock(c.getStock() - 1);
        }
    }

    public void mostrarDetalles(){
        double subtotal = compu.calcularTotal();
        System.out.println("Cliente: "+cliente.getNombreCompleto()+" | subtotal: "+subtotal+" | recargo: "+mdp.calcularRecargo(subtotal)+" | total: "+mdp.calcularTotal(subtotal)
        +" | Paga con: "+mdp.pagaCon()+" | Componentes de la Compu: ");
        compu.mostrarComponentes();
    }
}
