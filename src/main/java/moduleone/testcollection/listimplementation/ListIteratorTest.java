package moduleone.testcollection.listimplementation;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by User on 15.06.2016.
 */
public class ListIteratorTest extends ListImplementationTest {

    ListIterator iterator;

    public ListIteratorTest(List list, int size) {
        super(list, size);
    }

    @Override
    public long getTime(int index, int value) {

        long startTime = System.nanoTime();

        operationTest(index, value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

}
