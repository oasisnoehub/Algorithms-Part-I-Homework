import java.util.Arrays;

public class ShellSort {
    public static void Sort(int[] array) {
        int n = array.length;

        // Start with a relatively large gap and reduce it gradually
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform insertion sort on subarrays with the current gap
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
    }

    public static void KnuthSort(int[] array) {
            int n = array.length;

            int gap = 1;
            while (gap <= n / 3) {
                gap = gap * 3 + 1;
            }

            while (gap > 0) {
                for (int i = gap; i < n; i++) {
                    int temp = array[i];
                    int j = i;
                    while (j >= gap && array[j - gap] > temp) {
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    array[j] = temp;
                }
                gap = (gap - 1) / 3;
            }
        }

    public static void main(String[] args) {
        int[] array1 = {12, 34, 8, 23, 45, 67, 89, 5, 19};

        System.out.println("Original array: " + Arrays.toString(array1));

        Sort(array1);

        System.out.println("Sorted array: " + Arrays.toString(array1));

        int[] array2 = {120, 342, 89, 231, 425, 67, 189, 55, 119};

        System.out.println("Original array: " + Arrays.toString(array2));

        KnuthSort(array2);

        System.out.println("Sorted array: " + Arrays.toString(array2));
    }
}
