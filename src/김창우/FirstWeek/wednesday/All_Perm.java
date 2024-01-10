package 김창우.FirstWeek.wednesday;

import java.util.Scanner;

public class All_Perm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }
        int[] output=new int[N];
        boolean[] visited=new boolean[N];

        prem(arr,output,visited,0,N);
    }

    private static void prem(int[] arr, int[] output, boolean[] visited, int depth, int n) {
        if(depth==n){
            print(output,n);
            return;
        }
        for (int i=0;i<n;i++){
            if (visited[i]!=true){
                visited[i]=true;
                output[depth]=arr[i];
                prem(arr, output, visited, depth+1, n);
                visited[i]=false;
            }
        }
    }

    private static void print(int[] arr, int r) {
        for (int i=0;i<r;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
