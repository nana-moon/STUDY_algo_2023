import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // for문 돌면서 인자 확인
        int idx = 0;
        for (int[] command: commands) {
            answer[idx] = getResult(command[0]-1, command[1], command[2], array);
            idx += 1;
        }
        return answer;
    }
    public static int getResult(int start, int end, int place, int[] array) {
        int[] temp = Arrays.copyOfRange(array, start, end);
        Arrays.sort(temp);
        return temp[place -1];
    }
}