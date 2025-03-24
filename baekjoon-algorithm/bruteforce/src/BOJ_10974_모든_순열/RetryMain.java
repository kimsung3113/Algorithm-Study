package BOJ_10974_모든_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RetryMain {

    static StringBuilder sb = new StringBuilder();

    static void input(){
        CustomReader scan = new CustomReader();
        N = scan.nextInt();
        selected = new int[N];
        used = new int[N];
    }

    static int N;
    static int[] selected, used;

    static void rec_func(int param){

        if(param == N){
            for(int i = 0; i < N; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{

            for(int cand = 1; cand <= N; cand++){

                if(used[cand - 1] == 1) continue;

                selected[param] = cand; used[cand - 1] = 1;
                rec_func(param + 1);
                selected[param] = 0; used[cand - 1] = 0;

            }

        }

    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(sb.toString());
    }

    static class CustomReader{
        BufferedReader br;
        StringTokenizer st;

        public CustomReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }

}
