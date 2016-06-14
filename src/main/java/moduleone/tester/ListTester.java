package moduleone.tester;

import moduleone.testcollection.ListImplementation;
import moduleone.helper.CollectionHelper;

import java.util.*;

/**
 * Created by SleepWalker on 07.06.2016.
 */

public class ListTester {

    public static final int NUMBER_OF_ITERATIONS = 100;

    public static String arrayListCollection(int collectionSize){
        List<Integer> arrayList = new ArrayList<Integer>();

        return tester(arrayList, collectionSize).toString();
    }

    public static String linkedListCollection(int collectionSize){
        List<Integer> arrayList = new LinkedList<Integer>();

        return tester(arrayList, collectionSize).toString();
    }

    private static Formatter tester(List list, int size){

        CollectionHelper.fillCollection(list, size);

        ListImplementation listImplementation = new ListImplementation(list, size);

        Random randomValue = new Random();
        int addedValue = randomValue.nextInt();

        Random randomPosition = new Random();
        int position = randomPosition.nextInt(list.size() - 1);

        int i = 0;
        long addingTime = 0;
        long gettingTime = 0;
        long removingTime = 0;
        long timeOfMethodContains =0;
        long populatingTime = 0;
        long timeOfListIteratorAdd = 0;
        long timeOfListIteratorRemove = 0;

        while (i < NUMBER_OF_ITERATIONS){

            addingTime += listImplementation.addingSpeed(addedValue, position);
            gettingTime += listImplementation.gettingSpeed(position);
            removingTime += listImplementation.removingSpeed(position);
            timeOfMethodContains += listImplementation.speedOfMethodContains(addedValue);
            populatingTime += listImplementation.populatingSpeed();
            timeOfListIteratorAdd += listImplementation.speedOfListIteratorAdd(addedValue, position);
            timeOfListIteratorRemove += listImplementation.speedOfListIteratorRemove(position);
            i++;
        }

//        StringBuilder out = new StringBuilder();
        Formatter out = new Formatter();
        out.format("| %-12d| %-12d| %-12d| %-12d| %-12d| %-12d| %-16d|",
                addingTime/NUMBER_OF_ITERATIONS, gettingTime/NUMBER_OF_ITERATIONS, removingTime/NUMBER_OF_ITERATIONS,
                timeOfMethodContains/NUMBER_OF_ITERATIONS,  populatingTime/NUMBER_OF_ITERATIONS,
                timeOfListIteratorAdd/NUMBER_OF_ITERATIONS, timeOfListIteratorRemove/NUMBER_OF_ITERATIONS);

//        out.append(addingTime/NUMBER_OF_ITERATIONS + " " +
//                gettingTime/NUMBER_OF_ITERATIONS + " " +
//                removingTime/NUMBER_OF_ITERATIONS + " " +
//                timeOfMethodContains/NUMBER_OF_ITERATIONS + " " +
//                populatingTime/NUMBER_OF_ITERATIONS + " " +
//                timeOfListIteratorAdd/NUMBER_OF_ITERATIONS + " " +
//                timeOfListIteratorRemove/NUMBER_OF_ITERATIONS);

        return out;
    }

}
