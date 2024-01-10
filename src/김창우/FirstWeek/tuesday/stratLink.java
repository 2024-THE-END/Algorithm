package 김창우.FirstWeek.tuesday;

import java.util.Map;
import java.util.Scanner;


public class stratLink {

    public static int N;
    public static int[][] S;
    public static boolean[] visited;

    public static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        combi(0,0);
        System.out.println(Min);
    }
    private static void combi(int idx,int count) {
        if(count==N/2){
            dif();
            return;
        }
        for (int i=idx;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                combi(i+1,count+1);
                visited[i]=false;
            }
        }
    }

    private static void dif() {
        int start=0;
        int link=0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    start += S[i][j];
                    start += S[j][i];
                }
                else if (visited[i] == false && visited[j] == false) {
                    link += S[i][j];
                    link += S[j][i];
                }
            }
        }
        int val = Math.abs(start - link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        Min= Math.min(val,Min);
    }
}
