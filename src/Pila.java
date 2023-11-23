
import Recursividad.Nodo;

public class Pila {

    private int ContNodo = 0;
    private Nodo Cabeza;

    public int getContNodo() {
        return ContNodo;
    }

    public void setContNodo(int ContNodo) {
        this.ContNodo = ContNodo;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo Cabeza) {
        this.Cabeza = Cabeza;
    }
//apilar un nuevo elemento a mi pila

    public void Push(Nodo N) {
        ContNodo++;
        if (Cabeza == null) {
            Cabeza = N;
        } else {
            N.setAbajo(Cabeza);
            Cabeza.setArriba(N);
            Cabeza = N;
        }
    }

    //desapilar un elemento en la pila
    public void Pop() {
        if (ContNodo > 0) {
            ContNodo--;

            Cabeza = Cabeza.getAbajo();
        }
    }
// devolver un elemento 

    public String Peek() {
        return Cabeza.getDato();

    }

}
