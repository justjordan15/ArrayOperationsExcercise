import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu extends IntArrayOps {

    public void runMenu() {
        Scanner scnr = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Create Array");
                System.out.println("2. Display Array");
                System.out.println("3. Save Array to File");
                System.out.println("4. Find Value in Array");
                System.out.println("5. Delete Array");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scnr.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Exiting program.");
                        break;
                    case 1:
                        try {
                            System.out.print("Enter number of values: ");
                            this.numberOfValues = scnr.nextInt();
                            System.out.print("Enter min value: ");
                            this.minRange = scnr.nextInt();
                            System.out.print("Enter max value: ");
                            this.maxRange = scnr.nextInt();
                            if (this.numberOfValues > 0 && this.minRange < this.maxRange) {
                                this.createArray(this.numberOfValues, this.minRange, this.maxRange);
                                continue;
                            }

                            throw new IllegalArgumentException("Invalid input for array creation. Min value should be less than max value.");
                        } catch (InputMismatchException var6) {
                            System.out.println("Invalid input for array creation. Please enter valid numbers.");
                            scnr.nextLine();
                        } catch (IllegalArgumentException var7) {
                            IllegalArgumentException e = var7;
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        this.displayArray();
                        break;
                    case 3:
                        System.out.print("Enter file name to save array: ");
                        String fileName = scnr.next();
                        this.saveArrayToFile(fileName);
                        break;
                    case 4:
                        try {
                            System.out.print("Enter value to find in the array: ");
                            int valueToFind = scnr.nextInt();
                            this.findValue(valueToFind);
                        } catch (InputMismatchException var5) {
                            System.out.println("Invalid input. Please enter a valid value to search.");
                            scnr.nextLine();
                        }
                        break;
                    case 5:
                        this.deleteArray();
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (InputMismatchException var8) {
                System.out.println("Invalid menu choice. Please enter 1-5 or 0 to exit.");
                scnr.nextLine();
            }
        }

    }
}
