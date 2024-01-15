package 신근재.백트래킹_2주차.월요일;

import java.util.*;

public class 숫자재배치 {
    static int maxNum = -1;
    static String originNum;
    static int limitNum = 0;
    static int limitLen = 0;
    static char[] charNums;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        originNum = sc.next();
        limitNum = sc.nextInt();
        limitLen = originNum.length();
        visited = new boolean[limitLen];
        charNums = new char[originNum.length()];

        for(int i = 0 ; i < originNum.length(); i++)
            charNums[i] = originNum.charAt(i);

        combiNum(0, "");
        System.out.println(maxNum);
    }

    private static void combiNum(int curDepth, String sum) {
        if(curDepth == limitLen){
            //Integer로 변경
            int curTemp;
            if(sum.charAt(0) != '0') {
                curTemp = Integer.parseInt(sum);
                if(curTemp < limitNum)
                    maxNum = Math.max(curTemp, maxNum);
            }
            return;
        }

        for(int i =0 ; i< limitLen; i++){
            if(!visited[i]){
                visited[i]=true;
                combiNum(curDepth+1, sum + charNums[i]);
                visited[i]=false;
            }
        }
    }
}
