import com.sun.tools.classfile.Code_attribute;

/**
 * Created by bahubali.n on 25/12/16.
 */
public class PrintSum {
    public static int MAX = 10000;
    public static void main(String[] args) throws Exception{
        int[] arr1 = {1, 2, 3, 2, 3, 1, 3};
        int[] arr2 = {5, 8, 12, 14};
        int[] arr = {1, 2, 1, 45, 35, 2, 1};
        int n = 16;
        System.out.println(PrintSum.getOddOccurance(arr1));
//        System.out.println("Array before sorting :");
//        PrintSum.mergeTwoArrays(arr1, arr2);
//        System.out.println("Array after sorting :");
//        for (int i = 0; i < arr1.length; i++)
//            System.out.println(arr1[i]);
    }

    public static void printPair(int[] arr, int size, int sum){
        boolean[] binMap = new boolean[MAX];
        int temp = 0;
        for (int i = 0; i < size; i++) {
            temp = sum - arr[i];
            if (temp >= 0 && binMap[temp]) {
                System.out.print("Sum of "+arr[i]+" and "+temp+" is "+sum);
            }
            binMap[arr[i]] = true;
        }
    }

    public static int getOddOccurance(int[] arr){
        int i;
        int res = 0;
        for (i = 0; i < arr.length; i++)
        {
            res = res ^ arr[i];
        }
        return res;
    }

    public static void mergeTwoArrays(int[] arr, int[] right) {
        int n = arr.length;
        int nRight = right.length;
        int[] left = new int[n-nRight];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                left[k++] = arr[i];
            }
        }
        int x = 0, y = 0, z = 0;
        int nLeft = left.length;
        while (x < nLeft && y < nRight) {
            if (left[x] <= right[y]) {
                arr[z++] = left[x++];
            } else {
                arr[z++] = right[y++];
            }
        }
        while (x < nLeft)
            arr[z++]=left[x++];
        while (y < nRight)
            arr[z++]=right[y++];
    }

    public static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }
}
