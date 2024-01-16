package 신근재.백트래킹_1주차.금요일;

import java.util.*;

public class 에너지모으기 {
    static int n;
    static int m;
    static int[] weight;
    static int[] marbles;
    static boolean[] visited;
    static int maxNum = -1;
    public static void main(String args[]) throws Exception {
        /*
            목표 :  에너지 양의 최댓값
            [1] 구슬 하나 고르고 애 제거
            [2] 제거-1 * 제거+1
            [3] 최대가 되는..

        */
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        weight = new int[n];
        marbles = new int[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++)
            weight[i] = sc.nextInt();

        marbleSelect(0);
        System.out.println(maxNum);
    }

    private static void marbleSelect(int curDepth) {
        if(curDepth == n){
            //구슬 로직 시작
            getMax();
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i]=true;
                marbles[curDepth] = weight[i];
                marbleSelect(curDepth+1);
                visited[i]=false;
            }
        }

    }

    private static void getMax() {
        List<Integer> list = new ArrayList<>();
        for(int n : marbles)
            list.add(n);

        int value = 0;
        for(int i = 0; i < n-2; i++){
            value += list.get(0)*list.get(2);
            list.remove(1);
        }
        //System.out.println("합 : " + value);
        maxNum = Math.max(maxNum, value);
    }
}