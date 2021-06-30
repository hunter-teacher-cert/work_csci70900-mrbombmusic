import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Arrays;

/* The assignment called for making a class called Arrays
However, I ran into issues trying to use the Arrays.toString method
from the java.util.Arrays library. It appears that you are not able to
name a class the same name as a library if you want to call methods
from that library. This is why I changed the assignment name to MakeArrays.
*/
public class MakeArrays{

  // random array generator with values between 0 - 100
  // To be used with indexOfMax method and histogram method
  public static int[] randomArray(int size) {
    Random random = new Random();
    int[] a = new int[size];
    for (int i = 0; i < a.length; i++) {
        a[i] = random.nextInt(100);
    }
    return a;
}

  // This method will not work with an enhanced for loop
  // because we need to return the index of the max value
  // not the max value itself
  public static int indexOfMax(int[] a) {
  int currentMaxValue = 0;
  int maxValueIndex = 0;
  for(int i = 0; i < a.length;i++) {
    if(a[i] > currentMaxValue) {
      currentMaxValue = a[i];
      maxValueIndex = i;
    }
  }
  return maxValueIndex;
  }

  public static double[] powArray(double[] a, int x) {
    for (int i = 0; i < a.length; i++) {
    a[i] = Math.pow(a[i], x);
    }
      return a;
  }

  public static int[] histogram(int[] scores, int counters) {
    int[] counts = new int[counters];
    for (int score : scores) {
      counts[score]++;
}
  return counts;
  }

  // I revised my original solution after discussion from breakout group
  public static boolean[] sieve(int n) {
    boolean[] primeNumbers = new boolean[n];
    for(int i = 2; i < n; i++) {
      if(isPrime(i)) {
        primeNumbers[i] = true;
      }
    }
    return primeNumbers;
  }

  // method to check if number is prime for use in sieve method
  // inspired from group work
  public static boolean isPrime(int n) {
    for(int i = 2; i < n; i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }

public static void main(String[] args) {
  // creates array to use as argument for powArray method
  double[] a = new double[5];
  double increase = 1.0;
  for(int i = 0; i < a.length; i++) {
    a[i] = increase;
    increase++;
  }

  // powArray execution
 System.out.println(Arrays.toString(powArray(a, 3)));

  //histogram execution
 System.out.println(Arrays.toString(histogram(randomArray(30), 100)));

// indexOfMax execution
int[] b = randomArray(12);
System.out.println(Arrays.toString(b)); // array used as argument for reference
System.out.println(indexOfMax(b));

//sieve execution
 System.out.println(Arrays.toString(sieve(30)));
 }
}
