import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.offerFirst(arr[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) answer = false;
        return answer;
    }
}