package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.print("금액 : ");
		int money = scanner.nextInt();
		int cnt,result;
		result=money;
		for(int i:MONEYS) {
			cnt=0;
			
			while(true) {
				if(result-i>=0) {
					result-=i;
					cnt++;
				} else {
					break;
				}
			}
			System.out.println(i+" : "+cnt+"개");
		}
		scanner.close();
 	}
}