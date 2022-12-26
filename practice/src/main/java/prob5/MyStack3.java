package prob5;
public class MyStack3<T> {
	private T[] buffer;
	private int index; //변한 배열의 크기
	private int n; // 처음 생성 배열의 크기

	public MyStack3(int n) {
		buffer = (T[])new Object[n];
		this.index = 0;
		this.n = n;
	}

	public void push(T str) {
		T[] buffer1;
		if(index+1>=n) {
			buffer1 = (T[])new String[index+1];
		} else {
			buffer1 = (T[])new String[n+1];
		}
		
		for(int i = 0;i<index;i++) {
			buffer1[i+1]=buffer[i];
		}
		buffer1[0] = str;
		index+=1;
		if(index>n) {
			buffer = (T[])new String[index];
		}
		for(int i = 0;i<index;i++) {
			buffer[i] = buffer1[i];
		}
	}

	public boolean isEmpty() {
		return index==0;
	}

	public T pop() {
		T[] buffer1 =(T[]) new String[index-1];
		T str = buffer[0];
		for(int i = 1; i<index;i++) {
			buffer1[i-1]=buffer[i];
		}
		if(index >= n) {
			buffer = (T[])new String[index];
		} 
		for(int i = 0;i<index-1;i++) {
			buffer[i]=buffer1[i];
		}
		index-=1;
		return str;
	}
}