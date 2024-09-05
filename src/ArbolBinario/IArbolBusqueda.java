/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author USER
 */
public interface IArbolBusqueda<K extends Comparable<K>,V> {
    
    void insertarNodoRecursivo(K Clave,V Valor);
    public int cantidadNodos();
    public int cantidadNodosPares();
    public void recorridoInOrdenR();
    public void recorridoPostOrdenR();
    
    public void porNiveles();
    public int cantidadNodosIncompletos();
  
    
    
    
    
    
}
