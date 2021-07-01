/*
Programming in a High Level Language
In Class assignment - 6/30/21
Mancala
by
Liam Baum
Victoria Berkowitz
Brian Mueller
*/

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class Mancala2{

  // initialize players mancala and arrays
  public static int aiMancala = 10;
  public static int playerMancala = 0;
  public static int[] aiPits = new int[] {4, 4, 4, 4, 4, 4};
  public static int[] playerPits = new int[] {4, 4, 4, 4, 4, 4};
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();

  public static void showBoard() {
    // ai
    System.out.print(aiMancala + "\t");
    for(int i = 0; i < 6; i++) {
      System.out.print(aiPits[i] + "\t");
    }
    System.out.print("\n");

    // player
    System.out.print("\t");
    for(int i = 0; i < 6; i++) {
      System.out.print(playerPits[i] + "\t");
    }
    System.out.println(playerMancala);
  }

  // checks to see if pit is empty
  public static boolean checkPitEmpty(int index, int[] pitArr){
    return pitArr[index] == 0;
  }

  // for when game is over
  public static boolean allPitsEmpty(int[] pitArr) {
    boolean noStones = true;
    for(int i = 0; i < 6; i++) {
      if(pitArr[i] > 0) {
        noStones = false;
      }
    }
    return noStones;
  }

  // method informs the result of game
  public static void didYouWin(int player, int ai) {
    System.out.println("Game Over!");
    System.out.println("Your mancala: " + player);
    System.out.println("AI mancala: " + ai);
    if(player > ai) {
      System.out.println("You win!");
    } else if(ai > player) {
      System.out.println("You lose!");
    } else {
      System.out.println("It's a tie!");
     }
  }

  public static void playerTurn() {
    int currentIndex;
    System.out.print("Which pit would you like to choose from?\n");
    currentIndex = scan.nextInt();
    currentIndex -= 1; // offset for 0-based indexing (pit 1 is index 0)

    boolean outOfBounds = currentIndex < 0 || currentIndex > 5;
    while(outOfBounds || checkPitEmpty(currentIndex, playerPits)) { // should also make sure choice is btwn 1-6
      if(outOfBounds){
        System.out.println("Please choose a pit from 1 through 6");
      }else{
        System.out.println("That pit is empty. Please choose another pit");
      }
      System.out.print("Which pit would you like to choose from?\n");
      currentIndex = scan.nextInt();
      currentIndex -= 1; // offset for 0-based indexing (pit 1 is index 0)
      outOfBounds = currentIndex < 0 || currentIndex > 5;
    }

    System.out.println("");

    int stonesInHand = playerPits[currentIndex]; // stores # of stones in new variable
    playerPits[currentIndex] = 0; // empties array index of chosen pit
    int direction = 1; // 1 = right, -1 = left
    int chosenStones = stonesInHand; // copy this value so it doesn't change the limit of the loop below
    for(int i = 0; i < chosenStones; i++) { // sets loop for number of stones chosen
      currentIndex += direction;

      if(currentIndex == 6){ // reached player Mancala
        stonesInHand--; // transfer from hand...
        playerMancala++; // ...to player mancala
        if(stonesInHand == 0 && !allPitsEmpty(playerPits)) { // checks if last stone was put in Mancala && not last move
            System.out.println("Last stone in Mancala. You go again");
            System.out.println("");
            showBoard();
            playerTurn(); // recursive call to take another player turn
        }
        direction = -1; // set direction variable to opposite direction
      } else if(currentIndex == -1) { // reached aiMancala
        //skip ai Mancala
        direction = 1; // set direction variable to opposite direction
        i--; // prevents accounting for one of the chosenStones loop iterations
      } else { // distribute stones
        if(direction == 1) { // player's pits
          if(checkPitEmpty(currentIndex , playerPits) && stonesInHand == 1 && aiPits[currentIndex] != 0) { // check if last stone put in empty pit
            System.out.println("Ended in empty pit on your side. Collect stones from both pits!");
            playerMancala += (aiPits[currentIndex] + 1); // add both pits at that index to player mancala
            aiPits[currentIndex] = 0; // set ai mirror pit to zero
            break; // end turn
          }
          stonesInHand--; // transfer from hand...
          playerPits[currentIndex]++; // ...to player pit
        } else { // ai's pits
          stonesInHand--; // transfer from hand...
          aiPits[currentIndex]++; // ...to ai pit
        }
      } // end distribute stones
    } // end for loop
  } // end method

  public static void aiTurn() {
    int currentIndex;
    currentIndex = rand.nextInt(6); // random ai choice for index
    while(checkPitEmpty(currentIndex, aiPits)) { // check that ai did not choose empty pit
      currentIndex = rand.nextInt(6);
    }
    System.out.println("AI chose pit " + (currentIndex+1) + "\n"); // prints out AI pit choice

    int stonesInHand = aiPits[currentIndex]; // stores # of stones in new variable
    aiPits[currentIndex] = 0; // empties array index of chosen pit
    int direction = -1; // 1 = right, -1 = left
    int chosenStones = stonesInHand; // copy this value so it doesn't change the limit of the loop below
    for(int i = 0; i < chosenStones; i++) { // sets loop for number of stones chosen
      currentIndex += direction;
      if(currentIndex == -1){ // reached ai Mancala
        stonesInHand--; // transfer from hand...
        aiMancala++; // ...to ai mancala
        if(stonesInHand == 0 && !allPitsEmpty(aiPits)) { // checks if last stone was put in Mancala && not last move
          System.out.println("Last stone in Mancala. AI goes again");
          System.out.println("");
          showBoard();
          aiTurn(); // recursive call to take another ai turn
        }
        direction = 1; // set direction variable to opposite direction
      } else if(currentIndex == 5) { // reached player Mancala
        //skip player Mancala
        direction = -1; // set direction variable to opposite direction
        i--; // prevents accounting for one of the chosenStones loop iterations
      } else { // distribute stones
        if(direction == -1) { // ai's pits
          if(checkPitEmpty(currentIndex , aiPits) && stonesInHand == 1 && playerPits[currentIndex] != 0) { // check if last stone put in empty pit
            System.out.println("Ended in empty pit on AI side. Collect stones from both pits!");
            aiMancala += (playerPits[currentIndex] + 1); // add both pits at that index to ai mancala
            playerPits[currentIndex] = 0; // set player mirror pit to zero
            break; // end turn
          }
          stonesInHand--; // transfer from hand...
          aiPits[currentIndex]++; // ...to ai pit
        } else { // player's pits
          stonesInHand--; // transfer from hand...
          playerPits[currentIndex]++; // ...to player pit
        }
      } // end distribute stones
    } // end for loop
  } // end method


  public static void main(String[] args) {
    System.out.println("Welcome to the game of Mancala.");
    System.out.println("On the left is the AI's mancala.");
    System.out.println("On the right is your mancala.");
    System.out.println("In the middle is the pits.");
    System.out.println("The top row of 4's belongs to the AI.");
    System.out.println("The bottom row of 4's belongs to you.");

    showBoard();

    while(!allPitsEmpty(playerPits) || !allPitsEmpty(aiPits)) {
      System.out.println("\nYour Turn: ");
      playerTurn();
      showBoard();
      if(allPitsEmpty(playerPits)) {
        didYouWin(playerMancala, aiMancala); // displays game outcome
        break;
      }

      System.out.println("\nAI Turn: ");
      aiTurn();
      showBoard();
      if(allPitsEmpty(aiPits)) {
        didYouWin(playerMancala, aiMancala); // displays game outcome
        break;
      }
    } // end while
  } //end main
} // end class
