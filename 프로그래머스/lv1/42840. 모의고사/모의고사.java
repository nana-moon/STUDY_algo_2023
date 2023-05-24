import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
		int[][] pattern = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
		int[] temp = new int[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cnt_answer(pattern[i], answers);
		}

		System.out.println(Arrays.toString(temp));

		int max = Arrays.stream(temp).max().getAsInt();
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == max) {
				array.add(i+1);
			}
		}
		int[] answer = array.stream()
			.mapToInt(Integer::intValue)
			.toArray();

		return answer;
	}
	public int cnt_answer(int[] pattern, int[] answers) {
		int len = pattern.length;
		int answer = 0;
		int idx;
		for (int i = 0; i < answers.length; i++) {
			idx = ((i+1) % len -1 == -1) ? len-1 : (i+1) % len -1;
			if (answers[i] == pattern[idx]) {
				answer++;
			}
		}
		return answer;
	}
}