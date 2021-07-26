import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
	root = null;
    }

    public int search(int key){
	TreeNode current = root;

	while (current.getLeft() != null && current.getRight() != null){
	    int currentValue = current.getData();
	    if (currentValue == key){
		      return currentValue; // do we want to return this?
	    } else if (currentValue < key){
		// do something else
        current = current.getLeft();
	    } else {
		// do yet another thing
    current = current.getRight();
		}
	}
	// do we really want to return -1?
	return -1;
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

	t = new TreeNode(22);
	root.getRight().setRight(t);

	}


}
