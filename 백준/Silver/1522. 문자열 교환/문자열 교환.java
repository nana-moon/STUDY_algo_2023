import java.io.*;
import java.util.*;
public class Main {
	//  슬라이딩 윈도우
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int aCnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') aCnt++;
		}

		int start = 0;
		int end = aCnt; // 슬라이딩 윈도우 범위의 바로 다음 idx
		int bCnt = 0;
		for (int i = 0; i < end; i++) {
			if (str.charAt(i) == 'b') bCnt++;
		}
		int minB = bCnt;
		while (start < str.length()) {
			if (str.charAt(start) == 'b') bCnt--;
			if (str.charAt(end % str.length()) == 'b') bCnt++;
			minB = Math.min(minB, bCnt);
			start++;
			end++;
		}
		System.out.println(minB);
	}
}
