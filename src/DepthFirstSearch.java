import java.util.*;

public class DepthFirstSearch {

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

        dfs(g, 0);
    }

    private static void dfs(Graph g, int startingNode) {
        Map<Integer, List<Integer>> graph = g.getGraph();
        Stack<Integer> nodeStack = new Stack<>();
        //Queue<Integer> nodeStack = new ArrayDeque<>();
        Set<Integer> visitedSet = new HashSet<>();
        visitedSet.add(startingNode);
        nodeStack.push(startingNode);
        do {
            traverse(nodeStack.pop(), visitedSet, nodeStack, graph);
        } while (!nodeStack.isEmpty());
    }

    private static void traverse(int currentNode, Set<Integer> visitedSet, Stack<Integer> nodeStack, Map<Integer, List<Integer>> graph) {
        System.out.println(currentNode);
        if (graph.get(currentNode) != null) {
            graph.get(currentNode).forEach(childNode -> {
                if (visitedSet.add(childNode)) {
                    nodeStack.push(childNode);
                }
            });
        }
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
