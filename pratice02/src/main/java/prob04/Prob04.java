package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] result = str.toCharArray();
		str.charAt(0);
		
		
		return str.toCharArray();
	}

	public static void printCharArray(char[] array){
		String str="";
		for(int i=array.length-1;i>=0;i--) str+=array[i];
		System.out.println( str );
	}
}