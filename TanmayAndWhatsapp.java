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



public class TanmayAndWhatsapp {
	
	
public static int N;
public static int[] arr;
public static int Csize;
public TanmayAndWhatsapp(int N) {
	this.N=N;
	arr=new int[N+1];
	Csize=0;
}
	
	public static void downheapify(int arr[], int i) 
	{ 
		if(N==0) {
			return;
		}
	    int smallest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l] < arr[smallest]) 
	        smallest = l; 
	  
	    if (r <= N && arr[r] < arr[smallest]) 
	        smallest = r; 
	  
	    if (smallest != i) { 
	        int temp=arr[i];
	        arr[i]=arr[smallest];
	        arr[smallest]=temp;
	        downheapify(arr, smallest); 
	    } 
	} 
	
	
	public static void upheapify(int arr[],int i) {
		if(i==0) {
			return;
		}
		int smallest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l] < arr[smallest]) 
	        smallest = l; 
	  
	    if (r <= N && arr[r] < arr[smallest]) 
	        smallest = r;
	    int temp=arr[i];
	    arr[i]=arr[smallest];
	    arr[smallest]=temp;
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
		// TODO Auto-generated method stub
		N=0;
		Reader.init(System.in);
    	int n = Reader.nextInt();
    	int k = Reader.nextInt();
    	int arr[]=new int[100005];
//    	int[] arr;
    	for(int i=0;i<n;i++) {
//    		arr=new int[N+1];
    		int h=Reader.nextInt();
    		insert(arr,h);
    	}
//    	Arrays.sort(arr);
//    	int count=0;
    	int left=0;
//    	while(arr[1]<k) {
//    		
//    		int n1=popout(arr);
////    		System.out.print(n1+" ");
//    		int n2=popout(arr);
////    		System.out.println(n2);
//    		insert(arr,n1+n2);
////    		count++;
//    		left++;
//    		
//    	}
    	while(N!=0) {
    		int x1=popout(arr);
    		if(N==0 || x1>=k) {
    			if(x1<k) {
    				left=-1;
    			}
    			break;
    		}
    		int x2=popout(arr);
    		left++;
    		int z=x1+x2;
    		insert(arr,z);
    	}
    	System.out.println(left);
	}

}
