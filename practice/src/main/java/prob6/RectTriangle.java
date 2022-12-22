package prob6;

public class RectTriangle extends Shape {
	public RectTriangle (double w, double h) {
		width = w;
		height = h;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double result = width*height/2;
		return result;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		double result = Math.sqrt(width*width+height*height)+width+height;
		return result;
	}
}