package Items;

public class CilindricalBox extends item {
	public CilindricalBox(String itemName, int amount, double weight, double x, double y, double height, String baseShape) {
		super(itemName, amount, weight, x, y, height, baseShape);
	}

	public double calculateArea(double x, double y) {
		return Math.PI * (x / 2) * (x / 2);
	}
}
