import java.io.*;
import java.util.*;



public class Mode{

  private ArrayList<Integer> inputData;
  private Random r;

  public Mode(){
    r = new Random();
    inputData = new ArrayList<Integer>();

    for (int i=0; i < 20; i++){
      inputData.add(r.nextInt(20));
    }
  }

  public Mode(int size){
    r = new Random();
    inputData = new ArrayList<Integer>();

    for (int i=0; i < size; i++){
      inputData.add(r.nextInt(50));
    }
  }

  /**
  * Warmup 1

  Find and return the smallest value in  InputData.
  */

  public int findSmallestValue(){

    int smallestValue = inputData.get(0); //set smallest value to the first value
    //loop through inputData
    for(int i = 1; i < inputData.size(); i++) {
      if(inputData.get(i) < smallestValue) { //check to see if the number at i is smaller than smallest value
        smallestValue = inputData.get(i); //update the smallestValue if we find a smaller value
      } // end if
    } // end for loop

    return smallestValue;

  } // end findSmallestValue

  /**
  * Warmup 2

  Returns the frequency of value in inputData, that is, how often value appears
  */
  public int frequency(int value){
    int counter = 0; // initialize counter to keep track of how many times value appears in data set

    for(int i = 0; i < inputData.size(); i++){ // interate through data set
      if(inputData.get(i) ==  value){ // if value in data set is equal to input value...
        counter++; // ...increment counter

      }//end if
    }//end for
    return counter;
  }

  /**
  *
  This function should calculate and return the mode of inputData.
  The mode is the value that appears most frequently so if inputData contained
  5,3,8,2,5,9,12,5,12,6,5, the mode would return 5 since 5 appears four times.

  If there are multiple modes such as in the case with this data set: 5,5,2,9,9,6 you should return
  either of them (the 5 or the 9).

  Note: you will probably use the frequency function you wrote in
  this solution but not findSmallestValue. the findSmallestValue
  function will help you find a strategy for approaching finding the mode.
  */

  public int calcMode1(){
    // need a variable to freq value
    int freq = 0;
    // create mode variable to hold which value has highest freq
    int mode = inputData.get(0);
    // check the freq of values in data set
    for(int i = 0; i < inputData.size(); i++){ //loops through each element
      int valueAtIndex = inputData.get(i); // stores current value at index i
      if(this.frequency(valueAtIndex) > freq) {   // check freq of one value against others
        freq = this.frequency(valueAtIndex); //updates the frequency
        mode = valueAtIndex; //updates the mode

      }//end if
    }//end for
    return mode;
  } // end calcMode

// skips over values that have already been check in data set
public int calcMode2(){
  // need a variable to freq value
  int freq = 0;
  // create mode variable to hold which value has highest freq
  int mode = inputData.get(0);
  // check the freq of values in data set
  ArrayList<Integer> checked = new ArrayList<Integer>();

  for(int i = 0; i < inputData.size(); i++){ //loops through each element
    int valueAtIndex = inputData.get(i); // stores current value at index i
    if(!checked.contains(valueAtIndex)) { // evaluates if value has already been checked
      checked.add(valueAtIndex); //adds to list of checked items if not already checked
      int currentValueFrequency = this.frequency(valueAtIndex); // sets frequency of current value
      if(currentValueFrequency > freq) {   // check freq of one value against others
        freq = currentValueFrequency; //updates the frequency
        mode = valueAtIndex; //updates the mode
      }//end if
    }//end if
  }//end for
  return mode;
} // end calcMode

  // if checked.contains(valueAtIndex);
  // i++


  public String toString(){
    return ""+inputData;
  }
}
