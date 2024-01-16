package 신근재.백트래킹_2주차.월요일;

import java.util.*;

public class 감시 {
    static int row;
    static int col;
    static String[][]board;
    static int[] saveCamera = new int[3];
    static int minSquare = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        /*
            감시 카메라가 가장 효율적으로 돌아가는 상황, 사각지대의 최소 구하기
            1 -> 4개
            2 -> 2개
            3 -> 4개
            4 -> 4개
            5 -> 1개

            카메라를 하나 하나 처리해서 1~5를 처리할려고 했는데 그건 불가능..
            카메라가 보는 방향이 일정하지 않고 경우의 수가 많이 등장..결국 백트래킹?
            근데 문제는 갯수가 4244 정해져있는데..
            그 안에서 또 상하좌우 움직이는 걸 처리? -> 너무 복잡하게 생각하는건가

            2는 따로 처리하고 그냥 444처리나 할까..
            5는 먼저 처리해도 될 것 같다 어쩌피 경우의 수가 없으니까
        */
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        board = new String[row][col];

        for(int i = 0; i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j] = sc.next();
            }
        }

        findMinSquare(0);
        System.out.println(minSquare);
    }

    private static void findMinSquare(int curDepth) {
        if(curDepth == 3){
            //깊은 복사 => String[][] tempBoard = board;
            int cnt = 0;
            String[][] tempBoard = new String[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    tempBoard[i][j] = board[i][j];
                }
            }
            //1번 카메라 처리
            //몇 번 돌리고 알았는데 한 번에 x번 카메라를 작동하는 게 아니라 그 안에서도 다 작동법이 달라야..하..
            if(saveCamera[0] == 1){//->
                checkRight(tempBoard,"1");
            }
            else if(saveCamera[0] == 2){//아래
                checkDown(tempBoard,"1");
            }
            else if(saveCamera[0] == 3){//<-
                checkLeft(tempBoard,"1");
            }
            else if(saveCamera[0] == 4){//위
                checkUp(tempBoard,"1");
            }

            //checkBoard(tempBoard);
            //3번 카메라 처리
            if(saveCamera[1] == 1){//상 + 우
                checkUp(tempBoard,"2");
                checkRight(tempBoard,"2");
            }
            else if(saveCamera[1] == 2){//우 + 아래
                checkRight(tempBoard,"2");
                checkDown(tempBoard,"2");
            }
            else if(saveCamera[1] == 3){//아래 + 왼쪽
                checkDown(tempBoard,"2");
                checkLeft(tempBoard,"2");
            }
            else if(saveCamera[1] == 4){//왼쪽 + 상
                checkLeft(tempBoard,"2");
                checkUp(tempBoard,"2");
            }
            //4번 카메라 처리
            if(saveCamera[2] == 1){//좌상우
                checkLeft(tempBoard,"4");
                checkUp(tempBoard,"4");
                checkRight(tempBoard,"4");
            }
            else if(saveCamera[2] == 2){//상 우 아래
                checkUp(tempBoard,"4");
                checkRight(tempBoard,"4");
                checkDown(tempBoard,"4");
            }
            else if(saveCamera[2] == 3){//우 아래 좌
                checkRight(tempBoard,"4");
                checkDown(tempBoard,"4");
                checkLeft(tempBoard,"4");
            }
            else if(saveCamera[2] == 4){//아래 좌 상
                checkDown(tempBoard,"4");
                checkLeft(tempBoard,"4");
                checkUp(tempBoard,"4");
            }
            //5번 처리
            checkDown(tempBoard,"5");
            checkLeft(tempBoard,"5");
            checkUp(tempBoard,"5");
            checkRight(tempBoard,"5");

            //2번 처리 (좌우)
            String[][] tempBoard2 = new String[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    tempBoard2[i][j] = board[i][j];
                }
            }
            checkLeft(tempBoard,"2");
            checkRight(tempBoard,"2");
            for(int i = 0; i<row;i++) {
                for (int j = 0; j < col; j++) {
                    if(tempBoard[i][j].equals("0"))
                        cnt++;
                }
            }
            minSquare = Math.min(minSquare, cnt);

            //2번 처리 (상하)
            for(int i = 0; i<row;i++){
                for(int j=0;j<col;j++){
                    if(tempBoard2[i][j].equals("2")){
                        int curX = i;
                        while(curX-1 >= 0){
                            if(tempBoard2[curX-1][j].equals("6"))
                                break;
                            curX--;
                            tempBoard[curX][j] = "7";
                        }
                    }
                }
            }
            for(int i = 0; i<row;i++){
                for(int j=0;j<col;j++){
                    if(tempBoard2[i][j].equals("2")){
                        int curX = i;
                        while(curX < row-1){
                            if(tempBoard2[curX+1][j].equals("6"))
                                break;
                            curX++;
                            tempBoard2[curX][j] = "7";
                        }
                    }
                }
            }
            cnt = 0;
            for(int i = 0; i<row;i++) {
                for (int j = 0; j < col; j++) {
                    if(tempBoard[i][j].equals("0"))
                        cnt++;
                }
            }
            minSquare = Math.min(minSquare, cnt);

            return;
        }

        for(int i = 1 ; i <= 4; i++){
            saveCamera[curDepth]=i;
            findMinSquare(curDepth+1);
        }
    }

    private static void checkUp(String[][] tempBoard, String target) {
        for(int i = 0; i<row;i++){
            for(int j=0;j<col;j++){
                if(tempBoard[i][j].equals(target)){
                    int curX = i;
                    while(curX-1 >= 0){
                        if(tempBoard[curX-1][j].equals("6"))
                            break;
                        curX--;
                        tempBoard[curX][j] = "7";
                    }
                }
            }
        }
    }

    private static void checkLeft(String[][] tempBoard, String target) {
        for(int i = 0; i<row;i++){
            for(int j=0;j<col;j++){
                if(tempBoard[i][j].equals(target)){
                    int curY = j;
                    while(curY-1 >= 0){
                        if(tempBoard[i][curY-1].equals("6"))
                            break;
                        curY--;
                        tempBoard[i][curY] = "7";
                    }
                }
            }
        }
    }

    private static void checkDown(String[][] tempBoard, String target) {
        for(int i = 0; i<row;i++){
            for(int j=0;j<col;j++){
                if(tempBoard[i][j].equals(target)){
                    int curX = i;
                    while(curX < row-1){
                        if(tempBoard[curX+1][j].equals("6"))
                            break;
                        curX++;
                        tempBoard[curX][j] = "7";
                    }
                }
            }
        }
    }

    private static void checkRight(String[][] tempBoard, String target) {
        for(int i = 0; i<row;i++){
            for(int j=0;j<col;j++){
                if(tempBoard[i][j].equals(target)){
                    int curY = j;
                    while(curY < col-1){
                        if(tempBoard[i][curY+1].equals("6"))
                            break;
                        curY++;
                        tempBoard[i][curY] = "7";
                    }
                }
            }
        }
    }

    private static void checkBoard(String[][] tBoard) {
        for(int i = 0; i<row;i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tBoard[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println();
    }
}
