package BOJ_1476_날짜계산;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        String [] token = scan.nextLine().split(" ");

        E = Integer.parseInt(token[0]);
        S = Integer.parseInt(token[1]);
        M = Integer.parseInt(token[2]);
    }

    static int E, S, M;
    static int ans = 1;

    static void rec_func() {

        while(true){
            int e = ans % 15 == 0 ? 15 : ans % 15;
            int s = ans % 28 == 0 ? 28 : ans % 28;
            int m = ans % 19 == 0 ? 19 : ans % 19;

            if(e == E && s == S && m == M){
                break;
            }

            ans++;
        }

    }

    public static void main(String[] args) {
        input();

        rec_func();
        System.out.println(ans);
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
