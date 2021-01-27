package categories_test;
import java.util.ArrayList;
import categories.Category;
import categories.SubCategory;
import categories.TopLevelCategory;

class CategoryDisplayExample {
	
	public static ArrayList<Category> theCategories = new ArrayList<Category>();
	
	public static void main(String[] args) {  //  explicit postconditions unnecessary
		
		System.out.println("=========CategoryDisplayExample==========");
		displayCategoryHierarchyExample();
	}
	
	static void displayCategoryHierarchyExample() {  
		
		/*
		    =========CategoryDisplayExample==========
			========= Should display 23 items ==========
			Image Categories
			Client Portfolio
				Pepsi Bottling
				Walmart
				Family Dollar
				Kroger
			Asphalt Paving
				Streets
				Airport Ramps
				Subdivisions
				Parking Lots
				Driveways
				Paths
			Specialty Work
				Pavement Milling
				Dust Control
				Pavement Fabric Installation
				Utility Cut Patching
				Asphalt Curbs
				Golf Cart Paths
				Gabeon Baskets
			Grading & Excavating
			Shuttle Buggy Rental
			
			6 Top Level Categories and 17 Sub Level Categories.
		
		 */		
		
		
		// Post1 (theCategories) AND Post2 (Various)
		
		TopLevelCategory myTopLevelCategories = new TopLevelCategory("Image Categories");
		theCategories.add(myTopLevelCategories); // for Post1
		 
		
		//First Top Level Category (Client Portfolio) and Sub Categories of Clients
		SubCategory pepsi = new SubCategory("Pepsi Bottling");
		theCategories.add(pepsi); // for Post1
		SubCategory wallyWorld = new SubCategory("Walmart");
		theCategories.add(wallyWorld); // for Post1
		SubCategory familyDollar = new SubCategory("Family Dollar");
		theCategories.add(familyDollar); // for Post1
		SubCategory kroger = new SubCategory("Kroger");
		theCategories.add(kroger); // for Post1
		TopLevelCategory clients = new TopLevelCategory("Client Portfolio");
		theCategories.add(clients); // for Post1
		clients.add(pepsi);
		clients.add(wallyWorld);
		clients.add(familyDollar);
		clients.add(kroger);
		
		//Second Top Level Category (Asphalt Paving) and Sub Categories (Types of Paving)
		SubCategory streets = new SubCategory("Streets");
		theCategories.add(streets); // for Post1
		SubCategory airportRamps = new SubCategory("Airport Ramps");
		theCategories.add(airportRamps); // for Post1
		SubCategory subDivisions = new SubCategory("Subdivisions");
		theCategories.add(subDivisions); // for Post1
		SubCategory parkingLots = new SubCategory("Parking Lots");
		theCategories.add(parkingLots); // for Post1
		SubCategory driveways = new SubCategory("Driveways");
		theCategories.add(driveways); // for Post1
		SubCategory paths = new SubCategory("Paths");
		theCategories.add(paths); // for Post1
		TopLevelCategory asphalt = new TopLevelCategory("Asphalt Paving");
		theCategories.add(asphalt); // for Post1
		asphalt.add(streets);
		asphalt.add(airportRamps);
		asphalt.add(subDivisions);
		asphalt.add(parkingLots);
		asphalt.add(driveways);
		asphalt.add(paths);
		
		//Third Top Level Category (Specialty Work) and Sub Categories (Types of Specialty Work)
		SubCategory pavementMilling = new SubCategory("Pavement Milling");
		theCategories.add(pavementMilling); // for Post1
		SubCategory dustControl = new SubCategory("Dust Control");
		theCategories.add(dustControl); // for Post1
		SubCategory fabric = new SubCategory("Pavement Fabric Installation");
		theCategories.add(fabric); // for Post1
		SubCategory utilityCut = new SubCategory("Utility Cut Patching");
		theCategories.add(utilityCut); // for Post1
		SubCategory asphaltCurbs = new SubCategory("Asphalt Curbs");
		theCategories.add(asphaltCurbs); // for Post1
		SubCategory golfCartPaths = new SubCategory("Golf Cart Paths");
		theCategories.add(golfCartPaths); // for Post1
		SubCategory gabeonBaskets = new SubCategory("Gabeon Baskets");
		theCategories.add(gabeonBaskets); // for Post1		
		TopLevelCategory specialty = new TopLevelCategory("Specialty Work");
		theCategories.add(specialty); // for Post1
		specialty.add(pavementMilling);
		specialty.add(dustControl);
		specialty.add(fabric);
		specialty.add(utilityCut);
		specialty.add(asphaltCurbs);
		specialty.add(golfCartPaths);
		specialty.add(gabeonBaskets);
		
		TopLevelCategory grading = new TopLevelCategory("Grading & Excavating");
		theCategories.add(grading); // No SubCategories
		
		TopLevelCategory shuttle = new TopLevelCategory("Shuttle Buggy Rental");
		theCategories.add(shuttle); //  No SubCategories
		
		myTopLevelCategories.add(clients);
		myTopLevelCategories.add(asphalt);
		myTopLevelCategories.add(specialty);
		myTopLevelCategories.add(grading);
		myTopLevelCategories.add(shuttle);
		
		// Post3 (Display All)
		System.out.println("========= Should display 23 items ==========");
		myTopLevelCategories.displayAll();	
		
		// Post4 (Counts)
		displayTypeCount();
	}
	
	static void displayTypeCount() {
		// Postcondition: The number of Top Level Categories and Sub Level Categories in theCategories ArrayList get displayed in the console
			
		    int topLevelCount = 0, subLevelCount = 0;
			for (Category category : theCategories) {
		        if (category.getType() == "Top Level Category") {
		        	topLevelCount += 1;
		        }
		        else {
		        	subLevelCount += 1;
		        }
		    }
		System.out.println("\n" + topLevelCount + " Top Level Categories and " + subLevelCount + " Sub Level Categories.");
	}
}