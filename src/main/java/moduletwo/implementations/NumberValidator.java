package moduletwo.implementations;

import moduletwo.interfaces.Validator;

/**
 * Created by User on 18.06.2016.
 */
public class NumberValidator implements Validator<Number> {



    @Override
    public boolean isValid(Number result) {

        boolean val = (result.longValue() > 0);
        return val;
    }
}
