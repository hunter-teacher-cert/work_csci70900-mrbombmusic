import java.io.*;
import java.util.*;


public class Driver {

  public static void main(String[] args){

    Hash h = new Hash(30);
    System.out.println(h);

    String test = "hello this is a test of test string splitting";
    String[] splitTest = test.split(" ", -2);
    System.out.println(Arrays.toString(splitTest));

    for(int i = 0; i < splitTest.length - 1; i++){
    h.put(splitTest[i], splitTest[i+1]);
    }
    h.put(splitTest[splitTest.length - 1], " ");
    //

    System.out.println(h);
    System.out.println(h.get("hello"));
    System.out.println(h.hasKey("hello"));
    System.out.println(h.hasKey("chicken"));

  }



}
