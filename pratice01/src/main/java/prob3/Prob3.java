package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("수를 입력하시오 : ");
		int input = scanner.nextInt();
		int sum = 0;
		int start;
		if(input%2==0) start = 2;
		else start =1;
		for(int i = start;i<=input;i+=2) {
			sum+=i;
		}
		
		System.out.println("결과값 : "+sum);
		scanner.close();
	}
}
