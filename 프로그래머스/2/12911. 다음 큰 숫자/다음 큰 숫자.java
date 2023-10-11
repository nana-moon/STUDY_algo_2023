class Solution {
    public int solution(int n) {
        int curOne = toBinary(n);
        while (true) {
            if (toBinary(++n) == curOne) break;
        }
        return n;
    }
    // 2진수로 변환했을 때 1의 개수
    public int toBinary(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) cnt++;
            n /= 2;
        }
        return cnt;
    }
}