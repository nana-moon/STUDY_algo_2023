class Solution {
    public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int st = 1;
		int ed;
		for (int i = 0; i < stations.length; i++) {
			ed = stations[i]-w;
			if (st >= ed) {
				st = stations[i]+w+1;
				continue;
			}
			int gap = ed-st;
			int result = (gap % (2*w+1) == 0)? gap/(2*w+1): gap/(2*w+1)+1;
			answer += result;
			st = stations[i]+w+1;
		}
		if (st < n+1) {
			int last = n+1-st;
			int addition = (last % (2*w+1) == 0)? last/(2*w+1): last/(2*w+1)+1;
			// System.out.println(addition);
			answer += addition;

		}

		return answer;
	}
}