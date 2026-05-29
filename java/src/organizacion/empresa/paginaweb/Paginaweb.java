package organizacion.empresa.paginaweb;

import electrodomesticos.Computadora;
import organizacion.empresa.paginaweb.componentes.CPU;
import organizacion.empresa.paginaweb.componentes.Componente;
import organizacion.empresa.paginaweb.componentes.dispositivo.entrada.DispositivosEntrada;
import organizacion.empresa.paginaweb.componentes.dispositivo.entrada.Mouse;
import organizacion.empresa.paginaweb.componentes.dispositivo.entrada.Teclado;
import organizacion.empresa.paginaweb.componentes.dispositivo.salida.DispositivosSalida;
import organizacion.empresa.paginaweb.componentes.dispositivo.salida.Impresora;
import organizacion.empresa.paginaweb.componentes.dispositivo.salida.Pantalla;
import organizacion.empresa.paginaweb.compras.Compra;
import organizacion.empresa.paginaweb.compras.metodoDePago.Efectivo;
import organizacion.empresa.paginaweb.compras.metodoDePago.Tarjeta;
import personas.Cliente;

import java.util.ArrayList;

public class Paginaweb {
    private ArrayList<Computadora> compusvendidas;
    private ArrayList<Componente> componentes;

    public Paginaweb(){
        compusvendidas = new ArrayList<>();
        componentes = new ArrayList<>();
    }

    public ArrayList<Computadora> getCompusvendidas() {
        return compusvendidas;
    }

    public void setCompusvendidas(ArrayList<Computadora> compusvendidas) {
        this.compusvendidas = compusvendidas;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public void addComponente(Componente c){
        componentes.add(c);
    }

    public void removeComponente(Componente c){
        componentes.remove(c);
    }

    public void mostrarcantDeDispositivosDeES(Computadora c){
        if(!estaVendida(c)) return ;
        System.out.println("Total de dispositivos de E/S: "+c.cantDispositivosDeES());
    }

    private boolean estaVendida(Computadora c){
        return compusvendidas.contains(c);
    }

    public void realizarCompra(Compra c){
        if(c.sePuedeComprar() && c.getMdp().pagar(c.getCompu().calcularTotal())){
            compusvendidas.add(c.getCompu());
        }
    }

    public void mostrarComponenteMasVendido(){
        ArrayList <Integer> cant = new ArrayList<>();
        int max = 0;
        for(Componente c : componentes){
            cant.add(0);
        }
        for(Computadora c : compusvendidas){
            for(Componente com : c.getComponentes()){
                cant.set(componentes.indexOf(com), cant.get(componentes.indexOf(com))+1);
            }
        }
        for(int i = 0; i < cant.size(); i++){
            if(cant.get(i) > cant.get(max)){
                max = i;
            }
        }

        System.out.println("Componente mas vendido: "+componentes.get(max).mostrarNombreYModelo());
    }

    static void main() {

        Paginaweb p = new Paginaweb();

        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente("Macarena","Que tu cuerpo es pa darle alegria cosa buena",897985454);
        Cliente c3 = new Cliente("Sebastián Fernando","Ruiz Ferrante",1178964523);
        Cliente c4 =  new Cliente("Pepe","Factory",4);

        Tarjeta tarj1 = new Tarjeta(50000,545855554,"Galicia");
        Tarjeta tarj2 = new Tarjeta(100,676767676,"Santander");
        Efectivo efectivo = new Efectivo(7500);

        Componente componente1 = new Componente(5,199.99,"Fury 8GB","Kingston");
        Componente componente2 = new Componente(10,49.99,"SSD 1TB","SanDisk");
        Componente componente3 = new Componente(8,499.99,"RTX 3080","Nvidia");
        Componente componente4 = new Componente(15,15.99,"HHD 3TB","Kingston");

        CPU cpu = new CPU(25,13.99,"I9","INTEL");
        CPU cpu2 = new CPU(30,10.99,"Ryzen 7","AMD");

        Mouse mouse = new Mouse(40,5.00,"G509","LOGITECH",1,"USB");
        Teclado teclado = new Teclado(20,5.00,"Horus k618","REDRAGON",1,"USB");

        Impresora impresora = new Impresora(5,150.99,"J508","HP",1,"laser");
        Pantalla pantalla = new Pantalla(12,35.99,"LM751845J","SAMSUNG",1);

        Computadora compu1 = new Computadora();
        Computadora compu2 = new Computadora();

        p.addComponente(componente1);
        p.addComponente(componente2);
        p.addComponente(componente3);
        p.addComponente(componente4);
        p.addComponente(cpu);
        p.addComponente(cpu2);
        p.addComponente(mouse);
        p.addComponente(teclado);
        p.addComponente(impresora);
        p.addComponente(pantalla);

        compu1.addComponente(componente1);
        compu1.addComponente(cpu2);
        compu1.addComponente(mouse);
        compu1.addComponente(impresora);

        compu2.addComponente(cpu);
        compu2.addComponente(componente4);


        Compra compra1 = new Compra(c1,tarj1,compu2);
        Compra compra2 = new Compra(c2,tarj2,compu1);

        p.realizarCompra(compra1);
        p.realizarCompra(compra2);

        compu1.calcularTotal();

        p.mostrarcantDeDispositivosDeES(compu2);

        p.mostrarComponenteMasVendido();

        compra2.mostrarDetalles();
    }

}
