package empresas.poliAgros;

import empresas.Empresa;

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
}
