package Grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GrafoNoDirigido {
    // Atributos
    private int cantAristas; // Para contar los arcos del grafo
    private List<List<Integer>> listaDeAdyacencia;
    private boolean[] marcado;

    // Constructor
    public GrafoNoDirigido() {
        this.listaDeAdyacencia = new ArrayList<>();
        this.cantAristas = 0;
        this.marcado = new boolean[0];
    }

    public void insertarVertice() {
        this.listaDeAdyacencia.add(new ArrayList<>());
        // Aumenta el tamaño del arreglo marcado al agregar un nuevo vértice
        boolean[] nuevoMarcado = new boolean[this.listaDeAdyacencia.size()];
        System.arraycopy(this.marcado, 0, nuevoMarcado, 0, this.marcado.length);
        this.marcado = nuevoMarcado;
    }

    public int cantidadAristas() {
        return this.cantAristas;
    }

    public int cantidadDeVertice() {
        return this.listaDeAdyacencia.size();
    }

    public void validarVertice(int posVertice) throws Exception {
        if (posVertice < 0 || posVertice >= cantidadDeVertice()) {
            throw new Exception("Error al validar el vértice: " + posVertice);
        }
    }

    public void insertarArista(int posVerticeOrigen, int posVerticeDestino) throws Exception {
        validarVertice(posVerticeOrigen);
        validarVertice(posVerticeDestino);
        if (verificarAdyacencia(posVerticeOrigen, posVerticeDestino)) {
            throw new Exception("Ya existe la adyacencia entre los vértices: " + posVerticeOrigen + " y " + posVerticeDestino);
        }
        this.cantAristas++;
        List<Integer> adyacenciaDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        adyacenciaDelOrigen.add(posVerticeDestino);

        if (posVerticeOrigen != posVerticeDestino) { // Evitar duplicados en caso de bucles
            List<Integer> adyacenciaDelDestino = this.listaDeAdyacencia.get(posVerticeDestino);
            adyacenciaDelDestino.add(posVerticeOrigen);
        }
    }

    public boolean verificarAdyacencia(int posVerticeOrigen, int posVerticeDestino) {
        List<Integer> adyacenciaDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        return adyacenciaDelOrigen.contains(posVerticeDestino);
    }

    public void mostrarGrafoNoDirigido() {
        for (int i = 0; i < this.listaDeAdyacencia.size(); i++) {
            StringBuilder adyacencia = new StringBuilder();
            for (int j = 0; j < this.listaDeAdyacencia.get(i).size(); j++) {
                adyacencia.append(this.listaDeAdyacencia.get(i).get(j)).append(",");
            }
            System.out.println("[" + i + "] -> " + adyacencia);
        }
    }

    // Métodos de recorrido
    public void desmarcarTodos() {
        for (int i = 0; i < this.marcado.length; i++) {
            this.marcado[i] = false;
        }
    }

    public void marcar(int vertice) {
        this.marcado[vertice] = true;
    }

    public boolean estaMarcado(int vertice) {
        return this.marcado[vertice];
    }

    public void RecorridoBFS(int vertice) throws Exception {
        validarVertice(vertice);
        desmarcarTodos();
        Queue<Integer> cola = new LinkedList<>();
        System.out.println("BFS:");
        cola.add(vertice);
        marcar(vertice);
        while (!cola.isEmpty()) {
            int verticeActual = cola.poll();
            System.out.print(verticeActual + " ");
            for (int i=0 ; i < this.listaDeAdyacencia.get(verticeActual).size(); i++) {
                int vecino = this.listaDeAdyacencia.get(verticeActual).get(i);
                if (!estaMarcado(vecino)) {
                    cola.add(vecino);
                    marcar(vecino);
                }
            }
        }
        System.out.println();
    }
    
      public void RecorridoDFS(int vertice) throws Exception {
        validarVertice(vertice);
        desmarcarTodos();
        System.out.println("DFS:");
        Stack<Integer> pila = new Stack<>();
        pila.push(vertice);
        marcar(vertice);
        while (!pila.isEmpty()) {
            int verticeActual = pila.pop();
            System.out.print(verticeActual + " ");
            for (int i=0 ; i < this.listaDeAdyacencia.get(verticeActual).size(); i++) {
                int vecino = this.listaDeAdyacencia.get(verticeActual).get(i);
                if (!estaMarcado(vecino)) {
                    pila.push(vecino);
                    marcar(vecino);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        GrafoNoDirigido grafo = new GrafoNoDirigido();

        // Agregar vértices
        grafo.insertarVertice();
        grafo.insertarVertice();
        grafo.insertarVertice();
        grafo.insertarVertice();
        grafo.insertarVertice();

        // Agregar aristas
        grafo.insertarArista(0,3);
        grafo.insertarArista(0,4);
        grafo.insertarArista(1,2);
        grafo.insertarArista(3,2);
        grafo.insertarArista(3,4);

        // Mostrar el grafo
        grafo.mostrarGrafoNoDirigido();

//        // Recorrido BFS
        grafo.RecorridoBFS(3);
        
        //   Recorrido DFS
        grafo.RecorridoDFS(3);
    }
}
