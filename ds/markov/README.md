### Markov Chain Lyric Generator using Hash Table

## How It Works
This project implemented a Markov chain which is used to generate<br>
lyrics based on multiple Nirvana songs. This is done by breaking the song lyrics<br>
into individual words and storing them in a Hashtable. Each word is assigned as a key.<br>
Every time this key appears in the lyrics, the word which follows it is stored as a value pair<br>
associated with this key.<br>

To generate lyrics, the program choses a key word at random.<br>
It then randomly chooses from all the value pair words which are associated with this key word.<br>
A word can be stored multiple times as a value pair for each time it appears in the lyrics<br>
following the key word. This will increase the probability that it will be chosen as the word<br>
to follow the chosen key word when generating lyrics.<br>
Once a word has been generated to follow the key word, that word is then becomes the key word and<br>
a word is randomly chosen from all the value pair words associated with it.<br>
This process repeats for a specified number of times that is determined in the program.<br>
<br>
The data for the song lyrics was taken from this website: <br>
https://www.kaggle.com/paultimothymooney/poetry?select=nirvana.txt<br>

**Songs used:**<br>

- Heart Shaped Box
- Drain You
- On a Plain
- Something in the Way
- PennyRoyal Tea
- Smells Like Teen Spirit
- All Apologies
- Serve the Servants
- Scentless Apprentice
- Milk It
- Sliver
- Frances Farmer will have her Revenge on Seattle
- Sappy
- In Bloom
- Dumb
- Polly
- About a Girl
- Lithium
- Come as You Are

## Sample Output
**Note: All Line breaks are made by the program.**
```
ugly okay
My heart is about me home
Love myself
I do?
I'm a new complaint
Forever in debt to feed him happy
He'll cover you
I'm so are made into your way
It's fun to sell your priceless advice your infection
Chew my dinner there
But
I'm to shoot his gun

But
I feel stupid and name her milk
Doll steak test meat for food
She eyes me take a passionate kiss
From my bones grew they have been drawn into perfume
I do?
I'm not gonna crack
I think you're happy
He'll cover you
I can pretend
The black
```

## Under the Hood

This project uses the Hash Table which I implemented as part 1 of the final project<br>
The code for this Hash Table can be found [here](https://github.com/hunter-teacher-cert/work_csci70900-mrbombmusic/tree/master/ds/hash). <br>

The Hash Table includes a Node, Linked List and Hash class to implement the Hash Table.<br>
The code to generate lyrics is written in the Driver<br>

I included the following additions/changes/modifications to each class<br>
from what was implemented in the Hash Table project: <br>

### Node

- The data for Value in each node was changed from a single String to an ArrayList of Strings. This was done in order to store multiple words which would follow the key word.

- The parameterized constructor functions which take arguments for the value data had to first initialize a new ArrayList and then use the .add() method for that list to add a new value to the ArrayList.

- I included some additional get methods for this value data Array list. This included a method to return the value at index 0 of the ArrayList, a method to return the value at a specified index passed as an argument and a method to return to entire ArrayList of value data.

- I included a public method to add values to the ArrayList that is used in the put method of the Hash class.

### Linked List

There are no modifications to the original Linked List class from the original Hash Table.<br>

### Hash

- The toString method prints out the key and ArrayList of all pair values by calling the getValueArray() method added to the Node class.

- The .put() method first checks if the key word passed as an argument is already in the table by using the hasKey() method. If the key is already there, the pair value is added to the value ArrayList using the addValueData method from the Node class. If the key is not already in the table, a new node is created which stores the key word, the pair value by initializing a new ArrayList and populating it with the pair value word, and the hash code.

- The get() method will only return the first pair value in the array list that is associated with the key word passed as an argument. I created another method called getAllValues which will return the entire ArrayList of all pair value words associated with the key word passed as an argument.

### Driver

The Driver parses the .txt file which contains the corpus lyrics.<br>
Specific punctuation is removed from the text and then each word is split into a single string.<br>
The words are then added to the Hash Table in a loop. Each word is added as a key<br>
and any word that follows is added to the ArrayList as a pair value<br>
<br>
The Driver also includes a function which generates a following word based on the word passed as an argument.<br>
This function first finds all pair values associated with the key word passed as an argument.<br>
It then choses a random number based on the size of the length of the pair value ArrayList<br>
This random number is used to choose a random pair value word to be used as the word to follow the key word.<br>
Finally the function returns the String that was chosen as the next word in the chain.<br>
<br>
The process for creating the Markov chain starts by selecting a random word from a random list in<br>
the Hash table array and storing it in a variable.<br>
That word is then passed as an argument into the generateWord function described above.<br>
That word is stored in a variable which is later switched to a new variable and passed back into the generateWord function in a for loop.<br>
The word is also added to a String which compiles all the generated words into the final result once the loop has concluded.<br>
<br>
The biggest issue I had was trying to incorporate line breaks in the final text to more accurately<br>
mimic the way the corpus lyrics are presented in the text.<br>
My first attempt involved adding a "\n" character as a pair value for the last word of each line.<br>
However, I began to get error messages when the newLine character would show up twice in a row<br>
as a generated word. This is because there were no instances of a line break being followed by a line break.<br>
This would result in trying to access value data from a Linked list that was null.<br>
I was able to solve this issue by changing my approach and focusing on the fact that each new line<br>
begins with a capital letter. So after a word was generated in the foor loop, I would check to<br>
see if it began with an Upper Case character. if it did, I would precede this word with a line break<br>
when it was added to the final lyric string.<br>
