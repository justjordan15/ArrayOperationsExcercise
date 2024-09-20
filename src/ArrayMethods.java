public interface ArrayMethods <T>{

    //Menu operation requirements (Re-usable if a different type of array is asked to be created)
    void createArray(int numValues, T minVal, T maxVal);

    void displayArray();

    void saveArrayToFile(String fileName);

    void findValue(int target);

    void deleteArray();


}
