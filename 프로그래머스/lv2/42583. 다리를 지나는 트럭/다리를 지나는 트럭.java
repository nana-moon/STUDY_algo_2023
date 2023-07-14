import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int pointer = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < bridge_length; i++) {
			q.offer(0);
		}
		int bridgeSum = 0;
		while (pointer < truck_weights.length) {
			bridgeSum -= q.poll();
			if (bridgeSum + truck_weights[pointer] <= weight) {
				// 새로운 트럭 올라갈 수 있음
				q.offer(truck_weights[pointer]);
				bridgeSum += truck_weights[pointer];
				pointer++;
			} else {
				q.offer(0);
			}
			answer++;
		}
		while (!q.isEmpty()) {
			q.poll();
			answer++;
		}
		return answer;
	}
}