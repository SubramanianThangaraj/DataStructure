import dataStructure.DoublyLinkedList;
import dataStructure.DynamicArray;
import dataStructure.Stack;

import java.util.Iterator;

public class TestDS
{

    public static void main(String[] args)
    {
        TestDS test = new TestDS();
        test.testDynamicArray();
        test.testDoublyLinkedList();
        test.testStack();
    }

    public void testDynamicArray()
    {
        DynamicArray da = new DynamicArray(5);
        da.add("START");
        da.add(0);
        da.add(1);
        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);
        da.add(6);
        System.out.println("Contents of the array "+da);
        System.out.println("Size : "+da.size());
        System.out.println("is Empty? " +da.isEmpty());
        System.out.println("Getting 3rd element from the array "+da.get(2));
        da.set(2, "changed");
        System.out.println("After Changing the data present in second index... "+da);
        System.out.println("Index of the data 3 is "+da.indexOf(3));
        System.out.println("Does the array coontains the value 5 ? "+da.contains(5));
        System.out.println("Removing particular data from the array using remove method. This method will remove the data and return the index of the data, INDEX: "+da.remove(4));
        System.out.println("Removing data at the index 1 , The data which is removed is "+da.removeAt(1));
        System.out.println("After removing "+da);

        System.out.println("Traversing the array using Iterator");
        Iterator iterator = da.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next()+", ");
        }
        System.out.println();

        System.out.println("Clearing the array... ");
        da.clear();
        System.out.println("After clearing, " +da);
    }
    public void testDoublyLinkedList()
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add("START");
        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);
        dll.add(6);
        System.out.println("Contents of the DoublyLinkedList "+dll);

        System.out.println("Size : "+dll.size());
        System.out.println("is Empty? " +dll.isEmpty());
        dll.addFirst("-1");
        System.out.println("After adding an element \"-1\" to the front of the LinkedList : "+dll);
        dll.addLast("LAST");
        System.out.println("After adding an element to the front of the LinkedList : "+dll);
        System.out.println("The first element in the list is : "+dll.peekFirst());
        System.out.println("The last element in the list is : "+dll.peekLast());
        System.out.println("Removing the first element of the Linked List : "+dll.removeFirst());
        System.out.println("After removing the First element of the LinkedList : "+dll);
        System.out.println("Removing the first element of the Linked List : "+dll.removeLast());
        System.out.println("After removing the Last element of the LinkedList : "+dll);
        System.out.println("Index of the data 3 is "+dll.indexOf(3));
        System.out.println("Does the array contains the value 5 ? "+dll.contains(5));
        System.out.println("Removing the element located at index 2(third element) in Linked list : "+dll.removeAt(2));
        System.out.println("Removing the element \"3\" from the Linked list : "+dll.remove(3));
        System.out.println("After removing "+dll);

        System.out.println("Traversing the array using Iterator");
        Iterator iterator = dll.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next()+", ");
        }
        System.out.println();

        System.out.println("Clearing the array... ");
        dll.clear();
        System.out.println("After clearing, " +dll);
    }


    public void testStack()
    {
        Stack stack = new Stack();
        stack.push("Start");
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push("END");

        System.out.println("Size of the Stack : "+stack.size());
        System.out.println("Is the Stack Empty? "+stack.isEmpty());
        System.out.println("Just peeking the last element in stack : "+stack.peek());
        System.out.println("After peeking : "+stack);
        System.out.println("Pop the last element in stack : "+stack.pop());
        System.out.println("After popping : "+stack);

        System.out.println("Iterating through Stack");
        Iterator iterator = stack.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + ", ");
        }

        System.out.println("Popping and iterating through stack... ");
        iterator = stack.iterator();
        while (iterator.hasNext())
        {
            System.out.print(stack.pop());
        }

        System.out.println("\n############################################");
        System.out.println("Size of the Stack : "+stack.size());
        System.out.println("Is the Stack Empty? "+stack.isEmpty());
        System.out.println(stack);
    }
}
