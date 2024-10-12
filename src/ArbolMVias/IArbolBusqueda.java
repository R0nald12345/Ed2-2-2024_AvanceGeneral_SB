/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

import java.util.List;

/**
 *
 * @author USER
 */
public interface IArbolBusqueda<K extends Comparable<K> > {
    void vaciar();
    boolean esArbolVacio();
    int size(); //cantidad de Nodos
    int altura(); // 3
    int nivel(); // 2
    K minimo();
    K maximo();
    void insertar(K clave);
    
    //V eliminar(K clave);
    boolean contiene(K clave);
    
//    V buscar(K clave);
    List<K> recorridoEnInOrden();
//    List<K> recorridoPreOrden();
//    List<K> recorridoPostOrden();
//    List<K> recorridoPorNiveles();
//    int verificarExiste(NodoMVias<K,V> nodoActual, K claveABuscar);
//    public boolean esClaveVacia(int posicion);
//    int sumarDatosDelNodo();
//    int contarCantidadNumeroPar();
//    void recorridoPostOrdenR();
//    boolean verificarExiste(int dato);
//    int getCantidadClaveNoVaciaPorNivel(int n);
}