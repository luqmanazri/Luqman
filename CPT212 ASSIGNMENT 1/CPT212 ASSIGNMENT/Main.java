import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Title(); // Display the title of the program
            System.out.println("Choose an option:");
            System.out.println("1. Radix sort for integer arrays");
            System.out.println("2. Radix sort for floating-point arrays");
            int choice = sc.nextInt(); // Read the user's choice

            ClearScreen(); // Clear the console screen

            if (choice == 1) {
                Title(); // Display the title of the program
                System.out.println("Enter the size of the integer array: ");
                int size = sc.nextInt(); // Read the size of the integer array
                int[] arr = new int[size]; // Create an integer array of the given size
                System.out.println("\nEnter " + size + " integers in any order");
                for (int i = 0; i < size; i++) {
                    arr[i] = sc.nextInt(); // Read the integers and store them in the array
                }

                ClearScreen(); // Clear the console screen
                Title(); // Display the title of the program
                System.out.println("Before Sorting: ");
                printArray(arr); // Display the array before sorting

                RadixSorter sorter = new RadixSorter();
                int operationCount = sorter.sort(arr, size); // Sort the array using radix sort and get the operation
                                                             // count

                System.out.println("\nAfter Sorting: ");
                printArray(arr); // Display the sorted array
                System.out.print("\n");
                System.out.print("\nNumber of Array: " + size);
                System.out.print("\n");
                System.out.println("Number of Operations: " + operationCount); // Display the operation count
            } else if (choice == 2) {
                Title(); // Display the title of the program
                System.out.println("Enter the size of the floating-point array: ");
                int size = sc.nextInt(); // Read the size of the floating-point array
                float[] arr = new float[size]; // Create a floating-point array of the given size
                System.out.println("\nEnter " + size + " floating-point numbers in any order");
                for (int i = 0; i < size; i++) {
                    arr[i] = sc.nextFloat(); // Read the floating-point numbers and store them in the array
                }
                ClearScreen(); // Clear the console screen
                Title(); // Display the title of the program
                System.out.println("Before Sorting: ");
                printArray(arr); // Display the array before sorting

                RadixFloat sorter = new RadixFloat();
                int operationCount = sorter.sort(arr, size); // Sort the array using radix sort and get the operation
                                                             // count

                System.out.println("\nAfter Sorting: ");
                printArray(arr); // Display the sorted array
                System.out.print("\n");
                System.out.print("\nNumber of Array: " + size);
                System.out.print("\n");
                System.out.println("Number of Operations: " + operationCount); // Display the operation count
            } else {
                System.out.println("\nInvalid option selected. Exiting..."); // Display an error message for invalid
                                                                             // choice
            }
        }
    }

    // Method to clear Screen
    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Method to Display Tittle
    public static void Title() {
        System.out.print("********************************\n");
        System.out.print("*     RADIX SORT ALGORITHM     *\n");
        System.out.print("********************************\n");

    }

    // method to print Array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" > ");
            }
        }
    }

    public static void printArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" > ");
            }
        }
    }
}
