package Dao;

import java.util.ArrayList;
import code.CategoriaProducto;

public class CategoriaDao {

    private static ArrayList<CategoriaProducto> categorias = new ArrayList<>();
    private static int nCategorias = 1;
    
    static {
        categorias.add(new CategoriaProducto(nCategorias++, "Galletas", "Galletas Varias"));
        categorias.add(new CategoriaProducto(nCategorias++, "Bebidas", "Bebidas Varias"));
        categorias.add(new CategoriaProducto(nCategorias++, "Abarrotes", "Prodcutos de abarrotes"));
        categorias.add(new CategoriaProducto(nCategorias++, "Prueba", "Descripcion de Prueba"));
    }
    
    public static ArrayList<CategoriaProducto> obtenerCategorias(){
        return categorias;
    }
    
    public static void eliminarItem(int codigo){
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getCodigo() == codigo) {
                categorias.remove(i);
            }
        }
    }

    public static void crearCategoria(CategoriaProducto nuevaCategoria) {
        nuevaCategoria.setCodigo(nCategorias++);
        categorias.add(nuevaCategoria);
    }
}
