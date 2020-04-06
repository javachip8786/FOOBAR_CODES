
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
public class Lab_HEAP_ {
	
	public static void whatsapp(int[] arr,int n,int k) {
		int sum=0;
		int temp=0;
		int temp2=0;
		for(int i=0;i<n;i++) {
			temp2+=1;
//		System.out.println(sum);
			
			if(temp>=k) {
				
				temp=0;
				sum+=temp2;
				temp2=0;
			}
			
			
			else {
				
				temp+=arr[i];
				
			}
//			System.out.println("temp2 is "+temp2);
//			System.out.println("temp is "+temp);
//			System.out.println("sum is "+sum);
			
		}
		System.out.print(sum);
		
		
	}
	
	
	public static int[] mergesort(int[] arr) {
		if(arr.length<=1) {
			return arr;
		}
		int mid=arr.length/2;
		int[] left=new int[mid];
		int[] right;
		if(arr.length%2==0) {
			right=new int[mid];
		}
		else {
			right=new int[mid+1];
		}
		for(int i=0;i<mid;i++) {
			left[i]=arr[i];
		}
		for(int j=0;j<right.length;j++) {
			right[j]=arr[mid+j];
		}
		
		
		int[] result=new int[arr.length];
		left=mergesort(left);
		right=mergesort(right);
		
		result=merge(left,right);
		return result;
		}
	
	
	public static int[] merge(int[] left,int[] right) {
		int[] result=new int[left.length+right.length];
		int leftpointer,rightpointer,resultpointer;
		leftpointer=rightpointer=resultpointer=0;
		while(leftpointer<left.length || rightpointer<right.length) {
			if(leftpointer<left.length && rightpointer<right.length) {
				if(left[leftpointer]>right[rightpointer]) {
					result[resultpointer++]=right[rightpointer++];
				}
				else {
					result[resultpointer++]=left[leftpointer++];
				}
			}
			else if(leftpointer<left.length) {
				result[resultpointer++]=left[leftpointer++];
			}
			else if(rightpointer<right.length) {
				result[resultpointer++]=right[rightpointer++];
			}
		}
		return result;
		
	}
	
//	public static void maxheap(int[] arr,int n,int i) {
//		int largest=i;
//		int l=i*2;
//		int r=2*i+1;
//		while(l<=n && arr[l]>arr[largest]) {
//			largest=l;
//		}
//		while(r<=n && arr[r]>arr[largest]) {
//			largest=r;
//		}
//		if(largest!=i) {
//			int temp=arr[largest];
//			arr[largest]=arr[i];
//			arr[i]=temp;
//			maxheap(arr,n,largest);
//		}
//	}
//	public static void heapsort(int[] arr,int n) {
//		for(int i=n/2;i>=0;i--) {
//			maxheap(arr,n,i);
//		}
//		for(int i=n;i>=1;i--) {
//			int temp=arr[1];
//			arr[1]=arr[i];
//			arr[i]=temp;
//			maxheap(arr,n,1);
//		}
//	}
//	
	
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int n= Reader.nextInt();
		int k= Reader.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]= Reader.nextInt();
		}
//		heapsort(arr,n);
		int result[]=new int[n];
		result=mergesort(arr);
		whatsapp(arr,n,k);
//		for(int i=0;i<6;i++) {
//			System.out.println(arr[i]);
//		}

	}

}
