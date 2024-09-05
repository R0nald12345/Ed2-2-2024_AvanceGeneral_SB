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
public class Main {
    
    //psvm + TAB
    public static void main(String[] args) {
        ClaseArbolBinario arbol = new ClaseArbolBinario();
        
        arbol.insertarNodoRecursivo(100, "Ronald");
        arbol.insertarNodoRecursivo(70, "Ronald1");
        arbol.insertarNodoRecursivo(51, "Ronald2");
        arbol.insertarNodoRecursivo(31, "Ronal3");
        arbol.insertarNodoRecursivo(20, "Ronald4");
        arbol.insertarNodoRecursivo(11, "Ronald5");
        arbol.insertarNodoRecursivo(80, "Ronald6");
        
        arbol.recorridoInOrdenR();
        System.out.println("");
        System.out.println("ContarNodos: " + arbol.cantidadNodos());
        System.out.println("ContarNodos: " + arbol.cantidadNodosPares());
        arbol.recorridoPostOrdenR();
    }
}
