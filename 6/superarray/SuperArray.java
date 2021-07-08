import java.io.*;
import java.util.*;


public class SuperArray{

  // declare instance variables
  private int numberElements; // number of meaningful elements in array - also index after last meaningful element
  private int[] data; // array that holds values

  // constructor to intitialize instance variables - array gets 2 values
  public SuperArray() {
    this.numberElements = 0;
    this.data = new int[2];
  }

  // parameterized constructor where size of array is provided as argument
  public SuperArray(int size) {
    this.numberElements = 0;
    this.data = new int[size];
  }

  // method to check if array does not contain any meaningful elements
  public boolean isEmpty() {
    return this.numberElements == 0;
  }

  // method to add meaningful element to end of array
  public void add(int value) {
    // check to see that array is large enough to take one more value
    // uses numberElements as reference for
    if(this.numberElements < this.data.length) {
      this.data[this.numberElements] = value; // adds value argument to end of array
      this.numberElements++; // increments number of meaningful values in array
    } else { // if array is not big enough to add one more value...
      grow(); //...call grow method to increase size of array
      this.data[this.numberElements] = value; // add value argument to end of array
      this.numberElements++; // increments number of meaningful values in array
    }
  }

  // method to add value to array at specific index
  public void insert(int value, int index) {
    // check to see that array is large enough to take one more value
    if(this.numberElements == this.data.length) { // if array has no more space to hold new value...
      grow(); // ...increase size of array
    }
    // loop through array starting at the end moving down to the index where new value will be added
    for(int i = this.numberElements; i > index; i--) {
      this.data[i] = this.data[i - 1]; // shift each value up by one index
    }
    this.data[index]= value; // insert value argument at specified index
    this.numberElements++; // // increments number of meaningful elements in array
  }

  // method to remove a value from array at specific index specified by argument
  public void remove(int index) {
    // loops trhough array starting at chosen index to end of array
    for(int i = index; i < this.numberElements -1; i++) {
      this.data[i] = this.data[i + 1]; // shift each value down by one index
    }
    this.data[this.numberElements -1] = 0; // changes last value of array to 0 (non-meaningful element)
    this.numberElements--; // decrements number of meaningful elements in array
    shrink(); // resizes array by removing non-meaningful elements from end of array
  }

  // increases size of array to add additional meaningful elements
  private void grow(){
    // initializes new array that has one additional index space
    int[] newData = new int[this.numberElements + 1];
    // copies all values from data array to new array
    for(int i = 0; i < this.data.length; i++) {
      newData[i] = this.data[i];
    }
    // points data array to new array
    this.data = newData;
  }

  // removes all non-meaningful elements from array and resizes array
  private void shrink() {
    // initializes new array the size of number of meaningful elements
    // this will be one less than the current size of array since numberElements is decremented prior to invoking shrink()
    int[] newData = new int[this.numberElements];
    // copies all meaningful elements from data array to new array
    for(int i = 0; i < this.numberElements; i++) {
      newData[i] = this.data[i];
    }
    // points data array to new array
    this.data = newData;
  }

  // returns number of meaningful elements in array
  public int getNumberElements(){
    return this.numberElements;
  }

  // returns length of array
  public int getLength() {
    return this.data.length;
  }

  // returns value in array at speicifc index provided as argument
  public int getValue(int index) {
    return this.data[index];
  }

  // overriding toString method to return full array as string
  public String toString() {
    return String.format(Arrays.toString(this.data));
  }


}
