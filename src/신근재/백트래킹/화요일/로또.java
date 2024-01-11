package 신근재.백트래킹.화요일;

import java.util.*;

public class 로또 {
    //시작 : 16:43
    //종료 : 16:55
    //소요 : 12분

    static int n;
    static int num[];
    static boolean[] visited;
    static int[] saveAry;
    public static void main(String args[]) throws Exception {
        Scanner sc= new Scanner(System.in);

        while(true) {
            n=sc.nextInt();	//개수

            if(n==0)
                break;

            num = new int[n];
            visited = new boolean[n];
            saveAry = new int[7];
            saveAry[0] = -1;

            for(int i=0;i<n;i++)
                num[i]=sc.nextInt();

            findAll(1);
            System.out.println();
        }

    }

    private static void findAll(int curDepth) {
        if(curDepth == 7){
            for(int i=1;i<=6;i++){
                System.out.print(saveAry[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                //이미 넣은 것보다 더 큰 것만 넣을 수 있음
                if(saveAry[curDepth-1] < num[i]){
                    saveAry[curDepth] = num[i];
                    visited[i] = true;
                    findAll(curDepth+1);
                    visited[i] = false;
                }
            }
        }
    }
}