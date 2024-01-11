package 김창우.FirstWeek.tuesday;

import java.util.Scanner;

public class partHydSum {
    public static int S;
    public static int N;
    public static int[] number;

    public static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        S=sc.nextInt();
        number=new int[N];
        for (int i=0;i<N;i++){
            number[i]=sc.nextInt();
        }
        dfs(0,0);
        if(S==0) System.out.println(count-1);
        else System.out.println(count);
    }

    private static void dfs(int depth, int sum) {
        if(depth==N){
            if (sum==S)count++;
            return;
        }
        dfs(depth+1,sum+number[depth]);
        dfs(depth+1,sum);
    }

}
