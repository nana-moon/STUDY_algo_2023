class Solution {
    public int solution(int[][] triangle) {
        
        int answer = 0;
        int N = triangle.length;
        int[][] dp = new int[N][];
        for(int i = 0; i < N; i++) {
            dp[i] = triangle[i].clone();
        }
        
        
        for(int i = 0; i < N-1; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                dp[i+1][j] = Math.max(triangle[i+1][j] + dp[i][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(triangle[i+1][j+1] + dp[i][j], dp[i+1][j+1]);
            }
        }
        for(int i = 0; i < N; i++) {
             answer = Math.max(answer, dp[N-1][i]);
        }
        return answer;
    }
}