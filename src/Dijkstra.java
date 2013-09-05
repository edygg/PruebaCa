
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Dijkstra {
    
    /**
     * Recuperador de caminos. Retorna un arreglo de pilas con todo el contenido de los caminos. el arreglo
     * está ordenado con respecto al orden de los vértices extraídos del grafo. Revisar el comentario interno
     * a esta clase.
     * @param grafo Grafo dirigido
     * @param verticeInicial Vértice de partida para ejecutar el algoritmo
     * @return 
     */
    public static ADTQueue[] dijkstra(DirectedSparseGraph<String, Edge> grafo, String verticeInicial) {
        //Declarando el arreglo de colas. Una cola por vértice en el grafo.
        ADTQueue[] caminos = new ADTQueue[grafo.getVertexCount()];
        
        //Inicializando el arreglo de colas
        for (int i = 0; i < caminos.length; i++) {
            caminos[i] = new SLQueue();
        }
        
        //Inicializando el arreglo que contiene los caminos mas cortos
        double[] valoresCaminos = new double[grafo.getVertexCount()];
        //Rellenando la matriz de infinitos para indicar que no hay caminos
        Arrays.fill(valoresCaminos, Double.POSITIVE_INFINITY);
        
        Collection<String> vertices = grafo.getVertices(); //Utilizo Collection porque es lo que retorna este método
        vertices = new TreeSet<>(vertices); //Creo una nueva copia de la colección porque la colección que retorna el jung no se puede modificar
        
        /* Este arreglo solo lo hago para saber en que subíndice está la cola y el camino más corto
           de cada uno de los vértices. Así arregloVertices[0] significa que su camino esta en 
           caminos[0] y el valor del camino está en valoresCaminos[0] 
         */
        //CON RESPECTO A ESTE ARREGLO CORRESPONDE CADA SUBÍNDICE DEL ARREGLO DE COLAS
        String[] arregloVertices = new String[grafo.getVertexCount()]; 
        //Imprimiendo el arreglo de vértices para saber cual es el orden de las colas
        for (int i = 0; i < arregloVertices.length; i++) {
            System.out.print(arregloVertices[i]+ "   ");
        }
        System.out.println();
        //Rellenando el arreglo de vertices con el contenido de la colección extraida del grafo
        vertices.toArray(arregloVertices);
        
        //vertice que posee el camino más corto actualmente
        String verticeCaminoCorto = "";
        //Valor del camino más corto actualmente
        double valorCaminoCorto = Double.POSITIVE_INFINITY; // Esto solo es por inicializarla con un valor cualquiera
        
        /* Creando la situación inicial */
        for (int i = 0; i < arregloVertices.length; i++) {
            //Comparando que el vértice no sea el vértice inicial
            if (!arregloVertices[i].equals(verticeInicial)) {
                //Encontrando una arista del vértice inicial hacia un vertice en el arreglo de vertices
                if (grafo.findEdge(verticeInicial, arregloVertices[i]) != null) {
                    //Extrayendo el valor del camino que hay entre el vértice inicial y un vértice en el arreglo de vértices
                    double valorCamino = grafo.findEdge(verticeInicial, arregloVertices[i]).getWeight();
                    //Colocando el valor en el arreglo de los caminos más cortos
                    valoresCaminos[i] = valorCamino;
                    //Añadiendo el vértice inicial al camino del vértice en el arreglo de vértices
                    caminos[i].queue(arregloVertices[i]);
                    
                    //Con este if se determina el camino más corto inicial
                    if (i == 0) {
                        verticeCaminoCorto = arregloVertices[i];
                        valorCaminoCorto = valorCamino;
                    } else {
                        if (valorCamino < valorCaminoCorto) {
                            verticeCaminoCorto = arregloVertices[i];
                            valorCaminoCorto = valorCamino;
                        }
                    }
                }
            }
        }
        
        //Ciclo principal. Verifica cada uno de los vertices para encontrar el camino más corto a cada uno
        while(vertices.size() > 1) { //Los collections no eliminan todos los elementos siempre quedan con uno a dentro al menos
            //Elimina el vértices que ya fue el que tenía el camino más corto
            boolean remove = vertices.remove(verticeCaminoCorto);
            
            /*Vértice en cuestión significa el vértice del for */
            //Verifica vertice por vértice para determinar el nuevo vértice con el camino más corto
            for (int i = 0; i < arregloVertices.length; i++) {
                //Verifica que el vértice siga en el conjunto V-S, el de vértices que no han sido camino mínimo
                if (vertices.contains(arregloVertices[i]) == true) {
                    //Verifica si existe camino entre el vértice que posee el camino más corto y el vértice en cuestión
                    if (grafo.findEdge(verticeCaminoCorto, arregloVertices[i]) != null) {
                        //D[w] + C[w, v], el valor del camino más corto más el camino del más corto hasta el vértices en cuestión
                        double neoCamino = valorCaminoCorto + grafo.findEdge(verticeCaminoCorto, arregloVertices[i]).getWeight();
                        //min(D[v], D[w] + C[w, v]) para determinar el nuevo valor para almacenar en la matriz
                        if (Math.min(valoresCaminos[i], neoCamino) == neoCamino) {
                            //Si el nuevo camino es menor se sustituye por el anterior
                            valoresCaminos[i] = neoCamino;
                            //Añadiendo el vertice de camino más corto a la pila del vértice en cuestión
                            //porque significa que tuvimos por ahí para llegar al vértice en cuestión.
                            caminos[i].queue(verticeCaminoCorto);
                        }
                    }
                }
            }
            
            //Determinando el nuevo camino mínimo 
            double nuevoCaminoAUsar = Double.POSITIVE_INFINITY; //Valor para inicializar
            
            for (int i = 0; i < arregloVertices.length; i++) {
                //Si el vértice analizado todavía está en el conjunto V-S, o sea no ha sido mínimo
                if (vertices.contains(arregloVertices[i]) == true) {
                    //Comprara si es menor que el menor
                    if (valoresCaminos[i] < nuevoCaminoAUsar) {
                        //Nuevo vértice de camino más corto
                        nuevoCaminoAUsar = valoresCaminos[i];
                        verticeCaminoCorto = arregloVertices[i];
                    }
                }
            }
            //Setea el nuevo valor de camino más corto
            valorCaminoCorto = nuevoCaminoAUsar;
        }
        
        //Imprimiendo los valores de los caminos
        for (int i = 0; i < valoresCaminos.length; i++) {
            System.out.println(arregloVertices[i] + " = " + valoresCaminos[i]);
        }
        
        //Retornando el arreglo de pilas
        return caminos;
    }
}
