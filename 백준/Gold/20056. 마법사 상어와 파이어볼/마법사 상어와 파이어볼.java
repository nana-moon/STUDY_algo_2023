import java.io.*;
import java.util.*;
public class Main {
	static int N, K;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static class Ball {
		int mass, dir, speed;
		public Ball(int mass, int speed, int dir) {
			this.mass = mass;
			this.speed = speed;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ArrayList<Ball>[][][] arr = new ArrayList[N][N][2];
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j][0] = new ArrayList<>();
				arr[i][j][1] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()); // 속도
			int f = Integer.parseInt(st.nextToken()); // 방향
			arr[a-1][b-1][0].add(new Ball(c, e, f));
		}

		while (K > 0) {
			K--;
			// 0인덱스에서 1 인덱스로 이동
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Iterator<Ball> iter = arr[i][j][0].iterator();
					while (iter.hasNext()) {
						Ball ball = iter.next();
						// 옮겨질 r,c구함
						int ny = (dy[ball.dir] * (ball.speed % N) + i + N) % N; // 1과 N 이어져 있음
						int nx = (dx[ball.dir] * (ball.speed % N) + j + N) % N;
						arr[ny][nx][1].add(ball);
						iter.remove();
					}
				}
			}
			// 1인덱스에서 분해 작업 후 > 0인덱스로
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int size = arr[i][j][1].size();
					if (size == 0) {
						continue;
					} else {
						Iterator<Ball> iter = arr[i][j][1].iterator();
						if (size == 1) {
							Ball now = iter.next();
							arr[i][j][0].add(now);
							iter.remove();
						} else {
							// 나누어질 질량, 속력, 방향 구하기
							int[] tmp = new int[2]; // 질량, 속력 합
							int[] dirs = new int[size];
							int idx = 0;
							while (iter.hasNext()) {
								Ball now = iter.next();
								tmp[0] += now.mass;
								tmp[1] += now.speed;
								dirs[idx] = now.dir%2;
								idx++;
								iter.remove();
							}
							tmp[0] /= 5;
							if (tmp[0] != 0) {
								tmp[1] /= size;
								boolean zero = true;
								for (int k = 1; k < size; k++) {
									if (dirs[k] != dirs[0]) {
										zero = false;
										break;
									}
								}
								int start = 0;
								if (!zero) start = 1;
								for (int k = 1; k <= 4; k++) {
									arr[i][j][0].add(new Ball(tmp[0], tmp[1], start));
									start += 2;
								}
							}
						}
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Ball b : arr[i][j][0]) {
					sum += b.mass;
				}
			}
		}
		System.out.println(sum);
	}
}
