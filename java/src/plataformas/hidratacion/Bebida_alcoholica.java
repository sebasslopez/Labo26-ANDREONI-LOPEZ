package plataformas.hidratacion;

public class Bebida_alcoholica extends Bebida {
     private int cantalcohol;

     public Bebida_alcoholica(int cantalcohol, String nombre){
         super(0,nombre,cantalcohol*20 );
         this.cantalcohol=cantalcohol;
     }

    public int getCantalcohol() {
        return cantalcohol;
    }

    public void setCantalcohol(int cantalcohol) {
        this.cantalcohol = cantalcohol;
    }
}
