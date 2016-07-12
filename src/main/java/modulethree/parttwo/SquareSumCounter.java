package modulethree.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by User on 07.07.2016.
 */
public class SquareSumCounter implements SquareSum {

    public static void main(String[] args) {
        int[] u = {1,2,3, 4};
        System.out.println("result " + new SquareSumCounter().getSquareSum(u, 2));
    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        int parties = phaserPartiesCalculator(values, numberOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        Phaser phaser = new Phaser(parties);

        List<Long> tempResults = new ArrayList<>();

        long result = 0;
        int startIndex = 0;
        int endIndex = parties;

        for (int i = 0; i < numberOfThreads; i++){

            singleThreadStarter(values, executorService, phaser, tempResults, startIndex, endIndex);
            startIndex += parties;
            endIndex += parties;
        }

        phaser.arriveAndDeregister();
        executorService.shutdown();

        for (long sums:tempResults) {

            result += sums;
        }

        return result;
    }

    private void singleThreadStarter(int[] values, ExecutorService executorService, Phaser phaser,
                                     List<Long> tempResults, int startIndex, int endIndex) {
        executorService.execute(() -> {

            long sum = 0;
            int j = startIndex;

            while (j < endIndex){

                sum+= Math.pow(values[j], 2);
                j++;
            }

            tempResults.add(sum);
            System.out.println(Thread.currentThread().getName());
            System.out.println(sum);
            phaser.arriveAndAwaitAdvance();
        });
    }


    private int phaserPartiesCalculator(int[] values, int numberOfThreads){

        int parties;

        if (values.length >= numberOfThreads){

            if (values.length % numberOfThreads == 0){

                parties = values.length/numberOfThreads;
            } else {

                parties = values.length/numberOfThreads + 1;
            }
        } else {

            parties = numberOfThreads;
        }

        return parties;
    }

}
