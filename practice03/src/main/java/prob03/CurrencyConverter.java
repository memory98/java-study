package prob03;

public class CurrencyConverter {
	   private static double rate;
	   
	   public static double toDollar(double won) {
	      // 한국 원화를 달러로 변환
		   return won*0.00078;
	   }
	   public static double  toKRW(double dollar) {
	      // 달러를 한국 원화로 변환
		   return dollar*1283.33;
	   }
	   public static void setRate(double r) {
	       // 환율 설정(KRW/$1)
		   CurrencyConverter.rate = r;
	   }

}
