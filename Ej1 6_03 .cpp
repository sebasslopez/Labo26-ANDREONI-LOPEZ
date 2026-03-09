#include <iostream>
#include <vector>

using namespace std;


struct Empleado_t{

    string nombre;
    string apellido;
    int fecha;
    string sexo;
    float salario;
    
};


Empleado_t empleadoConMayorSueldo (vector <Empleado_t> pedro , vector <Empleado_t> &pablo ) {

Empleado_t empleado = pedro[0];
for(int i=0 ; i< pedro.size() ; i++ )
{
    if(pedro[i].salario <= 400000){
        pablo.push_back(pedro[i]);

    }
    if(pedro[i].salario > empleado.salario){
        empleado= pedro[i];
    }
}
return empleado;
}


int main(void){




Empleado_t empleado;
vector <Empleado_t> pedro , pablo;
pedro = {{"Juan", "Peréz",20408,"therian",754564.00},{"Martin", "Barbieri",40255,"masculino",7545.00},{"Rodrigo Nicolas", "Masek Urquizu",180908,"frutillita",1000000},{"Franco", "Diaz",240309,"queer",1.99},{"Sebastian Fernando", "Ruiz Ferrante",171208,"gato persa",5.01}};
empleado= empleadoConMayorSueldo(pedro,pablo);

cout<<empleado.salario<<endl;

for(int i=0; i< pablo.size(); i++){
    
    cout<<pablo[i].nombre<<" "<< pablo[i].apellido<<endl;
}


}