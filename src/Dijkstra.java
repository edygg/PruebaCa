
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EdilsonFernando
 */
public class Dijkstra {

    public static ADTQueue[] dijkstra(DirectedSparseGraph<String, Edge> grafo, String verticeInicial) {
        ADTQueue[] caminos = new ADTQueue[grafo.getVertexCount()];
        
        for (int i = 0; i < caminos.length; i++) {
            caminos[i] = new SLQueue();
        }
        
        double[] valoresCaminos = new double[grafo.getVertexCount()];
        //Rellenando la matriz de infinitos para indicar que no hay caminos
        Arrays.fill(valoresCaminos, Double.POSITIVE_INFINITY);
        
        Collection<String> vertices = grafo.getVertices(); //Utilizo Collection porque es lo que retorna este método
        vertices = new TreeSet<>(vertices); //Creo una nueva copia de la colección porque la colección que retorna el jung no se puede modificar
        
        /* Este arreglo solo lo hago para saber en que subíndice está la cola y el camino más corto
           de cada uno de los vértices. Así arregloVertices[0] significa que su camino esta en 
           caminos[0] y el valor del camino está en valoresCaminos[0] 
         */
        String[] arregloVertices = new String[grafo.getVertexCount()]; 
        vertices.toArray(arregloVertices);
        
        //vertice que posee el camino más corto actualmente
        String verticeCaminoCorto = "";
        double valorCaminoCorto = Double.POSITIVE_INFINITY; // Esto solo es por inicializarla con un valor cualquiera
        
        /* Creando la situación inicial */
        for (int i = 0; i < arregloVertices.length; i++) {
            if (!arregloVertices[i].equals(verticeInicial)) {
                if (grafo.findEdge(verticeInicial, arregloVertices[i]) != null) {
                    double valorCamino = grafo.findEdge(verticeInicial, arregloVertices[i]).getWeight();
                    valoresCaminos[i] = valorCamino;
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
        
        while(vertices.size() > 1) { //Los collections no eliminan todos los elementos siempre quedan con uno a dentro al menos
            boolean remove = vertices.remove(verticeCaminoCorto);
 
            for (int i = 0; i < arregloVertices.length; i++) {
                if (vertices.contains(arregloVertices[i]) == true) {
                    if (grafo.findEdge(verticeCaminoCorto, arregloVertices[i]) != null) {
                        double neoCamino = valorCaminoCorto + grafo.findEdge(verticeCaminoCorto, arregloVertices[i]).getWeight();
                        
                        if (Math.min(valoresCaminos[i], neoCamino) == neoCamino) {
                            valoresCaminos[i] = neoCamino;
                            caminos[i].queue(verticeCaminoCorto);
                        }
                    }
                }
            }
            
            double nuevoCaminoAUsar = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < arregloVertices.length; i++) {
                if (vertices.contains(arregloVertices[i]) == true) {
                    if (valoresCaminos[i] < nuevoCaminoAUsar) {
                        nuevoCaminoAUsar = valoresCaminos[i];
                        verticeCaminoCorto = arregloVertices[i];
                    }
                }
            }
            
            valorCaminoCorto = nuevoCaminoAUsar;
        }
        
        for (int i = 0; i < valoresCaminos.length; i++) {
            System.out.println(arregloVertices[i] + " = " + valoresCaminos[i]);
        }
        
        return caminos;
    }
}
