package edificaciones.tiendas.tiendaElectronica;

import electro.Cargador;
import electro.multimedia.Calidad;
import electro.multimedia.EquiposDeSonido;
import electro.multimedia.Televisor;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<ProductoElectronico> productos;

    public Tienda(){
        productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoElectronico p){
        productos.add(p);
    }

    public void sacarProducto(ProductoElectronico p){
        productos.remove(p);
    }

    public void modificarProducto(int index,ProductoElectronico p){
        productos.set(index,p);
    }

    public ArrayList<ProductoElectronico> productosDeSeccion(Seccion s){
        ArrayList<ProductoElectronico> prods = new ArrayList<>();
        for(ProductoElectronico e : productos){
            if(e.tieneLaMismaSeccion(s)) prods.add(e);
        }
        return prods;
    }

    public void tenerProductoMayorStock(){
        ProductoElectronico mayol = productos.getFirst();
        for(ProductoElectronico p : productos){
            if(p.tieneMasStockQue(mayol)) mayol = p;
        }
        System.out.println(mayol.mostrarDatos());
    }

    public void tenerProductoMenorStock(){
        ProductoElectronico menol = productos.getFirst();
        for(ProductoElectronico p : productos){
            if(p.tieneMenosStockQue(menol)) menol = p;
        }
        System.out.println(menol.mostrarDatos());
    }

    public void mostrarProductosDeSeccion(Seccion seccion){
        for ( ProductoElectronico p : productosDeSeccion(seccion)){
            System.out.println(p.mostrarDatos());
        }
    }

    static void main() {
        Tienda t = new Tienda();
        EquiposDeSonido prod1 = new EquiposDeSonido("Parlante re epico xd lol",0.1,15, Seccion.MULTIMEDIA,true);
        ProductoElectronico prod2 = new ProductoElectronico("Cargador six seven watts",4558.99,10,Seccion.CARGADORES);
        Cargador prod3 = new Cargador("un cargador samsung no tan bueno :(",4.99,35,Seccion.CARGADORES,100);
        Televisor prod4 = new Televisor("tung tung tv",149.99,23,Seccion.MULTIMEDIA, Calidad.FULL_HD);

        t.agregarProducto(prod1);
        t.agregarProducto(prod2);
        t.agregarProducto(prod3);
        t.agregarProducto(prod4);

        t.mostrarProductosDeSeccion(Seccion.MULTIMEDIA);
        t.mostrarProductosDeSeccion(Seccion.CARGADORES);

        t.tenerProductoMayorStock();
        t.tenerProductoMenorStock();

    }
}
