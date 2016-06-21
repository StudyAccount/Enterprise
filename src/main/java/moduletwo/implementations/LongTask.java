package moduletwo.implementations;

import moduletwo.interfaces.Task;

/**
 * Created by User on 18.06.2016.
 */
public class LongTask implements Task<Long> {

    private Long input;
    private Long output;
    private final static Long SOME_EXTRA_LONG_NUMBER = 10L;

    public LongTask(Long input, Long output) {
        this.input = input;
        this.output = output;
    }


    @Override
    public void execute() {

        output = input + SOME_EXTRA_LONG_NUMBER;
    }

    @Override
    public Long getResult() {

        return output;
    }
}
