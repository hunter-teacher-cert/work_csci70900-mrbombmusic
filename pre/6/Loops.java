import java.io.*;
import java.util.*;

public class Loops{

  // original myexp method from exercise 5 part 1
  // public static double myexp(double x, int n) {
  //   double term = 0.0;
  //   for(int i = 0; i < n; i++) {
  //   term += Math.pow(x, i)/factorial(i);
  //   }
  //   return term;
  // }

/*
This method checks the results of myexp function and Math.myexp.
The exercise says to adjust the number of terms until the estimated value
agrees with the correct answer when x is 1. That is the number 17 in the myexp.
However, the exercise also said that the number of terms should be the second argument that check sends to myexp.
But it did not specify to make the check method with two arguments.
*/
  public static String check(double x, int term) {
      return x + "\t" + myexp(x, term) + "\t" + Math.exp(x);
  }


/*
e^x = 1 + x + x^2 / 2! + x^3 / 3! + x^4 / 4! + …
It was not clear what 'e' was in this exercise.

The instructions said
"You can make this method more efficient if you realize that
the numerator of each term is the same as its predecessor multiplied by x,
and the denominator is the same as its predecessor multiplied by i"
This is why I created the 2 previous variables, to store the values of
the predecessor that would then be multiplied by x and i respectively.
The argument n is the number of terms.
*/
  public static double myexp(double x, int n) {
      double term = 0.0;
      double numerator = 1.0;
      double denominator = 1.0;
      double previousNumerator;
      double previousDenominator;
      for(int i = 0; i < n; i++) {
      term += numerator/denominator;
      previousNumerator = numerator;
      previousDenominator = denominator;
      numerator = previousNumerator*x;
      denominator = previousDenominator*(i+1);
      }
      return term;
  }

  public static int factorial(int n) {
    int result = 1;
    for(int i = n; i > 0; i--) {
      result = i*result;
    }
   return result;
  }

  public static double power(double x, int n) {
    double answer = 1.0;
    for(int i = 0; i < n; i++) {
      answer = answer*x;
    }
      return answer;
  }

  public static void main(String[] args) {
    // power method
  System.out.println(power(7, 6));
    // factorial method
  System.out.println(factorial(10));

    // check method for values 0.1, 1.0, 10.0, and 100.0.
  double x = 0.1;
  for(int i = 0; i < 4; i++) {
  System.out.println(check(x, 17));
  x = x*10.0;
  }
    // check method for values -0.1, -1.0, -10.0, and -100.0.
  double negX = -0.1;
  for(int i = 0; i < 4; i++) {
  System.out.println(check(negX, 17));
  negX = negX*10.0;
 }
 // comment on accuracy
 // -0.1 is consistent thru 15 decimal places
 // -1.0 is consistent thru 14 decimal places
 // -10.0 is way off with myexp outputing 179.45369797750715
 // but Math.pow outputs 4.5399929762484854E-5
 // -100.0 returns to closer accuracy with myexp outputing 4.115271557032277E18
 // and Math.exp outputs 3.720075976020836E-44
}
}
