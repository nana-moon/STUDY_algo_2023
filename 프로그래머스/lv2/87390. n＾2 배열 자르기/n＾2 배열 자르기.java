class Solution {
    public static int[] solution(int n, long left, long right) {
		int[] answer = new int[(int)right-(int)left+1];
		int idx = 0;
		for (long num = left; num <= right; num++) {
			int i = (int)(num / n);
			int j = (int)(num % n);
			answer[idx] = Math.max(i,j) +1;
			idx++;

		}
		return answer;
	}
}