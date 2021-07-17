/*
Programming in a High Level Language
7/7/21

 encapsulation / SuperArray Lab
 by
 Liam Baum
 Mr. H
 Marina Moshchenko
*/

import java.io.*;
import java.util.*;

public class SuperArrayDriver
{
  public static void main( String[] args )
  {
    System.out.println("Testing default constructor.");
    SuperArray2 sa = new SuperArray2();

    System.out.println("Testing empty print:");
    System.out.println(sa);
    System.out.println("Testing isEmpty (should be true)");
    System.out.println(sa.isEmpty());
/*
    sa.add(8); // adding 8 to first index of array
    sa.add(7);
    sa.add(6); // this was skipped
    sa.add(5);
    System.out.println(sa);
    sa.remove(0); // expect [8, 7, 5];
    System.out.println(sa);
*/
    // System.out.println("Testing add method");
    // System.out.println(sa.getNumberElements()); // expect 1
    // int i = sa.getNumberElements();
    // System.out.println("Data element = " + sa.getDataElement(i-1)); // expect 8
    // int[] dataCheck = sa.getData();
    // System.out.println("Testing grow: ");
    // System.out.printf("%d\n", dataCheck.length);
    //
    // System.out.println("Checking index value");
    // System.out.printf("%d\n", sa.getDataElement(2)); // expect 5

    // -----------------------------------------------------------
    // YOUR HOMEGROWN/HOUSEMADE/ROLL-YOUR-OWN TEST METHODS HERE...
    // -----------------------------------------------------------

    //precondition: newly-instantiated SuperArray of default capacity
    System.out.println("Testing overfill (calling grow() in add)");
    for (int i=0; i<15; i++) {
      sa.add(i);
    }//for i
    System.out.println(sa);
    System.out.println(sa.isEmpty());
    System.out.println("\nTesting add at index 5, 0 and 17(end)");
    sa.add(100, 5);
    System.out.println(sa);
    sa.add(100, 0);
    System.out.println(sa);
    sa.add(100, 17);
    System.out.println(sa);
    System.out.println("\nTesting remove at 0, 5, and 15 (end)");
    sa.remove(0);
    System.out.println(sa);
    sa.remove(5);
    System.out.println(sa);
    sa.remove(15);
    System.out.println(sa);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//main

}//class SuperArrayDriver
