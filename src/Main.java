import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] random_array() {
        Random r = new Random();
        int[] arr = new int[r.nextInt(5, 11)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(-173, 247);
        }
        return arr;
    }

    private static int partition(int[] arr, int min, int max) {
        int pivotIndex = (min + max) / 2;
        int pivot = arr[pivotIndex];
        int i = min - 1, j = max + 1;
        while (true) {
            while (arr[++i] < pivot);
            while (arr[--j] > pivot);
            if (i >= j) return pivotIndex;
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            if (i == pivotIndex) pivotIndex = j++;
            else if (j == pivotIndex) pivotIndex = i--;
        }
    }

    public static void quickSort(int[] arr, int min, int max) {
        int p = partition(arr, min, max);
        if (min < (p - 1)) quickSort(arr, min, p - 1);
        if (max > (p + 1)) quickSort(arr, p + 1, max);
    }

    public static void quickSort(int[] arr) {   // перегруженная функция
        quickSort(arr, 0, arr.length - 1);
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array; int i = 0;
        do {
            i++;
            array = random_array();
            System.out.println(i + ". " + Arrays.toString(array));
            quickSort(array);
            System.out.println(i + ". " + Arrays.toString(array));
        } while (isSorted(array));
    }
}
