package FormasGeometricas;

public class Rectangulo {
    private float base;
    private float altura;

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura= altura;
    }

    public float getBase(){
        return base;
    }
    public void setBase(float base){
        this.base=base;
    }
    public float getAltura(){
        return altura;
    }
    public void setAltura(float altura){
        this.altura=altura;
    }

    public float areap(){
        return base * altura;
    }

    public float perimetro(){
        return ((2*base)+(2*altura));
    }

    public static void main(String[] args) {
        Rectangulo rec1 = new Rectangulo(5,9);
        Rectangulo rec2 = new Rectangulo(8,3);
        System.out.println("area rec 1:"+ rec1.areap());
        System.out.println("perimetro rec 2:"+ rec2.perimetro());
    }
}
