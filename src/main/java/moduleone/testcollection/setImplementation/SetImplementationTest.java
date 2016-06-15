package moduleone.testcollection.setImplementation;

import moduleone.testcollection.Test;

import java.util.Set;

/**
 * Created by User on 15.06.2016.
 */
public class SetImplementationTest implements Test {

    protected int size;
    protected Set set;

    public SetImplementationTest(Set set, int size) {
        this.set = set;
        this.size = size;
    }

    @Override
    public long getTime(int index, int value) {

        long startTime = System.nanoTime();

        operationTest(index, value);

        long estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }


    public void operationTest(int index, int value) {

    }
}
