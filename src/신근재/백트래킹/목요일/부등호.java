package 신근재.백트래킹.목요일;

import java.util.Scanner;

public class 부등호 {
    static int n;
    static boolean[] visited = new boolean[10];
    static String[] signs;
    static int[] saveNum;
    static long maxNum = Integer.MIN_VALUE;
    static long minNum = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception{
        /* 풀이과정
        주어지는 부등호가 성립하는 경우를 찾고 그 중 최대,최소를 찾자
        [1] DFS로 숫자 조합을 뽑자
        [2] 숫자 조합들과 부등호를 비교하며 성립되는 지 확인한다
        [3] 성립이 되는 숫자 조합들은 그대로 str로 이어붙여서 만들고 다시 int형으로
        */

        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        saveNum = new int[n+1];
        signs = new String[n];

        for(int i=0;i<n;i++)
            signs[i] = sc.next();

        getNumComi(0);
//        System.out.println(maxNum);
//        System.out.println(minNum);
        //앞이 빈 곳은 0으로 채우고, 길이는 n+1, 10진 형태 출력
        System.out.printf("%0" + (n + 1) + "d\n", maxNum);
        System.out.printf("%0" + (n + 1) + "d\n", minNum);
    }

    private static void getNumComi(int curDepth) {
        if(curDepth == n+1){
            //부호랑 일치여부 확인
            boolean flag= true;
            for(int i = 0 ; i < n; i++){
                if(signs[i].equals("<")){
                    if(saveNum[i] >= saveNum[i+1])
                        flag = false;
                }
                else if(signs[i].equals(">")){
                    if(saveNum[i] <= saveNum[i+1])
                        flag = false;
                }
            }

            String temp = "";
            if(flag) {
                for(int  i = 0;  i< n+1; i++){
                    temp += Integer.toString(saveNum[i]);
                }

                long tempNum =Long.parseLong(temp);
                maxNum = Math.max(maxNum,tempNum);
                minNum = Math.min(minNum,tempNum);
            }
            return;
        }

        for(int i = 0 ; i< 10;i++){
            if(!visited[i]){
                visited[i]=true;
                saveNum[curDepth]=i;
                getNumComi(curDepth+1);
                visited[i]=false;
            }
        }
    }
}
