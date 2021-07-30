import java.io.*;
import java.util.*;

public class Node {

  private int hash;
  private String key;
  private String value;
  private Node next;

  public Node() {
    hash = 0;
    key = "";
    value = "";
    next = null;
  }//default constructor

  public Node(String keyData) {
    hash = 0;
    key = keyData;
    value = "";
    next = null;
  }//constructor(keyData)

  public Node(int hashCode) {
    hash = hashCode;
    key = "";
    value = "";
    next = null;
  }

  public Node(String keyData, Node next) {
    hash = 0;
    key = keyData;
    value = "";
    this.next = next;
  }//constructor(keyData, next)

  public Node(String keyData, String valueData) {
    hash = 0;
    key = keyData;
    value = valueData;
    this.next = null;
  }

  public Node(String keyData, String valueData, Node next) {
    hash = 0;
    key = keyData;
    value = valueData;
    this.next = next;
  }

  public Node(String keyData, String valueData, int hashCode) {
    hash = hashCode;
    key = keyData;
    value = valueData;
    this.next = null;
  }

  // public void setKeyData(String keyData) {
  //   key = keyData;
  // }//setData
  //
  public void setNext(Node n) {
    next = n;
  }//setNext
  //
  // public void setValueData(String valueData){
  //   value = valueData;
  // }

  public void setHash(int hashData) {
    hash = hashData;
  }

  public String getKeyData() {
    return key;
  }//end getkeyData

  public String getValueData(){
    return value;
  }

  public int getHashData(){
    return hash;
  }

  public Node getNext() {
    return next;
  }//getNext

  public String toString() {
    return key;
  }//toString

  public String printList(){
        Node currentVar = this;
        String output ="";
        do {
          output += currentVar.toString();
          currentVar = currentVar.getNext();
        }while (currentVar != null);
        return output;
      }//printList

}//class Node
