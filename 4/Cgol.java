import java.io.*;
import java.util.*;
import java.util.Random;

public class Cgol {
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

  // can be used to set specific cell values in main
  // not currently used in this code
  public static void setCell(char[][] board, int r, int c, char val){
    board[r][c] = val;
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

  // initialize random board configuration
  // second argument chooses how many cells to set as alive
  public static char[][] setBoard(char[][] board, int numCells) {
    Random randomRow = new Random();
    Random randomCell = new Random();
    int row = randomRow.nextInt(board.length); // chooses random row
    int cell = randomCell.nextInt(board[row].length); // choose random cell in row
    for(int liveCells = 0; liveCells < numCells; liveCells++) { // sets specific number of cells chosen in argument
      while(board[row][cell] == 'X'){ // if cell already has been chosen and set as alive...
        row = randomRow.nextInt(board.length); // ...choose different random row...
        cell = randomCell.nextInt(board[row].length); //...and different random cell in row
      }
      board[row][cell] = 'X'; // assigns alive value to randomly chosen cell
    }
    return board;
  }


  // method to check status of all neighbor cells and retun number of living neighbors
  public static int countNeighbours(char[][] board, int r, int c) {
    char val = board[r][c]; // value of cell being checked
    int sumCellValues = 0; // will accumulate state of neightbor cells - 1 = alive, 0 = dead
    for(int rowOffset = -1; rowOffset < 2; rowOffset++) {
      for(int cellOffset = -1; cellOffset < 2; cellOffset++) {
        if(rowOffset != 0 || cellOffset != 0) {// skip cell being checked
          sumCellValues += isCellAlive(board,r + rowOffset, c + cellOffset); // uses helper method to check neighbor cell value
        } // if skep cell
      } // end cellOffset for
    } // end rowOffset for
    return sumCellValues; // returns how many neighbors have a value of alive
  } // end method


  // helper method to deal with out of bounds cells
  public static int isCellAlive(char[][] board, int r, int c) {
    if(r < 0 || r > board.length - 1) { // if cell is at top or bottom border of grid
      return 0;
    } else if(c < 0 || c > board[r].length -1) { // if cell is left or right border
      return 0;
    } else if(board[r][c] == 'X') { // cell within borders that is alive
      return 1;
    } else { // cells within borders that are dead
      return 0;
    }
  }

  // method evaluates next generation of cell value
  public static char getNextGenCell(char[][] board,int r, int c) {
    int val = countNeighbours(board, r, c); // method evaulates state of neighbor cells into variable
    char newVal = ' ';
    if(board[r][c] == 'X') { // if cell is alive
      if(val <= 1 || val >= 4) { // cell has 0-1 neightbors or 4+ neighbors...
        newVal = ' '; // ...set cell value to dead
      } else if(val == 2 || val == 3) { // cell has 2 or 3 neightbors...
        newVal = 'X'; // ... set cell to alive
      }
    } else { // if cell is dead
      if(val == 3) { // cell has 3 neightbors..
        newVal = 'X'; // ... set cell to alive
      }
    }
    return newVal; // return new cell value
  }

  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    char[][] newBoard = new char[board.length][board[0].length];
    for(int row = 0; row < board.length; row++) { // iterate through Board
      for(int cell = 0; cell < board[row].length; cell++) {
        newBoard[row][cell] = getNextGenCell(board, row, cell);   // assign new value to each cell in board
      }
    }
    return newBoard;
  }

  // method sets time btwn terminal canvas resets
  public static void delay(int n) {
    try {
      Thread.sleep(n);
    }
    catch(InterruptedException e) {}
    }

    // method to handle animation in terminal
    public static char[][] animate(int n, char[][] board) {
      //clear screen, place cursor at origin (upper left)
      System.out.print("[0;0H\n"); // wipes terminal canvas clear - moves cursor back to 0, 0
      System.out.println("Gen " + (n + 1) + ": ");
      printBoard(board); // prints current board
      board = generateNextBoard(board); // generates new board
      int delayTime = board.length*100; // board size appears to affect speed of clearing the terminal
      delay(delayTime); // time to wait before reseting terminal
      return board; // update next generation board for display
    }

    // checks to see if entire board is empty to stop animation
    public static boolean isBoardEmpty(char[][] board) {
      for(int row = 0; row < board.length; row++) { // iterate through entire board
        for(int cell = 0; cell < board[row].length; cell++){
          if(board[row][cell] == 'X') { //if any cell is alive...
            return false; //... board is not empty
          }
        }
      }
      return true;
    }

    public static void main( String[] args ){
      char[][] board; // declare variable to hold board 2D array
      board = createNewBoard(15,15); // create board
      setBoard(board, 20); // populate board with living cells in random positions
      for (int frame = 0; frame < 40; frame++) { // loop to animate board
        board = animate(frame, board); // call to animate method to display current generation of board
        if(isBoardEmpty(board)) { // check if board is empty
          System.out.print("[0;0H\n"); // updates terminal canvas
          printBoard(board); // prints empty board
          System.out.println("All your cells are dead..."); // alert that board is now empty
          delay(2000); // waits 2 seconds
          System.out.println("but life goes on..."); // fills user with hope...
          break; // end animation
        }
      }

    }//end main()

  }//end class
