import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] line = br.readLine().toCharArray();
		double[] num = new double[N];
		for(int i = 0; i < N; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		HashSet<Character> operators = new HashSet<>(Arrays.asList('+','-','/','*'));
		ArrayDeque<Double> stack = new ArrayDeque<>();
		for(int i = 0; i < line.length; i++) {
			if(operators.contains(line[i])) {
				// pop 2번 해서 연산 후 다시 넣어줌
				double a = stack.pop();
				double b = stack.pop();
				stack.offerFirst(calculate(b,a,line[i]));
			} else {
				// 숫자로 변경해서 stack 넣어주기
				int idx = line[i]-'A';
				stack.offerFirst(num[idx]);
			}
		}
		// 소수점 둘째자리까지 출력
		System.out.println(String.format("%.2f", stack.poll()));
	}
	public static double calculate(double b, double a, char operator) {
		if(operator == '+') {
			return b+a;
		} else if (operator == '-') {
			return b-a;
		} else if (operator == '*') {
			return b*a;
		} else {
			return b/a;
		}
	}
}
