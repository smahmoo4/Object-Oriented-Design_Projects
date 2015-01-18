// Saad Mahmood
// CS 115 Final Project
// Section 001
// ID: A20266900


/*This Program is a Summer Olympics Information Program. It displays participating athletes by 
  country, by sport, by revenues, by venues, and by ages. It calculates total revenue of a country and 
  average revenue of a country. It searches from a file called socs115.txt, and uses an array of athlete
  class objects to store any athlete information.
 */
import java.io.*; // two packages are needed, io for inputting the File, and util for for scanning user input. 
import java.util.*;
public class mahmood_saad {

	//Constants 

	final static athlete[] allPlayers = new athlete[2000]; //athlete class object array
	static int total = 0;

	//main method 
	// reads in socs115.txt
	//checks for END_OF_FILE

	public static void main(String[] args) throws IOException //main method
	{
		int checkTotal [] = new int [7];
		File ifile = new File(/*"/Users/Saaduddin/Desktop/*/"socs115 copy.txt"); //specific file path for my program on Eclipse...
		Scanner scan = new Scanner(ifile); //setting up my IO input reader...
		Scanner user = new Scanner(System.in); //setting up input from user

		// NOTE*** 
		// when type Scanner's variable is set to "scan"... this reads from the File socs115.txt
		// when type Scanner's variable is set to "user"... this reads from the user's input on keyboard

		String Country = scan.nextLine();

		while(!Country.equals("END_OF_FILE")) //makes sure that the first word is Country
		{
			int NumAthletes = scan.nextInt(); // next line of the file which is an integer

			for(int i=0; i < NumAthletes; i++) { //reads in athlete info from socs115.txt
				String Last_Name = scan.next();
				String First_Name = scan.next();
				int age = scan.nextInt();
				double adRevenue = scan.nextDouble();
				String venue = scan.next();
				String sport = scan.nextLine();

				allPlayers[total++] = new athlete(Country, Last_Name, First_Name, age, adRevenue, venue, sport);
				//^ this is the array of athlete class object, which is incremented by total
			}
			Country = scan.nextLine(); //once the for loop is finished, it checks again for the country, to make sure it does not loop the same country again, and that it is not END_OF_FILE
		}
		System.out.println ("Welcome To the 2012 Summer Olympics Information Program");
		System.out.println ();

		boolean done = false;
		// do is necessary to enter the program once. after that it is up to the user. 
		do{
			System.out.print("Please Enter 'M' for Main Menu or 'Q' for Final Stats or 'E' to Exit.");
			System.out.println();
			System.out.println();
			System.out.println("Enter Here--> :");//first option


			String option;
			char selection; //this is for user input, the string is converted to a character

			option= user.next(); 
			selection=option.charAt(0); 

			while (selection != 'M' && selection!= 'm' && selection != 'Q' && selection != 'q' && selection != 'E' && selection !='e')
			{
				System.out.println ("Please Try Again.");
				System.out.println ("Please Enter 'M' for Menu or 'Q' for Final Stats: ");
				System.out.println();
				System.out.println();
				System.out.println("Enter Here--> :");

				option= user.next();
				selection=option.charAt(0); 
			}
			switch (selection) //switch case for menu() and finalStats()
			{
			case 'm':		
			case 'M':
				menu (checkTotal); // calls menu method; increases the counter for 'm' in checkTotal
				break;

			case 'q':
			case 'Q':
				finalStats (checkTotal); // calls finalStats(); increases 'q' counter.
				System.out.println();
				break;
			
			case 'e':
			case 'E': 
				done = true;
			}
		} while(!done);

		finalStatsFile(checkTotal); // displays total in SummerOlympicsFile.txt

	}	



	//method menu. breaks down even further into more methods.	
	private static void menu(int checkTotal []) 
	{	

		Scanner user = new Scanner (System.in); //scans their string and converts to character
		String option; 
		char selection; 

		//gives them option here...
		System.out.println();
		System.out.println("Main Menu");
		System.out.println ();
		System.out.println("Please Enter:");
		System.out.println ();
		System.out.println(" 'l' for a List of Athlete Attributes,");
		System.out.println ();
		System.out.println(" 'a' for an Athlete Search," );
		System.out.println ();
		System.out.println(" 'c' for a Country Search,");
		System.out.println ();
		System.out.println(" 'r' for an Athlete's Revenue Search,");
		System.out.println ();
		System.out.println(" 'v' for a Venue Search,");		
		System.out.println ();
		System.out.println(" 'q' to return back to Main Menu,");
		System.out.println ();
		System.out.print( "Enter Here -->: "); 

		option= user.next(); 
		selection=option.charAt(0); //converts string to character

		for (int p=0; p < checkTotal[6]; p++) //7 options
		{
			checkTotal [p]= 0;
		}
		while ( selection != 'L' && selection!= 'l' && selection != 'A' && selection != 'a' && 
				selection != 'C' && selection!= 'c' && selection != 'R' && selection != 'r' && 
				selection != 'V' && selection!= 'v' && selection != 'Q' && selection != 'q' )

		{ 	System.out.println ();
		System.out.print ("Sorry. Please Enter a Valid Option:"); //input failure
		option= user.next();
		selection = option.charAt(0); //converts string to character again
		checkTotal [0]++; //increments checkTotal for Garbage Values ("Invalid Option" in code)
		}

		switch (selection) //switch-case that checks for what method to enter and counts number of times a letter is entered 	

		{
		case 'l':
		case 'L':
			listall(); //calls listall()
			checkTotal[1]++; //increments checkTotal for 'l'

			break;

		case 'a':
		case 'A':
			athleteReport(); //calls athleteReport()
			checkTotal[2]++; //increments checkTotal for 'a'

			break; 

		case 'c':
		case 'C':
			countryReport(); //calls countryReport()
			checkTotal[3]++; //increments checkTotal for 'c'

			break;

		case 'r':
		case 'R':
			adRevenueReport(); //calls adRevenueReport()
			checkTotal[4]++; //increments checkTotal for 'r'

			break;

		case 'v':
		case 'V':
			venueReport(); //calls venueReport()
			checkTotal[5]++; //increments checkTotal for 'v'

			break;

		case 'q':
		case 'Q':		
			//returns to main()
			checkTotal[6]++; //increments checkTotal for 'q'
			

		}

	}


	// outputs number of letters entered. 
	// adds it up and will display here...
	private static boolean finalStats(int [] checkTotal) 
	{		
		System.out.println();
		System.out.println("Final Stats");
		System.out.println();
		System.out.println ("'L' Entered: " + checkTotal[1] + " times.");
		System.out.println ("'A' Entered: " + checkTotal[2] + " times.");
		System.out.println ("'C' Entered: " + checkTotal[3] + " times.");
		System.out.println ("'R' Entered: " + checkTotal[4] + " times.");
		System.out.println ("'V' Entered: " + checkTotal[5] + " times.");
		System.out.println ("'Q' Entered: " + checkTotal[6] + " times."); 
		System.out.println("Illegal Options Entered: " + checkTotal[0] + " times."); 
		System.out.println();

		return true; 

	}
	
	
	
	// custom method for outputting the file to SummerOlympicsFile.txt
	private static void finalStatsFile(int [] checkTotal) throws IOException 
	{		
		FileOutputStream ofile = new FileOutputStream ("SummerOlympicsFile.txt", false); //using FileOutputStream and PrintWriter
		PrintWriter pw = new PrintWriter (ofile); 
		
		pw.println();
		pw.println("Final Stats");
		pw.println();
		pw.println ("'L' Entered: " + checkTotal[1] + " times.");
		pw.println ("'A' Entered: " + checkTotal[2] + " times.");
		pw.println ("'C' Entered: " + checkTotal[3] + " times.");
		pw.println ("'R' Entered: " + checkTotal[4] + " times.");
		pw.println ("'V' Entered: " + checkTotal[5] + " times.");
		pw.println ("'Q' Entered: " + checkTotal[6] + " times."); 
		pw.println("Illegal Options Entered: " + checkTotal[0] + " times."); 
		pw.println();
		pw.println ("Final Stats Stored in File: SummerOlympicsFile.txt");
		
		pw.close(); //closing the file. 
		
		ofile.close();
	}


	
	
	
	//lists all athletes and their attributes
	private static void listall() 
	{	
		System.out.println();
		System.out.println("List of Participating Athletes"); 
		System.out.println();
		for(int i = 0; i < total; i++) 
		{	
			System.out.println();
			System.out.println(allPlayers[i].toStringListAll());// custom method which displays Country and name, age, revenue, venue, and sport
		}
		
		System.out.println();
		return;
	}


	
	
	
	
	// asks user to search for venues q, p, q, h, or k... "all" can be searched too
	// lists further attributes of sport the athlete plays
	// considers input failure 
	private static boolean venueReport() 
	{	
		boolean finder= false;
		System.out.println();
		System.out.println("Venue Report"); //displays all options 
		System.out.println();
		System.out.println("Please Enter:");
		System.out.println();
		System.out.println(" 'q' for Queen Elizabeth Pool");
		System.out.println();
		System.out.println(" 'p' for Prince Charles Field" );
		System.out.println();
		System.out.println(" 'w' for Prince William Arena");
		System.out.println();
		System.out.println(" 'h' for Prince Harry Beach");
		System.out.println();
		System.out.println(" 'k' for Princess Kate Stadium");
		System.out.println();
		System.out.println(" 'all' to Display All Athlete Information for Each Venue.");
		System.out.println();
		System.out.print("Enter Here -->: ");
		System.out.println();
		System.out.println();

		String selection; 
		Scanner user = new Scanner (System.in); //scans for their selection
		selection= user.next(); 

		if(selection.equals("q")) //if q then check diving, swimming, water polo, and if none, then say Unknown Water Sport...
			{
			for(int i = 0; i < total; i++) 
				{
				if(allPlayers[i].GetVenue().equals("q")) 
					{
					System.out.println();
					finder= true; 
					{
					if(allPlayers[i].GetSport().equals("diving")) 
						System.out.println (allPlayers[i].toStringVenueReport() + "\t" + "board sport");
						 
					else if(allPlayers[i].GetSport().equals("swimming")) 
						System.out.println (allPlayers[i].toStringVenueReport() + "\t" + "individual sport");
						
					else if(allPlayers[i].GetSport().equals("water polo")) 
						System.out.println (allPlayers[i].toStringVenueReport() + "\t" + "water sport");	
					}
						System.out.println (allPlayers[i].toStringVenueReport() + "  \t   " +  "Unknown Water Sport");		
					}
					
					// ran into some problem here, it always posts Unknown Water Sport, even when the water sport IS known...

				}
			}
		
		
		else if (selection.equals("all")) //if user types all, then display every athlete's first and last name + venue 
			{
				for(int k = 0; k < total; k++) 
				{
					finder= true; 
					System.out.println (allPlayers[k].toStringVenueReport());
					System.out.println();
				}
			}
	
			
		else if(selection.equals("p")) //if p then display only p athletes
					{
				for (int b=0; b < total; b++)
						if(allPlayers[b].GetVenue().equals("p"))
						{
							finder= true; 
							System.out.println (allPlayers[b].toStringVenueReport());
							System.out.println();
						}
					}

		else if (selection.equals("w")) // if w then display only w athletes
					for (int l= 0; l< total; l++)
					{
						if (allPlayers[l].GetVenue().equals ("w"))
						{
							finder= true; 
							System.out.println (allPlayers[l].toStringVenueReport());
							System.out.println();
						}
						
					}

		else if (selection.equals("h")) //if h then display only h athletes
					for (int j= 0; j< total; j++)
					{	
						if (allPlayers[j].GetVenue().equals ("h"))
						{
							finder= true; 
							System.out.println (allPlayers[j].toStringVenueReport());
							System.out.println();
						}
					}

		else if (selection.equals("k")) //if k then display only k athletes
					for (int d= 0; d< total; d++)
					{
						if (allPlayers[d].GetVenue().equals ("k"))
						{
							finder= true; 
							System.out.println (allPlayers[d].toStringVenueReport());
							System.out.println();
						}
					}

		else if (finder==false)	// else check boolean, if no legitimate venue is entered display no athlete found.
				{
					System.out.println ("No Venue Found.");
					System.out.println();
				}
 
			return true;
			}


	


	// prompts user for country
	// displays all athletes from country by last name, first name, age, and adRevenue
	// if all displays all countries' information followed by above information.
	// else displays No Country Found for input failure

	private static boolean adRevenueReport() 
	{	
		boolean finder= false; 

		System.out.println(); 
		System.out.println("AdRevenue Report"); //displays options 
		System.out.println ();
		System.out.print ("Please Enter the Athlete's Last Name You Would Like to Search For,or Enter 'all' to Display All Athlete Information: "); 
		System.out.println();
		String selection; 

		Scanner user = new Scanner (System.in); // catches their input
		selection= user.next(); 

		for (int n=0; n< total; n++) 
		{	
			if(allPlayers[n].GetLastName().equals(selection)) // if input is equal to something from array of athlete class object
			{	
				finder= true; 
				System.out.println(allPlayers[n].toStringAdRevenueReport()); //display info for that athlete, custom method in athlete class, displays exactly what is required
				System.out.println();
			}

			else if (selection.equals("all")) // if all...

			{	finder= true;
			System.out.println(allPlayers[n].toStringAdRevenueReport());
			System.out.println(); //display all info for every athlete
			}

		}
		if (finder==false)
		{
			System.out.println();
			System.out.println("No Athlete Found."); //input failure
		}

		return true; 
	}



	

	
	// country report displays last and first name, age and athlete's revenue
	// also displays average revenue for a country and total revenue for all players in a country
	private static boolean countryReport()					
	{
		String search; 
		double totRev= 0;
		double avgRev= 0; 
		boolean finder = false;
		//prompt
		System.out.println();
		System.out.println ("Country Report");
		System.out.println ();
		System.out.println ("Please Enter the Country You Would Like to Search For, or Enter 'all' to Display All Countries' Information: ");
		System.out.println();

		Scanner user = new Scanner (System.in);
		search= user.next();  //scans

		for (int j=0; j< total; j++)
		{
			if (allPlayers[j].GetCountry().equals(search)) //if equal to their input and matches the array of athlete...
			{ 
				finder= true;
				totRev+= allPlayers[j].adRevenue; //display adRevenue for all players
				avgRev= totRev/(j+1); //average revenue is total divided by number of people 
				System.out.println(allPlayers[j].toStringCountryReport()); //uses custom method in athlete class which outputs exactly what is required
				System.out.println("Total Revenue is: " + totRev+" million dollars.");
				System.out.println("Average Revenue is: "+ avgRev + " million dollars.");
				System.out.println(" ");

			} 	


			else if (search.equals("all"))
			{ 
				finder = true;
				totRev+= allPlayers[j].adRevenue; //display adRevenue for all player
				avgRev= totRev/(j+1);
				System.out.println(allPlayers[j].toStringCountryReport());
				System.out.println("Total Revenue is: " + totRev+" million dollars.");
				System.out.println("Average Revenue is: "+ avgRev + " million dollars.");//display adRevenue for all players
				System.out.println();
			}
		}
		if(finder==false) 

		{
			System.out.println ("No Country Found."); //input failure
			System.out.println(); 
		}

		return true; 

	}

	
	
	
	
	//matches last name to a specific athlete and displays last name first name and sport 
	// else returns no athlete found
	private static boolean athleteReport() 
	{
		//prompt
		System.out.println();
		System.out.println ("Athlete Report");
		System.out.println ();
		String selection; 

		System.out.print("Please Enter the Athlete's Last Name: ");

		Scanner user = new Scanner (System.in);
		selection = user.nextLine(); //takes input
		boolean finder= false;
		for (int x=0; x< total; x++)
		{
			if(allPlayers[x].GetLastName().equals(selection)) //displays information for that athlete
			{	
				finder= true;
				System.out.println();
				System.out.println(allPlayers[x].toStringAthleteReport());
				System.out.println();
				//custom method in athlete class that outputs exactly what is needed
			}

		}
		if (finder== false) //checks boolean, if no legitimate option is entered then 
		{
			System.out.println();
			System.out.println ("No Athlete Found."); 
			System.out.println();
		}
		return true; 
	}
}
