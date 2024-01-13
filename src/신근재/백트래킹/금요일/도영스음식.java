package 신근재.백트래킹.금요일;

import java.util.Scanner;

public class 도영스음식 {
    static int n;
    static int[] sour;
    static int[] bitter;
    static int minDiff = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String args[]) throws Exception {
        /*
        * 재료 N개 / 신맛 S는 곱/ 쓴맛 B는 합
        * 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다
        * 근데 재료는 적어도 하나 이상은 꼭
        * dfs로 뽑는데 1개 이상씩 뽑아야 -> 즉 뽑을 수도 있고 안 뽑을 수도 있다.
        * */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sour = new int[n];
        bitter = new int[n];

        for(int i=0;i<n;i++){
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }

        getSour(0,1, 0);
        System.out.println(minDiff);
    }

    private static void getSour(int curDepth, int sourTaste, int cnt) {
        //아무것도 안 고른 경우에
        if(curDepth == n && cnt == 0)
            return;

        if(curDepth == n && cnt > 0){
            System.out.println(sourTaste);
            visited = new boolean[cnt];
            getBitter(0,0, cnt, sourTaste);
            return;
        }

        getSour(curDepth+1, sourTaste * sour[curDepth], cnt+1);
        getSour(curDepth+1, sourTaste, cnt);
    }

    //애는 그래도 무조건 깊이 맞춰야지..
    private static void getBitter(int curDepth, int bitterTaste, int maxLen, int sourTaste) {
        if(curDepth == maxLen){
            //System.out.println("W " +sourTaste + " "+  bitterTaste);
            minDiff = Math.min(minDiff, Math.abs(bitterTaste - sourTaste));
            return;
        }

        for(int i = 0;i < maxLen;i++){
            if(!visited[i]){
                //System.out.println(bitter[i]);
                visited[i]=true;
                getBitter(curDepth+1, bitterTaste+bitter[i], maxLen, sourTaste);
                visited[i]=false;
            }
        }
    }
}
