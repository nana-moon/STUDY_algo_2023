import java.util.*;

class Solution {
    static HashMap<String, Integer> now = new HashMap<>();
    static HashMap<String, Integer> target = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++) {
            target.put(want[i], number[i]);
        }
        System.out.println(target);
        int answer = 0;
        for (int i = 0; i < discount.length; i++) {
            // 초기화 안하면 null point 오류
            now.putIfAbsent(discount[i], 0);
            int a = now.get(discount[i]);
            now.put(discount[i], a+1);
            if (i >= 10) {
                int b = now.get(discount[i-10]);
                now.put(discount[i-10], b-1);
            }
            if (sameNow()) answer++;
        }
        return answer;
    }
    public static boolean sameNow() {
        for (String key : target.keySet()) {
            if (!now.containsKey(key)) return false;
            if (now.get(key) != target.get(key)) return false;
        }
        return true;
    }
}