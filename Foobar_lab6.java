import java.util.Scanner;
public class Foobar_lab6 {
	public class Node{
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	public void stack(int data) {
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
			s=tail;
			size++;
		}
	}
	public int popout() {
		if(size>1) {
		Node temp=head;
		Node temp2=head.next;
		while(temp2!=tail) {
			temp=temp2;
			temp2=temp2.next;
		}
		int q=temp2.data;
		System.out.println(q);
		temp.next=null;
		temp=tail;
		size--;
		return q;
		}
	}
	public void dis() {
		if(size>0) {
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		Foobar_lab6 sta= new Foobar_lab6();
		String s=scn.nextLine();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*') {
				char g=s.charAt(i);
				if(g=='+'){
					int d=sta.popout();
					int e=sta.popout();
					int f=d+e;
					sta.stack(f);
				}
				else if(g=='-') {
					int d=sta.popout();
					int e=sta.popout();
					int f=d-e;
					sta.stack(f);
				}
				else if(g=='*') {
					int d=sta.popout();
					int e=sta.popout();
					int f=d*e;
					sta.stack(f);
				}
			}
			
			else if (s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9') {
				char d=s.charAt(i);
				int n=Integer.parseInt(String.valueOf(d));
				sta.stack(n);
			}
			
		}
		sta.dis();
	}
	
		

	}


