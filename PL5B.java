import java.util.Scanner;
public class PL5B {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	private Node mid;
	
	public void AddAtLast(int data) {
		if(size==0) {
		Node s=new Node();
		s.data=data;
		s.next=null;
		head=tail=s;
		mid=s;
		size++;
		}
		else {
			Node s=new Node();
			s.data=data;
			s.next=null;
			tail.next=s;
			tail=s;
			size++;
			if(size%2!=0) {
				mid=mid.next;
			}
		}
	}
		public void remove() {
			Node temp=head.next;
			head=temp;
			size--;
			if(size%2!=0) {
				mid=mid.next;
			}
		}
		public void dis() {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	public void middle() {
		if(size%2==0) {
			System.out.println(mid.data+" "+mid.next.data);
		}
		else {
			System.out.println(mid.data);
		}
	}

	public static void main(String[] args) {
		PL5B list=new PL5B();
		Scanner scn=new Scanner(System.in);
		list.AddAtLast(1);
		int n=scn.nextInt();
		for(int i=0;i<n;i++) {
			int p=scn.nextInt();
			if(p==1) {
				int c=scn.nextInt();
				list.AddAtLast(c);
			}
			else if(p==2) {
				list.remove();
			}
			else {
				list.middle();
			}
		}
	}

}
