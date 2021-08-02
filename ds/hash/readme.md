# Hash Table Implementation

This hash table was implemented using the **Node** and **Linked List** classes<br>
which we made in class and a **Hash** class which I implemented myself.<br>
<br>
I include the following additions/changes/deletions to each class: <br>

### Node
- Each node includes the following data:
    - Key (String)
    - Value (String)
    - Hash code (int) - This was only necessary for testing purposes
    - Pointer to next node

- I made several different constructors but only really used the one which parameterized key, value and hash which was stored in each node when a new node was made using the addFront method in the linked list.
- I overloaded the get functions which was also useful for testing
- I removed the set functions after a discussion with DW since all pieces of data are linked<br>
and changing the value of one would cause problems trying to access the other pieces of data.

### Linked list
- I changed the addFront method to include the parameterized constructor which included key, value and hash code.
- I included a listLength counter variable which I intended on using to keep track of the length of each list. However, since each list in the array is meant to only have a couple of nodes, I opted not to use it.
- I modified the get method since there are multiple pieces of data in the node. This node was renamed getKeyValue and returns the key value stored in the node at the specified index.
- I added another get method called getNode which returns the entire node found at the specified index.
- I deleted the set and insert method since I only intended to add nodes to the front of the list.
- The search method searches by key value which then uses the getKeyValue method.

### Hash
- The Hash class includes the following methods:
  - Parameterized Constructor
  - Initialized Constructor
  - getList() - retreives lsit at specific index
  - isEmpty() - checks if table is is empty
  - hashFunc() - creates Hash code for key that is stored in node. I realize I could have also made the hash index in this same function. However, I opted to make a second function for making the actual index so I could store the hash code in the node.
  - hashIndex() - creates index from hash code to put node at specific index.
  - toString() - prints all key value pairs in table. Ignores any index with a list that has a length of zero.
  - put() - Takes key and value as parameters but invokes hashFunc and hashIndex within the method. Method then invokes addFront method from linked list class to add key, value and hashCode to a new node.
  - hasKey() - checks if key exists within table.
  - get() - takes key as argument and returns value that is paired with key. Returns null if table does not contain key.
  - remove() - removes node containing specified key from list. Prints message if key is not in table.


### Driver
The Driver tests the Hash table by making a short string of words.<br>
It then uses the split function to make each word a seperate string and stores all the strings in an array.<br>
I tested the .put() function by making the key a word and the value pair, the word which follows that word. This was done in anticipation of later using this Hash class to implement a markov chain text generator.<br>
From there, I ran a series of tests of each method using various keys as arguments<br>
I used a for loop to print out each index and the nodes found at each index.<br>
This was also done for testing purposes. I made sure that at least one index contained more than one node to test traversing a list with multiple nodes.<br>
Since I was able to access each key hash code, I was able to come up with a string which would produce the same hash code as a key that was in the table in order to test each method with a string argument that would have a hash code found in the table but did not have correct key value associated with that hash code.<br>

As the second part of my final project, I will use these Classes as a foundation to build a Markov Chain Lyric Generator. Information and code for that project can be found [here](https://github.com/hunter-teacher-cert/work_csci70900-mrbombmusic/tree/master/ds/markov).
