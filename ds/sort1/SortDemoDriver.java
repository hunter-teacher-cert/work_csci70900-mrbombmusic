import java.io.*;
import java.util.*;

public class SortDemoDriver {
    public static void main(String[] args) {

	SortDemo sd = new SortDemo();
	System.out.println(sd);

	SortDemo sd2 = new SortDemo(20);
	System.out.println(sd2);
/*
	int i;
	i = sd.findSmallestIndex(5);
	System.out.println("sd["+ i +"] = "+sd.get(i)+" : " + sd);

	i = sd2.findSmallestIndex(10);
	System.out.println("sd2["+ i +"] = "+sd2.get(i)+" : " + sd2);
  /* part 2 test lines */
  System.out.println(sd);
  sd.sort();
  System.out.println(sd);
  int foundIt = sd.binarySearch(8);
  System.out.println(foundIt);
  /*
	*/

	/* part 3 test lines */
	/*
	*/
    }
}
