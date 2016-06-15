package moduleone.testcollection.setImplementation;

import moduleone.helper.CollectionHelper;

import java.util.Set;

/**
 * Created by User on 15.06.2016.
 */
public class SetPopulateTest extends SetImplementationTest {

    public SetPopulateTest(Set set, int size) {
        super(set, size);
    }

    @Override
    public long getTime(int index, int value) {
        CollectionHelper.eraseCollection(set);

        long startTime = System.nanoTime();

        operationTest(index, value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }

    @Override
    public void operationTest(int index, int value) {
        CollectionHelper.fillCollection(set, size);
    }
}
