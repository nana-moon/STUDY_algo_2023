import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String changed = Integer.toString(n,k);
        int answer = 0;
        String str = "";
        for(int i = 0; i < changed.length(); i++) {
            if (changed.charAt(i) == '0') {
                // 소수인지 판단
                if (str.length() > 0) {
                    long num = Long.parseLong(str);
                    if(isPrime(num)) answer++;
                    // 초기화
                    str = "";
                }
            } else {
                str += changed.charAt(i);
            }
        }
        if (str.length() > 0) {
            long num = Long.parseLong(str);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    
    public static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}