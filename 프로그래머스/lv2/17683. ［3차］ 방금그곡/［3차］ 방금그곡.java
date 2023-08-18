import java.util.*;
class Solution {
    static class Music implements Comparable<Music> {
		String title;
		int dur, idx;

		Music (String title, int dur, int idx) {
			this.title = title;
			this.dur = dur;
			this.idx = idx;
		}
		@Override
		public int compareTo(Music m) {
			int result = m.dur - this.dur;
			if (result == 0) return this.idx - m.idx;
			return m.dur - this.dur;
		}

	}

	public static String solution(String m, String[] musicinfos) {
		String answer = "";
		m = changeNote(m);
		PriorityQueue<Music> musics = new PriorityQueue<>();
		int i = 0;
		for(String info : musicinfos) {
			String[] infos = info.split(",");
			int dur = toIntTime(infos[1])-toIntTime(infos[0]);
			String title = infos[2];
			String origin = changeNote(infos[3]);
			int len = origin.length();
			String melody = origin.repeat(dur/len);
			melody += origin.substring(0,dur%len);
			if (melody.contains(m)) {
				musics.offer(new Music(title, dur, i));
			}
			i++;
		}

		if (musics.isEmpty()) {
			return "(None)";
		}
		return musics.poll().title;
	}
	public static String changeNote(String str) {
		str = str.replaceAll("C#", "c");
		str = str.replaceAll("D#", "d");
		str = str.replaceAll("F#", "f");
		str = str.replaceAll("G#", "g");
		str = str.replaceAll("A#", "a");
		return str;
	}
	public static int toIntTime(String str) {
		String[] times = str.split(":");
		return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
	}
}