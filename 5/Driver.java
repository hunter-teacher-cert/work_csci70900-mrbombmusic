/*
Programing in a High Level Language
In Class Work - 07/06/21
Time Class lab
by
Liam Baum
Mamudu Wally
Eduardo Leite

*/

import java.io.*;
import java.util.*;

/*
- Your driver file should contain code to (in suggested development order)
done - instantiate a newly-created Time object (aka "instance of class Time") with default value(s)
done - instantiate a newly-created Time object with specified value(s)
done - assign a Time var the value null
done - assign a Time var the value of an existing Time var
done - print all of the above (See multiple ways to do this? Try all -- and document in comments!)
done - test for equality of each of the Time instances above. Print results.
done - add two Time objects and print results
done - add two Time objects and save the result in another Time object


- Your Time class definition file should contain code to
- tell a Time object how to do the tasks necessary to achieve the above

*/

public class Driver {

  // method to print instance variables of Time object
  // Takes object as Parameter
  // Issue arises when trying to print Object with value of null because no instance variables exist
  public static void printTime(Time t) {
    System.out.printf("Hour = %02d, Minute = %02d, Second = %04.1f\n", t.hour, t.minute, t.second);

    // revised this method to use print format instead of individual println
    // orignal code is below
    /*
    System.out.print("Hour = ");
    System.out.println(t.hour);
    System.out.print("Minute = ");
    System.out.println(t.minute);
    System.out.print("Second = ");
    System.out.println(t.second);
    */
  }


  public static void main(String[] args) {

    //declare a var of appropriate type to assign an instance of Time to
    Time t;

    // instantiate a newly-created Time object (aka "instance of class Time") with default value(s)
    t = new Time();

    // instantiate a newly-created Time object with specified value(s)
    // declare and instantiate in one line of code
    Time tSpec = new Time(8, 11, 23.5);

    // assign a Time var the value null
    Time tNull = null;

    // assign a Time var the value of an existing Time var
    Time tCopy = tSpec;

    // print all of the above (See multiple ways to do this? Try all -- and document in comments!)

    // listed in order of effectiveness/simplicity

    // #1 - Uses toString method made in Time.java file
    // Originally had as t.toString() to call toString method...
    // but realized that a toString method already exists in a class (prints out hexidecimal reference address of object)
    // and writing this method in your class overrides what is already there and is called automatically
    System.out.println(t);
    System.out.println(tSpec);
    // System.out.println(tNull.toString()); // cannot print out instance variables for object with value of null
    System.out.println(tCopy);

    // #2 - print out using helper method - see comments above method for issue
    // printTime(t);
    // printTime(tSpec);
    // printTime(tNull);
    // printTime(tCopy);
    //
    // //  #3 - print out using println - a lot of print commands need to do this.
    // System.out.println("Here is Time object t: ");
    // System.out.println(t); // prints object
    // System.out.println(t.hour); // prints hour instance variable
    // System.out.println(t.minute); // prints minute instance variable
    // System.out.println(t.second); // prints second instance variable
    // System.out.println("");
    //
    // System.out.println("Here is Time object tSpec: ");
    // System.out.println(tSpec); // prints object
    // System.out.println(tSpec.hour); // prints hour instance variable
    // System.out.println(tSpec.minute); // prints minute instance variable
    // System.out.println(tSpec.second); // prints second instance variable
    // System.out.println("");
    //
    // System.out.println("Here is Time object tNull: ");
    // System.out.println(tNull); // prints object
    // // cannot print out instance variables for object with value of null
    // // because instance variables do not exist
    //
    // System.out.println("");
    // System.out.println("Here is Time object tCopy: ");
    // System.out.println(tCopy); // prints object
    // System.out.println(tCopy.hour); // prints hour instance variable
    // System.out.println(tCopy.minute); // prints minute instance variable
    // System.out.println(tCopy.second); // prints second instance variable

    // test for equality of each of the Time instances above. Print results.

    System.out.println(t.equals(tSpec)); // should be false because....
                                         // t == hour = 0, minute = 0, second = 0.0
                                         // tSpec == hour = 8, minute = 11, second = 23.5

    System.out.println(t.equals(tCopy)); // should be false because....
                                         // t == hour = 0, minute = 0, second = 0.0
                                         // tCopy == hour = 8, minute = 11, second = 23.5

    // System.out.println(t.equals(tNull)); // will not evaluate because tNull instance variables do not exist

    System.out.println(tSpec.equals(tCopy)); // should be true because both are the same object with same instance variables

    Time tEqual = new Time(8, 11, 23.5); // made new Object with same instance variable values to use for equals method test
    System.out.println(tSpec.equals(tEqual)); // should be true


    // add two Time objects and print results
    System.out.println("Here are the added objects: ");
    System.out.println(t.add(tSpec)); // adds instance variables of t and tSpec

    // add two Time objects and save the result in another Time object
    Time tAdd = new Time(2, 2, 2.0); // new time object to test add method
    Time tSum = tAdd.add(tSpec); // expect to see 10, 13, 25.5

    System.out.println("Here is the added objects in new Object: ");
    System.out.println(tSum);

  }//end main()

}//end class
