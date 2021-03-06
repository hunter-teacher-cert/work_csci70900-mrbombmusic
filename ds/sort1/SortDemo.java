import java.io.*;
import java.util.*;

/*

Setup:
 1.Make a folder under your work repo named: ds
 2. Make another folder under that named sort1
 3. Copy this file and SortDemoDriver.java into the ds/sort1 folder

Lab:

Part 1:
  1. Analyze the two constructors - try to figure out how they work.
  2. Compile and run the program (SortDemoDriver.java and SortDemo.java) and confirm
   the behavior of the constructors.

Part 2:
  1. Read the description of findSmallestIndex and complete the method.
  2. Uncomment the lines in SortDemoDriver to test.

Part 3:
  1. Complete the sort method - read comments for description
  2. Uncomment the lines in sortDemoDriver to test.

*/

public class SortDemo{

    /* Instance Variables */
    private ArrayList<Integer> data;  // to store the data
    private Random r;

  // can you include non-instance variables in a constructor?
  // can you make a constructor and omit certain instance variables?
  // When to use or not use this. ?

    //constructs ArrayList data length 15 filled with random numbers [0,19]
    public SortDemo(){
	    data = new ArrayList<Integer>(); // create new ArrayList of integers
	    r = new Random();  // create variable to hold random number
	    for (int i=0;i<15;i++){ // loop 15 times
	    data.add(r.nextInt(20)); // assign a random integer into ArrayList btwn 0 and 19
    }//for
  }//SortDemo

    //constructs ArrayList data with specified length size filled with random numbers [0,19]
    public SortDemo(int size){ // creates parameterized constructor - argument for size of ArrayList
	     data = new ArrayList<Integer>(); // create new ArrayList of integers
	     r = new Random(); // create variable to hold random number
	     for (int i=0;i<size;i++){//loop size times (= to argument passed through parameter)
	        data.add(r.nextInt(20)); // assign a random integer into ArrayList btwn 0 and 19
	     }
    }//end constructor with parameter

    /*
      return the index of the ArrayList data from index start to the end
      Example, if the arraylist has:
      5,3,10,6,8
      if start was 2 (start at index 2, value 10) then it woudl return 3 which is the index of the value
      6 which is the index with the smallest value from start to end

    */
    //finds the index of the minimum value for the sub-ArrayList from var start to end
    public int findSmallestIndex(int start){
	     int smallIndex = start; // set smallIndex to start argument value

       for (int i= start + 1;i<this.data.size();i++) // loop starting at start value + 1 going to length of ArrayList
       {
         if (this.data.get(i) < this.data.get(smallIndex)) // if value in ArrayList at i index is less value at current smallIndex...
         {
           smallIndex = i; // ...set the smallest index to i
         }
       }//for

	// start a variable at the one after start
	// your code here

	// loop from that variable to end and update smallIndex as needed
	// your code here
	     return smallIndex;  // return the index of the smallest value
    } //end findSmallestIndex

    public int get(int index){
      return data.get(index);
    }


    public void sort(){
      int i; // declare variable for loop
      for (i=0;i < data.size()-1; i++){ // for loop to iterate through data
        // find the smallest index from i to end --use findSmallestIndex
        // your code here
        int currMinIndex = findSmallestIndex(i+1); // initializing variable to store current Minimum index
                                                  //
          // swap the item at that index and i
          // your code here
          swap(i, currMinIndex); // ... swap values in ArrayList indecies
      }
    }

    /*
    allocate temp storage
    put var A in temp
    overwrite var A with var B
    overwrite var B with temp
    */

    // method for swapping two values
    public void swap(int aIndex, int bIndex) {
      int temp = data.get(aIndex); // assigns temp var with value at aIndex
      data.set(aIndex, data.get(bIndex)); // overwrites value at aIndex with value from bIndex
      data.set(bIndex, temp); // overWrites value at bIndex with temp var which held value at aIndex
    }




    /* If you finish the lab early you can get started on this */
    public int linearSearch(int value){
      // loop through the ArrayList data
      // and if the value you're searchign for is in the ArrayList, return it.
      // return -1 if it isn't there.
      for(int i = 0; i < data.size(); i++){
        if(data.get(i) == value) {
          return value; // replace this return
        }
      }
      return -1;

    }

    /* If you finish the lab early you can get started on this */
    public int binarySearch(int value){
      boolean didUpperCrossLower = false;
      int lowerIndex = 0;
      int upperIndex = data.size();
      int middleIndex = data.size()/2;

      /* if upper crosses lower it's not there and the loop should exit the loop
      and if the item is at middle you should exit the loop

      you have to replace the "replacethiswithrealexpression" boolean
      with a correct expression based on lowerIndex and upperIndex
      */
      while (!didUpperCrossLower) // lowerIndex <= upperIndex
      {
        // update lower and upper.
        // remember if value is less than data.get(middleIndex) you want to search next time
        // from lower to the middle and otherwise from the middle to the upper.
        //
        // then update middleIndex based on new lowerIndex and upperIndex.
        if(value < data.get(middleIndex)) {
          upperIndex = middleIndex - 1;
          middleIndex = (upperIndex+lowerIndex)/2;
        } else if (value > data.get(middleIndex)) {
          lowerIndex = middleIndex + 1;
          middleIndex = (upperIndex+lowerIndex)/2;
        } else {
          value = data.get(middleIndex);
          didUpperCrossLower = true;
        }
        if(lowerIndex > upperIndex) {
          value = -1;
          didUpperCrossLower = true;
        }
      }

	/* replace this return to either return the value if it was found and -1
	   if upperIndex and lowerIndex crossed
	*/

	return value; // replace this return
    }


    public String toString(){
	return ""+data;
    };

}

//*------------------------- MERGESORT STUFF -----------------*/
//Work with Eduardo

// Preconditions: a and b are ArrayLists of Integers and
//                both are in increasing order
// Return: a new ArrayList of Integers that is the result
//         of merging a and b. The new ArrayList
//         should be in increasing order
private ArrayList<Integer> merge(ArrayList<Integer> a,
ArrayList<Integer> b){
  ArrayList<Integer> ab = new ArrayList<Integer>(); // initialize new arraylist to merge
  int aIndex = 0; // initialize index counter for a list
  int bIndex = 0; // initialize index counter for b list
  while(aIndex != a.size() && bIndex != b.size()) { // loops until we reach the end of one list
      if(a.get(aIndex) < b.get(bIndex)) { // if value from list a is less than value from list b....
        ab.add(a.get(aIndex)); // ... add value to merged list from list a
        aIndex++; // increment a index counter
      } else { // else if value from list b is less than value from list a...
        ab.add(b.get(bIndex)); // ...add value to merged list from list b
        bIndex++; // increment b index counter
      // } // end nested else
    } // end else
  } // end while
  while(aIndex < a.size()) { // if a index counter is not size of list...
      ab.add(a.get(aIndex)); // ... add values from a list until reach end of list
      aIndex++; // increments a index until end of list is reached
    }
    while(bIndex < b.size()) { // if b index counter is not size of list...
      ab.add(b.get(bIndex)); // ... add values from b list until reach end of list
      bIndex++; // // increments b index until end of list is reached
    } // end else
  return ab; // return merged list
} // end merge


private ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
  if(list.size() < 2) {
    return list;
  } else {
    int size = list.size();
    int half = size/2;
    // checked ArrayList documentation for using subList method
    ArrayList<Integer> a = new ArrayList<Integer>(list.subList(0, half));
    ArrayList<Integer> b = new ArrayList<Integer>(list.subList(half, size));

    a = mergeSort(a);
    b = mergeSort(b);
    return merge(a, b);
  }


}

private ArrayList<Integer> fillForMerge(int size){
  ArrayList<Integer> a = new ArrayList<Integer>();
  int lastVal = r.nextInt(100);
  for (int i = 0 ; i < size ; i=i+1){
    a.add(lastVal);
    // lastVal = lastVal + r.nextInt(10);
     lastVal = r.nextInt(100);
  }
  return a;

}
public void testMerge(){

  ArrayList<Integer> a = new ArrayList<Integer>();
  ArrayList<Integer> b = new ArrayList<Integer>();
  a = fillForMerge(19);

  System.out.println("unsorted list: " + a);

  ArrayList<Integer> msort = mergeSort(a);
  System.out.println("sorted list: " + msort);

}



}
