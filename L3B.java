import java.util.Scanner;
public class L3B {
	public static void func(int[] arr,int[] brr) {
		for(int i=0;i<brr.length;i++) {
			int sum=0;
			for(int j=0;j<arr.length;j++) {
				if(brr[i]==arr[j]) {
					sum+=1;
				}
			}
			
			if(sum>0) {
				System.out.println(sum);
			}
			else {
				System.out.println(-1);
			}
		}
	}
	public static int lastoccurence(int[] arr,int data) {
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==data) {
				if(mid+1<arr.length ) {
					if(arr[mid+1]==data) {
						left=mid+1;
					}
				}
				else {
					return mid;
				}
			}
			else if(arr[mid]>data) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return -1;
	}
	
	public static int firstoccurence(int[] arr,int data) {
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==data) {
				if(mid-1>=0) {
					if(arr[mid-1]==data) {
						right=mid-1;
					}
				}
				else {
					return mid;
				}
			}
			else if(arr[mid]>data) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
	
		Scanner scn=new Scanner(System.in);
		int a=scn.nextInt();
		int[] arr=new int[a];
		for(int i=0;i<a;i++) {
			arr[i]=scn.nextInt();
		}
//		int b=scn.nextInt();
//		int[] brr=new int[b];
//		for(int i=0;i<b;i++) {
//			brr[i]=scn.nextInt();
//		}
//		func(arr,brr);
		int j=scn.nextInt();
		System.out.print(firstoccurence(arr,j));

	}
	
	

}
