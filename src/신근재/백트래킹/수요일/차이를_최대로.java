package 신근재.백트래킹.수요일;

import java.util.Scanner;

public class 차이를_최대로 {
    //🕐 : 16:00~16:23
    static int n;
    static int max = -1;
    static int[] ary;
    static int[] saveAry;
    static boolean[] visited;
    public static void main(String args[]) throws Exception {
        //배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는
        //|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
        //결국 값을 구하는 건 나중에 하는거고 순서를 적절히 바꿔서 가능한 모든 배치를 확인

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ary = new int[n];
        saveAry = new int[n];
        for(int i=0;i<n;i++)
            ary[i]=sc.nextInt();
        visited=new boolean[n];
        findAllCase(0);
        System.out.println(max);
    }

    private static void findAllCase(int curDepth) {
        if(curDepth == n){
            int sum = 0;
            for(int i=0;i<n-1;i++) {
                sum += Math.abs(saveAry[i]-saveAry[i+1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                saveAry[curDepth]=ary[i];
                findAllCase(curDepth+1);
                visited[i]=false;
            }
        }
    }
}