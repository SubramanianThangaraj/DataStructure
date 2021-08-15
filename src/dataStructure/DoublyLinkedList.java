package dataStructure;

import java.util.Iterator;

public class DoublyLinkedList<T>
{
    public int size;
    public Node<T> head;
    public Node<T> tail;

    public class Node<T>
    {
        public Node next;
        public Node previous;
        public T data;
        public Node()
        {
            next = null;
            previous = null;
        }
        public Node(T data, Node next, Node previous)
        {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public DoublyLinkedList()
    {
        size = 0;
        head = null;
        tail = null;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public void addLast(T data)
    {
        if(isEmpty())
        {
            head = tail = new Node(data, null, null);
        }
        else
        {
            tail.next = new Node(data, null, tail);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T data)
    {
        if(isEmpty())
        {
            head = tail = new Node(data, null, null);
        }
        else
        {
            head.previous = new Node(data, head, null);
            head = head.previous;
        }
        size++;
    }

    public void add(T data)
    {
        addLast(data);
    }

    public T peekFirst()
    {
        if(isEmpty())
        {
            throw new RuntimeException("The list is empty");
        }
        return head.data;
    }

    public T peekLast()
    {
        if(isEmpty())
        {
            throw new RuntimeException("The list is empty");
        }
        return tail.data;
    }

    public T removeFirst()
    {
        if(isEmpty())
        {
            throw new RuntimeException("The list is empty");
        }
        T data = head.data;
        if(size() == 1)
        {
            head = tail = null;
        }
        else
        {
            head.next.previous = null;
            head = head.next;
        }
        size--;
        return data;
    }

    public T removeLast()
    {
        if(isEmpty())
        {
            throw new RuntimeException("The list is empty");
        }
        T data = tail.data;
        if(size() == 1)
        {
            head = tail = null;
        }
        else
        {
            tail.previous.next = null;
            tail = tail.previous;
        }
        size--;
        return data;
    }

    public T removeAt(int index)
    {
        if(index<0 || index>size){ throw new IllegalArgumentException("Index crossed the limit, Provide an index between 0 and "+size);}
        Node<T> currentNode = null;
        if(index<size/2)
        {
            currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.next;
            }
        }
        else
        {
            currentNode = tail;
            for(int i=size-2; i>=index; i--)
            {
                currentNode = currentNode.previous;
            }
        }
        return remove(currentNode);
    }

    private T remove(Node<T> node)
    {
        if(node.previous == null) return removeFirst();
        else if(node.next == null) return removeLast();
        node.previous.next = node.next;
        node.next.previous = node.previous;
        T data = node.data;
        node.data = null;
        node.next = node.previous = null;
        size--;
        return data;
    }

    //Do we need to support null removal?
    public int remove(T data)
    {
        if(isEmpty())
        {
            throw new RuntimeException("The list is empty");
        }
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if(currentNode.data == data)
            {
                remove(currentNode);
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    //Do we need to support null removal?
    public int indexOf(T data)
    {
        if(isEmpty())
        {
            throw new RuntimeException("The list is empty");
        }
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if(currentNode.data == data)
            {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public boolean contains(T data)
    {
        return indexOf(data)!= -1;
    }

    public void clear()
    {
        Node<T> currentNode = head;
        Node<T> nextNode;
        while (currentNode!=null)
        {
            nextNode = currentNode.next;
            currentNode.data = null;
            currentNode.next = currentNode.previous = null;
            currentNode = nextNode;
        }
        nextNode = head = tail = null;
        size = 0;
    }

    public Iterator iterator()
    {
        return new Iterator() {
            Node<T> currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode!=null;
            }

            @Override
            public Object next() {
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    public String toString()
    {
        String returnString = "[";
        Node<T> currentNode = head;

        while (currentNode!=null)
        {
            returnString =returnString + currentNode.data +  ",";
            currentNode = currentNode.next;
        }
        returnString = returnString + "]";
        return returnString;

    }

}
