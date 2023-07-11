import java.util.*;

class Solution {
    static int max_plus, max_price, discount[], emoticon[], N, user[][];


	public static int[] solution(int[][] users, int[] emoticons) {
		int[] answer = new int[2];
		max_plus = 0;
		max_price = 0;
		emoticon = Arrays.copyOf(emoticons, emoticons.length);

		N = emoticons.length;
		user = users.clone(); // 2차원 배열에서는 앝은 복사
		discount = new int[N];
		dfs(0);
		answer[0] = max_plus;
		answer[1] = max_price;
		return answer;
	}
	public static void dfs(int level) {
		if (level == N) {
			calculate(discount);
			return;
		}
		for (int i = 4; i >= 1; i--) {
			discount[level] = i*10;
			dfs(level+1);
		}
	}
	public static void calculate(int[] discount) {
		int[] total_price = new int [user.length];
		for (int i = 0; i < N; i++) {
			// 하나의 이모티콘에 대해 user를 돌며 구매 가격을 올려줌
			for (int j = 0; j < user.length; j++) {
				if (user[j][0] <= discount[i]) {

					// 구매한다.
					total_price[j] += emoticon[i]*(100-discount[i])/100;
				}
			}
		}
		int sum = 0;
		int cnt = 0;

		for (int i = 0; i < user.length; i ++) {
			if (total_price[i] >= user[i][1]) {
				// 임티 플러스 가입
				cnt++;
			} else {
				sum += total_price[i];
			}
		}
		if (cnt > max_plus) {
			max_plus = cnt;
			max_price = sum;
		} else if (cnt == max_plus) {
			max_price = Math.max(max_price, sum);
		}

	}
}