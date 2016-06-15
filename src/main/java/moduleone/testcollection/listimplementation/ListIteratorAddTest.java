package moduleone.testcollection.listimplementation;

import java.util.List;

/**
 * Created by User on 15.06.2016.
 */
public class ListIteratorAddTest extends ListIteratorTest {

    public ListIteratorAddTest(List list, int size) {
        super(list, size);
    }

    @Override
    public void operationTest(int index, int value) {

        iterator = list.listIterator();

        int i=0;
        while (i < index){
            iterator.next();
            i++;
        }

        try {
            iterator.add(value);
        }catch (IllegalStateException e){

        }
    }
}
