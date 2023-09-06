import java.io.*;
import java.util.*;
class Solution {
    
    public static int solution(int[][] scores) {
        int A = scores[0][0];
        int B = scores[0][1];
        int sum = A+B;
        Arrays.sort(scores, (x1, x2) -> x2[0] == x1[0] ? x1[1] - x2[1] : x2[0] - x1[0]);
        ArrayList<Integer> sums = new ArrayList<>();
        int pre = scores[0][1];
        sums.add(scores[0][0]+scores[0][1]);
        for(int i = 1; i < scores.length; i++) {
            if (pre <= scores[i][1]) {
                pre = scores[i][1];
                sums.add(scores[i][0]+scores[i][1]);
            } else if (pre > scores[i][1]) {
                if (scores[i][0] == A && scores[i][1] == B) {
                    return -1;
                }
            }
        }
        sums.sort((x1,x2) -> x2-x1);
        int rank = 1;
        for(int i = 0; i < sums.size(); i++) {
            
            if (sums.get(i) == sum) return rank;
            rank ++;
        }
        return -1;
    }
}