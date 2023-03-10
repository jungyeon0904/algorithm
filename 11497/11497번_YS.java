import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int tc = Integer.parseInt(br.readLine());
   
        for(int t=0; t<tc; t++) {
        	int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<n; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            
            int ret=0;
            for(int i=0; i<n-2; i++) {
            	ret =Math.max(ret, arr[i+2]-arr[i]);
            }
            
        	bw.write(ret+"\n");
        	bw.flush();
        }
        
        bw.close();
    }
}