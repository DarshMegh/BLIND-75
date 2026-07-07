import java.util.*;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1)
            return false;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfs(0, graph, visited);

        for (boolean node : visited)
            if (!node)
                return false;

        return true;
    }

    private void dfs(int node, List<List<Integer>> graph,
                     boolean[] visited) {

        if (visited[node])
            return;

        visited[node] = true;

        for (int next : graph.get(node))
            dfs(next, graph, visited);
    }
}