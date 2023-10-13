class Solution {
    public int[][] solution(int n) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        boolean[][] visited = new boolean[n][n];
        int[][] answer = new int[n][n];
        
        int y = 0, x = 0, dir = 0;
        visited[y][x] = true;
        answer[y][x] = 1;
        int num = 2;
        while (num <= n*n) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx]) {
                
            } else {
                dir++;
                dir %= 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            visited[ny][nx] = true;
            answer[ny][nx] = num;
            y = ny;
            x = nx;
            num++;
        }
        return answer;
    }
}