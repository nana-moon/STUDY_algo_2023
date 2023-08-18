import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		ArrayDeque<Character> stack = new ArrayDeque<>(); // offerFirst, poll
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'P') {
				stack.offer('P');
			} else {
				// A일 경우에는 pop 2번, 뒤의 문자 확인
				if(stack.size() >= 2 && i != str.length()-1 && str.charAt(i+1) == 'P') {
					stack.poll();
					stack.poll();
					i++;
					stack.offer('P');
				} else {
					System.out.println("NP");
					return;
				}

			}
		}
		if (stack.size() != 1) {
			System.out.println("NP");
		} else {
			System.out.println("PPAP");
		}
	}
}