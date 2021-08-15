package dataStructure;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T>
{
    LinkedList<T> internalList = new LinkedList<T>();
    public Stack()
    { }
    public Stack(T firstData)
    {
        push(firstData);
    }

    public int size()
    {
        return internalList.size();
    }
    public boolean isEmpty()
    {
        return size()==0;
    }
    public void push(T data)
    {
        internalList.push(data);
    }
    public T pop()
    {
        if(isEmpty()) throw new EmptyStackException();
        return internalList.pop();
    }
    public T peek()
    {
        if(isEmpty()) throw new EmptyStackException();
        return internalList.peekLast();
    }
    public Iterator iterator()
    {
        return internalList.iterator();
    }
    public String toString()
    {
        return internalList.toString();
    }
}
