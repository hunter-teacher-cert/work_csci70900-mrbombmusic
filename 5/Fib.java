/*
Programing in a High Level Language
In Class Work - 07/06/21
Fibinacci Recursion lab
by
Liam Baum
Mamudu Wally
Eduardo Leite

*/

import java.io.*;
import java.util.*;


class Fib{

// this works!!!
public static int fib(int n) {
  int totalSum = 0;
  if(n == 0) {
    return 0;
  } else if (n == 1) {
    return 1;
  } else {
    totalSum = fib(n - 2) + fib(n - 1);
  }
  return totalSum;
}

public static void main(String[] args) {
  System.out.println("Return value = " + fib(8));

}

}
