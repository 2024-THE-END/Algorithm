package 신근재.백트래킹_1주차.금요일;

import java.util.*;

public class 카드놓기 {
    static int n;
    static int m;
    static int[] cards;
    static boolean[] visited;
    static int[] saveCards;
    static Set<String> set = new HashSet<>();

    public static void main(String args[]) throws Exception {
        /*
        n(4 ≤ n ≤ 10)장
        카드엔 1이상 99이하의 정수
         이 카드 중에서 k(2 ≤ k ≤ 4)장을 선택

         상근이가 만들 수 있는 정수는 모두 몇 가지일까?
         */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        saveCards = new int[m];
        cards = new int[n];

        for(int i =0 ; i< n; i++)
            cards[i] = sc.nextInt();

        combiNum(0);
        System.out.println(set.size());
    }

    private static void combiNum(int curDepth) {
        if(curDepth == m){
            //숫자들 조합해서 String으로 만들고 set에 집어넣기
            String temp = "";
            for(int i=0;i<m;i++)
                temp += Integer.toString(saveCards[i]);
            //System.out.println(temp);
            set.add(temp);
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i]=true;
                saveCards[curDepth] = cards[i];
                combiNum(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
