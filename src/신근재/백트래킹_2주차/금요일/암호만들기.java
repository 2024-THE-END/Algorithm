package 신근재.백트래킹_2주차.금요일;

import java.util.*;
import java.io.*;
/*
* 암호는 서로 다른 L개의 알파벳 소문자들로 구성
* 최소 한 개의 모음(a, e, i, o, u) + 최소 두 개의 자음
* 알파벳이 암호에서 증가하는 순서로 배열
* 암호로 사용했을 법한 문자의 종류는 C가지
* C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램
* 중복은 없다!
*
* 6개중에 4개를 고르는 상황..
* */
public class 암호만들기 {
    static int len;
    static int cntAlphabet;
    static String[] alphabet;
    static int[] saveAry;
    static boolean[] visited;
    static List<String> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        cntAlphabet = sc.nextInt();
        alphabet = new String[cntAlphabet];
        visited = new boolean[cntAlphabet];
        saveAry = new int[cntAlphabet];

        for(int i=0; i<cntAlphabet;i++)
            alphabet[i] = sc.next();
        combiPassword(0);

        for(int i = 0 ; i < ansList.size(); i++) {
            String checkStr = ansList.get(i);
            boolean flag = true;
            //애가 문자열 순으로 되어있는가?
            for(int j=0;j<len-1;j++){
                if(checkStr.charAt(j) > checkStr.charAt(j+1)){
                    flag = false;
                }
            }

            if(flag){
                System.out.println(checkStr);
            }
        }
        System.out.println();
    }

    private static void combiPassword(int curDepth) {
        if(curDepth == len){
            String temp = "";
            for(int i=0;i<len;i++){
                temp += alphabet[saveAry[i]];
            }
            ansList.add(temp);
            return;
        }

        for(int i = 0; i < cntAlphabet; i++){
            if(!visited[i]){
                visited[i]=true;
                saveAry[curDepth] = i;
                combiPassword(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
