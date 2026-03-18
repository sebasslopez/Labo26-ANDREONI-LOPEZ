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
float promedio(int & cantidad,float total){
    float promedio = 0;
    promedio = total/cantidad;
    cantidad = 0;
    return promedio;
}
void mayorcito(producto_t producto,producto_t & mayor_producto,int & mayor_columna,int columna){
    if(producto.precio > mayor_producto.precio) {
        mayor_producto = producto;
        mayor_columna = columna+1;
    }
}


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
        for(int filas = 0; filas < supermercado[0].size(); filas++) {
            for(int columna = 0; columna < supermercado[0][filas].size(); columna++) {
                contador_productos++;
                mayorcito(supermercado[0][filas][columna],mayor_producto,columna_mayor_precio,columna);
                if(supermercado[0][filas][columna].fecha_de_vencimiento) contador_productos_fecha_vencimiento++;
                promedio_precio += supermercado[0][filas][columna].precio;
            }
        }
        promedio(contador_productos,promedio_precio);
    cout<<"Columna con el producto de mayor precio: "<<columna_mayor_precio<<endl;
    cout<<"Nombre del producto de la fila 2 columna 3: "<<supermercado[0][1][2].nombre<<endl;
    cout<<"Promedio de precios: "<<promedio_precio<<endl;
    cout<<"Cantidad de productos con fecha de vencimiento: "<<contador_productos_fecha_vencimiento<<endl;
    return 0;
}