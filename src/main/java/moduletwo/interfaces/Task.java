package moduletwo.interfaces;

/**
 * Created by User on 10.06.2016.
 */
public interface Task<T>{

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();

}
