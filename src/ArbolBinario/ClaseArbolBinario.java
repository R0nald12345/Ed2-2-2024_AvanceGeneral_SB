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
public class ClaseArbolBinario<K extends Comparable<K>, V> implements IArbolBusqueda<K, V> {

    //Atributos 
    protected ClaseNodo<K, V> raiz;

//    @Override
//    public int cantidadNodos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public int cantidadNodosIncompletos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorridoInOrdenR() {
        recorridoInOrdenRecursivo(this.raiz);
    }

    private void recorridoInOrdenRecursivo(ClaseNodo<K, V> raizAuxiliar) {
        //Caso Base
        if (raizAuxiliar == null) {
            return;
        }
        recorridoInOrdenRecursivo(raizAuxiliar.getHijoIzquierdo());
        System.out.print(raizAuxiliar.getClave() + " ");
        recorridoInOrdenRecursivo(raizAuxiliar.getHijoDerecho());
//        System.out.println("");
    }

    @Override
    public void insertarNodoRecursivo(K Clave, V valor) {
        this.raiz = insertarRecursivoMask(this.raiz, Clave, valor);
    }

    private ClaseNodo<K, V> insertarRecursivoMask(ClaseNodo<K, V> raizAux, K nuevoClave, V nuevoValor) {
        if (raizAux == null) {
            ClaseNodo<K, V> nuevoNodo = new ClaseNodo<>(nuevoClave, nuevoValor);
            return nuevoNodo;
        } else {
            if (raizAux.getClave().compareTo(nuevoClave) > 0) {
                // La clave es menor, insertar en el subárbol izquierdo
                raizAux.setHijoIzquierdo(insertarRecursivoMask(raizAux.getHijoIzquierdo(), nuevoClave, nuevoValor));
            } else if (raizAux.getClave().compareTo(nuevoClave) == 0) {
                raizAux.setValor(nuevoValor);
            } else {
                raizAux.setHijoDerecho(insertarRecursivoMask(raizAux.getHijoDerecho(), nuevoClave, nuevoValor));
            }
            return raizAux;
        }

    }

//    @Override
//    public int cantidadNodosPares() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public int cantidadNodos() {
        return cantidadNodosMask(this.raiz);
    }

    private int cantidadNodosMask(ClaseNodo<K, V> nodoRaiz) {
        if (nodoRaiz == null) {
            return 0;
        }
        if (nodoRaiz.esHoja()) {
            return 1;
        }
        int i = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        int d = cantidadNodosMask(nodoRaiz.getHijoDerecho());
        return i + d + 1;
    }

    @Override
    public int cantidadNodosPares() {
        return contarNumerosParesRecursivo(this.raiz);
    }

    private int contarNumerosParesRecursivo(ClaseNodo<K, V> raizAuxiliar) {
        //primer caso base (Arbol vacio)
        if (raizAuxiliar == null) {
            return 0;
        }
        //2do Caso Base
        if (raizAuxiliar.esHoja()) {
            int valor = (Integer) raizAuxiliar.getClave();
            if (valor % 2 == 0) {
                return 1;
            } else { //Tomar en consideracion
                return 0;
            }
        }
        //Caso General
        int cantidadHijoI = contarNumerosParesRecursivo(raizAuxiliar.getHijoIzquierdo()); // 2
        int cantidadHijoD = contarNumerosParesRecursivo(raizAuxiliar.getHijoDerecho());  // 1 
        //Verificar Padre
        int valorPadre = (Integer) raizAuxiliar.getClave();
        if (valorPadre % 2 == 0) {
            return cantidadHijoI + cantidadHijoD + 1;
        } else {
            return cantidadHijoI + cantidadHijoD;
        }

    }

    @Override
    public void porNiveles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorridoPostOrdenR() {
        recorridoPostOrdenRecursivo(this.raiz);
    }

    private void recorridoPostOrdenRecursivo(ClaseNodo<K, V> raizAuxiliar) {
        if (raizAuxiliar == null) {
            return;
        }
        recorridoPostOrdenRecursivo(raizAuxiliar.getHijoIzquierdo());
        recorridoPostOrdenRecursivo(raizAuxiliar.getHijoDerecho());
        System.out.print(raizAuxiliar.getClave() + " ");
    }

    //Eliminar x de un Arbol
    public void eliminarX(int valorX) { //valorX = 100
        this.raiz = eliminarXRecursivo(this.raiz, valorX);
    }

    private ClaseNodo<K, V> eliminarXRecursivo(ClaseNodo<K, V> raizAuxiliar, int valorX) {
        if (raizAuxiliar == null) {
            return raizAuxiliar; //Finalice el procedimiento
        } else {
            //en el caso que tenga 1 solo Nodo
            int ClaveRaiz = (Integer) raizAuxiliar.getClave();
            if (ClaveRaiz == valorX) {
                return eliminarNodo(raizAuxiliar);
            }

            //Caso general
            if (valorX < ClaveRaiz) {
                ClaseNodo<K, V> nuevoSubArbolIzquierdo = eliminarXRecursivo(raizAuxiliar.getHijoIzquierdo(), valorX);
                raizAuxiliar.setHijoIzquierdo(nuevoSubArbolIzquierdo);
            } else {
                ClaseNodo<K, V> nuevoSubArbolDerecho = eliminarXRecursivo(raizAuxiliar.getHijoDerecho(), valorX);
                raizAuxiliar.setHijoDerecho(nuevoSubArbolDerecho);
            }
            return raizAuxiliar;
        }
    }

    public ClaseNodo<K, V> eliminarNodo(ClaseNodo<K, V> punteroNodo) {
        //Caso 0
        if (punteroNodo.getHijoIzquierdo() == null && punteroNodo.getHijoDerecho() == null) {
            return null;
        }

        //Caso 1
        //En el Caso que de existe solo hijo Derecho
        if (punteroNodo.getHijoIzquierdo() == null) {
            return punteroNodo.getHijoDerecho();
        }

        if (punteroNodo.getHijoDerecho() == null) {
            return punteroNodo.getHijoIzquierdo();
        }

        //Caso 2
        ClaseNodo<K, V> nodoSucesor = buscarSiguienteSucesor(punteroNodo.getHijoDerecho());
        punteroNodo.setClave(nodoSucesor.getClave()); //Intercambiando
        
        ClaseNodo<K, V> nuevoSubArbol = eliminarXRecursivo(punteroNodo.getHijoDerecho(), (Integer) nodoSucesor.getClave());
        punteroNodo.setHijoDerecho(nuevoSubArbol);
        return punteroNodo;

    }

    public ClaseNodo<K, V> buscarSiguienteSucesor(ClaseNodo<K, V> nodo) {
        ClaseNodo<K, V> sucesor = nodo;  //Codigo actualizado para evitar bucle infinito
        while (sucesor.getHijoIzquierdo() != null) {
//            NodoBinario<K,V> nuevaRutaIzquierda = nodo.getHijoIzquierdo();
            sucesor = sucesor.getHijoIzquierdo(); //Codigo Actualizado para evitar bucle infinito
//            nodo.setHijoIzquierdo(nodo);
        }
        return sucesor; //Codigo actualizado para evitar bucle infinito
    }
}
