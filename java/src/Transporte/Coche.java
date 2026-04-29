package Transporte;

public class Coche extends Vehiculos{
    private String marca;
    private String modelo;
    private String color;
    private int velocidad;

    public Coche(String marca, String modelo, String color, int patente, int anio, int cantruedas, int velocidad) {
        super(marca, modelo, color, patente, anio, cantruedas);
        this.velocidad = velocidad;
    }
    public int getVelocidad() {
        return velocidad;
    }

   public int acelerar(){
       int incremento = 0;
        if(incremento >0){
            velocidad+=incremento;
        }else{
            incremento++;
        }
        return velocidad;
   }

   public int desacelerar (){
       int decremento =0;
        if(decremento>0){
            velocidad -= decremento;
        }else{
            decremento++;
        }
        if(velocidad <0){
            velocidad=0;
        }
        return velocidad;
   }

   public String vel(){
       return "la vel es:"+velocidad;
   }

    public static void main(String[] args) {
        Coche coche= new Coche("Audi","R8","Blanco");
        Coche coche2= new Coche("Audi","TT","negro");
        Coche coche3= new Coche("Audi","A1","gris");
        System.out.println(coche.vel());

    }
}
