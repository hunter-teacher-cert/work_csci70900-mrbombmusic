import java.io.*;
import java.util.*;
import java.util.Random;

/**
   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

public class Cgol
{

  //initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
    char[][] board = new char[rows][cols];
    for(int row = 0; row < board.length; row++) {
      for(int cell = 0; cell < board[row].length; cell++) {
         board[row][cell] = ' ';
      }
    }
    return board;
  }


  //print the board to the terminal
  public static void printBoard(char[][] board) {
      for(int row = 0; row < board.length; row++) {
        for(int cell = 0; cell < board[row].length; cell++) {
          System.out.print(board[row][cell]);
          System.out.print(" ");
        }
        System.out.println(" ");
      }
  }


  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
    // Random rand = new Random();
    // int liveCells = rand.nextInt();
      board[r][c] = val;
  }

  // initialize random board configuration
  // note: have not accounted for choosing the same cell twice
  // maybe use while loop?
  public static char[][] setBoard(char[][] board, int numCells) {
    Random randomRow = new Random();
    Random randomCell = new Random();
      for(int liveCells = 0; liveCells < numCells; liveCells++) {
        int row = randomRow.nextInt(board.length);
        int cell = randomCell.nextInt(board[row].length);
        board[row][cell] = 'X';
      }
    return board;
}


  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {
      // conditional to check val of neighbor - "X" or " "
      char val = board[r][c + 1]; // cell to the right
      if(val == 'X') {
        System.out.println("Your neighbor is alive!");
        return 0;
      } else {
        System.out.println("Your neighbor is dead :(");
        return 0;
      }
  }




  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell(char[][] board,int r, int c) {
      return 0;
  }


  //generate new board representing next generation
  // public static char[][] generateNextBoard(char[][] board) {
  //     return
  // }


  public static void main( String[] args )
  {
    char[][] board;
    board = createNewBoard(25,25);

    //breathe life into some cells:

    setCell(board, 0, 0, 'X');
   setCell(board, 0, 1, 'X');
    // setCell(board, 1, 0, 'X');

    printBoard(board);
    countNeighbours(board, 0, 0);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
