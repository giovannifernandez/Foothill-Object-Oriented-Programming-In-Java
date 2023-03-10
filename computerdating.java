public class Foothill
{
public static void main(String[] args)
{
 {
    // Instantiating a total of four DateProfile objects using an array
    DateProfile applicant1 = new DateProfile('F', 'F', 3, 5, 7, "Sarah Somebody"
     );
    DateProfile applicant2 = new DateProfile('M', 'F', 2, 6, 8, "Steve Nobody");
    DateProfile applicant3 = new DateProfile('F', 'M', 6, 5, 4, "Jane Peabody");
    DateProfile applicant4 = new DateProfile('F', 'F', 2, 3, 4, "Helen Anybody"
     );

    // applicant1/Sarah Somebody
    displayTwoProfiles(applicant1, applicant1);
    displayTwoProfiles(applicant1, applicant2);
    displayTwoProfiles(applicant1, applicant3);
    displayTwoProfiles(applicant1, applicant4);
    System.out.println("\n");
    
    // applicant2/Steve Nobody
    displayTwoProfiles(applicant2, applicant1);
    displayTwoProfiles(applicant2, applicant2);
    displayTwoProfiles(applicant2, applicant3);
    displayTwoProfiles(applicant2, applicant4);
    System.out.println("\n");
    
    // applicant3/Jane Peabody
    displayTwoProfiles(applicant3, applicant1);
    displayTwoProfiles(applicant3, applicant2);
    displayTwoProfiles(applicant3, applicant3);
    displayTwoProfiles(applicant3, applicant4);
    System.out.println("\n");
    
    // applicant4/Helen Anybody
    displayTwoProfiles(applicant4, applicant1);
    displayTwoProfiles(applicant4, applicant2);
    displayTwoProfiles(applicant4, applicant3);
    displayTwoProfiles(applicant4, applicant4);
    System.out.println("\n"); 
    
    // Mutator test at the end
    if ( applicant2.setGender('A'))
       System.out.println("A accepted as gender");
    else
       System.out.println("A rejected as gender");
 }
}

//Method that prints names of the two objects and displays fit value
static void displayTwoProfiles(DateProfile profile1, DateProfile profile2)
{
   System.out.println("Fit between " + profile1.getName() + " and " +
   profile2.getName() + ":" +  + profile1.calculateFit(profile2));
 }
}

//Creating class DateProfile with private instance members
class DateProfile
{
   // Private data
   private char gender;
   private char searchGender;
   private int romance;
   private int finance;
   private int distance;
   private String name;

   // Public static constants
   public static final int DEFAULT_FINANCE = 1;
   public static final int DEFAULT_ROMANCE = 1;
   public static final int DEFAULT_DISTANCE = 1;
   public static final char DEFAULT_GENDER = 'M';
   public static final char DEFAULT_SEARCH_GENDER = 'F';
   public static final String DEFAULT_NAME = "(undefined)";

   // Symbolic constants
   public static final int MIN_ROMANCE = 1;
   public static final int MAX_ROMANCE = 10;
   public static final int MIN_NAME_LENGTH = 3;
   public static final int MAX_NAME_LENGTH = 50;

// Accessors
 char getGender(){return gender;}
 char getSearchGender(){return searchGender;}
 int getRomance(){return romance;}
 int getFinance(){return finance;}
 int getDistance(){return distance;}
 String getName(){return name;}  
      
// Constructors
DateProfile()
{
   setDefaults();
}
DateProfile(char gndr, char searchGender, int rom, int fin, int dist, String num
      )
{
   setDefaults();
   setAll(gndr, searchGender, rom, fin, dist, num);
}

// Mutators
void setAll(char gndr, char searchGender, int rom, int fin, int dist, String num
      )
{
   setGender(gndr);
   setSearchGender(searchGender);
   setRomance(rom);
   setFinance(fin);
   setDistance(dist);
   setName(num);
}
void setDefaults()
{
   gender = DEFAULT_GENDER;
   searchGender = DEFAULT_SEARCH_GENDER;
   finance = DEFAULT_FINANCE;
   romance = DEFAULT_ROMANCE;
   distance = DEFAULT_DISTANCE;
   name = DEFAULT_NAME;
}
boolean setGender(char gndr)
{
   if (!validGender(gndr))
      return false;
   gender = Character.toUpperCase(gndr);
   return true;
}
static private boolean validGender(char gndr)
{
   char newGender = Character.toLowerCase(gndr);
   if (newGender != 'm' && newGender != 'f')
      return false;
   else
      return true;
}
boolean setSearchGender(char gndr)
{
   if (!validGender(gndr))
      return false;
   searchGender = Character.toUpperCase(gndr);
   return true;
}
boolean setRomance(int romvalue)
{
   if (romvalue < MIN_ROMANCE || romvalue > MAX_ROMANCE)
      return false;
   romance = romvalue;
   return true;
}
boolean setFinance(int finvalue)
{
   if (finvalue < MIN_ROMANCE || finvalue > MAX_ROMANCE)
      return false;
   finance = finvalue;
   return true;
}
boolean setDistance(int disvalue)
{
   if (disvalue < MIN_ROMANCE || disvalue > MAX_ROMANCE)
      return false;
   distance = disvalue;
   return true;
}
boolean setName(String num)
{
   if (num.length() < MIN_NAME_LENGTH || num.length() > MAX_NAME_LENGTH)
      return false;
   name = num;
   return true;
}
      
//Gender Fit
private double determineGenderFit(DateProfile partner)
{
   if (searchGender != partner.gender)
      return 0.0;
   if (partner.searchGender != gender)
      return 0.0;
   return 1.0;
}
      
//Romance Fit
private double determineRomanceFit (DateProfile partner)
{
   int romanceVal;
   int partnerVal;
   int difference;
   double fit;
   romanceVal = romance;
   partnerVal = partner.romance;
   difference = Math.abs(romanceVal - partnerVal);
   fit = MAX_ROMANCE - difference;
   fit = (fit - 1)*(9.9/9);
   fit += .1;
   fit = fit/(double)MAX_ROMANCE;
   return fit;
}

//Finance Fit
private double determineFinanceFit(DateProfile partner)
{
   int romanceVal;
   int partnerVal;
   int difference;
   double fit;
   romanceVal = finance;
   partnerVal = partner.finance;
   difference = Math.abs(romanceVal-partnerVal);
   fit = MAX_ROMANCE-difference;
   fit = (fit-1)*(9.9/9);
   fit += .1;
   fit = fit/(double)MAX_ROMANCE;
   return fit;
} 

//Distance Fit
private double determineDistanceFit(DateProfile partner)
{
   int romanceVal;
   int partnerVal;
   int difference;
   double fit;
   romanceVal = distance;
   partnerVal = partner.distance;
   difference = Math.abs(romanceVal-partnerVal);
   fit = MAX_ROMANCE-difference;
   fit = (fit - 1)*(9.9/9);
   fit += .1;
   fit = fit/(double)MAX_ROMANCE;
   return fit;
}

//Calculate Fit
public double calculateFit(DateProfile partner)
{
   double genderResult;
   double romanceResult; 
   double financeResult;
   double distanceResult;
   double returnResult;
   genderResult = determineGenderFit(partner);
   romanceResult = determineRomanceFit(partner);
   financeResult = determineFinanceFit(partner);
   distanceResult = determineDistanceFit(partner);
   returnResult = genderResult * (romanceResult + financeResult +
   distanceResult)/3.;
   return returnResult;
 }
}

/* ---------- Sample Run -------------
Fit between Sarah Somebody and Sarah Somebody:1.0
Fit between Sarah Somebody and Steve Nobody:0.0
Fit between Sarah Somebody and Jane Peabody:0.0
Fit between Sarah Somebody and Helen Anybody:0.7799999999999999


Fit between Steve Nobody and Sarah Somebody:0.0
Fit between Steve Nobody and Steve Nobody:0.0
Fit between Steve Nobody and Jane Peabody:0.6699999999999999
Fit between Steve Nobody and Helen Anybody:0.0


Fit between Jane Peabody and Sarah Somebody:0.0
Fit between Jane Peabody and Steve Nobody:0.6699999999999999
Fit between Jane Peabody and Jane Peabody:0.0
Fit between Jane Peabody and Helen Anybody:0.0


Fit between Helen Anybody and Sarah Somebody:0.7799999999999999
Fit between Helen Anybody and Steve Nobody:0.0
Fit between Helen Anybody and Jane Peabody:0.0
Fit between Helen Anybody and Helen Anybody:1.0


A rejected as gender
 --------------------------------------*/
