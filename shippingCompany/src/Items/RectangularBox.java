package Items;

public class RectangularBox extends item{
	public RectangularBox(String itemName, double weight, double x, double y, double height, String baseShape) {
		super(itemName, weight, x, y, height, baseShape);
	}

	public double calculateArea(double x, double y) {
		return x * y;
	}
}
