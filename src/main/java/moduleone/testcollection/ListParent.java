package moduleone.testcollection;

import java.util.List;
import java.util.Random;

/**
 * Created by SleepWalker on 07.06.2016.
 */
public class ListParent {

    public static List fillCollection(List list, int size) {

        int i = 0;

        while (i < size){

            Random element = new Random();
            list.add(element.nextInt());
            i++;
        }

        return list;
    }

    public static void erraseCollection(List list){

        list.clear();
    }
}
