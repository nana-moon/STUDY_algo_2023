import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int length = 3;
		int M = 0;
		while (length < N) {
			M++;
			length = 2*length + (M+3);
		}
		// System.out.println(M);
		// System.out.println(length);
		// S(M) 수열까지 필요함
		while (M > 0) {
			int left = (length-(M+3))/2;
			int middle = left + M+3;
			int right = middle + left;
			if (N <= left) {
				M--;
				length = left;
			} else if (N <= middle) {
				if (N != left +1 ) {
					System.out.println("o");
				} else {
					System.out.println("m");
				}
				break;
			} else {
				M--;
				N -= middle;
				length = left;
			}
		}
		if(M == 0) {
			if (N != 1) {
				System.out.println("o");
			} else {
				System.out.println("m");
			}
		}
	}
}
