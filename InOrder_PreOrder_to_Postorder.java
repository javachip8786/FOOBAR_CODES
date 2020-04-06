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

public class InOrder_PreOrder_to_Postorder {
	public static class Node{
		int data;
		Node left;
		Node right;
		
	}
	public Node root;
	public int size;
	
//	public InOrder_PreOrder_to_Postorder(int[] pre, int[] in) {
//		this.root=this.cons(pre,0,pre.length-1,in,0,in.length-1);
//		this.size=pre.length;
//	}
	
	
	public static Node cons(int[] pre,int psi,int pli,int[] in,int isi,int ili) {
		if(psi>pli || isi>ili) {
			return null;
		}
		Node s=new Node();
		s.data=pre[psi];
		int i=-1;
		for(i=isi;i<=ili;i++) {
			if(pre[psi]==in[i]) {
				break;
			}
		}
		int nle=i-isi;
		s.left=cons(pre,psi+1,psi+nle,in,isi,i-1);
		s.right=cons(pre,psi+nle+1,pli,in,i+1,ili);
		
		return s;
	}
	
	
	public static void posto(Node root) {
		if(root!=null) {
			
			posto(root.left);
			posto(root.right);
			System.out.print(root.data+" ");
	}
	}
	
//	public static boolean isBST() {
//		Node bstp= isBST(root);
//		return bstp.isBST;
//	}
	
	
	public static int isBST(Node root,int min,int max) {
		if(root==null) {
			return 1;
		}
		if(min<root.data && root.data<max) {
			int l=isBST(root.left,min,root.data);
			int r= isBST(root.right,root.data,max);
			if(l==1 && r==1) {
				return 1;
			}
		}
		return 0;
	}
	
	

	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int n = Reader.nextInt(); // To take integer input
		int[] pre= new int[n];
		int[] in= new int[n];
		for(int i=0;i<pre.length;i++) {
			pre[i]=Reader.nextInt();
		}
		for(int i=0;i<pre.length;i++) {
			in[i]=Reader.nextInt();
		}
		Node root=cons(pre,0,pre.length-1,in,0,in.length-1);
		posto(root);
		int min=Integer.MIN_VALUE;
		int max=Integer.MAX_VALUE;
		int f=isBST(root,min,max);
		System.out.println();
		if(f==1) {
			System.out.print("YES");
		}
		else {
			System.out.print("NO");
		}

	}

}
