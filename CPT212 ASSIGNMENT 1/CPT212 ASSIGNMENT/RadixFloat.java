
import java.util.ArrayList;
import java.util.Collections;

public class RadixFloat {
    int operationCount = 0;

    // This method performs the radix sort algorithm on a floating-point array
    public int sort(float[] arr, int size) {
        // Get the maximum value of the array to determine the number of digits
        float max = getMax(arr, size);

        // Create two arrays to hold the sorted output
        float[] output1 = new float[size];
        float[] output2 = new float[size];

        // Perform bucket sort for each digit, starting from the least significant digit

        for (int exp = 1; max / exp > 0; exp *= 10) {
            // Sort the array into output1 using bucket sort
            operationCount += bucketSort(arr, size, exp, output1);

            // Sort output1 back into the array using another pass of bucket sort
            operationCount += bucketSort(output1, size, exp, output2);

            // Swap the arrays to prepare for the next iteration
            float[] temp = output1;
            output1 = output2;
            output2 = temp;
        }

        // Copy the sorted elements from the final output array back into the input
        // array
        System.arraycopy(output1, 0, arr, 0, size);

        return operationCount;
    }

    // This method returns the maximum value in a floating-point array
    public float getMax(float[] arr, int size) {
        float max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
                operationCount++; // Increment the Counter
            }
        }
        return max;
    }

    // This method performs bucket sort on a floating-point array based on a
    // specific digit
    public int bucketSort(float[] arr, int size, int exp, float[] output) {
        int numOfBuckets = 10;
        ArrayList<ArrayList<Float>> buckets = new ArrayList<>(numOfBuckets);

        // Initialize the buckets
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(new ArrayList<>());
            operationCount++;
        }

        // Place elements into buckets based on the specific digit
        for (int i = 0; i < size; i++) {
            int digit = (int) ((arr[i] / exp) % 10);
            buckets.get(digit).add(arr[i]);
            operationCount++; // Increment the counter for each element placement
        }

        // Sort each bucket individually
        int index = 0;
        int operationCount = 0; // Initialize operationCount variable
        for (ArrayList<Float> bucket : buckets) {
            if (bucket.size() > 1) {
                Collections.sort(bucket);
                operationCount += bucket.size() * (int) (Math.log(bucket.size()) / Math.log(2));
            }
            for (float value : bucket) {
                output[index++] = value;
                operationCount++; // Increment the counter for each element retrieval
            }
        }

        System.arraycopy(output, 0, arr, 0, size);
        return operationCount;
    }
}
