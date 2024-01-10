package 신근재.백트래킹.수요일;

import java.util.*;

public class 모든순열 {
    //🕐 : 15시 41분 ~ 15시 59분
    static int n;
    static int[] ary;
    static int[] saveAry;
    static int maxLine = 1;
    static int curLine = 0;
    static boolean[] visited;
    static StringBuilder stb = new StringBuilder();
    public static void main(String args[]) throws Exception {
        //1부터 N까지의 수로 이루어진 순열을 사전순으로 출력
        //N!개의 줄에 걸쳐..?
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ary = new int[n];
        saveAry = new int[n];
        visited = new boolean[n];

        for(int i = 1; i <= n; i++) {
            ary[i-1] = i;
            maxLine *= i;
        }

        backTracking(0);
        System.out.println(stb);
    }

    private static void backTracking(int curDepth) {
        if(curDepth == n && curLine < maxLine){
            for(int n : saveAry)
                stb.append(n + " ");
            stb.append("\n");
            curLine++;
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i]=true;
                saveAry[curDepth]=ary[i];
                backTracking(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
