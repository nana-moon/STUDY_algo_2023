import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] newArr = new int[H+X][W+Y];
		for (int i = 0; i < H+X; i++) {
			String[] tmp = br.readLine().split(" ");
			// String 배열을 int 배열로 변환
			newArr[i] = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();
		}
		int[][] origin = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// if (newArr[i][j] == 0) continue;
				int nx = i - X;
				int ny = j - Y;
				// 초기화
				boolean after = true;
				// if (i >= H || j >= W) before = false;
				if (nx < 0 || ny < 0) after = false;
				if (!after) {
					origin[i][j] = newArr[i][j];
				} else {
					origin[i][j] = newArr[i][j] - origin[nx][ny];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i =0; i < H; i++) {
			for ( int j = 0; j < W; j++) {
				sb.append(origin[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
