package organizacion.colegio.buffet;

import personas.Profesor;
import utils.Fecha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        Map<Plato,Integer> map = new HashMap<>();
        int max = 0;
        Plato platoMax = null;
        for(Plato plato : menu){
            map.put(plato,0);
        }
        for(Pedido pedido : pedidos){
            map.put(pedido.getPlato(),map.get(pedido.getPlato())+1);
        }
        for(int i = 0; i < 3 && i < map.size(); i++){
            for(Map.Entry<Plato,Integer> entry : map.entrySet()){
                if(entry.getValue()>max){
                    max = entry.getValue();
                    platoMax = entry.getKey();
                }
            }
            System.out.println("Plato: "+platoMax.getNombre() +" Cantidad de platos: "+max);
            map.remove(platoMax);
            max = 0;
            platoMax = null;
        }
    }

    public static void main() {

    }
}
