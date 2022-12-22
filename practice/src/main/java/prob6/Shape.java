package prob6;

public abstract class Shape {
	protected double width;
	protected double height;
	
	//넓이
	abstract double getArea();
	//둘레 길이
	abstract double getPerimeter();
}
