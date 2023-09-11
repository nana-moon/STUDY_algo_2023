import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i < N+1; i++) {
			if (isPrime[i]) {
				for (int j = i*2; j < N+1; j += i) {
					isPrime[j] = false;
				}
			}
		}
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i  = 2; i < N+1; i++) {
			if (isPrime[i]) primes.add(i);
		}
		int cnt = 0;
		int st = 0;
		int sum = 0;
		for (int ed = 0; ed < primes.size(); ed++) {
			sum += primes.get(ed);
			if (sum >= N) {
				// st 증가
				while (st < primes.size() && sum >= N) {

					if (sum == N) {
						cnt++;
					}

					sum -= primes.get(st);
					st++;
				}
			}
		}
		System.out.println(cnt);
	}
}
