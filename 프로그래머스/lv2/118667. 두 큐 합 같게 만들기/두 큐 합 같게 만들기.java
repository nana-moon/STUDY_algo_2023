import java.util.*;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
		ArrayDeque<Integer> q1 = new ArrayDeque<>();
		ArrayDeque<Integer> q2 = new ArrayDeque<>();
		long sum1 = 0;
		long sum2 = 0;
		int N = queue1.length;
		for (int i = 0; i < N; i++) {
			sum1 += queue1[i];
			q1.offer(queue1[i]);
			sum2 += queue2[i];
			q2.offer(queue2[i]);
		}
		int cnt = 0;
		boolean success = true;
		while (sum1 != sum2) {
			if (cnt > 3*N) {
				success = false;
				break;
			}
			if (sum1 > sum2) {
				int picked1 = q1.poll();
				q2.offer(picked1);
				sum1 -= picked1;
				sum2 += picked1;
			} else {
				int picked2 = q2.poll();
				q1.offer(picked2);
				sum2 -= picked2;
				sum1 += picked2;
			}
			cnt++;
		}
		if (success) return cnt;
		return -1;
	}
}