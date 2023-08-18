import java.io.*;
import java.util.*;
public class Main {
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		long result = pow(A, B);
		System.out.println(result);
	}
	public static long pow(long A, long exponent) {
		if (exponent == 1) {
			return A % C;
		}
		long temp = pow(A, exponent / 2);
		if (exponent % 2 == 0) {
			return temp * temp % C;
		} else {
			return (temp * temp % C) * A % C;
		}

	}
}
