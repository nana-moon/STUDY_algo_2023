import java.util.*;

class Solution {
    static int dist[], N;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n;
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] node : roads) {
            graph[node[1]].add(node[0]);
            graph[node[0]].add(node[1]);
        }
        // System.out.println(Arrays.toString(graph));
        
        dijkstra(destination);
        
        int[] answer = new int[sources.length];
        int i = 0;
        for (int source : sources) {
            if (dist[source] == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = dist[source];
            }
            i++;
        }
        return answer;
    }
    public static void dijkstra(int st) {
        dist[st] = 0;
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(st);
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (visited[now]) continue;
            visited[now] = true;
            for (Integer next : graph[now]) {
                if (dist[now] + 1 < dist[next]) {
                    dist[next] = dist[now] + 1;
                    pq.offer(next);
                }
            }
        }
    }
}