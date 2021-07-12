import java.io.*;
import java.util.*;

public class Time {
  // your implementation of class Time here

  // create instance variables
  int hour;
  int minute;
  double second;

  // Contructor method to initialize default values for instance variables
  public Time() {
    this.hour = 0;
    this.minute = 0;
    this.second = 0.0;
  }

  // Parameterized Construtor method where values for instance variables are passed as arguments
  public Time(int hour, int minute, double second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  // method to print instance variables of Time object
  // Takes object as Parameter

  // Issue arises when trying to print Object with value of null because no instance variables exist

  public static void printTime(Time t) {
    System.out.printf("Hour = %02d, Minute = %02d, Second = %04.1f\n", t.hour, t.minute, t.second);

    // revised this method to use print format instead of individual println
    // orignal code is below
    /*
    System.out.print("Hour = ");
    System.out.println(t.hour);
    System.out.print("Minute = ");
    System.out.println(t.minute);
    System.out.print("Second = ");
    System.out.println(t.second);
    */
  }

  // method to print out instance variables of Object
  public String toString() {
    return String.format("hour = %02d, minute = %02d, second = %04.1f\n", this.hour, this.minute, this.second);
  }

  // method to check for equality of this objects instance variables with another Time object
  public boolean equals(Time t) {
    return this.hour == t.hour
    && this.minute == t.minute
    && this.second == t.second;
  }

  // method to add two Time objects together
  public Time add(Time t) {
    Time sumTime = new Time(); // initialized new Time object with default instance variables
    sumTime.hour = this.hour + t.hour; // adds hour of Object method is called on plus Oject used as argument and assigns sumTime object instance variable
    sumTime.minute = this.minute + t.minute; // adds minute of Object method is called on plus Oject used as argument and assigns sumTime object instance variable
    sumTime.second = this.second + t.second; // adds second of Object method is called on plus Oject used as argument and assigns sumTime object instance variable
    return sumTime; // returns new Time object with added instance variables from both objects
  }

}//end class
