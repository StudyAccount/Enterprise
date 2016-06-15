package moduleone.output;

import moduleone.tester.ListTester;

import java.util.Formatter;

/**
 * Created by User on 15.06.2016.
 */
public class Collector {

    private static Formatter tester(int size){

        long[] linkedListCollection = ListTester.linkedListCollection(size);

        long addingTime = linkedListCollection[0];
        long gettingTime = linkedListCollection[1];
        long removingTime = linkedListCollection[2];
        long timeOfMethodContains = linkedListCollection[3];
        long populatingTime = linkedListCollection[4];
        long timeOfListIteratorAdd = linkedListCollection[5];
        long timeOfListIteratorRemove = linkedListCollection[6];


//        StringBuilder out = new StringBuilder();
        Formatter out = new Formatter();
        out.format("| %-12d| %-12d| %-12d| %-12d| %-12d| %-12d| %-16d|",
                addingTime, gettingTime, removingTime,
                timeOfMethodContains,  populatingTime,
                timeOfListIteratorAdd, timeOfListIteratorRemove);

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
