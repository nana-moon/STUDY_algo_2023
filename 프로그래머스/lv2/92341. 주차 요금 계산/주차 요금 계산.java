import java.util.*;

class Solution {
    public static int[] solution(int[] fees, String[] records) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < records.length; i++) {
			String[] tmp = records[i].split(" ");

			Integer time = changeTimeToInt(tmp[0]);
			if (map.containsKey(tmp[1])) {
				map.get(tmp[1]).add(time);
			} else {
				ArrayList<Integer> array = new ArrayList<>();
				array.add(time);
				map.put(tmp[1], array);
			}
		}
		int[][] result = new int[map.size()][2];
		// map을 돌면서
		int idx = 0;
		for (String key : map.keySet()) {
			// System.out.println("key " +key);
			ArrayList<Integer> values = map.get(key);

			if (values.size() % 2 != 0) {
				values.add(changeTimeToInt("23:59"));
			}
			// System.out.println("values " + values);
			int totalFee = 0;
			double totalTime = 0;
			for (int i = 0; i < values.size(); i+=2) {
				totalTime += values.get(i+1) - values.get(i);
			}
			if (totalTime <= fees[0]) totalFee = fees[1];
			else {
				// 올림 유의
				int ceil = (int)Math.ceil((totalTime - fees[0])/fees[2]);
				totalFee = fees[1] + (ceil)* fees[3];
			}
			// System.out.println(totalTime + " " +totalFee);
			result[idx][0] = Integer.parseInt(key);
			result[idx][1] = totalFee;
			idx++;
		}
		int[] answer = new int[result.length];
		// Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]));            // 첫번째 숫자 기준 오름차순 : {1,30}{2,10}{3,50}{4,20}{5,40}
		// Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]).reversed()); // 첫번째 숫자 기준 내림차순 : {5,40}{4,20}{3,50}{2,10}{1,30}
		// Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[1]));            // 두번째 숫자 기준 오름차순 : {2,10}{4,20}{1,30}{5,40}{3,50}
		// Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[1]).reversed()); // 두번째 숫자 기준 내림차순 : {3,50}{5,40}{1,30}{4,20}{2,10}
		Arrays.sort(result, Comparator.comparingInt((int[] o) -> o[0]));
		idx = 0;
		for (int[] num : result) {
			answer[idx] = num[1];
			idx++;
		}

		return answer;
	}

	private static Integer changeTimeToInt(String s) {
		String[] strings = s.split(":");
		int hours = Integer.parseInt(strings[0]);
		int minutes = Integer.parseInt(strings[1]);
		return hours*60 + minutes;
	}
}