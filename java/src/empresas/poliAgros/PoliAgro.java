package empresas.poliAgros;

import empresas.Empresa;
import utils.Fecha;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class PoliAgro extends Empresa {
    private ArrayList<ProductosEnvasados> productos;

    public PoliAgro(String nombre, ArrayList<ProductosEnvasados> productos) {
        super(nombre);
        this.productos = productos;
    }

    public ArrayList<ProductosEnvasados> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductosEnvasados> productos) {
        this.productos = productos;
    }

    public void agregarpr (ProductosEnvasados pe){
        productos.add(pe);
    }
    public int lote(){
       ProductosEnvasados masreciente = productos.get(0);
       for(ProductosEnvasados p : productos){
           if(p instanceof Productofres && p.getFechaenv().mayorQue(masreciente.getFechaenv())){
               masreciente= p;
           }
       }
       return masreciente.getNlote();
    }

    public int cantproductxpais (PaisOG po){
        int count =0;
            for(ProductosEnvasados pe : productos){
                if(pe.getPaisog().equals(po)){
                    count++;
                }
            }
            return count;
    }

    public void mostrarproductos (){
        for(PaisOG po : PaisOG.values()){
            System.out.println( "cantidad de productos de " + po.name()+ ": " + cantproductxpais(po));
        }
    }

static void main() {
        PoliAgro p = new PoliAgro("lalaal",new ArrayList<>());
    Fecha f = new Fecha(4, 8, 26);
    Productofres pf = new Productofres(f, new Fecha(5, 9, 27), PaisOG.ARGENTINA, 885858, "xele", 546465);
    Productofres pf2 = new Productofres(f, new Fecha(25, 9, 27), PaisOG.BRASIL, 888968, "ricota", 556888);
    Productorefri pr1 = new Productorefri(new Fecha(4, 9, 26), new Fecha(6, 5, 28), PaisOG.CHILE, 687865498, "RHTA", 654488, 58);
    Productorefri pr2 = new Productorefri(new Fecha(12, 6, 26), new Fecha(6, 5, 28), PaisOG.URUGUAY, 987657498, "LIUG", 974388, 5);
    Productorefri pr3 = new Productorefri(new Fecha(9, 9, 26), new Fecha(6, 11, 28), PaisOG.ARGENTINA, 12345678, "TYUU", 963852, 21);
    p.agregarpr(pf);
    p.agregarpr(pf2);
    p.agregarpr(pr1);
    p.agregarpr(pr2);
    p.agregarpr(pr3);
    p.mostrarproductos();

}
}