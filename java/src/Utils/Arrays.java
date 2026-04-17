package Utils;

import Gente.Persona;

import java.util.ArrayList;

public class Arrays {
    private ArrayList<Integer> num;
    private ArrayList<String> pal;
    private ArrayList<Persona> pedad;


    public Arrays(){
        this.num =new ArrayList<>();
        this.pal=new ArrayList<>();
        this.pedad=new ArrayList<>();

    }

    public ArrayList<Integer> getNum() {
        return num;
    }

    public ArrayList<Persona> getPedad() {
        return pedad;
    }

    public ArrayList<String> getPal() {
        return pal;
    }

    public void setNum(ArrayList<Integer> num) {
        this.num = num;
    }

    public void setPal(ArrayList<String> pal) {
        this.pal = pal;
    }

    public void setPedad(ArrayList<Persona> pedad) {
        this.pedad = pedad;
    }
    public void suma(){
        int total = 0;
        for(int n : num){
            total += n;
        }
        System.out.println(total);
    }
    public void Palabra(char letra){
        for(String p : pal){
            if(p.startsWith(Character.toString(letra))){
                System.out.println(p);
            }
        }
    }

    public void Edad(){
        for(Persona pe : pedad){
            if(pe.getEdad()>30){
                System.out.println(pe);
            }



        }
    }
}
