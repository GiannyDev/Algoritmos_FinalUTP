package arbolBB;

public class NArbol {
    private int dato;
    private NArbol izq,der;

    public NArbol(int dato) {
        this.dato   = dato;
        this.izq    = null;
        this.der    = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NArbol getIzq() {
        return izq;
    }

    public void setIzq(NArbol izq) {
        this.izq = izq;
    }

    public NArbol getDer() {
        return der;
    }

    public void setDer(NArbol der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return "NArbol{" + "dato=" + dato + ", izq=" + izq + ", der=" + der + '}';
    }
    
}
