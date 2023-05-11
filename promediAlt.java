package Arboles_binarios;
import java.util.Random;

public class promediAlt {

    
    

public static void main(String[] args) {

    int n = 100; 
    int numTrees = 100; 
    int suma=0;
        
        for (int i = 1; i <= numTrees; i++) {
            arbolBi tree = new arbolBi<Integer>();
            Random rand = new Random();
            for (int j = 0; j < n; j++) {
                int value = rand.nextInt(1000); // Generar un número aleatorio entre 0 y 999
                tree.inserta(value);
            }
            suma= suma + tree.altura(tree.raiz);
            
        }

        System.out.println("el promedio es" + (suma/100));


    }


    
}
