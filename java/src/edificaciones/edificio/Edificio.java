package edificaciones.edificio;

import edificaciones.edificio.sistemaAlarmas.Elemento;
import edificaciones.edificio.sistemaAlarmas.GrupoDeElementos;
import electro.sensores.SensorDePresion;
import electro.sensores.SensorDeTemperatura;
import exceptions.AlarmaNoEncontradaException;
import exceptions.SinAlarmasException;

import java.util.ArrayList;
import java.util.Scanner;

public class Edificio {
    private ArrayList<GrupoDeElementos> detesensor;

    public Edificio(){
        this.detesensor = new ArrayList<>();
    }

    public ArrayList<GrupoDeElementos> getDetesensor() {
        return detesensor;
    }

    public void setDetesensor(ArrayList<GrupoDeElementos> detesensor) {
        this.detesensor = detesensor;
    }

    public void addElemento(Elemento e){
        ArrayList<Elemento> elementos = new ArrayList<>();
        elementos.add(e);
        detesensor.add(new GrupoDeElementos(elementos));
    }

    public void addGrupoElementos(GrupoDeElementos e){
        detesensor.add(e);
    }

    public void removeGrupoElementos(GrupoDeElementos e){
        detesensor.remove(e);
    }
    public void hayQueDispararAlarmas(){
        for(GrupoDeElementos g : detesensor){
            for(Elemento e : g.getElementos()){
                e.dispararAlarma();
            }
        }
    }

    public int cantidadDeAlarmas(){
        int cantidad = 0;
        for (GrupoDeElementos g : detesensor){
            cantidad += g.getElementos().size();
        }
        return cantidad;
    }

    public Elemento obtenerAlarma(int numero) throws SinAlarmasException, AlarmaNoEncontradaException {
        int cantidad = cantidadDeAlarmas();
        if (cantidad == 0){
            throw new SinAlarmasException();
        }
        if (numero < 0 || numero >= cantidad){
            throw new AlarmaNoEncontradaException(numero, cantidad);
        }
        int contador = 0;
        for (GrupoDeElementos g : detesensor){
            for (Elemento e : g.getElementos()){
                if (contador == numero){
                    return e;
                }
                contador++;
            }
        }
        throw new AlarmaNoEncontradaException(numero, cantidad);
    }

    public void mostrarInfoDeAlarma(int numero) throws SinAlarmasException, AlarmaNoEncontradaException {
        System.out.println(obtenerAlarma(numero));
    }

    static void main() {
        Edificio edificio = new Edificio();
        edificio.addElemento(new SensorDeTemperatura(true, 30, 2021));
        edificio.addElemento(new SensorDePresion(false, 100, 2019));
        SensorDePresion detector = new SensorDePresion(true, 50, 2023);
        edificio.addElemento(detector);
        detector.setMedida(70);
        edificio.hayQueDispararAlarmas();

        Scanner scanner = new Scanner(System.in);
        int ultima = edificio.cantidadDeAlarmas() - 1;
        boolean consultada = false;
        while (!consultada){
            System.out.print("Ingrese el numero de alarma que desea consultar (entre 0 y " + ultima + "): ");
            String dato = scanner.nextLine().trim();
            int numero;
            try {
                numero = Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido, debe ser un numero entero entre 0 y " + ultima + ".");
                continue;
            }
            try {
                edificio.mostrarInfoDeAlarma(numero);
                consultada = true;
            } catch (SinAlarmasException e) {
                System.out.println(e.getMessage());
            } catch (AlarmaNoEncontradaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
