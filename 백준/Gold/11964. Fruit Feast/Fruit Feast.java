import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int max = 0;
    static boolean[] dp;        //지나온 fullness 체크를 위한 배열

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int A = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        dp = new boolean[T+1];
        dfs(0, T, A, B, false);

        System.out.println(max);
    }

    public static void dfs(int temp, int T, int A, int B, boolean flag) {
        if(dp[temp]) return;              //지나온 fullness면 중지

        max = Math.max(max, temp);
        dp[temp] = true;

        int sum = temp+A;

        if(sum<=T) {
            if(!flag)
                dfs(sum/2, T, A, B, true);

            dfs(sum, T, A, B, flag);
        }

        sum = temp+B;

        if(sum<=T) {
            if(!flag)
                dfs(sum/2, T, A, B, true);

            dfs(sum, T, A, B, flag);
        }
    }
}