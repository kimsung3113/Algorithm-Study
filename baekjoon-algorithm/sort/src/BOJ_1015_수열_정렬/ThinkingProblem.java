package src.BOJ_1015_수열_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThinkingProblem {

    static StringBuilder sb = new StringBuilder();
    static CustomReader scan = new CustomReader();

    static void input(){

        N = scan.nextInt();
        a = new int[N];
        b = new int[N];
        used = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
            b[i] = a[i];
        }
    }

    static int N;
    static int[] a, b, used;

    static void output(){
        Arrays.sort(b);

        for(int i = 0; i < N; i ++){
            findP(a[i]);
        }

        System.out.println(sb.toString());
    }

    static void findP(int aElement){

        for(int i = 0; i < N; i ++){

            if(aElement == b[i] && used[i] == 0){
                sb.append(i).append(' ');
                used[i] = 1;
                break;
            }
        }
    }

    public static void main(String[] args){
        input();
        output();
    }

    static class CustomReader{

        BufferedReader br;
        StringTokenizer st;

        public CustomReader(){
            br = new BufferedReader(new InputStreamReader((System.in)));
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
