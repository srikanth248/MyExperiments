import java.util.*;

public class BreathFirstSearch {

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(5, 9);
        g.addEdge(5, 11);
        g.addEdge(6, 72);
        g.addEdge(7, 31);
        g.addEdge(8, 50);
        g.addEdge(8, 33);

        bfs(g.getGraph(), 0);
    }

    private static void bfs(Map<Integer, List<Integer>> g, int startingNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visitedSet = new HashSet<>();
        queue.add(startingNode);
        do {
            int currentNode = queue.poll();
            System.out.println(currentNode);
            List<Integer> childNodes = g.get(currentNode);
            if(childNodes != null) {
                childNodes.forEach(childNode -> {
                    if(visitedSet.add(childNode)) {
                        queue.add(childNode);
                    }
                });
            }
        } while (!queue.isEmpty());
    }

    private static class Graph {
        private int nodes;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        public Graph(int nodes) {
            this.nodes = nodes;
        }

        public void addEdge(int node1, int node2) {
            if (graph.get(node1) == null) {
                List<Integer> edgeList = new ArrayList<>();
                edgeList.add(node2);
                graph.put(node1, edgeList);
            } else {
                graph.get(node1).add(node2);
            }
        }

        public Map<Integer, List<Integer>> getGraph() {
            return graph;
        }
    }
}
