package chapter04;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);
		
		byte[] data = new byte[9];
		try {
			String s= new String(data,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printDate01(Date d) {
		//2022-12-26 13:01:06
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = (String) sdf.format(d);
		
		System.out.println(date);
	}
	
	private static void printDate02(Date d) {
		//년도
		int year = d.getYear();
		// 월
		int month = d.getMonth();
		//일
		int date = d.getDate();
		// 시
		int hours = d.getHours();
		// 분
		int minute = d.getMinutes();
		// 초
		int second = d.getSeconds();
		
		
		
		System.out.println(
				(year+1900)+"-"+
				month+"-"+
				date+" "+
				hours+":"+
				minute+":"+
				second
				);
	}
}
