
import java.util.Random;

public class OrganicRecycleBin<T> implements BagInterface<T> {

    private T[] items;
    private int numberOfItems;
    public int size;
    @SuppressWarnings("unchecked")
    public OrganicRecycleBin() {
        Random random = new Random();
        int[] myArray= {5,10,15};
        size = myArray[random.nextInt(myArray.length)];
        numberOfItems =0;
        items = (T[]) new Object[size];
    }




    public boolean add(T newItem) {
        boolean result=true;
        if( isFull())
        {
            result=false;
        }
        else
        {
            items[numberOfItems]=newItem;
            numberOfItems++;
        }
        return result;
    }
    public boolean isEmpty() {
        return numberOfItems==0;

    }
    public int getSize() {
        return size;
    }
    public boolean isFull() {
        return numberOfItems==items.length;
    }
    public T removeByIndex(int index) {
        if (index < 0 || index >= numberOfItems) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        T removedItem = items[index];
        numberOfItems--;
        items[index] = items[numberOfItems];
        items[numberOfItems] = null;
        return removedItem;
    }
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException ("The Bag is empty");
        }

        T item= items[numberOfItems-1];
        items[numberOfItems-1]=null;
        return item;
    }
    public T remove(T item) {
        for ( int index=0; index<numberOfItems; index++ ) {
            if (item.equals(items[index]))
            {
                numberOfItems--;
                items[index]=items[numberOfItems];
                items[numberOfItems]=null;
                return item;
            }}
        return item;
    }
    public int getItemCount() {
        {
            return numberOfItems;
        }
    }
    public int getIndexOf(T item) {
        for (int index = 0; index < numberOfItems; index++) {
            if (item.equals(items[index])) {
                return index;
            }
        }
        return -1;
    }
    public boolean contains(T item) {
        return getIndexOf(item)>-1;
    }


    public void displayItems() {
        for(int i=0; i<items.length; i++){
            if(items[i] != null) {
                System.out.println(items[i]);
            }
        }

    }
    public void dump() {
        while (!isEmpty())
            remove();

    }
    public boolean transferTo(BagInterface<T> targetBag, T item) {
        if (targetBag.isFull()) {

            return false; }

        targetBag.add(item);


        remove(item);
        return true;

    }
}
