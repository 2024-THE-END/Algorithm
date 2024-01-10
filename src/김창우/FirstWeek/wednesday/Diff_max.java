package 김창우.FirstWeek.wednesday;

import java.util.Scanner;

public class Diff_max {
    public static int N;
    public static int[] A;

    public static int[] arr;
    public static boolean[] visited;

    public static int Max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        arr=new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(Max);
    }
    private static void dfs(int depth) {
        if(depth==N){
            int sum=0;
            for(int i=0;i<N-1;i++){
                sum+=Math.abs(arr[i]-arr[i+1]);
            }
            Max=Math.max(Max,sum);
            return;
        }
        for (int i=0;i<N;i++){
            if(!visited[i]){
                arr[depth]=A[i];
                visited[i]=true;
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }

}
