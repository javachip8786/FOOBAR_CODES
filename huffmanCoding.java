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



class huffmanCoding { 
	public static class Node{
		public int data;
		public String str;
		public Node left;
		public Node right;
		public Node() {
			
		}
		public Node(int val,String a) {
				data=val;
				str=a;
		}
	}
	public static String[] array=new String[26];
	
	public static int N;
	

	public static void downheapify(Node arr[], int i) 
	{ 
		if(N==0) {
			return;
		}
	    int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l].data < arr[largest].data) 
	        largest = l; 
	  
	    if (r <= N && arr[r].data < arr[largest].data) 
	        largest = r; 
	  
	    if (largest != i) { 
	        Node temp=arr[i];
	        arr[i]=arr[largest];
	        arr[largest]=temp;
	        downheapify(arr, largest); 
	    } 
	} 
	
	
	public static void upheapify(Node arr[],int i) {
		if(i==0) {
			return;
		}
		int largest = i; // Initialize largest as root 
	    int l = 2 * i ; // left = 2*i + 1 
	    int r = 2 * i +1; // right = 2*i + 2 
	  
	    if (l <= N && arr[l].data < arr[largest].data) 
	        largest = l; 
	  
	    if (r <= N && arr[r].data < arr[largest].data) 
	        largest = r;
	    Node temp=arr[i];
	    arr[i]=arr[largest];
	    arr[largest]=temp;
	    upheapify(arr,i/2);
	    
	}
	
	public static void insert(Node ar[],Node nn )
    {
        N++;
        ar[N] = nn;
        upheapify(ar,N);
    }
	
	
	 public static Node  popout(Node ar[])
	    {	Node n = ar[1];
	        // swap with leaf
	        ar[1] = ar[N];
	        // disconnect the last node 
	        N--;
	        // downheapify on root
	        downheapify(ar, 1);
	        return n;
	    }
	
	public static void dis(Node root,String s) {
		
		if(root.left==null && root.right==null) {
//			System.out.println(root.str+" --> "+s);
			array[root.str.charAt(0)-'a']=s;
			return;
		}
//		System.out.println(root.str);
		dis(root.left,s+"0");
		dis(root.right,s+"1");
		
		
	}
	

    public static void main(String[] args)  throws IOException
    { N=0;
    Reader.init(System.in);
    String input=Reader.next();
    Node arr[]=new Node[100005];
    int SIZE=26;
    
    
 // size of the string 'str' 
 		int n = input.length(); 

 		// 'freq[]' implemented as hash table 
 		int[] freq = new int[SIZE]; 

 		// accumulate freqeuncy of each character 
 		// in 'str' 
 		for (int i = 0; i < n; i++) 
 			freq[input.charAt(i) - 'a']++; 

 		// traverse 'str' from left to right 
 		for (int i = 0; i < n; i++) { 

 			// if frequency of character str.charAt(i) 
 			// is not equal to 0 
 			if (freq[input.charAt(i) - 'a'] != 0) { 

 				// print the character along with its 
 				// frequency 
 				String s=String.valueOf(input.charAt(i)); 
 				int h=freq[input.charAt(i) - 'a']; 
// 				System.out.println(h);
 		    	Node nn = new Node(h,s);
 		    	insert(arr,nn);
 				// update frequency of str.charAt(i) to 
 				// 0 so that the same character is not 
 				// printed again 
 				freq[input.charAt(i) - 'a'] = 0; 
 			
 			}
 		}
    
//    int n=Reader.nextInt();
   
//    Node root=new Node();
//    for(int i=0;i<n;i++) {
//    	String s=Reader.next();
//    	int h=Reader.nextInt();
//    	Node nn = new Node(h,s);
//    	insert(arr,nn);
//    }
    
    while(N>1) {
    	Node n1=popout(arr);//4 a
    	
    	Node n2=popout(arr);//6 b
//    	System.out.println(n1.data+"  "+n2.data);
    	Node s=new Node(n1.data+n2.data,n1.str+n2.str);//10 ab
    	
//    	Node root=addnode(null,n1.data+n2.data,n1.str+n2.str);
    	s.left=n1;
    	s.right=n2;
//    	System.out.println(s.str);
    	insert(arr,s);
    }
    
    Node t=popout(arr);
//    System.out.println(t.data);
    dis(t,"");
      for(int i=0;i<array.length;i++) {
    	  System.out.println(array[i]);
      }
    } 

}