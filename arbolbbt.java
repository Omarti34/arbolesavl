package Arboles_binarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class arbolbbt<T> {

    private Nodo<T> raiz;

    public arbolbbt(){

    }

    public boolean existe(T ele){
        if(raiz==null){
            return false;
        }else{
            return existe( ele, raiz);
        }
    }
    public boolean existe( T ele, Nodo<T> actual){
        if(actual==null){
            return false;
        }
        if(actual.compareTo(ele)==0){
            return true;
        }else{
            if(actual.compareTo(ele)<0){
                return existe(ele, actual.getDer());
            }else{
                return existe(ele, actual.getIzq());
            }
        }


    }
    public int altura(Nodo<T> actual) {
            if (actual == null) {
                return 0;
            } else {
                int izq = altura(actual.getIzq());
                int der = altura(actual.getDer());
                if (izq > der) {
                    return (izq + 1);
                } else {
                    return (der + 1);
                }
            }
        }
    public static<T> int altura2 (Nodo<T> nodo){
            if (nodo == null) {
                return 0;
            } else {
                int izq = altura2(nodo.getIzq());
                int der = altura2(nodo.getDer());
                if (izq > der) {
                    return (izq + 1);
                } else {
                    return (der + 1);
                }
            }
        }
    public static<T> int equilibrio(Nodo<T> x){
        if(x== null){
            return 0;
        }
        
            return (altura2(x.getIzq())-altura2(x.getDer()));
        
        
    }
    
    public void inserta(T ele){
        if(raiz==null){
            Nodo<T> nuevo = new Nodo<T>(ele);
            this.raiz=nuevo;
        }else{
            this.inserta(ele,raiz);
            
        }
    }
    public void inserta(T ele, Nodo<T> actual){
        if(actual.compareTo(ele)<=0){
            if(actual.getDer()==null){
                actual.setDer(new Nodo<T>(ele,actual));
                this.acomodar(actual);
            }else{
                this.inserta(ele, actual.getDer());
                this.acomodar(actual);
            }
        }else{
            if(actual.getIzq()==null){
                actual.setIzq(new Nodo<T>(ele, actual));
                this.acomodar(actual);
            }else{
                this.inserta(ele, actual.getIzq());
                this.acomodar(actual);
            }
        }


    }


    public void inserta2(T ele){
        if(raiz==null){
            Nodo<T> nuevo = new Nodo<T>(ele);
            this.raiz=nuevo;
        }else{
            
            this.inserta22(ele,raiz);
            
        }
    }
    public void inserta22(T ele, Nodo<T> actual){
        
        
        if(actual.compareTo(ele)<=0){
            if(actual.getDer()==null){
                actual.setDer(new Nodo<T>(ele,actual));
                
            }else{
                this.inserta22(ele, actual.getDer());
                
            }
        }else{
            if(actual.getIzq()==null){
                actual.setIzq(new Nodo<T>(ele, actual));
                
            }else{
                this.inserta22(ele, actual.getIzq());
                
            }
        }
    

    }

    public void acomodar(Nodo<T> actual){
        while (actual != null) {
            int balance = equilibrio(actual);
            if (balance > 1) {
                balanceo(this.raiz);     //aqui y alla abajo
            } else if (balance < -1) {
                balanceo(this.raiz);
            }
            actual = actual.getPadre();
        }
    }



    

    public void balanceo(Nodo<T> actual){
        //Nodo<T> chido = new Nodo<T>();
        T[] nuevo = toArray(actual);
        Nodo<T> chido = new Nodo<T>(nuevo[0]);
        for(int i=1; i<nuevo.length;i++){
            inserta22(nuevo[i], chido);
        }
        this.raiz=chido;
        }
        
    
    

    public static <T> T[] arrayListTo(ArrayList<T> arrayList) {
        // Creamos un arreglo del tipo T con el tamaño del ArrayList
        T[] genericArray = (T[]) new Integer[arrayList.size()];

        // Convertimos el ArrayList al arreglo
        genericArray = arrayList.toArray(genericArray);

        // Devolvemos el arreglo
        return genericArray;
    }

    public T[] toArray(Nodo<T> actual){
        ArrayList<T> arr = new ArrayList();
        llenar(actual, arr);
        
        T[] nuevo = arrayListTo(arr);


        organizarEnArbolBinario(nuevo, 0, nuevo.length-1);
        return nuevo;
        


    }

    
    public static <T> void organizarEnArbolBinario(T[] arreglo, int indiceInicio, int indiceFin) {
        if (indiceInicio > indiceFin) {
            return;
        }

        // Calcular el índice medio
        int indiceMedio = (indiceInicio + indiceFin) / 2;

        // Organizar el elemento en el índice medio
        T temp = arreglo[indiceMedio];
        arreglo[indiceMedio] = arreglo[indiceInicio];
        arreglo[indiceInicio] = temp;

        // Organizar los elementos en los subarreglos izquierdo y derecho recursivamente
        organizarEnArbolBinario(arreglo, indiceInicio + 1, indiceFin); // Subarreglo izquierdo
        organizarEnArbolBinario(arreglo, indiceMedio + 1, indiceFin); // Subarreglo derecho
    }
    public  void llenar(Nodo<T> actual, ArrayList<T> list) {
        if (actual == null) {
        return;
        }
        list.add(actual.getEle());
        llenar(actual.getIzq(), list);
        llenar(actual.getDer(), list);
    }
    public void print() {
        print(raiz, 0);
    }
    private void print(Nodo<T> actual, int level) {
        if (actual != null) {
            print(actual.getDer(), level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(actual.getEle());
            print(actual.getIzq(), level + 1);
        }
    }


    public static void main(String[] args) {
        
        arbolbbt<Integer> a = new arbolbbt<Integer>();

        a.inserta(1);
        a.inserta(2);
        a.inserta(3);
        a.inserta(4);
        a.inserta(5);
        a.inserta(6);
        a.inserta(7);
        a.inserta(8);
        //a.inserta(9);

        Integer[] c= a.toArray(a.raiz);
        System.out.println(c[1]);
        System.out.println(c[2]);
        System.out.println(c[3]);
        System.out.println(c[4]);
        System.out.println(c[5]);
        System.out.println(c[6]);
        System.out.println(c[7]);
        System.out.println(c[0]);
        a.balanceo(a.raiz);

        //a.acomodar(a.raiz);

        a.print();


        
      

        

        
        
        //a.print();
        //a.acomodar(a.raiz);
        //a.print();


    }
    

    
}
