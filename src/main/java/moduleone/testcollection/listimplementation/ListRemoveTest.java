package moduleone.testcollection.listimplementation;

import java.util.List;

/**
 * Created by User on 15.06.2016.
 */
public class ListRemoveTest extends ListImplementationTest {
    public ListRemoveTest(List list, int size) {
        super(list, size);
    }

    @Override
    public void operationTest(int index, int value) {
        list.remove(index);
    }
}
