import java.util.*;
import java.util.Scanner;
public class No_of_Combination_of_unlimitedPairsOfcoins {
	public static int count(int amount,int[] coins) {
		
		//this for printing
//		ArrayList<String>[] paths=new ArrayList[amount+1];
//		for(int i=0;i<paths.length;i++) {
//			paths[i]=new ArrayList<>();
//		}
//		paths[0].add("");
//		
		
		
		
		int[] dp=new int[amount+1];
		dp[0]=1;
		for(int i=0;i<coins.length;i++) {
			int coin = coins[i];
			for(int j=coin;j<dp.length;j++) {
				dp[j]=dp[j]+dp[j-coin];
				//below loop is for printing the combination
//				for(String r: paths[j - coin]) {
//					paths[j].add(r+coin);
//				}
		}
			
		}
//		for(String s:paths[amount]) {
//			System.out.println(s);
//		}
		return dp[amount];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn= new Scanner(System.in);
		int noc=scn.nextInt();
		int[] coins=new int[noc];
		for(int i=0;i<coins.length;i++) {
			coins[i]=scn.nextInt();
		}
		int amount=scn.nextInt();
		System.out.println(count(amount,coins));
	}

}
