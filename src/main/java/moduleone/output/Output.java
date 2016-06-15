package moduleone.output;

import moduleone.tester.ListTester;
import moduleone.tester.SetTester;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

/**
 * Created by User on 08.06.2016.
 */
public class Output {


    public static void outputWriter(int size){

        Formatter formatter = dataOutput(size);

        System.out.println(formatter.toString());

        String filename = "AverageTime " + size/1000 + "K";
        fileWriter(filename, formatter.toString());

    }

    private static void fileWriter(String fileName, String message) {
        File file = new File(fileName);

        try {
            if (!file.exists()){
                file.createNewFile();
            }
        }   catch (IOException e){
            System.out.println("Can not create a file");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()))) {
            bufferedWriter.write(message);
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Can not write to file");
        }
    }

    private static Formatter dataOutput(int size) {
        String arrayListCollection = ListTester.arrayListCollection(size);
        String linkedListCollection = ListTester.linkedListCollection(size);

        String hashSetCollection = SetTester.hashSetCollection(size);
        String treeSetCollection = SetTester.treeSetCollection(size);

        Formatter formatter = new Formatter();
        formatter.format("Average time in nanoseconds for collections with size %d:\n" +
                "|\t\t\t | %-12s| %-12s| %-12s| %-12s| %-12s| %-12s| %-16s|\n|%-12s%s\n|%-12s%s\n|%-12s%s\n|%-12s%s\n",
                size, "add", "get", "remove", "contains", "populate", "iterator.add", "iterator.remove",
                " ArrayList", arrayListCollection, " LinkedList", linkedListCollection,
                " HashSet", hashSetCollection, " TreeSet", treeSetCollection);
        return formatter;
    }


}
