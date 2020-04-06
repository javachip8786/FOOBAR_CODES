import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}


public class HeapSectionA_subarrays {
	
	
public static int N;
	
	public static void downheapify(int arr[], int i) 
	{ 
		if(N==0) {
			return;
		}
	    int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l] > arr[largest]) 
	        largest = l; 
	  
	    if (r <= N && arr[r] > arr[largest]) 
	        largest = r; 
	  
	    if (largest != i) { 
	        int temp=arr[i];
	        arr[i]=arr[largest];
	        arr[largest]=temp;
	        downheapify(arr, largest); 
	    } 
	} 
	
	
	public static void upheapify(int arr[],int i) {
		if(i==0) {
			return;
		}
		int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l] > arr[largest]) 
	        largest = l; 
	  
	    if (r <= N && arr[r] > arr[largest]) 
	        largest = r;
	    int temp=arr[i];
	    arr[i]=arr[largest];
	    arr[largest]=temp;
	    upheapify(arr,i/2);
	    
	}
	
	public static void insert(int ar[],int val )
    {
        N++;
        ar[N] = val;
        upheapify(ar,N);
    }
	
	
	 public static int  popout(int ar[])
	    {	int n=ar[1];
	        // swap with leaf
	        ar[1] = ar[N];
	        // disconnect the last node 
	        N--;
	        // downheapify on root
	        downheapify(ar, 1);
	        return n;
	    }

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int loop=Reader.nextInt();
		
		int[] arr=new int[100005];
		
		for(int l=0;l<loop;l++) {
			int n=Reader.nextInt();
			int k=Reader.nextInt();
			int[] ar=new int[n];
			
		for(int i=0;i<n;i++) {
				ar[i]=Reader.nextInt();
			}
		
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=i;j<n;j++) {
				
				sum+=ar[j];
				insert(arr,sum);
				
			}
//			System.out.println(i+"st is "+sum);
		}
		for(int i=0;i<k;i++) {
			int h=popout(arr);
			System.out.print(h+" ");
		}

	}
	}

}
