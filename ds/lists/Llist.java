import java.io.*;
import java.util.*;


public class Llist{
  private Node front; // the front of the list


  public  Llist(){
    front = null;
  }

  // Add a new node containing data
  // at the front of the list
  public void addFront(String data){
    // make the new node
    Node newFront = new Node(data);
    // point it to what front points to
    newFront.setNext(front);
    // point front to the new node
    front = newFront;
  }

  public String toString(){
    Node currentNode;
    currentNode = front;
    String result = "";
    while (currentNode != null){
      result = result + currentNode + " --> " ;
      currentNode = currentNode.getNext();
    }
    result = result + "null";
    return result;

  }

}
