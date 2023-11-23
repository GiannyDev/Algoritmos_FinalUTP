package arbolBB;

import javax.swing.JPanel;

public class ArbolBinario {

    private NArbol raiz;
    int num_nodos;
    int alt;

    public ArbolBinario() {
        raiz = null;
    }
    
    public NArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NArbol raiz) {
        this.raiz = raiz;
    }
    
     public boolean agregar(int dato) {
        insertToTree(dato);
        return true;
    }
    
    public void insertToTree(int dato)
    {
        NArbol nuevo = new NArbol(dato);
        
        if(raiz == null)
        {
            raiz = nuevo;
            
        }else {
            NArbol tem = raiz;
            NArbol padre;
            
            while(true)
            {
                padre = tem;
                
                if (dato == tem.getDato()) {
                    
                System.out.println("El valor " + dato + " ya existe en el árbol.");
                
                return;
                
                }else if(dato < tem.getDato()){
                    tem = tem.getIzq();
                
                    if(tem == null)
                    {
                        padre.setIzq(nuevo);
                        return;
                    }
                }else {
                    tem = tem.getDer();
                    if(tem == null)
                    {
                        padre.setDer(nuevo);
                        return;
                    }
                }
            }
        }
    }

    public void deleteFromTree(int dato) {
       
        raiz = deleteNode(raiz, dato);
        
    }

    private NArbol deleteNode(NArbol aux, int dato)
    {
        if(aux == null)
        {
            System.out.println("No se encontro el nodo ha eliminar");
        }else if(dato < aux.getDato())
        {
            NArbol left = deleteNode(aux.getIzq(), dato);
            
            aux.setIzq(left);
        }else if(dato > aux.getDato()){
            
            NArbol right = deleteNode(aux.getDer(), dato);
            
            aux.setDer(right);
            
        }else {
            
            NArbol p = aux;
            
            if(p.getDer() == null)
            {
                aux = p.getIzq();
            }else if(p.getIzq() == null)
            {
                aux = p.getDer();
            }else {
                p = change(p);
            }
            p = null;
            
        }
        
        return aux;
    }
    
    private NArbol change(NArbol aux)
    {
        NArbol p = aux;
        NArbol a = aux.getIzq();
        
        while(a.getDer() != null)
        {
            p = a;
            a = a.getDer();
        }
        aux.setDato(a.getDato());
        if(p == aux)
        {
            p.setIzq(a.getIzq());
        }else {
            p.setDer(a.getIzq());
        }
        
        return a;
    }
    
    public NArbol searchInTree(int dato)
    {
        
        NArbol term = raiz;
        
        while(term.getDato() != dato)
        {
            
            if(dato > term.getDato())
            {
                term = term.getDer();
            }
            if(dato < term.getDato())
            {
                term = term.getIzq();
            }
           
            if(term.getDato() != dato){
                return null;
            }
            
        }
        
        return term;
        
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
