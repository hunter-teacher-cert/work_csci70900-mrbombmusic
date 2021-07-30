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

  public Llist getList(int n){
    return this.hashArray[n];
  }


  private int hashFunc(String key){
    int sum = 0;
    for(int i = 0; i < key.length(); i++){
      sum += key.charAt(i) % 7;
    }
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
  public boolean hasKey(String key){
    int hashCode = this.hashFunc(key);
    int index = this.hashIndex(hashCode);
    boolean isListEmpty = this.hashArray[index].isEmpty();
    int counter = 0;
    if(isListEmpty) {
      // System.out.println("List was empty");
      return false;
    }
    while(counter != this.hashArray[index].length()) {
      if(key.equals(this.hashArray[index].getNode(counter).getKeyData())) {
        // System.out.println(key + "is in this table");
        return true;
      }
      counter++;
    }
    // System.out.println(key + "was not in the list");
    return false;
  }


  public String get(String key) {
    int hashCode = this.hashFunc(key);
    int index = this.hashIndex(hashCode);
    String value = "";
    Llist list = this.hashArray[index];
    if(list.length() == 1) {
      value = list.getNode(0).getValueData();
    } else {
      int listIndex = list.search(key);
      value = list.getNode(listIndex).getValueData();
  }
    return value;
  }


}
