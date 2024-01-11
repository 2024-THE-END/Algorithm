package 신근재.백트래킹.화요일;

import java.util.*;

public class N과M_5 {
    //시작 16:02
    //종료 16:22
    //소요 20분

    static int n;
    static int m;
    static int[] ary;
    static boolean[] visited;
    static int[] saveAry;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        saveAry = new int[n];
        ary = new int[n];

        for(int i = 0 ; i < n; i++)
            ary[i] = sc.nextInt();

        //사전 순 증가를 위한 정렬
        Arrays.sort(ary);

        findAll(0);
    }

    private static void findAll(int curDepth) {
        if(curDepth == m){
            for(int i = 0 ; i < m; i++){
                System.out.print(saveAry[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < n; i ++){
            if(!visited[i]){
                visited[i] = true;
                saveAry[curDepth] = ary[i];
                findAll(curDepth+1);
                visited[i] = false;
            }
        }
    }
}