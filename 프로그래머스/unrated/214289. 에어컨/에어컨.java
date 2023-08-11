import java.util.*;
class Solution {
    static int T1,T2;

	public static int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
		T1 = t1;
		T2 = t2;
		int inf = Integer.MAX_VALUE;
		int[][] dp = new int[onboard.length][51];
		for (int i = 0; i < onboard.length; i++) {
			Arrays.fill(dp[i], inf);
		}
		dp[0][temperature+10] = 0;
		for (int i = 0; i < onboard.length-1; i++) {
			for(int j = 0; j <51; j++) {
				// int nowDegree = j-10;
				if (dp[i][j] != inf) {
					for (int k = 0; k < 4; k++) {
						int temp = 0;
						int cost = 0;
						if (k == 0) {
							// i+1, j-1
							temp = j-1;
							cost = a;
						} else if (k == 1) {
							// i+1, j
							temp = j;
							cost = b;
						} else if (k == 2) {
							// i+1, j+1
							temp = j+1;
							cost = a;
						} else {
							// 에어컨을 끌 경우
							cost = 0;
							if(temperature+10 > j) {
								// 온도가 올라감
								temp = j+1;
							} else if (temperature+10 < j) {
								// 온도가 내려감
								temp = j-1;
							} else {
								// 그대로 유지
								temp = j;
							}
						}
						if(temp < 0 || temp >= 51) continue;
						if(onboard[i+1] == 1) {
							if (isIn(temp) != 0) continue;
						}
						dp[i+1][temp] = Math.min(dp[i+1][temp], dp[i][j]+cost);
					}
				}
			}
		}
		int answer = inf;
		for (int j = 0; j < 51; j++) {
			answer = Math.min(dp[onboard.length-1][j], answer);
		}
		return answer;

	}
	public static int isIn(int degree) {
		degree -= 10;
		if (degree < T1) {
			return -1;
		} else if (degree > T2) {
			return 1;
		} else {
			return 0;
		}
	}
}