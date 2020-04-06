//min
public class Min_heap {
	public static void min(int[] arr,int n,int i) {
		while(i!=0) {
			int parent=i/2;
			if(arr[i]<arr[parent]) {
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
	public static void minA(int[] arr,int n,int key) {
		n=n+1;
		arr[n-1]=key;
		min(arr,n,n-1);
		
	}
//delete
	public static void del(int[] arr,int n,int i) {
		int largest=i;
		int leftC=(2*i)+1;
		int rightC=(2*i)+2;
		if (leftC < n && arr[leftC] > arr[largest]) 
            largest = leftC; 
  
        // If right child is larger than largest so far 
        if (rightC < n && arr[rightC] > arr[largest]) 
            largest = rightC; 
  
        // If largest is not root 
        if (largest != i) { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
           del(arr, n, largest); 
        } 
    
	}
	public static void del1(int[] arr,int n) {
		arr[0]=arr[n-1];
		n=n-1;
		del(arr,n,0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[100];
		arr[0]=1;
		arr[1]=3;
		arr[2]=4;
		arr[3]=6;
		arr[4]=8;
		arr[5]=9;
		int n=6;
		int key=7;
		minA(arr,n,key);
		System.out.println(arr[0]);
		del1(arr,6);
		System.out.println(arr[0]);
		
		
	}

}
