import javax.swing.*;
import java.util.Random;

    public class Matriz {
        public static void main(String[] args) {
            Matriz matriz = new Matriz();
            matriz.ingresarDimension();
            matriz.verificarDimension();
            matriz.crearMatriz();
            matriz.completarMatriz();
            matriz.mostrarFila();

            if (matriz.matrizTipoCero()) {
                System.out.println("La matriz generada es de TIPO CERO.");
            } else {
                System.out.println("La matriz generada no es de TIPO CERO.");
            }
        }
    //Parametros
    int filas;
    int columnas;
    int[][] matriz;


    //Metodos
    public void ingresarDimension(){
        filas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de filas de la matriz: "));
        columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de columnas de la matriz: "));
    }

    public void verificarDimension(){
        if (validarDimensiones(filas,columnas)){
            System.out.println("Las dimensiones son validas");
        }
        else {
            System.out.println("Las dimensiones no son validas");
        }
    }

    public static boolean validarDimensiones(int filas, int columnas){
        if (filas > 0 && columnas > 0){
            return true;
        }
        else {
            return false;
        }
    }
    public void crearMatriz() {
        if (validarDimensiones(filas, columnas)) {
            int[][] matriz = new int[filas][columnas];
            System.out.println("Matriz creada:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No se puede crear la matriz debido a dimensiones no válidas.");
        }
    }

    public void completarMatriz(){
        if (validarDimensiones(filas, columnas)) {
            int[][] matriz = new int[filas][columnas];
            Random random = new Random();

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = random.nextInt(9) + 1;
                }
            }

            System.out.println("Matriz completada con números aleatorios:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


    public boolean matrizTipoCero(){
        if (validarDimensiones(filas, columnas) && matriz != null) {
            int cantidadCeros = 0;
            int totalElementos = filas * columnas;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] == 0) {
                        cantidadCeros++;
                    }
                }
            }
            return cantidadCeros > (totalElementos / 2); // Verificar si más del 50% son ceros.
        } else {
            System.out.println("La matriz no ha sido inicializada o las dimensiones no son válidas.");
            return false;
        }
    }
    public void mostrarFila(){
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la fila que quieres ver"));
        if (validarDimensiones(filas, columnas) && matriz != null && fila >= 0 && fila < filas) {
            System.out.println("Fila " + fila + " de la matriz:");
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[fila][j] + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se puede mostrar la fila especificada debido a dimensiones no válidas o fila fuera de rango.");
        }
    }

    private static int mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Verificar Dimensiones");
        System.out.println("2. Crear Matriz, Completar Matriz, Mostrar Fila y Verificar Tipo CERO");
        System.out.println("3. Cerrar Programa");
        return Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de la opción deseada:"));
    }

}


