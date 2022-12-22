package prob6;

public class Rectangle extends Shape {

	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double result = width*height;
		return result;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double result = 2*(width+height);
		return result;
	}

	
}
