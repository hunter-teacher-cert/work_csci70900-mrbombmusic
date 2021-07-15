//Team CarBomb

/*
barGraphify(nums)` takes a list of non-negative integers and prints a horizontal bar for each index, commensurate with the value at said index. _Exempli gratia,_ for x = {0,1,2,3}:

barGraphify(x)
0:
1: =
2: ==
3: ===
```
and for x = {1,0,3,2}
```
barGraphify(x)
0: =
1:
2: ===
3: ==
*/



public class BarGraphify {
  public static void main(String[] args){
  int[] a = {6,4,1,7};
  barGraph (a);
  //System.out.println(bar(3));
  }

  public static void barGraph(int[] a) {
    for(int i = 0; i < a.length; i++) {
      System.out.println(i + ":  " + bar(a[i]));
      }
  }

  public static String bar(int n){
    String size = "";
    for (int i = 0; i < n;  i++){
      size = size + "=";
    }
    return size;
  }
}
