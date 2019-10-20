package lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab4 {

	public static void main(String[] args) {
		getFirst();

	}

	public static void getFirst() {
		// a
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String reg = "abcd1{7}02019";
		System.out.println("Задание а" + Pattern.matches(reg, a));

		// b
		ArrayList<Integer> b1 = new ArrayList<>();
		String b = "qefkjsadfsdpfskdlf12323456";
		String regex = "[0-9]";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher(b);
		while (matcher.find()) {
			b1.add(Integer.valueOf(b.substring(matcher.start(), matcher.end())));
		}
		int tmp = 0;
		int tmpIndex = 0;
		for (int i = 0; i < b1.size(); i++) {
			if (tmp < b1.get(i)) {
				tmp = b1.get(i);
				tmpIndex = i;
			}

		}
		System.out.println("Задание б");
		System.out.println(b1);
		System.out.println((b1.get(tmpIndex)) == tmp);
		// ВЭ
		ArrayList<String> gV = new ArrayList<>();
		String regexV = "\\d*([.,]\\d*|\\d)";
		String V = "123842034wklfjsdbf891234oksdf";
		Pattern ptv = Pattern.compile(regexV);
		Matcher matcherg = ptv.matcher(V);
		while (matcherg.find()) {
			gV.add((V.substring(matcherg.start(), matcherg.end())));
		}
		System.out.print(gV);

		System.out.println("Задание г");

		Pattern ptg = Pattern.compile("\\w{10,}");
		String g = "jkadnfksdfasdak aaxcklmksda adclaxclzcxca";
		Matcher matcher2 = ptg.matcher(g);
		String g1 = g;
		String g2 = g;
		while (matcher2.find()) {
			g1 = matcher2.replaceAll("*");
		}
		System.out.println(g1);
		matcher2 = ptg.matcher(g2);
		while (matcher2.find()) {
			g2 = g2.replace(g2.substring(matcher2.start(), matcher2.end()),
					String.valueOf(g2.charAt(matcher2.start())));
			matcher2 = ptg.matcher(g2);
		}
		System.out.println(g2);

		matcher2 = ptg.matcher(g);
		StringBuffer string = new StringBuffer(g);
		while (matcher2.find()) {
			int k = matcher2.start();
			while (k != matcher2.end()) {
				string.setCharAt(k, g.charAt(matcher2.start()));
				k++;
			}
		}
		System.out.println(string);

		System.out.println("Задание д");

		System.out.println(
				Pattern.matches("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}", "какая то там строка"));

		System.out.println("Задание е");
		System.out.println(Pattern.matches("#[a-fA-F0-9]{6}", "#FFFFFF"));

		System.out.println("Задание д");
		Pattern ptg1 = Pattern.compile("^(.*/)([^/]*)$");
		Matcher matcher3 = ptg1.matcher("/Users/maxim/BIA/_project.xml");
		ArrayList<String> as = new ArrayList<>();
		while (matcher3.find()) {
			as.add("/Users/maxim/BIA/_project.xml".substring(matcher3.start(), matcher3.end()));
		}
		System.out.println(as);
		System.out.println("Задание з");

		Pattern ptg2 = Pattern.compile("[ик]");
		Matcher matcher4 = ptg2.matcher("Садик чето там Садик");

		System.out.println(matcher4.replaceAll(""));

	}

	public static void getThird(String string) {
		System.out.println(Pattern.matches("^([a-fA-F0-9][:-]){5}[a-fA-F0-9][:-]$", string));
	}

	public static void getFourth(String string) {
		System.out.println(
				Pattern.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", string));
	}

	public static void getSixth(String string) {
		Pattern ptg = Pattern.compile("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");
		Matcher matcher = ptg.matcher(string);
		matcher.find();
		int day = Integer.parseInt(matcher.group(1));
		int month = Integer.parseInt(matcher.group(2));
		int year = Integer.parseInt(matcher.group(3));
		System.out.print("день" + day + "месяц" + month + "год" + year);
	}

	public static void getSeventh(String string) {
		System.out.println(Pattern.matches("^(.+)@(.+)$", string));
	}

	public static void getEight(String string) {
		System.out.println(Pattern.matches("([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])", string));
	}
	 public static void getTenth(String string){
	        System.out.println(Pattern.matches("[1-9]\\d{5}",string));
	    }
	 public static void getTwelfth(String string){
	        Pattern pattern = Pattern.compile("\\d[^+]");
	        Matcher matcher = pattern.matcher(string);
	        System.out.println(matcher.find());
	    }
	 public static void getThirteenth(String string){
	        Pattern ptg1 = Pattern.compile("\\(");
	        Pattern ptg2 = Pattern.compile("\\)");
	        Matcher matcher = ptg1.matcher(string);
	        int i=0,j=0;
	        while (matcher.find())i++;
	        matcher = ptg2.matcher(string);
	        while (matcher.find())j++;
	        System.out.println(i==j);
	    }
	 public static void ninth(String string){
	        Pattern ptg = Pattern.compile("[\\w_]{8,}");
	        Matcher matcher = ptg.matcher(string);
	        boolean up=false,low=false,dig=false;
	        if(!matcher.find()) {
	        	System.out.println(false);
	        }
	        else {
	            
	            for (int i = matcher.start(); i < matcher.end(); i++) {
	                char c = string.charAt(i);
	                if(Character.isUpperCase(c)) {
	                	up=true;
	                }
	                else if(Character.isLowerCase(c)) {
	                	low=true;
	                }
	                else if(Character.isDigit(c)) {
	                	dig=true;
	                }
	            }
	            System.out.println(up&low&dig);
	        }
	    }

}
