class Solution {
    public static int solution(int[][] sizes) {
		// for문 돌면서 max, min 갱신
		int left_max = -999999;
		int right_max = -999999;
		for (int[] size: sizes) {
			if (size[0] >= size[1]) {
				left_max = Math.max(size[0], left_max);
				right_max = Math.max(size[1], right_max);
			} else {
				left_max = Math.max(size[1], left_max);
				right_max = Math.max(size[0], right_max);

			}
		}
		int answer = left_max *right_max;
		return answer;
	}
}