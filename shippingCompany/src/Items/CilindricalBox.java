package Items;

public class CilindricalBox extends item {
	public CilindricalBox(String itemName, double weight, double x, double y, double height, String baseShape) {
		super(itemName, weight, x, y, height, baseShape);
	}

	public double calculateArea(double x, double y) {
		return Math.PI * (x / 2) * (x / 2);
	}
}
