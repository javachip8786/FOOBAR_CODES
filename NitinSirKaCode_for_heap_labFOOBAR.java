
//public class NitinSirKaCode_for_heap_labFOOBAR {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}


//import java.io.IOException;
//import java.util.*;
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

class NitinSirKaCode_for_heap_labFOOBAR{
    public static int N ;
//    public static void swap(int ar[], int a ,int b)
//    {
//        int temp = ar[a];
//        ar[a] = ar[b];
//        ar[b] = temp;
//    }

//    public static int heapify(int ar[] , int i )
//    {
//        int largest = i;
//        int left = i *2;
//        int right = i*2 +1 ;
//        if( left <=N  && ar[left] < ar[largest])
//            largest = left;
//        if( right <=N  && ar[right] < ar[largest])
//            largest = right;
//        return largest;
//    }
//    public static void downheapify(int ar[],int i )
//    {
//    	if(N==0)
//    		return ;
//        int largest = heapify(ar, i);
//        if(largest != i)
//        {
//                swap(ar, largest, i );
//                downheapify(ar, largest);
//        }  
//    }
//
//    public static void upheapify(int ar[], int i)
//    {
//        if(i == 0)
//        {
//            return ;
//        }
//        int largest = heapify(ar, i);
//        swap(ar, largest, i);
//        upheapify(ar, i/2);
//    }
    
    
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

//    public static int top(int ar[])
//    {
//        if( N >= 1)
//            return ar[1];
//        return -1;
//    }

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
    
    
//    public static void main(String agrs[])
//    {
//        N  = 0;
//        int ar[] = new int[100];
//        insert(ar,3);
//        System.out.println(top(ar));            // 3
//        insert(ar,5);
//        System.out.println(top(ar));        // 3
//        insert(ar,1);
//        System.out.println(top(ar));        //1
//        popout(ar);
//        System.out.println(top(ar));        //3
//        
//    }
    public static void main(String[] args) throws IOException {
    	N=0;
		Reader.init(System.in);
		int n= Reader.nextInt();
		int k= Reader.nextInt();
		int[] arr=new int[200005];
//		int[] ar=new int[n];
		for(int i=0;i<n;i++) {
			int h= Reader.nextInt();
			insert(arr,h);
		}
		int sum=0;
		int left=0;
		while(left<arr.length) {
			if(arr[left]<k) {
				int n1=popout(arr);
				int n2=popout(arr);
				insert(arr,n1+n2);
				sum+=1;
				left+=1;
			}
		}
		System.out.println(sum);
//		for(int i=0;i<ar.length;i++) {
//			System.out.println(arr[i]);
//		}
//		heapsort(arr,n);
		
//		for(int i=0;i<6;i++) {
//			System.out.println(arr[i]);
//		int count=0;
//		boolean flag  = true;
//		while(N>1) {
//			int n1=popout(arr);
//			int n2=popout(arr);
//			if(n1<k || n2<k) {
//				int sum=n1+n2;
//				insert(arr,sum);
//				count++;
//			}
////			else {
////				break;
////			}
//		}
//
//		if(N==1) {
//			int a = popout(arr);
//			if(a < k) {
//				System.out.println(-1);
//			}
//			else {
//				System.out.println(count);
//			}
//				
//		}
//		else {
//		System.out.println(count);
//		}
////		}

	}

}