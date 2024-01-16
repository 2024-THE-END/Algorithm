package 신근재.백트래킹_1주차.화요일;

import java.util.*;

public class 부분수열의합 {
    //시작 14:03
    //종료 15:18
    //소요 1시간 15분
    static int[] ary;
    static int n;
    static int s;
    static int ans = 0;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        ary = new int[n];

        for(int i = 0 ; i < n ; i++)
            ary[i] = sc.nextInt();

        //조합 가능한 경우를 모두 찾고 합이s가 될 경우 ans++
        findAllCase(0, 0);
        if (s == 0) System.out.println(ans - 1);
        else  System.out.println(ans);
    }

    private static void findAllCase(int curDepth, int sum) {
        if(curDepth == n){
            if(sum == s) ans++;
            return;
        }

        //현 단계에 숫자를 포함할 것인가
        findAllCase(curDepth+1, sum+ary[curDepth]);
        //포함하지 않고 넘어갈 것인가
        findAllCase(curDepth+1, sum);
    }
}
