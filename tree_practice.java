
public class tree_practice {
	public class Node{
		public int val;
		public Node left;
		public Node right;
		public int bal;
		public int height;
		public Node(int val){
			this.val=val;
			int bal=0;
			int height=1;
		}
		
		}
	public static void setbal(Node root) {
		int lefth= root.left==null? 0: root.left.height;
		int righth= root.right== null? 0: root.right.height;
		root.bal = lefth-righth;
		root.height= Math.max(lefth, righth)+1;	
	}
	
	public static Node leftRot(Node root) {
		Node t1=root;
		Node t2=root.right.left;
		root=root.right;
		root.left=t1;
		t1.right=t2;
		setbal(t1);
		setbal(root);
		return root;
	}
	
	public static Node rightRot(Node root) {
		Node t1=root;
		Node t2=root.right.right;
		root=root.left;
		root.right=t1;
		t1.left=t2;
		setbal(t1);
		setbal(root);
		return root;
	}
	public static Node reorder(Node root) {
		if(root.bal==2) {
			if(root.left.bal==1)
			{
				//left left
				root=rightRot(root);
			}
			else {
				//left right
				root.left=leftRot(root.left);
				root= rightRot(root);
			}
		}
		else {
			if(root.right.bal==-1) {
				//right right
				root=leftRot(root);
			}
			else {
				//right left
				root.right= rightRot(root.right);
				root= leftRot(root);
			}
		}
		return root;
	}
	
	public static Node Addnode(Node root,int val) {
		if(root==null) {
			Node s=new Node(val);
			return s;
		}
		if(val>root.val){
			Addnode(root.right,val);
		}
		else {
			Addnode(root.left,val);
		}
		setbal(root);
		if(root.bal <-1 || root.bal>1) {
			root=reorder(root);
		}
		return root;
	}

	public static void main(String[] args) {
		Node root=null;
		root=Addnode(root,15);

	}

}
