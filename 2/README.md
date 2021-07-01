# Programming in a High Level Language
# In Class assignment - 6/30/21
# Mancala
## by
## Liam Baum
## Victoria Berkowitz
## Brian Mueller

**GOAL:**

Collect as many stones as possible in your mancala.

**RULES:**

you can only move stones on your side
a move consists of collecting all stones in a pit and dropping them 1 by 1 into each consecutive pit in a counterclockwise direction
if last stone dropped is into your mancala, you go again
if last stone dropped is into an empty pit on your side, you capture the stones in the opposite pit (store in mancala)

Original planning notes:

// set up
// two arrays - player and opponent rows of pits  
// two variables - player and opponent mancala  
// user array on bottom / ai on top (visually)

//turn
// which index you will pick from
// how many stones in that index (pit)
// which direction will you traverse the array
// (user - up in index, ai down in index)
// add 1 to each following index  (use for loop)
// when you reach end or beginning of array, add one to mancala variables

//aiTurn
// choose random index btwn 0-5
// check that pit has stones in it (index != 0)


// moving stones method
// start on chosen index? is index > 0?
// checks whos turn?
   // If player move up, if ai move down
   // put stone in correct mancala


//checks

// did last stone go in mancala? repeat player turn
// are you in your own pits (array) &&  did last stone go in empty pit?
      // If opponents mirrored pit > 0?, move all stones from both indecies
// is either array empty? if so game over  
