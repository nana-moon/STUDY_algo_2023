import java.util.*;

class Solution {
    int N;
    HashSet<HashSet<Integer>> result = new HashSet<>();
    String[] banned;
    String[] user;
    
    public int solution(String[] user_id, String[] banned_id) {
        N = banned_id.length;
        banned = banned_id;
        user = user_id;
     
        dfs(0, new HashSet<>());
        
        return result.size();
    }
    public void dfs(int level, HashSet<Integer> set) {
        if (level == N) {
            result.add(set);
            return;
        }
        for (int i = 0; i < user.length; i++) {
            if (set.contains(i)) continue;
            if (same(banned[level], user[i])) {
                // System.out.println(banned[level]+ " "+ user[i]+" "+ level);
                set.add(i);
                dfs(level+1, new HashSet<>(set));
                set.remove(i);
            }
        }
    }
    public boolean same(String ban, String use) {
        if (ban.length() != use.length()) return false;
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (ban.charAt(i) != use.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}