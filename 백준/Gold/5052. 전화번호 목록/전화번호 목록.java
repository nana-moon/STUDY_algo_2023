
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> str_set = new HashSet<>();
			TreeSet<Integer> len_set = new TreeSet<>();
			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				str_set.add(str);
				len_set.add(str.length());
			}
			boolean is_consist = true;
			for (String str: str_set) {
				for (int len: len_set) {
					if (str.length() <= len) break;
					if (str_set.contains(str.substring(0, len))) is_consist = false;

				}
			}
			if (is_consist)
				sb.append("YES" + "\n");
			else
				sb.append("NO" + "\n");


		}
		System.out.println(sb);
	}
}
