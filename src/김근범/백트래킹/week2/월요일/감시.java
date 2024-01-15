package 김근범.백트래킹.week2.월요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시 {

    static int N, M;
    static int[][] room;
    static ArrayList<Integer[]> list = new ArrayList<>();
    static int minArea = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] > 0 && room[i][j] <6) list.add(new Integer[] {i, j});
            }
        }
        fetchMinArea(room, 0);
        System.out.println(minArea);
    }

    private static void fetchMinArea(int[][] arr, int index) {
        if(index == list.size()) {
            int area = 0;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    if(arr[i][j]==0) area++;
                }
            }
            if(area < minArea) minArea = area;
            return;
        }

        int r = list.get(index)[0];
        int c = list.get(index)[1];
        int cctv = room[r][c];
        switch(cctv){
            case 1:
                remoteCctv1(arr, r, c, index);
                break;
            case 2:
                remoteCctv2(arr, r, c, index);
                break;
            case 3:
                remoteCctv3(arr, r, c, index);
                break;
            case 4:
                remoteCctv4(arr, r, c, index);
                break;
            case 5:
                remoteCctv5(arr, r, c, index);
                break;
        }
    }

    private static void remoteCctv1(int[][] arr, int r, int c, int index) {
        fetchMinArea(monitorUp(arr, r, c), index+1);
        fetchMinArea(monitorDown(arr, r, c), index+1);
        fetchMinArea(monitorLeft(arr, r, c), index+1);
        fetchMinArea(monitorRight(arr, r, c), index+1);
    }

    private static void remoteCctv2(int[][] arr, int r, int c, int index) {
        int[][] t = monitorUp(arr, r, c);
        int[][] t2 = monitorDown(t, r, c);
        fetchMinArea(t2, index+1);
        int[][] t3 = monitorLeft(arr, r, c);
        int[][] t4 = monitorRight(t3, r, c);
        fetchMinArea(t4, index+1);
    }

    private static void remoteCctv3(int[][] arr, int r, int c, int index) {
        int[][] up = monitorUp(arr, r, c);
        int[][] left = monitorLeft(arr, r, c);
        int[][] down = monitorDown(arr, r, c);
        int[][] right = monitorRight(arr, r, c);
        fetchMinArea(monitorLeft(up, r, c), index + 1);
        fetchMinArea(monitorDown(left, r, c), index + 1);
        fetchMinArea(monitorRight(down, r, c), index + 1);
        fetchMinArea(monitorUp(right, r, c), index + 1);
    }

    private static void remoteCctv4(int[][] arr, int r, int c, int index) {
        int[][] left = monitorLeft(arr, r, c);
        int[][] leftUp = monitorUp(left, r, c);
        int[][] right = monitorRight(leftUp, r, c);
        fetchMinArea(right, index+1);
        int[][] down = monitorDown(leftUp, r, c);
        fetchMinArea(down, index+1);
        int[][] d = monitorDown(arr, r,  c);
        int[][] right2 = monitorRight(d, r, c);
        int[][] up = monitorUp(right2, r, c);
        fetchMinArea(up, index+1);
        int[][] l = monitorLeft(right2, r, c);
        fetchMinArea(l, index+1);
    }

    private static void remoteCctv5(int[][] arr, int r, int c, int index) {
        int[][] t = monitorUp(arr, r, c);
        int[][] t2 = monitorLeft(t, r, c);
        int[][] t3 = monitorRight(t2, r, c);
        int[][] t4 = monitorDown(t3, r, c);
        fetchMinArea(t4, index+1);
    }

    private static int[][] monitorUp(int[][] arr, int r, int c) {
        int[][] next = new int[N][M];
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                next[i][j] = arr[i][j];
            }
        }
        for(int i = r-1;i>=0;i--){
            int object = next[i][c];
            if(object == 6) break;
            if(object == 0) next[i][c] = -1;
        }
        return next;
    }

    private static int[][] monitorDown(int[][] arr, int r, int c) {
        int[][] next = new int[N][M];
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                next[i][j] = arr[i][j];
            }
        }
        for(int i = r+1;i<next.length;i++){
            int object = next[i][c];
            if(object == 6) break;
            if(object == 0) next[i][c] = -1;
        }
        return next;
    }

    private static int[][] monitorLeft(int[][] arr, int r, int c) {
        int[][] next = new int[N][M];
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                next[i][j] = arr[i][j];
            }
        }
        for(int i = c-1;i>=0;i--){
            int object = next[r][i];
            if(object == 6) break;
            if(object == 0) next[r][i] = -1;
        }
        return next;
    }

    private static int[][] monitorRight(int[][] arr, int r, int c) {
        int[][] next = new int[N][M];
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                next[i][j] = arr[i][j];
            }
        }
        for(int i = c+1;i<arr[0].length;i++){
            int object = next[r][i];
            if(object == 6) break;
            if(object == 0) next[r][i] = -1;
        }
        return next;
    }
}
