import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;


public abstract class IntArrayOps implements ArrayMethods<Integer>{
    //Fields for managing the array of type T
    Integer[] values;     //Array to store Integer values
    int numberOfValues;  //Number of elements in the array
    int minRange;        //Minimum range for random values
    int maxRange;        //Maximum range for random values
    int i;              //for loop variable
    Random rand;       //Random object for getting random numbers

    @Override
    public void createArray(int numValues, Integer minVal, Integer maxVal){
        //Initialize array size and random value range
        this.numberOfValues = numValues;
        this.minRange = minVal;
        this.maxRange = maxVal;
        this.rand = new Random();
        this.values = new Integer[numValues];

        //Populate array with random values between minVal and maxVal
        for(int i = 0; i < numValues; ++i){
            this.values[i] = this.rand.nextInt(maxVal - minVal + 1);
        }
        System.out.println("Array created with " + numValues + " random values.");
    }

    @Override
    public void displayArray(){
        //Check if the array has been initialized
        if (this.values != null){
            System.out.print("Values: ");
            //Loop through the array to display each value
            for(this.i=0; this.i < this.values.length; ++this.i){
                Integer valueToDisplay = this.values[this.i]; //Get current Value

                //Print the current value
                System.out.print(valueToDisplay);

                //If this is not the last value, print a comma and space
                if (this.i < this.values.length - 1){
                    System.out.print(", ");
                }
            }
        } else{
            //If the array is null, indicate that it's empty
            System.out.print("Array is empty.");
        }
        //Print a new line after the array is displayed
        System.out.println();
    }

    @Override
    public void saveArrayToFile(String fileName){
        //Check if the array exists
        if(this.values != null){
            PrintWriter printWriter = null;
            PrintStream printStream = null;

            try{
                //open file for writing
                printStream = new PrintStream(fileName);
                printWriter = new PrintWriter(printStream);

                //Loop through the array and write each value to the file
                for(this.i = 0; this.i < this.values.length; ++this.i){
                    printWriter.print(this.values[this.i].toString());

                    //Add a comma and space after each value except for the last one
                    if(this.i < this.values.length - 1){
                        printWriter.print(", ");
                    }
                }

                printWriter.flush(); //Ensure all data is written to the file
                System.out.println("Array saved to file: " + fileName);

            } catch (FileNotFoundException e){
                //Handle the case where the file cannot be created or opened
                System.out.println("Error saving to file: " + e.getMessage());
            } finally {
                //Ensure the files are closed to release file resources
                if (printWriter != null){
                    printWriter.close();
                }
                if(printStream != null){
                    printStream.close();
                }
            }
        }else{
            //If the array is empty, print message
            System.out.println("Array is empty. Nothing to save.");
        }
    }

    @Override
    public void findValue(int target){
        //Check if the array exists and has at least one element
        if(this.values != null && this.values.length > 0){
            boolean found = false; //Flag to track if the value is found

            //Loop through the array to search for the target value
            for(this.i = 0; this.i < this.values.length; ++this.i){
                //If the current element matches the target value
                if(this.values[this.i].equals(target)){
                    Integer targetValue = this.values[this.i];
                    System.out.println("Value: " + targetValue + " found at index " + this.i);
                    found = true; //Mark value as found
                    break; //Stop searching after found
                }
            }
            //If the value was not found, print
            if (!found){
                System.out.println("Value not found in array.");
            }
        }else{
            //If the array is empty or uninitialized, print
            System.out.println("Array is empty.");
        }
    }

    @Override
    public void deleteArray(){
        //Set the array to null (delete)
        this.values = null;

        //Print a message to confirm the array has been deleted
        System.out.println("Array deleted.");
    }

}