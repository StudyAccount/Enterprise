package moduleone.testcollection.listimplementation;

import java.util.List;

/**
 * Created by User on 15.06.2016.
 */
public class ListGetSpeed extends ListImplementationTest {

    public ListGetSpeed(List list, int size) {
        super(list, size);
    }

    @Override
    public void operationTest(int index, int value) {
        list.get(index);
    }
}
