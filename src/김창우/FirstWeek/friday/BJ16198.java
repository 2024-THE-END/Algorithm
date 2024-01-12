package 김창우.FirstWeek.friday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ16198 {
    static int N;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        List<Integer> W = new ArrayList<>();
        for(int i=0;i<N;i++){
            W.add(sc.nextInt());
        }
        dfs(W,0);
        System.out.println(max);
    }

    private static void dfs( List<Integer> w, int sum) {
        if (w.size()==2) {
            max=Math.max(sum,max);
            return;
        }
        for (int i=1;i<w.size()-1;i++){
            int temp=w.get(i);
            int rest=w.get(i-1)*w.get(i+1);
            w.remove(i);
            dfs(w,sum+rest);
            w.add(i,temp);
        }
    }
}
