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
    this.data = new int[2];
  }

  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  // adds meaningful elements to the end of the array
  public void add( int value )
  {
    
    // test to see if we need to grow, then grow
    // SIMPLE VERSION DOES NOT AUTO-GROW CAPACITY; INSERT MORE CODE HERE LATER
    if(this.numberElements < this.data.length) {
    // add item
    this.data[this.numberElements] = value;
    // increment numberElements
    this.numberElements++;

  } else {
    grow();
  }

  }//end add()

  // getter for data array
  public int getDataElement(int index) {
    return this.data[index];
  }

 // getter for data
  public int[] getData() {
    return this.data;
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
    // prints value in data array at numberElements index
    // issue - will usually print 0 since numberElements is incremented after using add
    // what else should we be printing? What is most useful
    // for(int i = 0; i < numberElements; i++) {
    //
    // }
   return String.format(Arrays.toString(this.data));
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


  */
  private void grow()
  {
    // create a new array with extra space
    // Q: How did you decide how much to increase capacity by?

    //
    int[] newData = new int[this.numberElements*2];
    // copy over all the elements from the old array to the new one

    for(int i = 0; i < this.numberElements; i++) {
      newData[i] = this.data[i];
    }

    // point data to the new array
    this.data = newData;

  //  System.out.println(this.data.length);
    // Q: How does this look when illustrated using encapsulation diagram?

  }//end grow()
}//end class
