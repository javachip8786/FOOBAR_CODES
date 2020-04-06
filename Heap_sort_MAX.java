
public class Heap_sort_MAX {
	public static void maxheap(int[] arr,int n,int i) {
		int largest=i;
		int l=i*2;
		int r=2*i+1;
		while(l<=n && arr[l]>arr[largest]) {
			largest=l;
		}
		while(r<=n && arr[r]>arr[largest]) {
			largest=r;
		}
		if(largest!=i) {
			int temp=arr[largest];
			arr[largest]=arr[i];
			arr[i]=temp;
			maxheap(arr,n,largest);
		}
	}
	public static void heapsort(int[] arr,int n) {
		for(int i=n/2;i>=0;i--) {
			maxheap(arr,n,i);
		}
		for(int i=n;i>=1;i--) {
			int temp=arr[1];
			arr[1]=arr[i];
			arr[i]=temp;
			maxheap(arr,n,1);
		}
	}

	public static void main(String[] args) {
		int n=100;
		int[] arr=new int[n];
		arr[0]=13;
		arr[1]=15;
		arr[2]=7;
		arr[3]=9;
		arr[4]=3;
		arr[5]=10;
		heapsort(arr,6);
		for(int i=0;i<6;i++) {
			System.out.println(arr[i]);
		}

	}

}
