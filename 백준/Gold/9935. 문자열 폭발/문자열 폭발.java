import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] origin = br.readLine().toCharArray();
		String find = br.readLine();
		int N = find.length();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < origin.length; i++) {
			stack.push(origin[i]);
			if(stack.size() >= N) {
				// 마지막 문자열이 같은지 확인 후 같으면 pop N번
				boolean isSame = true;
				for(int k = 0; k < N; k++) {
					if(find.charAt(k) != stack.get(stack.size()-N+k)) {
						isSame = false;
					}
				}
				if(isSame) {
					for(int n = 0; n < N; n++) {
						stack.pop();
					}
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		for(Character ch : stack) {
			sb.append(ch);
		}
		if(sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}
	}
}
