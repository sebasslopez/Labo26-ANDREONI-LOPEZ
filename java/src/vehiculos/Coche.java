package vehiculos;

public class Coche {
    private String marca;
    private String modelo;
    private String color;
    private int velocidad;

    public Coche (String marca,String modelo,String color){
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.velocidad=0;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
