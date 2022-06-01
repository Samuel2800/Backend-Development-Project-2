package Containers;

public class containers {
	private String containerSize;
	private double containerHeight;
	private double containerWidth;
	private double containerLength;
	
	public containers(String containerSize, double containerHeight, double containerWidth, double containerLength) {
		this.containerSize = containerSize;
		this.containerHeight = containerHeight;
		this.containerWidth = containerWidth;
		this.containerLength = containerLength;
	}

	public String getContainerSize() {
		return containerSize;
	}
	
	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}
	
	public double getContainerHeight() {
		return containerHeight;
	}

	public void setContainerHeight(double containerHeight) {
		this.containerHeight = containerHeight;
	}

	public double getContainerWidth() {
		return containerWidth;
	}

	public void setContainerWidth(double containerWidth) {
		this.containerWidth = containerWidth;
	}

	public double getContainerLength() {
		return containerLength;
	}

	public void setContainerLength(double containerLength) {
		this.containerLength = containerLength;
	}
	
	public double containerVolume(double height, double length, double width) {
		return height * length * width;
	}
	
	public void containerInfo(String containerSize, double height, double length, double width) {
		System.out.println("Container size: " + containerSize);
		System.out.println("Container volume: " + containerVolume(height, length, width));
	}
	
}
