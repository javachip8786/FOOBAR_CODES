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

public class ManyMaxes_foobar_heap {
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
	
	public static void insertNode(int arr[], int Key) 
	{ 	N++;
		arr[N]=Key;
	   
	    upheapify(arr,N); 
	    
	}
	
	
	public static void del(int[] arr) {
		arr[1]=arr[N];
		N--;
		downheapify(arr,1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		N=0;
		
		int n=Reader.nextInt();
		
		int[] arr=new int[100005];
		
		insertNode(arr,1);
		
		for(int i=0;i<n;i++) {
//			System.out.println("h is "+(h));
			int q=Reader.nextInt();
//			System.out.println("q is "+q);
			if(q==1) {
				int h=Reader.nextInt();
				insertNode(arr,h);
			}
			if(q==2) {
				System.out.println(arr[1]);
			}
			if(q==3) {
				del(arr);
			}
		}
	}

}
