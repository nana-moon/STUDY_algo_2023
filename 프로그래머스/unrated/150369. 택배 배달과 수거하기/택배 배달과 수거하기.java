class Solution {
    
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		int deliver = 0;
		int pick = 0;
		long answer = 0;
		for (int i = n-1; i >= 0; i--) {
			int cnt = 0;
			while (deliver < deliveries[i] || pick < pickups[i]) {
				cnt++;
				deliver += cap;
				pick += cap;
			}
			deliver -= deliveries[i];
			pick -= pickups[i];
			answer += (cnt)*(i+1)*2;
		}
		return answer;
	}
}