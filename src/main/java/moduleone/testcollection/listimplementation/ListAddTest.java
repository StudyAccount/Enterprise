package moduleone.testcollection.listimplementation;

import java.util.List;

/**
 * Created by User on 15.06.2016.
 */
public class ListAddTest extends ListImplementationTest {

    public ListAddTest(List list, int size) {
        super(list, size);
    }

    @Override
    public void operationTest(int value, int index) {
        list.add(value);
    }
}
