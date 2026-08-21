package plataformas.hidratacion;

import personas.Bebedor;

import java.util.ArrayList;

public class sistema_de_hidratacion {

    private ArrayList<Bebedor> bebedores;
    private int coeficienteH;


    public sistema_de_hidratacion(ArrayList<Bebedor> bebedores) {
        this.bebedores = bebedores;
    }
     public void porcentajehidratacion(){
        for(Bebedor b: bebedores){
            int coeficiente=0;
            for(Bebida be : b.getBebidas()){
                coeficiente= (b.getCantidad().get(b.getBebidas().indexOf(be))  *(be.getCoeficienteP()-be.getCoeficienteN()));
            }
        }
     }

}
