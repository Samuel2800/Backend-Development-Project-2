package Items;

public class PolygonBox extends item{
	public PolygonBox(String itemName, double weight, double x, double y, double height, String baseShape) {
		super(itemName, weight, x, y, height, baseShape);
	}

	//For a regular polygon of n sides we only need the length x of a side and the number of sides
	public double calculateArea(double x, double n) {
		return n * (x * x) / (4 * Math.tan(Math.PI / n));
	}
}
