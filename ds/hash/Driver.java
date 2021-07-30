import java.io.*;
import java.util.*;


public class Driver {

  public static void main(String[] args){

    Hash h = new Hash(30);
    System.out.println(h);

    String test = "hello this is a test of string splitting";
    String[] splitTest = test.split(" ", -2);
    System.out.println(Arrays.toString(splitTest));

    for(int i = 0; i < splitTest.length - 1; i++){
    h.put(splitTest[i], splitTest[i+1]);
    }
    h.put(splitTest[splitTest.length - 1], " ");
    //

     // /*
    for(int i = 0; i < 30; i++) {
      System.out.println("index " + i + "= " + h.getList(i) + " ");
      // index++;
    }
 // */
Llist check = h.getList(10);
System.out.println(check.length());
 Node n = check.getNode(0);
// Node n2 = check.getNode(0);
 System.out.println(n.getHashData() + ", " + n.getKeyData());
// System.out.println(n2.getHashData() + ", " + n2.getKeyData());
    // System.out.println(h);
    System.out.println(h.get("of"));
    System.out.println(h.hasKey("hello"));
    System.out.println(h.hasKey("of"));
    System.out.println(h.hasKey("dd"));
    System.out.println(h.hasKey("chicken"));

  }



}
