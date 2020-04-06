

public class LabSecA_b_tree {
	public static class Node{
		public static int data;
		public static Node left;
		public static Node right;
		public Node(int val) {
			data=val;
		}
	}
	//insert
	public static Node AddNode(Node root,int val) {
		if(root==null) {
			return root;
		}
		if(val>root.data) {
			root.right=AddNode(root.right,val);
		}
		else {
			root.left=AddNode(root.left,val);
		}
		return root;
	}
	//count func
	public static int Count(Node root,int data) {
		int sum=0;
		while(sum<data) {
		sum+=1;
		Count(root.left,data);
		Count(root.right,data);
		}
		return sum;
	}
	//find
	public static void find(Node root,int data) {
		int h=0;
		if(h==data) {
			System.out.print(root.data);
		}
		h+=1;
		find(root.left,data);
		find(root.right,data);
	}
	
	
	public static void main(String[] args){
		Node root=null;
		AddNode(root,0);
		AddNode(root,0);
		AddNode(root,2);
		System.out.println(Count(root,1));
	}

}
