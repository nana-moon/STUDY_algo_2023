import java.io.*;
import java.util.*;
// 내일 할거야
public class Main {
	static class Homework {
		int dur;
		int end;
		public Homework(int dur, int end) {
			this.dur = dur;
			this.end = end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Homework> pq = new PriorityQueue<>((x1, x2) -> (x1.end == x2.end) ? x1.dur - x2.dur : x2.end - x1.end );
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int day = pq.peek().end;
		while (!pq.isEmpty()) {
			Homework work = pq.poll();
			if (work.end <= day) {
				day = work.end - work.dur;
			} else {
				day -= work.dur;
			}
		}
		System.out.println(day);
	}
}
