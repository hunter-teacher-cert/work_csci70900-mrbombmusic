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

  // maybe add grid system
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


  public static int countNeighbours(char[][] board, int r, int c) {
      // conditional to check val of neighbor - "X" or " "
      char val = board[r][c];
      int sumCellValues = 0; // will accumulate state of cell - 1 = alive, 0 = dead
      for(int rowOffset = -1; rowOffset < 2; rowOffset++) {
         for(int cellOffset = -1; cellOffset < 2; cellOffset++) {
          if(rowOffset != 0 || cellOffset != 0) {// skip cell
              sumCellValues += isCellAlive(board,r + rowOffset, c + cellOffset);
              // System.out.println("Your neighbor is alive!" + rowOffset + " " + cellOffset);
            // } else {
            //   System.out.println("Your neighbor is dead :(" + rowOffset + " " + cellOffset);

         } // if skep cell
        } // end cellOffset for
      } // end rowOffset for
      return sumCellValues;
  } // end method


 // helper method to deal with out of bounds cells
  public static int isCellAlive(char[][] board, int r, int c) {
    if(r < 0 || r > board.length - 1) {
      return 0;
    } else if(c < 0 || c > board[r].length -1) {
      return 0;
    } else if(board[r][c] == 'X') {
      return 1;
    } else {
      return 0;
    }
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell(char[][] board,int r, int c) {
      int val = countNeighbours(board, r, c);
      char newVal = ' ';
      // this happens when cell is alive
      if(board[r][c] == 'X') {
        if(val <= 1) { // cell has 1 or 0 neightbors
          newVal = ' ';
        } else if (val >= 4) { // cell has 4 or more neightbors
          newVal = ' ';
        } else if(val == 2 || val == 3) { // cell has 2 or 3 neightbors
          newVal = 'X';
        }
      } else { // if cell is dead
        if(val == 3) { // cell has 3 neightbors
          newVal = 'X';
        }
      }
  return newVal;
}

  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {

      char[][] newBoard = new char[board.length][board[0].length];
      // iterate through Board
      for(int row = 0; row < board.length; row++) {
        for(int cell = 0; cell < board[row].length; cell++) {
          newBoard[row][cell] = getNextGenCell(board, row, cell);
        }
      }
      // check neighbors of each cell
      // use getNextGenCell to assign new value to each cell in board
      return newBoard;
  }


  public static void main( String[] args )
  {
    char[][] board;
    board = createNewBoard(5,5);

    //breathe life into some cells:

    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, ' ');
    setCell(board, 0, 2, ' ');
    setCell(board, 1, 0, ' ');
    setCell(board, 1, 1, 'X'); // checked cell
    setCell(board, 1, 2, 'X');
    setCell(board, 2, 0, ' ');
    setCell(board, 2, 1, 'X');
    setCell(board, 2, 2, 'X');
    setCell(board, 0, 3, 'X');
    setCell(board, 3, 2, 'X');
    // setCell(board, 1, 0, 'X');

  //  printBoard(board);
    // countNeighbours(board, 1, 1); // checking the cell to the right of 0, 0
   // System.out.println(countNeighbours(board, 0, 1));
   // System.out.println(board[0][0]);
   // System.out.println("Cell new value: ");
    // System.out.println(getNextGenCell(board, 0, 0));
  //  System.out.println();

    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    for(int generations = 0; generations < 5; generations++) {
    System.out.println("Gen " + (generations + 1) + ": ");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
  }
    // System.out.println("Gen X+1:");
    // printBoard(board);
    // System.out.println("--------------------------\n\n");
    // board = generateNextBoard(board);
    // System.out.println("Gen X+2:");
    // printBoard(board);
    // System.out.println("--------------------------\n\n");

  }//end main()

}//end class
