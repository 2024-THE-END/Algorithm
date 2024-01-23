package 김근범.백트래킹.week2.화요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 순열장난 {

    static ArrayList<Integer> numList = new ArrayList<>();
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        updateFile(file);
        System.out.println(answer);
    }

    private static void updateFile(String file) {
        if(!answer.isEmpty()) return;
        if(file.isBlank()) {
            boolean isRight = true;
            for(int i=1;i<=numList.size();i++) {
                if(!numList.contains(i)) {
                    isRight = false;
                    break;
                }
            }
            if(isRight) {
                for(int i=0;i<numList.size();i++) {
                    answer = answer + numList.get(i) + " ";
                }
            }
            return;
        }

        Integer num1 = Integer.parseInt(file.substring(0, 1));
        if(!numList.contains(num1)) {
            numList.add(num1);
            updateFile(file.substring(1));
            numList.remove(num1);
        }
        if(file.length()>=2) {
            Integer num2 = Integer.parseInt(file.substring(0, 2));
            if(!numList.contains(num2)) {
                numList.add(num2);
                updateFile(file.substring(2));
                numList.remove(num2);
            }
        }
    }
}
