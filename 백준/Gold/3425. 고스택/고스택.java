import java.io.*;
import java.util.*;

public class Main {
	static long MAX = (long) Math.pow(10,9);
	static ArrayList<String> order = new ArrayList<>();
	static LinkedList<Long> stack = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			order.clear();
			String line = br.readLine();
			if(line.equals("QUIT")) break;
			while(!line.equals("END")){
				String[] splitLine = line.split(" ");
				if(splitLine.length == 1) {
					order.add(splitLine[0]);
				} else {
					order.add(splitLine[0]);
					order.add(splitLine[1]);
				}
				line = br.readLine();
			}
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				long num = Long.parseLong(br.readLine());
				if (solution(num)) {
					sb.append(stack.removeLast() + "\n");
				} else {
					sb.append("ERROR" + "\n");
				}
			}
			sb.append("\n");
			br.readLine();
		}
		System.out.println(sb);
	}
	public static boolean solution(long num) {
		stack.clear();
		stack.addLast(num);
		int idx = 0;

		while (idx < order.size()) {
			String operator = order.get(idx);
			if (operator.equals("NUM")) {
				stack.addLast(Long.parseLong(order.get(idx+1)));
				idx++;
			} else if (operator.equals("POP")) {
				if (stack.isEmpty()) return false;
				stack.removeLast();
			} else if (operator.equals("INV")) {
				if (stack.isEmpty()) return false;
				long tmp = stack.removeLast();
				stack.addLast(-tmp);
			} else if (operator.equals("DUP")) {
				if (stack.isEmpty()) return false;
				stack.addLast(stack.getLast());
			} else if (operator.equals("SWP")) {
				if (stack.size() < 2) return false;
				long fir = stack.removeLast();
				long sec = stack.removeLast();
				stack.addLast(fir);
				stack.addLast(sec);
			} else if (operator.equals("ADD")) {
				if (stack.size() < 2) return false;
				long fir = stack.removeLast();
				long sec = stack.removeLast();
				if (Math.abs(sec+fir) > MAX) return false;
				stack.addLast(sec+fir);
			} else if (operator.equals("SUB")) {
				if (stack.size() < 2) return false;
				long fir = stack.removeLast();
				long sec = stack.removeLast();
				if (Math.abs(sec-fir) > MAX) return false;
				stack.addLast(sec-fir);
			} else if (operator.equals("MUL")) {
				if (stack.size() < 2) return false;
				long fir = stack.removeLast();
				long sec = stack.removeLast();
				if (Math.abs(sec*fir) > MAX) return false;
				stack.addLast(sec*fir);
			} else if (operator.equals("DIV")) {
				if (stack.size() < 2) return false;
				long fir = stack.removeLast();
				long sec = stack.removeLast();
				int minusCnt = 0;
				if (fir == 0) return false;
				if (fir < 0) minusCnt++;
				if (sec < 0) minusCnt++;
				long div = Math.abs(sec) / Math.abs(fir);
				if (div > MAX) return false;
				if (minusCnt == 1) {
					stack.addLast(div*-1);
				} else {
					stack.addLast(div);
				}
			} else if (operator.equals("MOD")) {
				if (stack.size() < 2) return false;
				long fir = stack.removeLast();
				long sec = stack.removeLast();
				if (fir == 0) return false;
				long mod = Math.abs(sec) % Math.abs(fir);
				if (mod > MAX) return false;
				if (sec < 0) {
					stack.addLast(mod*-1);
				} else {
					stack.addLast(mod);
				}
			}
			idx++;
		}
		if (stack.size() != 1) return false;
		return true;

	}
}
