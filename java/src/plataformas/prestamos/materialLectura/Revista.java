package plataformas.prestamos.materialLectura;

import plataformas.prestamos.Prestable;
import utils.Fecha;

import java.time.LocalDate;

public class Revista extends Material_de_lectura implements Prestable {
    private LocalDate fechapubli;

    public Revista(String titulo, Fecha fecha, int isbn, LocalDate fechapubli) {
        super(titulo, fecha, isbn);
        this.fechapubli = fechapubli;
    }

    public LocalDate getFechapubli() {

        return fechapubli;
    }

    public void setFechapubli(LocalDate fechapubli) {
        this.fechapubli = fechapubli;
    }

    @Override
    public void prestar() {
       if(puedePrestarse()){
           System.out.println("la revista se puede dar");
       }
    }

    @Override
    public boolean puedePrestarse() {
       if(fechapubli.getMonthValue()<LocalDate.now().getMonthValue()-2){
           return true;
       }
       return false;
    }

    @Override
    public void devolver() {
        System.out.println("devolver");
    }

    @Override
    public String toString() {
        return fechapubli+" ";
    }
}
