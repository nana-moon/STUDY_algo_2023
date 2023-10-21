import java.util.*;
class Solution {
    class Node implements Comparable<Node> {
        int v, cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {-1, Integer.MAX_VALUE};
        
        ArrayList<Node>[] graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        HashSet<Integer> summitSet = new HashSet<>();
        HashSet<Integer> gateSet = new HashSet<>();
        for (int gate : gates) {
            gateSet.add(gate);
        }
        for (int summit : summits) {
            summitSet.add(summit);
        }
        for (int[] path : paths) {
            graph[path[0]].add(new Node(path[1], path[2]));
            graph[path[1]].add(new Node(path[0], path[2]));
        }
        Arrays.sort(summits);
        // 산봉우리 > 각 지점까지의 최대 intensity를 dist 배열에 기록
        for (int i = 0; i < summits.length; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[summits[i]] = 0;
            int minVal = answer[1];
            pq.offer(new Node(summits[i], 0));
            
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (gateSet.contains(now.v)) {
                    minVal = Math.min(minVal, now.cost);
                } else {
                    if (now.cost > minVal) continue;
                    
                    for (Node next : graph[now.v]) {
                        if (summitSet.contains(next.v)) continue;
                        int nextVal = Math.max(next.cost, now.cost);
                        // 이 때만 insert
                        if (nextVal < dist[next.v]) {
                            dist[next.v] = nextVal;
                            pq.offer(new Node(next.v, nextVal));
                        }
                    }
                }
            }
            for (int j = 0; j < gates.length; j++) {
                int gate = gates[j];
                if (dist[gate] < answer[1]) {
                    answer[0] = summits[i];
                    answer[1] = dist[gate];
                }
            }
        }
        return answer;
    }
}