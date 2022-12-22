package prob5;
public class MyStack {
	private String[] buffer;
	private int index;

	public MyStack(int n) {
		buffer = new String[0];
		this.index = 0;
	}

	public void push(String str) {
//		System.out.print(this.index+ " : ");
//		if(this.index>=this.buffer.length-1) {
		String[] buffer1 = new String[this.buffer.length + 1];
		for (int i = 0; i < this.buffer.length; i++)
			buffer1[i] = buffer[i];
			buffer1[buffer1.length - 1] = str;
			this.buffer = new String[buffer1.length];
		for (int i = 0; i < this.buffer.length; i++)
			this.buffer[i] = buffer1[i];
			this.index += 1;
//			} else {
//				buffer[this.index]=str;
//				this.index+=1;
//		}
	}

	public boolean isEmpty() {
		if (this.buffer.length == 0)
			return true;
		else
			return false;
	}

	public String pop() {
//		System.out.print(index + "  : ");
		String result = this.buffer[this.buffer.length - 1];
		String[] buffer1 = new String[this.buffer.length - 1];
		for (int i = 0; i < buffer1.length; i++)
			buffer1[i] = this.buffer[i];
		buffer = new String[buffer1.length];
		for (int i = 0; i < buffer1.length; i++)
			this.buffer[i] = buffer1[i];
		index -= 1;
		return result;
	}
}