package BOJ_15663_N과M_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RetryMain {

    static StringBuilder sb = new StringBuilder();

    static void input(){
        CustomReader scan = new CustomReader();
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N];
        selected = new int[M];
        used = new int[N];

        for(int i = 0; i < N; i++) nums[i] = scan.nextInt();
        Arrays.sort(nums);
    }

    static int N, M;
    static int[] nums, selected, used;

    static void rec_func(int param){

        if(param == M){
            for(int i = 0; i < M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            int lastCand = 0;
            for(int cand = 0; cand < N; cand++){

                if(used[cand] == 1) continue;
                if(lastCand == nums[cand]) continue;

                lastCand = nums[cand];
                selected[param] = nums[cand]; used[cand] = 1;
                rec_func(param+1);
                selected[param] = 0; used[cand] = 0;
            }
        }
    }

    public static void main(String[] args){
        input();
        rec_func(0);
        System.out.println(sb.toString());
    }

    static class CustomReader{
        BufferedReader br;
        StringTokenizer st;

        public CustomReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
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
