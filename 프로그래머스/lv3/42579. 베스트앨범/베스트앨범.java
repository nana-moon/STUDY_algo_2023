import java.util.*;
import java.io.*;

class Solution {
	static class Music {
		int idx;
		String genre;
		int plays;
		public Music (int idx, String genre, int plays) {
			this.idx = idx;
			this.genre = genre;
			this.plays = plays;
		}
	}
	public static int[] solution(String[] genres, int[] plays) {
		// 재생 수 많은 순대로 해시 맵에 넣어 정렬
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}
		// 새로운 리스트 선언 후 정렬된 애들 담기
		ArrayList<String> ordered_genre = new ArrayList<>();
		while (map.size() != 0) {
			int max_plays = -1;
			String max_genre = "";
			for (String genre : map.keySet()) {
				if (map.get(genre) > max_plays) {
					max_plays = map.get(genre);
					max_genre = genre;
				}
			}
			ordered_genre.add(max_genre);
			map.remove(max_genre);
		}
		// 정렬된 list에서 하나씩 추출하여 안의 노래를 내림차순으로 또 정렬하여 1개 또는 2개의 클래스를 결과 list에 append
		ArrayList<Music> result = new ArrayList<>();
		for (String genre2 : ordered_genre) {
			ArrayList<Music> music_list = new ArrayList<>();
			for (int j = 0; j < genres.length; j++) {
				if (genres[j].equals(genre2)) {
					music_list.add(new Music(j, genre2, plays[j]));
				}
			}
			// 정렬
			Collections.sort(music_list, (o1, o2) -> o2.plays - o1.plays);
			// 가장 앞에 있는 애들
			result.add(music_list.get(0));
			if (music_list.size() > 1) {
				result.add(music_list.get(1));
			}
		}
		// 정답 return
		int[] answer = new int[result.size()];
		for (int k = 0; k < result.size(); k++) {
			answer[k] = result.get(k).idx;
		}
		return answer;
	}
	// public static void main(String[] args) {
	// 	String[] genres = {"classic", "pop", "classic", "classic", "pop"};
	// 	int[] plays = {500, 600, 150, 800, 2500};
	// 	System.out.println(Arrays.toString(solution(genres, plays)));
	// }

}
