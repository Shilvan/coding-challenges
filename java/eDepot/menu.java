import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Main {
	//Define a user variable so we can access it through out the program
	static String currentUser;
	
	//Define scanner to get user input
	static Scanner myScanner = new Scanner(System.in);
	
	//Define database so it can be used throughout the class
	static MongoDatabase db;
	
	
	//Main function to authenticate and redirect users
	public static void main(String[] args) {
		
		
		connectDB();
		
		System.out.println("WELCOME TO THE E-DEPOT SYSTEM");
		
		
		String username;
		String password;

		do {
			System.out.println("\nPlease login");
			
			//Set user name
			System.out.print("- Username: ");
			username = myScanner.nextLine().toLowerCase();
			
			//if user presses q, get out of loop
			if (username.equals("q")) {
				break; //Does this break goes out of if or out of loop?
				//Maybe return user = null
			}
			
			//Set password
			System.out.print("- Password (create one if it's your 1st time): ");
			password = myScanner.nextLine();
			System.out.println();
			
			
			//Authenticate user
			currentUser = login(username, password); //set it equal to a user variable
			
			if (currentUser == null) {
				continue;
			}
			//If user null
			//System.out.println("Failed to login! Try again or press \"q\" to exit");
			
			//If valid user
			//String userType = "";
			switch(currentUser) {
				case "admin":
					admin();
					break;
				case "manager":
					manager();
					break;
				case "driver":
					driver();
					break;
			}
			
			
		} while (!username.equals("q"));
		
		
		
		
		

    }
	
	public static boolean connectDB() {
		try {
			MongoClient client =  MongoClients.create("mongodb+srv://some-user:NOTsecurePWD@cluster0.zkqlf.mongodb.net/eDepot?retryWrites=true&w=majority");
			db = client.getDatabase("eDepot");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	public static void admin() {
		
		//If user not admin exit function
		if(!currentUser.equals("admin")) {
			return;
		}
		
		System.out.println("Welcome to the admin dashboard");
		
		String input;
		do {
			//Display all the options of the menu
			System.out.println();
			System.out.println("CHOOSE AN OPTION");
			System.out.println("- 1: Register manager");
			System.out.println("- 2: Register driver");
			System.out.println("- 3: Logout");
			//Ask user to enter an input
			System.out.print("Enter an option: ");
			
			//Pass input to value
			input = myScanner.nextLine().toLowerCase();
					
			//Switch to decide where to redirect manager
			switch(input) {
				case "1":
					registerManager();
					break;
				case "2":
					registerDriver();
					break;
				case "3":
					logout();
					//Exit loop
					return;
			}
			
		} while(!input.equals("3")); //Only leave the loop when user decides to logout

	}
	
	public static boolean registerManager() {
		System.out.print("Register username for manager: ");
		String username = myScanner.nextLine().toLowerCase();
		System.out.println();
		
		try {
			MongoCollection managers = db.getCollection("Managers");
			Document managerDoc = new Document("username", username);
			managers.insertOne(managerDoc);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean registerDriver() {
		System.out.print("Register username for driver: ");
		String username = myScanner.nextLine().toLowerCase();
		System.out.println();
		
		try {
			MongoCollection drivers = db.getCollection("Drivers");
			Document driverDoc = new Document("username", username);
			drivers.insertOne(driverDoc);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	
	public static void manager() {
		
		//If user not manager exit function
		
		System.out.println("Hello {name}, to your manager's dashboard");
		
		String input;
		do {
			//Display all the options of the menu
			System.out.println();
			System.out.println("CHOOSE AN OPTION");
			System.out.println("- 1: Setup work schedule");
			System.out.println("- 2: Move vehicle");
			System.out.println("- 3: Logout");
			//Ask user to enter an input
			System.out.print("Enter an option: ");
			
			//Pass input to value
			input = myScanner.nextLine().toLowerCase();
					
			//Switch to decide where to redirect manager
			System.out.print(input);
			switch(input) {
				case "1":
					//Send to setup work schedule function
					break;
				case "2":
					//Send to move vehicle function
					break;
				case "3":
					logout();
					//Exit loop
					break;
			}
			
		} while(!input.equals("3")); //Only leave the loop when user decides to logout
		
	}

	
	
	
	public static void driver() {
		
		//If user not driver exit function

		System.out.println("Hello {name}, to your driver's dashboard");
		
		String input;
		do {
			//Display all the options of the menu
			System.out.println();
			System.out.println("CHOOSE AN OPTION");
			System.out.println("- 1: View work schedule");
			System.out.println("- 2: Logout");
			//Ask user to enter an input
			System.out.print("Enter an option: ");
			
			//Pass input to value
			input = myScanner.nextLine().toLowerCase();
					
			//Switch to decide where to redirect manager
			System.out.print(input);
			switch(input) {
				case "1":
					//Send to view work schedule function
					break;
				case "2":
					logout();
					//Exit loop
					break;
			}
			
		} while(!input.equals("2")); //Only leave the loop when user decides to logout
		
	}
	
	
	
	
	
	
	/*COMMON FUNCTIONS*/
	
	
	//Function to authenticate users (change void to return user)
	public static String login(String username, String password) {
		//Attempt to login
		if(username.equals("admin") && password.equals("admin")) {
			return "admin";
		}
		
		try {
			//Compare user name and password to value in database
			//if match, return current user
		} catch (Exception e) {
			//Error
		}
		
		return null;
		//return null user
	}
	
	
	//Log user out
	public static void logout() {
		//set user to null
		currentUser = null;
	}
	

}
