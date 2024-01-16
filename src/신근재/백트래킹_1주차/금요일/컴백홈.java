package 신근재.백트래킹_1주차.금요일;

import java.util.Scanner;

public class 컴백홈 {
    static int r;
    static int c;
    static int distance;
    static int ans = 0;
    static char[][] maps;
    public static void main(String args[]) throws Exception {
        Scanner sc =new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        distance = sc.nextInt();
        maps = new char[r][c];

        for(int i=0;i<r;i++){
            String temp = sc.next();

            for(int j=0;j<c;j++){
                maps[i][j] = temp.charAt(j);
            }
        }
        //위나 오른쪽으로 무조건
        searchMap(0, r-1, 0);
        System.out.println(ans);
    }

    private static void searchMap(int countMove, int curX, int curY) {
        System.out.println(curX + " " + curY);
        //맵에서 벗어난 경우는 아니다.
        if(countMove > distance || curX < 0 || curX >= r ||curY < 0 || curY >= c)
            return;

        //도착한 경우
        if(curX == 0 && curY == 3 && countMove == distance) {
            ans++;
            return;
        }

        //T등장 안하면 위로 이동
        if(curX-1 >= 0 && !(maps[curX-1][curY] == 'T'))
            searchMap(countMove+1, curX-1, curY);
        //T등장 안하면 우로 이동
        if(curY+1 < c && !(maps[curX][curY+1]== 'T'))
            searchMap(countMove+1, curX, curY+1);


        //다시 생각하니까 꼭 합리적으로 움직인다는 말이 없었ㄷ...
        //바로 갈 수 있는데 왼쪽으로 꺾어서 가거나 이런 거 생각 했어야..
    }
}
