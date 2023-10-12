import java.util.*;

class Solution {
    static ArrayList<Integer> keys = new ArrayList<>();
    static int colSize, rowSize;
    
    public int solution(String[][] relation) {
        rowSize = relation.length;
        colSize = relation[0].length;
        // i의 개수 = 가능한 부분 집합의 개수
        for (int i = 1; i < (1<<colSize); i++) {
            if (!isMinimal(i)) continue;
            if (!isUnique(i, relation)) continue;
            keys.add(i);
        }
        return keys.size();
    }
    public static boolean isMinimal(int num) {
        for (int key : keys) {
            if ((num & key) == key) return false;
        }
        return true;
    }
    public static boolean isUnique(int num, String[][] relation) {
        ArrayList<Integer> indexs = changeToIndex(num);
        HashSet<String> set = new HashSet<>();
        StringBuilder sb;
        for (int i = 0; i < rowSize; i++) {
            sb = new StringBuilder();
            for (int idx: indexs) {
                sb.append(relation[i][idx]);
            }
            set.add(sb.toString());
        }
        return set.size() == rowSize;
    }
    public static ArrayList changeToIndex(int num) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < colSize; i++) {
            // 0 false
            if (((num >> i) & 1) == 1) {
                answer.add(i);
            }
        }
        return answer;
    }
}