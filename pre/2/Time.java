import java.io.*;
import java.util.*;

public class Time {
  public static void main(String[] args) {
    /* Originally had all variables as double
     but I converted all variables to int type after learning
     I could convert data type to double later on.
     The only double needed was for percentage of day.
    */
    int hour = 23; // current hours
    int minute = 55; // current minutes
    int secondsSinceMidnight = ((hour*60)+minute)*60; // seconds in the day
    int secondsTotal = (24*60*60); // total seconds in a day
    int secondsLeft = secondsTotal - secondsSinceMidnight; // seconds left in the day
    int pastHour = 23; // starting time hours
    int pastMinute = 30; // starting time minutes


    System.out.print("The number of seconds since midnight is: ");
    System.out.println(secondsSinceMidnight);

    System.out.print("The number of seconds left in the day is: ");
    System.out.println(secondsLeft);

    // Learned from breakout group you can change data type by putting
    // new data type in parentheses before variable you want to change
    System.out.print("The percentage of the day that has passed is: ");
    System.out.println(((double) secondsSinceMidnight/secondsTotal)*100);

    System.out.print("The elasped time from when I started is ");
    System.out.println((hour - pastHour) + " hours and " + (minute - pastMinute) + " minutes");
  }
}
