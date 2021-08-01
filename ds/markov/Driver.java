import java.io.*;
import java.util.*;
import java.io.File;
// import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Nirvana lyrics - text versions from:
https://www.kaggle.com/paultimothymooney/poetry?select=nirvana.txt
Songs used:

Heart Shaped Box
Drain You
On a Plain
Something in the Way
PennyRoyal Tea
Smells Like Teen Spirit
All Apologies
Serve the Servants
Scentless Apprentice
Milk It
Sliver
Frances Farmer will have her Revenge on Seattle
Sappy
In Bloom
Dumb
Polly
About a Girl
Lithium
Come as You Are
*/

public class Driver {

  public static void main(String[] args){
    int tableSize = 977;
    Hash h = new Hash(tableSize);
    //code for reading .txt files
    //https://www.w3schools.com/Java/java_files_read.asp
    String path = "/Users/admin/Documents/Hunter/work_csci70900-mrbombmusic/ds/markov/nirvana.txt";
    try {
      File myObj = new File(path);
      Scanner myReader = new Scanner(myObj);
      String lastWord = "";
       while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String cleanData = data.replaceAll("!|,|-|", ""); // shown by Lyuba
        String[] split = cleanData.split(" ", -2);
        h.put(lastWord, split[0]);
        for(int i = 0; i < split.length - 1; i++){
        h.put(split[i], split[i+1]);
        }
        lastWord = split[split.length-1];
        // h.put(split[split.length - 1], "\n");
        // System.out.println(data);
       }
       h.put(lastWord, "\n");
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
     // System.out.println(h.getList(2).getNode(1).getHashData());
     // System.out.println(h.getList(22).getNode(0).getHashData());
     /*
     for(int i = 0; i < tableSize; i++){
       System.out.println("Index " + i + " = " + h.getList(i) + " ");
     }

     */
    Random rand = new Random();
    Llist startingList = h.getList(rand.nextInt(tableSize));
    while(startingList.isEmpty()) {
      startingList = h.getList(rand.nextInt(tableSize));
    }
    // System.out.println("Random list " + startingList.getNode(0));
    Node startNode = startingList.getNode(0); // get starting node
    String startWord = startNode.getKeyData(); // gets random word to start on
    String newLyrics = startWord + " "; // creates variable to hold all words
    String word = generateWord(h, startWord);
    String nextWord = "";
    // System.out.println(test);
    for(int i = 0; i < 100; i++){
    // System.out.println("Word being sent to generate function is " + word);
    nextWord = generateWord(h, word);
    // System.out.println("Word = " + word + ", nextWord = " + nextWord);
     /*
    if(word.equals("\n") && nextWord.equals("\n")) {
    ArrayList<String> notNewLine = h.getList().search("\n");
    System.out.println("Word that is not newLine is: " + notNewLine);
  }

     */
    word = nextWord;
    // System.out.println("Word returned by generate function is " + nextWord);
    // System.out.println("loop #" + i);
    // System.out.println();
    newLyrics = newLyrics + word + " "; // add new word to lyric string
    }
    System.out.println("");
    System.out.println(newLyrics);
    System.out.println("");
    // /*
  }

  public static String generateWord(Hash h, String word) {
    // System.out.println("generating word....." + word);
    // char c = word.charAt(0);
    // int a = c;
    // System.out.println("Ascii value of " + word + " = " + a);
    ArrayList<String> nextWordChoices = h.getAllValues(word);
    // while(nextWordChoices == null) {
    //
    // }
     // System.out.println("next word is" + nextWordChoices);
    Random r = new Random();
    int randIndex = r.nextInt(nextWordChoices.size());
    // System.out.println("size of next array is " + nextWordChoices.size());
    while(nextWordChoices.get(randIndex).equals(null)){
      randIndex = r.nextInt(nextWordChoices.size());
    }
    // System.out.println("The next word chosen is: " + nextWordChoices.get(randIndex));
    String nextWord = nextWordChoices.get(randIndex);

    // System.out.println("");
    return nextWord;
  }

}
