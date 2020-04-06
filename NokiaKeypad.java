import java.util.ArrayList;
public class NokiaKeypad {
	public static void Str(String ques,String ans,String[] arr) {
		if(ques.length()==0) {
			System.out.println(ans);
			return;
		}
		char ch=ques.charAt(0);
		int num=ch - '0';
		String word= arr[num];
		for(int i=0;i<word.length();i++) {
			char ch1=word.charAt(i);
			Str(ques.substring(1),ans+ch1,arr);
		}
	}
	
	public static void main(String[] args) {
		String[] arr= {"?.",",;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		
		Str("234","",arr);
	
	
	
	}

}
