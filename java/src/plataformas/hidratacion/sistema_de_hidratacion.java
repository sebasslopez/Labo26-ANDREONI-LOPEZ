package plataformas.hidratacion;

import exceptions.BebidaNoEncontradaException;
import exceptions.CantidadInsuficienteException;
import exceptions.DniYaRegistradoException;
import exceptions.SinBebedoresException;
import exceptions.SinComponenteException;
import personas.Bebedor;

import java.util.ArrayList;

public class sistema_de_hidratacion {

    private ArrayList<Bebedor> bebedores;
    private ArrayList<Bebida> bebidas;

    public sistema_de_hidratacion() {
        this.bebedores = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }

    public void anadirBebedor(Bebedor b) throws DniYaRegistradoException, SinComponenteException {
        if (b == null){
            throw new SinComponenteException("ERROR: no se puede registrar un bebedor null");
        }
        Bebedor existente = obtenerBebedorPorDni(b.getDni());
        if (existente != null){
            throw new DniYaRegistradoException(b.getDni(), existente.getNombreCompleto());
        }
        bebedores.add(b);
        System.out.println("Bebedor " + b.getNombreCompleto() + " (dni " + b.getDni() + ") registrado");
    }

    public void removerBebedor(Bebedor b){
        bebedores.remove(b);
    }

    public ArrayList<Bebedor> getBebedores() {
        return bebedores;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public boolean existeBebedorConDni(int dni){
        return obtenerBebedorPorDni(dni) != null;
    }

    public Bebedor obtenerBebedorPorDni(int dni){
        for(Bebedor b : bebedores){
            if(b.getDni() == dni) return b;
        }
        return null;
    }

    public void agregarBebida(Bebida b){
        if (b == null || obtenerBebidaPorNombre(b.getNombre()) != null){
            System.out.println("No se puede agregar la bebida '" + (b == null ? "null" : b.getNombre()) + "': ya existe en el sistema");
            return;
        }
        bebidas.add(b);
    }

    public Bebida obtenerBebidaPorNombre(String nombre){
        for(Bebida b : bebidas){
            if(b.getNombre().equalsIgnoreCase(nombre)) return b;
        }
        return null;
    }

    public Bebida obtenerBebida(String nombre) throws BebidaNoEncontradaException {
        Bebida b = obtenerBebidaPorNombre(nombre);
        if (b == null){
            throw new BebidaNoEncontradaException(nombre);
        }
        return b;
    }

    public void consumir(Bebedor b, String nombreBebida, int cantidad) throws SinComponenteException, BebidaNoEncontradaException, CantidadInsuficienteException {
        if (b == null){
            throw new SinComponenteException("ERROR: no se puede registrar el consumo de un bebedor null");
        }
        if (!existeBebedorConDni(b.getDni())){
            throw new SinComponenteException("ERROR: " + b.getNombreCompleto() + " no esta registrado en el sistema");
        }
        Bebida bebida = obtenerBebida(nombreBebida);
        if (!bebida.tieneCantidad(cantidad)){
            throw new CantidadInsuficienteException(bebida.getNombre(), cantidad, bebida.getCantidadDisponible());
        }
        bebida.descontar(cantidad);
        b.anadirBebida(bebida, cantidad);
        System.out.println(b.getNombreCompleto() + " consumio " + cantidad + " de '" + bebida.getNombre() + "' (quedan " + bebida.getCantidadDisponible() + ")");
    }

    public void reponerBebida(String nombreBebida, int cantidad) throws BebidaNoEncontradaException, SinComponenteException {
        if (cantidad <= 0){
            throw new SinComponenteException("ERROR: la cantidad a reponer debe ser mayor a 0");
        }
        Bebida bebida = obtenerBebida(nombreBebida);
        bebida.reponer(cantidad);
        System.out.println("Se repusieron " + cantidad + " de '" + bebida.getNombre() + "' (quedan " + bebida.getCantidadDisponible() + ")");
    }

    public Bebedor obtenerMejorCoef() throws SinBebedoresException {
        if (bebedores.isEmpty()){
            throw new SinBebedoresException();
        }
        Bebedor mayor = bebedores.getFirst();
        for(Bebedor b : bebedores){
            if(mayor.calcularCoefHidratacion() < b.calcularCoefHidratacion()) mayor = b;
        }
        return mayor;
    }

    public Bebedor obtenerPeorCoef() throws SinBebedoresException {
        if (bebedores.isEmpty()){
            throw new SinBebedoresException();
        }
        Bebedor menor = bebedores.getFirst();
        for(Bebedor b : bebedores){
            if(b.calcularCoefHidratacion() < menor.calcularCoefHidratacion()) menor = b;
        }
        return menor;
    }

    public void mostrarBebidas(){
        System.out.println("Bebidas del sistema:");
        for(Bebida b : bebidas){
            System.out.println("   " + b);
        }
    }

    public void mostrarBebedores(){
        System.out.println("Bebedores del sistema:");
        for(Bebedor b : bebedores){
            System.out.println("   " + b.getNombreCompleto() + " (dni " + b.getDni() + ") coeficiente: " + b.calcularCoefHidratacion());
        }
    }

    static void main() {
        sistema_de_hidratacion sistema = new sistema_de_hidratacion();

        System.out.println("--- Sistema sin bebedores ---");
        try {
            sistema.obtenerMejorCoef();
        } catch (SinBebedoresException e) {
            System.out.println(e.getMessage());
        }

        try {
            sistema.obtenerPeorCoef();
        } catch (SinBebedoresException e) {
            System.out.println(e.getMessage());
        }

        Bebida_Azucarada gaseosa = new Bebida_Azucarada("Gaseosa", 30, 10);
        Bebida_alcoholica vino = new Bebida_alcoholica(12, "Vino", 3);
        sistema.agregarBebida(gaseosa);
        sistema.agregarBebida(vino);

        Bebedor ana = new Bebedor("Ana", "Ruiz", 30111222);
        Bebedor bruno = new Bebedor("Bruno", "Diaz", 30444555);
        Bebedor duplicado = new Bebedor("Tomas", "Gomez", 30111222);

        System.out.println();
        System.out.println("--- Alta de bebedores ---");
        try {
            sistema.anadirBebedor(ana);
        } catch (DniYaRegistradoException e) {
            System.out.println("Alta rechazada por dni: " + e.getMessage());
        } catch (SinComponenteException e) {
            System.out.println("Alta rechazada: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Alta con dni ya registrado ---");
        try {
            sistema.anadirBebedor(duplicado);
        } catch (DniYaRegistradoException e) {
            System.out.println("Alta rechazada por dni: " + e.getMessage());
        } catch (SinComponenteException e) {
            System.out.println("Alta rechazada: " + e.getMessage());
        }

        try {
            sistema.anadirBebedor(bruno);
        } catch (DniYaRegistradoException e) {
            System.out.println("Alta rechazada por dni: " + e.getMessage());
        } catch (SinComponenteException e) {
            System.out.println("Alta rechazada: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Consumo de bebida inexistente ---");
        try {
            sistema.consumir(ana, "Mate", 1);
        } catch (BebidaNoEncontradaException e) {
            System.out.println("Consumo rechazado por bebida: " + e.getMessage());
        } catch (CantidadInsuficienteException e) {
            System.out.println("Consumo rechazado por cantidad: " + e.getMessage());
        } catch (SinComponenteException e) {
            System.out.println("Consumo rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Consumo con cantidad insuficiente ---");
        try {
            sistema.consumir(ana, "Gaseosa", 50);
        } catch (CantidadInsuficienteException e) {
            System.out.println("Consumo rechazado por cantidad: " + e.getMessage());
        } catch (BebidaNoEncontradaException e) {
            System.out.println("Consumo rechazado por bebida: " + e.getMessage());
        } catch (SinComponenteException e) {
            System.out.println("Consumo rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Consumos validos ---");
        try {
            sistema.consumir(ana, "Gaseosa", 4);
        } catch (BebidaNoEncontradaException | CantidadInsuficienteException | SinComponenteException e) {
            System.out.println("Consumo rechazado: " + e.getMessage());
        }

        try {
            sistema.consumir(bruno, "Vino", 3);
        } catch (BebidaNoEncontradaException | CantidadInsuficienteException | SinComponenteException e) {
            System.out.println("Consumo rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Estado final ---");
        sistema.mostrarBebidas();
        sistema.mostrarBebedores();

        try {
            Bebedor mejor = sistema.obtenerMejorCoef();
            Bebedor peor = sistema.obtenerPeorCoef();
            System.out.println("Mejor coeficiente: " + mejor.getNombreCompleto() + " (" + mejor.calcularCoefHidratacion() + ")");
            System.out.println("Peor coeficiente: " + peor.getNombreCompleto() + " (" + peor.calcularCoefHidratacion() + ")");
        } catch (SinBebedoresException e) {
            System.out.println(e.getMessage());
        }
    }

}
