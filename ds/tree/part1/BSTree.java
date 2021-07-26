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
    }

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
    int newParent = previous.getData(); // initialize variable to hold value of parent node of inserted node
    if(key > newParent){ // if key value is greater than parent node value...
      previous.setRight(new TreeNode(key)); // ... insert new node to the right of parent node
    } else { // if key value is less than parent node value...
      previous.setLeft(new TreeNode(key));  // ... insert new node to the left of parent node
    } // end conditinal
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

    if(this.root ==null) {
      return;
    }

    // iterate through tree to get to value to be deleted
    while(current != null && current.getData() != key) {
      int  currentValue = current.getData();
      if(currentValue == key) {
        break;
      } else if(currentValue < key ) {
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
    }
    // if value has one child - works
    int newParentValue = previous.getData(); // initialize variable for previous node value
    if(current.getLeft() == null) { // if new child is to right of value to be deleted
      TreeNode newChild = current.getRight(); // initialze variable for new child node
      if(key < newParentValue) { // if value to be deleted is left of previous value
        previous.setLeft(newChild); // point previous node at new child on right
      } else { // if value to be delted is right of previous value
        previous.setRight(newChild); // point previous node at new child on left
      }
    } else if (current.getRight() == null) { // if new child is to left of value to be deleted
      TreeNode newChild = current.getLeft(); // initialze variable for new child node
      if(key < newParentValue) { // if value to be deleted is left of previous value
        previous.setLeft(newChild); // point previous node at new child on right
      } else { // if value to be delted is right of previous value
        previous.setRight(newChild); // point previous node at new child on left
      }
    }
    /*
    // if value has 2 children
    if(current.getLeft() != null && current.getRight() != null)  {

        TreeNode replacement = current.getLeft();
         TreeNode prevReplace = null;
        while(replacement.getRight() != null) {
          prevReplace = replacement;
          replacement = replacement.getRight();
        } // end while
        System.out.println(replacement.getData() +", " + newParentValue);
      // } // end if(current.getLeft() != null)
      TreeNode newLeftChild = current.getLeft();
      TreeNode newRightChild = current.getRight();
      // replacement.setLeft(newLeftChild);
      // replacement.setRight(newRightChild);
      if(newParentValue < replacement.getData()) {
      replacement.setRight(current.getRight());
        previous.setRight(replacement);
        // prevReplace.setLeft(null);
        // replacement.setLeft(newLeftChild);
        // current
        // replacement.setLeft(current.getLeft());
        System.out.println(replacement.getRight() + ", " + replacement.getLeft());

      } else {
        previous.setLeft(replacement);
          System.out.println(replacement.getRight() + ", " + replacement.getLeft());
      }

    } // end if(current.getLeft() != null && current.getRight() != null)  {
      */
  }



public void seed(){
  TreeNode t;

  t = new TreeNode(10);
  root = t;
  t = new TreeNode(5);
  root.setLeft(t);
  t = new TreeNode(20);
  root.setRight(t);

  root.getLeft().setRight( new TreeNode(8));

  t = new TreeNode(15);
  root.getRight().setLeft(t);
  // System.out.println(t.getData());

  t = new TreeNode(22);
  root.getRight().setRight(t);


}


}
