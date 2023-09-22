import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr.add(Long.parseLong(st.nextToken()));
		}
		Collections.sort(arr);
		long min = Long.MAX_VALUE;
		long[] minNums = new long[3];
		for (int i = 0; i < N-1; i++) {
			int le = i+1;
			int ri = N-1;
			while (le < ri) {
				long sum = arr.get(i) + arr.get(le) + arr.get(ri);
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					minNums[0] = arr.get(i);
					minNums[1] = arr.get(le);
					minNums[2] = arr.get(ri);
				}
				if (sum >= 0) {
					ri--;
				} else {
					le++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		sb.append(minNums[0]+ " " + minNums[1]+ " " + minNums[2]);
		System.out.println(sb);
	}
}
