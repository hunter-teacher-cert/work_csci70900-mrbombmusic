import java.io.*;
import java.util.*;


public class Driver{

  public static void main(String[] args) {

    // make new object with default instance variables
    SuperArray sa = new SuperArray();

    // make new object with parameterized constructor
    SuperArray saSpec = new SuperArray(3);

    // print initialized objects - toString method automatically invoked
    System.out.println(sa); // array with 2 values - [0, 0]
    System.out.println(saSpec); // array with 3 values - [0, 0, 0]

    // checks isEmpty method - both should evaluate as true
    System.out.println(sa.isEmpty());
    System.out.println(saSpec.isEmpty());
    System.out.println("");
    // checks add method one at a time
    // includes 3 add methods to test private grow method in class
    sa.add(8);
    sa.add(4);
    sa.add(6);
    System.out.println(sa); // expect [8, 4, 6] - confirmed

    // checks add method in loop
    // includes 5 values to to test private grow method in class
    for(int i = 1; i < 30; i++) {
      saSpec.add(i);
    }
    System.out.println(saSpec);
    System.out.println("");

    // checks isEmpty method - both should evaluate as false
    System.out.println(sa.isEmpty());
    System.out.println(saSpec.isEmpty());
    System.out.println("");
    // loop to check getLength & getValue getter methods and remove method
    for(int i = 0; i < saSpec.getLength(); i++){
      if(saSpec.getValue(i) % 3 == 0) { // if element in array is divisible by 3...
        saSpec.remove(i); // ... remove value divisible by 3
      }
    }

    System.out.println(saSpec); // [1, 2, 3, 4, 5]
    System.out.println("");

    sa.insert(3, 1); // inserts 3 into index 1 of array
    System.out.println(sa); // [8, 3, 4, 6]
    System.out.println("");
    sa.add(2); // adds 2 to the end of array
    System.out.println(sa); // [8, 3, 4, 6, 2]
    System.out.println("");
    sa.insert(10, 3); // inserts 10 into index 3 of array
    System.out.println(sa); // [8, 3, 4, 10, 6, 2]
    System.out.println("");
    sa.remove(2); // removes element from index 2
    sa.remove(1); // removes element from index 1
    sa.remove(0); // / removes element from index 0
    System.out.println(sa); // [10, 6, 2]


  } // end main
} // end class
