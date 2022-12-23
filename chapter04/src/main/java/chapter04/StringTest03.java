package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello " + "World " + "Java "+17;
		String s1 = new StringBuffer("Hello ")
		.append("World")
		.append("World")
		.append(" Java ")
		.append(17)
		.toString();
		
		System.out.println(s1);
			
		String s2 = "";
		StringBuffer sb = new StringBuffer("");
		for(int i =0;i<100000;i++) {
//			s2 = s2+i;
//			s2=new StringBuffer(s2).append(i).toString();
			sb.append(i);
		}
		
		String s3 = sb.toString();
		System.out.println(s1);
		
		// String method들 ...
		String s4 = new String("aBcABCabcAbc");
		
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc",7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3,5));
		
		String s5 = "     ab     cd    ";
		String s6 = "efg,hij,klm,nop,qrs";
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("---"+s5.trim()+"---");
		System.out.println("---"+s5.replaceAll(" ","")+"---");
		
		String[] token = s6.split(",");
		for(String s : token) {
			System.out.println(s);
		}
		
		String[] token2 = s6.split(" ");
		for(String s:token2) {
			System.out.println(s);
		}
		

	}
}
