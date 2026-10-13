import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> reverse = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int next : graph[i]) {
                reverse.get(next).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;

            for (int prev : reverse.get(node)) {
                indegree[prev]--;

                if (indegree[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
