package com.problems;

import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class FindMinDistance {
    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 7, 11, 8, 10, 13, 6, 15, 22, 25, 1};
        System.out.println(minDistance(nums, 3, 6));

        int[][] grid = new int[][]
                { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}};
        //System.out.println(maxArea(grid));
        //subArraySum(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23);
        //System.out.println("Max sequence sum? "+maxSumSequence(new int[]{12, 34, 1, 5, 40, 80}));
        //ascSequence(new int[]{12, 11, 10, 5, 6, 2, 30}, 3);
        //maxSum(nums);
        //System.out.println("Possible triangles? "+incSubSeq(nums));
        //lcs("acbacba".toCharArray(),"abcabcaa".toCharArray(),"acbacba".length(),"abcabcaa".length());
        //peopleHeights();
        mergeMatrix();
        //sortedMatrix(grid);
        //System.out.println(removeDuplicates("caaabbbaacdddd"));
    }

    public static int minDistance(int[] nums, int a, int b) {
        int min = Integer.MAX_VALUE;
        int end  = 0, start = -1;
        while(end < nums.length) {
            if (nums[end] == a || nums[end] == b) {
                if (start < 0) {
                    start = end;
                } else if (start >= 0 && nums[start] == nums[end]) {
                    start = end;
                }
                else {
                    int dist = (end - start);
                    if (dist < min) min = dist;
                }
            }
            end++;
        }
        return min;
    }

    public static int maxArea(int[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) continue;
                else {
                    int area = 1;
                    int offsetX = i + 1;
                    int offsetY = j + 1;
                    while (isValidIndex(offsetX, offsetY,4,5)) {
                        if (matrix[i][offsetY] == 1 && matrix[offsetX][j] == 1) {
                            offsetX = (offsetX < 3)? offsetX+1 : offsetX;
                            offsetY = (offsetY < 4)? offsetY+1 : offsetY;
                            area += 2;
                        } else {
                            area += 1;
                            break;
                        }
                    }
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static boolean isValidIndex(int x, int y, int r, int c) {
        return (x >= 0 && y >= 0 && x < r && y < c);
    }

    public static void subArraySum(int[] nums, int sum) {
        int start = 0;
        int subSum = nums[start];
        for (int i = 1; i < nums.length; i++) {
            subSum += nums[i];
            while (subSum > sum) {
                subSum -= nums[start++];
            }
            if (subSum == sum)
                System.out.println("Found sum from "+start+" to "+i);
        }
    }

    public static int maxSumSequence(int[] nums) {
        int maxSum = Integer.MIN_VALUE, seqSum = nums[0];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] < st.peek()) {
                seqSum -= st.pop();
            }
            st.push(nums[i]);
            seqSum += st.peek();
            if (maxSum < seqSum) maxSum = seqSum;
        }
        return maxSum;
    }

    public static void ascSequence(int[] nums, int k) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) continue;
            else {
                if (!st.isEmpty() && st.peekFirst() > nums[i-1])
                    st.push(nums[i-1]);
            }
            st.push(nums[i]);
            if (st.size() == k) break;
        }
        while (!st.isEmpty()) System.out.print(st.pop()+" ");
    }

    public static void maxSum(int[] nums) {
        int j, maxSoFar = 0, currentMax = 0;
        for(int i = 0; i < nums.length; i++) {
            currentMax += nums[i];
            j = i + 1;
            while(j < nums.length) {
                currentMax += nums[j];
                if (currentMax < 0) currentMax = 0;
                if (maxSoFar < currentMax) maxSoFar = currentMax;
                j++;
            }
            currentMax = 0;
            //if (maxSoFar < currentMax) maxSoFar = currentMax;
        }

        System.out.println("Max of continuous sub array? "+maxSoFar);
    }

    public static int possibleTriangles(int[] nums) {
        int p1 = 0, p2 = 1, p3 = 2, triangles = 0, x, y, z;
        while(p3 < nums.length) {
            x = nums[p1];
            y = nums[p2];
            z = nums[p3];
            if ((x+y) > z) {
                p3++;
                triangles++;
            } else {
                p1++;
                p2++;
                p3 = p2 + 1;
            }
        }
        return triangles;
    }

    public static int possibleTriangles(int[] nums, int p1, int p2, int p3, int tr, int n) {
        if (p1 > n || p2 > n || p3 > n) return tr;
        if (p1 == n && p2 == n && p3 == n) return tr;

        int x = nums[p1];
        int y = nums[p2];
        int z = nums[p3];
        if ((x+y) > z) {
            return possibleTriangles(nums, p1, p2, p3+1, tr+1, n);
        } else if (p3 == n) return possibleTriangles(nums, p1, p2+1, p2+2, tr, n);
        else if (p2 == n - 1) return possibleTriangles(nums, p1+1, p1+1, p1+2, tr, n);
        else {
            return tr;
        }
    }

    public static int incSubSeq(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(nums[0]);
        int i = 1, max = Integer.MIN_VALUE;
        while (i < nums.length) {
            while (!st.isEmpty() && (nums[i] < st.peek())) {
                st.pop();
            }
            st.push(nums[i++]);
            if (max < st.size()) max = st.size();
        }
        return max;
    }

    public static void lcs(char[] x, char[] y, int m, int n) {
        int[][] result = new int[m+1][n+1];

        for (int r = 0; r <= m; r++) {
            for (int c = 0; c <= n; c++) {
                if (r == 0  || c == 0) {
                    result[r][c] = 0;
                } else if (x[r-1] == y[c-1]) {
                    result[r][c] = result[r-1][c-1] + 1;
                } else {
                    result[r][c] = Math.max(result[r-1][c], result[r][c-1]);
                }
            }
        }

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n + 1; j++)
                System.out.print(result[i][j] + " ");

            System.out.println();
        }

    }

    public static void peopleHeights() {
        int[] people = {4, 3, 2, 1};
        int[] infront = {0, 1, 2, 1};
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < infront.length; i++) {
            inMap.put(people[i], infront[i]);
        }
        Arrays.sort(people);
        boolean exit = false;
        while (!exit) {
            int howMany = inMap.get(people[0]);
            int k = 0, l = 1;
            while (howMany > 0) {
                if (people[k] < people[l]) {
                    int tmp = people[k];
                    people[k] = people[l];
                    people[l] = tmp;
                    k = l;
                    howMany--;
                }
                l++;
            }
            if (inMap.get(people[0]) == 0) exit = true;
        }
        Arrays.stream(people).forEach(num -> System.out.print(num+" "));
    }

    public static void mergeMatrix() {
        int[][] matrix = new int[][] {
                {0, 2, 0, 2},
                {2, 2, 2, 0},
                {2, 2, 2, 2},
                {0, 2, 2, 2}
        };
        matrix(matrix, true, false);
        //matrix(matrix, false, true);
        //matrix(matrix, false, true);
        for (int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                System.out.print(matrix[m][n]+" ");
            }
            System.out.println();
        }
    }
    public static void matrix(int[][] matrix, boolean isRow, boolean isForward) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            st.clear();
            if (isRow) {
                if (!isForward) {
                    for (int j = 0; j < 4; j++) {
                        if (matrix[i][j] > 0) {
                            if (!st.isEmpty() && matrix[i][j] == st.peek()) {
                                st.push(st.pop() * 2);
                            } else {
                                st.push(matrix[i][j]);
                            }
                        }
                    }
                } else {
                    for (int j = 3; j > 0; j--) {
                        if (matrix[i][j] > 0) {
                            if (!st.isEmpty() && matrix[i][j] == st.peek()) {
                                st.push(st.pop() * 2);
                            } else {
                                st.push(matrix[i][j]);
                            }
                        }
                    }
                }
            } else {
                if (!isForward) {
                    for (int j = 0; j < 4; j++) {
                        if (matrix[j][i] > 0) {
                            if (!st.isEmpty() && matrix[j][i] == st.peek()) {
                                st.push(st.pop() * 2);
                            } else {
                                st.push(matrix[j][i]);
                            }
                        }
                    }
                } else {
                    for (int j = 3; j > 0; j--) {
                        if (matrix[j][i] > 0) {
                            if (!st.isEmpty() && matrix[j][i] == st.peek()) {
                                st.push(st.pop() * 2);
                            } else {
                                st.push(matrix[j][i]);
                            }
                        }
                    }
                }
            }
            if (!st.isEmpty()) {
                int k = 0;
                while (!st.isEmpty()) {
                    if (isRow) {
                        if (isForward) matrix[i][k++] = st.removeFirst();
                        else matrix[i][k++] = st.removeLast();
                    } else {
                        if (isForward) matrix[k++][i] = st.removeFirst();
                        else matrix[k++][i] = st.removeLast();
                    }
                }
                while (k < 4) {
                    if (isRow) {
                        if (isForward) matrix[i][k++] = 0;
                        else matrix[i][k++] = 0;
                    } else {
                        if (isForward) matrix[k++][i] = 0;
                        else matrix[k++][i] = 0;
                    }
                }
            }
        }
    }

    public static String removeDuplicates(String str) {
        Deque<Character> st = new ArrayDeque<>();
        st.push(str.charAt(0));
        int i = 1;
        while (i < str.length()) {
            if (!st.isEmpty() && str.charAt(i) == st.peek()) {
                while (str.charAt(i) == st.peek()) {
                    st.pop();
                }
                st.push(str.charAt(i));
            } else {
                st.push(str.charAt(i));
            }
            i++;
        }
        StringBuffer buffer = new StringBuffer();
        while (!st.isEmpty())
            buffer.append(st.removeLast());
        return buffer.toString();
    }

    public static void sortedMatrix(int[][] matrix) {
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.val - o2.val;
            }
        });
        int column = 0;
        for (int row = 0; row < 4; row++) {
            Cell cell = new Cell(row, column, matrix[row][column]);
            pq.add(cell);
        }
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            System.out.print(cell.val + " ");
            if ((cell.y + 1) < 4) {
                Cell next = new Cell(cell.x, cell.y + 1, matrix[cell.x][cell.y + 1]);
                pq.add(next);
            }
        }
    }

    static class Cell {
        public int x, y, val;
        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
