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
public class ClaseNodo<K,V> {
    private K clave;
    private V valor;
    private ClaseNodo<K,V> hijoIzquierdo;
    private ClaseNodo<K,V> hijoDerecho;
    
    //Constructor
    public ClaseNodo(K clave, V valor){
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public ClaseNodo<K, V> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(ClaseNodo<K, V> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public ClaseNodo<K, V> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(ClaseNodo<K, V> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public boolean esVacioHijoIzquierdo(){
        return esNodoVacio(this.hijoIzquierdo);
//        return this.hijoIzquierdo == null;
    }
    
    public boolean esVacioHijoDerecho(){
        return esNodoVacio(this.hijoDerecho);
    }
    
    public boolean esHoja(){
        return this.esVacioHijoIzquierdo() && this.esVacioHijoDerecho();
        
//        return this.hijoIzquierdo == null && this.hijoDerecho == null;
    }

    
    
    public boolean esNodoCompleto(){
        return !this.esVacioHijoIzquierdo() && !this.esVacioHijoDerecho();
        
    }
    
    
    //Verifica Si mi Nodo esta vacio
    public static boolean esNodoVacio(ClaseNodo nodo){
        return nodo == nodoVacio();
    }
    
    
    //Me retorna un vacio (Siempre me retorna Null)
    public static ClaseNodo<?,?> nodoVacio(){
        return null;
    }
    
    
}
