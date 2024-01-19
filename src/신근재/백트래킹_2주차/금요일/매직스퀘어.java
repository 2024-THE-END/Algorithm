package 신근재.백트래킹_2주차.금요일;

import java.util.*;
import java.io.*;
/*
* 가로 합 맞춰놓고
* 세로 합 맞추고, 대각합 맞추면..안되지 않나
*
* 블로그보고 아이디어 확인
* 모든 칸을 9개의 경우의 수로 보고
* 칸에 맞게 숫자를 하나씩 넣으면서 board를 완성한다?..
* 합들이 일치 && 최소의 차이
*  */
public class 매직스퀘어 {
    static int[][] board = new int[3][3];
    static boolean[] visited = new boolean[10];
    static int[] saveAry = new int[10];
    static int ansDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = sc.nextInt();
            }
        }

        makeMagicBoard(1);
        System.out.println(ansDiff);
    }

    private static void makeMagicBoard(int curDepth) {
        if(curDepth == 10){
            if(isMagicBoard()){
                //차이 계산
                int tempdiff = 0;

                tempdiff += Math.abs(saveAry[1] - board[0][0]);
                tempdiff += Math.abs(saveAry[2] - board[0][1]);
                tempdiff += Math.abs(saveAry[3] - board[0][2]);

                tempdiff += Math.abs(saveAry[4] - board[1][0]);
                tempdiff += Math.abs(saveAry[5] - board[1][1]);
                tempdiff += Math.abs(saveAry[6] - board[1][2]);

                tempdiff += Math.abs(saveAry[7] - board[2][0]);
                tempdiff += Math.abs(saveAry[8] - board[2][1]);
                tempdiff += Math.abs(saveAry[9] - board[2][2]);

                ansDiff = Math.min(tempdiff, ansDiff);
            }
            return;
        }

        for(int i = 1; i <= 9 ; i++){
            if(!visited[i]){
                visited[i]=true;
                saveAry[curDepth]=i;
                makeMagicBoard(curDepth+1);
                visited[i]=false;
            }
        }
    }

    private static boolean isMagicBoard() {
        int[] rowSum = new int[3];
        rowSum[0] =  saveAry[1]+saveAry[2]+saveAry[3];
        rowSum[1] =  saveAry[4]+saveAry[5]+saveAry[6];
        rowSum[2] =  saveAry[7]+saveAry[8]+saveAry[9];
        if(rowSum[0] == rowSum[1] && rowSum[1] == rowSum[2] && rowSum[2] == rowSum[1]){
            int[] colSum = new int[3];
            colSum[0] +=  saveAry[1]+saveAry[4]+saveAry[7];
            colSum[1] +=  saveAry[2]+saveAry[5]+saveAry[8];
            colSum[2] +=  saveAry[3]+saveAry[6]+saveAry[9];
            if(colSum[0] == colSum[1] && colSum[1] == colSum[2] && colSum[2] == colSum[1]){
                int[] diagonalSum = new int[2];
                diagonalSum[0] += saveAry[1]+saveAry[5]+saveAry[9];
                diagonalSum[1] += saveAry[3]+saveAry[5]+saveAry[7];

                if(diagonalSum[0] == diagonalSum[1]) {
                    if(rowSum[0] == colSum[0] && colSum[0] == diagonalSum[0] && diagonalSum[0] == rowSum[0]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
