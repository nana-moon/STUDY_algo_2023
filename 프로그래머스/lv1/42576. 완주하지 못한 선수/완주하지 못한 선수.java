import java.util.*;
class Solution {
    public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		String answer = "";
		for (String com : completion) {
			if (!map.containsKey(com)) {
				map.put(com, 1);
			} else {
				int temp = map.get(com);
				map.put(com, temp+1);
			}
		}
		for (String part :participant) {
			if (map.containsKey(part)) {
				if (map.get(part)-1 == 0) {
					map.remove(part);
				} else {
					int temp = map.get(part);
					map.put(part, temp-1);
				}
			} else {
				answer = part;
			}
		}
		return answer;
	}
}