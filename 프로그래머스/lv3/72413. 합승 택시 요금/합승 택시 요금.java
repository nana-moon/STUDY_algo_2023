import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] arr = new int[n][n];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }
        for(int[] fare : fares) {
            int st = fare[0]-1;
            int ed = fare[1]-1;
            int cost = fare[2];
            arr[st][ed] = cost;
            arr[ed][st] = cost;
        }
        // 플로이드 와샬
        for (int k = 0; k < n; k++) {
			// 노드 i에서 j로 가는 경우.
			for (int i = 0; i < n; i++) {
                if(arr[i][k] == INF) continue;
				for (int j = 0; j < n; j++) {
                    if(arr[k][j] == INF) continue;
					// k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
					// 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
        // System.out.println(Arrays.deepToString(arr));
        
        int minCost = INF;
        
        minCost = Math.min(minCost, arr[s-1][a-1] + arr[s-1][b-1]);
        
        // 공통 내리는 구간 설정
        for(int m = 0; m < n; m++) {
            if(m == s-1) continue;
            int nCost = arr[s-1][m] + arr[m][a-1] + arr[m][b-1];
            minCost = Math.min(minCost, nCost);
        }
        return minCost;
    }
}