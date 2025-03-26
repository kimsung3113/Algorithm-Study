package src.BOJ_15970_화살표_그리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ThinkingProblems {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] a;

    static void input(){
        CustomReader scan = new CustomReader();

        N = scan.nextInt();
        a = new ArrayList[N+1];

        for(int color = 1; color <= N; color++){
            a[color] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= N; i++){
            int location, color;
            location = scan.nextInt();
            color = scan.nextInt();
            a[color].add(location);
        }
    }

    static int N;

    static void pro(){

        int sum = 0;

        for(int i = 1; i <= N; i++){
            Collections.sort(a[i]);
            for(int j = 0; j < a[i].size(); j++){

                if(j == 0){
                    sum += a[i].get(j+1) - a[i].get(j);
                    continue;
                }else if(j == a[i].size() - 1){
                    sum += a[i].get(j) - a[i].get(j-1);
                    continue;
                }

                sum += Math.min(a[i].get(j) - a[i].get(j-1), a[i].get(j+1) - a[i].get(j));
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args){
        input();
        pro();
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
