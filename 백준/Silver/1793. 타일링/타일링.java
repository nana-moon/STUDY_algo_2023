import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// BigInteger 사용법, BufferedReader 계속 받는 법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] dp = new BigInteger[251];
		dp[0] = BigInteger.valueOf(1); // new BigInteger("2"), BigInteger.TWO로도 표현 가능
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(3);
		for(int i = 3; i <= 250; i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.valueOf(2)));
		}

		String num;
		while((num = br.readLine()) != null) {
			int N = Integer.parseInt(num);
			System.out.println(dp[N]);
		}
	}
}
