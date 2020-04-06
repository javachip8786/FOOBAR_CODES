//max heap
public class Heap {
	public static void heapify(int[] arr,int n,int i) {
		
		
			
			while(i!=0) {

				int parent=i/2;
			if(arr[i]>arr[parent]) {
				int temp=arr[i];
				arr[i]=arr[parent];
				arr[parent]=temp;
				i=parent;
			}
			else {
				return;
				
			}
			}
			
		
	}
	
	public static void insertNode(int[] arr, int n,int key) {
		n=n+1;
		arr[n-1]=key;
		heapify(arr,n,n-1);
	}

	public static void main(String[] args) {
		
		int[] arr=new int[100];
		arr[0]=10;
		arr[1]=7;
		arr[2]=9;
		arr[3]=4;
		arr[4]=2;
		int n=5;
		int key=15;
		insertNode(arr,n,key);
		System.out.print(arr[0]);
	}

}
