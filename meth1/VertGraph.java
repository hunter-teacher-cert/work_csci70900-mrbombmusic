
// number of println based on largest value in the array
// last printed line is index identifiers (0, 1, 2, 3)
// if value is < largestValue, print " ";
// if value is < largestValue - 1, print " " else Print "*""

/*
vertBarGraphify(x)
*
* *
* * *
0 1 2 3

*/

public class VertGraph{

  public static void main (String[] args){
    int [] a = {0,9,2,5, 6, 2, 7};
    vertBarGraphify(a);
  }

  public static void vertBarGraphify(int[] a) {
    int bigVal = largestValue(a);
    while(bigVal > 0) {
      System.out.println(graph(a, bigVal));
      bigVal--;
    }
    System.out.println(printIndex(a));
  }

  public static String printIndex(int[] a) {
    String bottomLine = "";
    for(int i = 0; i < a.length; i++) {
      bottomLine += i + " ";
    }
    return bottomLine;
  }

  public static int largestValue(int[] a ){
    int largestValue = 0;
    for (int i = 0; i < a.length; i++){
      if (a[i] > largestValue){
        largestValue= a[i];
      }
    }
    return largestValue;
  }

  public static String graph(int[] a, int big ){
    String line = "";
    for(int j = 0; j < a.length; j++) {
      if(a[j] < big) {
        line += " ";
      } else {
        line += "*";
      }
      line += " ";

    }
    return line;
  }

}
