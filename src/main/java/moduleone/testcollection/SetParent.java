package moduleone.testcollection;

import java.util.Random;
import java.util.Set;

/**
 * Created by User on 08.06.2016.
 */
public class SetParent {

    public static Set fillCollection(Set set, int size) {

        int i = 0;

        while (i < size){

            Random element = new Random();
            set.add(element.nextInt());
            i++;
        }

        return set;
    }

    public static void eraseCollection(Set set){

        set.clear();
    }
}
