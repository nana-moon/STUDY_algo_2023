class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int h = 3; h < brown / 2; h++) {
            if (total % h == 0) {
                int w = total / h;
                if (2*w + 2*h - 4 == brown) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        return answer;
    }
}