import java.util.Random;
import java.util.Scanner;

public class GuessRandom{

  public static void main(String[] args) {
    Random random = new Random();

    Scanner in = new Scanner(System.in);

    int number = random.nextInt(100) + 1;
    int guess;

    System.out.print("I'm thinking of a number between 1 and 100 (including both).");
    System.out.println("Can you guess what it is?");
    System.out.println("Type a number: ");
    guess = in.nextInt();
    System.out.println("Your guess is: " + guess);
    System.out.println("The number I was thinking of is: " + number);

    int difference = guess - number;

    System.out.println("You were off by: " + Math.abs(difference));

  }
}
