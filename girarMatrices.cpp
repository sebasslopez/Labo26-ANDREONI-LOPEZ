#include <iostream>
using namespace std;

const int N = 5;

void mostrarMatriz(char matriz[N][N])
{
    for(int fila = 0; fila < N; fila++){
        for(int columna = 0; columna < N; columna++){
            cout << matriz[fila][columna] << " ";
        }
        cout << endl;
    }
}

void girarDerecha(char origen[N][N], char destino[N][N])
{
    for(int fila = 0; fila < N; fila++){
        for(int columna = 0; columna < N; columna++){
          destino[(N-1) - columna][(N-1) - fila] = origen[fila][columna];   
        }
        cout << endl;
    }
}

void limpiarPantalla()
{
    for (int i = 0; i < 30; i++)
    {
        cout << endl;
    }
}

int main()
{
    char matriz[N][N] = {
        {'.', '.', '#', '.', '.'},
        {'.', '#', '#', '#', '.'},
        {'#', '#', '#', '#', '#'},
        {'.', '.', '#', '.', '.'},
        {'.', '.', '#', '.', '.'}};

    char girada[N][N];

    girarDerecha(matriz, girada);

    cout << "Matriz original:\n\n";
    mostrarMatriz(matriz);

    cout << "\nPresionar Enter para girarla...";
    cin.get();

    limpiarPantalla();

    cout << "Matriz girada 90 grados a la derecha:\n\n";
    mostrarMatriz(girada);

    return 0;
}