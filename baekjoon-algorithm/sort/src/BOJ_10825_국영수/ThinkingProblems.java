package src.BOJ_10825_국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThinkingProblems {

    static StringBuilder sb = new StringBuilder();
    static CustomReader scan = new CustomReader();

    static class Elements implements Comparable<Elements> {

        String name;
        int korean, english, math;

        @Override
        public int compareTo(Elements others) {

            // 국어 점수 내림차순
            // -> others가 더 적으면 -> 음수 ->  this가 먼저!!
            // -> others가 더 크면? -> 양수 -> others가 먼저!!
            if(korean != others.korean) return others.korean - korean;

            // 영어 점수 오름차순
            // -> others가 더 커서 음수가 나오면 오름차순이니 this가 먼저!!
            // -> others가 작으면 양수가 나와 others가 먼저!!
            if(english != others.english) return english - others.english;
            // 수학 점수 내림차순
            if(math != others.math) return others.math - math;
            return name.compareTo(others.name);
        }
    }

    static void input(){
        N = scan.nextInt();
        students = new Elements[N];

        for (int i = 0; i < N; i++) {
            students[i] = new Elements();
            students[i].name = scan.next();
            students[i].korean = scan.nextInt();
            students[i].english = scan.nextInt();
            students[i].math = scan.nextInt();
        }
    }

    static int N;
    static Elements[] students;

    static void output(){

        Arrays.sort(students);

        for(int i = 0; i < N; i++){
            sb.append(students[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        output();
    }

    static class CustomReader {
        BufferedReader br;
        StringTokenizer st;

        public CustomReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) { // StringTokenizer에 값이 없으면?
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
