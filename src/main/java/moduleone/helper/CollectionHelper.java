package moduleone.helper;

import java.util.Collection;
import java.util.Random;

/**
 * Created by SleepWalker on 07.06.2016.
 */
public class CollectionHelper {

    public static Collection fillCollection(Collection collection, int size) {

        int i = 0;
        Random element = new Random();

        while (i < size){

            collection.add(element.nextInt());
            i++;
        }

        return collection;
    }

    public static void eraseCollection(Collection collection){

        collection.clear();
    }
}
