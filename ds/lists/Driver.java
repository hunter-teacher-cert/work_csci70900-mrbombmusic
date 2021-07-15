import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	// Node n;
	// n = new Node();
	// n.setData("Eduardo");
  //
  //
	// Node n2 = new Node("Brian");
	// n.setNext(n2);
  //
	// System.out.println(n);
  //
	// System.out.println(n2);
  //
	// System.out.println(n.getNext());
	// n.getNext().setNext(new Node("Steph"));
	// System.out.println(n2.getNext());
	// System.out.println(n.getNext().getNext());
  /*
	Node L; // initialize Node 1
	// 1.Create a new  list that looks like:
	//   L->"a"->"b"->"c"->"d"
  L = new Node("a"); // set value to Node 1
  Node L2 = new Node("b"); // initialize and set value for Node 2
  L.setNext(L2); // Point node 1 to node 2
  L.getNext().setNext(new Node("c")); // initialize and set value for Node 3 after Node 2
  L2.getNext().setNext(new Node("d")); // initialize and set value for Node 4 after node 3
  System.out.println(L + ", " + L2 + ", " + L2.getNext() + ", " + L2.getNext().getNext());

  Node LX = new Node("x", L2.getNext()); // initialize node X and point to node 3
  L2.setNext(LX); // tell node 2 that LX is next
  // System.out.println(L2 + ", " + L2.getNext() + ", " + LX.getNext()); // prediction - "b" "x" "c"
  System.out.println(L.printList());
	// 2. Write the code to insert an "x"
	//    between the b and the c
	// 3. Write the code to delete the c
  LX.setNext(LX.getNext().getNext()); // point node x to node 4 thereby bypassing node 3
  // System.out.println(L2 + ", " + L2.getNext() + ", " + LX.getNext()); // prediction-  b, x, d
  */

  Llist list = new Llist();
  System.out.println("1st list try: ");
  System.out.println(list);
  list.addFront("d");
  list.addFront("chicken");
  list.addFront("banana");
  list.addFront("apple");
  System.out.println("2nd list try: ");
  System.out.println(list);


    }
}
