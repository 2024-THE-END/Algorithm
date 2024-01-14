package 김창우.FirstWeek.friday;

import java.util.Scanner;

public class BJ2961 {
    static int N;
    static int[] sour;
    static int[] bit;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        sour=new int[N];
        bit=new int[N];
        for(int i=0;i<N;i++){
            sour[i]=sc.nextInt();
            bit[i]=sc.nextInt();
        }
        System.out.println(dfs(0,1,0));

    }

    private static int dfs(int count,int sour_mul,int bit_plus) {
        if(count==N){
            if(sour_mul==1&&bit_plus==0)return Integer.MAX_VALUE;
            return Math.abs(sour_mul-bit_plus);
        }
        int a=dfs(count+1,sour_mul*sour[count],bit_plus+bit[count]);
        int b=dfs(count+1,sour_mul,bit_plus);
        return Math.min(a,b);
    }
}
