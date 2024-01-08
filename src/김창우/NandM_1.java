package 김창우;

import java.util.Scanner;
public class NandM_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=i+1;
        }
        int[] output=new int[N];
        boolean[] visited=new boolean[N];

        prem(arr,output,visited,0,N,M);
    }

    private static void prem(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r){
            print(output,r);
            return;
        }
        for (int i=0;i<n;i++){
            if (visited[i]!=true){
                visited[i]=true;
                output[depth]=arr[i];
                prem(arr, output, visited, depth+1, n, r);
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

