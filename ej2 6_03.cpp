#include <iostream>
#include <vector>
using namespace std;

struct producto_t{
    string nombre;
    int codigo_de_barras;
    string marca;
    double precio;
    bool fecha_de_vencimiento;
};

int main() {
    producto_t mayor_producto;
    float promedio_precio = 0;
    int contador_productos = 0,columna_mayor_precio = 0,contador_productos_fecha_vencimiento = 0;
    vector<vector<vector<producto_t>>> supermercado;
    supermercado.push_back(vector<vector<producto_t>>({
        {{"Leche", 123456, "Marca A", 1.5, true},{"Pan", 234567, "Marca B", 0.8, false},{"Jugo", 345678, "Marca C", 2.0, true},{"Agua", 456789, "Marca D", 0.5, false}},
        {{"Queso", 345678, "Marca C", 2.5, false},{"Yogur", 456789, "Marca D", 1.0, false},{"Mantequilla", 567890, "Marca E", 3.0, false},{"Huevos", 678901, "Marca F", 2.5, true}},
        {{"Carne", 567890, "Marca E", 5.0, false},{"Pescado", 678901, "Marca F", 4.0, false},{"Pollo", 789012, "Marca G", 3.5, true},{"Cerdo", 890123, "Marca H", 4.5, false}}
    }));
    for(int pasillo = 0; pasillo < supermercado.size(); pasillo++) {
        for(int filas = 0; filas < supermercado[pasillo].size(); filas++) {
            for(int columna = 0; columna < supermercado[pasillo][filas].size(); columna++) {
                contador_productos++;
                if(supermercado[pasillo][filas][columna].precio > mayor_producto.precio) {
                    mayor_producto = supermercado[pasillo][filas][columna];
                    columna_mayor_precio = columna+1;
                }
                if(supermercado[pasillo][filas][columna].fecha_de_vencimiento) {
                    contador_productos_fecha_vencimiento++;
                }
                promedio_precio += supermercado[pasillo][filas][columna].precio;
            }
        }
        promedio_precio /= contador_productos;
        contador_productos = 0;
    }
    cout<<"Columna con el producto de mayor precio: "<<columna_mayor_precio<<endl;
    cout<<"Nombre del producto de la fila 2 columna 3: "<<supermercado[0][1][2].nombre<<endl;
    cout<<"Promedio de precios: "<<promedio_precio<<endl;
    cout<<"Cantidad de productos con fecha de vencimiento: "<<contador_productos_fecha_vencimiento<<endl;
    return 0;
}