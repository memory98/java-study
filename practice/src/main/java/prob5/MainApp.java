package prob5;

public class MainApp {

	public static void main(String[] args) {

		MyStack stack = new MyStack(3);
		stack.push("Hello");
		stack.push("World");
		stack.push("!!!");
		stack.push("java");
		stack.push(".");
//		stack.print();
		while (stack.isEmpty() == false) {
			String s = stack.pop();
			System.out.println(s);
		}

		System.out.println("======================================");

		stack = new MyStack(3);
		stack.push("Hello");
//		stack.print();
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}