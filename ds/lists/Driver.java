import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
      // Demo by Z
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

  /* This work done with Peter Tsun and Marisa Laks
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

  // Testing for Linked List methods with Chris & Marina
  String[] data = {"e", "d", "c", "b", "a"};
  Llist myList = new Llist();
  boolean test = myList.isEmpty();
  System.out.println("How many items? " + myList.length());
  System.out.println("Is myList empty? " + test);
  for (String datum: data){
    myList.addFront(datum);
    System.out.println(myList);
  }

  test = myList.isEmpty();
  System.out.println("Is myList Empty? " + test);
  System.out.println("How many items? " + myList.length());
  String item = myList.get(0);
  System.out.println("0th item is " + item);
  item = myList.get(4);
  System.out.println("4th item is " + item);
  System.out.println("10th item is " + myList.get(10));

  //test set() method, expect 'a->b->x->d->e->null'
  int index = 2;
  String value = "x";
  //myList.set(index, value);
  //test insert(), expect a->b->x ->c->d->e->null'
 myList.insert(index,value);
int searchTest1 = myList.search("c");
System.out.println("Found item at index " + searchTest1);
int searchTest2 = myList.search("z");
System.out.println(searchTest2);

  System.out.println("list w/ x at 2: " + myList);
  System.out.println("Length(): " + myList.length());
  System.out.println("getSize(): " + myList.getSize());
  myList.remove(2);
  System.out.println("List after removing x:" + myList);
  myList.remove(10);
  System.out.println("Length(): " + myList.length());
  System.out.println("getSize(): " + myList.getSize());

// My own Linked List Testing for addFront & remove done independently
/*
  Llist2 list = new Llist2();
  System.out.println("1st list try: ");
  System.out.println(list);
  System.out.println(list.isEmpty());
  list.addFront("d");
  list.addFront("chicken");
  list.addFront("banana");
  list.addFront("apple");
  System.out.println("2nd list try: ");
  System.out.println(list);
  System.out.println(list.isEmpty());
  list.remove(2);
  System.out.println(list);
  list.remove(15);
  System.out.println(list);
*/


    }
}
