import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu extends IntArrayOps {

    //Method ro run the interactive menue
    public void runMenu(){
        Scanner scnr = new Scanner(System.in); //Create a scanner to read user input
        int choice = -1; //Initialize menu choice variable

        //Loop to keep dispaying the menu until the user chooses to exit (choice = 0)
        while(choice != 0){
            try{
                System.out.println("\nChoose an option:");
                System.out.println("1) Create array");
                System.out.println("2) Display");
                System.out.println("3) Save array");
                System.out.println("4) Find a value");
                System.out.println("5) Sort array using Merge Sort");
                System.out.println("6) Sort array using Shell Sort");
                System.out.println("7) Compare execution time of algorithms Merge Sort and Shell Sort");
                System.out.println("8) Delete array");
                System.out.println("0) Exit");

                //Get user input for menu choice
                choice = scnr.nextInt();

                //Handle user's choice with a switch statement
                switch (choice) {
                    case 0:
                        System.out.println("Exiting program.");
                        break;
                    case 1:
                        try{
                            //Prompt user to enter the number of values
                            System.out.print("Enter number of values: ");
                            this.numberOfValues = scnr.nextInt(); //Get number of values
                            scnr.nextLine(); //Clear the newline character after nextInt()

                            //Prompt user to enter both min and max values in a single line
                            System.out.print("Enter range of values (lower upper): ");
                            String rangeInput = scnr.nextLine(); //Get the entire line of input

                            //Split the input string into two parts (min and max values)
                            String[] rangeParts = rangeInput.split(" ");

                            //Ensure the user has entered exactly two values
                            if(rangeParts.length != 2){
                                throw new IllegalArgumentException("Please enter exactly two integer values.");
                            }

                            //Parse both parts as integers
                            this.minRange = Integer.parseInt(rangeParts[0]); //Parse min
                            this.maxRange = Integer.parseInt(rangeParts[1]); //Parse max value

                            //Validate input and createate array if valid
                            if(this.numberOfValues > 0 && this.minRange < this.maxRange){
                                this.createArray(this.numberOfValues, this.minRange, this.maxRange);
                                continue; //Return to the main menu after array creation
                            }

                            //If the input validation fails, throw an exception
                            throw new IllegalArgumentException("Invalid input: Min value should be less than max value");

                        }catch(InputMismatchException e){
                            //Handle invalid input for number of values
                            System.out.println("Invalid input for number of values. Please enter a valid integer.");
                            scnr.nextLine(); //Clear the input buffer
                        }catch(NumberFormatException e){
                            //Handle invalid input if min or max values are not integers
                            System.out.println("Invalid input format. Please enter two valid integers.");
                        }catch(IllegalArgumentException e){
                            //Handle validation errors or incorrect number of values entered
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        //Display the array
                        this.displayArray();
                        break;
                    case 3:
                        //Save the array to a file
                        System.out.print("Enter file name to save array: ");
                        String fileName = scnr.next();
                        this.saveArrayToFile(fileName);
                        break;
                    case 4:
                        //Find a value in the array
                        try{
                            System.out.print("Enter file name to find in array: ");
                            int valueToFind = scnr.nextInt(); //Get value to search for
                            this.findValue(valueToFind); //Call method to find value
                        }catch(InputMismatchException e){
                            //Handle invalid input for value search
                            System.out.println("Invalid input. Please enter a valid value to search.");
                            scnr.nextLine(); //Clear input buffer
                        }
                        break;
                    case 5:
                        // Sort the array using Merge Sort
                        try{
                            if(this.values == null){
                                throw new IllegalStateException("Array is empty. Create and array first.");
                            }
                            this.mergeSort();
                        } catch (IllegalStateException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        // Sort the array using Shell Sort
                        try{
                            if(this.values == null){
                                throw new IllegalStateException("Array is empty. Create an array first.");
                            }
                            this.shellSort();
                        } catch (IllegalStateException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 7:
                        // Compare execution time of Merge Sort and Shell Sort
                        try{
                            if(this.values == null){
                                throw new IllegalStateException("Array is empty. Create an array first.");
                            }
                            this.compareSortTimes();
                        } catch (IllegalStateException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 8:
                        //Delete the current array
                        this.deleteArray();
                        break;
                    default:
                        //Handle invalid menu choice
                        System.out.println("Invalid option. Please choose again.");
                }
            }catch (InputMismatchException e){
                //Handle invalid menu choice input
                System.out.println("Invalid menu choic. Please enter 1-5 or 0 to exit.");
                scnr.nextLine(); //Clear input buffer
            }
        }
    }
}