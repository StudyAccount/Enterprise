package moduleone.tester;

import moduleone.helper.CollectionHelper;
import moduleone.output.Collector;
import moduleone.testcollection.listimplementation.*;

import java.util.*;

/**
 * Created by SleepWalker on 07.06.2016.
 */

public class ListTester {

    public static final int NUMBER_OF_ITERATIONS = 100;

    public static String arrayListCollection(int collectionSize){
        List<Integer> arrayList = new ArrayList<Integer>();

        ArrayList<Long> resultArray = testAggregator(arrayList, collectionSize);

        Formatter result = Collector.collector(resultArray);

        return result.toString();
    }

    public static String linkedListCollection(int collectionSize){
        List<Integer> arrayList = new LinkedList<Integer>();

        ArrayList<Long> resultArray = testAggregator(arrayList, collectionSize);

        Formatter result = Collector.collector(resultArray);

        return result.toString();
    }

    private static ArrayList<Long> testAggregator (List list, int size){

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

        ArrayList<Long> outputArray = new ArrayList();
        outputArray.add(addingTime);
        outputArray.add(gettingTime);
        outputArray.add(removingTime);
        outputArray.add(timeOfMethodContains);
        outputArray.add(populatingTime);
        outputArray.add(timeOfListIteratorAdd);
        outputArray.add(timeOfListIteratorRemove);


        return outputArray;
    }

}
