#include <iostream>
#include <vector>
#include <string>
using namespace std;

struct zombie_t{
    int salud = 100;
    int tipo = 1;
    int daño = 15;
    int velocidad = 5;
};

struct jugador_t{
    int salud = 100;
    string name = "Pedro";
    bool infectado = false;
    int municion = 30;
};
int recibir_mordida(int salud){
    zombie_t zombie;
    int daño = zombie.daño;
    return salud - daño;
}
int main(){
    jugador_t jugador;
     vector <string> mochila;
    zombie_t zombie;
    cout<<"Estado inicial: Salud: "<<jugador.salud<<",Nombre: "<<jugador.name<<endl;
    if(jugador.municion > 0){
        cout<<"¡Disparo efectuado!"<<endl;
        jugador.municion--;
        zombie.salud -= 25;
        cout<<"Acierto,daño: 25, salud: "<<zombie.salud<<", Jugador: "<<jugador.name<<endl;
    }
    else {
        cout<<"¡Click! Sin municion, a correr"<<endl;
    }

    jugador.salud = recibir_mordida(jugador.salud);
    cout<<"Mordida recibida, daño: "<<zombie.daño<<", salud: "<<jugador.salud<<", jugador: "<<jugador.name<<endl;
    for(int i = 0;i<5;i++){ 
        cout<<"Revisando caja #"<<i<<"..."<<endl;
        cout<<"item encontrado: [Medkit]"<<endl;
        mochila.push_back("[Medkit]");
    }

    while(jugador.salud >75){
        cout<<"Ciclo de vida activo, salud: "<<jugador.salud<<", jugador: "<<jugador.name<<endl;
        cout<<"sigues vivo..."<<endl;
        jugador.salud = jugador.salud-5;
    }
    cout<<"Fin de la simulacion."<<endl;
    cout<<"Estado final: Salud: "<<jugador.salud<<", Municion: "<<jugador.municion<<", jugador: "<<jugador.name<<endl;

    return 0;
}
