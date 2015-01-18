public class athlete {

	// constants 
	
	final int MIN_AGE = 10;
	final int MIN_ADREVENUE = 0;
	public String Country;
	public int NumAthletes;
	public String Last_Name;
	public String First_Name;
	public int age; 
	public double adRevenue;
	public String venue; 
	public String sport;

	//athlete constructor general
	
	public void athleteDefault ()
	{	
		Country= "NoCountryYet";
		Last_Name = "NoLastName";
		First_Name = "NoFirstName";
		age = 0; 
		adRevenue = 0.0;
		venue = "None";
		sport = "NoSportYet"; 
	}

	// athlete class specific 
	
	public athlete (String Country, String Last_Name, String First_Name, int age,
			double adRevenue, String venue, String sport) {

		this.Country = Country;
		this.Last_Name = Last_Name;
		this.First_Name = First_Name;
		this.age = age;
		this.adRevenue = adRevenue;
		this.venue = venue;
		this.sport = sport;

	}

	public String GetCountry() //accessor for Country
	{
		return Country;
	}

	public void SetCountry (String passedCountry) //mutator for Country
	{
		Country = passedCountry;
	}


	public String GetLastName () //accessor for Last Name
	{ 
		return Last_Name;
	}

	public void SetLastName (String passedLastName) //mutator for Last Name
	{
		Last_Name= passedLastName;
	}

	public String GetFirstName () //accessor for First Name
	{ 
		return First_Name;
	}

	public void SetFirstName(String passedFirstName) //mutator for First Name
	{
		First_Name= passedFirstName;
	}

	public int GetAge() //accessor for Age
	{ 
		return age;
	}

	public boolean SetAge (int passedAge) //mutator for Age, also sets Min Age
	{
		if (passedAge >= MIN_AGE)
		{
			age = passedAge;
			return true;
		}
		else
		{
			return false;
		}
	}

	public double GetAdRevenue () //accessor for Ad Revenue 
	{
		return adRevenue;
	}

	public void SetAdRevenue(double passedAdRevenue) //mutator for Ad Revenue, also sets Min Revenue
	{
		if (passedAdRevenue > MIN_ADREVENUE)
			adRevenue = passedAdRevenue;

		else
		{
			System.out.println("Sorry, Not a Valid Revenue.");
			System.out.println("Please Try Again.");
		}
	}


	public String GetVenue () //accessor for Venue 
	{ 
		return venue;
	}

	public void SetVenue (String passedVenue) //mutator for Venue

	{
		
		if (passedVenue == "p"|| passedVenue== "k"|| passedVenue== "w"|| passedVenue=="q"||passedVenue=="h")
			venue = passedVenue;
		else
		{
			System.out.println("The Venue You Have Entered Does Not Exist.");
			System.out.println ("Please Try Again.");
		}
	}

	public String GetSport () //accessor for sport
	{
		return sport;
	}

	public void SetSport(String passedSport) //mutator for sport 
	{
		sport= passedSport;
	}

	public void display() //has same format as socs115.txt file 
	{
		System.out.println(Country);

		for (int n= 0; n<NumAthletes; n++)
		{
			System.out.println(Last_Name+ "\t" + First_Name + "\t" + 
					age + "\t" + adRevenue + "\t"+ venue + "\t" + sport +"\t");	
		}
	}

	public String toString() // general toString method
	{
		return +age +"      \t" +adRevenue +"      \t" +venue + "      \t" +sport;
	}

	public String toStringCountry() //specific toString methods that allows data to be displayedi
	{
		return +age +"      \t" + adRevenue + "\t" +venue +" " +sport;
	}

	public String toStringCountryReport() // used in countryReport()
	{
		return Last_Name+ "     \t" + First_Name + "     " +" \t"+ age +"   \t" +adRevenue;
	}
	
	public String toStringListAll() // used in listall()
	{
		return Country + "\t    " + Last_Name+ "  \t " + First_Name + "    \t"+ age +"   \t" +adRevenue+ "\t" +venue +" " +sport;
	}

	public String toStringVenueReport() //used in venueReport () lists, venue last and first name p
	{
		return venue+ "    \t   " + Last_Name+ "   \t    " + First_Name;
	}
	
	public String toStringVenueReportLastNameFirstName() //used in venueReport () : lists last name and first name
	{
		return Last_Name+ "    \t   " + First_Name;
	}

	public String toStringAthleteReport()
	{
		return " "+ First_Name+ " " + Last_Name + " ------------" + sport;
	}
	
	public String toStringAdRevenueReport() // used in adRevenue
	{
		return Last_Name+ "    \t" + First_Name + "    \t" + adRevenue + " million";
	}
	public boolean equals (athlete player) // .equals method compares Athlete objects via String
	{

		if (player.Country==Country && player.Last_Name==Last_Name 
				&& player.First_Name==First_Name && player.age==age &&player.adRevenue==adRevenue
				&& player.venue== venue && player.sport==sport)
			return true;

		else
			return false;	
	}
}


