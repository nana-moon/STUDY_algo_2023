import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
		int max = citations[citations.length-1];
		int[] bucket = new int[max+1];
		for (int citation : citations) {
			for (int i = 1; i <= citation; i++) {
				bucket[i]++;
			}
		}
		int answer = 0;
		for (int i = 1; i < max+1; i++) {
			if (bucket[i] >= i) {
				answer = i;
			}
		}
		// System.out.println(Arrays.toString(bucket));
		return answer;
    }
}