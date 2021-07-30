import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) {
      BSTree t = new BSTree();
    //
      t.seed();
      int value;
    //
    t.insert(2);
    t.insert(4);
		t.insert(16);
    t.insert(23);
    t.insert(26);
    t.insert(15);
    t.insert(3);
    // Random r = new Random();
    // for(int i = 0; i < 16; i++) {
    //   t.insert(r.nextInt(8));
    // }

    t.inOrderTraverse();

    t.delete(5);
    t.inOrderTraverse();
    /*
    t.preOrderTraverse();
    t.postOrderTraverse();
    */
      /*
      value = t.search(10);
      System.out.println("Value" + value);

      value = t.search(15);
      System.out.println("Value" + value);

      try {
        value = t.search(17);
        System.out.println(value);
      } catch (NullPointerException e) {
        System.out.println("17 not in tree");
      }
      */

    }
}
