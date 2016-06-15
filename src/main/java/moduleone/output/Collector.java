package moduleone.output;

import java.util.ArrayList;
import java.util.Formatter;

/**
 * Created by User on 15.06.2016.
 */
public class Collector {

    public static Formatter collector(ArrayList<Long> list){

        Long addingTime = list.get(0);
        Long gettingTime = list.get(1);
        Long removingTime = list.get(2);
        Long timeOfMethodContains = list.get(3);
        Long populatingTime = list.get(4);
        Long timeOfListIteratorAdd = list.get(5);
        Long timeOfListIteratorRemove = list.get(6);

        Formatter out = new Formatter();
        out.format("| %-12d| %-12d| %-12d| %-12d| %-12d| %-12d| %-16d|",
                addingTime, gettingTime, removingTime,
                timeOfMethodContains,  populatingTime,
                timeOfListIteratorAdd, timeOfListIteratorRemove);

        return out;
    }
}
