package 김창우.SecondWeek.monday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ15683_감시 {
    static class Point{
        int x;
        int y;
        int cctvNumber;
        Point(int x,int y,int cctvNumber){
            this.x=x;
            this.y=y;
            this.cctvNumber=cctvNumber;
        }
    }
    static int N,M;
    static int min=Integer.MAX_VALUE;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        map=new int[N][M];
        ArrayList<Point> cctv=new ArrayList<>();
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                map[i][j]=sc.nextInt();
                if(map[i][j]!=0&&map[i][j]!=6)cctv.add(new Point(i,j,map[i][j]));
            }
        }
        dfs(0,map,cctv);
        System.out.println(min);
    }

    private static void dfs(int depth,int[][] copymap,ArrayList<Point> cctv) {
        if(depth==cctv.size()){
            min=Math.min(min,Count(copymap));
            return;
        }
        int[][] temp;
        int x=cctv.get(depth).x;
        int y=cctv.get(depth).y;
        switch (cctv.get(depth).cctvNumber){
            case 1:
                //좌
                temp= copyMap(copymap);
                Left(temp,x,y);
                dfs(depth+1,temp,cctv);

                //우
                temp= copyMap(copymap);
                Right(temp,x,y);
                dfs(depth+1,temp,cctv);

                //상
                temp= copyMap(copymap);
                Up(temp,x,y);
                dfs(depth+1,temp,cctv);

                //하
                temp= copyMap(copymap);
                Down(temp,x,y);
                dfs(depth+1,temp,cctv);
                break;
            case 2:
                //좌우
                temp= copyMap(copymap);
                Left(temp,x,y);
                Right(temp,x,y);
                dfs(depth+1,temp,cctv);

                //상하
                temp= copyMap(copymap);
                Up(temp,x,y);
                Down(temp,x,y);
                dfs(depth+1,temp,cctv);
                break;
            case 3:
                //좌상
                temp=copyMap(copymap);
                Left(temp,x,y);
                Up(temp,x,y);
                dfs(depth+1,temp,cctv);

                //상우
                temp=copyMap(copymap);
                Up(temp,x,y);
                Right(temp,x,y);
                dfs(depth+1,temp,cctv);

                //우하
                temp=copyMap(copymap);
                Right(temp,x,y);
                Down(temp,x,y);
                dfs(depth+1,temp,cctv);

                //우좌
                temp=copyMap(copymap);
                Down(temp,x,y);
                Left(temp,x,y);
                dfs(depth+1,temp,cctv);
                break;
            case 4:
                //좌상우
                temp=copyMap(copymap);
                Left(temp,x,y);
                Up(temp,x,y);
                Right(temp,x,y);
                dfs(depth+1,temp,cctv);

                //상우하
                temp=copyMap(copymap);
                Up(temp,x,y);
                Right(temp,x,y);
                Down(temp,x,y);
                dfs(depth+1,temp,cctv);

                //우하좌
                temp=copyMap(copymap);
                Right(temp,x,y);
                Down(temp,x,y);
                Left(temp,x,y);
                dfs(depth+1,temp,cctv);

                //하좌상
                temp=copyMap(copymap);
                Down(temp,x,y);
                Left(temp,x,y);
                Up(temp,x,y);
                dfs(depth+1,temp,cctv);
                break;
            case 5:
                //변함없음
                temp = copyMap(copymap);
                Right(temp, x, y);
                Down(temp, x, y);
                Left(temp ,x , y);
                Up(temp, x, y);
                dfs(depth+1,temp,cctv);
                break;

        }
    }

    private static int Count(int[][] map) {
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0)count ++;
            }
        }
        return count;
    }

    private static int[][] copyMap(int[][] arr){//깊은복사로해야함..
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }
    private static void Left(int[][] map, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    private static void Right(int[][] map, int x, int y) {
        for(int i=y+1; i<M; i++) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    private static void Up(int[][] map, int x, int y) {
        for(int i=x-1; i>=0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    private static void Down(int[][] map, int x, int y) {
        for(int i=x+1; i<N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }
}
