package moduleone.testcollection.setImplementation;

import java.util.Set;

/**
 * Created by User on 15.06.2016.
 */
public class SetRemoveTest extends SetImplementationTest {
    public SetRemoveTest(Set set, int size) {
        super(set, size);
    }

    @Override
    public void operationTest(int index, int value) {
        set.remove(value);
    }
}
