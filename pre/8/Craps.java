import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Scanner;


public class Craps{

// die roll method
  public static int roll(int sides) {
    Random dice = new Random();
    int diceRoll = dice.nextInt(sides) + 1;
    return diceRoll;
  }

// total value of multiple dice rolls method
  public static int shoot(int numDice, int maxValue) {
    int rollResult = 0;
    for(int i = 0; i < numDice; i++) {
      rollResult += roll(maxValue);
    }
    return rollResult;
  }

/*
This method is set up to return a 0 if the round is lost
and a 1 if the round is won.
The returned value is then used in a conditional statement in the main method
to print out if the round was won or lost
*/
  public static int round() {
    int diceRoll = shoot(2, 6);
    int result = 0; // initialize result variable
    if(diceRoll == 2 || diceRoll == 3 || diceRoll == 12) {   // These roll values result in loss
      result = 0;
    } else if(diceRoll == 7 || diceRoll == 11) {   // These roll values result in win
      result = 1;
    } else { // all other roll values are stored in new variable
      int point = diceRoll;
      diceRoll = shoot(2, 6);
      while(diceRoll != point && diceRoll != 7) { // loop continues to roll until point value or 7 is rolled
        diceRoll = shoot(2, 6);
      }
      if(diceRoll == point) { // Rolled point value resulting in win
        result = 1;
      } else if(diceRoll == 7) { // Rolled 7 resulting in loss
        result = 0;
      }
    }
    return result;
  }


public static void main(String[] args) {
  int numRounds;
  Scanner howManyRounds = new Scanner(System.in);

  System.out.print("How many rounds would you like to play?");
  numRounds = howManyRounds.nextInt();
  for(int i = 0; i < numRounds; i++) {
    int roundResult = round();
    System.out.print("Round " + (i + 1) + ": ");
    if(roundResult == 1) {
      System.out.println("You Win!");
    } else {
      System.out.println("You Lose!");
    }
  }
  }

}
