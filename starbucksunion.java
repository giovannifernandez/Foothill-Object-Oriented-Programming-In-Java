// STARBUCKS STORE
package myapp;

// Defined a class of type Starbucks
public class StarbucksStore
{
   
// Defined instance variables with private visibility
   private String storeName;
   private String location;
   private String state;
   private boolean RTWstate;
   private int voteYes;
   private int voteNo;
   private boolean result;

// CONSTRUCTORS
// Completed method signature to receive an argument for each attribute
public StarbucksStore(String storeName, String location, String state, 
      boolean RTWstate, int voteYes, int voteNo, boolean result) 
{
   this.storeName = storeName;
   this.location = location;
   this.state = state;
   this.RTWstate = RTWstate;
   this.voteYes = voteYes;
   this.voteNo = voteNo;
   if(voteNo >= voteYes) 
{
   this.result = false;
}  
   else 
{
   this.result = result;
 }
}

// ACCESSORS
public StarbucksStore(String storeName) 
{
   this(storeName, "unknown", "unknown", false, 0, 0, false);
}
// Defined a getter method for storeName attribute
public String getStoreName() 
{
   return storeName;
}
// Defined a getter method for stateName attribute
public String getState() 
{
   return state;
}
// Defined a getter method for RTWstate attribute
public boolean getRTWstate() 
{
  return RTWstate;
}
// Defined a getter method for voteYes attribute
public int getvoteYes() 
{
  return voteYes;
}
// Defined a getter method for voteNo attribute
public int getvoteNo() 
{
  return voteNo;
}
// Defined a getter method for result attribute
public boolean getVoteResult() 
{
  return result;
}

// MUTATORS
// Defined a setter method for storeName attribute
public void setStoreName(String storeName) throws IllegalArgumentException 
{
   if(storeName.length() < 1) 
{
      throw new IllegalArgumentException();
} 
   else
{
   this.storeName = storeName;
 }
}
// Defined a setter method for location attribute
public void setStoreLocation(String location) 
{
   if(location.length() < 1) 
{
   throw new IllegalArgumentException();
} 
   else 
{
   this.location = location;
 }
}
// Defined a method called printStore
public void printStore()
{
   System.out.println("Votes at store " + storeName + " in " + location 
         + " did " + (result ? "" : "not ") + "unionize.");
 }
}


// STARBUCKS WORLD
package myapp;

//Defined a class of type Starbucks
public class StarbucksWorld
{
// Defined given attributes with private visibility
// Completed method signature to receive an argument for the expected number 
// of stores
// Initialized attribute(s)
   private StarbucksStore[] allStores;
   private final static int MIN_NUM_STORES = 2;
   public StarbucksWorld(int numOfStores) 
{
   if(numOfStores < MIN_NUM_STORES) 
{
   numOfStores = MIN_NUM_STORES;
}
   allStores = new StarbucksStore[numOfStores];
}
   
// Completed method to add Starbucks object to "allStores" array
public boolean addStore(StarbucksStore newStore) 
{
   int nextAvailableIndex = -1;
   for (int i = 0; i < allStores.length; i++) 
{
   if(allStores[i] == null) 
{ 
   nextAvailableIndex = i;
   break;
 }
}
   if(nextAvailableIndex == -1) 
{
   return false;
}
   else 
{ 
   allStores[nextAvailableIndex] = newStore;
   return true;
 }
}

// ACCESSORS
// Defined a getter method for "allStores"
public StarbucksStore[] getAllStores() 
{
   return allStores;
}
// Defined a getter method for the number of elements in "allStores"
public int sizeOfWorld() 
{
   int count = 0;
   for (int i = 0; i < allStores.length; i++) 
{
   if(allStores[i] != null) 
{
   count++;
 }
}
   return count;
}
// Defined a getter method that returns a Starbucks store
public StarbucksStore getStoreNumber(int requestedStoreNumber) 
      throws IndexOutOfBoundsException 
{
   if(requestedStoreNumber < 0 || requestedStoreNumber >= sizeOfWorld()) 
{
   throw new IndexOutOfBoundsException();
} 
   else 
{
   return allStores[requestedStoreNumber];
 }
}
// Define a getter method for the number of stores that have a yes for the 
// result of the vote
public int getNumYesVoteResults() 
{
   int count = 0;
   for (int i = 0; i < allStores.length; i++) 
{
   if(allStores[i] != null && allStores[i].getvoteYes() > 0) 
{
   count++;
 }
}
   return count;
}
// Defined a getter method for the number of stores with Right-to-Work laws
public int getNumRTW() 
{
   int count = 0;
   for (int i = 0; i < allStores.length; i++) 
{
   if(allStores[i] != null && allStores[i].getRTWstate()) 
{
   count++;
 }
}
   return count;
}
// Defined a getter method for the name of stores
public String[] getStoreNames() 
{
   String[] storeNames = new String[allStores.length];
   for (int i = 0; i < allStores.length; i++) 
{
   if(allStores[i] != null) 
{
   storeNames[i] = allStores[i].getStoreName();
 }
}
   return storeNames;
}
// Defined a method called printAllStores
public void printAllStores() 
{
   System.out.println("We have captured votes for " + sizeOfWorld()
      + " store(s):");
   for (int i = 0; i < allStores.length; i++) 
{
   if(allStores[i] != null) 
{
   allStores[i].printStore();
   }
  }
 }
}


// TEST STARBUCKS
//Note: Deleted comments from provided test class to organize
package myapp;
public class TestStarbucks
{
// Hard-coded 2D array representation of sbwu_elections.csv data input file
private final static String[][] SAMPLE_CSV_DATA_IN_ROWS = 
{
 {"20th Street and 3rd Ave", "Birmingham, AL", "AL", "Yes", "4/11/22", 
  "5/26/22", "45", "27", "1", "28", "33", "0.8485", "0.9286", "0.9643", "Yes"},
 {"Katella & Los Alamitos", "Los Alamitos, CA", "CA", "No", "3/16/22", 
  "5/23/22", "68", "2", "11", "13", "19", "0.6842", "-0.6923", "0.1538", "No"},
 {"Clares & 41st", "Capitola, CA", "CA", "No", "3/30/22", "6/6/22", "68", "8", 
  "3", "11", "21", "0.5238", "0.4545", "0.7273", "Yes"},
 {"Katella & Anaheim", "Anaheim, CA", "CA", "No", "3/28/22", "6/9/22", "73", 
  "10", "1", "11", "29", "0.3793", "0.8182", "0.9091", "Yes"},
 {"Downtown Disney Store", "Anaheim, CA", "CA", "No", "3/28/22", "6/16/22", 
  "80", "29", "15", "44", "90", "0.4889", "0.3182", "0.6591", "Yes"},
 {"Hwy 111 & Jefferson, La Quinta", "La Quinta ,CA", "CA", "No", "4/11/22", 
  "6/21/22", "71", "5", "4", "9", "35", "0.2571", "0.1111", "0.5556", "Yes"},
 {"2nd & Covina", "Long Beach, CA", "CA", "No", "4/11/22", "6/21/22", "71", 
  "3", "5", "8", "22", "0.3636", "-0.25", "0.375", "No"},
 {"Citrus & Rowland", "Covina, CA", "CA", "No", "4/11/22", "6/21/22", "71", 
  "7", "10", "17", "36", "0.4722","-0.1765", "0.4118", "No"},
 {"Mason & Lassen", "Los Angeles, CA", "CA", "No", "2/2/22", "6/29/22", "147", 
  "6", "9", "15", "35", "0.4286", "-0.2", "0.4", "No"},
 {"Burton & Rosemont", "Grand Rapids, MI", "MI", "Yes", "3/7/22", "5/13/22", 
  "67", "15", "3", "18", "30", "0.6", "0.6667", "0.8333", "Yes"},
 {"Main & Liberty", "Ann Arbor, MI", "MI", "Yes", "2/4/22", "6/7/22", "123", 
  "10", "3", "13", "19", "0.6842", "0.5385", "0.7692", "Yes"},
 {"South University & Church", "Ann Arbor, MI", "MI", "Yes", "2/4/22", 
  "6/7/22", "123", "10", "2", "12", "29", "0.4138", "0.6667", "0.8333", "Yes"},
 {"State & Liberty", "Ann Arbor, MI", "MI", "Yes", "2/4/22", "6/7/22", "123", 
  "15", "1", "16", "33", "0.4848", "0.875", "0.9375", "Yes"},
 {"Jackson & Zeeb", "Ann Arbor, MI", "MI", "Yes", "1/28/22", "6/7/22", "130", 
  "10", "2", "12", "29", "0.4138", "0.66 67", "0.8333", "Yes"},
 {"Glencoe Crossing", "Ann Arbor, MI", "MI", "Yes", "1/28/22", "6/7/22", "130",
  "14", "0", "14", "30", "0.4667", "1", "1", "Yes"},
 {"Grand River & Stoddard", "East Lansing, MI", "MI", "Yes", "3/7/22", 
  "6/9/22", "94", "19", "0", "19", "32", "0.5938", "1", "1", "Yes"},
 {"Miller Road & I-75", "Flint, MI", "MI", "Yes", "3/7/22", "6/9/22", "94", 
   "13", "6", "19", "26", "0.7308", "0.3684", "0.6842", "Yes"},
 {"Lake Lansing & Kerry St", "Lansing, MI", "MI", "Yes", "2/4/22", "6/9/22", 
   "125", "13", "3", "16", "37", "0.4324", "0.625", "0.8125", "Yes"},
 {"S. Saginaw Street", "Grand Blanc, MI", "MI", "Yes", "1/28/22", "6/9/22", 
   "132", "8", "13", "21", "30", "0.7", "-0.2381", "0.381", "No"},
 {"The Mall at Partridge Creek", "Clinton Township, MI", "MI", "Yes", 
   "1/28/22", "6/9/22", "132", "8", "3", "11", "15", "0.7333", "0.4545", 
   "0.7273", "Yes"},
 {"Carpenter Rd.", "Ann Arbor, MI", "MI", "Yes", "4/12/22", "6/17/22", "66", 
  "15", "2", "17", "38", "0.4474", "0.7647", "0.8824", "Yes"}};
/**
 * Keeps track of all StarbucksStore elements that are added to the world.
 * Enables asking some questions about the store data stored via accessor
 * methods.
 */
private StarbucksWorld theStarbucksWorld;
/**
 * Constructs an object of type StarbucksWorld by passing in the number of
 * stores in sample data. Note: The number of indices SAMPLE_CSV_DATA_IN_ROWS
 * may change.
 */
public TestStarbucks() 
{
   int numberOfStoresInWorld = SAMPLE_CSV_DATA_IN_ROWS.length;
   theStarbucksWorld = new StarbucksWorld(numberOfStoresInWorld);
}
/**
* Constructs one object of type StarbucksStore and tests whether the store was
* initialized correctly with the expected hard-coded values.
* 
* @return the hard-coded StarbuckStore.
*/
public StarbucksStore createOneStore() 
{
   StarbucksStore current;
   current = new StarbucksStore("CS1ACafe");
   try 
{
   current.setStoreName("12345 El Monte Road");
} 
   catch (Exception receivedExc) 
{
   System.err.println("Warning! createOneStore(): Invalid store name. "
         + "Unable to update.");receivedExc.printStackTrace();
}
   try 
{
   current.setStoreLocation("Los Altos Hills, CA");
} 
   catch(Exception receivedExc) 
{
   System.err.println("Warning! createOneStore(): Invalid store name. "
         + "Unable to update.");
   receivedExc.printStackTrace();
}
   System.out.println("In createOneStore(): Created store with name \"" + 
   current.getStoreName() + "\":");current.printStore();
   return current;
}
/**
* Initializes an array of type Starbucks to hold a fixed number of objects.
* 
* @return a one-dimensional array of StarbucksStore elements.
*/
public StarbucksStore[] loadSampleData() 
{
   for (String[] data : SAMPLE_CSV_DATA_IN_ROWS) 
{
   StarbucksStore store;
   String storeName = data[0];
   String storeLocation = data[1];
   String stateAbbreviation = data[2];
   boolean hasRightToWork = data[3].equals("Yes");
   int numVotesYes = Integer.parseInt(data[7]);
   int numVotesNo = Integer.parseInt(data[8]);
   boolean result = data[14].equals("Yes");
   store = new StarbucksStore(storeName, storeLocation, stateAbbreviation, 
         hasRightToWork, numVotesYes, numVotesNo, result);
   theStarbucksWorld.addStore(store);
} 
   return theStarbucksWorld.getAllStores();
}
/**
* Prints to standard output the name of all stores in the order stored.
*/
private void printStoreNames() 
{
   String[] names;
   names = theStarbucksWorld.getStoreNames();
   System.out.println("\nIn printStoreNames(): Found " + names.length 
         + " stores in Starbucks world.");
   for (String name : names) 
{
   System.out.println(name);
 }
}
/**
 * Tests if Right to Work status is valid.
 */
private void testGetRTWstate() 
{
   System.out.println("\nIn testGetRTWstate(): testing select stores "
         + "Right to Work status.");
   StarbucksStore storeToTest;
   int storeNum;
   final boolean TEST_CASE_RTW_1 = true;
   storeNum = 0;
   try 
{
   storeToTest = theStarbucksWorld.getStoreNumber(storeNum);
   if (storeToTest.getRTWstate() == TEST_CASE_RTW_1) 
{
   System.out.println("Passed in testGetRTWstate(): for " 
         + storeToTest.getStoreName() + " found RTW to be "
         + storeToTest.getRTWstate() + ".");
} 
   else 
{
  System.err.println("Failed in testGetRTWstate(): for " 
        + storeToTest.getStoreName() + " found invalid RTW to be "
        + storeToTest.getRTWstate() + " when it should have been " 
        + TEST_CASE_RTW_1 + ".");
 }
} 
   catch (Exception receivedExc) 
{
   System.err.println("Failed in testGetRTWstate(): Requested store at index " 
         + storeNum + " is invalid.");
   receivedExc.printStackTrace();
}
   final boolean TEST_CASE_RTW_2 = false;
   storeNum = 1;
   try 
{
   storeToTest = theStarbucksWorld.getStoreNumber(storeNum);
   if (storeToTest.getRTWstate() == TEST_CASE_RTW_2) 
{
   System.out.println("Passed in testGetRTWstate(): for " 
         + storeToTest.getStoreName() + " found RTW to be "
         + storeToTest.getRTWstate() + ".");
} 
   else 
{
   System.err.println("Failed in testGetRTWstate(): for " 
         + storeToTest.getStoreName() + " found invalid RTW to be "
         + storeToTest.getRTWstate() + " when it should have been " 
         + TEST_CASE_RTW_2 + ".");
 }
} 
   catch 
   (Exception receivedExc) 
{
   System.err.println("Failed in testGetRTWstate(): Requested store at index "
         + storeNum + " is invalid.");
   receivedExc.printStackTrace();
 }
}
/**
* Tests if whether stores voted Yes to unionize.
*/
private void testGetVoteResult() 
{
   System.out.println("\nIn testGetVoteResult(): testing select stores on "
         + "whether they voted yes to unionize.");
   StarbucksStore storeToTest;
   int storeNum;
   final boolean TEST_CASE_RESULT_1 = true;
   storeNum = 0;
   try 
{
   storeToTest = theStarbucksWorld.getStoreNumber(storeNum);
   if (storeToTest.getVoteResult() == TEST_CASE_RESULT_1) 
{
   System.out.println("Passed in testGetVoteResult(): for "
         + storeToTest.getStoreName() + " found vote to be "
         + storeToTest.getVoteResult() + ".");
} 
   else 
{
   System.err.println( "Failed in testGetVoteResult(): for " 
         + storeToTest.getStoreName() + " found invalid vote to be "
         + storeToTest.getVoteResult() + " when it should have been " 
         + TEST_CASE_RESULT_1 + ".");
 }
} 
   catch (Exception receivedExc) 
{
   System.err.println("Failed in testGetRTWstate(): Requested store at index " 
         + storeNum + " is invalid.\n");
   receivedExc.printStackTrace();
}
   final boolean TEST_CASE_RESULT_2 = false;
   storeNum = 1;
   try 
{
   storeToTest = theStarbucksWorld.getStoreNumber(storeNum);
   if (storeToTest.getVoteResult() == TEST_CASE_RESULT_2) 
{
   System.out.println("Passed in testGetVoteResult(): for " 
         + storeToTest.getStoreName() + " found vote to be "
         + storeToTest.getVoteResult() + ".");
} 
   else 
{
   System.err.println("Failed in testGetVoteResult(): for " 
         + storeToTest.getStoreName() + " found invalid vote to be "
         + storeToTest.getVoteResult() + " when it should have been " 
         + TEST_CASE_RESULT_2 + ".");
}
} 
   catch (Exception receivedExc) 
{
   System.err.println("Failed in testGetRTWstate(): Requested store at index "
         + storeNum + " is invalid.");
   receivedExc.printStackTrace();
 }
}
/**
* Tests the Starbucks class. Then, tests for valid data type and value.
* 
* @param args
*           not used.
*/
public static void main(String[] args) 
{
   TestStarbucks tester = null;
   tester = new TestStarbucks();
   StarbucksStore sample = tester.createOneStore();
   if (sample == null) 
{
   String message = "Error in main(): Unable to initialize the first "
            + "Starbucks store." + "Check project description and test file.";
   throw new RuntimeException(message);
}
   StarbucksStore[] sampleStarbucksStores = tester.loadSampleData();
   if (sampleStarbucksStores == null)
      System.err.println("\nWarning! main(): Unable to initialize Starbucks "
            + "stores.");
   else
      System.out.println("\nIn main(): Found " + sampleStarbucksStores.length 
            + " number of stores in our Starbucks world.\n");
   System.out.println("In main(): Displaying all stores.");
      tester.theStarbucksWorld.printAllStores();
      tester.printStoreNames();
      tester.testGetRTWstate();
      tester.testGetVoteResult();
      System.out.println("In main(): Done.");
 } 
}

/*----------------------- SAMPLE RUN ---------------------
In createOneStore(): Created store with name "12345 El Monte Road":
Votes at store 12345 El Monte Road in Los Altos Hills, CA did not unionize.

In main(): Found 21 number of stores in our Starbucks world.

In main(): Displaying all stores.
We have captured votes for 21 store(s):
Votes at store 20th Street and 3rd Ave in Birmingham, AL did unionize.
Votes at store Katella & Los Alamitos in Los Alamitos, CA did not unionize.
Votes at store Clares & 41st in Capitola, CA did unionize.
Votes at store Katella & Anaheim in Anaheim, CA did unionize.
Votes at store Downtown Disney Store in Anaheim, CA did unionize.
Votes at store Hwy 111 & Jefferson, La Quinta in La Quinta ,CA did unionize.
Votes at store 2nd & Covina in Long Beach, CA did not unionize.
Votes at store Citrus & Rowland in Covina, CA did not unionize.
Votes at store Mason & Lassen in Los Angeles, CA did not unionize.
Votes at store Burton & Rosemont in Grand Rapids, MI did unionize.
Votes at store Main & Liberty in Ann Arbor, MI did unionize.
Votes at store South University & Church in Ann Arbor, MI did unionize.
Votes at store State & Liberty in Ann Arbor, MI did unionize.
Votes at store Jackson & Zeeb in Ann Arbor, MI did unionize.
Votes at store Glencoe Crossing in Ann Arbor, MI did unionize.
Votes at store Grand River & Stoddard in East Lansing, MI did unionize.
Votes at store Miller Road & I-75 in Flint, MI did unionize.
Votes at store Lake Lansing & Kerry St in Lansing, MI did unionize.
Votes at store S. Saginaw Street in Grand Blanc, MI did not unionize.
Votes at store The Mall at Partridge Creek in Clinton Township, MI did unionize.
Votes at store Carpenter Rd. in Ann Arbor, MI did unionize.

In printStoreNames(): Found 21 stores in Starbucks world.
20th Street and 3rd Ave
Katella & Los Alamitos
Clares & 41st
Katella & Anaheim
Downtown Disney Store
Hwy 111 & Jefferson, La Quinta
2nd & Covina
Citrus & Rowland
Mason & Lassen
Burton & Rosemont
Main & Liberty
South University & Church
State & Liberty
Jackson & Zeeb
Glencoe Crossing
Grand River & Stoddard
Miller Road & I-75
Lake Lansing & Kerry St
S. Saginaw Street
The Mall at Partridge Creek
Carpenter Rd.

In testGetRTWstate(): testing select stores Right to Work status.
Passed in testGetRTWstate(): for 20th Street and 3rd Ave found RTW to be true.
Passed in testGetRTWstate(): for Katella & Los Alamitos found RTW to be false.

In testGetVoteResult(): testing select stores on whether they voted yes to unionize.
Passed in testGetVoteResult(): for 20th Street and 3rd Ave found vote to be true.
Passed in testGetVoteResult(): for Katella & Los Alamitos found vote to be false.
In main(): Done.
--------------------------------------------------------*/   
