import java.io.*;
import java.util.*;


public class ArrayListTest {

  public static void main(String[] args) {

    ArrayList<Integer> ints = new ArrayList<Integer>();
    ints.add(8); // adds element to array
    ints.add(6);
    ints.add(7);
    ints.add(5);
    ints.add(309);
    System.out.println(ints); // [8, 6, 7, 5, 309]

    int gotValue = ints.get(4); // returns value at specified index
    System.out.println(gotValue); // 309

    ints.set(0, 9); // changes value at specified index
    System.out.println(ints); // [9, 6, 7, 5, 309];

    ints.remove(2); // removes value at specified index
    System.out.println(ints); // [9, 6, 5, 309];

    int getSize = ints.size(); // returns length of array
    System.out.println(getSize); // 4

    Collections.sort(ints); // sorts elements in array
    System.out.println(ints); // [5, 6, 9, 309]

    ints.clear(); // removes all elements from array
    System.out.println(ints); // []

  }


}
