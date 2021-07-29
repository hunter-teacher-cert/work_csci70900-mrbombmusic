import java.io.*;
import java.util.*;

public class Hash {

  private Llist[] hashArray;
  // private Llist2 hashLists;

  // parameterized constructor
  public Hash(int arraySize) {
    hashArray = new Llist[arraySize];
    for(int i = 0; i < arraySize; i++) {
    hashArray[i] = new Llist();
    }
  }

  // constructor
  public Hash() {
    this(8);
  }

  // public int getArrayIndex(int n){
  //   return hashArray[n];
  // }

  private int hashFunc(String key){
    int sum = 0;
    for(int i = 0; i < key.length(); i++){
      sum += key.charAt(i) % 7;
    }
    // return sum % this.hashArray.length;
    return sum;
  }

  private int hashIndex(int hash){
    return hash % this.hashArray.length;
  }

  public String toString() {
    String result = "";
    String keyRef = "";
    int hashLength = this.hashArray.length;
    for(int i = 0; i < hashLength; i++){
      for(int j = 0; j < this.hashArray[i].length(); j++) {
      if(this.hashArray[i].length() > 0) {
        keyRef = "Key: " + this.hashArray[i].getNode(j).getKeyData() +
        ", Value: " + this.hashArray[i].getNode(j).getValueData();
        result = result + keyRef + "\n" + "\n";
      }
    }
  }
    return result;
  }

  public void put(String key, String value) {
    int hashCode = this.hashFunc(key);
    int index = this.hashIndex(hashCode);
    Llist l = this.hashArray[index];
    l.addFront(key, value, hashCode);
  }

/*
  public boolean hasKey(String key){
    int hashCode = this.hashFunc(key);
    int index = this.hashIndex(hashCode);
    boolean isListEmpty = this.hashArray[index].isEmpty();
    int listLength = this.hashArray[index].length();
    // if list at
    if(isListEmpty) {
      // System.out.println(this.hashArray[index].getNode(0).getKeyData() );
      return false;
    } else if (listLength == 1){
      return key == this.hashArray[index].getNode(0).getValueData();
    } else {


    }
  }
*/

  public String get(String key) {
    int hashCode = this.hashFunc(key);
    int index = this.hashIndex(hashCode);
    String value = "";
    if(this.hashArray[index].length() == 1) {
      value = this.hashArray[index].getNode(0).getValueData();
    } else {
      int listIndex = this.hashArray[index].search(key);
      System.out.println(listIndex);
      value = this.hashArray[index].getNode(listIndex).getValueData();
  }
    return value;
  }


}
