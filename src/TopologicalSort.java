import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        boolean[] visited = new boolean[6];
        Stack<Integer> result = new Stack();
        for(int i=0; i< 6; i++) {
            visited[i] = false;
        }
        //This is start with some random Node. After that it only hits non visited nodes.
        for(int j=0; j < 6; j++) {
            if(!visited[j]) {
                topologicalSort(g, result, j, visited);
            }
        }

        while(!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    private static void topologicalSort(Graph g, Stack<Integer> result, int node, boolean[] visited) {
        visited[node] = true;
        List<Integer> connectedNodes = g.getGraph().get(node);
        if(connectedNodes != null) {
            for (int cn : connectedNodes) {
                if(!visited[cn]) {
                    topologicalSort(g, result, cn, visited);
                }
            }
        }
        result.push(node);
    }

    private static class Graph {
        private int nodes;
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        public Graph(int nodes) {
            this.nodes = nodes;
        }

        public void addEdge(int node1, int node2) {
            if (edgeMap.get(node1) == null) {
                List<Integer> edgeList = new ArrayList<>();
                edgeList.add(node2);
                edgeMap.put(node1, edgeList);
            } else {
                edgeMap.get(node1).add(node2);
            }
        }

        public Map<Integer, List<Integer>> getGraph() {
            return edgeMap;
        }
    }
}
