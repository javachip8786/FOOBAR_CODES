import java.util.Scanner;
public class PatrickGoesHome_Recer {
	public static int re(int[][] arr,int xs,int ys,int xe,int ye) {
		int count=0;
		if(xs==xe && ys==ye) {
			return 1;
		}
		if((xs+1)<=(arr.length-1) && arr[xs+1][ys]!=0 ) {
			count+=re(arr,xs+1,ys,xe,ye);
		}
		if(ys+1<=(arr[0].length-1) && arr[xs][ys+1]!=0 ) {
			count+=re(arr,xs,ys+1,xe,ye);
		}
//		else {
//		count+=re(arr,xs,ys+1,xe,ye)+re(arr,xs+1,ys,xe,ye);
//		}
		return count;
	}
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int a=scn.nextInt();
		int b=scn.nextInt();
		int c=scn.nextInt();
		int d=scn.nextInt();
//		int count=0;
		int arr[][]=new int[a][b];
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				arr[i][j]=scn.nextInt();
			}
		}
		int n1=re(arr,0,0,c-1,d-1);
		int n2=re(arr,c-1,d-1,a-1,b-1);
		System.out.println(n1*n2);

	}

}
//3 3 2 2
//1 0 1
//1 1 1
//1 1 1
