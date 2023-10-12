import java.util.*;

class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    boolean[] visited;
    int banSize, userSize;
    HashSet<String> combi = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        banSize = banned_id.length;
        userSize = user_id.length;
        visited = new boolean[userSize];
        for (String banned : banned_id) {
            if (map.containsKey(banned)) continue;
            map.put(banned, new ArrayList<>());
            for (int i = 0; i < userSize; i++) {
                String user = user_id[i];
                if (isMember(user, banned)) map.get(banned).add(i);
            }
            
        }
        // System.out.println(map);
        dfs(0, banned_id);
        return combi.size();
    }
    public boolean isMember(String member, String team) {
        if (member.length() != team.length()) return false;
        for (int i = 0; i < member.length(); i++) {
            if (team.charAt(i) == '*') continue;
            else if (team.charAt(i) != member.charAt(i)) return false;
        }
        return true;
    }
    public void dfs(int level, String[] banned_id) {
        if (level == banSize) {
            StringBuilder sb = new StringBuilder();
            for (int i =0; i < userSize; i++) {
                if (visited[i]) sb.append(i);
            }
            combi.add(sb.toString());
            return;
        }
        String target = banned_id[level];
        ArrayList<Integer> idxs = map.get(target);
        for (int idx : idxs) {
            if (!visited[idx]) {
                visited[idx] = true;
                dfs(level+1, banned_id);
                visited[idx] = false;
            }
        }
    }
}