package prob02;

public class Calc implements Arithmetic {
	
	private int rValue,lValue;
	private String str;
	
	public Calc(String str) {
		this.str = str;
	}
	@Override
	public int calculate(int a, int b) {
		int result;
		switch(str) {
		case "+":
			result = Add(a,b);
			break;
		case "-":
			result = Sub(a,b);
			break;
		case "*":
			result = Mul(a,b);
			break;
		case "/":
			result = Div(a,b);
			break;
			default :
				result = -1;
				
		}
		return result;
	}
	
	public int Add(int a, int b) {
		return a+b;
	}
	public int Sub(int a, int b) {
		return a-b;
	}
	public int Mul(int a, int b) {
		return a*b;
	}
	public int Div(int a, int b) {
		return a/b;
		
	}

}
