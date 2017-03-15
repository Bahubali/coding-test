import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 24/12/16.
 */
public class ArrayTest {

    public static void main(String[] args) throws Exception{
        int[] input = {6, 9, 3, 2, 8, 7, 13, 5};
        String input1 = "Hi Bahubali";
        char[] charArray = input1.toCharArray();
        System.out.println("Array before shift :");
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);
        ArrayTest.mergeSort(input);
        System.out.println("Array after shift :");
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);
    }

    public static int calculateSum(int[] arr, int left, int right, int sum, int cnt) {
        if (left == right)
            return arr[left];

        int mid = (left+right)/2;
        return calculateSum(arr, left, mid, sum, cnt) + calculateSum(arr, mid+1, right, sum, cnt);
    }

    public static int fibonacci(int n, List<Integer> list) {
        if (n == 0) return 0;
        if (n == 1) {
            if (!list.isEmpty() && list.get(n-1) != null)
                return list.get(n-1);
            else
                list.add(n);
            return 1;
        }
        if (!list.isEmpty()) {
            if (list.get(n - 1) != null) {
                return list.get(n - 1);
            }
        }
        System.out.println(n);
        list.add(fibonacci(n-1, list) + fibonacci(n -2, list));
        return list.get(n-1);
    }

    public static void normalSort(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-i-1); j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int key;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            int j = i - 1;
            while (j >=0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        for (int i = 0; i <= mid - 1; i++)
            left[i] = arr[i];
        for (int j = 0; j <= (n-mid-1); j++)
            right[j] = arr[mid+j];

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);

    }

    public static void merge(int[] left, int[] right, int[] finalArr){
        int nLeft = left.length;
        int nRight = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nLeft && j < nRight) {
            if (left[i] <= right[j]) {
                finalArr[k++] = left[i++];
            }else {
                finalArr[k++] = right[j++];
            }
        }
        while (i < nLeft) {
            finalArr[k++] = left[i++];
        }
        while (j < nRight) {
            finalArr[k++] = right[j++];
        }
    }


    public static void rotate(int[] arr, int shift) {
        int size = arr.length;
        int sIndex = shift;
        int temp;
        for (int i = 0; i < size -1; i++) {
            temp = arr[sIndex];
            arr[sIndex] = arr[i];
            arr[i] = temp;
            if (sIndex < size -1) sIndex++;
            else sIndex = shift;
        }
    }
}
