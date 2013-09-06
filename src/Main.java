
import edu.uci.ics.jung.graph.DirectedSparseGraph;

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
        
        grafo.addVertex("TGU");
        grafo.addVertex("MIA");
        grafo.addVertex("ATL");
        grafo.addVertex("JFK");
        grafo.addVertex("SAP");
        grafo.addVertex("SAL");
        grafo.addVertex("RTB");

        grafo.addVertex("MEX");
        grafo.addVertex("MGA");
        grafo.addVertex("PTY");
        grafo.addVertex("BOG");
        grafo.addVertex("LIM");

        grafo.addVertex("CUN");
        grafo.addVertex("PHL");
        grafo.addVertex("AMS");
        grafo.addVertex("NAP");
        grafo.addVertex("BWI");


        grafo.addVertex("LAX");
        grafo.addVertex("DFW");
        grafo.addVertex("SEA");
        grafo.addVertex("MAD");
        grafo.addVertex("HNL");
        grafo.addVertex("BER");
        grafo.addVertex("HND");
        
        grafo.addEdge(new Edge(10), "TGU", "MIA");
        grafo.addEdge(new Edge(100), "TGU", "SAP");
        grafo.addEdge(new Edge(30), "TGU", "JFK");
        grafo.addEdge(new Edge(50), "MIA", "ATL");
        grafo.addEdge(new Edge(10), "ATL", "SAP");
        grafo.addEdge(new Edge(20), "JFK", "ATL");
        grafo.addEdge(new Edge(60), "JFK", "SAP");

        grafo.addEdge(new Edge(706.3), "TGU", "MIA");
        grafo.addEdge(new Edge(557.81), "ATL", "JFK");
        grafo.addEdge(new Edge(877.1), "TGU", "ATL");
        grafo.addEdge(new Edge(183.7), "TGU", "SAP");
        grafo.addEdge(new Edge(497.03), "SAL", "TGU");
        grafo.addEdge(new Edge(159), "SAP", "RTB");
        grafo.addEdge(new Edge(198.2), "RTB", "TGU");
        grafo.addEdge(new Edge(529.76), "SAP", "PTY");
        grafo.addEdge(new Edge(589.1), "MIA", "MEX");
        grafo.addEdge(new Edge(646.55), "MEX", "SAL");
        grafo.addEdge(new Edge(86.9), "MIA", "TGU");
        grafo.addEdge(new Edge(417.93), "SAP", "SAL");
        grafo.addEdge(new Edge(431.73), "MGA", "SAL");
        grafo.addEdge(new Edge(441.93), "SAL", "MGA");
        grafo.addEdge(new Edge(520.33), "SAL", "PTY");
        grafo.addEdge(new Edge(548.66), "PTY", "MIA");
        grafo.addEdge(new Edge(520.33), "PTY", "BOG");
        grafo.addEdge(new Edge(638.13), "BOG", "LIM");
        grafo.addEdge(new Edge(554.96), "PHL", "ATL");
        grafo.addEdge(new Edge(641.813), "TGU", "ATL");
        grafo.addEdge(new Edge(1738.36), "LIM", "TGU");
        grafo.addEdge(new Edge(520.33), "PTY", "BOG");
        grafo.addEdge(new Edge(194.88), "TGU", "RTB");
        grafo.addEdge(new Edge(897.2), "TGU", "CUN");
        grafo.addEdge(new Edge(59), "CUN", "SAP");
        grafo.addEdge(new Edge(543.25), "MIA", "PHL");
        grafo.addEdge(new Edge(427.49), "SAP", "MEX");
        grafo.addEdge(new Edge(651.8), "SAP", "PTY");
        grafo.addEdge(new Edge(1133.4), "TGU", "LAX");
        grafo.addEdge(new Edge(1123.4), "LAX", "SAP");
        grafo.addEdge(new Edge(483.55), "SEA", "DFW");
        grafo.addEdge(new Edge(381), "MIA", "JFK");
        grafo.addEdge(new Edge(2912), "JFK", "MAD");
        grafo.addEdge(new Edge(488), "MEX", "BWI");
        grafo.addEdge(new Edge(266), "BWI", "LAX");
        grafo.addEdge(new Edge(406), "LAX", "HNL");
        grafo.addEdge(new Edge(425), "MIA", "SEA");
        grafo.addEdge(new Edge(2907), "MIA", "BER");
        grafo.addEdge(new Edge(2006), "JFK", "HND");
        grafo.addEdge(new Edge(453.45), "NAP", "AMS");
        grafo.addEdge(new Edge(3074.8), "AMS", "JFK");
        grafo.addEdge(new Edge(528.364), "DFW", "MIA");
        grafo.addEdge(new Edge(3754.47), "MIA", "AMS");
        grafo.addEdge(new Edge(190.32), "SPS", "MIA");
        grafo.addEdge(new Edge(405.82), "SAL", "JFK");
        grafo.addEdge(new Edge(383.13), "MAD", "NAP");
        grafo.addEdge(new Edge(304), "HNL", "HND");
        grafo.addEdge(new Edge(307), "HND", "HNL");
        grafo.addEdge(new Edge(788), "HND", "LAX");
        grafo.addEdge(new Edge(408), "HNL", "LAX");
        grafo.addEdge(new Edge(300.34), "BER", "MAD");

        
        ADTQueue result[] = Dijkstra.dijkstra(grafo, "TGU");
        System.out.println("Pase");
        for (int i = 0; i < result.length; i++) {
            while (!result[i].isEmpty()) {
                System.out.print(result[i].dequeue().toString() + " ");
            }
            System.out.println();
        }
    }
}
