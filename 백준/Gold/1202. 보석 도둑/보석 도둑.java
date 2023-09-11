import java.io.*;
import java.util.*;
public class Main {
	static class Jewel {
		int weight, price;
		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int[] bags = new int[K];
		for (int i =0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jewels, (a,b) -> a.weight == b.weight ? b.price - a.price : a.weight - b.weight);
		Arrays.sort(bags); // 람다 정렬 하려면 래퍼 클래스 배열이어야 함
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		long sum = 0;
		int j = 0;
		for (int i = 0; i < K; i++) {
			int bagW = bags[i];
			while (j < N && jewels[j].weight <= bagW) {
				pq.offer(jewels[j].price);
				j++;
			}

			if (!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		System.out.println(sum);

	}
}
