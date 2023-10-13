import java.io.*;
import java.util.*;
public class Main {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		arr = new int[5][5];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] check = new int[12];
		int bingo = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int call = Integer.parseInt(st.nextToken());
				int[] idx = findIdx(call);

				check[idx[0]]++;
				if (check[idx[0]] == 5) bingo++;
				
				check[idx[1]+5]++;
				if (check[idx[1]+5] == 5) bingo++;
				
				if (idx[0] == idx[1]) {
					check[10]++;
					if (check[10] == 5)
						bingo++;
				}
				if (idx[0] + idx[1] == 4) {
					check[11]++;
					if (check[11] == 5) {
						bingo++;
					}
				}

				if (bingo >= 3) {
					System.out.println(5*i+(j+1));
					return;
				}
			}
		}
	}
	public static int[] findIdx(int call) {
		int[] answer = new int[2];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == call) {
					answer[0] = i;
					answer[1] = j;
				}
			}
		}
		return answer;
	}
}
