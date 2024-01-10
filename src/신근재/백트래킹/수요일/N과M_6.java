package 신근재.백트래킹.수요일;

import java.util.*;
import java.io.*;

public class N과M_6 {
    //🕐 : 15시~15시 40분
    static int n;
    static int m;
    static int[] ary;
    static boolean[] visited;
    static int[] saveAry;
    static StringBuilder stb = new StringBuilder();
    public static void main(String args[]) throws Exception {
        //고른 수열은 오름차순
        //수열은 사전 순으로 증가하는 순서로 출력..(=> 정렬)
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ary = new int[n];
        visited = new boolean[n];
        saveAry = new int[n+1];

        for(int i=0;i<n;i++)
            ary[i]=sc.nextInt();

        Arrays.sort(ary);
        backTracking(1);
        System.out.println(stb);
    }

    private static void backTracking(int curDepth) {
        if(curDepth == m+1){
            for(int i = 1; i <= m; i++){
                stb.append(saveAry[i] + " ");
            }
            stb.append("\n");
            return;
        }

        for(int i= 0 ;i<n;i++){
            if(!visited[i] && saveAry[curDepth-1] < ary[i]){
                visited[i]=true;
                saveAry[curDepth] = ary[i];
                backTracking(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
