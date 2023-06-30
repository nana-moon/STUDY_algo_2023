import java.util.*;
class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
		// 오늘 날짜
		int year = Integer.parseInt(today.substring(0,4));
		int month = Integer.parseInt(today.substring(5,7));
		int day = Integer.parseInt(today.substring(8,10));
		// System.out.println(year+" "+month+" "+day);
		HashMap<Character, Integer> termMap = new HashMap<>();
		for (int i = 0; i < terms.length; i++) {
			String[] line = terms[i].split(" ");
			termMap.put(line[0].charAt(0), Integer.parseInt(line[1]));
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < privacies.length; i++) {
			String[] line = privacies[i].split(" ");
			// 체크 대상
			int cy = Integer.parseInt(line[0].substring(0,4));
			int cm = Integer.parseInt(line[0].substring(5,7));
			int cd = Integer.parseInt(line[0].substring(8,10));

			// 적용 유효기간
			int plusTerm = cm + termMap.get(line[1].charAt(0));
			cy += plusTerm / 12;
			cm = plusTerm % 12;
			// System.out.println(cy+" "+cm+" "+cd);

			// 오늘 날짜랑 비교
			// boolean isExpire = false;
			// if (year > cy) {
			// 	isExpire = true;
			// } else {
			// 	if (month > cm) {
			// 		isExpire = true;
			// 	} else {
			// 		if (day > cd) isExpire = true;
			// 	}
			// }
			// if (year == cy && month == cm && day == cd) isExpire = true;
			// if (isExpire) result.add(i+1);
			int countedToday = countDay(year, month, day);
			int countedChange = countDay(cy,cm,cd);
			if (countedToday >= countedChange) {
				result.add(i+1);
			}
		}
		// System.out.println(result);
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}

	public static int countDay(int year, int month, int day) {
		month += 12*(year-2000);
		day += 28*(month);
		return day;
	}
}