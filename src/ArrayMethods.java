public interface ArrayMethods<T> {

    /**
     *Create an array with random values of type T
     *
     *@param numValues the number of element in the array
     *@param minVal the minimum possible value for the array elements
     *@param maxVal the maximum value for the array elements
     *
     *This method should generate an array size 'numValues' and populate
     *it with random values between 'minVal' and 'maxVal' inclusive.
     */
    abstract void createArray(int numValues, T minVal, T maxVal);


    /**
     *Displays the array elements.
     *
     *This method should output the contents of the array in a readable format.
     *If the array is empty or uninitialized, an appropriate message should be displayed.
     */
    abstract void displayArray();



    /**
     *Saves the array to a file.
     *
     *@param fileName the name of the file to save the array
     *
     *This method should write the array elements to the specified file.
     *The values can be saved in a format such as comma-separated
     *If the array is empty, the method should handle this case and inform the user.
     */
    abstract void saveArrayToFile(String fileName);


    /**
     *Finds the position of a target value in the array.
     *
     *@param target the value to search for in the array
     *
     *This method should search the array for the given target value.
     *If the value is found, the method should print its index;
     *otherwise, it should notify that the value is not in the array.
     */
    abstract void findValue(int target);


    /**
     *Deletes the current array.
     *
     *This method should delete or clear the array by resetting its contents.
     *It effectively "removes" the array, making it unavailable for further operations
     *until a new one is created.
     */
    abstract void deleteArray();
}