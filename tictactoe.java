import java.util.Scanner;
public class Foothill
{
   // Public static constants
   public final int MAX_WINS = 5;
   public final char MIN_SYMBOL = 'A';
   public final char MAX_SYMBOL = 'Z';
   public final char DEFAULT_SYMBOL = ' ';
   
   // Private data
   private char symbol;
   private int wins;
   
// Accessors/Mutators
public char getSymbol()  
{
   return symbol;
}
public void setSymbol(char symbol) 
{
   this.symbol = symbol;
}
public int getWins() 
{
   return wins;
}
public void setWins(int wins) 
{

   this.wins = wins;
}

// Constructors
public Foothill()
{
   setWins(0);
}
public Foothill(char symbol)
{
   setSymbol(symbol);
   setWins(0);
}

// Add Win
public boolean addWin()
{
   if(wins < MAX_WINS)
{
   wins ++ ;
   return true;
}
   else
{
   return false;
 }
}

// Reset Win
public void resetWins()
{
   wins = 0;
} 

// MAIN CLASS STUFF
public static void main(String arg[])
{
   Foothill player1 = new Foothill();
   Foothill player2 = new Foothill();
   Foothill playerDefault = new Foothill(' ');        
   Foothill board[][] = new Foothill[3][3];
           
   char symbol = askUserForSymbol();
   player1.setSymbol(symbol);    
   symbol = askUserForSymbol();  
   while(symbol == player1.getSymbol())
{
   symbol = askUserForSymbol();
}
   player2.setSymbol(symbol);
   int count = 1;
   Foothill player;      
   while(count <= 5)
{
   resetBoard(board,playerDefault);
   System.out.println("Game " + (count) + " starting:");
   displayBoard(board);
   player = player1;
   while(true)
{              
   makeAMove(board, player);
   displayBoard(board);
   if(isWin(board, player))
{
   System.out.println(player.getSymbol() + " player won!\n");
   if(player.getSymbol() == player1.getSymbol())
      player1.addWin();
   else
      player2.addWin();
   break;
}
   if(isDraw(board))
{
   System.out.println("\nDraw");
   break;
}
   player = player == player1 ? player2 : player1;
}
   count ++ ;
}
   System.out.println("\nNumber of wins for player " + player1.getSymbol() + ":" 
         + player1.getWins() +
   "\nNumber of wins for player " + player2.getSymbol() + ":"
         + player2.getWins());  
}

// ASKING FOR USER SYMBOL
static Scanner input = new Scanner(System.in);
public static char askUserForSymbol()
{
   System.out.printf("What is the symbol for a player? ");
   char symbol = input.next().charAt(0);
   while( ! (symbol >= 'A' && symbol <= 'Z'))
{
   System.out.printf("Sorry that is no good, choose a capital letter.  "
         + "Try again: ");
   symbol = input.next().charAt(0);
}
   return symbol;
}     

// RESETTING THE BOARD
public static void resetBoard(Foothill[][] board, Foothill player)
{
   for(int a = 0;a < board.length;a ++ )
{
   for(int b = 0;b < board.length;b ++ )
{
   board[a][b] = player;
  }
 }
}
    
// MAKING A MOVE
public static void makeAMove(Foothill[][] board, Foothill player)
{
  System.out.printf("Enter a row (0, 1, or 2) for player " 
        + player.getSymbol() + ":");
  int row = input.nextInt();
  System.out.printf("Enter a column (0, 1, or 2) for player " 
        + player.getSymbol() + ":");
  int column = input.nextInt();
  while(row < 0 || row > 2||column < 0 || column > 2 
        || board[row][column].getSymbol() != ' ')
{
  System.out.printf("ERROR. Try again.");
  System.out.printf(" Enter a row (0, 1, or 2) for player " + player.getSymbol()
     + ":");
  row = input.nextInt();
  System.out.printf("Enter a column (0, 1, or 2) for player "
     + player.getSymbol() + ":"); 
  column = input.nextInt();
}
  board[row][column] = player;
}
    
// DISPLAYING THE BOARD
public static void displayBoard(Foothill[][] board)
{
   System.out.println("\n----------");
   for(int a = 0;a < 3;a ++ )
{
   for(int b = 0;b < 3;b ++ )
{
   if(b == 0)
{
   System.out.printf("|");
}
   System.out.printf(board[a][b].getSymbol() + "|");
}
   System.out.println("\n----------");
 }
}
    
// CHECKING FOR A WIN
public static boolean isWin(Foothill[][] board, Foothill player)
{
   for (int a = 0; a < 3; a ++ ) 
{
   if (board[a][0].getSymbol() == player.getSymbol() 
         && board[a][1].getSymbol() == player.getSymbol()
         && board[a][2].getSymbol() == player.getSymbol()) 
{
      return true;
 }
}
   for (int b = 0; b < 3; b++) 
{
   if (board[0][b].getSymbol() == player.getSymbol()
         && board[1][b].getSymbol() == player.getSymbol()
         && board[2][b].getSymbol() == player.getSymbol()) 
{
   return true;
 }
}

   if (board[0][0].getSymbol() == player.getSymbol()
         && board[1][1].getSymbol() == player.getSymbol()
         && board[2][2].getSymbol() == player.getSymbol()) 
{
   return true;

}
   if (board[0][2].getSymbol() == player.getSymbol()
         && board[1][1].getSymbol() == player.getSymbol()
         && board[2][0].getSymbol() == player.getSymbol())
{
   return true;
}
   return false;
}
     
// CHECKING FOR A DRAW
public static boolean isDraw(Foothill[][] board)
{
   for (int a = 0; a < 3; a ++ ) 
{
   for (int b = 0; b < 3; b ++ )
{
   if (board[a][b].getSymbol() == ' ')
{
   return false;
  }
 }
}
return true;
 }
}

/*----------------------- SAMPLE RUN ---------------------
What is the symbol for a player? X
What is the symbol for a player? o
Sorry that is no good, choose a capital letter.  Try again: O
Game 1 starting:

----------
| | | |
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:0

----------
|X| | |
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player O:1
Enter a column (0, 1, or 2) for player O:1

----------
|X| | |
----------
| |O| |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:1

----------
|X|X| |
----------
| |O| |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player O:2
Enter a column (0, 1, or 2) for player O:1

----------
|X|X| |
----------
| |O| |
----------
| |O| |
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:2

----------
|X|X|X|
----------
| |O| |
----------
| |O| |
----------
X player won!

Game 2 starting:

----------
| | | |
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:0

----------
|X| | |
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player O:1
Enter a column (0, 1, or 2) for player O:2

----------
|X| | |
----------
| | |O|
----------
| | | |
----------
Enter a row (0, 1, or 2) for player X:2
Enter a column (0, 1, or 2) for player X:1

----------
|X| | |
----------
| | |O|
----------
| |X| |
----------
Enter a row (0, 1, or 2) for player O:0
Enter a column (0, 1, or 2) for player O:2

----------
|X| |O|
----------
| | |O|
----------
| |X| |
----------
Enter a row (0, 1, or 2) for player X:1
Enter a column (0, 1, or 2) for player X:0

----------
|X| |O|
----------
|X| |O|
----------
| |X| |
----------
Enter a row (0, 1, or 2) for player O:2
Enter a column (0, 1, or 2) for player O:2

----------
|X| |O|
----------
|X| |O|
----------
| |X|O|
----------
O player won!

Game 3 starting:

----------
| | | |
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:2

----------
| | |X|
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player O:2
Enter a column (0, 1, or 2) for player O:0

----------
| | |X|
----------
| | | |
----------
|O| | |
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:0

----------
|X| |X|
----------
| | | |
----------
|O| | |
----------
Enter a row (0, 1, or 2) for player O:1
Enter a column (0, 1, or 2) for player O:2

----------
|X| |X|
----------
| | |O|
----------
|O| | |
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:1

----------
|X|X|X|
----------
| | |O|
----------
|O| | |
----------
X player won!

Game 4 starting:

----------
| | | |
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player X:1
Enter a column (0, 1, or 2) for player X:1

----------
| | | |
----------
| |X| |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player O:2
Enter a column (0, 1, or 2) for player O:2

----------
| | | |
----------
| |X| |
----------
| | |O|
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:0

----------
|X| | |
----------
| |X| |
----------
| | |O|
----------
Enter a row (0, 1, or 2) for player O:1
Enter a column (0, 1, or 2) for player O:1
ERROR. Try again. Enter a row (0, 1, or 2) for player O:2
Enter a column (0, 1, or 2) for player O:0

----------
|X| | |
----------
| |X| |
----------
|O| |O|
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:2

----------
|X| |X|
----------
| |X| |
----------
|O| |O|
----------
Enter a row (0, 1, or 2) for player O:2
Enter a column (0, 1, or 2) for player O:1

----------
|X| |X|
----------
| |X| |
----------
|O|O|O|
----------
O player won!

Game 5 starting:

----------
| | | |
----------
| | | |
----------
| | | |
----------
Enter a row (0, 1, or 2) for player X:2
Enter a column (0, 1, or 2) for player X:2

----------
| | | |
----------
| | | |
----------
| | |X|
----------
Enter a row (0, 1, or 2) for player O:1
Enter a column (0, 1, or 2) for player O:1

----------
| | | |
----------
| |O| |
----------
| | |X|
----------
Enter a row (0, 1, or 2) for player X:2
Enter a column (0, 1, or 2) for player X:1

----------
| | | |
----------
| |O| |
----------
| |X|X|
----------
Enter a row (0, 1, or 2) for player O:0
Enter a column (0, 1, or 2) for player O:0

----------
|O| | |
----------
| |O| |
----------
| |X|X|
----------
Enter a row (0, 1, or 2) for player X:0
Enter a column (0, 1, or 2) for player X:2

----------
|O| |X|
----------
| |O| |
----------
| |X|X|
----------
Enter a row (0, 1, or 2) for player O:0
Enter a column (0, 1, or 2) for player O:1

----------
|O|O|X|
----------
| |O| |
----------
| |X|X|
----------
Enter a row (0, 1, or 2) for player X:2
Enter a column (0, 1, or 2) for player X:0

----------
|O|O|X|
----------
| |O| |
----------
|X|X|X|
----------
X player won!


Number of wins for player X:3
Number of wins for player O:2
--------------------------------------------------------*/   
