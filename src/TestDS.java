import dataStructure.DynamicArray;
import java.util.Iterator;

public class TestDS
{

    public static void main(String[] args)
    {
        DynamicArray da = new DynamicArray(5);
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
}
