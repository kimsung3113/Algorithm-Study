package BOJ_10819_차이를_최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RetryMain {

    static void input(){
        CustomReader scan = new CustomReader();
        N = scan.nextInt();
        a = new int[N];
        selected = new int[N];
        used = new int[N];
        for(int i = 0; i < N; i++) a[i] = scan.nextInt();
        max = Integer.MIN_VALUE;
    }

    static int N, sum, max;
    static int[] a, selected, used;

    static void rec_func(int param){

        if(N == param){
            for(int i = 0; i < N-1; i++) sum += Math.abs(selected[i] - selected[i+1]);
            max = Math.max(max, sum);
            sum = 0;
        }else{

            for(int cand = 0; cand < N; cand++){

                if(used[cand] == 1) continue;

                selected[param] = a[cand]; used[cand] = 1;
                rec_func(param + 1);
                selected[param] = 0; used[cand] = 0;
            }
        }
    }

    public static void main(String[] args){
        input();
        rec_func(0);
        System.out.println(max);
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
