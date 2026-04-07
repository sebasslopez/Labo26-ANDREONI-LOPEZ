package FormasGeometricas;

public class Circulo {
    private float radio;


    public Circulo(){

        this.radio = 2;
    }
    public Circulo(float radio) {
        this.radio = radio;
    }

    public float getRadio (){
        return radio;
    }
    public void setRadio(float radio){
        this.radio = radio;
    }

    public double area() {
        return Math.PI * (radio * radio);
    }


    public double perimetro() {
        return 2 * Math.PI * radio;
    }


    public static void main(String[] args){
    Circulo c1 = new Circulo();
    Circulo c2 = new Circulo(5);

        System.out.println(" area del circulo 1"+ c1.area());
        System.out.println("perimetro del circulo 2"+ c2.perimetro());
    }
}
