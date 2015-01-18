//Saad Mahmood
//Section 001
//ID # A20266900


import java.util.*;
import java.io.*;

	public class Olympics
	{
		final static int MAX_ATHLETES= 2000; 
		final static int MAX_VENUES = 6;
		final static int MAX_SPORTS = 15;
		final static int MAX_NUM_COUNTRIES= 20;
		final static int MAX_NUM_PER = 100;
	
	public static void main (String [] args) throws IOException
	
	{
		File ifile = new File ("socs115.txt");
		Scanner scan = new Scanner(ifile);
		Scanner user = new Scanner (System.in); 
				
		athlete [] player = new athlete [MAX_NUM_COUNTRIES];
		
			for (int i = 0; i<MAX_NUM_COUNTRIES; i++)
			{
				player[i]= new athlete(); 
			
			while (scan.nextLine() != "END_OF_FILE")
			
				{	
					for (int j= 0; j< MAX_NUM_COUNTRIES; j++)	//sets for loop to read country and num athletes first... 
				
						player [i].Country = scan.nextLine();
						player [i].NumAthletes = scan.nextInt();
			
						{
							for (int h = 0; h < MAX_ATHLETES; h++)	//... assigns attributes later
								player[i].Last_Name= scan.next();
								player[i].First_Name = scan.next();
								player[i].age= scan.nextInt();
								player[i].adRevenue= scan.nextDouble(); 
								player[i].venue= scan.next();
								player[i].sport= scan.next();
						}
				}
			}
			
						
		//Inputting file socs115.txt
		
		//Menu Option
		System.out.print("Please Enter 'M' for Menu or 'Q' for Final Stats:");
		
		String option;
		char selection; 
		
		option= user.next(); 
		selection=option.charAt(0); 
		
		while (selection != 'M' && selection!= 'm' && selection != 'Q' && selection != 'q')
			{
				System.out.println ("Please Try Again.");
				System.out.println ("Please Enter 'M' for Menu or 'Q' for Final Stats:");
	
				option= user.next();
				selection=option.charAt(0); 
			}
		switch (selection)
			{
			case 'm':		
			case 'M':
				menu ();
				break;
				
			case 'q':
			case 'Q':
				finalStats ();
				break;
			}
		}

	//method finalStats();
	// lists the number of times menu option has been entered

	
	
	private static boolean finalStats() throws IOException
	{		
			menu();
			return true; 
	}


	//method menu. breaks down even further into more methods.	
	private static void menu() throws IOException 
		{	
		File ifile = new File ("socs115.txt");
		Scanner scan = new Scanner (ifile);
		Scanner user = new Scanner (System.in);
		String option;
		char selection; 
		int total []= new int [7];
		
		System.out.println("Menu Method");
		System.out.println("Please Enter:");
		System.out.println(" 'l' for a List of Athlete Attributes,");
		System.out.println(" 'a' for an Athlete Search," );
		System.out.println(" 'c' for a Country Search,");
		System.out.println(" 'r' for an Athlete's Revenue Search,");
		System.out.println(" 'v' for a Venue Search,");
		System.out.println(" 'q' to return back to Main Menu,");
		
		System.out.print( "Enter Here -->: "); 
		
		option= user.next(); 
		selection=option.charAt(0); 
		
		for (int a=0; a < 7; a++)
		{
			total [a]= 0;
		}
		while ( selection != 'L' && selection!= 'l' && selection != 'A' && selection != 'a' && 
				selection != 'C' && selection!= 'c' && selection != 'R' && selection != 'r' && 
				selection != 'V' && selection!= 'V' && selection != 'Q' && selection != 'q' )
		
		{ 
			System.out.print ("Sorry. Please Enter a Valid Option:");
			option= user.next();
			selection = option.charAt(0);
			total [0]++;
		}
			
			switch (selection) //switch-case that checks for what method to enter	
				
				{
					case 'l':
					case 'L':
						listall();
						total[1]++;
						//System.out.println ("Number of Times 'L' Has Been Entered:" + total[1]);
						break;
			
					case 'a':
					case 'A':
						athleteReport();
						total[2]++;
						//System.out.println ("Number of Times 'A' Has Been Entered:" + total[2]);
						break; 
						
					
					case 'c':
					case 'C':
						countryReport();
						total[3]++;
						//System.out.println ("Number of Times 'C' Has Been Entered:" + total[3]);
						break;
						
					case 'r':
					case 'R':
						adRevenueReport();
						total[4]++;
						//System.out.println ("Number of Times 'A' Has Been Entered:" + total[4]);
						break;
						
					case 'v':
					case 'V':
						venueReport();
						total[5]++;
						//System.out.println ("Number of Times 'V' Has Been Entered:" + total[5]);
						break;
					
					case 'q':
					case 'Q':
						//main();
						total[6]++;
						//System.out.println ("Number of Times 'Q' Has Been Entered:" + total[6]);
						
						System.out.println ("'L' Entered: " + total[1] + " times.");
						System.out.println ("'A' Entered: " + total[2] + " times.");
						System.out.println ("'C' Entered: " + total[3] + " times.");
						System.out.println ("'R' Entered: " + total[4] + " times.");
						System.out.println ("'V' Entered: " + total[5] + " times.");
						System.out.println ("'Q' Entered: " + total[6] + " times."); 
						System.out.println("Illegal Options Entered: " + total[0] + " times."); 
						
					break;
				
				}
		}
		

	// asks user to search for venues q, p, q, h, or k... "all" can be searched too
	// lists further attributes of sport the athlete plays
	// considers input failure 
	
		private static boolean venueReport() throws IOException
		{	
			System.out.println("Venue Report");
			System.out.println("Please Enter:");
			System.out.println(" 'q' for Queen Elizabeth Pool,");
			System.out.println(" 'p' for Prince Charles Field," );
			System.out.println(" 'w' for Prince William Arena,");
			System.out.println(" 'h' for Prince Harry Beach,");
			System.out.println(" 'k' for Princess Kate Stadium, or");
			System.out.println(" 'all' to Display All Athlete Information for Each Venue:");
			System.out.print("Enter Here -->: ");
			
			String selection; 
		
			File ifile = new File ("socs115.txt");
			Scanner scan = new Scanner (ifile);
			String Country [] = new String [20];
			int NumAthletes []= new int [2000];
			String Last_Name []= new String [2000];
			String First_Name []= new String [2000];
			int age[]= new int [2000]; 
			double adRevenue []= new double [2000];
			String venue[]= new String [2000]; 
			String sport[]= new String [2000];		
		
			Scanner user = new Scanner (System.in);
			selection= user.next(); 

			 
				while (scan.nextLine() != "END_OF_FILE")
				{
					for (int i=0;i<MAX_NUM_COUNTRIES; i++)
						{
							Country [i]= scan.next();
							NumAthletes[i]= scan.nextInt();
					
							for (int k=0; k<NumAthletes[i]; k++)
							{
							
								Last_Name [i] = scan.next();
								First_Name [i] = scan.next();
								age [i]=scan.nextInt();
								adRevenue [i]= scan.nextDouble(); 
								venue[i]= scan.next();
								sport[i]= scan.next();
							}
						}
				}
					for (int j=0; j< MAX_NUM_COUNTRIES; j++)
						
						{	
							for (int q = 0; q< MAX_NUM_PER; q++)
							
							{	
								if (selection.equals (venue[i]))
								{
									if (selection.equals ("q"))
											{	
											if (sport[i].equals ("diving"))
												System.out.println (Last_Name+ "\t" + First_Name + "\t" + "board sport");	
										
											else if (sport[i].equals ("swimming"))
												System.out.println (Last_Name+ "\t" + First_Name + "\t" + "individual sport");
										
											else if (sport[i].equals("water polo"))
												System.out.println (Last_Name+ "\t" + First_Name + "\t" + "team sport");
										
											else 
												System.out.println (Last_Name+ "\t" + First_Name + "\t" + "Unknown Water Sport");		
											}
									
									else if (selection.equals ("k"))
										System.out.println (Last_Name+ "\t" + First_Name);
									
									else if (selection.equals ("p"))
										System.out.println (Last_Name+ "\t" + First_Name);
									
									else if (selection.equals ("h"))
										System.out.println (Last_Name+ "\t" + First_Name);
									
									else if (selection.equals ("w"))
										System.out.println (Last_Name+ "\t" + First_Name);
								
								}
							
									else if (selection.equals ("all"))
										System.out.println (Last_Name+ "\t" + First_Name + "\t" + venue[i]);
							
									else	
										System.out.println ("No Venue Found.");
										return false;
						}
							
										return true;
						}
	}
		

	// prompts user for last name they'd like to search for, or "all" 
	// displays athlete that matches inputed last name along with their revenues
	// considers input failure 
	
	
		
		

		private static boolean adRevenueReport() throws IOException
		
		{ 
		System.out.println("AdRevenue Report");
		System.out.print ("Please Enter the Athlete's Last Name You Would Like to Search For,or Enter 'all' to Display All Athlete Information: "); 
		String selection; 
	
		
		File ifile = new File ("socs115.txt");
		Scanner scan = new Scanner (ifile);
		String Country [] = new String [20];
		int NumAthletes []= new int [2000];
		String Last_Name []= new String [2000];
		String First_Name []= new String [2000];
		int age[]= new int [2000]; 
		double adRevenue []= new double [2000];
		String venue[]= new String [2000]; 
		String sport[]= new String [2000];		
		System.out.println ("Country Report");
		System.out.println ("Please Enter the Athlete's Last Name You Would Like to Search For, or Enter 'all' to Display All Athlete Information: ");
		
		Scanner user = new Scanner (System.in);
		selection= user.next(); 

		 
			while (scan.nextLine() != "END_OF_FILE")
			{
				for (int i=0;i<MAX_NUM_COUNTRIES; i++)
					{
						Country [i]= scan.next();
						NumAthletes[i]= scan.nextInt();
				
						for (int k=0; k<NumAthletes[i]; k++)
						{
						
							Last_Name [i] = scan.next();
							First_Name [i] = scan.next();
							age [i]=scan.nextInt();
							adRevenue [i]= scan.nextDouble(); 
							venue[i]= scan.next();
							sport[i]= scan.next();
						}
					}
			}
				for (int j=0; j< MAX_NUM_COUNTRIES; j++)
					
					{	
						for (int q = 0; q< MAX_NUM_PER; q++)
						
						{	
							if (selection.equals (Last_Name[i]))
							
							{
								System.out.println(Last_Name+ "\t" + First_Name + "\t"  + adRevenue);
							}
						
						else if (selection.equals ("all"))
						
							{
								System.out.println(Last_Name+ "\t" + First_Name + "\t" + adRevenue);	
							}
						else 
							{	
							System.out.println ("No Athlete Found.");
							return false;
							}
						}
					}
				return true;
		}
	// prompts user for country they'd like to search for, or "all"
	// displays last name, first name,age, and ad revenue, displays total ad revenue and average ad revenue
	// considers input failure 
	
	
	
	
	
	private static boolean countryReport() 
		{
		String search; 
		double totRev= 0;
		double avgRev= 0; 
		//avgRev = Country[i]/ NumAthletes[i];
		
		File ifile = new File ("socs115.txt");
		Scanner scan = new Scanner (ifile);
		String Country [] = new String [20];
		int NumAthletes []= new int [2000];
		String Last_Name []= new String [2000];
		String First_Name []= new String [2000];
		int age[]= new int [2000]; 
		double adRevenue []= new double [2000];
		String venue[]= new String [2000]; 
		String sport[]= new String [2000];		
		System.out.println ("Country Report");
		System.out.println ("Please Enter the Country You Would Like to Search For, or Enter 'all' to Display All Countries: ");
		
		Scanner user = new Scanner (System.in);
		search= user.next(); 

		 
			while (scan.nextLine() != "END_OF_FILE")
			{
				for (int i=0;i<MAX_NUM_COUNTRIES; i++)
					{
						Country [i]= scan.next();
						NumAthletes[i]= scan.nextInt();
				
						for (int k=0; k<NumAthletes[i]; k++)
						{
						
							Last_Name [i] = scan.next();
							First_Name [i] = scan.next();
							age [i]=scan.nextInt();
							adRevenue [i]= scan.nextDouble(); 
							venue[i]= scan.next();
							sport[i]= scan.next();
						}
					}
			}
				for (int j=0; j< MAX_NUM_COUNTRIES; j++)
					
					{	for (int q = 0; q< MAX_NUM_PER; q++)
						{
						if (search.equals (Country[i]))
						{
							System.out.println(Country);
							System.out.println(NumAthletes);
							System.out.println(Last_Name+ "\t" + First_Name + "\t" + age + 
							"\t" + adRevenue + "\t"+ venue + "\t" + sport +"\t");	
							
							System.out.println ("Total Revenue of" + Country[i] +"is" + totRev  + ".");
							System.out.println ("Average Revenue of" + Country[i] +"is"+ avgRev + ".");
						}
						
						else if (search.equals ("all"))
						{
							listall(); 
						}
						else 
							System.out.println ("No Country Found.");
						return false;
						
						}
					}
				return true;
		}

	// prompts user for last name search
	// displays country, last name, first name, and sport 
	// considers input failure
	
	
	
	
	
	
	
	private static boolean athleteReport() throws IOException
		{
		System.out.println ("Athlete Report");
		File ifile = new File ("socs115.txt");
		Scanner scan = new Scanner (ifile);
		
		String relay;
		String selection; 
		String Country [] = new String [20];
		int NumAthletes []= new int [2000];
		String Last_Name []= new String [2000];
		String First_Name []= new String [2000];
		int age[]= new int [2000]; 
		double adRevenue []= new double [2000];
		String venue[]= new String [2000]; 
		String sport[]= new String [2000];		
		
		System.out.println("Athlete Report");
		System.out.print( "Please Enter the Athlete's Last Name: ");
		
		Scanner user = new Scanner (System.in);
		selection = user.nextLine(); 
	
		athlete [] player = new athlete [MAX_NUM_COUNTRIES];
		
		 for (int p=0;p<MAX_NUM_COUNTRIES;p++  )
		 {
					 
			 Country[p] = scan.next();
			 NumAthletes[p]= scan.nextInt();

			 for (int l=0;l<MAX_ATHLETES;l++ )
			 {
				First_Name [l] = scan.next();
				Last_Name [l] = scan.next();
				age [l]=scan.nextInt();
				adRevenue [l]= scan.nextDouble(); 
				venue[l]= scan.next();
				sport[l]= scan.next();
			 }
			 
			 for (int k = 0; k<MAX_NUM_COUNTRIES; k++)
			 {
				 for (int j =0; j < MAX_ATHLETES; j++)
				 {
					 if (relay.equals(Last_Name[p]))
							 {		 System.out.println (Country[k]+ "\t" + NumAthletes[p] + "\t" + 
									 First_Name[l]+ "\t" + Last_Name [l] + "\t" + age [l] + 
									 "\t" + venue[l] + "\t"+ sport[l]);
						 			
							 return true;
							 }		
			 		else
					 	{		
			 				System.out.println("No Athlete Found.");
			 				return false; 
					 	}
				 		
			}
			
			 return true; 

		 }
	}
}

	// lists out all athletes' names, countries, ages, revenues, venues, and sport
	//basically pulls from socs.115.txt

	
	
	
	
	
	
	private static boolean listall() throws IOException
		{
			File ifile = new File ("socs115.txt");
			Scanner scan = new Scanner (ifile);
			String Country [] = new String [20];
			int NumAthletes []= new int [2000];
			String Last_Name []= new String [2000];
			String First_Name []= new String [2000];
			int age[]= new int [2000]; 
			double adRevenue []= new double [2000];
			String venue[]= new String [2000]; 
			String sport[]= new String [2000];			
			

			while (scan.nextLine() != "END_OF_FILE")
				{
					for (int i=0;i<MAX_NUM_COUNTRIES; i++)
						{
							Country [i]= scan.next();
							NumAthletes[i]= scan.nextInt();
					
					for (int k=0; k<NumAthletes[i]; k++)
						{
							First_Name [i] = scan.next();
							Last_Name [i] = scan.next();
							age [i]=scan.nextInt();
							adRevenue [i]= scan.nextDouble(); 
							venue[i]= scan.next();
							sport[i]= scan.next();
						}
				}
					for (int j=0; j< MAX_NUM_COUNTRIES; j++)
						
					{	
						System.out.println(Country);
						System.out.println(NumAthletes);
						System.out.println(Last_Name+ "\t" + First_Name + "\t" + age + 
								"\t" + adRevenue + "\t"+ venue + "\t" + sport +"\t");	
					}
					
			
						}
				return true; 
		}

	}

		


