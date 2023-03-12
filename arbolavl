package Arboles_binarios;


public class arbolalv<T> {
    private Nodo<T> raiz;

    public arbolalv(){

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
    public  void rotaizq(Nodo<T> actual) {
        Nodo<T> aux = actual.getDer();
            actual.setDer(aux.getIzq());

if (actual.getDer() != null) {
    actual.getDer().setPadre(actual);
}
aux.setPadre(actual.getPadre());
        if (actual.getPadre() == null) {
            this.raiz = aux;
        } else if (actual.getPadre().getIzq() == actual) {
            actual.getPadre().setIzq(aux);
        } else {
            actual.getPadre().setDer(aux);
        }
        aux.setIzq(actual);
        actual.setPadre(aux);/// quitar 

    }
    public  void rotader(Nodo<T> actual) {
        Nodo<T> aux = actual.getIzq();
        actual.setIzq(aux.getDer());
if (actual.getIzq() != null) {
    actual.getIzq().setPadre(actual);
}
aux.setPadre(actual.getPadre());

        if (actual.getPadre() == null) {
            this.raiz = aux;
        } else if (actual.getPadre().getIzq() == actual) {
            actual.getPadre().setIzq(aux);
        } else {
            actual.getPadre().setDer(aux);
        }
        aux.setDer(actual);
        actual.setPadre(aux);/// quitar

    }
    public  void dobleizq(Nodo<T> actual) {
        rotader(actual.getDer());
        rotaizq(actual);
    }  
    public  void dobleder(Nodo<T> actual) {
        rotaizq(actual.getIzq());
        rotader(actual);
    }
    public void balance(Nodo<T> actual) {
        while (actual != null) {
            int balance = equilibrio(actual);
            if (balance > 1) {
                if (equilibrio(actual.getIzq()) < 0) {
                    dobleder(actual);//aqui
                } else {
                    rotader(actual);//aqui
                }
            } else if (balance < -1) {
                if (equilibrio(actual.getDer()) > 0) {
                    dobleizq(actual);//aqui
                } else {
                    rotaizq(actual);//aqui
                }
            }
            actual = actual.getPadre();
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
                this.balance(actual);
                
            }else{
                this.inserta(ele, actual.getDer());
            }
        }else{
            if(actual.getIzq()==null){
                actual.setIzq(new Nodo<T>(ele, actual));
                this.balance(actual);
            }else{
                this.inserta(ele, actual.getIzq());
            }
        }
    }
    public boolean borrar(T dato){
        return this.borrar(dato, raiz);

    }
    public boolean borrar(T ele, Nodo<T> actual){
        if(actual.compareTo(ele)==0){
            if(actual.getDer()==null ||  actual.getIzq()==null){
                if(actual.getDer()==null &&  actual.getIzq()==null){
                    if(actual.getPadre().getDer().equals(actual)){
                        actual.getPadre().setDer(actual.getDer());
                    }else{
                        actual.getPadre().setIzq(null);
                    }
                    actual=null;
                    this.balance(actual);
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
        
        arbolalv<Integer> a = new arbolalv<Integer>();
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
        a.borrar(10);
        a.print();
        //ArrayList<Integer>  re = new ArrayList<Integer>();
        //a.preOrden(a.raiz, re);
        //System.out.println(re.toString());


    }

}
