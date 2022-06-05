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
	
	public void addItems(HashMap<String, Object> order){
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
			System.out.println("Circle    Rectangle    Cube    Polygon");
			String[] validShapes = {"circle", "rectangle", "cube", "polygon"};
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
				CilindricalBox cb = new CilindricalBox(itemName, amount, weight, x, y, height, volume, "Cylinder");
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
				RectangularBox rb = new RectangularBox(itemName, amount, weight, x, y, height, volume, "Rectangular prism");
				volume = Math.round((rb.calculateVolume(x, y, height) * 100 / 100));
				rb.setVolume(volume);
				order.put(itemName, rb);
			}
			//Cube
			else if(baseShape.equals(validShapes[2])) {
				try {
					System.out.println("What is the length of one of the base's sides?");
					x = Double.valueOf(sc.nextLine());
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try adding this item again");
					continue;
				}
				RectangularBox sb = new RectangularBox(itemName, amount, weight, x, x, height, volume, "Cube");
				volume = Math.round((sb.calculateVolume(x, x, x) * 100 / 100));
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
					if(y < 5) {
						System.out.println("No shape found");
						continue;
					}
				}
				catch(Exception e){
					System.out.println("Something went wrong, please try adding this item again");
					continue;
				}
				PolygonBox pb = new PolygonBox(itemName, amount, weight, x, y, height, volume, "Polygonal prism");
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
	}
	
	public void removeItem(HashMap<String, Object> order, String item) {
		try {
			order.remove(item);
		}
		catch(Exception e) {
			System.out.println(item + " couldn't be found in the order");
		}
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
		if(order.isEmpty()) {
			System.out.println("You have not added any items to this order yet");
		}
		else {
			int option;
			Scanner sc = new Scanner(System.in);
			System.out.println("For printing general information about the order press 1");
			System.out.println("For printing the information of every item in the order press 2");
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
			else {
				System.out.println("This option is not available");
			}
		}
	}
	
	public void bestShippingMethod(HashMap<String, Object> order, BigContainer biggie, SmallContainer smalls) {
		double localVolume = orderVolume(order);
		double localWeight = orderWeight(order);
		double smallVolume = smalls.getContainerVolume();
		double bigVolume = biggie.getContainerVolume();
		while(!order.isEmpty()){
			double temp = 0;
			if(localVolume > smallVolume) {
				biggie.setAmount(biggie.getAmount() + 1);
				for(String key : order.keySet()) {
					Object value = order.get(key);
					while(!(((item) value).getAmount() == 0) && (temp + ((item) value).getVolume()) < bigVolume && !(((item) value).getAmount() == 0)) {
						temp += ((item) value).getVolume();
						((item) value).setAmount(((item) value).getAmount() - 1);
						localVolume -= ((item) value).getVolume();
						localWeight -= ((item) value).getWeight();
					}
					if(((item) value).getAmount() == 0) {
						order.remove(key);
					}
				}
			}
			else {
				smalls.setAmount(smalls.getAmount() + 1);
				for(String key : order.keySet()) {
					Object value = order.get(key);
					while(!(((item) value).getAmount() == 0) && !(((item) value).getAmount() == 0)) {
						//just in case  && (temp + ((item) value).getVolume()) < smallVolume
						temp += ((item) value).getVolume();
						((item) value).setAmount(((item) value).getAmount() - 1);
						localVolume -= ((item) value).getVolume();
						localWeight -= ((item) value).getWeight();
					}
					if(((item) value).getAmount() == 0) {
						order.remove(key);
					}
				}
			}
		}
		double cost = shippingCost(biggie, smalls);
		System.out.println("Big containers used: " + biggie.getAmount());
		System.out.println("Small containers used: " + smalls.getAmount());
		System.out.println("Shipping cost: " + cost);
	}
	
	public double shippingCost(BigContainer biggie, SmallContainer smalls) {
		return ((biggie.getAmount() * 1800) + (smalls.getWeight() < 500 ? 1000 : 1200));
	}
	
	public void app() {
		HashMap<String, Object> order = new HashMap<String, Object>();
		BigContainer biggie = new BigContainer(0);
		SmallContainer smalls = new SmallContainer(0);
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		while(!exit) {
			System.out.println("To procede choose one of the following options");
			System.out.println("1. Add items to the order");
			System.out.println("2. Remove an item from the order");
			System.out.println("3. Show information about the order");
			System.out.println("4. Show information about an specific item");
			System.out.println("5. Get the best shipping method");
			System.out.println("6. Exit");
			String option = sc.nextLine();
			if(option.toLowerCase().trim().equals("add items to the order") || option.trim().equals("1") || option.trim().equals("1. Add items to the order")) {
				addItems(order);
			}
			else if(option.toLowerCase().trim().equals("remove an item from the order") || option.trim().equals("2") || option.trim().equals("2. Remove an item from the order")) {
				System.out.println("Enter the name of the item you want to remove");
				String itemToRemove = sc.nextLine();
				removeItem(order, itemToRemove);
			}
			else if(option.toLowerCase().trim().equals("show information about the order") || option.trim().equals("3") || option.trim().equals("3. Show information about the order")) {
				printOrderInfo(order);
			}
			else if(option.toLowerCase().trim().equals("show information about an specific item") || option.trim().equals("4") || option.trim().equals("4. Show information about an specific item")) {
				System.out.println("Introduce the name of the item");
				String str = sc.nextLine();
				try {
					printItemInfo(order.get(str));
				}
				catch(Exception e) {
					System.out.println("No item was found under this name");
					continue;
				}
			}
			else if(option.toLowerCase().trim().equals("get the best shipping method") || option.trim().equals("5") || option.trim().equals("5. Get the best shipping method")) {
				HashMap<String, Object> copy = order;
				bestShippingMethod(copy, biggie, smalls);
			}
			else if(option.toLowerCase().trim().equals("exit") || option.trim().equals("6") || option.trim().equals("6. Exit")) {
				exit = true;
				System.out.println("The programm has ended, please close the console");
			}
			else {
				System.out.println("Option not available");
			}
		}
		
		
	}


	
}
