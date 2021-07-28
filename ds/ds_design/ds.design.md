# Data Structures Design Challenge

Storing 3 pieces of data (first, last, number) makes most sense to be<br>
stored in a data structure which contains a node.<br>

When adding, you are creating a new node and inserting it into the data structure<br>

Binary tree

- add - needs to traverse through all levels of the tree - worst case O(n)
searching a binary tree would be pretty optimal - O(log n)

Linked list

quickest way to add would be similar to linked list - adding to the front - O(constant)
search linked list - O(n)

Could we create a binary tree where we can add to the root and reshuffle everything else
