package moduletwo.implementations;

import moduletwo.exceptions.ExecutorException;
import moduletwo.interfaces.Executor;
import moduletwo.interfaces.Task;
import moduletwo.interfaces.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15.06.2016.
 */
public class ExecutorImplementation<T> implements Executor<T> {

    private List<Task<? extends T>> tasks = new ArrayList<>();
    private List<? super T> validResults = new ArrayList<>();
    private List<? super T> inValidResults = new ArrayList<>();
    private boolean isExecuted = false;
    private Validator<? super T> validator;

    @Override
    public void addTask(Task<? extends T> task) throws ExecutorException {

        isExecutorCalled();
        tasks.add(task);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws ExecutorException {

        isExecutorCalled();
        addTask(task);
        this.validator = validator;
    }


    @Override
    public void execute() {

        isExecuted = true;

        if (validator != null) {

            for (Task<? extends T> task : tasks) {

                if (validator.isValid(task.getResult())) {

                    validResults.add(task.getResult());
                } else {

                    inValidResults.add(task.getResult());
                }
            }
        }
    }

    @Override
    public List getValidResults() throws ExecutorException{

        isExecutorWasNotCalled();
        return validResults;
    }

    @Override
    public List getInvalidResults() throws ExecutorException{

        isExecutorWasNotCalled();
        return inValidResults;
    }

    private void isExecutorCalled() throws ExecutorException {

        if (isExecuted) {

            throw new ExecutorException("Method execute() was already called");
        }
    }

    private void isExecutorWasNotCalled() throws ExecutorException {

        if (!isExecuted) {

            throw new ExecutorException("Method execute() was not called yet");
        }
    }
}
