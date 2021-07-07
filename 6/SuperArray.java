/**
   lab skeleton
   encapsulation / SuperArray

   SuperArray is a wrapper class for an array.
   Provides "pass-thru" accessibility to array capabilities:
   - get/set by index
   - get length
   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
 **/

import java.io.*;
import java.util.*;

public class SuperArray
{
  //instance vars
  private int[] data;           //where the actual data is stored
  private int numberElements;   //number of "meaningful" elements - same as 'end' from discussion


  // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
  //overloaded constructor -- allows specification of initial capacity

  public SuperArray( int size )
  {
    this.numberElements = 0;
    this.data = new int[size];
  }

  //default constructor -- initializes capacity to 10
  public SuperArray()
  {
    this.numberElements = 0;
    this.data = new int[10];
  }

  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  // adds meaningful elements to the end of the array
  public void add( int value )
  {
    // test to see if we need to grow, then grow
    // SIMPLE VERSION DOES NOT AUTO-GROW CAPACITY; INSERT MORE CODE HERE LATER
    if(numberElements <= data.length) {
    // add item
    this.data[this.numberElements] = value;

    // increment numberElements
    this.numberElements++;
  }

  }//end add()

  // getter for data array
  public int getDataElement(int index) {
    return this.data[index];
  }

  // getter for numberElements
  public int getNumberElements() {
    return this.numberElements;
  }


  // checks to see if array is empty of meaningful values
  public boolean isEmpty()
  {
   return numberElements == 0;
  }

  // prints out element in format
  public String toString()
  {
   return String.format("%d\n", this.data[this.numberElements]);
  }//end toString()
  /*


  // public int get(int index)
  // {
  //
  // }



  //helper method for debugging/development phase
  // public String debug()
  // {
  //   String s = "";
  //   s = "Size: " + this.data.length;
  //   s = s + " LastItem: " + numberElements + "  Data: ";
  //   for (int i = 0; i < numberElements; i++) {
  //     s = s + data[i] + ", ";
  //   }
  //   s = s + "\n";
  //   return s;
  // }//end debug()


  private void grow()
  {
    // create a new array with extra space
    // Q: How did you decide how much to increase capacity by?

    // copy over all the elements from the old array to the new one

    // point data to the new array
    // Q: How does this look when illustrated using encapsulation diagram?

  }//end grow()
*/
}//end class
