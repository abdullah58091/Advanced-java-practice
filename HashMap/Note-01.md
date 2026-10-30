### PHASE 1 — Collections Framework
Topic 4: HashMap ⭐⭐⭐

HashMap is one of the most important topics for Java interviews and backend development.

HashMap is used extensively in Java applications, especially when working with databases, APIs, caching, and data processing.

Aaj hum ise basic se advanced level tak samjhenge.

Today's Learning Roadmap
No.	Topic	Importance
1	HashMap Fundamentals	⭐⭐⭐
2	Internal Working	⭐⭐⭐
3	Hashing	⭐⭐⭐
4	Hash Function	⭐⭐⭐
5	Bucket	⭐⭐⭐
6	Collision	⭐⭐⭐
7	Load Factor	⭐⭐⭐
8	Rehashing / Resizing	⭐⭐⭐
9	put() and get()	⭐⭐⭐
10	Why HashMap is Fast	⭐⭐⭐
11	HashMap with Custom Objects	⭐⭐⭐


###  1. What is HashMap in Java?
Definition

A HashMap is a class in the Java Collections Framework that stores data in the form of key-value pairs.

Each key is unique, but multiple keys can have the same value.

HashMap belongs to the java.util package and implements the Map interface.

Example

Imagine you are developing a student management system.

You want to store student IDs with their names.

Student ID (Key)	Student Name (Value)
101	Abdullah
102	Ali
103	Sara
104	David

Instead of searching through a list, you can retrieve a student's name using their ID.

For example:

students.get(101);

Output:

Abdullah

This is one of the main purposes of HashMap.

Syntax
HashMap<KeyType, ValueType> map = new HashMap<>();

Example:

HashMap<Integer, String> students = new HashMap<>();

Here:

Integer represents the key type.
String represents the value type.
Important Features of HashMap
Stores data in key-value pairs.
Keys must be unique.
Values can be duplicated.
Allows one null key.
Allows multiple null values.
Does not guarantee insertion order.
Provides average O(1) time complexity for put() and get() under normal conditions.
It is not synchronized by default.
2. Basic HashMap Example

Let's understand HashMap through Java code.

import java.util.HashMap;

public class HashMapPractice {

    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();

        students.put(101, "Abdullah");
        students.put(102, "Ali");
        students.put(103, "Sara");
        students.put(104, "David");

        System.out.println(students);

        System.out.println("Student with ID 101: "
                + students.get(101));
    }
}
Output
{101=Abdullah, 102=Ali, 103=Sara, 104=David}

Student with ID 101: Abdullah

Note: The order of entries displayed by HashMap is not guaranteed.

Understanding the Methods
Method	Purpose
put(key, value)	Inserts or updates a key-value pair
get(key)	Retrieves the value associated with a key
remove(key)	Removes an entry
containsKey(key)	Checks whether a key exists
containsValue(value)	Checks whether a value exists
size()	Returns the number of entries
isEmpty()	Checks whether the map is empty
clear()	Removes all entries
###  3. What is Hashing?

This is where the actual internal working of HashMap begins.

Definition

Hashing is a technique used to convert a key into an integer hash value, which helps determine where the key-value pair should be stored.

In simple terms:

Hashing helps HashMap decide where to store data and where to find it later.

Example

Suppose we insert:

students.put(101, "Abdullah");

Conceptually, the process looks like this:

       Key
        |
        v
       101
        |
        v
   Hash Function
        |
        v
    Hash Value
        |
        v
   Bucket Index
        |
        v
  Store Key-Value Pair

HashMap uses the key to calculate a hash and determine the appropriate bucket.

Important: Hashing is not encryption. It is a technique for efficiently storing and retrieving data.

####  4. What is a Hash Function?
Definition

A hash function is a function that takes a key as input and produces an integer hash value.

HashMap uses this hash value to determine the bucket in which an entry should be stored.

Example

Imagine we have a simplified hash function:

hash(key) = key % 10

Suppose our keys are:

101
102
103
104

Calculations:

101 % 10 = 1
102 % 10 = 2
103 % 10 = 3
104 % 10 = 4

So:

Key	Hash Value (simplified)	Bucket Index
101	101	1
102	102	2
103	103	3
104	104	4

This is only a simplified illustration, not the actual Java HashMap hash calculation.

Actual Java HashMap Hashing

In modern Java implementations, HashMap uses the key's hashCode() method and applies a hash-spreading operation.

Conceptually:

int hash = key.hashCode() ^ (key.hashCode() >>> 16);

Then it calculates the bucket index using:

int index = (capacity - 1) & hash;

This works because HashMap uses a power-of-two table capacity.

We will explore this implementation in more detail when studying internal working.

###  5. What is a Bucket?
Definition

A bucket is a position in the internal array of HashMap where entries are stored.

HashMap internally uses an array of buckets.

Each bucket can hold:

No entry.
One entry.
Multiple entries if collisions occur.
Diagram

Imagine a simplified HashMap with 8 buckets.

        HashMap Internal Array

Index       Bucket
  0       [Empty]
  1       [101, Abdullah]
  2       [102, Ali]
  3       [103, Sara]
  4       [104, David]
  5       [Empty]
  6       [Empty]
  7       [Empty]

Here:

Bucket 1 stores key 101.
Bucket 2 stores key 102.
Bucket 3 stores key 103.
Bucket 4 stores key 104.

Remember: Bucket is a logical position in the internal array, not a separate Java collection.

####  6. What is Collision?
Definition

A collision occurs when two or more different keys are assigned to the same bucket index.

This can happen because different keys can produce the same bucket index.

Example

Consider this simplified hash function:

hash(key) = key % 10

Now:

101 % 10 = 1
111 % 10 = 1
121 % 10 = 1

All three keys are assigned to bucket 1.

This is called a collision.

Collision Diagram
                Bucket 1
                    |
                    v
             +-------------+
             | 101 = Ali   |
             +-------------+
                    |
                    v
             +-------------+
             | 111 = Sara  |
             +-------------+
                    |
                    v
             +-------------+
             | 121 = David |
             +-------------+
How does Java Handle Collision?

Java HashMap handles collisions using:

Linked List: Multiple entries can be stored in the same bucket using linked nodes.
Red-Black Tree: Under certain conditions, a heavily populated bucket can be converted into a balanced tree.

In modern Java implementations, treeification generally requires:

Bucket size reaching the treeification threshold of 8.
Table capacity being at least 64.

If the table is smaller, HashMap generally resizes instead.

Important interview question: What happens when two keys have the same hash code?

Answer: They may be placed in the same bucket. HashMap uses equals() to distinguish between keys and handles the collision using its bucket structure.

###  7. What is Load Factor?
Definition

The load factor is a measure of how full the HashMap's internal bucket array can become before resizing is triggered.

The default load factor in Java HashMap is:

0.75
Example

Suppose:

Initial Capacity = 16
Load Factor = 0.75

The resize threshold is:

16 × 0.75 = 12

This means the threshold is 12 entries.

When the number of entries exceeds this threshold, HashMap resizes its internal table.

Java Example
HashMap<Integer, String> students =
        new HashMap<>(16, 0.75f);

Here:

16 = initial capacity requested.
0.75f = load factor.
Why is Load Factor Important?

A lower load factor:

Can reduce collisions.
Uses more memory because resizing happens earlier.

A higher load factor:

Can save memory.
May increase collisions and reduce performance.
###  8. What is Resizing and Rehashing?
Resizing Definition

Resizing means increasing the capacity of HashMap's internal bucket array when its threshold is exceeded.

In modern Java HashMap, capacity generally doubles when resizing occurs.

Example

Initially:

Capacity = 16
Load Factor = 0.75
Threshold = 12

After the threshold is exceeded, the capacity generally becomes:

Old Capacity = 16
New Capacity = 32
New Threshold = 24
Diagram
Before Resizing:

Capacity = 16

[0] [1] [2] [3] [4] ... [15]


          Resize


After Resizing:

Capacity = 32

[0] [1] [2] [3] [4] ... [31]
What is Rehashing?

During resizing, HashMap redistributes existing entries into the new table based on the new capacity.

In Java 8 and later, the implementation optimizes this process rather than blindly recalculating every hash from scratch.

Remember the difference:

Resizing = Increasing the internal array capacity.
Rehashing = Redistributing entries into the new table.
###  9. How do put() and get() Work Internally?

These are two of the most important HashMap methods.

A. put()
Definition

The put() method inserts a key-value pair into a HashMap.

Example:

students.put(101, "Abdullah");
Internal Working
          put(101, "Abdullah")
                    |
                    v
              Calculate Hash
                    |
                    v
             Find Bucket Index
                    |
                    v
             Check Bucket
                    |
             +------+------+
             |             |
          Empty         Occupied
             |             |
             v             v
        Insert Entry   Check Existing Key
                           |
                    +------+------+
                    |             |
                  Same Key     Different Key
                    |             |
                    v             v
                Update Value   Handle Collision

Important: If the key already exists according to equals(), its value is replaced.

Example:

students.put(101, "Abdullah");
students.put(101, "Mohammad");

System.out.println(students.get(101));

Output:

Mohammad

There is still only one entry for key 101.

B. get()
Definition

The get() method retrieves the value associated with a given key.

Example:

students.get(101);
Internal Working
              get(101)
                 |
                 v
           Calculate Hash
                 |
                 v
          Find Bucket Index
                 |
                 v
          Search Bucket Entry
                 |
           +-----+-----+
           |           |
        Key Found   Key Not Found
           |           |
           v           v
       Return Value   Return null

If the key does not exist, get() returns null.

###  10. Why is HashMap Fast?

HashMap is fast because it uses hashing to directly identify the bucket where a key-value pair should be stored or searched for.

Without HashMap, searching for an element in a list may require checking many elements one by one.

With HashMap, Java calculates a hash and finds the relevant bucket.

Time Complexity
Operation	Average Case	Worst Case
put()	O(1)	O(n)
get()	O(1)	O(n)
remove()	O(1)	O(n)
containsKey()	O(1)	O(n)
containsValue()	O(n)	O(n)

Interview note: In modern Java, treeified buckets can provide O(log n) lookup and insertion within those buckets under suitable conditions. The commonly quoted average O(1) assumes a reasonably distributed hash function.

###  11. HashMap with Custom Objects

This is an advanced and very important Java interview concept.

So far, we have used built-in types such as:

HashMap<Integer, String> students = new HashMap<>();

But what happens when we want to use our own class as a key?

For example, suppose we create a Student class.

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

We want to use Student objects as HashMap keys.

HashMap<Student, String> students = new HashMap<>();
Why are hashCode() and equals() Important?

HashMap uses:

hashCode() to determine the hash and locate a bucket.
equals() to check whether two keys are logically equal.

When using custom objects as keys, you should generally override both methods consistently.

Example
import java.util.HashMap;
import java.util.Objects;

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return this.id == other.id;
    }
}

public class HashMapCustomObject {

    public static void main(String[] args) {

        HashMap<Student, String> students = new HashMap<>();

        Student s1 = new Student(101, "Abdullah");
        Student s2 = new Student(102, "Ali");

        students.put(s1, "Computer Science");
        students.put(s2, "Information Technology");

        System.out.println(students.get(s1));
    }
}

Output:

Computer Science
Important Rule

If two objects are equal according to equals(), they must return the same hash code.

However, two objects having the same hash code do not necessarily have to be equal.

This is known as the equals-hashCode contract.

12. Quick Revision
Concept	Meaning
HashMap	Stores key-value pairs
Hashing	Converts a key into a hash value
Hash Function	Calculates the hash value
Bucket	Position in the internal array
Collision	Different keys assigned to the same bucket
Load Factor	Determines when resizing is triggered
Resizing	Increases internal array capacity
Rehashing	Redistributes entries into the new table
put()	Inserts or updates an entry
get()	Retrieves a value using its key
hashCode()	Provides an object's hash code
equals()	Checks logical equality
13. Practical Exercise — Your Turn

Bhai, ab theory ke baad practical implementation karte hain.

Create a file:

HashMapPractice.java

Task 1: Create a HashMap

Create:

HashMap<Integer, String> students = new HashMap<>();
Task 2: Insert Elements

Insert these records:

ID	Name
101	Abdullah
102	Ali
103	Sara
104	David

Use put().

Task 3: Retrieve Data

Print the name of student ID 103 using get().

Task 4: Update Data

Change student ID 102 from Ali to Mohammad.

Task 5: Check Key

Check whether student ID 105 exists using containsKey().

Task 6: Remove Element

Remove student ID 104.

Task 7: Print Final Data

Print:

Complete HashMap.
Total number of students using size().
Student ID 101 using get().
Expected Output
Student with ID 103: Sara

After Updating: {101=Abdullah, 102=Mohammad, 103=Sara, 104=David}

Does ID 105 exist? false

After Removing ID 104: {101=Abdullah, 102=Mohammad, 103=Sara}

Total Students: 3

Student with ID 101: Abdullah

Note: HashMap does not guarantee display order, so your output may appear in a different order.