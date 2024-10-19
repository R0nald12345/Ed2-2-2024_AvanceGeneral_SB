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
        arbolM.insertar(78);
         
        arbolM.insertar(85);
        arbolM.insertar(100);
        arbolM.insertar(60);
 
        System.out.println(arbolM.recorridoEnInOrden());
        
        System.out.println("cantidad de Hijos por Nivel: "+ arbolM.contarCantidadHijosVaciosPorNivel(0));
        System.out.println("cantidad de Hijos por Nivel: "+ arbolM.contarCantidadHijosVaciosPorNivel(1));
        System.out.println("cantidad de Hijos por Nivel: "+ arbolM.contarCantidadHijosVaciosPorNivel(2));
        System.out.println("cantidad de Hijos por Nivel: "+ arbolM.contarCantidadHijosVaciosPorNivel(100));
        
        System.out.println("-------------------------------------------");
        
        System.out.println("cantidad de Clave Vacia por Nivel: " + arbolM.contarCantidadClaveVaciosPorNivel(0));
        System.out.println("cantidad de Clave Vacia por Nivel: " + arbolM.contarCantidadClaveVaciosPorNivel(1));
        System.out.println("cantidad de Clave Vacia por Nivel: " + arbolM.contarCantidadClaveVaciosPorNivel(2));
        
    }
}
