package 신근재.백트래킹.월요일;

import java.util.*;
import java.io.*;

public class N과M_2 {
    static int n;
    static int m;
    static int[] visited;
    static int[] ary;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m =  sc.nextInt();
        visited = new int[n+1];
        ary = new int[n+1];
        ary[0] = -1;

        //DFS 깊이우선탐색을 통해 재귀적으로 해결
        dfs(1);

        //1.다 구하고 나서 오름차순인 것만 출력
        //2.구할 때 오름차순인 것만 ary에 담기
    }

    private static void dfs(int curDepth) {
        //종료조건
        if(curDepth == m+1){
            for(int i = 1; i <= m; i++){
                System.out.print(ary[i] + " ");
            }
            System.out.println();
            return;
        }

        //돌면서 이미 방문한 거 빼고는 ㄱㄱ
        for(int i= 1; i <= n; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                //System.out.println("123");
                if(ary[curDepth-1] < i){
                    ary[curDepth] = i;
                    dfs(curDepth+1);
                }

                visited[i] = 0;
            }
        }
    }
}