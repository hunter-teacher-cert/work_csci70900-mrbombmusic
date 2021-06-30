import java.io.*;
import java.util.*;

public class Methods{

  public static int ack(int m, int n) {
    if(m == 0) {
     return n + 1;
   } else if(n == 0 && m > 0) {
     return ack(m -1 , 1);
   } else {
     return ack(m-1, ack(m, n-1));
   }
  }

  public static boolean isTriangle(int side1, int side2, int side3) {
    if(side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2) {
      return false;
    } else {
    return true;
   }
  }

  // revised based on class discussion
  // quote from slack thread
  // "If the sole purpose of an if-else stmt  is to return T or F, then you can strip away the superstructure…"
  public static boolean isDivisible(int n, int m) {
    return (n % m == 0);
  }

  public static void main(String[] args) {
    //print isDivisible method return value
    System.out.println(isDivisible(5, 2));

    // use isDivisible method return value for conditional statement
    boolean divisibleResult = isDivisible(9, 3);
    if(divisibleResult) {
      System.out.println("These numbers are divisible");
    } else {
      System.out.println("These numbers are not divisible");
    }

    //print isTriangle method return value
    System.out.println(isTriangle(8, 7, 14));

    // use isTriangle method return value for conditional statement
    boolean triangleResult = isTriangle(10, 4, 5);
    if(triangleResult) {
      System.out.println("These sticks will make a triangle");
    } else {
      System.out.println("These sticks will not make a triangle");
    }

    // ack method with parameter m = 0
    System.out.println(ack(0, 2));

    //ack method with parameter n = 0
    System.out.println(ack(2, 0));

    //ack method with both parameters are greater than 0
    System.out.println(ack(2, 2));
  }

}
