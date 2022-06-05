package Containers;

public class SmallContainer {
	
	private double containerVolume = 38.139822;
	private int amount;
	private int weight;

	public SmallContainer(int amount) {
		super();
		this.containerVolume = containerVolume;
		this.amount = amount;
		this.weight = weight;
	}

	public double getContainerVolume() {
		return containerVolume;
	}

	public void setContainerVolume(double containerVolume) {
		this.containerVolume = containerVolume;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
