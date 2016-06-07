package moduleone.tester;

import moduleone.testcollection.ListImplementation;
import moduleone.testcollection.ListParent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SleepWalker on 07.06.2016.
 */

public class Tester {

    public static void tester(){

        List<Integer> arrayList = new ArrayList<Integer>();

        int size = 1000000;

        ListParent.fillCollection(arrayList, size);

        ListImplementation listImplementation = new ListImplementation(arrayList, size);

        Random randomValue = new Random();
        int addedValue = randomValue.nextInt();

        Random randomPosition = new Random();
        int position = randomPosition.nextInt(arrayList.size() - 1);

        int i = 0;
        long addingTime = 0;
        long gettingTime = 0;
        long removingTime = 0;
        long timeOfMethodContains =0;
        long populatingTime = 0;
        long timeOfListIteratorAdd = 0;
        long timeOfListIteratorRemove = 0;

        while (i < 100){

            addingTime += listImplementation.addingSpeed(addedValue, position);
            gettingTime += listImplementation.gettingSpeed(position);
            removingTime += listImplementation.removingSpeed(position);
            timeOfMethodContains += listImplementation.speedOfMethodContains(addedValue);
            populatingTime += listImplementation.populatingSpeed();
            timeOfListIteratorAdd += listImplementation.speedOfListIteratorAdd(addedValue, position);
            timeOfListIteratorRemove += listImplementation.speedOfListIteratorRemove(position);


            i++;
        }

        System.out.println("asdasd " + addingTime/100);
        System.out.println("asdasd " + gettingTime/100);
        System.out.println("asdasd " + removingTime/100);
        System.out.println("asdasd " + timeOfMethodContains/100);
        System.out.println("asdasd " + populatingTime/100);
        System.out.println("asdasd " + timeOfListIteratorAdd/100);
        System.out.println("asdasd " + timeOfListIteratorRemove/100);
    }







}
