/*
Data Structures
7/15-16/21
Linked List methods assignment
by
Chris O'Brien
Marina Moshchenko
Liam Baum

*/

import java.io.*;
import java.util.*;


public class Llist{
  private Node front; // the front of the list
  private int size; // instance variable for length of the list


  // constructor to intialize instance variables
  public  Llist(){
    front = null; // initializw fron to null
    size = 0; // initialize size to zero
  }

  //constructer with

  // Add a new node containing data
  // at the front of the list
  public void addFront(String data){
    // make the new node
    Node newNode = new Node(data);
    // point it to what front points to
    newNode.setNext(front);
    // point front to the new node
    front = newNode;
    //update length
    size++;
  }

  public String toString(){
    Node currentNode;
    currentNode = front;
    String result = "";
    while (currentNode != null){
      result = result + currentNode + "->";
      // this is like i=i+1 is for arrays
      // but for linked lists
      currentNode = currentNode.getNext();
    }
    result = result + "null";
    return result;

  }

  // returns True if there is nothing in the list
  // False otherwise
  public boolean isEmpty(){
    return front == null;
  }

  // returns the number of items in the list
  // Hint: look at the toString
  // to remind you how to traverse down the list
  public int length(){
    Node currentNode = front; // initialize new node
    int numItems = 0; // initialize counter variable
    while(currentNode != null) { // iterates through nodes in the list
      numItems++;  // increments each time there is a new node
      currentNode = currentNode.getNext(); // move to the next node in the list
    }

    return numItems; // return n umber of items in list;
  }

  // method to get size instance variable value (the length of the list)
  public int getSize(){
    return this.size;
  }


  // returns the item at location index;
  // returns null if there aren't enough
  // items. Starts with index 0
  public String get(int index){
    Node currentNode; // initialize new node
    int numItems = 0; // initialize counter variable
    currentNode = front; // set currentNode to front (1st node)
    while(currentNode != null) { // iterates through nodes in the list
      if (numItems == index){ // if/when counter variable reaches the requested index...
        return currentNode.getData(); //...return data stored in that node
      }//end if statement
      numItems++;  // increments each time there is a new node
      currentNode = currentNode.getNext(); // move to the next node in the list

    }//end while loop
    return null;

  }//end get

  // sets the item at location index (starting
  // with 0) to value.
  // only sets if the index is within range
  public void set(int index, String value){
    // check to see  if index is in range using length
    if   (index >= this.size){
      System.out.println("Index " + index + " is not in this list.");
    } else{
      Node  currentVar = front; // initialize currentVar as the front node
      int counter = 0; // initialize counter
      while (counter!= index){ // while counter is less than the requested index....
        counter++; //.. increment counter ...
        currentVar = currentVar.getNext(); //... and move to next node in the list
      }
      currentVar.setData(value); // set the value at counter index to requested value argument
    }
    //
  }

  // insert an item before index.
  // only inserts if the index is within bounds
  // Hint: look at toString for hints on
  // traversal and draw out a diagram.
  // You will need a variable that refers to
  // the node BEFORE you want to do the insertion.
  public void insert(int index, String value){
    if(index == 0) { //...if index argument is 0
      this.addFront(value); // ... create new node to the front of list with value argument
    } else { // if
      Node newNode = new Node(value);
      Node currentNode = front;; // initialize new node & set currentNode to front (1st node)
      int numItems = 0; // initialize counter variable
      if(index < this.size) { // check if index argument is within the size of list
        while(currentNode != null) { // iterates through nodes in the list
          if (numItems == index - 1){ // if/when counter variable reaches node before the requested index...
            newNode.setNext(currentNode.getNext()); // ... point new Node at node one after current Node (one before specified index argument)
            currentNode.setNext(newNode); // ... point current node to new node
            break; // exit out of method
          }//end if statement
          numItems++;  // increments each time there is a new node
          currentNode = currentNode.getNext();
          size++; // increment size instance variable
        } // end while
      }
    } // end else
  } // end method

  // returns the index of the first item with
  // data value key. Returns -1 if not found
  public int search(String key){
    int index = 0;// initialize index counter
    while (index != this.size){ // iterates through list until index counter reaches the length of list
      if (this.get(index).equals(key)){ // if value at index of list is same as key argument...
        return index; //.. return the value of index counter and exit method
      }  //end if
      index++; // increment index
    } //end while loop
    return -1; // returns -1 if key argument value is not found in list
  } //end search

  // removes the node at index.
  // does nothing if index out of bounds
  public void remove(int index){
    int currentIndex = 0; //  initialize counter variable
    Node currentNode = front; // initialize new node & set currentNode to front (1st node)
    if (index > this.size){ // if index is greater than size of list
      System.out.println("Index " + index + " is out of bounds " + this.size); //... print message and exit method
    } else { // if index is within size of list
      while (currentNode != null){ //iterates through nodes in the list

        if (currentIndex  == index -1){ // if/when counter variable reaches node before the requested index...
          currentNode.setNext(currentNode.getNext().getNext()); //... point node before specified index to node after specified index
          break;  // since we have by passed the node at specified index, node will be removed and therefore we can exit the method
        } //end if
        currentNode = currentNode.getNext(); // move to the next node in the list
        currentIndex++; // increments each time there is a new node
      } //end while
      size--; // decrement size instance variable
  }//end else




  }//end method


}
