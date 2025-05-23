package BOJ_10974_모든_순열;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        selected = new int[N + 1];
        used = new int[N + 1];
    }

    static int N;
    static int[] selected, used;

    // Recurrence Function (재귀 함수)
    static void rec_func(int k) {
        if (k == N + 1) {
            for (int i = 1; i <= N; i++) sb.append(selected[i]).append(" ");
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {

                if(used[cand] == 1) continue;

                selected[k] = cand; used[cand] = 1;
                rec_func(k + 1);
                selected[k] = 0; used[cand] = 0;
            }
        }
    }


    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
