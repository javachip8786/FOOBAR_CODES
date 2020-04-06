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

public class NewTreeForPractice {
	public static class Node{
		public int data;
		public Node left;
		public Node right;
		public Node(int val) {
			data=val;
		}
		
	}
	public static Node AddNode(Node root,int val) {
		if(root==null) {
			Node s=new Node(val);
			return s;
		}
		if(val>root.data) {
			root.right=AddNode(root.right,val);
			
		}
		else {
			root.left=AddNode(root.left,val);
		}
		return root;
	}
	
	public static void dis(Node root) { //pre-order traversal
		if(root==null) {
			return;
			
		}
		dis(root.left);
		System.out.println(sum(root)-root.data);
		dis(root.right);
	}
	
	public static int sum(Node root) {
		if(root==null) {
			return 0;
		}
		
		int sum1=0;
		sum1+=sum(root.left);
		sum1+=root.data;
		sum1+=sum(root.right);
		return sum1;
		
	}

	public static void main(String[] args) throws IOException {

		Node root=null;
		Reader.init(System.in);
    	int t = Reader.nextInt();
    	for(int i=0;i<t;i++) {
    		int n = Reader.nextInt();
    		root=AddNode(root,n);
    	}
//		root=AddNode(root,6);
//		root=AddNode(root,1);
//		root=AddNode(root,9);
//		root=AddNode(root,8);
//		root=AddNode(root,8);
//		root=AddNode(root,6);
//		root=AddNode(root,5);
//		root=AddNode(root,5);
//		root=AddNode(root,6);
//		root=AddNode(root,6);
		dis(root);
	}

}
