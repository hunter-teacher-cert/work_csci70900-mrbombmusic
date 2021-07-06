import java.io.*;
import java.util.*;


class Fib{

  /*
  0, 1, 1, 2, 3, 5, 8, 13, 21 (n = 8), 34, 55, 89

 n = 8

 (n - (n -1)) + (n - (n - 2))
 fib(n)

 sum = 8 - 7 = 1

 sum += n - (n-1)
 2 = 1 + 1
 return sum;


  input is nth time of the sequence

  base case = (n- 2) + (n -1)

  int totalSum = 0;

  if n == 0 {
  return 0;
} else if (n == 1) {
return 1;
} else {
totalSum = 1+0;
}

 sum = n(9) n(9 - 1)

n = position;

return int - sum of input
*/

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

// public static int fib2(int n) {
//   int totalSum = 0;
//   if(n - 1 == 0) {
//     return 0;
//   } else {
//     totalSum = fib2(n - 2) + fib2(n - 1);
//   }
//   return totalSum;
// }



public static void main(String[] args) {
  System.out.println("Return value = " + fib2(2));

}

}
