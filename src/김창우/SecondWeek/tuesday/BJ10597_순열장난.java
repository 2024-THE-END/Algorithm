package 김창우.SecondWeek.tuesday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ10597_순열장난 {
    static int len;
    static boolean[] visited=new boolean[51];
    static ArrayList<Integer> answer = new ArrayList<>();
    static String kriii;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        kriii=br.readLine();
        if(kriii.length()<10){
            len=kriii.length();
        }else{
            len=9+(kriii.length()-9)/2;
        }
        dfs(0);
    }

    private static void dfs(int idx) {
        if(idx==len){
            for (int i=0;i<answer.size();i++){
                System.out.print(answer.get(i)+" ");
            }
            System.exit(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int temp=0;
        for(int i=idx;i<=idx+1;i++){
            sb.append(kriii.charAt(i));
            temp=Integer.parseInt(sb.toString());

            if(temp>len)continue;
            if(visited[temp])continue;;

            answer.add(temp);
            visited[temp]=true;
            dfs(i+1);
            visited[temp]=false;
            answer.remove(answer.size()-1);
        }

    }
}
