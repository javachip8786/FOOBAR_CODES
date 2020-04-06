
public class LinkedListFOOBARdsa {
	public class Node{
		int data;
		Node next;
		Node prev;
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void AddLast(int data) {
		if(size==0) {
			Node s=new Node();
			s.data=data;
			s.next=null;
			head=tail=s;
			
			size++;
		}
		else {
			Node s=new Node();
			s.data=data;
			s.next=null;
			s.prev=tail;
			tail.next=s;
			tail=s;
			size++;
		}
		}
	
	

	public static void main(String[] args) {
		LinkedListFOOBARdsa s=new LinkedListFOOBARdsa();
		s.AddLast(12);
		s.AddLast(13);
		

	}

}
