package edificaciones.colegio.buffet;

import personas.Profesor;
import utils.Fecha;

import java.util.ArrayList;

public class Buffet {
    private ArrayList<Plato> menu;
    private ArrayList<Pedido> pedidos;

    public Buffet(ArrayList<Plato> menu, ArrayList<Pedido> pdidis) {
        this.menu = menu;
        this.pedidos = pdidis;
    }

    public ArrayList<Plato> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Plato> menu) {
        this.menu = menu;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pdidis) {
        this.pedidos = pdidis;
    }

    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    public void eliminarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

    public void listarPedidosACocinar(Fecha fecha) {
        for (Pedido pedido : pedidos) {
            if (pedido.getFecha().equals(fecha)) {
                System.out.println("Plato: "+pedido.getPlato().getNombre()+" Precio(con descuento(si es Profesor)): "+
                        (pedido.getPersona() instanceof Profesor profe? pedido.getPlato().getPrecio()*profe.getPorcentajeDescu()/100 : pedido.getPlato().getPrecio()));
            }
        }
    }
    public void listarPendientesDeEntrega(){
        for(Pedido pedido : pedidos){
            if(!pedido.isEntregado()){
                System.out.println(pedido.mostrarDatos());
            }
        }
    }

    public void topTresBestPlatos(){
        ArrayList<Plato> platos = new ArrayList<>();
        ArrayList<Integer> cant = new ArrayList<>();
        int max = -1;
        Plato platoMax = null;
        for(Plato plato : menu){
            platos.add(plato);
            cant.add(0);
        }
        for(Pedido pedido : pedidos){
            int index = platos.indexOf(pedido.getPlato());
            cant.set(index, cant.get(index) + 1);
        }
        for(int i = 0; i < 3 ;i++){
            int j;
            for( j = 0; j<platos.size(); j++){
                if(cant.get(j)>max){
                    max = cant.get(j);
                    platoMax = platos.get(j);
                }
            }
            if(platoMax!=null){
                System.out.println("Plato: "+platoMax.getNombre() +" Cantidad de platos: "+max);
                platos.remove(platoMax);
                cant.remove(j);
                max = -1;
                platoMax = null;
            }
        }
    }

    public static void main() {

    }
}
