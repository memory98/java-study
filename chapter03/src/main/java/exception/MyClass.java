package exception;

import java.io.IOException;

public class MyClass  {
	public void danger() throws IOException,MyException {
		System.out.println("some code1.....");
		System.out.println("some code2.....");
		
		if(3-3==0) {
			throw new MyException();
		}
		//이렇게 하면 속는다.??
		if(5-5==0) {
			throw new IOException();
		}
		//error 발생
		System.out.println("some code3.....");
		System.out.println("some code4.....");
	}
}
