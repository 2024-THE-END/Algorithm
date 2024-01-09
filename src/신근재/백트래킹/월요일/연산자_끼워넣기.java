package 신근재.백트래킹.월요일;

import java.util.*;
import java.io.*;

public class 연산자_끼워넣기 {
    static int[] ary;
    static int n;
    static int max = -1;
    static int min = 99999;
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

        if(signs[0] > 0){
            signs[0]--;
            saveSign[curDepth] = 1;
            dfs(curDepth+1);
            signs[0]++;
        }
        if(signs[1] > 0){
            signs[1]--;
            saveSign[curDepth] = 2;
            dfs(curDepth+1);
            signs[1]++;
        }
        if(signs[2] > 0){
            signs[2]--;
            saveSign[curDepth] = 3;
            dfs(curDepth+1);
            signs[2]++;
        }
        if(signs[3] > 0){
            signs[3]--;
            saveSign[curDepth] = 4;
            dfs(curDepth+1);
            signs[3]++;
        }
    }
}