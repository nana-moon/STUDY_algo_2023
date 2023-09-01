import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for (int i = 1; i < 1000000; i++) {
			int now = dp[i];
			dp[i+1] = Math.min(now+1, dp[i+1]);
			if(i*2 <= 1000000) {
				dp[i*2] = Math.min(now+1, dp[i*2]);
			}
			if(i*3 <= 1000000) {
				dp[i*3] = Math.min(now+1, dp[i*3]);
			}
		}
		System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}
