import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static ArrayList<Long> downNums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		downNums = new ArrayList<>();

		for(int i = 0; i < 10; i++) {
			dfs(i,1); // 숫자, 자릿수
		}
		Collections.sort(downNums);
		if (N >= downNums.size()) {
			System.out.println(-1);
		} else {
			System.out.println(downNums.get(N));
		}
	}
	public static void dfs(long num, int idx) {
		if (idx > 10) {
			return;
		}
		downNums.add(num);

		for(long i = 0; i < num % 10; i++) {
			dfs(num*10+i, idx+1);
		}
	}
}
