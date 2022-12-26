package prob5;
public class MyStack2 {
	private Object[] buffer;
	private int index; //변한 배열의 크기
	private int n; // 처음 생성 배열의 크기

	public MyStack2(int n) {
		buffer = new Object[n];
		this.index = 0;
		this.n = n;
	}

	public void push(String str) {
		Object[] buffer1;
		if(index+1>=n) {
			buffer1 = new Object[index+1];
		} else {
			buffer1 = new Object[n+1];
		}
		
		for(int i = 0;i<index;i++) {
			buffer1[i+1]=buffer[i];
		}
		buffer1[0] = str;
		index+=1;
		if(index>n) {
			buffer = new Object[index];
		}
		for(int i = 0;i<index;i++) {
			buffer[i] = buffer1[i];
		}
	}

	public boolean isEmpty() {
		return index==0;
	}

	public Object pop() {
		Object[] buffer1 = new Object[index-1];
		Object str = buffer[0];
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
}