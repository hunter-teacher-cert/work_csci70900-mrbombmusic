/*
Programming in a High Level Language
In Class assignment - 6/26/21
Game of Nim
by
Liam Baum
Eric Liu
Jiyoon Kim
Peter Tsun
*/


import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class Nim{

  // global variable for number of stones
  public static int stones = 12;

  // method to check if game is over
  public static boolean isGameOver(int stones) {
    return (stones == 0);
  }

  //method to run user turn
  //user input number of stone to remove, checks if input valid
  //ie. stones removed is btwn 1-3
  //updates stonesRemoved with user input removed
  public static void userTurn() {
    Scanner howManyStones = new Scanner(System.in);
    int stonesRemoved;
    System.out.print("How many stones would you like to remove?");
    stonesRemoved = howManyStones.nextInt();
    while(stonesRemoved > stones || stonesRemoved > 3) {
      System.out.println("You cannot removed that many stones.");
      System.out.println("How many stones would you like to remove?");
      stonesRemoved = howManyStones.nextInt();
    }
    stones -= stonesRemoved;
  }

  // method for AI turn
  // checks how many stones are left
  // if stones left is 3 or less, AI will pick reamining stones and Win
  // Otherwise, AI chooses random number btwn 1-3
  // updates global stone variable with ai number removed
  public static void aiTurn() {
    Random rand = new Random();
    int stonesRemoved;
    if(stones <= 3) {
      stonesRemoved = stones; // AI will win :(
    } else {
      stonesRemoved = rand.nextInt(3) + 1; // + 1 is to compensate for range starting at zero
   }
    System.out.println("The AI removed " + stonesRemoved + " stones.");
      stones -= stonesRemoved;
  }


public static void main(String[] args) {
  while(!isGameOver(stones)) {
    userTurn();
    System.out.println("There are " + stones + " remaining.");
    if(isGameOver(stones)) { //checks if game is over when user removes last stone
      System.out.println("You Win!!!");
      break; // exit while loop if game is over to bypass aiTurn.
    }
    aiTurn();
    System.out.println("There are " + stones + " remaining.");
    if(isGameOver(stones)) { //checks if game is over when AI removes last stone
      System.out.println("You Lose!!!");
      break;
     }
   }
 }

}




// to do list

// are there zero stones left
// how many stones currently There

// ask how many stones to choose
// subtract user input from currentStones
// output remainingStones

// AI takes turns
// output how many AI took
// back to stoneCheck & isGameOver
