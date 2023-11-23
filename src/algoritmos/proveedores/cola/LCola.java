package algoritmos.proveedores.cola;

import code.Proveedor;
import java.util.ArrayList;

public class LCola
{

    private NProveedor cabeza;
    private NProveedor fin;
    private int nElementos = 0;
    private int tope= 0;
    
    private class NProveedor
    {
        private Proveedor proveedor;
        private NProveedor siguiente = null;
        
        public NProveedor(Proveedor proveedor)
        {
            this.proveedor = proveedor;
        }
    }

    public Integer getTope() {
        return tope;
    }

    public void setTope(Integer tope) {
        this.tope = tope;
    }
    
    // Methods
    
    public void insertInCola(Proveedor proveedor)
    {
        NProveedor nuevo = new NProveedor(proveedor);
        
        if(this.tope != this.nElementos)
        {
            
            if(cabeza == null)
            {
                cabeza = fin = nuevo;
            }else {
                this.fin.siguiente = nuevo;
                fin = this.fin.siguiente;
            }
            
            nElementos++;
            
        }else {
            System.out.println("No se puede insertar mas porque la cola esta llena");
        }
        
        
        
    }

    public void deleteFromCola()
    {
        NProveedor dato = new NProveedor(null);
        if(cabeza != null){
            dato = this.cabeza;
            this.cabeza = this.cabeza.siguiente;
            nElementos--;
            
        }else{
            System.out.println("No hay elements en la cola");
        }
        
        System.out.println("Proveedor eliminado: " + dato.proveedor.getNombre() );
    }
    
    public void showElements()
    {
        NProveedor inicio = cabeza;
        
        while(inicio != null)
        {
            System.out.println(inicio.proveedor);
            inicio = inicio.siguiente;
        }
    }
  public ArrayList<Proveedor> showProveedor()
    {
        ArrayList<Proveedor> proveedor = new ArrayList<>();
        
        if(cabeza == null)
        {
            System.out.println("lista vacía");
        }else {
            NProveedor puntero = cabeza;
            
            while(puntero != null)
            {
                proveedor.add(puntero.proveedor);
                puntero = puntero.siguiente;
            }
        }
        
        System.out.println(proveedor);
        
        return proveedor;
    }

}