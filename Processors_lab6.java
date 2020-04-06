import java.util.Scanner;

import Linked_List.Node;
public class Processors_lab6 {
	

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int p=scn.nextInt();
		int q=scn.nextInt();
		int[] arr=new int[p];
		int[] brr=new int[q];
		
		for(int i=0, gt=0 ; i<q ; i++,gt++) {
			int a=scn.nextInt();
			if(a==1) {
				int t=scn.nextInt();
				int r=scn.nextInt();
				brr[i]=r;
			}
			if(a==2) {
				int ps=scn.nextInt();
			}
		}

	}

}
