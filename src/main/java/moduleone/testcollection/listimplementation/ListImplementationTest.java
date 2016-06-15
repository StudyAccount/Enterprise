package moduleone.testcollection.listimplementation;

import moduleone.testcollection.Test;

import java.util.List;

/**
 * Created by User on 14.06.2016.
 */
public class ListImplementationTest implements Test {

    protected int size;
    protected List list;

    public ListImplementationTest(List list, int size) {
        this.list = list;
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
