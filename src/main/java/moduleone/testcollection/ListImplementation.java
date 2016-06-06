package moduleone.testcollection;

import java.util.List;
import java.util.Random;

/**
 * Created by SleepWalker on 06.06.2016.
 */
public class ListImplementation {

    private int size;
    private List list;
    private int testNumber;

    public ListImplementation(List list, int size) {
        this.list = list;
        this.size = size;
    }

    public long addingSpeed(int value, int index){

//        Random randomValue = new Random();
//        int addedValue = randomValue.nextInt();
//
//        Random randomPosition = new Random(list.size());
//        int position = randomPosition.nextInt();

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

    public long populatingSpeed(int size){

        long startTime = System.nanoTime();

        fillCollection();

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    public List fillCollection() {

        int i = 0;

        while (i < size){

            Random element = new Random();
            list.add(element.nextInt());
            i++;
        }

        return list;
    }


}
