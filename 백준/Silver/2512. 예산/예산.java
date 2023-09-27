import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cities[];

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cities = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			cities[i] = num;
			sum += num;
			max = Math.max(max, num);
		}
		M = Integer.parseInt(br.readLine());
		if (M >= sum) {
			System.out.println(max);
			return;
		}
		Arrays.sort(cities);
		// System.out.println(Arrays.toString(cities));
		// System.out.println(max);

		int start = 1;
		int end = max;
		while (start < end) {
			int mid = (start + end) / 2;
			int result = returnSum(mid);
			// System.out.println("mid " + mid + " result " +result);
			if (result > M) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start-1);
	}
	public static int returnSum(int n) {
		boolean stop = false;
		int i = 0;
		int result = 0;
		while (i < N) {
			if (cities[i] >= n) {
				stop = true;
				break;
			}
			result += cities[i];
			i++;
		}
		if (stop) {
			result += n*(N-i);
		}
		return result;
	}
}
