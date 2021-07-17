import java.io.*;

import java.util.*;

public class Dlist{




    private Node front;
    private Node prev;
    private int size;

    public Dlist{
      front = null;
      prev = null;
      size = 0;
    }

    public void addFront(String data){
      // make the new node
      Node newNode = new Node(data);
      // point it to what front points to
      newNode.setNext(front);
      // point front to the new node
      front = newNode;
      //update length
      size++;
    }



}
