import java.io.*;
import java.util.*;


public class Driver {

  public static void main(String[] args){

    Hash h = new Hash(30);
    System.out.println("Is the table empty? " + h.isEmpty()); // isEmpty test on empty table

    String test = "hello this is a test of string splitting";

    String[] splitTest = test.split(" ", -2); // https://www.geeksforgeeks.org/split-string-java-examples/
    System.out.println(Arrays.toString(splitTest));

    for(int i = 0; i < splitTest.length - 1; i++){
    h.put(splitTest[i], splitTest[i+1]);
    }
    h.put(splitTest[splitTest.length - 1], " ");

    System.out.println("Is the table empty? " + h.isEmpty()); // isEmpty test on populated table

    // prints out each index of table array and values at each index
    for(int i = 0; i < 30; i++) {
      System.out.println("index " + i + "= " + h.getList(i) + " ");
    }

    Llist check = h.getList(10); // check getList method
    System.out.println(check.length());
    Node n = check.getNode(0);
    Node n2 = check.getNode(0);
    System.out.println(n.getHashData() + ", " + n.getKeyData()); // check getHashData method to retreive hash code
    System.out.println(n2.getHashData() + ", " + n2.getKeyData()); // check getHashData method to retreive hash code
    System.out.println(h); // print table
    System.out.println("The value for 'of' is " + h.get("of"));
    System.out.println("The value of chicken is" + h.get("chicken"));
    System.out.println(h.hasKey("hello")); // hasKey test for only key in list
    System.out.println(h.hasKey("of")); // test for 2nd node in list
    System.out.println(h.hasKey("dd")); // test for key not in table with hash value the same as a key in the table
    System.out.println(h.hasKey("chicken")); // test for key not in table

    h.remove("of"); // remove test for 2nd node in list
    h.remove("hello"); // remove test for only node in list
    System.out.println(h.hasKey("of")); // check for removed node
    System.out.println(h.hasKey("hello")); // check for removed node
    // System.out.println(h);
    h.remove("dd"); // remove test for key not in table with hash value the same as a key in the table
    h.remove("chicken"); // remove test for key not in table

  }



}
