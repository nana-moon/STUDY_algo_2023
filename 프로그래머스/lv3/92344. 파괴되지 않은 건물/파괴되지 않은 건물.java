class Solution {
    // 배열의 특정 구간에 같은 값을 더하거나 빼는 로직
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] preSum = new int[N+1][M+1];
        for(int[] s: skill) { 
            if(s[0] == 1) {
                // 공격
                preSum[s[1]][s[2]] -= s[5];
                preSum[s[1]][s[4]+1] += s[5];
                preSum[s[3]+1][s[2]] += s[5];
                preSum[s[3]+1][s[4]+1] -= s[5];
            } else {
                preSum[s[1]][s[2]] += s[5];
                preSum[s[1]][s[4]+1] -= s[5];
                preSum[s[3]+1][s[2]] -= s[5];
                preSum[s[3]+1][s[4]+1] += s[5];
            }
        }
        for(int i = 0; i < N+1; i++) {
            for(int j = 1; j <M+1; j++) {
                preSum[i][j] += preSum[i][j-1];
            }
        }
        for(int j = 0; j < M+1; j++) {
            for(int i = 1; i <N+1; i++) {
                preSum[i][j] += preSum[i-1][j];
            }
        }
        int answer = 0;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if (board[i][j] + preSum[i][j]> 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}