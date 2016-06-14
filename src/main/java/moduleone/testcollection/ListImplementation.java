package moduleone.testcollection;

import moduleone.helper.CollectionHelper;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by SleepWalker on 06.06.2016.
 */
public class ListImplementation {

    private int size;
    private List list;

    public ListImplementation(List list, int size) {
        this.list = list;
        this.size = size;
    }

    public long addingSpeed(int value, int index){

        long startTime = System.nanoTime();

        list.add(index, value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long gettingSpeed(int index){

        long startTime = System.nanoTime();

        list.get(index);

        long estimatedTime = System.nanoTime() - startTime;

        return  estimatedTime;
    }

    public long removingSpeed(int index){

        long startTime = System.nanoTime();

        list.remove(index);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long speedOfMethodContains(int value){

        long startTime = System.nanoTime();

        list.contains(value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long populatingSpeed(){

        CollectionHelper.eraseCollection(list);

        long startTime = System.nanoTime();

        CollectionHelper.fillCollection(list, size);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long speedOfListIteratorAdd(int value, int index){

        ListIterator iterator = list.listIterator();
        int i = 0;

        while (i < index){
            iterator.next();
            i++;
        }

        long startTime = System.nanoTime();

        iterator.add(value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long speedOfListIteratorRemove(int index){

        ListIterator iterator = list.listIterator();
        int i=0;

        while (i <= index){
            iterator.next();
            i++;
        }

        long startTime = System.nanoTime();

        try {
            iterator.remove();
        }catch (IllegalStateException e){

        }
        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

}
