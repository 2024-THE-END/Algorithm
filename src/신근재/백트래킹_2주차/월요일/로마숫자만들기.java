package 신근재.백트래킹_2주차.월요일;

import java.util.*;

public class 로마숫자만들기 {
    static int[] lomaNum = {1,5,10,50};
    static int n;
    static Set<Integer> set = new HashSet<>();
    public static void main(String args[]) throws Exception {
    /*
         I, V, X, L을 사용한다. 각 문자는 1, 5, 10, 50
         문자열이 나타내는 값은, 각 문자가 의미하는 수를 모두 합한 값이다.

         ★ 배열로 과정을 저장하는 건 상당한 시간소요 => 왠만하면 그냥 DFS 돌면서 재귀적으로 더하자
         ★ 반복문에 첫 인자를 start로 지정하고 dfs함수 인자로 i로 넘기는 방식..이해가 잘 안된다.
    */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lomaNumMake(0,0, 0);
        System.out.println(set.size());
    }

    private static void lomaNumMake(int curDepth, int start, int sum) {
        if(curDepth == n){
            if(sum != 0) set.add(sum);
            return;
        }

        for(int i = start ; i < 4; i++){
            lomaNumMake(curDepth+1, i, sum + lomaNum[i]);
        }
    }
}
