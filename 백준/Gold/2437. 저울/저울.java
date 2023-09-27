import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int prefixSum  = 0;
		for (int i = 0; i < N; i++) {
			if (prefixSum + 1 < arr[i]) break;
			prefixSum += arr[i];
		}
		System.out.println(prefixSum + 1);
	}
}
