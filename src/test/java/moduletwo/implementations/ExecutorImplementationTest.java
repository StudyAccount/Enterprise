package moduletwo.implementations;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 21.06.2016.
 */
public class ExecutorImplementationTest {

    ExecutorImplementation executorImplementation = new ExecutorImplementation();
    NumberValidator validator = new NumberValidator();

    @Test
    public void executeTest() throws Exception {

        LongTask longTask1 = new LongTask(5L);
        LongTask longTask2 = new LongTask(10L);
        LongTask longTask3 = new LongTask(-10L);
        LongTask longTask4 = new LongTask(-40L);

        longTask1.execute();
        longTask2.execute();
        longTask3.execute();
        longTask4.execute();

        executorImplementation.addTask(longTask1);
        executorImplementation.addTask(longTask2, validator);
        executorImplementation.addTask(longTask3);
        executorImplementation.addTask(longTask4, validator);


        executorImplementation.execute();

        List<Long> actualValidList = executorImplementation.getValidResults();
        List<Long> actualInvalidList = executorImplementation.getInvalidResults();

        List<Long> expectedValidList = Arrays.asList(15L, 20L);
        List<Long> expectedInvalidList = Arrays.asList(0L, -30L);

        Assert.assertEquals(expectedValidList, actualValidList);
        Assert.assertEquals(expectedInvalidList, actualInvalidList);
    }
}