import java.io.*;
import java.util.*;
class AthleteTester 
{
	final static Athlete[] allPlayers = new Athlete[2000];
	static int counter = 0;
	
	public static void main(String[] args) throws IOException
	{
		final int maxAthleteNum=2000;
		final int maxCountryNum=20;

		File ifile = new File("/Users/Saaduddin/Desktop/socs115.txt");
		Scanner fileIn = new Scanner(ifile);
		Scanner keyboard = new Scanner(System.in);

		String country = fileIn.nextLine();

		while(!country.equals("END_OF_FILE")) {
			int numOfPlayers = fileIn.nextInt();

			for(int i=0; i < numOfPlayers; i++) {
				String lName = fileIn.next();
				String fName = fileIn.next();
				int age = fileIn.nextInt();
				double revenue = fileIn.nextDouble();
				char venue = fileIn.next().charAt(0);
				String sport = fileIn.nextLine();

				allPlayers[counter++] = new Athlete(country, lName, fName, age, revenue, venue, sport);
			}
			country = fileIn.nextLine();
		}

		listall();
		
		System.out.println("\nCountry: US");
		listcountry("US");





		//		System.out.print("What do you want to do next: ");
		//		//choice1=scan.next();
		//		char choice;
		//		choice=choice1.charAt(0);
		//		while (choice!='m' && choice!='M' && choice!='q' && choice!='Q')
		//		{
		//			System.out.println("Please try again!");
		//			garbage=scan.nextLine();
		//			System.out.print("Enter the choice again: ");
		//		
		//			choice1=scan.next();
		//			choice=choice1.charAt(0);
		//		}
		//		if(choice=='m' || choice=='M')
		//			menu();
		//		else if(choice=='q' || choice=='Q') 
		//			System.out.println("Hello"); 
		//			finalStats();

	}



	public static void menu() throws IOException
	{

		String option1,useless;
		int count[]=new int[7];
		Scanner scan=new Scanner(System.in);
		System.out.println("In menu() method");
		System.out.print("What do you want to do: ");
		option1=scan.next();
		char option=option1.charAt(0);
		for (int a=0;a<7 ;a++ )
		{
			count[a]=0;
		}
		while (option!='l' && option!='L' && option!='a' && option!='A' && option!='c' && option!='C' && option!='r' && option!='R' && option!='v' && option!='V' && option!='q' && option!='Q')
		{
			System.out.println("Please try again!");
			useless=scan.nextLine();
			System.out.print("Enter the choice again: ");
			option1=scan.next();
			option=option1.charAt(0);
			count[0]++;
		}
		//return count[0];

		if(option=='l' || option=='L')
		{
			listall();
			count[1]++;

			//return count[1];
		}
		else if(option=='a' || option=='A')
		{	
			athleteReport();
			count[2]++;

			//return count[2];
		}
		else if(option=='c' || option=='C')
		{
			countryReport();
			count[3]++;

			//return count[3];
		}
		else if(option=='r' || option=='R')
		{
			adRevenueReport();
			count[4]++;

			//return count[4];
		}
		else if(option=='v' || option=='V')
		{
			venueReport();
			count[5]++;

			//return count[5];
		}
		else if(option=='q' || option=='Q')
		{
			//main();
			count[6]++;

			//return count[6];
		}

		System.out.println("Number of garbage choices: " +count[0]);
		System.out.println("Number of L entered: " +count[1]);
		System.out.println("Number of A entered: " +count[2]);
		System.out.println("Number of C entered: " +count[3]);
		System.out.println("Number of R entered: " +count[4]);
		System.out.println("Number of V entered: " +count[5]);
		System.out.println("Number of Q entered: " +count[6]);

	}
	public static boolean finalStats() throws IOException
	{
		menu();
		return true;
	}
	
	public static void listall() {

		for(int i = 0; i < counter; i++) {
			System.out.println(allPlayers[i]);
		}
	}
	
	public static void listcountry(String country) {

		for(int i = 0; i < counter; i++) {
			if(allPlayers[i].getcountry().equals(country))
				System.out.println(allPlayers[i].toStringCountry());
		}
	}
	
	
	
public static boolean athleteReport()
		throws IOException
		{
	File ifile=new File("socs115.txt");
	Scanner scan=new Scanner(ifile);
	String search;
	/*int [] no_athletes=new int[2000];
		String [] country=new String[20];              
		String [][] lastname=new String[20][100];
		String [][] firstname=new String[20][100];
		int [][] age=new int[20][100];
		double [][] revenue=new double[20][100];
		String [][] venue=new String[20][100];
		String [][] sport=new String[20][100];*/
	String [] name=new String [1000];

	System.out.println("In atheleteReport() ");
	System.out.print("Enter the athlete's last name to search: ");
	Scanner scan1=new Scanner(System.in);
	search=scan1.next();
	while(scan.nextLine()!="END_OF_FILE")
	{
		/*for (int i=0;i<20 ;i++ )
			{
				country[i]=scan.next();
				no_athletes[i]=scan.nextInt();
				for (int j=0;j<no_athletes[i] ;j++ )
				{
					lastname[i][j]=scan.next();
					firstname[i][j]=scan.next();
					age[i][j]=scan.nextInt();
					revenue[i][j]=scan.nextDouble();
					venue[i][j]=scan.next();
					sport[i][j]=scan.next();
				}
			}*/
		for (int i=0;i<1000 ;i++ )
		{
			name[i]=scan.nextLine();
		}
	}
	for (int j=0;j<1000 ;j++ )
	{
		if(search.equals(name[j].substring(0,4)))
			System.out.println(name[j]);
		else
			System.out.println("No athlete found.");
	}
	/*for (int x=0;x<20 ;x++ )
			{
				for(int y=0;y<no_athletes[x];y++)
				{
				if(search.equals(lastname[x][y]))
					{
						System.out.println(country[x] +"\t" +lastname[x][y] +"\t" +firstname[x][y] +"\t" +sport[x][y]);
						return true;
					}
				else
					{
					System.out.println("No athlete found.");
					return false;
					}
				}


			}*/
	return true;
		}
public static boolean countryReport()
		throws IOException
		{
	File ifile=new File("socs115.txt");
	Scanner scan=new Scanner(ifile);
	String searchCountry;
	int [] no_athletes=new int[2000];
	String [] country=new String[20];              
	String [][] lastname=new String[20][100];
	String [][] firstname=new String[20][100];
	int [][] age=new int[20][100];
	double [][] revenue=new double[20][100];
	String [][] venue=new String[20][100];
	String [][] sport=new String[20][100];
	double total_revenue=0,average_revenue=0;

	System.out.println("In countryReport()");
	System.out.print("Enter the country name to search or enter 'all' to display everything: ");
	Scanner scan1=new Scanner(System.in);
	searchCountry=scan1.next();
	while(scan.nextLine()!="END_OF_FILE")
	{
		for (int i=0;i<20 ;i++ )
		{
			country[i]=scan.next();
			no_athletes[i]=scan.nextInt();
			for (int j=0;j<no_athletes[i] ;j++ )
			{
				lastname[i][j]=scan.next();
				firstname[i][j]=scan.next();
				age[i][j]=scan.nextInt();
				revenue[i][j]=scan.nextDouble();
				venue[i][j]=scan.next();
				sport[i][j]=scan.next();
			}
		}
	}
	for (int x=0;x<20 ;x++ )
	{
		for(int y=0;y<100;y++)
		{
			if(searchCountry.equals(country[x]))
			{
				System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t" +age[x][y] +"\t" +revenue[x][y]);
				total_revenue+=revenue[x][y];
				average_revenue=total_revenue/no_athletes[x];
				System.out.println("Total revenue of" +country[x] +"is: " +total_revenue);
				System.out.println("Average revenue of" +country[x] +"is: " +average_revenue);
				return true;
			}
			else if (searchCountry.equals("all"))
			{
				System.out.println(country[x]);
				System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t" +age[x][y] +"\t" +revenue[x][y]);
				total_revenue+=revenue[x][y];
				average_revenue=total_revenue/no_athletes[x];
				System.out.println("Total revenue of" +country[x] +" is: " +total_revenue);
				System.out.println("Average revenue of" +country[x] +" is: " +average_revenue);
				return true;
			}
			else
			{
				System.out.println("No country found.");
				return false;
			}
		}


	}
	return true;

		}

public static boolean adRevenueReport()
		throws IOException
		{
	File ifile=new File("socs115.txt");
	Scanner scan=new Scanner(ifile);
	String searchname;
	int [] no_athletes=new int[2000];
	String [] country=new String[20];              
	String [][] lastname=new String[20][100];
	String [][] firstname=new String[20][100];
	int [][] age=new int[20][100];
	double [][] revenue=new double[20][100];
	String [][] venue=new String[20][100];
	String [][] sport=new String[20][100];
	double total_revenue=0,average_revenue=0;

	System.out.println("In adRevenueReport()");
	System.out.print("Enter the lastname to search or enter 'all' to display everything: ");
	Scanner scan1=new Scanner(System.in);
	searchname=scan1.next();
	while(scan.nextLine()!="END_OF_FILE")
	{
		for (int i=0;i<20 ;i++ )
		{
			country[i]=scan.next();
			no_athletes[i]=scan.nextInt();
			for (int j=0;j<no_athletes[i] ;j++ )
			{
				lastname[i][j]=scan.next();
				firstname[i][j]=scan.next();
				age[i][j]=scan.nextInt();
				revenue[i][j]=scan.nextDouble();
				venue[i][j]=scan.next();
				sport[i][j]=scan.next();
			}
		}
	}
	for (int x=0;x<20 ;x++ )
	{
		for(int y=0;y<100;y++)
		{
			if(searchname.equals(lastname[x]))
			{
				System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t" +age[x][y] +"\t" +revenue[x][y]);
				return true;
			}
			else if (searchname.equals("all"))
			{

				System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t" +age[x][y] +"\t" +revenue[x][y]);

				return true;
			}
			else
			{
				System.out.println("No athlete found.");
				return false;
			}
		}


	}
	return true;
		}
public static boolean venueReport()
		throws IOException
		{
	File ifile=new File("socs115.txt");
	Scanner scan=new Scanner(ifile);
	String searchvenue;
	int [] no_athletes=new int[2000];
	String [] country=new String[20];              
	String [][] lastname=new String[20][100];
	String [][] firstname=new String[20][100];
	int [][] age=new int[20][100];
	double [][] revenue=new double[20][100];
	String [][] venue=new String[20][100];
	String [][] sport=new String[20][100];
	double total_revenue=0,average_revenue=0;

	System.out.println("In venueReport()");
	System.out.print("Enter the venue to search or enter 'all' to display everything: ");
	Scanner scan1=new Scanner(System.in);
	searchvenue=scan1.next();
	while(scan.nextLine()!="END_OF_FILE")
	{
		for (int i=0;i<20 ;i++ )
		{
			country[i]=scan.next();
			no_athletes[i]=scan.nextInt();
			for (int j=0;j<no_athletes[i] ;j++ )
			{
				lastname[i][j]=scan.next();
				firstname[i][j]=scan.next();
				age[i][j]=scan.nextInt();
				revenue[i][j]=scan.nextDouble();
				venue[i][j]=scan.next();
				sport[i][j]=scan.next();
			}
		}
	}
	for (int x=0;x<20 ;x++ )
	{
		for(int y=0;y<100;y++)
		{
			if(searchvenue.equals(venue[x][y]))
			{
				if(searchvenue.equals("q"))
				{
					if(sport[x][y].equals("diving"))
						System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t board sport") ;

					else if(sport[x][y].equals("swimming"))
						System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t individual sport") ;
					else if(sport[x][y].equals("water polo"))
						System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t team sport") ;
					else
						System.out.println(lastname[x][y] +"\t" +firstname[x][y] +"\t unknown water sport") ;
				}
				else if(searchvenue.equals("p") )
					System.out.println(lastname[x][y] +"\t" +firstname[x][y]);
				else if(searchvenue.equals("w") )
					System.out.println(lastname[x][y] +"\t" +firstname[x][y]);
				else if(searchvenue.equals("h") )
					System.out.println(lastname[x][y] +"\t" +firstname[x][y]);
				else 
					System.out.println(lastname[x][y] +"\t" +firstname[x][y]);
			}
			else if(searchvenue.equals("all") )
				System.out.println(lastname[x][y] +"\t" +firstname[x][y] + "\t" +venue[x][y]);
			else
			{
				System.out.println("No venue found.");
				return false;
			}
		}
	}



	return true;
		}
}