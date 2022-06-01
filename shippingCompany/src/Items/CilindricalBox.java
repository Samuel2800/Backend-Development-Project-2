package Items;

public class CilindricalBox extends item {
	public double calculateArea(double x, double y) {
		return Math.PI * (x / 2) * (x / 2);
	}
}
