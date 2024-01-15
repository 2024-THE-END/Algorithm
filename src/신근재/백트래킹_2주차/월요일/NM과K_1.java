package 신근재.백트래킹_2주차.월요일;

import java.util.*;

public class NM과K_1 {
    static int n;
    static int m;
    static int k;
    static int[][] board;
    public static void main(String args[]) throws Exception {
    /*
    * N * M 칸에 정수가 들어있고, 여기서 k개를 선택
    * 칸에 들어간 수를 모두 더한 값의 최댓값, 근데 선택한 두 칸이 인접하면 안된다.
    * */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = sc.nextInt();
            }
        }

        //board에서 k개를 고른다..
        //근데 그걸 고르는 과정에서 칸이 인접하면 안된다.
        //k개를 board에서 고르는 거 자체를 코딩으로 어떻게 해볼까
        //모든 경우를 다 해본다..근데 칸을 어떻게 백트래킹으로 고르지
        //
        //고민하다가 블로그를 봤는데도 솔직히 이해가 잘 안된다..다시 읽어봐야겠다..
        //애초에 이 문제에 백트래킹 사용이 이해가 안되서 그런 거 같기도


    }
}
