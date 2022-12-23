package prob5;
public class MyStack {
	private String[] buffer;
	private int index; //변한 배열의 크기
	private int n; // 처음 생성 배열의 크기

	public MyStack(int n) {
		buffer = new String[n];
		this.index = 0;
		this.n = n;
	}

	public void push(String str) {
		String[] buffer1;
		if(index+1>=n) {
			buffer1 = new String[index+1];
		} else {
			buffer1 = new String[n+1];
		}
		
		for(int i = 0;i<index;i++) {
			buffer1[i+1]=buffer[i];
		}
		buffer1[0] = str;
		index+=1;
		if(index>n) {
			buffer = new String[index];
		}
		for(int i = 0;i<index;i++) {
			buffer[i] = buffer1[i];
		}
	}

	public boolean isEmpty() {
		if(index==0) {
			return true;
		} else {
			return false;
		}
	}

	public String pop() {
		String[] buffer1 = new String[index-1];
		String str = buffer[0];
		for(int i = 1; i<index;i++) {
			buffer1[i-1]=buffer[i];
		}
		if(index >= n) {
			buffer = new String[index];
		} 
		for(int i = 0;i<index-1;i++) {
			buffer[i]=buffer1[i];
		}
		index-=1;
		return str;
	}
	
	public void print() {
		for(String s:buffer) System.out.print(s+" ");
	}
}