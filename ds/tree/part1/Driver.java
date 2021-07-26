import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) {
      BSTree t = new BSTree();

      t.seed();
      int value;
      // t.insert(6);
      // t.insert(12);
      // t.insert(8);
      // t.insert(1);
      t.insert(20);
      t.insert(16);



      System.out.print("In Order Traversal: ");
      t.inOrderTraverse();
      /*
      System.out.print("Pre Order Traversal: ");
      t.preOrderTraverse();

      System.out.print("Post Order Traversal: ");
      t.postOrderTraverse();
      */
      t.delete(20);
      System.out.print("In Order Traversal: ");
       t.inOrderTraverse();
      /*
      value = t.search(10);
      System.out.println("Value " + value);

      value = t.search(15);
      System.out.println("Value " + value);

      try {
        value = t.search(17);
        System.out.println(value);
      } catch (NullPointerException e) {
        System.out.println("17 not in tree");
      }
      */
    }
}
