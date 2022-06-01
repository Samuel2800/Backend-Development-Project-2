package Items;

public abstract class item {
	//for a cylinder y doesn't represent anything, x the diameter
	//for a rectangle y represents the width, x the length
	//for a polygon y represents the number of sides (n), x the length of a side
	private String itemName;
	private double weight;
	private double x;
	private double y;
	private double height;
	private String baseShape;
	
	public item(String itemName, double weight, double x, double y, double height, String baseShape) {

		this.itemName = itemName;
		this.weight = weight;
		this.x = x;
		this.y = y;
		this.height = height;
		this.baseShape = baseShape;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBaseShape() {
		return baseShape;
	}

	public void setBaseShape(String baseShape) {
		this.baseShape = baseShape;
	}

	public double calculateVolume(double x, double y, double height) {
		return calculateArea(x, y) * height;
	}
	
	public abstract double calculateArea(double x, double y);
}
