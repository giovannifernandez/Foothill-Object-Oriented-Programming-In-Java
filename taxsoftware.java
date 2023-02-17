public class Tax
{
// An int, that is one of the four tax-filing status
   private int filingStatus;
   
// Public static constants to represent the statuses
   public static int SINGLE_FILER = 0;
   public static int MARRIED_JOINTLY_OR_QUAL_WIDOWER = 1;
   public static int MARRIED_SEPARATELY = 2;
   public static int HEAD_OF_HOUSEHOLD = 3;

// A double array of ints, that stores the tax brackets for each filing statuses
   private int[][] brackets;
// An array of doubles, that stores the tax rates for each bracket
   private static double[] rates;
// A double, that stores the taxable income
   private double taxableIncome ;

// Accessors and mutators for all
public void setRates(double []rates)
{
   for(int a = 0;a < 6;a ++ )
{
   Tax.rates[a] = rates[a];
 }
}
public int[][] getBrackets()
{
   return this.brackets;
}
public void setBrackets(int [][]brackets)
{
   for(int a = 0;a < 4;a ++ )
{
   for(int b = 0;b < 6;b ++ )
{
   this.brackets[a][b] = brackets[a][b];
  }
 }
}
public double getTaxableIncome()
{
   return this.taxableIncome;
}
public void setTaxableIncome(double taxableIncome)
{
   this.taxableIncome=taxableIncome;
}
public int getFilingStatus()
{
   return this.filingStatus;
}
public void setFilingStatus(int filingStatus)
{
   this.filingStatus = filingStatus;
}
public double[] getRates()
{
   return Tax.rates;
}  

// Constructor that takes no parameters 
public Tax()
{
   filingStatus = 0;
   brackets = new int[4][6];
   rates = new double[6];
   taxableIncome = 0;
}

// Constructor that takes parameters 
public Tax(int filingStatus,int brackets[][],int rates[],double taxableIncome)
{
   this.filingStatus = filingStatus;
   for(int a = 0;a < 4;a ++ )
{
   for(int b = 0;b < 6;b ++ )
{
   this.brackets[a][b]=brackets[a][b];
 }
}
   for(int a = 0;a < 6;a ++ )
{
   Tax.rates[a] = rates[a];
}
   this.taxableIncome = taxableIncome;
}

//Call getTax() for each of the incoming years and return the difference 
//between the two tax amounts
public int getTax()
{
   int value = 0;
   while(value < 6)
{
   if(taxableIncome > brackets[filingStatus][value])
{
   value ++ ;
}
   else
{
   break;
 }
}
   if(value == 0)
{
   return (int) Math.round(taxableIncome * rates[0]);
}
   int tax = (int) Math.round(brackets[filingStatus][0] * rates[0]);
   for(int a = 1;a < value;a ++ )
{
   tax += (int)Math.round((brackets[filingStatus][a]
         - brackets[filingStatus][a - 1]) * rates[a]);
}
   if(value == 6)
{
   tax += (int)Math.round((taxableIncome
         - brackets[filingStatus][value]) * rates[value]);
}
   else
{
   tax += (taxableIncome - brackets[filingStatus][value - 1]) * rates[value];
}
   return tax;
}

//String toString(), that will create and return a printable string with 
//values of filingStatus, taxableIncome, and amount from getTax()
public String toString() 
{
   return Integer.toString(filingStatus) + " " + Double.toString(taxableIncome) 
   + " " + Integer.toString(getTax());
}

// Double[] rates = {0.10, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};
// Brackets for each rate for all the filing statuses can be represented 
// in a two-dimensional array
public static void main(String[] args)
{
   double[] newRates = {0.10,0.12,0.22,0.24,0.32,0.35,0.37};
   double[] oldRates = {0.10,0.15,0.25,0.28,0.33,0.35,0.396};
   
   int[][] oldBracket = 
   {{9275, 37650, 91150, 190150, 413350, 415050},
   {18550, 75300, 151900, 231450, 413350, 466950},
   {9275, 37650, 75950,115725, 206675, 233475},
   {13250, 50400, 130150, 210800, 413350, 441000}};

   int[][] newBracket =
   {{9275, 38700, 82500, 157000, 200000, 500000},
   {19050, 77400, 165000, 315000, 400000, 600000},
   {9525, 38700, 82000, 157000, 200000, 300000},
   {13600, 51800, 82500, 157500, 200000, 500000}};

   Tax newRateYear = new Tax();
   Tax oldRateYear = new Tax();

   newRateYear.setRates(newRates);
   oldRateYear.setRates(oldRates);
   newRateYear.setBrackets(newBracket);
   oldRateYear.setBrackets(oldBracket);
   
   System.out.println("Cost difference: $" 
         + compareTax(newRateYear, oldRateYear, SINGLE_FILER, 80000) 
         + ("\n"));
   System.out.println("Cost difference: $" 
         + compareTax(newRateYear, oldRateYear, SINGLE_FILER, 150000) 
         + ("\n"));
   System.out.println("Cost difference: $" 
         + compareTax(newRateYear, oldRateYear, 
               MARRIED_JOINTLY_OR_QUAL_WIDOWER, 450000) 
         + ("\n"));
   System.out.println("Cost difference: $" 
         + compareTax(newRateYear, oldRateYear, 
               MARRIED_JOINTLY_OR_QUAL_WIDOWER, 140000) 
         + ("\n"));
   System.out.println("Cost difference: $" 
         + compareTax(newRateYear, oldRateYear, HEAD_OF_HOUSEHOLD, 100000) 
         + ("\n"));
   }

// Will change the filing status value and the taxable income amount in objects
static int compareTax(Tax newRateYear, Tax oldRateYear, int fStatus, 
      int taxableIncome)
{
   newRateYear.setTaxableIncome(taxableIncome);
   oldRateYear.setTaxableIncome(taxableIncome);
   newRateYear.setFilingStatus(fStatus);
   oldRateYear.setFilingStatus(fStatus);
   
   int difference; 
   int oldTax = newRateYear.getTax();
   int newTax = oldRateYear.getTax();
   
   if(oldTax > newTax)
{
   System.out.println("Year 2016 cost: $"
         + taxableIncome);
   difference = oldTax - newTax;
}
   else
{
  System.out.println("Year 2020 cost: $"
        + taxableIncome);
  difference = newTax - oldTax;
}
  return difference;
 }
}

/* --------------------- Run -------------------
Year 2020 cost: $80000
Cost difference: $104

Year 2016 cost: $150000
Cost difference: $155

Year 2020 cost: $450000
Cost difference: $4538

Year 2020 cost: $140000
Cost difference: $235

Year 2016 cost: $100000
Cost difference: $367
--------------------------------------------- */
