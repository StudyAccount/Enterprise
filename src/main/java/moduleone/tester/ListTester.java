package moduleone.tester;

import moduleone.helper.CollectionHelper;
import moduleone.testcollection.ListImplementation;
import moduleone.testcollection.listimplementation.*;

import java.util.*;

/**
 * Created by SleepWalker on 07.06.2016.
 */

public class ListTester {

    public static final int NUMBER_OF_ITERATIONS = 100;

    public static String arrayListCollection(int collectionSize){
        List<Integer> arrayList = new ArrayList<Integer>();

        testAggregator(arrayList, collectionSize);

        return tester(arrayList, collectionSize).toString();
    }

    public static String linkedListCollection(int collectionSize){
        List<Integer> arrayList = new LinkedList<Integer>();

        long[] list = testAggregator(arrayList, collectionSize);

        return tester(arrayList, collectionSize).toString();
//        return  list;
    }

    private static long[] testAggregator (List list, int size){

        Random rand = new Random();

        CollectionHelper.fillCollection(list, size);

        int position = rand.nextInt(list.size() - 1);
        int addedValue = rand.nextInt();

        ListAddTest listAddTest = new ListAddTest(list, size);
        ListGetSpeed listGetSpeed = new ListGetSpeed(list, size);
        ListRemoveTest listRemoveTest = new ListRemoveTest(list, size);
        ListContainsTest listContainsTest = new ListContainsTest(list, size);
        ListPopulateTest listPopulateTest = new ListPopulateTest(list, size);
        ListIteratorAddTest listIteratorAddTest = new ListIteratorAddTest(list, size);
        ListIteratorRemoveTest listIteratorRemoveTest = new ListIteratorRemoveTest(list, size);

        int i = 0;
        long addingTime = 0;
        long gettingTime = 0;
        long removingTime = 0;
        long timeOfMethodContains =0;
        long populatingTime = 0;
        long timeOfListIteratorAdd = 0;
        long timeOfListIteratorRemove = 0;

        while (i < NUMBER_OF_ITERATIONS){

            addingTime += listAddTest.getTime(position, addedValue);
            gettingTime += listGetSpeed.getTime(position, addedValue);
            removingTime += listRemoveTest.getTime(position, addedValue);
            timeOfMethodContains += listContainsTest.getTime(position, addedValue);
            populatingTime += listPopulateTest.getTime(position, addedValue);
            timeOfListIteratorAdd += listIteratorAddTest.getTime(position, addedValue);
            timeOfListIteratorRemove += listIteratorRemoveTest.getTime(position, addedValue);

            i++;
        }

        long[] outputArray = new long[7];

        outputArray[0] = addingTime/NUMBER_OF_ITERATIONS;
        outputArray[1] = (gettingTime/NUMBER_OF_ITERATIONS);
        outputArray[2] = (removingTime/NUMBER_OF_ITERATIONS);
        outputArray[3] = (timeOfMethodContains/NUMBER_OF_ITERATIONS);
        outputArray[4] = (populatingTime/NUMBER_OF_ITERATIONS);
        outputArray[5] = (timeOfListIteratorAdd/NUMBER_OF_ITERATIONS);
        outputArray[6] = (timeOfListIteratorRemove/NUMBER_OF_ITERATIONS);

        return outputArray;
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
