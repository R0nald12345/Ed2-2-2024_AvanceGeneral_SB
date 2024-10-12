/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ArbolMVias<K extends Comparable<K>> implements IArbolBusqueda<K> {

    protected NodoMVias<K> raiz;

    protected int orden; //Cantidad Hijos
    protected int POSICION_INVALIDA = -1;

    //Constructor
    public ArbolMVias(){
        this.orden = 3;
    }
    
    public ArbolMVias(int orden){
        this.orden = orden;
    }
    
    @Override
    public void vaciar() {
        this.raiz = null;
    }

    @Override
    public boolean esArbolVacio() {
        return this.raiz == null;
    }

    @Override
    public int size() {
        return sizeR(this.raiz);
    }

    private int sizeR(NodoMVias<K> raizAuxiliar) {
        //Verficio si mi arbol esta vacio
        if (raizAuxiliar == null) {
            return 0;
        }
        if (raizAuxiliar.esHoja()) {
            return 1;
        }
        //Caso general (Arbol Lleno)
        int contador = 0;
        for (int i = 0; i < this.orden; i++) {
            contador = contador + sizeR(raizAuxiliar.getHijo(i));
        }
        return contador + 1;
    }

    @Override
    public int altura() {
        return alturaR(this.raiz);
    }

    private int alturaR(NodoMVias<K> raizAuxiliar) {
        if (raizAuxiliar == null) {
            return 0;
        }
        if (raizAuxiliar.esHoja()) {
            return 1;
        }
        int mayorAnterior = 0;
        for (int i = 0; i < this.orden; i++) {
            int mayorNuevo = alturaR(raizAuxiliar.getHijo(i));
            if (mayorAnterior < mayorNuevo) {
                mayorAnterior = mayorNuevo;
            }
        }
        return mayorAnterior + 1;
    }

    @Override
    public int nivel() {
        return this.altura() - 1;
    }

    @Override
    public K minimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public K maximo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(K ClaveInsertar) {
        //Si mi arbol esta vacio
        if (this.esArbolVacio() == true) {
            NodoMVias nuevoNodo = new NodoMVias(this.orden, ClaveInsertar);
            this.raiz = nuevoNodo;
        } else {
            this.insertarRecursivo(this.raiz, ClaveInsertar);
        }
    }

    private void insertarRecursivo(NodoMVias<K> raizAuxiliar, K ClaveInsertar) {
        int posicionClaveExistente = this.getPosicionDeClave(raizAuxiliar, ClaveInsertar);
        //Si mi arbol es Hoja
        if (raizAuxiliar.esHoja()) {
            //Verifico si mi arbol es hoja y ademas esa hoja esta lleno sus claves
            if (raizAuxiliar.estanClaveLlenas()) {
                int posicionPorDondeBajar = this.getPosicionPorDondeBajar(raizAuxiliar, ClaveInsertar);
                NodoMVias<K> nuevoHijo = new NodoMVias<>(this.orden, ClaveInsertar);
                raizAuxiliar.setHijo(posicionPorDondeBajar, nuevoHijo);
            } else {
                this.insertarClaveEnNodo(raizAuxiliar, ClaveInsertar);
            }
        }else{
            //Que pasa si mi arbol no es Hoja
            int posicionPorDondebajar = this.getPosicionPorDondeBajar(raizAuxiliar, ClaveInsertar);
            if(raizAuxiliar.esHijoVacio(posicionPorDondebajar)){
                NodoMVias<K> nuevoHijo = new NodoMVias<>(this.orden, ClaveInsertar);
                raizAuxiliar.setHijo(posicionPorDondebajar, nuevoHijo);
            }else{
                this.insertarRecursivo(raizAuxiliar.getHijo(posicionPorDondebajar), ClaveInsertar);
            }
        }
    }

    private int getPosicionDeClave(NodoMVias<K> nodoActual, K claveInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveInsertar.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    private int getPosicionPorDondeBajar(NodoMVias<K> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    private void insertarClaveEnNodo(NodoMVias<K> nodoActual, K claveAInsertar) {
//        int posicionClaveExistente = this.getPosicionDeClave(raizAuxiliar, ClaveInsertar);
        int posicionDondeInsertar = getPosicionDondeInsertar(nodoActual, claveAInsertar);
        int posicionActual = nodoActual.cantidadDeClavesNoVacias();
        while(posicionActual > posicionDondeInsertar){
            K claveActual = nodoActual.getClave( posicionActual -1 );
            nodoActual.setClave(posicionActual, claveActual);
            posicionActual--;
        }
        nodoActual.setClave(posicionDondeInsertar, claveAInsertar);
    }
    
    

    private int getPosicionDondeInsertar(NodoMVias<K> nodoActual, K claveAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveAInsertar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    @Override
    public boolean contiene(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
     public List<K> recorridoEnInOrden() {
        List<K> recorrido = new ArrayList<>();
        this.recorridoEnInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnInOrden(NodoMVias<K> nodoActual, List<K> recorrido) {
        //n == 0
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            recorridoEnInOrden(nodoActual.getHijo(i), recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        recorridoEnInOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()), recorrido);
    }
    
}
