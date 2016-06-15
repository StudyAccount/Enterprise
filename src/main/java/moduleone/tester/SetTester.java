package moduleone.tester;

import moduleone.helper.CollectionHelper;
import moduleone.output.Collector;
import moduleone.testcollection.setImplementation.SetAddTest;
import moduleone.testcollection.setImplementation.SetContainsTest;
import moduleone.testcollection.setImplementation.SetPopulateTest;
import moduleone.testcollection.setImplementation.SetRemoveTest;

import java.util.*;

/**
 * Created by User on 08.06.2016.
 */
public class SetTester {

    public static final int NUMBER_OF_ITERATIONS = 100;

    public static String hashSetCollection(int collectionSize){
        Set<Integer> hashSet = new HashSet<Integer>();

        ArrayList<Long> resultArray = testAggregator(hashSet, collectionSize);

        Formatter result = Collector.collector(resultArray);

        return result.toString();
    }

    public static String treeSetCollection(int collectionSize){
        Set<Integer> treeSet = new TreeSet<Integer>();

        ArrayList<Long> resultArray = testAggregator(treeSet, collectionSize);

        Formatter result = Collector.collector(resultArray);

        return result.toString();
    }

    private static ArrayList<Long> testAggregator (Set set, int size){

        Random rand = new Random();

        CollectionHelper.fillCollection(set, size);

        int position = rand.nextInt(set.size() - 1);
        int addedValue = rand.nextInt();

        SetAddTest setAddTest = new SetAddTest(set, size);

        SetRemoveTest setRemoveTest = new SetRemoveTest(set, size);
        SetContainsTest setContainsTest = new SetContainsTest(set, size);
        SetPopulateTest setPopulateTest = new SetPopulateTest(set, size);

        int i = 0;
        long addingTime = 0;
        long removingTime = 0;
        long timeOfMethodContains =0;
        long populatingTime = 0;

        while (i < NUMBER_OF_ITERATIONS){


            addingTime += setAddTest.getTime(position, addedValue);
            removingTime += setRemoveTest.getTime(position, addedValue);
            timeOfMethodContains += setContainsTest.getTime(position, addedValue);
            populatingTime += setPopulateTest.getTime(position, addedValue);

            i++;
        }

        ArrayList<Long> outputArray = new ArrayList();
        outputArray.add(addingTime);
        outputArray.add(null);
        outputArray.add(removingTime);
        outputArray.add(timeOfMethodContains);
        outputArray.add(populatingTime);
        outputArray.add(null);
        outputArray.add(null);

        return outputArray;
    }

}
