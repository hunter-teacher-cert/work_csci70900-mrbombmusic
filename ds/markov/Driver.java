import java.io.*;
import java.util.*;
import java.io.File;
// import java.io.FileNotFoundException;
import java.util.Scanner;


public class Driver {

  public static void main(String[] args){

    Hash h = new Hash(300);
    String path = "/Users/admin/Documents/Hunter/work_csci70900-mrbombmusic/ds/markov/nirvana.txt";
    try {
      File myObj = new File(path);
      Scanner myReader = new Scanner(myObj);
       while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String cleanData = data.replaceAll("!|,", ""); // shown by Lyuba
        String[] split = cleanData.split(" ", -2);
        for(int i = 0; i < split.length - 1; i++){
        h.put(split[i], split[i+1]);
        }
        h.put(split[split.length - 1], "\n");
        // System.out.println(data);
       }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    // System.out.println(h);

    Random rand = new Random();
    Llist startingList = h.getList(rand.nextInt(300));
    while(startingList.isEmpty()) {
      startingList = h.getList(rand.nextInt(300));
    }
    // System.out.println("Random list " + startingList.getNode(0));
    Node startNode = startingList.getNode(0); // get starting node
    String startWord = startNode.getKeyData(); // gets random word to start on
    String newLyrics = startWord + " "; // creates variable to hold all words
    String test = generateWord(h, startWord);

    // System.out.println(test);
    for(int i = 0; i < 100; i++){
    test = generateWord(h, test);
    newLyrics = newLyrics + test + " "; // add new word to lyric string
    }
    System.out.println(newLyrics);

  }

  public static String generateWord(Hash h, String word) {
    ArrayList<String> nextWordChoices = h.getAllValues(word);
    // System.out.println("next word is" + nextWordChoices);
    Random r = new Random();
    int randIndex = r.nextInt(nextWordChoices.size());
    // System.out.println(nextWordChoices.get(randIndex));
    String nextWord = nextWordChoices.get(randIndex);
    return nextWord;
  }

}
