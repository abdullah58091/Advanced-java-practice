###  PHASE 1 — Collections Framework
###  Topic 3: LinkedList
Today's Learning Roadmap
No.	Topic	Status
1	LinkedList Fundamentals	Starting
2	Internal Working	Pending
3	Doubly Linked List	Pending
4	addFirst() and addLast()	Pending
5	ArrayList vs LinkedList	Pending
6	Practical Coding	Pending
1. What is LinkedList in Java?
Definition

A LinkedList is a class in the Java Collections Framework that implements the List and Deque interfaces.

It stores elements as individual nodes, where each node contains:

Data (the actual value).
A reference to the previous node.
A reference to the next node.

Unlike ArrayList, LinkedList does not store elements in a continuous array.

Package

LinkedList belongs to the java.util package.

import java.util.LinkedList;
Example
import java.util.LinkedList;

public class LinkedListPractice {

    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");
        names.add("David");

        System.out.println(names);
    }
}

Output:

[Abdullah, Ali, Sara, David]
Important Features of LinkedList
It maintains insertion order.
It allows duplicate elements.
It allows null elements.
It is dynamically sized.
It supports insertion and deletion at both ends.
It implements both List and Deque.
It is not synchronized by default.
2. Internal Working of LinkedList

This is one of the most important concepts for interviews.

First, understand what a Node is.

What is a Node?

A Node is an individual object that stores data and references to other nodes.

For example, suppose we create this LinkedList:

LinkedList<Integer> numbers = new LinkedList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

Internally, it looks conceptually like this:

HEAD                                  TAIL
  |                                     |
  v                                     v

null <- [10] <-> [20] <-> [30] -> null

Each node contains:

+----------+--------+----------+
| Previous |  Data  |  Next    |
+----------+--------+----------+

For example, the node containing 20 stores:

Previous = Address of node containing 10
Data     = 20
Next     = Address of node containing 30
How does LinkedList work?

Suppose you execute:

numbers.add(40);

Java creates a new node containing 40 and connects it to the previous last node.

Before:

10 <-> 20 <-> 30

After:

10 <-> 20 <-> 30 <-> 40

The last node becomes the new tail.

Important Internal Concept

Java's LinkedList uses a Doubly Linked List internally.

It maintains:

first: Reference to the first node.
last: Reference to the last node.
size: Number of elements.

Remember: LinkedList does not use an array internally like ArrayList.

3. Doubly Linked List
Definition

A Doubly Linked List is a data structure in which every node contains three components:

Previous reference.
Data.
Next reference.

It allows traversal in both directions.

Diagram
             Doubly Linked List

HEAD                                      TAIL
  |                                         |
  v                                         v

null <- [10] <-> [20] <-> [30] <-> [40] -> null

         Forward Direction  -------->

         <--------  Backward Direction
How does it work?

Forward Traversal:

10 → 20 → 30 → 40

Backward Traversal:

40 → 30 → 20 → 10
Advantages
Supports traversal in both directions.
Efficient insertion and deletion when the node position is already known.
Efficient insertion and deletion at the beginning and end.
Disadvantages
Requires extra memory for previous and next references.
Accessing an element by index is slower than ArrayList.
More pointer/reference management is required.
4. Important LinkedList Methods

Today, we will focus on these two methods.

A. addFirst()

Definition: Adds an element at the beginning of the LinkedList.

Example:

LinkedList<Integer> numbers = new LinkedList<>();

numbers.add(20);
numbers.add(30);

numbers.addFirst(10);

System.out.println(numbers);

Output:

[10, 20, 30]

Internal representation:

Before:

HEAD
 |
 v
[20] <-> [30]


After addFirst(10):

HEAD
 |
 v
[10] <-> [20] <-> [30]
B. addLast()

Definition: Adds an element at the end of the LinkedList.

Example:

LinkedList<Integer> numbers = new LinkedList<>();

numbers.add(10);
numbers.add(20);

numbers.addLast(30);

System.out.println(numbers);

Output:

[10, 20, 30]

Internal representation:

Before:

[10] <-> [20]


After addLast(30):

[10] <-> [20] <-> [30]
                         ^
                        TAIL
Time Complexity
Operation	Time Complexity
addFirst()	O(1)
addLast()	O(1)
get(index)	O(n)
removeFirst()	O(1)
removeLast()	O(1)
contains()	O(n)
5. ArrayList vs LinkedList

This is an important exam and interview question.

Feature	ArrayList	LinkedList
Internal structure	Dynamic array	Doubly linked list
Memory	Stores element references in an array	Each node stores data and two references
Random access	Fast — O(1)	Slow — O(n)
Add at beginning	O(n)	O(1)
Add at end	O(1) amortized	O(1)
Remove from beginning	O(n)	O(1)
Remove from end	O(1)	O(1)
Memory overhead	Lower	Higher
Implements	List	List and Deque
When should you use ArrayList?

Use ArrayList when:

You frequently access elements using indexes.
You mostly read or iterate over elements.
You rarely insert or remove elements at the beginning or middle.
When should you use LinkedList?

Use LinkedList when:

You need frequent insertion or deletion at the beginning or end.
You need queue or deque operations.
You need to add and remove elements from both ends.

Important interview point: LinkedList insertion and deletion are O(1) when you already have the node or position. Finding an arbitrary position still takes O(n).

6. Practical Exercise — Your Turn

Now it's your turn to write code. Don't copy the complete solution; try implementing it yourself.

Create a Java file:

LinkedListPractice.java

Tasks
Import the LinkedList class.
Create a LinkedList<Integer>.
Add 20, 30, and 40 using add().
Add 10 at the beginning using addFirst().
Add 50 at the end using addLast().
Print the complete LinkedList.
Print the first element.
Print the last element.
Print the size of the LinkedList.
Expected Output
LinkedList: [10, 20, 30, 40, 50]
First Element: 10
Last Element: 50
Size: 5