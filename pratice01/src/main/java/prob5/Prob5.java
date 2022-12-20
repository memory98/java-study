package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i = 1 ; i<100;i++) {
			String gameNumber = String.valueOf(i);
			String[] splitNumber = gameNumber.split("");
			String jjack="";
			for(String s:splitNumber) {
				if(Integer.parseInt(s)%3==0&&Integer.parseInt(s)!=0) {
					jjack+="짝";
				}
			}
			if(jjack!="") System.out.println(i+" "+jjack);
		}
	}
}
