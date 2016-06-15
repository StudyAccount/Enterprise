package moduleone.testcollection.listimplementation;

import java.util.List;

/**
 * Created by User on 15.06.2016.
 */
public class ListIteratorRemoveTest extends ListIteratorTest {

    public ListIteratorRemoveTest(List list, int size) {
        super(list, size);
    }

    @Override
    public void operationTest(int index, int value) {

        iterator = list.listIterator();

        int i=0;

        while (i <= index){
            iterator.next();
            i++;
        }

        try {
            iterator.remove();
        }catch (IllegalStateException e){

        }
    }
}
