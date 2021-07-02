// Liam Baum, Jovani Cardenas, and Tiffany Wong
/** skeleton file for
 class twoDimArray
  ...practice working with 2D arrays
*/


public class TwoDimArray
{

  //print each row of 2D integer array a on its own line,
  // using a FOR loop
  public static void print1( int[][] a ) {
    System.out.println("Here are all the rows in this array: ");
    for(int i = 0; i < a.length; i++) {
      System.out.print("[");
        for(int j = 0; j < a[i].length; j++) {
          System.out.print(a[i][j]);
            if(j < a[i].length - 1) {
              System.out.print(", ");
            }
        } // end 2nd for loop≤
      System.out.println("]");
    } // end 1st for loop
  } // end method


  //print each row of 2D integer array a on its own line,
  // using a FOREACH loop
  public static void print2( int[][] a ) {
  System.out.println("Here are all the rows in this array: ");
    for(int[] j : a){
		    System.out.print("[");
        int index = 0; //index of each number in a row of a
		    for(int i : j){
			      System.out.print(i);
			      if( index < j.length - 1 ) { // index needed for skipping last comma
				    System.out.print(", ");
			      }
			      index++;
	    	} // end second foreach
		System.out.println("]");
  } // end first foreach
} // end method

  //return sum of all items in 2D integer array a
  public static int sum1( int[][] a ) {
    int sum = 0;
    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < a[i].length; j++) {
        sum += a[i][j];
      }
    }
      return sum;
  }


  //return sum of all items in 2D integer array a
  // using helper fxn sumRow
  public static int sum2( int [][] m ) {
    int sumOfArrays = 0;
    for(int i = 0; i < m.length; i++) {
      sumOfArrays += sumRow2(i, m);
    }
      return sumOfArrays;
  }

 // helper fxn for sum2
 // this is an alternate solution for helpr fxn
 // because we didn't realize we had to use the one below
 // oops
  // public static int sumRow(int[] a) {
  //   int sumOfRow = 0;
  //   for(int i = 0; i < a.length; i++) {
  //     sumOfRow += a[i];
  //   }
  //   return sumOfRow;
  // }


  //return sum of all items on row r of 2D integer array a
  // using a FOR loop
  public static int sumRow( int r, int[][] a ) {
    int sumRow = 0;
    for(int i = 0; i < a[r].length; i++) {
      sumRow += a[r][i];
    }
      return sumRow;
  }


  //return sum of all items on row r of 2D integer array a
  // using a FOREACH loop
  public static int sumRow2( int r, int[][] m ) {
    int sumRow = 0;
    for(int i : m[r]) {
      sumRow += i;
    }
      return sumRow;
  }

  public static void main( String [] args )
  {
       int [][] m1 = new int[4][2];
       int [][] m2 = { {2,4,6}, {3,5,7} };
       int [][] m3 = { {2}, {4,6}, {1,3,5} };
       print1(m1);
       print1(m2);
       print1(m3);
       print2(m1);
       print2(m2);
       print2(m3);
       // System.out.print("testing sum1...\n");
       // System.out.println("sum m1 : " + sum1(m1));
       // System.out.println("sum m2 : " + sum1(m2));
       // System.out.println("sum m3 : " + sum1(m3));
       // System.out.print("testing sum2...\n");
       // System.out.println("sum m1 : " + sum2(m1));
       // System.out.println("sum m2 : " + sum2(m2));
       // System.out.println("sum m3 : " + sum2(m3));
       /* ~~~v~~~~~slide~me~down~as~you~test~~~~~~~~~~~~~~~v~~~
       ~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~*/
  }//end main()

}//end class TwoDimArray
