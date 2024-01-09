package 신근재.백트래킹.월요일;

import java.util.*;
import java.io.*;

public class N과M_3 {
    static int n;
    static int m;
    static int[] visited;
    static int[] ary;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m =  sc.nextInt();
        visited = new int[n+1];
        ary = new int[n+1];

        //DFS 깊이우선탐색을 통해 재귀적으로 해결
        dfs(1);
        System.out.print(sb);

        //뒤 선택에 영향을 안 주는 상황임
    }

    private static void dfs(int curDepth) {
        //종료조건
        if(curDepth == m+1){
            for(int i= 1; i<=m; i++){
                sb.append(ary[i]+ " ");
            }
            sb.append('\n');
            return;
        }

        for(int i= 1; i <= n; i++){
            ary[curDepth]= i;
            dfs(curDepth+1);
        }
    }
}