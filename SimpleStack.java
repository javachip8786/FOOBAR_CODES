import java.util.Scanner;
public class SimpleStack {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void Push(int data) {
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
	public void pop() {
		if(size<=1) {
			System.out.println(head.data);
			return;
		}
		Node temp=head;
		Node cur=head.next;
		while(cur!=tail) {
			temp=cur;
			cur=cur.next;
		}
		System.out.println(cur.data);
		tail=temp;
		size--;
		
	}
	public void peak() {
		Node temp=head;
		while(temp!=tail) {
			temp=temp.next;
		}
		System.out.println(temp.data);
	}

	public static void main(String[] args) {
		SimpleStack s=new SimpleStack();
		Scanner scn=new Scanner(System.in);
		int h=scn.nextInt();
		for(int i=0;i<h;i++) {
			int p=scn.nextInt();
			if(p==1) {
				int u=scn.nextInt();
				s.Push(u);
			}
			else if(p==2) {
				s.pop();
			}
			else if(p==3){
				s.peak();
			}
		}

	}

}
