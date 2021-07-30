import java.io.*;
import java.util.*;


public class Llist{
    private Node front; // the front of the list
    private int listLength = 0;

    public  Llist(){
	front = null;
    }

    // Add a new node containing data
    // at the front of the list
    public void addFront(String key, String value, int hash){
	// make the new node
	Node newNode = new Node(key, value, hash);
	// point it to what front points to
	newNode.setNext(front);
	// point front to the new node
	front = newNode;
  listLength++;
    }

    public String toString(){
	Node currentNode;
	currentNode = front;
	String result = "";
	while (currentNode != null){
	    result = result + currentNode;
	    // this is like i=i+1 is for arrays
	    // but for linked lists
	    currentNode = currentNode.getNext();
	}
	// result = result + "null";
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
      Node currentNode; // initialize new node
      int numItems = 0; // initialize counter variable
      currentNode = front; // set currentNode to front (1st node)
      while(currentNode != null) { // iterates through nodes in the list
        numItems++;  // increments each time there is a new node
        currentNode = currentNode.getNext(); // move to the next node in the list
      }
      return numItems; // return number of items in list;
    }

    // public int length() {
    //   return listLength;
    // }

    // returns the item at location index;
    // returns null if there aren't enough
    // items. Starts with index 0
    public String getKeyValue(int index){
      Node currentNode; // initialize new node
      int numItems = 0; // initialize counter variable
      currentNode = front; // set currentNode to front (1st node)
      while(currentNode != null) { // iterates through nodes in the list
        if (numItems == index){ // if/when counter variable reaches the requested index...
          return currentNode.getKeyData(); //...return data stored in that node
        }//end if statement
        numItems++;  // increments each time there is a new node
        currentNode = currentNode.getNext(); // move to the next node in the list

      }//end while loop
      return null;

    }//end get

    public Node getNode(int index){
      Node currentNode; // initialize new node
      int numItems = 0; // initialize counter variable
      currentNode = front; // set currentNode to front (1st node)
      while(currentNode != null) { // iterates through nodes in the list
        if (numItems == index){ // if/when counter variable reaches the requested index...
          return currentNode; //...return data stored in that node
        }//end if statement
        numItems++;  // increments each time there is a new node
        currentNode = currentNode.getNext(); // move to the next node in the list

      }//end while loop
      return null;

    }//end get

    // returns the index of the first item with
    // data value key. Returns -1 if not found
    public int search(String key){
      int index = 0;// initialize index counter
      while (index != this.length()){ // iterates through list until index counter reaches the length of list
        String keyValue = this.getKeyValue(index);
        if(keyValue.equals(key)){ // if value at index of list is same as key argument...
          return index; //.. return the value of index counter and exit method
        }  //end if
        index++; // increment index
      } //end while loop
      return -1; // returns -1 if key argument value is not found in list
    } //end search

    // removes the node at index.
    // does nothing if index out of bounds
    public void remove(int index){
      int counter = 0; // initialize counter variable
      Node currentNode = front; // initialize new node & set currentNode to front (1st node)
      if(index >= this.length()) {
        System.out.println("You cannot remove something from index: " + index + ". List is only " + this.length() + " nodes long.");
      } else {
      while(currentNode != null) { // iterates through nodes in the list
      if (counter == index - 1){ // if/when counter variable reaches node before the requested index...
          currentNode.setNext(currentNode.getNext().getNext()); // point node before specified index to node after tempnode(one past node we want to remove)
          listLength--;
          break; // since we have by passed the node at specified index, node will be removed and therefore we can exit the method
        }
        counter++;  // increments each time there is a new node
        currentNode = currentNode.getNext(); // move to the next node in the list
      }
    }
  }


}
