package 신근재.백트래킹_2주차.수요일;

//https://www.acmicpc.net/problem/1342
import java.util.*;
/*
* 인접해 있는 모든 문자가 같지 않은 문자열을 행운의 문자열
* 문자열 S에 나오는 문자를 재배치하면 서로 다른 행운의 문자열이 몇 개 나오는지
* 원래 문자열 S도 행운의 문자열이라면 그것도 개수에 포함
* */
public class 행운의_문자열 {
    static String[] strAry;
    static int[] saveAry;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        strAry = temp.split("");
        saveAry = new int[temp.length()];
        visited = new boolean[temp.length()];

        //재배치 시작하자
        reDispose(0);
        System.out.println(ans);
    }

    private static void reDispose(int curDepth) {
        if(curDepth == strAry.length){
            //str로 만들고
            String temp = "";
            for (int i = 0; i < curDepth; i++) {
                temp += strAry[saveAry[i]];
            }
            //인접한 거 다 따지기 시작
            boolean flag = false;
            for(int i = 0 ; i < temp.length()-1; i++){
                //현재꺼랑 다음꺼랑 비교해서 같을 때
                if(temp.charAt(i) == temp.charAt(i+1)){
                    flag = true;
                    break;
                }
            }
                ans++;
            return;
        }

        for(int i = 0; i < strAry.length; i++){
            if(!visited[i]){
                visited[i]=true;
                saveAry[curDepth] = i;
                reDispose(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
