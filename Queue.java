
public class Queue {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void Add(int data) {
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
			tail.next=s;
			tail=s;
			size++;
		}
	}
	
	public void dis() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data);
			temp=temp.next;
		}
	}
	public void queue(int data) {
		if(size>0) {
			Node s=new Node();
			s.data=data;
			s.next=null;
			tail.next=s;
			tail=s;
			head=head.next;
		}
	}

	public static void main(String[] args) {
		Queue list=new Queue();
		list.Add(1);
		list.Add(2);
		list.Add(3);
		list.Add(4);
		list.dis();
		System.out.println("");
		list.queue(7);
		list.dis();

	}

}
