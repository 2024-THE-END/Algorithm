package 신근재.백트래킹_1주차.화요일;

import java.util.*;

public class N과M_8 {
    //시작 : 16:25
    //종료 : 16:41
    //소요 : 16분

    static int n;
    static int m;
    static int[] ary;
    static int[] saveAry;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ary = new int[n];
        saveAry = new int[m+1];

        for(int i = 0; i < n; i++)
            ary[i] = sc.nextInt();

        Arrays.sort(ary);

        findAll(1);
    }

    private static void findAll(int curDepth) {
        if(curDepth == m+1){
            for(int i = 1;i<=m;i++){
                System.out.print( saveAry[i] + " ");
            }
            System.out.println();;
            return;
        }

        for(int i = 0;i < n;i++){
            if(saveAry[curDepth-1] <= ary[i]){
                saveAry[curDepth] = ary[i];
                findAll(curDepth+1);
            }
        }
    }
}