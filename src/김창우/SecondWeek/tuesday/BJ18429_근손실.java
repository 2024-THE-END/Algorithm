package 김창우.SecondWeek.tuesday;

import java.util.Scanner;

public class BJ18429_근손실 {
    static int N,K;
    static int[] num;
    static boolean[] visited;
    static int suecees=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        num=new int[N];
        visited=new boolean[N];
        int count=0;
        for (int i=0;i<N;i++){
            num[i]=sc.nextInt();
        }
        prem(0,500);
        System.out.println(suecees);
    }
    private static void prem(int depth,int m) {
        if(depth==N){
            suecees++;
            return;
        }
        for (int i=0;i<N;i++){
            if (!visited[i]&&(m-K+num[i])>=500){
                visited[i]=true;
                prem(depth+1,m-K+num[i]);
                visited[i]=false;
            }
        }
    }
}
