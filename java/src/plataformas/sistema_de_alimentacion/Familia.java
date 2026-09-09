package plataformas.sistema_de_alimentacion;

import personas.Familiar;
import personas.Medidor;
import utils.Fecha;

import java.util.HashSet;

public class Familia {

    private HashSet<Familiar> familiares;

    public Familia() {
        this.familiares = new HashSet<>();
    }

    public HashSet<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(HashSet<Familiar> familiares) {
        this.familiares = familiares;
    }

    public void agregarFamiliar(Familiar f){
        familiares.add(f);
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
            if(masCalConsumidas==null || masCalConsumidas.calcularCalorias()<fa.calcularCalorias()){
                masCalConsumidas=fa;
            }
        }
        return masCalConsumidas;
    }

    public Familiar familiarMenosCal(){
        Familiar menosCalConsumidas =null;
        for(Familiar fa: familiares){
            if(menosCalConsumidas==null || menosCalConsumidas.calcularCalorias()>fa.calcularCalorias()){
                menosCalConsumidas=fa;
            }
        }
        return menosCalConsumidas;
    }

    public int promCal(Familiar f){
        return f.promedioCalorias();
    }
    
    public int promCal(){
        int total = 0;
        for(Familiar f : familiares){
            total += f.promedioCalorias();
        }
        return total/familiares.size();
    }

    public HashSet<Familiar> familiarComeEstePlato(PlatoComida p){
        HashSet<Familiar> fs = new HashSet<>();
        for (Familiar f : familiares){
            if(f.comioEstePlato(p)) fs.add(f);
        }
        return fs;
    }
    
    public HashSet<PlatoComida> queComen(){
        HashSet<PlatoComida> platos = new HashSet<>();
        for(Familiar f : familiares){
            platos.addAll(f.getComidas().keySet());
        }
        return platos;
    }


    static void main(String[] args){
        Familiar f1 = new Familiar("castelli","luca",new Fecha(31,5,2009));
        Familiar f2=  new Familiar("sbas","tian",new Fecha(11,11,1111));
        Familiar  f3= new Familiar("martina","andreoni",new Fecha(27,5,2009));
        PlatoComida p1= new PlatoComida()

        Familia familia = new Familia();
        familia.agregarFamiliar(f1);
        familia.agregarFamiliar(f2);
        familia.agregarFamiliar(f3);
        familia.eliminarFamiliar(f3);


    }
}
