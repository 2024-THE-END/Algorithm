package 김창우.FirstWeek.wednesday;

import java.util.Arrays;
import java.util.Scanner;

public class NandM_7 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int[] output=new int[M];

        Arrays.sort(arr);

        prem(arr,output,0,M);

        System.out.println(sb.toString());
    }

    private static void prem(int[] arr, int[] output, int depth, int r) {
        if(depth==r){
            print(output,r);
            return;
        }
        for (int i=0;i< arr.length;i++){
            output[depth]=arr[i];
            prem(arr, output, depth+1,r);
        }
    }

    private static void print(int[] arr, int r) {
        for (int i=0;i<r;i++) {
            sb.append(arr[i]+" ");
        }
        sb.append("\n");
    }
}
