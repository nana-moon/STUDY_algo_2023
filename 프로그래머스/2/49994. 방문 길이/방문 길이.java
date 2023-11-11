import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        float r, c;
        public Node(float r, float c) {
            this.r = r;
            this.c = c;
        }
    }
    public int solution(String dirs) {
        int answer = 0;
        int[] dy = {0,0,1,-1}; // U, D, R, L
        int[] dx = {1,-1,0,0};
        
        HashSet<ArrayList<Float>> visited = new HashSet<>();
        float[] point = new float[] {0,0};
        char[] arr = dirs.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            float ny = 0;
            float nx = 0;
            if (arr[i] == 'U') {
                ny = point[0] + dy[0];
                nx = point[1] + dx[0];
            } else if (arr[i] == 'D') {
                ny = point[0] + dy[1];
                nx = point[1] + dx[1];
            } else if (arr[i] == 'R') {
                ny = point[0] + dy[2];
                nx = point[1] + dx[2];
            } else {
                ny = point[0] + dy[3];
                nx = point[1] + dx[3];
            }
            if (ny < -5 || ny > 5 || nx < -5 || nx > 5) continue;
            ArrayList<Float> node = new ArrayList<>();
            node.add((float) (point[0] + ny) / 2);
            node.add((float) (point[1] + nx) / 2);
    
            // System.out.println(node);
            visited.add(node);
            point[0] = ny;
            point[1] = nx;
        }
        
        return visited.size();
    }
}