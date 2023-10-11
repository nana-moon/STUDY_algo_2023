class Solution {
    public long solution(int[] sequence) {
        int[] reverse = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            reverse[i] = sequence[i]*-1;
        }
        // dp[i][0] = sequence[i]가 1로 끝나는 수열 중 가장 큰 값
        // dp[i][1] = sequence[i]가 -1로 끝나는 수열 중 가장 큰 값
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = reverse[0];
        long answer = Math.max(dp[0][1], dp[0][0]);
        for(int i = 1; i < sequence.length; i++) {
            dp[i][0] = Math.max(sequence[i], dp[i-1][1] + sequence[i]);
            dp[i][1] = Math.max(reverse[i], dp[i-1][0] + reverse[i]);
            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
        }
        return answer;
    }
}