package transporte;

public class Coche extends Vehiculo {
    private int velocidad;
    private boolean descapotable= false;

    public Coche(String marca, String modelo, String color, int patente, int anio, int cantruedas, int velocidad, boolean descapotable) {
        super(marca, modelo, color, patente, anio, cantruedas);
        this.velocidad = velocidad;
        this.descapotable = descapotable;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean isDescapotable() {
        return descapotable;
    }

    public void setDescapotable(boolean descapotable) {
        this.descapotable = descapotable;
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
        Coche coche= new Coche("Audi","R8","Blanco", 486869849, 2024, 4, 135,false);
        Coche coche2= new Coche("Audi","TT","negro",894922023,2023,4,124,true);
        Coche coche3= new Coche("Audi","A1","gris",645458686,2025,4,110,false);
        System.out.println(coche.vel());

    }
}
