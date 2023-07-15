import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N][10];
		for (int i = 1; i < 10; i++) {
			dp[0][i] = 1;
		}
        long mod = 1000000000;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j-1 >= 0) dp[i][j] += dp[i-1][j-1] % mod;
				if (j+1 < 10) dp[i][j] += dp[i-1][j+1] % mod;
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N-1][i];
		}
		
		System.out.println(sum%mod);
	}
}
