/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        
        ArbolMVias arbolM = new ArbolMVias();
        
        arbolM.insertar(80);
        arbolM.insertar(90);
        arbolM.insertar(70);
        arbolM.insertar(100);
 
        System.out.println(arbolM.recorridoEnInOrden());
        
    }
}
