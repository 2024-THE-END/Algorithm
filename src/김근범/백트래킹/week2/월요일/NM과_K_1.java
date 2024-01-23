package 김근범.백트래킹.week2.월요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM과_K_1 {

    static int N, M, K;
    static int[][] board;
    static boolean[][] check;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        check = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fetchMax(0, 0, 0, 0);
        System.out.println(max);
    }

    private static void fetchMax(int r, int c, int sum, int index) {
        if(index == K) {
            if(sum > max) max = sum;
            return;
        }

        for(int i=r;i<N;i++){
            for(int j=(i==r ? c : 0); j<M;j++){
                if(isValid(i, j)) {
                    check[i][j] = true;
                    int result = sum + board[i][j];
                    fetchMax(i, j+1, result, index+1);
                    check[i][j] = false;
                }
            }
        }
    }

    private static boolean isValid(int r, int c) {
        if(check[r][c]) return false;
        if(c-1>=0 && check[r][c-1]) return false;
        if(r-1>=0 && check[r-1][c]) return false;
        if(r+1<N && check[r+1][c]) return false;
        if(c+1<M && check[r][c+1]) return false;
        return true;
    }
}
