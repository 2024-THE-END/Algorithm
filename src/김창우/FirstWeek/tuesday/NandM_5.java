package 김창우.FirstWeek.tuesday;

import java.util.Arrays;
import java.util.Scanner;

public class NandM_5 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();
        int number[]=new int[N];
        for (int i=0;i<N;i++){
            number[i]=sc.nextInt();
        }
        Arrays.sort(number);

        int[] output=new int[M];
        boolean[] visited=new boolean[N];

        prem(number,output,visited,0,M);

        System.out.println(sb.toString());
    }
    private static void prem(int[] arr, int[] output,boolean[] visited, int depth, int r) {
        if(depth==r){
            print(output,r);
            return;
        }
        for (int i=0;i< arr.length;i++){
            if (visited[i]!=true){
                visited[i]=true;
                output[depth]=arr[i];
                prem(arr, output, visited, depth+1, r);
                visited[i]=false;
            }
        }
    }

    private static void print(int[] arr, int r) {
        for (int i=0;i<r;i++) {
            sb.append(arr[i]+" ");
        }
        sb.append("\n");
    }
}
