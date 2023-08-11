import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(num);
		}
		int[] arr = new int[N];
		int idx = 0;
		while(!pq.isEmpty()) {
			arr[idx] = pq.poll();
			idx++;
		}
		int left = 0;
		int right = 0;
		int minVal = Integer.MAX_VALUE;
		// System.out.println(Arrays.toString(arr));
		while (right < N) {
			int gap = arr[right] - arr[left];
			if(gap < M) {
				right++;
			} else if (gap > M) {
				left++;
				minVal = Math.min(minVal, gap);
			} else {
				minVal = Math.min(minVal, gap);
				break;
			}
		}
		System.out.println(minVal);

	}
}
