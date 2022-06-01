package Items;

public class PolygonBox {
	//For a regular polygon of n sides we only need the length x of a side and the number of sides
	public double calculateArea(double x, double n) {
		return n * (x * x) / (4 * Math.tan(Math.PI / n));
	}
}
