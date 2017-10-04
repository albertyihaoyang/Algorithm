package factory;

public class FactoryPatternDemo {
	private final ShapeFactory shapeFactory = new ShapeFactory();
	
	public void demo(String[] args){
		// get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		// call draw method of Circle
		shape1.draw();

		// get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("Rectangle");
		// call draw method of Rectangle
		shape2.draw();
		
		// get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("Square");
		// call draw method of Square
		shape3.draw();
	}
	
	public static void main(String[] args){
		FactoryPatternDemo my = new FactoryPatternDemo();
		my.demo(null);
	}
}
