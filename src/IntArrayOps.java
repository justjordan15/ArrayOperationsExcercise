import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;



public abstract class IntArrayOps implements ArrayMethods<Integer>{

    //Implement interface and define methods to process Integer type array

    Integer[] values;
    int numberOfValues;
    int minRange;
    int maxRange;
    int i;
    Random rand;


    @Override
    public void createArray(int numValues, Integer minVal, Integer maxVal) {
        this.numberOfValues = numValues;
        this.minRange = minVal;
        this.maxRange = maxVal;
        this.rand = new Random();
        this.values = new Integer[numValues];

        for(int i = 0; i < numValues; ++i){
            this.values[i] = this.rand.nextInt(maxVal - minVal + 1);
        }
        System.out.println("Array created with " + numValues + " random values.");
    }


    @Override
    public void displayArray() {
        if (this.values != null) {
            System.out.print("Values: ");

            for(this.i = 0; this.i < this.values.length; ++this.i) {
                Integer var10001 = this.values[this.i];
                System.out.print("" + var10001 + " ");
            }
        } else {
            System.out.print("Array is empty.");
        }

        System.out.println();
    }


    @Override
    public void saveArrayToFile(String fileName) {
        if (this.values != null) {
            PrintWriter printWriter = null;
            PrintStream printStream = null;

            try {
                printStream = new PrintStream(fileName);
                printWriter = new PrintWriter(printStream);

                for(this.i = 0; this.i < this.values.length; ++this.i) {
                    printWriter.print(this.values[this.i].toString());
                    if (this.i < this.values.length - 1) {
                        printWriter.print(", ");
                    }
                }

                printWriter.flush();
                System.out.println("Array saved to file: " + fileName);
            } catch (FileNotFoundException var8) {
                FileNotFoundException e = var8;
                System.out.println("Error saving to file: " + e.getMessage());
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }

                if (printStream != null) {
                    printStream.close();
                }

            }
        } else {
            System.out.println("Array is empty. Nothing to save.");
        }

    }


    @Override
    public void findValue(int target) {
        if (this.values != null && this.values.length > 0) {
            boolean found = false;
            for (this.i = 0; this.i < this.values.length; ++this.i) {
                if (this.values[this.i].equals(target)) {
                    Integer targetValue = this.values[this.i];
                    System.out.println("Value: " + targetValue + " found at index " + this.i);
                    found = true;
                    break; // Stop after finding the first occurrence
                }
            }
            if (!found) {
                System.out.println("Value not found in array.");
            }
        } else {
            System.out.println("Array is empty.");
        }
    }


    @Override
    public void deleteArray() {
        this.values = null;
        System.out.println("Array deleted.");
    }

}
