
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import javax.tools.Diagnostic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EdilsonFernando
 */
public class Main {
    
    public static void main(String[] args) {
        DirectedSparseGraph<String, Edge> grafo = new DirectedSparseGraph();
        
        grafo.addVertex("V1");
        grafo.addVertex("V2");
        grafo.addVertex("V3");
        grafo.addVertex("V4");
        grafo.addVertex("V5");
        
        grafo.addEdge(new Edge(10), "V1", "V2");
        grafo.addEdge(new Edge(30), "V1", "V4");
        grafo.addEdge(new Edge(100), "V1", "V5");
        grafo.addEdge(new Edge(50), "V2", "V3");
        grafo.addEdge(new Edge(10), "V3", "V5");
        grafo.addEdge(new Edge(20), "V4", "V3");
        grafo.addEdge(new Edge(60), "V4", "V5");
        
        ADTQueue result[] = Dijkstra.dijkstra(grafo, "V1");
        
        for (int i = 0; i < result.length; i++) {
            while (!result[i].isEmpty()) {
                System.out.print(result[i].dequeue().toString() + " ");
            }
            System.out.println();
        }
    }
}
