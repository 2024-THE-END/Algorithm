package 김창우.FirstWeek.thursday;

import java.util.Arrays;
import java.util.Scanner;

public class NandM_12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]= sc.nextInt();
        }
        Arrays.sort(arr);

        combi(arr,new int[M],0,0,N,M);
    }

    private static void combi(int[] arr, int[] output, int start, int depth, int n, int r) {
        if(depth==r){
            for (int i=0;i<output.length;i++){
                System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i=start;i<n;i++){
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            output[depth]=arr[i];
            combi(arr,output,i,depth+1,n,r);
        }
    }
}
