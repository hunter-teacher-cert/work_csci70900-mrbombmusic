/**
  Programming in a High Level Language
  7/7/21

   encapsulation / SuperArray Lab
   by
   Liam Baum
   Mr. H
   Marina Moshchenko

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
    // change the size of the array
    grow();
    // add new value to next index in new array size
    this.data[this.numberElements] = value;
    // increment numberElements
    this.numberElements++;
  }
  }//end add()

  // method to insert value at specifc index of array
  public void insert(int value, int index) {
    // check if array is big enough to hold one more value
    if(this.numberElements + 1 >= this.data.length) {
      // increase size of array
      grow();
    }
    // shift all values after index to next spot
    for(int i = numberElements; i > index; i--) {
      this.data[i] = this.data[i  -1];
    }
    // adds new value to index
    this.data[index] = value;
  }

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

  // prints out array
  public String toString()
  {
   return String.format(Arrays.toString(this.data));
  }//end toString()

  // method to remove a element from specifc index of array
  public void remove(int index) {

    // shift all values after index to previous spot
    for(int i = index; i < this.numberElements - 1; i++) {
      this.data[i] = this.data[i + 1];
    }
    // adds non-meaning
    this.data[this.numberElements - 1] = 0;
    this.numberElements--;
  }

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
    int[] newData = new int[this.numberElements*2];
    // copy over all the elements from the old array to the new one
    for(int i = 0; i < this.numberElements; i++) {
      newData[i] = this.data[i];
    }
    // point data to the new array
    this.data = newData;

  }//end grow()
}//end class
