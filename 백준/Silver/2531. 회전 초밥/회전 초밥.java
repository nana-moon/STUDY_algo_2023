import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		HashMap<Integer,Integer> sushiCnt = new HashMap<>();
		sushiCnt.put(c,1);
		int[] arr = new int[N+k];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = N; i < N+k; i++) {
			arr[i] = arr[i-N];
		}
		// System.out.println(Arrays.toString(arr));
		int max = 0;
		int left = 0;
		int len = 0;
		while (left < N) {
			if(len < k) {
				if (!sushiCnt.containsKey(arr[len])) {
					sushiCnt.put(arr[len],1);
				} else {
					sushiCnt.replace(arr[len], sushiCnt.get(arr[len])+1);
				}
				len++;
			} else {
				// left ++, max 갱신
				max = Math.max(max, sushiCnt.size());
				// System.out.println(left);

				if(sushiCnt.get(arr[left])-1 == 0) {
					sushiCnt.remove(arr[left]);
				} else {
					sushiCnt.replace(arr[left], sushiCnt.get(arr[left])-1);
				}
				if (!sushiCnt.containsKey(arr[left+len])) {
					sushiCnt.put(arr[left+len],1);
				} else {
					sushiCnt.replace(arr[left+len], sushiCnt.get(arr[left+len])+1);
				}
				left++;
			}
		}
		System.out.println(max);
	}
}
