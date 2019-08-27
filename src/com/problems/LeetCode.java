package com.problems;

public class LeetCode {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 1};
        numbers = nextPermutation(numbers);
        printArray(numbers);
    }

    public static int[] nextPermutation(int[] numbers) {
        if (numbers.length < 2) {
            return numbers;
        } else {
            for(int end = numbers.length - 1; end > 0; end--) {
                boolean isSmallEntryFound = false;
                for(int start = end; start > 0; start--) {
                    if (numbers[start-1] < numbers[start]) {
                        int iLast = end;
                        start = start-1;
                        while(numbers[start] >= numbers[iLast] && iLast > start) {
                            iLast--;
                        }

                        numbers = swap(numbers, start, iLast);
                        numbers = sortArray(numbers, ++start, numbers.length-1);
                        isSmallEntryFound = true;
                        break;
                    }
                }
                if(isSmallEntryFound) break;
                else {
                    numbers = reverse(numbers);
                    break;
                }
            }
        }
        return numbers;
    }

    public static int[] swap(int[] numbers, int m, int n) {
        int temp = numbers[m];
        numbers[m] = numbers[n];
        numbers[n] = temp;
        return numbers;
    }

    public static void printArray(int[] arrayElements) {
        for(int k = 0; k < arrayElements.length; k++)
            System.out.print(arrayElements[k]+",");

        System.out.println();
    }

    public static int[] sortArray(int[] numbers, int start, int end) {
        int temp;
        for (int i = start; i <= end; i++)
        {
            for (int j = i+1; j <= end; j++)
            {
                if (numbers[i] > numbers[j])
                {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }


    public static int[] reverse(int[] numbers) {
        int start = 0, end = numbers.length - 1;
        while (start < end)
        {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
        return numbers;
    }
}
