package dataStructure;

import java.util.Iterator;


public class DynamicArray<T> implements Iterable<T>
{

    //Change to generic type
    private T[] array;
    private int length;
    private int capacity;
    private int initialCapacity = 10;


    private void validateParmeter(int parameter)
    {
        if(parameter<0) throw new IllegalArgumentException("Only positive number is allowed");
    }
    public DynamicArray()
    {
        //If the user didn't provided any capacity, use 10 by default
        this(10);
    }

    public DynamicArray(int capacity)
    {
        this.validateParmeter(capacity);
        this.capacity = capacity;
        array = (T[])new Object[capacity];
    }

    public int size()
    {
        return length;
    }

    public boolean isEmpty()
    {
        if(length==0)
        {
            return true;
        }
        return false;
    }

    public T get(int index)
    {
        if(index<0) throw new IndexOutOfBoundsException("Provide a positive number");
        if(index>length) throw new IndexOutOfBoundsException("The provided index is out of the range of the array, provide a value below "+length);
        return array[index];
    }

    public void set(int index, T value)
    {
        this.validateParmeter(index);
        if(index > length+1) throw new IndexOutOfBoundsException("The provided index is out of the range of the array, provide a value below "+length);
        array[index] = value;
    }

    public void clear()
    {
        array = (T[])new Object[initialCapacity];
        length = 0;
        capacity = initialCapacity;
    }

    public void add(T value)
    {
        if(length+1 == capacity)
        {
            capacity = capacity * 2;
            T[] tempArray = (T[])new Object[capacity];
            for (int i=0; i<length; i++)
            {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        array[length++] = value;
    }

    public int remove(T value)
    {
        int index = this.indexOf(value);
        if(index!=-1)
        {
            removeAt(index);
        }
        return index;

    }

    public int indexOf(T value)
    {
        for(int i=0; i<length; i++)
        {
            if(array[i] == value)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * @returns the value of the index which is removed. null will be returned, If the specified index doesn't have a value.
     */
    public T removeAt(int index)
    {
        this.validateParmeter(index);
        if(index>=length)
        {
            throw new IndexOutOfBoundsException("The provided index is out of the range of the array, provide a value below "+length);
        }
        T value = array[index];
        if(index == length-1)
        {
            array[index] = null;
        }
        else
        {
            for (int i = index; i < length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[length - 1] = null;
        }
        length--;

        return value;
    }

    public boolean contains(T value)
    {
        for(int i=0; i<length; i++)
        {
            if(array[i] == value)
            {
                return true;
            }
        }
        return false;
    }

    public Iterator iterator()
    {
        return new Iterator() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<length;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    public String toString()
    {
        String returnString = "";
        if(length == 0)return "[]";
        returnString = returnString + "[" +array[0];
        for(int i=1; i<length; i++)
        {
            returnString = returnString + ", "+array[i];
        }
        returnString = returnString + "]";
        return returnString;
    }
}
