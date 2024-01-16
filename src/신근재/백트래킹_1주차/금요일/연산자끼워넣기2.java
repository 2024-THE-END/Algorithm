package 신근재.백트래킹_1주차.금요일;

import java.util.*;

public class 연산자끼워넣기2 {
    static int[] ary;
    static int n;
    static int max = -1;
    static int min = Integer.MAX_VALUE;
    static int[] saveSign;
    static int[] signs;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        saveSign = new int[n-1];

        ary = new int[n];
        for(int i =0; i < n; i++)
            ary[i] = sc.nextInt();

        signs = new int[4];
        for(int i=0;i<4;i++)
            signs[i]=sc.nextInt();

        dfs(0);
        System.out.println(max);
        System.out.print(min);
    }
    private static void dfs(int curDepth) {
        if(curDepth == n-1){
            //지금까지 모은 부호로 계산
            int num = ary[0];
            for(int i = 0; i < n-1; i++){
                if(saveSign[i] == 1){
                    num += ary[i+1];
                }
                else if(saveSign[i] == 2){
                    num -= ary[i+1];
                }
                else if(saveSign[i] == 3){
                    num *= ary[i+1];
                }
                else if(saveSign[i] == 4){
                    num /= ary[i+1];
                }
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for(int i = 0; i< 4; i++){
            if(signs[i] > 0){
                signs[i]--;
                saveSign[curDepth] = i+1;
                dfs(curDepth+1);
                signs[i]++;
            }
        }
    }
}