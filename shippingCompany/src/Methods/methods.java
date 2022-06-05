package Methods;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import Items.CilindricalBox;
import Items.PolygonBox;
import Items.RectangularBox;

public class methods {
<<<<<<< HEAD
	
	public HashMap<String, Object> readOrder(){
		HashMap<String, Object> order = new HashMap<String, Object>();
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
				weight = Double.valueOf(sc.nextLine()) * amount;
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
				volume = Math.round((cb.calculateVolume(x, y, height) * 100 / 100)) * amount;
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
				volume = Math.round((rb.calculateVolume(x, y, height) * 100 / 100)) * amount;
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
				volume = Math.round((sb.calculateVolume(x, x, height) * 100 / 100)) * amount;
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
				volume = Math.round((pb.calculateVolume(x, y, height) * 100 / 100)) * amount;
				pb.setVolume(volume);
				order.put(itemName, pb);
			}
			

		}
		
=======
	//readOrder method add an element to a list
	//volume and weight just get the element form the list, get the amount, weight and volume and play with that
	public ArrayList<String> readOrder(){
		ArrayList<String> order = new ArrayList<String>();
		boolean incompleteOrder = true;
		 do while(incompleteOrder) {
			 //use java scanner
		 }
>>>>>>> 9b041eabf497c699b898a928e09194064b552ead
		return order;
	}


	
}
