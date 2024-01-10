package 김창우.FirstWeek.tuesday;

import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            int K=sc.nextInt();
            if(K==0)break;
            int number[]=new int[K];
            for (int i=0;i<K;i++){
                number[i]=sc.nextInt();
            }
            boolean[] visited=new boolean[K];
            combi(number,visited,0,6);
            System.out.println();
        }
    }
    private static void combi(int[] arr, boolean[] visited, int start, int r) {
        if(r==0){
            print(arr,visited);
            return;
        }else{
            for (int i=start;i<arr.length;i++){
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
