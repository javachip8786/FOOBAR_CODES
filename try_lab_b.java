import java.util.Scanner;

public class try_lab_b {
	public class Node{
		long data;
		Node next;
	}
	private Node head;
	private Node tail;
	public int size;

	
	
	public void addLast(long data) {
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
	public void handleAddWhenSizeZero(long data) {
		Node n=new Node();
		n.data=data;
		n.next=null;
		head=tail=n;
		size++;
	}
	
	
	public long pop() {
//		System.out.print("hiii");
		if(size<1) {
			return -1;
		}
		else if(size==1) {
			long g=head.data;
			head=null;
			tail=head;
			size--;
			//System.out.print(g);
			return g;
			
		}
		else {
		Node temp1=head;
//		Node temp2=head.next;
		while(temp1.next!=tail) {
			
			temp1=temp1.next;
		}
		long g=tail.data;
		temp1.next=null;
		tail=temp1;
		size--;
//		System.out.print(g);
		return g;
		}
		
	}
	public void display() {
		Node temp= head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
			
		}
	}
	
	
	public static void main(String[] args) {
		try_lab_b d=new try_lab_b();
		Scanner scn=new Scanner(System.in);
		String str=scn.nextLine();
	//	String str="2 3 3 + +";
		
		long num=0;
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch==' ') {
				if(num!=0) {
				num=num/10;
//				System.out.print(num+"==");
				d.addLast(num);
				num=0;
				}
				continue;
			}
			else if(ch-'0'>=0 && ch-'0'<=9) {
				long n=ch-'0';
				
				num=(num+n)*10;
				
				
			}
			else {
				
				if(ch=='+') {
					long a=d.pop();
//					System.out.println(a);
					long b=d.pop();
//					System.out.println(b);
					long z=a+b;
					//System.out.println(z);
					d.addLast(z);
					
				}
				else if(ch=='-') {
					long a=d.pop();
					long b=d.pop();
					long z=a-b;
				//	System.out.print(z);
					
					
					d.addLast(z);
					
				}
				else {
					long a=d.pop();
					long b=d.pop();
					long z=a*b;
					//System.out.print(z);
					d.addLast(z);
					
				}
			}
			
		}
		d.display();
		
		
			}
			
			
			
		
		
	}
