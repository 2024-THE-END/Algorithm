package 김창우.SecondWeek.thursday;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ19949_영재의시험 {
    static int[] answer;
    static int[] arr;
    static int count;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        answer=new int[10];
        for (int i=0;i<10;i++){
            answer[i]=sc.nextInt();
        }
        arr=new int[10];

        combi(0);
        System.out.println(count);
    }
    private static void combi(int depth) {
        if (depth == 10) {
            if(isSameArray(arr,answer))count++;
            return;
        } else {
            for (int i = 1; i <= 5; i++) {
                if(depth>=2){
                    if(arr[depth-1]==i&&arr[depth-2]==i)continue;
                }
                arr[depth]=i;
                combi(depth + 1);
            }
        }
    }

    private static boolean isSameArray(int[] arr1, int[] arr2) {
        int suecess=0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                suecess++;
            }
        }
        return suecess>=5;
    }
}
