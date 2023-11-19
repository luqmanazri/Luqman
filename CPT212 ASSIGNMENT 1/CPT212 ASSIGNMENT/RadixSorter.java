
import java.util.ArrayList;
import java.util.Collections;

public class RadixSorter {
    int operationCount = 0;

    // This method performs the radix sort algorithm on a integer array
    public int sort(int[] arr, int size) {
        // Get the maximum value of the array to determine the number of digits
        int max = getMax(arr, size);

        // Create two arrays to hold the sorted output
        int[] output1 = new int[size];
        int[] output2 = new int[size];

        // Perform bucket sort for each digit, starting from the least significant digit
        int operationCount = 0;
        for (int div = 1; max / div > 0; div *= 10) {
            // Sort the array into output1 using bucket sort
            operationCount += bucketSort(arr, size, div, output1);

            // Sort output1 back into the array using another pass of bucket sort
            operationCount += bucketSort(output1, size, div, output2);
            // Swap the arrays to prepare for the next iteration
            int[] temp = output1;
            output1 = output2;
            output2 = temp;
        }
        // Copy the sorted elements from the final output array back into the input
        // array
        System.arraycopy(output1, 0, arr, 0, size);

        return operationCount;
    }

    // This method returns the maximum value in a floating-point array
    public int getMax(int[] arr, int size) {
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
                operationCount++;// Increment counter
            }
        }
        return max;
    }

    // This method performs bucket sort on a Integer array based on a
    // specific digit
    public int bucketSort(int[] arr, int size, int div, int[] output) {
        int numOfBuckets = 10;

        // Initialize the buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numOfBuckets);
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(new ArrayList<>());
            operationCount++;
        }
        // Place elements into buckets based on the specific digit
        for (int i = 0; i < size; i++) {
            int digit = (arr[i] / div) % 10;
            buckets.get(digit).add(arr[i]);
            operationCount++; // Increment the counter for each element placement
        }

        // Sort each bucket individually
        int index = 0;
        int operationCount = 0; // Initialize operationCount variable
        for (ArrayList<Integer> bucket : buckets) {
            if (bucket.size() > 1) {
                Collections.sort(bucket);
                operationCount += bucket.size() * (int) (Math.log(bucket.size()));
            }
            for (int value : bucket) {
                output[index++] = value;
                operationCount++; // Increment the counter for each element retrieval
            }
        }

        System.arraycopy(output, 0, arr, 0, size);
        return operationCount;
    }
}
