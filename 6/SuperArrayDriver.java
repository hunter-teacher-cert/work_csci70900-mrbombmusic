import java.io.*;
import java.util.*;

public class SuperArrayDriver
{
  public static void main( String[] args )
  {
    System.out.println("Testing default constructor.");
    SuperArray sa = new SuperArray();

    System.out.println("Testing empty print:");
    System.out.println(sa);
    System.out.println("Testing isEmpty (should be true)");
    System.out.println(sa.isEmpty());

    sa.add(8); // adding 8 to first index of array
    System.out.println("Testing add method");
    System.out.println(sa.getNumberElements()); // expect 1
    int i = sa.getNumberElements();
    System.out.println("Data element = " + sa.getDataElement(i -1)); // expect 8
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
    sa.add(5, 100);
    System.out.println(sa);
    sa.add(0, 100);
    System.out.println(sa);
    sa.add(17, 100);
    System.out.println(sa);

    System.out.println("\nTesting remove at 0, 5, and 15 (end)");
    sa.remove(0);
    System.out.println(sa);

    sa.remove(5);
    System.out.println(sa);

    sa.remove(15);
    System.out.println(sa);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//main

}//class SuperArrayDriver
