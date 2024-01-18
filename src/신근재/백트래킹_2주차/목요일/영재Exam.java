package 신근재.백트래킹_2주차.목요일;

import java.util.*;
/*
* 5 * 5 * 5* ...5 => 총 9,765,625
* 근데 이거 뽑을 때 3번 연속된 문제의 답은 같지 않도록 한다.
* saveAry 쌓아놓고 풀면서 비교하자
* */
public class 영재Exam {
    static int[] answer = new int[10];
    static int[] saveAry = new int[10];
    static int ans = 0;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<10;i++)
            answer[i] = sc.nextInt();

        makeAnswer(0);
        System.out.println(ans);
    }

    private static void makeAnswer(int curDepth) {
        if(curDepth == 10){
            //saveAry에서 연속된 수가 나오는지 체크..
            boolean hasConsecutiveTriple = false;
            for (int i = 0; i < 8; i++) {
                if (saveAry[i] == saveAry[i + 1] && saveAry[i + 1] == saveAry[i + 2]) {
                    hasConsecutiveTriple = true;
                    break;
                }
            }

            int score = 0;
            if(!hasConsecutiveTriple){
                for(int i=0;i<10;i++){
                    if(saveAry[i] == answer[i])
                        score++;
                }

                if(score >= 5) ans++;
            }
            return;
        }

        for(int i = 1 ; i <= 5 ;i++){
            saveAry[curDepth] = i;
            makeAnswer(curDepth+1);
        }
    }
}
