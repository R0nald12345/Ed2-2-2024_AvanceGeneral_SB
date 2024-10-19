/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USER
 */
// k = Valor Numerico
public class NodoMVias<K> {

    private List<K> listaDeClaves;
    private List<NodoMVias<K>> listaDeHijos;

    //Contructor
    //Orden = M 
    public NodoMVias(int orden) {
        listaDeHijos = new LinkedList<>();
        listaDeClaves = new LinkedList<>();
        for (int i = 0; i < orden - 1; i++) {
            listaDeHijos.add(nodoVacio());
            listaDeClaves.add((K) datoVacio());
        }
        listaDeHijos.add(nodoVacio());
    }

    public NodoMVias(int orden, K claveInsertar) {
        this(orden);
        this.listaDeClaves.set(0, claveInsertar);
    }

    public static Object datoVacio() {
        return null;
    }

    //-------------------
    public K getClave(int posicion) {
        return this.listaDeClaves.get(posicion);
    }

    public void setClave(int posicion, K clave) {
        this.listaDeClaves.set(posicion, clave);
    }

    public NodoMVias<K> getHijo(int posicion) {
        return this.listaDeHijos.get(posicion);
    }

    public void setHijo(int posicion, NodoMVias<K> nodo) {
        this.listaDeHijos.set(posicion, nodo);
    }

    //-------------
    public static boolean esNodoVacio(NodoMVias nodo) {
        return nodo == null;
    }

    public static NodoMVias nodoVacio() {
        return null;
    }

    //Para Verificar si mi Dato = Clave es Vacio
    public boolean esClaveVacia(int posicion) {
        return this.listaDeClaves.get(posicion) == datoVacio();
    }

    public boolean esHijoVacio(int posicion) {
        return this.listaDeHijos.get(posicion) == nodoVacio();
    }

    public boolean esHoja() {
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean estanClaveLlenas() {
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.esClaveVacia(i)) {
                return false;
            }
        }
        return true;
    }

    public int cantidadDeHijosNoVacios() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadDeHijosVacios() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (this.esHijoVacio(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadDeClavesNoVacias() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (!this.esClaveVacia(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadDeClavesVacias() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.esClaveVacia(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int sumarDatosDelNodo() {
        int contador = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.listaDeClaves.get(i) != null) {
                contador = contador + (Integer) this.listaDeClaves.get(i);
            }
        }
        return contador;
    }

    public boolean verificarExisteDatoEnNodo(int dato) {

        boolean bandera = false;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.listaDeClaves.get(i) != null) {
                if (dato == (Integer) this.listaDeClaves.get(i)) {
//                    return true;
                    bandera = true;
                }
            }
        }
        return bandera;
    }

}
