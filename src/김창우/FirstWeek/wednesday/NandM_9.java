package 김창우.FirstWeek.wednesday;

import java.util.Arrays;
import java.util.Scanner;

public class NandM_9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int[] output=new int[N];
        Arrays.sort(arr);
        boolean[] visited=new boolean[N];

        prem(arr,output,visited,0,N,M);
    }

    private static void prem(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r){
            print(output,r);
            return;
        }
        for (int i=0;i<n;i++){
            /**
             * i>0일때  부터 해줘야 범위를 벗어나지 않는다(i=0,arr[i-1]는 없는 배열)
             * visited[i]-> 11,22 를 위해서 있어야 했다..
             */
            if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            output[depth] = arr[i];
            prem(arr, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }

    private static void print(int[] arr, int r) {
        for (int i=0;i<r;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
