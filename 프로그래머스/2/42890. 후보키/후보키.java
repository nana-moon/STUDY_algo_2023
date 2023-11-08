import java.util.*;
class Solution {
    int N;
    int cnt;
    String[][] relations;
    int answer = 0;
    HashSet<TreeSet> candidateKeys = new HashSet<>();
    
    public int solution(String[][] relation) {
        N = relation[0].length;
        
        cnt = relation.length;
        relations = relation;
        for (int i = 1; i <= N; i++) {
            combination(0, new TreeSet<>(), i, 0);
        }
        
        return answer;
    }
    public void combination(int level, TreeSet<Integer> set, int full, int start) {
        if (level == full) {
            if (!unique(set)) return;
            
            for (TreeSet key : candidateKeys) {
                if (set.containsAll(key)) return;
            }
            candidateKeys.add(set);
            answer++;
            return;        
        }
        
        for (int i = start; i < N; i++) {
            set.add(i);
            combination(level+1, new TreeSet<>(set), full, i+1);
            set.remove(i);
        }
    }
    
    public boolean unique(TreeSet<Integer> set) {
        HashSet<String> rows = new HashSet<>();

        for (String[] relation : relations) {
            String newStr = "";
            for (int key : set) {
                newStr += relation[key] + ",";
            }
            rows.add(newStr);
        }
        
        return rows.size() == cnt;
        
        // List<String> list = new ArrayList<>();
        // // 만들어진 조합으로 중복되는지 검사
        // for (int i = 0; i < cnt; i++) {
        //     StringBuilder sb = new StringBuilder();
        //     for (int idx : set) {
        //         sb.append(relations[i][idx]);
        //     }
        //     if(!list.contains(sb.toString())) {
        //         list.add(sb.toString());
        //     } else {
        //         return false;
        //     }
        // }
        // return true;
    }
}