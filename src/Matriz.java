import javax.swing.*;

    public class Matriz {
    //Parametros
    int filas;
    int columnas;

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
}
