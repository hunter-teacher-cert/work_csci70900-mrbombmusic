import java.io.*;
import java.util.*;

public class BSTree {
  private TreeNode root;

  public BSTree(){
    root = null;
  }



  public int search(int key){
    TreeNode current = root;

    while (current != null){
      int currentValue = current.getData();
      if (currentValue == key){
        return key;
      } else if (currentValue < key){
        // do something else
        current = current.getRight();
      } else {
        // do yet another thing
        current = current.getLeft();
      }
    }
    throw new NullPointerException();
  }

  public void insert(int key){
    TreeNode current = root; // set variable to hold current node
    TreeNode previous = null; // set variable to hold piggybacked node

    // checks if tree is empty
    // if true, inserts new node at root
    if(this.root == null) {
      this.root = new TreeNode(key);
    } else {

    while (current != null){ // interate through tree until reaching end
      int currentValue = current.getData(); // initialize variable to hold current node data
      if(currentValue == key) { // if tree already contains value to be inserted...
        return; //... exit method
      } else if (currentValue < key){ // if current node data is less than value to be inserted...
        previous = current; //...set piggybacked node to current node...
        current = current.getRight(); // ... set current node to next node on right
      } else { // if current node data is greater than value to be inserted...
        previous = current; //...set piggybacked node to current node...
        current = current.getLeft();  // ... set current node to next node on left
      } // end conditional
    } // end while

    if(key > previous.getData()){ // if key value is greater than parent node value...
      previous.setRight(new TreeNode(key)); // ... insert new node to the right of parent node
    } else { // if key value is less than parent node value...
      previous.setLeft(new TreeNode(key));  // ... insert new node to the left of parent node
    } // end conditional
  }
  } // end inert method

  private void inOrderTraverse(TreeNode current) {
    if(current == null){
      return;
    }

    this.inOrderTraverse(current.getLeft());
    System.out.print(current.getData() + ", ");
    this.inOrderTraverse(current.getRight());
  }

  public void inOrderTraverse() {
    this.inOrderTraverse(this.root);
    System.out.println("");
  }

  private void preOrderTraverse(TreeNode current) {
    if(current == null){
      return;
    }

    System.out.print(current.getData() + ", ");
    this.preOrderTraverse(current.getLeft());
    this.preOrderTraverse(current.getRight());
  }

  public void preOrderTraverse() {
    this.preOrderTraverse(this.root);
    System.out.println("");
  }

  private void postOrderTraverse(TreeNode current) {
    if(current == null){
      return;
    }

    this.postOrderTraverse(current.getLeft());
    this.postOrderTraverse(current.getRight());
    System.out.print(current.getData() + ", ");
  }

  public void postOrderTraverse() {
    this.postOrderTraverse(this.root);
    System.out.println("");
  }

  public void delete(int key) {
    TreeNode current = root;
    TreeNode previous = null;
    if(current.getData() == key) {
    TreeNode tempRoot = new TreeNode(key - 1);
    System.out.println("here");
    previous = tempRoot;
    System.out.println(previous.getData());
    // previous.setRight(current);
    }
    // if tree is empty
    if(this.root ==null) {
      return;
    }

    // iterate through tree to get to value to be deleted
    while(current != null && current.getData() != key) {
      int  currentValue = current.getData();
      if(currentValue < key ) {
        previous = current;
        current = current.getRight();
      } else {
        previous = current;
        current = current.getLeft();
      }
    }

    // if value to be deleted was not in tree
    if(current == null){
      return;
    }

    // if value to be deleted in on leaf node - works
    if(current.getLeft() == null && current.getRight() == null) {
      if(key < previous.getData()) {
        previous.setLeft(null);
      } else {
        previous.setRight(null);
      }
    } // end leaf conditional

    // if value has one child - works
    if(current.getLeft() == null) { // if new child is to right of value to be deleted
      TreeNode newChild = current.getRight(); // initialze variable for new child node
      if(key < previous.getData() ) { // if value to be deleted is left of previous value
        previous.setLeft(newChild); // point previous node at new child on right
      } else { // if value to be delted is right of previous value
        previous.setRight(newChild); // point previous node at new child on left
      }
    } else if (current.getRight() == null) { // if new child is to left of value to be deleted
      TreeNode newChild = current.getLeft(); // initialze variable for new child node
      if(key < previous.getData() ) { // if value to be deleted is left of previous value
        previous.setLeft(newChild); // point previous node at new child on right
      } else { // if value to be delted is right of previous value
        previous.setRight(newChild); // point previous node at new child on left
      }
    } // end one child conditional

    // if value has 2 children - replaces data in node meant to be deleted - works

    if(current.getLeft() != null && current.getRight() != null)  {
      TreeNode replacement = current.getLeft(); // set replacement node to left of node to be deleted
      while(replacement.getRight() != null) { // loop to go as far right as possible to find largest value in left subtree
        replacement = replacement.getRight(); // set replacement to next node to the right
      } // end while
      int replacementData = replacement.getData(); // variable to store value of replacement node
      this.delete(replacement.getData()); // delete replacement node
      current.setData(replacementData); // assigned value of replacement node to node containing value to be deleted
    } // end two child conditional

    /*
    // if value has two children - repointing method
    // does not work for root or if replacement node has left child


    if(current.getLeft() != null && current.getRight() != null)  {
      TreeNode replacement = current.getLeft(); // set replacement node to left of node to be deleted
      TreeNode prevReplace = null;

      while(replacement.getRight() != null) { // loop to go as far right as possible to find largest value in left subtree
        prevReplace = replacement;
        replacement = replacement.getRight(); // set replacement to next node to the right

      } // end while
      if(prevReplace == null) {
      replacement.setRight(current.getRight()); // set replacement node to right node of to be deleted node
      previous.setLeft(replacement); // set previous node to replacement node
      this.delete(current.getData()); // delete specified node
    } else {
      if(current.getData() > previous.getData()) {
      replacement.setRight(current.getRight());
      previous.setRight(prevReplace);
      // System.out.println("gonna print current > previous");
      this.delete(current.getData());
      replacement.setLeft(prevReplace);
      prevReplace.setRight(null);
      previous.setRight(replacement);
    } else {
      replacement.setRight(current.getRight());
      previous.setLeft(prevReplace);
      // System.out.println("gonna print current > previous");
      this.delete(current.getData());
      // replacement.setLeft(prevReplace);
      // prevReplace.setRight(null);
      // previous.setLeft(replacement);
    }
    }

  }
  */


} // end delete



    public void seed(){
      TreeNode t;

      t = new TreeNode(10);
      root = t;
      t = new TreeNode(5);
      root.setLeft(t);
      t = new TreeNode(20);
      root.setRight(t);

      root.getLeft().setRight( new TreeNode(8));

      t = new TreeNode(14);
      root.getRight().setLeft(t);
      // System.out.println(t.getData());

      t = new TreeNode(22);
      root.getRight().setRight(t);


    }


  }
