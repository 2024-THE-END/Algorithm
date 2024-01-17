package 신근재.백트래킹_2주차.화요일;

import java.util.*;
/*
* 하루가 지날 때마다 중량이 K만큼 감소
* 하루에 1개씩의 키트를 사용, 각각의 운동 키트는 N일 동안 한 번씩만 사용할 수 있다.
* 어떤 시점에서라도 중량이 500보다 작아지지 않도록 해야 한다.
*
* => 근손실이 일어나지 않도록 적절한 운동 순서를 정하자
* */
public class 근손실 {
    static int day;
    static int loss;
    static int[] kit;
    static int[] kitOrder;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        day = sc.nextInt();
        loss = sc.nextInt();
        kit = new int[day];
        kitOrder = new int[day];
        visited = new boolean[day];
        for(int i=0;i<day;i++)
            kit[i] = sc.nextInt();

        combiKitOrder(0);
        System.out.println(ans);
    }

    private static void combiKitOrder(int curDepth) {
        //지정된 날까지 순서를 완성했을 때
        if(curDepth == day){
            int cur3Dae = 500;
            int successFlag = 1;
            for(int i = 0;i<day;i++){
                cur3Dae -= loss;
                cur3Dae += kit[kitOrder[i]];

                if(cur3Dae < 500){
                    successFlag = 0;
                    break;
                }
            }

            if(successFlag == 1)
                ans++;
            return;
        }

        //1~n일까지의 키트의 순서를 정하자
        for(int i = 0; i < day; i++){
            if(!visited[i]){
                visited[i]=true;
                kitOrder[curDepth] = i;
                combiKitOrder(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
