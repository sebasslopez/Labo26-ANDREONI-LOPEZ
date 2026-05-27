package organizacion.empresa.paginaweb;

import organizacion.empresa.paginaweb.componentes.Componente;
import organizacion.empresa.paginaweb.compras.Compra;
import personas.Cliente;

import java.util.ArrayList;

public class Paginaweb {
    private ArrayList<Computadora> compusvendidas;
    private ArrayList<Componente> componentes;

    static void main() {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente("Macarena","Que tu cuerpo es pa darle alegria cosa buena",897985454);
        Cliente c3 = new Cliente("Sebastián Fernando","Ruiz Ferrante",1178964523);
        Cliente c4 =  new Cliente("Pepe","Factory",4);

    }

}
