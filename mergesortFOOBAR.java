import java.util.Scanner;
public class mergesortFOOBAR {
	public static int[] mergesort(int[] arr) {
		if(arr.length<=1) {
			return arr;
		}
		int mid=arr.length/2;
		int[] left=new int[mid];
		int[] right;
		if(arr.length%2==0) {
			right=new int[mid];
		}
		else {
			right=new int[mid+1];
		}
		for(int i=0;i<mid;i++) {
			left[i]=arr[i];
		}
		for(int j=0;j<right.length;j++) {
			right[j]=arr[mid+j];
		}
		
		
		int[] result=new int[arr.length];
		left=mergesort(left);
		right=mergesort(right);
		
		result=merge(left,right);
		return result;
		}
	
	public static int[] merge(int[] left,int[] right) {
		int[] result=new int[left.length+right.length];
		int leftpointer,rightpointer,resultpointer;
		leftpointer=rightpointer=resultpointer=0;
		while(leftpointer<left.length || rightpointer<right.length) {
			if(leftpointer<left.length && rightpointer<right.length) {
				if(left[leftpointer]>right[rightpointer]) {
					result[resultpointer++]=right[rightpointer++];
				}
				else {
					result[resultpointer++]=left[leftpointer++];
				}
			}
			else if(leftpointer<left.length) {
				result[resultpointer++]=left[leftpointer++];
			}
			else if(rightpointer<right.length) {
				result[resultpointer++]=right[rightpointer++];
			}
		}
		return result;
		
	}

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		int[] result=new int[n];
		result=mergesort(arr);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}

	}

}
