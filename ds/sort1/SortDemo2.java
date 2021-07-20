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

public class SortDemo2{

  /* Instance Variables */
  private ArrayList<Integer> data;  // to store the data

  private Random r;


  public SortDemo2(){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<15;i++){
      data.add(r.nextInt(20));
    }

  }

  public SortDemo2(int size){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<size;i++){
      data.add(r.nextInt(20));
    }

  }

  public int get(int index){
    return this.data.get(index);
  }

  /*
  return the index of the ArrayList data from index start to the end
  Example, if the arraylist has:
  5,3,10,6,8
  if start was 2 (start at index 2, value 10) then it woudl return 3 which is the index of the value
  6 which is the index with the smallest value from start to end

  */
  public int findSmallestIndex(int start){
    int smallIndex = start;

    // start a variable at the one after start
    // your code here

    // loop from that variable to end and update smallIndex as needed
    // your code here
    int i;
    for (i = smallIndex + 1; i < this.data.size(); i++){

      if (this.data.get(i) < this.data.get(smallIndex)){
        smallIndex = i;
      }

    }
    return smallIndex;
  }


  public void sort(){
    int i;
    int smallIndex;
    int tmp;
    for (i=0;i < data.size()-1; i++){
      smallIndex = findSmallestIndex(i);
      tmp = data.get(smallIndex);
      data.set(smallIndex,data.get(i));
      data.set(i,tmp);
    }
  }



  /* If you finish the lab early you can get started on this */
  public int linearSearch(int value){


    return 0; // replace this return
  }

  /* If you finish the lab early you can get started on this */
  public int binarySearch(int value){
    return 0;

  }


  public String toString(){
    return ""+data;
  };

  /*------------------------- MERGESORT STUFF -----------------*/


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
      //  System.out.println("aIndex: " + aIndex + ", bIndex: " + bIndex);
      if(a.get(aIndex) == b.get(bIndex)) { // if values are equal in both lists
        ab.add(a.get(aIndex)); // add value to merged list from list a
        ab.add(b.get(bIndex)); // add value to merged list from list b
        aIndex++; // increment a index counter
        bIndex++; // increment b index counter
      } else { // if values from each list are not equal
        if(a.get(aIndex) < b.get(bIndex)) { // if value from list a is less than value from list b....
          ab.add(a.get(aIndex)); // ... add value to merged list from list a
          aIndex++; // increment a index counter
        } else { // else if value from list b is less than value from list a...
          ab.add(b.get(bIndex)); // ...add value to merged list from list b
          bIndex++; // increment b index counter
        } // end nested else
      } // end else
    } // end while
    while(aIndex != bIndex) { // while one index counter has reached list size but other has not
      if(aIndex < bIndex) { // if a index counter is not size of list...
        ab.add(a.get(aIndex)); // ... add values from a list until reach end of list
        aIndex++; // increments a index until end of list is reached
      } else { // if b index counter is not size of list...
        ab.add(b.get(bIndex)); // ... add values from b list until reach end of list
        bIndex++; // // increments b index until end of list is reached
      } // end else
    } // end while
    return ab; // return merged list
  } // end merge


  private ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
    if(list.size() < 2) {
      return list;
    } else {
      int size = list.size();
      int half = size/2;
      ArrayList<Integer> a = new ArrayList<Integer>(list.subList(0, half));
      ArrayList<Integer> b = new ArrayList<Integer>(list.subList(half, size));
      System.out.println(a);
      System.out.println(b);
      // mergeSort(a);
      // mergeSort(b);
      return merge(a, b);
    }


  }

  private ArrayList<Integer> fillForMerge(int size){
    ArrayList<Integer> a = new ArrayList<Integer>();
    int lastVal = r.nextInt(10);
    for (int i = 0 ; i < size ; i=i+1){
      a.add(lastVal);
      lastVal = lastVal + r.nextInt(10);
      // lastVal = r.nextInt(100);
    }
    return a;

  }
  public void testMerge(){

    ArrayList<Integer> a = new ArrayList<Integer>();
    ArrayList<Integer> b = new ArrayList<Integer>();
    a = fillForMerge(10);
    b = fillForMerge(10);
    // System.out.println(a);
    // System.out.println(a.subList(0, 10));
    // ArrayList<Integer> split = mergeSort(a);
    // System.out.println(split);
    System.out.println(a);
    System.out.println(b);
    ArrayList<Integer> ab = merge(a, b);
    System.out.println(ab.size());
    System.out.println(ab);
    

  }



}
