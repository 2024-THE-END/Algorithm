package 신근재.백트래킹_2주차.수요일;

//https://www.acmicpc.net/problem/9742
import java.util.*;
import java.io.*;
public class 순열 {
    static String str;
    static int targetNum;
    static boolean[] visited;
    static int cnt;
    static char[] charAry;
    static String ans;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input;
        while(sc.hasNext()){
            str = sc.next();
            targetNum = sc.nextInt();

            visited = new boolean[str.length()];
            charAry = new char[str.length()];
            cnt = 0;

            combiInput(0, str.length());
            if(cnt < targetNum)
                ans = "No permutation";
            System.out.println(str + " " + targetNum + " = " + ans);
        }
    }

    private static void combiInput(int curDepth, int maxDepth) {
        if(curDepth == maxDepth){
            cnt++;
            if(cnt == targetNum)
                ans = new String(charAry);
            return;
        }

        for(int i = 0 ; i < maxDepth; i++){
            if(!visited[i]){
                visited[i]=true;
                charAry[curDepth] = str.charAt(i);
                combiInput(curDepth+1, maxDepth);
                visited[i]=false;
            }
        }
    }
}
