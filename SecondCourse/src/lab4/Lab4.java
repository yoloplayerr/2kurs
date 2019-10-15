package lab4;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab4 {

	public static void main(String[] args) {
		getFirst();

	}

	public static void getFirst() {
		//b
		ArrayList<Integer> b1 = new ArrayList<>();
		String b = "qefkjsadfsdpfskdlf12323456";
		String regex = "[0-9]";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher(b);
		while (matcher.find()) {
			b1.add(Integer.valueOf(b.substring(matcher.start(), matcher.end())));
		}
		int tmp = 0;
		int tmpIndex=0;
				for (int i=0;i<b1.size();i++) {
					if(tmp<b1.get(i)) {
						tmp=b1.get(i);
						tmpIndex=i;
					}
				}
				System.out.println(b1);	
				System.out.println((b1.get(tmpIndex))==tmp);	
		
	}

}
