package moduleone.testcollection.listimplementation;

import moduleone.helper.CollectionHelper;

import java.util.List;

/**
 * Created by User on 15.06.2016.
 */
public class ListPopulateTest extends ListImplementationTest {

    public ListPopulateTest(List list, int size) {
        super(list, size);
    }

    @Override
    public void operationTest(int index, int value) {
        CollectionHelper.fillCollection(list, size);
    }

    @Override
    public long getTime(int index, int value) {
        CollectionHelper.eraseCollection(list);

        long startTime = System.nanoTime();

        operationTest(index, value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }
}
