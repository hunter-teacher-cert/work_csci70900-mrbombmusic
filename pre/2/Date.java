import java.io.*;
import java.util.*;

public class Date {
  public static void main(String[] args) {
    String day = "Friday";
    int date = 23;
    String month = "April";
    int year = 2021;

    System.out.println("American Format: ");
    System.out.println(day + ", " + month + " " + date + ", " + year);
    System.out.println("European Format: ");
    System.out.println(day + " " + date + " " + month + " " + year);
  }
}
