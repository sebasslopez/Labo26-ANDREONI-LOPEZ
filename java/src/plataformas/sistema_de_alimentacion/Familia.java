package plataformas.sistema_de_alimentacion;

import personas.Familiar;

import java.util.HashSet;

public class Familia {

    private HashSet<Familiar> familiares;

    public Familia(HashSet<Familiar> familiares) {
        this.familiares = familiares;
    }

    public HashSet<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(HashSet<Familiar> familiares) {
        this.familiares = familiares;
    }

    public void eliminarFamiliar( Familiar f){
        familiares.remove(f);
    }

    public void registrarConsumo( PlatoComida p,int cant,  Familiar f){
        f.agregarPlato(p,cant);
    }

    public Familiar familiarMasCal(){
        Familiar masCalConsumidas =null;
        for(Familiar fa: familiares){
            if(masCalConsumidas==null || masCalConsumidas.calcularCal()<fa.calcularCal()){
                masCalConsumidas=fa;
            }
        }
        return masCalConsumidas;
    }

    public Familiar familiarMenosCal(){
        Familiar menosCalConsumidas =null;
        for(Familiar fa: familiares){
            if(menosCalConsumidas==null || menosCalConsumidas.calcularCal()>fa.calcularCal()){
                menosCalConsumidas=fa;
            }
        }
        return menosCalConsumidas;
    }

    public int promCal(Familiar f){
        int cont=0;
        for(Familiar fa: familiares){
            cont++;
        }
        return f.calcularCal()/cont;
    }

}
