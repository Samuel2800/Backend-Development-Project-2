package Methods;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import Containers.BigContainer;
import Containers.SmallContainer;
import Items.CilindricalBox;
import Items.PolygonBox;
import Items.RectangularBox;
import Items.item;

public class methods {	
	
	public HashMap<String, Object> addItems(HashMap<String, Object> order){
		boolean orderIsIncomplete = true;
		
		while(orderIsIncomplete) {
			String itemName;
			int amount;
			double weight;
			double x;
			double y = 0;
			double height;
			double volume = 0;
			String baseShape;
			
			//name
			Scanner sc = new Scanner(System.in);
			System.out.println("What is the product called?");
			itemName = sc.nextLine();
			if(order.containsKey(itemName)) {
				System.out.println("The item could not be added to the order because you already added one with the same name");
				continue;
			}
			
			//amount
			System.out.println("How many of this would you like to include in this order?");
			try {
			amount = Integer.valueOf(sc.nextLine());
			}
			catch(Exception e){
				System.out.println("Something went wrong, please try adding this item again");
				continue;
			}
			
			//height
			System.out.println("What is the height of the box?");
			try {
				height = Double.valueOf(sc.nextLine());
			}
			catch(Exception e) {
				System.out.println("Something went wrong, please try adding this item again");
				continue;
			}
			
			//weight
			System.out.println("How much does the item weight including the box?");
			try {
				weight = Double.valueOf(sc.nextLine());
			}
			catch(Exception e) {
				System.out.println("Something went wrong, please try adding this item again");
				continue;
			}
			
			//shape
			System.out.println("Please introducte one of the next options as the base of your box:");
			System.out.println("Circle    Rectangle    Square    Polygon");
			String[] validShapes = {"circle", "rectangle", "square", "polygon"};
			baseShape = sc.nextLine();
			baseShape = baseShape.toLowerCase().trim();
			if(!Arrays.asList(validShapes).contains(baseShape)) {
				System.out.println("This option isn't available at the moment");
				continue;
			}
			
			//measurements not height
			//Cylinder
			if(baseShape.equals(validShapes[0])) {
				try {
					System.out.println("What is the diameter of the base?");
					x = Double.valueOf(sc.nextLine());
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try adding this item again");
					continue;
				}
				CilindricalBox cb = new CilindricalBox(itemName, amount, weight, x, y, height, volume, baseShape);
				volume = Math.round((cb.calculateVolume(x, y, height) * 100 / 100));
				cb.setVolume(volume);
				order.put(itemName, cb);
			}
			//Rectangle
			else if(baseShape.equals(validShapes[1])) {
				try {
					System.out.println("What is the length of the base?");
					x = Double.valueOf(sc.nextLine());
					System.out.println("What is the width of the base?");
					y = Double.valueOf(sc.nextLine());
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try adding this item again");
					continue;
				}
				RectangularBox rb = new RectangularBox(itemName, amount, weight, x, y, height, volume, baseShape);
				volume = Math.round((rb.calculateVolume(x, y, height) * 100 / 100));
				rb.setVolume(volume);
				order.put(itemName, rb);
			}
			//Square
			else if(baseShape.equals(validShapes[2])) {
				try {
					System.out.println("What is the length of one of the base's sides?");
					x = Double.valueOf(sc.nextLine());
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try adding this item again");
					continue;
				}
				RectangularBox sb = new RectangularBox(itemName, amount, weight, x, x, height, volume, baseShape);
				volume = Math.round((sb.calculateVolume(x, x, height) * 100 / 100));
				sb.setVolume(volume);
				order.put(itemName, sb);
			}
			//Polygon
			else if(baseShape.equals(validShapes[3])) {
				try {
					System.out.println("What is the length of one of the base's sides?");
					x = Double.valueOf(sc.nextLine());
					System.out.println("How many sides does it have?");
					y = Double.valueOf(sc.nextLine());
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try adding this item again");
					continue;
				}
				PolygonBox pb = new PolygonBox(itemName, amount, weight, x, y, height, volume, baseShape);
				volume = Math.round((pb.calculateVolume(x, y, height) * 100 / 100));
				pb.setVolume(volume);
				order.put(itemName, pb);
			}
			
			System.out.println("New Item added successfully");
			
			//continue ordering
			System.out.println("Do you want to continue with the order?(Y/N)");
			if(sc.nextLine().toLowerCase().equals("n") ||sc.nextLine().toLowerCase().equals("no")) {
				orderIsIncomplete = false;
				System.out.println("Thanks for trusting us with your order");
			}
		}
		return order;
	}
	
	public double orderVolume(HashMap<String, Object> order) {
		double totalVolume = 0;
		for(Object value : order.values()) {
			totalVolume += (((item) value).getVolume() * ((item) value).getAmount());
		}
		return totalVolume;
	}
	
	public double orderWeight(HashMap<String, Object> order) {
		double totalWeight = 0;
		for(Object value : order.values()) {
			totalWeight += (((item) value).getWeight() * ((item) value).getAmount());
		}
		return totalWeight;
	}
	
	public void printItemInfo(Object item) {
		System.out.println("Item name: " + ((Items.item) item).getItemName());
		System.out.println("Quantity: " + ((Items.item) item).getAmount());
		System.out.println("Item's total order volume: " + ((Items.item) item).getVolume());
		System.out.println("Item's total order weight: " + ((Items.item) item).getWeight());
		System.out.println("Item's shape: " + ((Items.item) item).getBaseShape());
	}
	
	public void printOrderInfo(HashMap<String, Object> order) {
		int option;
		Scanner sc = new Scanner(System.in);
		System.out.println("For printing general information about the order press 1");
		System.out.println("For printing the information of every item in the order press 2");
		System.out.println("For printing the information of a specific item press 3");
		option = sc.nextInt();
		
		if(option == 1) {
			double volume = orderVolume(order);
			double weight = orderWeight(order);
			System.out.println("The order has " + order.size() + " items");
			System.out.println("The total volume is: " + volume);
			System.out.println("The total weight is: " + weight);
		}
		
		else if(option == 2) {
			for(Object value : order.values()) {
				printItemInfo(value);
				System.out.println("------------------------------------------------");
			}
		}
		else if(option == 3) {
			System.out.println("What is the name of the item?");
			Object item = order.get(sc.nextLine());
			printItemInfo(item);
		}
		
	}
	
	public void bestShippingMethod(HashMap<String, Object> order) {
		//music reference lol
		BigContainer Biggie = new BigContainer(0);
		SmallContainer Smalls = new SmallContainer(0);
		//update each item's amount till it gets to 0, then go for the next one
		//if the remaining volume is less than a small container, start adding the weight to smalls
		
	}
	
	public double shippingCost(BigContainer biggie, SmallContainer smalls) {
		return ((biggie.getAmount() * 1800) + (smalls.getWeight() < 500 ? 1000 : 1200));
	}


	
}
