package 김창우.SecondWeek.monday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ16943_숫자재배치 {
    static int N,M;
    static int[] num;
    static boolean[] visited;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        answer = new ArrayList<>();

        String temp=Integer.toString(N);
        int len=temp.length();
        num=new int[len];
        visited=new boolean[len];
        int[] output=new int[len];
        for (int i=0;i<temp.length();i++){
            num[i]=temp.charAt(i)-'0';
        }
        prem(output,0,len,len);
        if(answer.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(answer.get(answer.size()-1));
        }
    }
    private static void prem(int[] output, int depth,int n,int r) {
        if(depth==r){
            if(output[0]!=0) {
                int current=change(output);
                if(current<M){
                    answer.add(change(output));
                }
            }
            return;
        }
        for (int i=0;i<n;i++){
            if (!visited[i]){
                visited[i]=true;
                output[depth]=num[i];
                prem(output,depth+1,n,r);
                visited[i]=false;
            }
        }
    }

    private static int change(int[] temp){
        int a=0;
        for(int temps:temp){
            a*=10;
            a+=temps;
        }
        return a;
    }
}
