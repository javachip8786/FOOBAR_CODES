import java.util.ArrayList;
public class pep_MissedLec {
	
	public static ArrayList<String> func(String ans) {
		if(ans.length()==0) {
			ArrayList<String> baseAns=new ArrayList<>();
			baseAns.add("");
			return baseAns;
		}
		String roq=ans.substring(1);
		ArrayList<String> rec=func(roq);
		ArrayList<String> myans=new ArrayList<String>();
		for(String i : rec) {
			myans.add(ans.charAt(0)+i);
		}
		for(int i=0;i<rec.size();i++) {
			myans.add(rec.get(i));
		}
		return myans;
	}

	public static void main(String[] args) {
		String abc="abc";
		String ans="";
		System.out.print(func(abc));

	}

}
