package 김근범.백트래킹.금요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴백홈 {

    static int R, C, K;
    static char[][] map;
    static boolean[][] check;
    static int total = 0;

    static int curR, curC;

    static int[] rDir = {-1, 0, 0, 1};
    static int[] cDir = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        check = new boolean[R][C];
        for(int i =0;i<R;i++){
            String input = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = input.charAt(j);
            }
        }
        curR = R-1;
        curC = 0;
        findLengthK(0);
        System.out.println(total);
    }

    private static void findLengthK(int index) {
        if(curR == 0 && curC == C-1) {
            if(index == K-1) total++;
            return;
        }
        if(index == K) {
            return;
        }
        check[curR][curC] = true;
        for(int i=0;i<4;i++) {
            if(validDir(i)) {
                curR += rDir[i];
                curC += cDir[i];
                findLengthK(index + 1);
                curR -= rDir[i];
                curC -= cDir[i];
            }
        }
        check[curR][curC] = false;
    }

    private static boolean validDir(int i) {
        int nextR = curR + rDir[i];
        int nextC = curC + cDir[i];
        if(nextR <0 || nextR >= R) return false;
        if(nextC <0 || nextC >= C) return false;
        if(check[nextR][nextC]) return false;
        if(map[nextR][nextC] == 'T') return false;
        return true;
    }
}
