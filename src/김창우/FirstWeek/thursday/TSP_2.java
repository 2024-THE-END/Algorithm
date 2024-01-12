package 김창우.FirstWeek.thursday;

import java.util.Scanner;

public class TSP_2 {
    static int N;
    static int W[][];
    static boolean visited[];
    static int cost;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        W=new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                W[i][j]= sc.nextInt();
            }
        }
        visited=new boolean[N];
        cost=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            visited[i]=true;
            dfs(i,i,0,0);
        }
        System.out.println(cost);
    }
    private static void dfs(int start,int now,int sum,int depth) {
        if(depth==N-1){
            if(W[now][start]!=0){
                sum+=W[now][start];
                cost=Math.min(cost,sum);
            }
            return;
        }
        for (int i=0;i<N;i++){
            if(!visited[i]&&W[now][i]!=0){
                visited[i]=true;
                dfs(start,i,sum+W[now][i],depth+1);
                visited[i]=false;
            }
        }
    }
}
