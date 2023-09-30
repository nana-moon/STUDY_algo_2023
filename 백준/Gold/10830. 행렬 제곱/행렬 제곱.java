import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int MOD = 1000;
	public static int N;
	public static int[][] origin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		origin = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// B가 1일 경우 고려
				origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}

		int[][] result = pow(origin, B);

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}
	public static int[][] pow(int[][] A, long exp) {
		if (exp == 1L) {
			return A;
		}
		int[][] ret = pow(A, exp / 2);
		ret = multiply(ret, ret);
		if (exp % 2 != 0) {
			ret = multiply(ret, A);
		}
		return ret;
	}
	public static int[][] multiply(int[][] A, int[][] B) {
		int[][] ret = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					ret[i][j] += A[i][k] * B[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
}
