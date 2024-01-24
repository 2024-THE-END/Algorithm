package 김창우.SecondWeek.thursday;

import java.util.Scanner;

public class BJ12101_123더하기2 {
    static int count = 0;
    static String result = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        solution( N,K,"");

        if (result.equals("")) {
            System.out.println(-1);
        } else {
            System.out.println(result.trim());
        }
    }

    private static void solution(int n,int k,String current) {
        if (n < 0 || count > k) {
            return;
        }

        if (n == 0) {
            count++;
            if (count == k) {
                result = formatExpression(current);
            }
            return;
        }

        solution(n-1,k,current + "1+");
        solution(n-2,k ,current + "2+");
        solution( n-3,k,current + "3+");
    }

    private static String formatExpression(String expression) {//+제거하는 방법 gpt가 알려줌..ㅋㅋ
        // 뒤에 추가된 "+" 제거
        return expression.substring(0, expression.length() - 1);
    }
}
