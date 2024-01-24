package 김창우.SecondWeek.wednesday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9742_순열 {
    static boolean visited[];
    static char[] chars;
    static int num,count;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String abc;

        while ((abc=br.readLine())!=null){
            StringTokenizer st=new StringTokenizer(abc);
            String str=st.nextToken();
            num=Integer.parseInt(st.nextToken());

            count=0;
            chars=new char[str.length()];
            visited=new boolean[str.length()];

            prem(str,0);
            if(count<num)System.out.println(str + " " + num + " = No permutation");

        }
    }
    private static void prem(String str,int depth) {
        if(depth==str.length()){
            count++;
            if (count==num){
                answer=new String(chars);
                System.out.println(str+" "+num+" = "+answer);
            }
            return;
        }
        for (int i=0;i<str.length();i++){
            if (!visited[i]){
                visited[i]=true;
                chars[depth]=str.charAt(i);
                prem(str, depth+1);
                visited[i]=false;
            }
        }
    }

}
