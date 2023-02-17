import java.util.Scanner;
public class Foothill
{
static Scanner input;
// Three output positions as strings
   static final String CHERRIES = "cherries";//40%
   static final String BAR = "BAR";//38%
   static final String SEVEN = "7";//15%
   static final String SPACE = "space";//7%

// Three output positions as integers
   static final int CHERRIES_INTEGER = 40;
   static final int BAR_INTEGER = 38;
   static final int SPACE_INTEGER = 7;

// Bet amount from 0 to 50
   static final int MIN_BET = 1;
   static final int MAX_BET = 50;
   static final int QUIT = 0;
    
// Combinations in order 
   static final int CHERRIES_NOT_CHERRIES_ANY = 5;
   static final int CHERRIES_CHERRIES_NOT_CHERRIES = 15;
   static final int CHERRIES_CHERRIES_CHERRIES = 30;
   static final int BAR_BAR_BAR = 50;
   static final int SEVEN_SEVEN_SEVEN = 100;
   
// Creating ThreeString object
public static void main (String[] args)
{
   input = new Scanner(System.in);
   ThreeString thePull;
         
   int bet; 
   int winnings;
         
   while ((bet = getBet()) != QUIT )
{
   thePull = pullSlot();
   int multiplier = getPayMultiplier (thePull);
   winnings = multiplier * bet;
   display(thePull, winnings);
}
   System.out.println("Thanks for coming to the slots.");
}

// Getting bet from the user and returning to main
public static int getBet()
{
   String Input;
   int bet;
   do
{
   System.out.print("How much would you like to bet (1 - 50) or 0 to quit?");
   Input = input.nextLine();
   bet = Integer.parseInt(Input);
}
   while (bet != QUIT && (bet < MIN_BET || bet > MAX_BET));
   return bet;
}
   
// Returning the ThreeString object to the client  
public static ThreeString pullSlot()
{
   ThreeString resultString = new ThreeString();
   resultString.setString1(randomString());
   resultString.setString2(randomString());
   resultString.setString3(randomString());
   return resultString;
}

// Returning a single random string
public static String randomString()
{
   int cherriesStop;
   int barStop;
   int randomNumber;
   int spaceStop;
   
   randomNumber = (int)(Math.random() * 1000);
   barStop = 10 * BAR_INTEGER;
   cherriesStop = barStop + 10 * CHERRIES_INTEGER;
   spaceStop = cherriesStop + 10 * SPACE_INTEGER;

   if (randomNumber < barStop)
      return BAR;
   else if (randomNumber < cherriesStop)
      return CHERRIES;
   else if (randomNumber < spaceStop)
      return SPACE;
   else
      return SEVEN;
}
   
//Returning pay multiplier (Cherries->Bar->Seven)
public static int getPayMultiplier(ThreeString thePull)
{
   if (thePull.getString1().equals(CHERRIES))
{
   if (!thePull.getString2().equals(CHERRIES))
      return  CHERRIES_NOT_CHERRIES_ANY;
   else if ( !thePull.getString3().equals(CHERRIES))
      return CHERRIES_CHERRIES_NOT_CHERRIES;
   else
      return CHERRIES_CHERRIES_CHERRIES;
}
   else if (thePull.getString1().equals(BAR) && thePull.getString2().equals(BAR)
    && thePull.getString3().equals(BAR))
   return BAR_BAR_BAR;
   else if (thePull.getString1().equals(SEVEN)
    && thePull.getString2().equals(SEVEN)
    && thePull.getString3().equals(SEVEN))
   return SEVEN_SEVEN_SEVEN;
   return 0;
}

//Displaying the three strings inside thePull 
public static void display(ThreeString thePull, int winnings )
{
   System.out.println("whirrrrrr .... and your pull is ... ");
   System.out.println(thePull.toString());
   if (winnings == 0)
      System.out.println("Sorry, you lose.");
   else
      System.out.println("Congratulations, you win: $ " + winnings);
 }
}

//Three string class stuff
class ThreeString
{
   String string1, string2, string3;
   public static final int MAX_LEN = 50, MIN_LEN = 1;
   public static final String DEFAULT_STRING = "(undefined)";

// Constructors
ThreeString()
{
   string1 = DEFAULT_STRING;
   string2 = DEFAULT_STRING;
   string3 = DEFAULT_STRING;
}
ThreeString(String string1, String string2, String string3)
{
   setString1(string1);
   setString2(string2);
   setString3(string3);
}

// Mutators
public boolean setString1(String str)
{
   if (!validString(str))
   return false;
   string1 = str;
   return true;
}
public boolean setString2(String str)
{
   if (!validString(str))
   return false;
   string2 = str;
   return true;
}
public boolean setString3(String str)
{
   if (!validString(str))
   return false;
   string3 = str;
   return true;
   
// Accessors
}
public String getString1(){return string1;}
public String getString2(){return string2;}
public String getString3(){return string3;}

private static boolean validString( String str )
{
   if (str == null)
   return false;
   if (str.length() > MAX_LEN || str.length() < MIN_LEN )
   return false;
   return true;
}
   public String toString()
{
   String returnStr;
   returnStr = string1 + ", " + string2 + ", " + string3;
   return returnStr;
 }
}

// ***  I got a pull of all BARS in pull 2 and all cherries in pull 3 ***
/* ---------- Sample Run -------------
How much would you like to bet (1 - 50) or 0 to quit?18
whirrrrrr .... and your pull is ... 
BAR, space, BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?47
whirrrrrr .... and your pull is ... 
BAR, BAR, BAR
Congratulations, you win: $ 2350
How much would you like to bet (1 - 50) or 0 to quit?31
whirrrrrr .... and your pull is ... 
cherries, cherries, cherries
Congratulations, you win: $ 930
How much would you like to bet (1 - 50) or 0 to quit?23
whirrrrrr .... and your pull is ... 
BAR, BAR, BAR
Congratulations, you win: $ 1150
How much would you like to bet (1 - 50) or 0 to quit?19
whirrrrrr .... and your pull is ... 
cherries, cherries, cherries
Congratulations, you win: $ 570
How much would you like to bet (1 - 50) or 0 to quit?12
whirrrrrr .... and your pull is ... 
BAR, BAR, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?23
whirrrrrr .... and your pull is ... 
7, cherries, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?11
whirrrrrr .... and your pull is ... 
cherries, 7, 7
Congratulations, you win: $ 55
How much would you like to bet (1 - 50) or 0 to quit?33
whirrrrrr .... and your pull is ... 
cherries, cherries, cherries
Congratulations, you win: $ 990
How much would you like to bet (1 - 50) or 0 to quit?18
whirrrrrr .... and your pull is ... 
cherries, cherries, BAR
Congratulations, you win: $ 270
How much would you like to bet (1 - 50) or 0 to quit?1
whirrrrrr .... and your pull is ... 
cherries, BAR, BAR
Congratulations, you win: $ 5
How much would you like to bet (1 - 50) or 0 to quit?49
whirrrrrr .... and your pull is ... 
cherries, BAR, BAR
Congratulations, you win: $ 245
How much would you like to bet (1 - 50) or 0 to quit?25
whirrrrrr .... and your pull is ... 
BAR, 7, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?27
whirrrrrr .... and your pull is ... 
BAR, BAR, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?43
whirrrrrr .... and your pull is ... 
7, BAR, BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?44
whirrrrrr .... and your pull is ... 
BAR, cherries, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?12
whirrrrrr .... and your pull is ... 
cherries, 7, BAR
Congratulations, you win: $ 60
How much would you like to bet (1 - 50) or 0 to quit?32
whirrrrrr .... and your pull is ... 
cherries, cherries, BAR
Congratulations, you win: $ 480
How much would you like to bet (1 - 50) or 0 to quit?27
whirrrrrr .... and your pull is ... 
7, BAR, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?26
whirrrrrr .... and your pull is ... 
cherries, BAR, BAR
Congratulations, you win: $ 130
How much would you like to bet (1 - 50) or 0 to quit?3
whirrrrrr .... and your pull is ... 
cherries, 7, BAR
Congratulations, you win: $ 15
How much would you like to bet (1 - 50) or 0 to quit?9
whirrrrrr .... and your pull is ... 
BAR, cherries, BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?14
whirrrrrr .... and your pull is ... 
BAR, cherries, 7
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?8
whirrrrrr .... and your pull is ... 
BAR, cherries, 7
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?36
whirrrrrr .... and your pull is ... 
cherries, cherries, 7
Congratulations, you win: $ 540
How much would you like to bet (1 - 50) or 0 to quit?46
whirrrrrr .... and your pull is ... 
BAR, BAR, BAR
Congratulations, you win: $ 2300
How much would you like to bet (1 - 50) or 0 to quit?5
whirrrrrr .... and your pull is ... 
BAR, 7, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?10
whirrrrrr .... and your pull is ... 
cherries, cherries, cherries
Congratulations, you win: $ 300
How much would you like to bet (1 - 50) or 0 to quit?19
whirrrrrr .... and your pull is ... 
BAR, space, cherries
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?40
whirrrrrr .... and your pull is ... 
space, cherries, BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?50
whirrrrrr .... and your pull is ... 
cherries, BAR, space
Congratulations, you win: $ 250
How much would you like to bet (1 - 50) or 0 to quit?6
whirrrrrr .... and your pull is ... 
cherries, space, cherries
Congratulations, you win: $ 30
How much would you like to bet (1 - 50) or 0 to quit?4
whirrrrrr .... and your pull is ... 
cherries, BAR, cherries
Congratulations, you win: $ 20
How much would you like to bet (1 - 50) or 0 to quit?7
whirrrrrr .... and your pull is ... 
cherries, cherries, cherries
Congratulations, you win: $ 210
How much would you like to bet (1 - 50) or 0 to quit?29
whirrrrrr .... and your pull is ... 
BAR, BAR, 7
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?5
whirrrrrr .... and your pull is ... 
cherries, BAR, cherries
Congratulations, you win: $ 25
How much would you like to bet (1 - 50) or 0 to quit?45
whirrrrrr .... and your pull is ... 
space, BAR, BAR
Sorry, you lose.
How much would you like to bet (1 - 50) or 0 to quit?8
whirrrrrr .... and your pull is ... 
cherries, BAR, space
Congratulations, you win: $ 40
How much would you like to bet (1 - 50) or 0 to quit?10
whirrrrrr .... and your pull is ... 
cherries, BAR, 7
Congratulations, you win: $ 50
 --------------------------------------*/
