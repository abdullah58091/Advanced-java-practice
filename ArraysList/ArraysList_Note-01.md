### PHASE 1 — Collections Framework
## Topic 2: ArrayList ⭐⭐⭐
Today's Learning Roadmap

We will cover these six topics:

No.	Topic	Importance
1	Introduction to ArrayList	Fundamentals
2	Internal Working of ArrayList	Important for interviews
3	Size vs Capacity	Frequently asked
4	Dynamic Resizing	Important for understanding performance
5	add(), get(), remove()	Practical coding
6	ArrayList vs Array	Exams and interviews

Let's start from the fundamentals.

1. What Is an ArrayList?
1.1 Definition

An ArrayList is a resizable-array implementation of the List interface in Java. It stores elements in an ordered sequence, allows duplicate elements, and supports index-based access.

It belongs to the java.util package.

import java.util.ArrayList;
Why do we need ArrayList?

Suppose you want to store five student marks.

Using a traditional array:

int[] marks = new int[5];

marks[0] = 85;
marks[1] = 90;
marks[2] = 78;
marks[3] = 88;
marks[4] = 95;

This works, but the array has a fixed length of five.

What happens if you later need to store six marks?

You cannot increase the length of the existing array. You must create a new array and copy the existing elements if you want a larger array.

An ArrayList handles this resizing process automatically when necessary.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(85);
        marks.add(90);
        marks.add(78);
        marks.add(88);
        marks.add(95);

        // Add another mark
        marks.add(92);

        System.out.println(marks);
    }
}

Output:

[85, 90, 78, 88, 95, 92]

Notice that we added a sixth element without manually creating a larger array.

Important: ArrayList can grow and shrink logically as elements are added and removed. Its internal storage capacity may be larger than the number of elements it currently contains.

2. Internal Working of ArrayList

This is one of the most important concepts in today's lesson.

To understand ArrayList, you need to understand what happens behind the scenes.

2.1 How does ArrayList store elements?

An ArrayList uses an array internally to store its elements.

For example:

ArrayList<String> names = new ArrayList<>();

names.add("Ali");
names.add("Sara");
names.add("Abdullah");

Conceptually, its internal storage might look like this:

ArrayList
    |
    v
Internal Array
+---------+---------+------------+
|  "Ali"  | "Sara"  | "Abdullah" |
+---------+---------+------------+
     0         1          2

Size = 3

The indexes start at zero, just like ordinary Java arrays.

However, the internal array may contain additional unused positions.

For example:

Internal Array
+-------+-------+------------+--------+--------+
| "Ali" | "Sara"| "Abdullah" |  null  |  null  |
+-------+-------+------------+--------+--------+
    0       1         2           3        4

Size = 3
Capacity = 5

This is an illustrative example of an internal array with capacity five. It does not mean every new ArrayList starts with five slots.

Two important properties

Size: The number of elements currently stored in the list.

Capacity: The number of elements the internal array can hold before it needs to grow.

In the example:

Size = 3
Capacity = 5

There are three actual elements, but the internal array has room for five references.

Let's understand why this distinction matters.

2.2 What happens when we call add()?

Consider:

ArrayList<String> names = new ArrayList<>();

names.add("Ali");
names.add("Sara");
names.add("Abdullah");

When you call:

names.add("Ali");

Java ensures that the internal array has enough room for the new element, then stores the reference at the appropriate index.

Conceptually:

Before add():

Size = 0

Internal array:
[ empty storage ]

After add("Ali"):

Size = 1

Internal array:
["Ali", unused, unused, ...]

The actual initial storage behavior depends on how the ArrayList is constructed and on the Java implementation.

For an ordinarily constructed empty ArrayList, Java can defer allocating the backing array until an element is first added.

When you subsequently add more elements, the list uses available capacity whenever possible.

If the internal array has insufficient capacity, it must grow.

We will examine that process in Topic 4.

2.3 Why is ArrayList called a dynamic array?

A normal Java array has a fixed length.

int[] numbers = new int[3];

Its length remains three.

You cannot change it to four using an operation such as:

numbers.length = 4; // Compilation error

An ArrayList, however, can increase its internal storage automatically.

ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);

The list manages its internal storage when necessary.

Therefore:

ArrayList is called a dynamic array because it can automatically grow its backing array when more storage is needed.

Strictly speaking, the internal array itself does not change length. Java allocates a larger array and transfers the existing element references when resizing is required.

That distinction is important for interviews.

3. Size vs Capacity

This is a frequently asked Java interview question.

3.1 What is Size?

Size is the current number of elements stored in an ArrayList.

We obtain it using:

list.size();

Example:

ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers.size());

Output:

3

There are three elements, so the size is three.

3.2 What is Capacity?

Capacity is the amount of element-reference storage currently available in the backing array.

For example, if the backing array can store ten references and the list contains four elements:

Capacity = 10
Size = 4

+----+----+----+----+------+------+------+-----+-----+-----+
| 10 | 20 | 30 | 40 | free | free | free | free| free| free|
+----+----+----+----+------+------+------+-----+-----+-----+

The list has six unused positions in this illustrative example.

Important: The standard ArrayList API exposes size(), but it does not provide a public capacity() method. You should not rely on internal implementation details to inspect its capacity.

3.3 Size vs Capacity: Comparison
Feature	Size	Capacity
Meaning	Number of elements in the list	Available storage in the backing array
Public method	size()	No public capacity() method
Changes when adding an element	Increases by one	May stay the same or increase
Changes when removing an element	Decreases by one	Usually stays the same
Can capacity exceed size?	Not applicable	Yes
Example	Four elements	Space for ten references
Interview question

Q: Can the capacity of an ArrayList be greater than its size?

Answer: Yes. An ArrayList may have unused positions in its internal array to accommodate future insertions without immediately allocating a larger array. Therefore, its capacity can exceed its current size.

Another important question

Q: Does removing an element automatically reduce the capacity of an ArrayList?

Answer: Generally, no. Removing an element reduces the list's size, but its backing array usually retains its existing capacity. The trimToSize() method can be used to request that the capacity be reduced to the current size.

Example:

ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.remove(Integer.valueOf(20));

System.out.println(numbers);
System.out.println(numbers.size());

Output:

[10, 30]
2

The size is now two. The capacity does not necessarily shrink.

4. Dynamic Resizing in ArrayList

Now we come to a particularly important topic.

4.1 What is Dynamic Resizing?

Dynamic resizing is the process of allocating a larger backing array when the existing array does not have enough capacity for additional elements.

Let's imagine an internal array that currently has capacity four.

Capacity = 4
Size = 4

+----+----+----+----+
| 10 | 20 | 30 | 40 |
+----+----+----+----+

Now you execute:

numbers.add(50);

The current array cannot accommodate the fifth element.

The list must grow its backing array.

Conceptually:

STEP 1: Existing array

+----+----+----+----+
| 10 | 20 | 30 | 40 |
+----+----+----+----+

STEP 2: Allocate a larger array

+----+----+----+----+----+----+
|    |    |    |    |    |    |
+----+----+----+----+----+----+

STEP 3: Copy existing references and add the new element

+----+----+----+----+----+----+
| 10 | 20 | 30 | 40 | 50 |    |
+----+----+----+----+----+----+

Size = 5
Capacity = 6 (illustrative only)

The capacity of six in this diagram is only an illustration. It is not the growth rule used by current standard OpenJDK ArrayList implementations.

4.2 What is the actual resizing strategy?

In commonly used OpenJDK implementations, ArrayList typically grows its backing array by approximately 50% when additional capacity is required.

For example, a backing array with capacity ten might grow to capacity fifteen.

Conceptually:

Old capacity = 10

New capacity ≈ 10 + (10 / 2)

New capacity ≈ 15

The implementation also handles special cases, such as a very small or empty backing array, and sufficiently large requested capacities.

Interview note: The Java API does not promise a specific growth factor. The approximately 1.5× growth strategy describes common OpenJDK implementations, not a permanent guarantee of the ArrayList specification.

4.3 Why does resizing take O(n) time?

Suppose an array contains 1,000 element references.

When resizing occurs, Java may need to allocate a larger array and copy the existing references.

The amount of copying is proportional to the current number of elements.

Therefore:

A single resizing operation can take O(n) time.

Here, n represents the number of elements already stored in the list.

However, not every insertion triggers resizing.

When there is sufficient capacity, adding an element to the end is generally O(1).

Across a long sequence of insertions, the average cost per end insertion is amortized O(1).

We will revisit this distinction when we study time complexity.

5. ArrayList Operations: add(), get(), and remove()

Now let's move from theory to practical Java.

5.1 The add() Method

The add() method inserts an element into the list.

Example 1: Adding elements
import java.util.ArrayList;

public class ArrayListAddPractice {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");

        System.out.println(names);
    }
}

Output:

[Abdullah, Ali, Sara]
Example 2: Adding an element at a specific index
ArrayList<String> names = new ArrayList<>();

names.add("Ali");
names.add("Sara");

names.add(1, "Abdullah");

System.out.println(names);

Output:

[Ali, Abdullah, Sara]

Here:

names.add(1, "Abdullah");

inserts "Abdullah" at index one.

The existing element at index one and the following elements shift one position to the right.

This operation is different from replacing an existing element.

Important: Adding at the end is generally O(1) amortized. Adding at an arbitrary index can take O(n) because elements may need to shift.

5.2 The get() Method

The get() method retrieves an element by its index.

Example:

import java.util.ArrayList;

public class ArrayListGetPractice {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Abdullah");
        names.add("Ali");
        names.add("Sara");

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names.get(2));
    }
}

Output:

Abdullah
Ali
Sara

Remember:

Index:    0       1      2
       +---------+------+------+
Value: | Abdullah| Ali  | Sara |
       +---------+------+------+

The first element has index zero.

Time complexity of get()

For an ArrayList, retrieving an element by index takes O(1) time.

Why?

Because Java can access the corresponding position in the backing array directly, without searching through all preceding elements.

What happens if the index is invalid?

Consider:

System.out.println(names.get(5));

If the list contains only three elements, this throws an IndexOutOfBoundsException.

Valid indexes range from:

0 to size - 1

For a list of size three, the valid indexes are zero, one, and two.

5.3 The remove() Method

This is particularly important because ArrayList provides two commonly used forms of remove().

Form 1: Remove by index
numbers.remove(1);

This removes the element at index one.

Form 2: Remove by object
numbers.remove(Integer.valueOf(20));

This removes the first matching occurrence of the specified object.

Let's understand the difference carefully.

Example
import java.util.ArrayList;

public class ArrayListRemovePractice {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("Original: " + numbers);

        numbers.remove(1);

        System.out.println("After removing index 1: " + numbers);

        numbers.remove(Integer.valueOf(40));

        System.out.println("After removing value 40: " + numbers);
    }
}

Output:

Original: [10, 20, 30, 40]
After removing index 1: [10, 30, 40]
After removing value 40: [10, 30]

Let's examine this line:

numbers.remove(1);

Because 1 is an int, Java selects the overload that removes an element by index.

It removes 20, not the number one by value.

Now examine:

numbers.remove(Integer.valueOf(40));

This selects the overload that removes an object equal to 40.

Common interview question

Q: What is the difference between remove(1) and remove(Integer.valueOf(1)) in an ArrayList<Integer>?

Answer:

remove(1) removes the element at index one.
remove(Integer.valueOf(1)) removes the first element whose value equals one.

This distinction is important when working with ArrayList<Integer>.

Time complexity of remove()
Operation	Typical time complexity
Remove the last element by index	O(1)
Remove an element from the beginning	O(n)
Remove an element from the middle	O(n)
Remove an object by value	O(n)

Removing an element from the beginning or middle usually requires shifting subsequent elements to fill the gap.

6. ArrayList vs Array

This is another important exam and interview topic.

6.1 What is an Array?

An array is a Java object that stores a fixed number of elements of a specified component type.

Example:

int[] numbers = new int[5];

numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;

The array's length remains five after creation.

You can update existing positions, but you cannot change the length of that array.

6.2 What is an ArrayList?

An ArrayList is a resizable-array implementation of the List interface.

Example:

ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.add(40);
numbers.add(50);
numbers.add(60);

It automatically manages additional storage when required.

6.3 Comparison Table
Feature	Array	ArrayList
Size	Fixed after creation	Can grow or shrink logically
Storage	Stores primitive values or object references	Stores object references
Primitive values	Supported directly	Use wrapper classes such as Integer
Index-based access	Yes	Yes
Access by index	O(1)	O(1)
Adding elements	Must manage available space yourself	Provides add()
Removing elements	Must manage shifting or copying yourself	Provides remove()
Built-in size information	length field	size() method
Utility methods	Limited built-in collection operations	Many List and Collections operations
Performance overhead	Usually lower	Additional object and resizing-management overhead
Best suited for	Fixed-size data and primitive arrays	Dynamically sized collections of objects
Important distinction: length vs size()

For arrays:

int[] numbers = new int[5];

System.out.println(numbers.length);

Output:

5

For an ArrayList:

ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);

System.out.println(numbers.size());

Output:

2

Remember:

Array → length
ArrayList → size()

Also, an array of five integers has five initialized integer positions, even if you have not assigned values to them yourself. An empty ArrayList, by contrast, has size zero.

6.4 When should you use an Array?

Choose an array when:

You know the required length in advance.
You need to store primitive values directly.
You want a simple fixed-size data structure.
You are implementing a data structure that benefits from direct array management.

Example:

int[] dailyTemperatures = new int[7];
6.5 When should you use an ArrayList?

Choose an ArrayList when:

The number of elements may change.
You frequently retrieve elements by index.
You need convenient methods for adding and removing elements.
You want to use the Java Collections Framework.

Example:

ArrayList<String> incidentMessages = new ArrayList<>();

incidentMessages.add("Database connection failed");
incidentMessages.add("High memory usage detected");
incidentMessages.add("Authentication failed");

For your Log Sentinel project, an ArrayList could be useful when you need an ordered, resizable in-memory list of log messages or incident records.

For large-scale log ingestion, however, you would normally also consider streaming, queues, batching, and persistent storage rather than keeping every log in one in-memory list.

7. Advantages and Disadvantages of ArrayList
Advantages
Dynamic sizing: It grows automatically when additional capacity is required.
Fast indexed access: get(index) takes O(1) time.
Duplicates allowed: The same value can appear multiple times.
Maintains sequence order: Elements appear in list order during iteration.
Convenient methods: It provides methods such as add(), get(), set(), remove(), and contains().
Works with generics: You can specify the element type, such as ArrayList<String>.
Disadvantages
Insertion in the middle can be expensive: Subsequent elements may need to shift.
Removal can be expensive: Removing from the beginning or middle generally requires shifting elements.
Resizing has a cost: Growing the backing array can require allocating a new array and copying references.
Additional memory overhead: It stores references in an internal array and may have unused capacity.
Not synchronized by default: Concurrent modifications from multiple threads require appropriate coordination.
8. Time Complexity of Major ArrayList Operations

This table is important for both DSA and Java interviews.

Operation	Time Complexity	Reason
get(index)	O(1)	Direct indexed access
set(index, value)	O(1)	Replace an existing element
add(value) at the end	O(1) amortized	Most insertions use available capacity
add(index, value)	O(n)	Elements may need to shift
remove(index)	O(n) in general	Subsequent elements may need to shift
remove(object)	O(n)	May need to search for the object
contains(value)	O(n)	May need to examine each element
indexOf(value)	O(n)	Linear search
size()	O(1)	Current size is maintained
clear()	O(n)	Existing element references are cleared

Interview note: These are standard expected complexities for typical operations. Exact implementation details and special cases can affect individual operations, but this table is appropriate for learning the general behavior of ArrayList.