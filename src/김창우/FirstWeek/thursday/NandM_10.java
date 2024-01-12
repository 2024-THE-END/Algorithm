package 김창우.FirstWeek.thursday;

import java.util.Arrays;
import java.util.Scanner;

public class NandM_10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        boolean[] visited=new boolean[N];

        combi(arr,visited,0,M);
    }

    private static void combi(int[] arr, boolean[] visited, int start, int r) {
        if(r==0){
            print(arr,visited);
            return;
        }else{
            for (int i=start;i<arr.length;i++){
                if (visited[i] || (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])) {
                    continue;
                }
                visited[i]=true;
                combi(arr, visited, i+1, r-1);
                visited[i]=false;
            }
        }
    }
    private static void print(int[] arr, boolean[] visited){
        for (int i=0;i<arr.length;i++) {
            if (visited[i]==true) System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
