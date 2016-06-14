package moduleone.testcollection;

import moduleone.helper.CollectionHelper;

import java.util.Set;

/**
 * Created by User on 08.06.2016.
 */
public class SetImplementation {

    private int size;
    private Set set;

    public SetImplementation(Set set, int size) {
        this.set = set;
        this.size = size;
    }

    public long addingSpeed(int value){

        long startTime = System.nanoTime();

        set.add(value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long removingSpeed(int value){

        long startTime = System.nanoTime();

        set.remove(value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long speedOfMethodContains(int value){

        long startTime = System.nanoTime();

        set.contains(value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public long populatingSpeed(){

        CollectionHelper.eraseCollection(set);

        long startTime = System.nanoTime();

        CollectionHelper.fillCollection(set, size);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }
}
