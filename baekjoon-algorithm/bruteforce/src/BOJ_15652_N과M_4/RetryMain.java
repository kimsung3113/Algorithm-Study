package BOJ_15652_N과M_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RetryMain {

    static StringBuilder sb= new StringBuilder();

    static void input(){
        CustomReader scan = new CustomReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M];
    }

    static int N, M;
    static int[] selected;

    static void rec_func(int param){

        if(param == M){
            for(int i = 0; i < M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            int lastCand;

            if(param - 1 == -1) lastCand = 1;
            else lastCand = selected[param - 1];

            for(int cand = lastCand; cand <= N; cand++){
                selected[param] = cand;
                rec_func(param + 1);
                selected[param] = 0;
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
