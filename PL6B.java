import Linked_List.Node;

public class PL6B {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void addLast(int data) {
		if(size==0) {
			handleAddWhenSizeZero(data);
			return;
		}
		//create
		Node n=new Node();
		//set properties
		n.data= data;
		n.next=null;
		//attach
		tail.next= n;
		//summary
		tail=n;
		size++;
	}
	public void handleAddWhenSizeZero(int data) {
		Node n=new Node();
		n.data=data;
		n.next=null;
		head=tail=n;
		size++;
	}
	
	
	
	public void func(int data) {
		int big=head.data;
		Node temp=head;
		while(size<data) {
			if(big<temp.data) {
				big=temp.data;
			}
			temp=temp.next;
		}
		while(size<data) {
			temp=head;
			if(temp.data!=big) {
				temp.data=temp.data-1;
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
