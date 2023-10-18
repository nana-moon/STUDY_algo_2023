class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // 이진수로 변환
            String str = Long.toBinaryString(numbers[i]);
            // 완전 이진 트리의 높이 구해주기
            int h = 0;
            while ((int) Math.pow(2, h) - 1 < str.length()) {
                h++;
            }
            // 이진 트리의 높이만큼 0을 추가해줌
            h = (int) Math.pow(2, h) - 1;
            while (str.length() < h) {
                str = "0" + str;
            }
            // 이진수가 이진트리로 표현 가능한지 확인
            if (dfs(str)) {
                answer[i] = 1;
            }
        }
        return answer;
    }
    public boolean dfs(String str) {
        int mid = (str.length()-1) / 2;
        String left = str.substring(0, mid);
        String right = str.substring(mid+1);
        
        if (str.charAt(mid) == '0' && (left.charAt((left.length()-1)/2) == '1' || right.charAt((right.length()-1)/2) == '1')) return false;
        
        if (left.length() >= 3) {
            if (dfs(left) == true && dfs(right) == true) return true;
            return false;
        }
        return true;
    }
}