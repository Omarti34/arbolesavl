package Arboles_binarios;

import java.util.ArrayList;

public class arbolBi<T>  {
    public Nodo<T> raiz;

    public arbolBi(){

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
            }else{
                this.inserta(ele, actual.getDer());
            }
        }else{
            if(actual.getIzq()==null){
                actual.setIzq(new Nodo<T>(ele, actual));
            }else{
                this.inserta(ele, actual.getIzq());
            }
        }


    }


    public void preOrden(Nodo<T> actual, ArrayList<T> list) {
        if (actual == null) {
          return;
        }
        list.add(actual.getEle());
        preOrden(actual.getIzq(), list);
        preOrden(actual.getDer(), list);
      }
    
    public void inorden(Nodo<T> actual, ArrayList<T> list) {
        if (actual == null) {
            return;
        }
    
        inorden(actual.getIzq(), list);
        list.add(actual.getEle());
        inorden(actual.getDer(), list);
        }
    
    public void postorden(Nodo<T> actual, ArrayList<T> list) {
        if (actual == null) {
            return;
        }
        postorden(actual.getIzq(), list);
        postorden(actual.getDer(), list);
        list.add(actual.getEle());
        }

    public boolean borrar(T dato){
        return this.borrar(dato, raiz);

    }
    public boolean borrar(T ele, Nodo<T> actual){
        if(actual.compareTo(ele)==0){
            if(actual.getDer()==null ||  actual.getIzq()==null){
                if(actual.getDer()==null &&  actual.getIzq()==null){
                    // hacer que borre la coneccion co el padre para que no se quede guardado en la memoria 
                    //usando if para saber por donde viene y de esa forma usar un setder o setizq para borrar 
                    
                    if(actual.getPadre().getDer().equals(actual)){
                        actual.getPadre().setDer(actual.getDer());
                    }else{
                        actual.getPadre().setIzq(null);
                    }
                    actual=null;
                    
                    return true;  
                }else{
                    if(actual.getIzq()==null ){
                    actual.getDer().setPadre(actual.getPadre());
                    actual.getPadre().setDer(actual.getDer());
                    return true;
                }else{
                    actual.getIzq().setPadre(actual.getPadre());
                    actual.getPadre().setIzq(actual.getIzq());
                    return true;
                    
                }
                }
            }else{
                Nodo<T> aux = this.ayudaNodo(actual.getDer());
                T au2 = aux.getEle();
                actual.setEle(au2);
                aux.setEle(ele);
                return borrar(ele,aux);
            }            
        }else{
            if(actual.compareTo(ele)<0){
                return borrar(ele, actual.getDer());
            }else{
                return borrar(ele, actual.getIzq());
            }
        }
    }


    

    public Nodo<T> ayudaNodo(Nodo<T> aux){
        Nodo<T> actual = aux;
        while (actual.getIzq() != null) {
            actual = actual.getIzq();
        }
        return actual;
    }

        //altura de un arbol 
    public int altura(Nodo<T> node) {
            if (node == null) {
                return 0;
            } else {
                int izq = altura(node.getIzq());
                int der = altura(node.getDer());
                if (izq > der) {
                    return (izq + 1);
                } else {
                    return (der + 1);
                }
            }
        }
    

        public void print() {
            print(raiz, 0);
        }
    
        private void print(Nodo<T> node, int level) {
            if (node != null) {
                print(node.getDer(), level + 1);
                for (int i = 0; i < level; i++) {
                    System.out.print("    ");
                }
                System.out.println(node.getEle());
                print(node.getIzq(), level + 1);
            }
        }

        public boolean isbi(){
            return true;
        }
    

    public static void main(String[] args) {
        arbolBi<Integer> a = new arbolBi<Integer>();
        a.inserta(5);
        a.inserta(3);
        a.inserta(4);
        a.inserta(1);
        a.inserta(2);
        a.inserta(6);
        a.inserta(8);
        a.inserta(7);
        a.inserta(9);
        a.inserta(10);
       
        a.print();
       System.out.println(a.borrar(10));
       a.print();
        //a.preOrden(a.raiz, re);
        //System.out.println(re.toString());
        
        //System.out.println(a.altura(a.raiz));
        






    
    }

    }
