package moduleone.tester;

import moduleone.testcollection.SetImplementation;
import moduleone.testcollection.SetParent;

import java.util.*;

/**
 * Created by User on 08.06.2016.
 */
public class SetTester {

    public static final int NUMBER_OF_ITERATIONS = 100;

    public static String hashSetCollection(int collectionSize){
        Set<Integer> hashSet = new HashSet<Integer>();

        return tester(hashSet, collectionSize).toString();
    }

    public static String treeSetCollection(int collectionSize){
        Set<Integer> treeSet = new TreeSet<Integer>();

        return  tester(treeSet, collectionSize).toString();

    }

    public static Formatter tester(Set set, int size){

        SetParent.fillCollection(set, size);

        SetImplementation setImplementation = new SetImplementation(set, size);

        Random randomValue = new Random();
        int addedValue = randomValue.nextInt();

        Random randomPosition = new Random();
        int position = randomPosition.nextInt(set.size() - 1);

        int i = 0;
        long addingTime = 0;
        long removingTime = 0;
        long timeOfMethodContains =0;
        long populatingTime = 0;

        while (i < NUMBER_OF_ITERATIONS){

            addingTime += setImplementation.addingSpeed(addedValue);
            removingTime += setImplementation.removingSpeed(position);
            timeOfMethodContains += setImplementation.speedOfMethodContains(addedValue);
            populatingTime += setImplementation.populatingSpeed();
            i++;
        }

//        StringBuilder out = new StringBuilder();
        Formatter out = new Formatter();

        out.format("| %-12d| %-12s| %-12d| %-12d| %-12d| %-12s| %-16s|",
                addingTime/NUMBER_OF_ITERATIONS, "", removingTime/NUMBER_OF_ITERATIONS,
                timeOfMethodContains/NUMBER_OF_ITERATIONS,  populatingTime/NUMBER_OF_ITERATIONS,
                "", "");

//        out.append(addingTime/NUMBER_OF_ITERATIONS + " " +
//                removingTime/NUMBER_OF_ITERATIONS + " " +
//                timeOfMethodContains/NUMBER_OF_ITERATIONS + " " +
//                populatingTime/NUMBER_OF_ITERATIONS);

        return out;
    }

}
