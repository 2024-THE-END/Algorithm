package 신근재.백트래킹_1주차.수요일;

import java.util.*;

public class N과M_7 {
    //🕐 : 14시 52분 ~ 3시
    static int n;
    static int m;
    static int[] ary;
    static int[] saveAry;
    static StringBuilder stb = new StringBuilder();
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ary = new int[n];
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
            saveAry[curDepth] = ary[i];
            backTracking(curDepth+1);
        }
    }
}