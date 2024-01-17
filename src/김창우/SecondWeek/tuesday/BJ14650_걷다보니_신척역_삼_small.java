package 김창우.SecondWeek.tuesday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ14650_걷다보니_신척역_삼_small {
    static int N;
    static int[] num={0,1,2};
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        int[] output=new int[N];
        prem(output,num,0);
        System.out.println(count);
    }

    private static void prem(int[] output, int[] num, int depth) {
        if(depth==N){
            if(output[0]!=0){
                int current=change(output);
                if(current%3==0)count++;
            }
            return;
        }
        for (int i=0;i< num.length;i++){
            output[depth]=num[i];
            prem(output, num,depth+1);
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
