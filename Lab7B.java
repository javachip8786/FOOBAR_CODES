


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

	class Lab7B{
	    public static class node{
	        public int val ;
	        public int bal;
	        public int height;
	        public node left;
	        public node right;
	        public node(int val)
	        {
	            this.val = val ;
	            this.bal =0;
	            this.height =1;
	        }
	 
	    }
	 
	 
	    public static int leftcount =0;
	    public static int rightcount =0;
	    public static void setbal(node root)
	    {
	        int lefth = root.left == null ? 0 : root.left.height;
	        int righth = root.right == null ? 0 : root.right.height;
	        root.bal = lefth - righth;
	        root.height = Math.max(lefth, righth) + 1;
	    }
	 
	    public static node rightrotation(node root)
	    {
	        rightcount++;
	        node t1 = root;
	        node t2 = root.left.right;
	        root = root.left;
	        root.right = t1;
	        t1.left = t2;
	        setbal(t1);
	        setbal(root);
	        return root;
	    }
	 
	    public static node leftrotation(node root)
	    {
	        leftcount ++;
	        node t1 = root;
	        node t2 = root.right.left;
	        root = root.right;
	        root.left = t1;
	        t1.right = t2;
	        setbal(t1);
	        setbal(root);
	        return root;
	    }
	 
	    public static node reorder(node root)
	    {
	        if(root.bal == 2)
	        {
	            if(root.left.bal == 1)
	            {
	                // left left
	                root = rightrotation(root);
	            }
	            else
	            {
	                    // left right
	                root.left = leftrotation(root.left);
	                root = rightrotation(root);
	 
	            }
	        }
	        else{
	            if(root.right.bal == -1)
	            {
	                // right right
	                root = leftrotation(root);
	            }
	            else
	            {
	                    //  right left
	                root.right = rightrotation(root.right);
	                root = leftrotation(root);
	            }
	        }
	        return root;
	    }
	 
	 
	    public static node addnode(node root, int val)
	    {
	        if( root == null)
	        {
	            node nn = new node(val);
	            return nn;
	        }
	        if(root.val > val)
	        {
	            root.left = addnode(root.left, val);
	        }
	        else 
	            root.right = addnode(root.right, val);
	 
	        // re- cal bal. point;
	 
	        setbal(root);
	 
	 
	        // check if bal become 2 or -2
	        if( root.bal <-1 || root.bal > 1)
	        {
	           root =  reorder(root);
	        }
	 
	        return root;
	    }
	 
	    public static int find(node root, int target)
	    {
	        if( root== null)
	        {
	            return -1;
	        }
	        if( root.val == target)
	        {
	            return 0;   
	        }
	        else if(root.val > target)
	        {
	            int left = find(root.left, target);
	            if(left == 0)
	                return root.val;
	            else 
	                return left;
	 
	        }
	        int right = find(root.right, target);
	        if(right == 0)
	            return root.val;
	        else 
	            return right;
	 
	    }
	    public static void main(String[] args) throws IOException{
	    	Reader.init(System.in);
	    	int t = Reader.nextInt(); // To take integer input
	       
	       
	        node root = null;
	        while(t-- > 0)
	        {
	        	String str = Reader.next(); // To take string input
	            if( str.charAt(0) == 'A')
	            {
	                int n = Reader.nextInt();
	                root =  addnode(root, n);
	            }
	            else if(str.charAt(0) == 'P')
	            {
	                // String h = str.substring(7);
	                // int n = Integer.parseInt(h);
	                int n = Reader.nextInt();
	                System.out.println(find(root , n));
	            }
	            else
	            {
	                // char ch = str.charAt(str.length()-1);
	                char ch = Reader.next().charAt(0);
	                if( ch == 'L')
	                    System.out.println(leftcount);
	                else 
	                    System.out.println(rightcount);
	 
	            }
	 
	        }
	 
	    }
	 
	}


