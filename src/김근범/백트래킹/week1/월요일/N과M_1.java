package 김근범.백트래킹.week1.월요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N과M_1 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int depth = Integer.parseInt(input[1]);
        int num = Integer.parseInt(input[0]);
        ArrayList<Integer> origin = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        for(int i=1;i<=num;i++){
            origin.add(i);
        }
        fetchSequences(0, depth, origin, sequence, sb);
        System.out.print(sb);
    }

    private static void fetchSequences(int index, int depth, ArrayList<Integer> origin, ArrayList<Integer> sequence, StringBuilder sequences) {
        if(index == depth) {
            for(int i=0;i<sequence.size();i++){
                sequences.append(sequence.get(i)).append(" ");
            }
            sequences.append("\n");
            return;
        }
        for(int i=0; i<origin.size();i++){
            Integer n = origin.get(i);
            sequence.add(n);
            origin.remove(n);
            fetchSequences(index+1, depth, origin, sequence, sequences);
            sequence.remove(n);
            origin.add(i, n);
        }
    }
}
