package 신근재.백트래킹_2주차.화요일;

/*
   3개 숫자(0, 1, 2)만 가지고 N자리 3의 배수를 만들어
   만드는 배수는 자연수
   0으로 시작하는 수는 만들 수 없는 수

   => 3의 배수는 총 몇 개?
*/

import java.util.*;
public class 걷다보니_신천역_small {
    //16:45~
    static int n;
    static int ans = 0;
    static String[] basicAry = {"0","1","2"};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        make3Friend(0,"");
        System.out.println(ans);
    }

    private static void make3Friend(int curDepth, String str) {
        if(curDepth == n){
            System.out.println(str);
            //첫 시작이 0이면  안된다!
            int firstLoc = -1;
            for(int i = 0 ;i < str.length(); i++){
                char firstChar = str.charAt(i);
                if(firstChar != '0'){
                    firstLoc = i;
                    break;
                }
            }

            //문제 없이 첫 시작이 바른 수 + 3으로 나눴을 때 나머지가 없으면
            if(firstLoc == 0 && Integer.parseInt(str) % 3 == 0)
                ans++;
           return;
        }

        for(int i =0; i < 3; i++){
            make3Friend(curDepth+1, str + basicAry[i]);
        }
    }
}
