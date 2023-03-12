package Arboles_binarios;

public class Nodo<T> implements Comparable<T> {

    private Nodo<T> padre;
    private Nodo<T> der;
    private Nodo <T> izq;
    private T ele;

    public Nodo(T elemento){
        ele= elemento;
        padre=der=izq=null;
        
    }

    public Nodo(T elemento, Nodo<T> pa){
        ele= elemento;
        padre=pa;
    }


    public Nodo<T> getDer() {
        return der;
    }
    public Nodo<T> getIzq() {
        return izq;
    }
    public T getEle() {
        return ele;
    }
    public Nodo<T> getPadre() {
        return padre;
    }

    public void setDer(Nodo<T> der) {
        this.der = der;
    }
    public void setEle(T ele) {
        this.ele = ele;
    }
    public void setIzq(Nodo<T> izq) {
        this.izq = izq;
    }
    public void setPadre(Nodo<T> padre) {
        this.padre = padre;
    }

    
    @Override
    public int compareTo(T o) {
        
        if(ele.equals(o)){
            return 0;
        }else{
            if(((Comparable<T>) ele).compareTo(o)>0){
                return 1;
            }else{
                return -1;
            }
        }
    }
    
    
}
