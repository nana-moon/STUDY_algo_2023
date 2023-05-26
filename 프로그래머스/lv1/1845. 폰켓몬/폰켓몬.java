import java.util.*;

class Solution {
    public static int solution(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				int tmp = map.get(nums[i]);
				map.put(nums[i], tmp+1);
			}
		}
		if (len/2 <= map.size()) {
			return len/2;
		} else {
			return map.size();
		}
	}
}