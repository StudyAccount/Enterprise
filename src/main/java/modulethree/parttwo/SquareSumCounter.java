package modulethree.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by User on 07.07.2016.
 */
public class SquareSumCounter implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        int parties = phaserPartiesCalculator(values, numberOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        Phaser phaser = new Phaser(parties);

        List<Long> tempResults = new ArrayList<>();

        long result = 0;
        int startIndex = 0;
        int endIndex = parties - 1;

        for (int i = 0; i < numberOfThreads; i++){

            Future<Long> f = executorService.submit(() -> {

                long sum = 0;
                int j = startIndex;

                while (j < endIndex){

                    sum+= Math.pow(values[j], 2);
                    j++;
                }

                tempResults.add(sum);
                phaser.arriveAndAwaitAdvance();
                return sum;
            });


            try {
                long tempResult = f.get();
                System.out.printf("temp " + tempResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            phaser.arriveAndDeregister();
            executorService.shutdown();

            for (long sums:tempResults) {

                result += sums;
            }

        }

        return result;
    }


    public int phaserPartiesCalculator(int[] values, int numberOfThreads){

        int parties = 0;

        if (values.length >= numberOfThreads){

            if (values.length % numberOfThreads == 0){

                parties = numberOfThreads/values.length;
            } else {

                parties = numberOfThreads/values.length + 1;
            }
        } else {

            parties = numberOfThreads;
        }

        return parties;
    }

}
