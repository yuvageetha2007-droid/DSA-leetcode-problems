class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (time > dist[node]) continue;

            for (int[] edge : times) {
                if (edge[0] == node) {
                    int next = edge[1];
                    int newTime = time + edge[2];

                    if (newTime < dist[next]) {
                        dist[next] = newTime;
                        pq.offer(new int[]{next, newTime});
                    }
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
