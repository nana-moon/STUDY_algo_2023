import java.util.*;
class Solution {
    int[] bosses = new int[2501];
    String[] words = new String[2501];
    public int toIdx(String r, String c) {
        return (Integer.parseInt(r)-1)*50 + Integer.parseInt(c);
    }
    public void union(int a, int b) {
        a = find_boss(a);
        b = find_boss(b);
        if (a != b)
            bosses[b] = a;
    }
    public int find_boss(int a) {
        if (bosses[a] == -1) return a;
        int ret = find_boss(bosses[a]);
        bosses[a] = ret;
        return ret;
    }
    public String[] solution(String[] commands) {
        Arrays.fill(bosses, -1);
        Arrays.fill(words, "");
        ArrayList<String> ansList = new ArrayList<>();
        for (String command : commands) {
            String[] cmd = command.split(" ");
            if (cmd[0].equals("UPDATE")) {
                if (cmd.length == 4) {
                    int idx = toIdx(cmd[1], cmd[2]);
                    int boss = find_boss(idx);
                    words[boss] = cmd[3];
                } else {
                    for (int i = 1; i < 2501; i++) {
                        if (words[i].equals(cmd[1])) {
                            words[i] = cmd[2];
                        }
                    }   
                }
            } else if (cmd[0].equals("MERGE")) {
                int idx1 = toIdx(cmd[1], cmd[2]);
                int idx2 = toIdx(cmd[3], cmd[4]);
                int boss1 = find_boss(idx1);
                int boss2 = find_boss(idx2);
                if (boss1 == boss2) continue;
                String word = words[boss1].isBlank() ? words[boss2] : words[boss1];
                words[boss1] = "";
                words[boss2] = "";
                union(idx1, idx2);
                words[boss1] = word;
            } else if (cmd[0].equals("UNMERGE")) {
                int idx = toIdx(cmd[1], cmd[2]);
                int boss = find_boss(idx);
                String rootString = words[boss];
                words[boss] = "";
                words[idx] = rootString;
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 1; i <= 2500; i++) {
                    if (find_boss(i) == boss)
                        deleteList.add(i);
                }
                for (Integer t : deleteList)
                    bosses[t] = -1;
            } else {
                int idx = toIdx(cmd[1], cmd[2]);
                int boss = find_boss(idx);
                if (words[boss].isBlank()) {
                    ansList.add("EMPTY");
                } else {
                    ansList.add(words[boss]);
                }
            }
        }
        return ansList.toArray(new String[0]);
    }
}