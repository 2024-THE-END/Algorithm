package 신근재.백트래킹_2주차.목요일;

import java.util.*;

import static java.lang.System.exit;

/*
* 1,2,3의 합으로 n을 나타내자
* 그리고 그 나타낸 합들을 정렬시켜서 k번째를 찾는
* 근데 이건 깊이가 안 정해졌는데 어떻게 하지..
* 1+1+1+1
* 1+1+2
* 1+2+1
* 굳이 깊이로 생각하지 않고 합으로 따져볼까
* */
public class oneTwoThree더하기_2 {
    static int n;
    static int k;
    static int[] saveAry;
    static int kCheck = 0;
    static boolean flag = false;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        saveAry= new int[n];

        combiOneTwoThree(0, 0);

        if(kCheck < k)
            System.out.println("-1");
    }

    private static void combiOneTwoThree(int curSum, int curDepth) {
        if(curSum == n){
            kCheck++;
            if(kCheck == k){
                for(int i=0;i<curDepth;i++){
                    System.out.print(saveAry[i]);
                    if(i < curDepth-1)
                        System.out.print("+");
                }
            }
            return;
        }
        else if(curSum > n) return;

        for(int i = 1; i <= 3;i++){
            saveAry[curDepth] = i;
            combiOneTwoThree(curSum+i, curDepth+1);
        }
    }
}
