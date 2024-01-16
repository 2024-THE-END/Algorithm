package 김창우.SecondWeek.monday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ18290_NM과K_1 {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        answer=Integer.MIN_VALUE;
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int depth,int sum) {
        if (depth == K) {
           answer=Math.max(answer,sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] ){
                    if(check(i,j)){
                        visited[i][j] = true;
                        dfs(depth + 1,sum+map[i][j]);
                        visited[i][j] = false;
                    }

                }
            }
        }
    }

    /**
     *상하좌우 제외
     */
    private static boolean check(int x, int y) {
        for (int i=0;i<4;i++){
            int next_x=x+dx[i];
            int next_y=y+dy[i];
            if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M){
                if(visited[next_x][next_y])return false;
            }
        }
        return true;
    }
}
