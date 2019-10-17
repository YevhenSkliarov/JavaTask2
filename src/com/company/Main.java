package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MaxAndMinLength();
        sortFromMinToMaxAndMaxToMin();
        printNumbersThatHaveLengthMoreThanAverageAndLess();
        findFirstNumberWithMinDifferentNumbers();
        findCountOfEvenNumbersAndCountOfNumbersWithEvenEqualOddNumbers();
        RowNumbersIncrease();
        findNumberWithMaxDiffNumbers();
        generateMatrixform1toK();
        generateMatrix();
        rowSort(generateMatrix());
        columnSort(generateMatrix());
        rightShift(generateMatrix());
        leftShift(generateMatrix());
        upShift(generateMatrix());
        downShift(generateMatrix());
        increaseValuesInRow(generateMatrix());
        decreaseValuesInRow(generateMatrix());
        turnOn90(generateMatrix());
    }

    private static void print(int[][] matrix) {
        for (int i = 0, n = matrix.length; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static void MaxAndMinLength() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }
        //Task 1:
        int maxSize = 0;
        int maxValue = 0;
        for (int value : array) {
            String str = Integer.toString(value);
            if (str.length() > maxSize) {
                maxSize = str.length();
                maxValue = value;
            }
        }
        System.out.println("Max length is " + maxSize);
        System.out.println("Max length value is " + maxValue);

        int minSize = Integer.toString(array[0]).length();
        int minValue = array[0];
        for (int value : array) {
            String str = Integer.toString(value);
            if (str.length() < minSize) {
                minSize = str.length();
                minValue = value;
            }
        }
        System.out.println("Min length is " + minSize);
        System.out.println("Min length value is " + minValue);
    }

    private static void sortFromMinToMaxAndMaxToMin() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }

        //Task 2: Sort from min length to max length
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int value = array[j];
                int next = array[j + 1];
                if (Integer.toString(value).length() > Integer.toString(next).length()) {
                    array[j] = next;
                    array[j + 1] = value;
                }
            }
        }
        System.out.println(Arrays.toString(array));

        //sort from max length to min length
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int value = array[j];
                int next = array[j + 1];
                if (Integer.toString(value).length() < Integer.toString(next).length()) {
                    array[j] = next;
                    array[j + 1] = value;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void printNumbersThatHaveLengthMoreThanAverageAndLess() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }

        //Task 3:
        int sum = 0;
        for (int value : array) {
            sum += Integer.toString(value).length();
        }
        int middleValue = sum / array.length;
        //values length more than middleValue
        for (int val : array) {
            if (Integer.toString(val).length() > middleValue) {
                System.out.println("Value length more than " + middleValue + " is " + val);
            }
        }
        for (int val : array) {
            if (Integer.toString(val).length() < middleValue) {
                System.out.println("Value length less than " + middleValue + " is " + val);
            }
        }
    }

    private static void findFirstNumberWithMinDifferentNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }

        //Task 4:
        int[] valLenght = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            String[] arr = Integer.toString(array[i]).split("");
            int diff = 1;
            for (int j = 0; j < arr.length - 1; j++) {
                if (!arr[j].equals(arr[j + 1])) {
                    diff += 1;
                }
            }
            valLenght[i] = diff;
        }
        int min = 1;
        int index = 0;
        for (int i = 0; i < valLenght.length; i++) {
            if (valLenght[i] <= min) {
                index = i;
                break;
            }
        }
        System.out.println(array[index]);
    }

    private static int[][] generateMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input matrix size: ");
        int num = sc.nextInt();
        int[][] matrix = new int[num][num];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Random random = new Random();
                int rand = random.nextInt(num);
                int rnd = (int) (Math.random() * (2 * rand + 1)) - rand;
                matrix[i][j] = rnd;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return matrix;
    }

    private static int[][] turnOn90(int[][] matrix) {
        int[][] nmatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                nmatrix[i][j] = matrix[matrix.length - j - 1][i];
            }
        }
        System.out.println();
        print(nmatrix);
        return nmatrix;
    }

    private static int decreaseValuesInRow(int[][] matrix) {
        int[] arr = new int[matrix.length * matrix.length];
        int k = 0;
        int count = 1;
        int saved = 0;
        for (int[] i : matrix) {
            for (int j : i) {
                arr[k++] = j;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j + 1] == arr[j] + 1) {
                count += 1;
            } else {
                if (saved < count) {
                    saved = count;
                }
                count = 1;
            }

        }
        System.out.println(count > saved ? count : saved);
        return count > saved ? count : saved;
    }

    public static int increaseValuesInRow(int[][] matrix) {
        int[] arr = new int[matrix.length * matrix.length];
        int k = 0;
        int count = 1;
        int saved = 0;
        for (int[] i : matrix) {
            for (int j : i) {
                arr[k++] = j;
            }
        }
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j + 1] == arr[j] + 1) {
                count += 1;
            } else {
                if (saved < count) {
                    saved = count;
                }
                count = 1;
            }

        }
        return count > saved ? count : saved;
    }

    public static int[][] rowSort(int[][] matrix) {
        for (int k = 0; k < matrix.length - 1; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length - 1; j++) {
                    int current = matrix[i][j];
                    int next = matrix[i][j + 1];
                    if (matrix[i][j] > matrix[i][j + 1]) {
                        matrix[i][j] = next;
                        matrix[i][j + 1] = current;
                    }
                }
            }
        }
        print(matrix);
        return matrix;
    }

    private static int[][] columnSort(int[][] matrix) {
        int j;
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (j = 0; j < matrix.length; j++) {
                    int current = matrix[i][j];
                    if (i + 1 > matrix.length - 1) {
                        break;
                    } else {
                        int next = matrix[i + 1][j];
                        if (matrix[i][j] > matrix[i + 1][j]) {
                            matrix[i][j] = next;
                            matrix[i + 1][j] = current;
                        }
                    }
                }
            }
        }
        print(matrix);
        return matrix;
    }

    private static int[][] rightShift(int[][] matrix) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Please input slide step: ");
        int step = sc1.nextInt();
        int j;
        for (int k = 0; k < step; k++) {
            for (int i = 0; i < matrix.length; i++) {
                int buff = matrix[i][matrix.length - 1];
                for (j = matrix.length - 1; j > 0; j--) {
                    matrix[i][j] = matrix[i][j - 1];
                }
                matrix[i][j] = buff;
            }
        }
        print(matrix);
        return matrix;
    }

    private static int[][] leftShift(int[][] matrix) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Please input slide step: ");
        int step = sc1.nextInt();
        int j;
        for (int k = 0; k < step; k++) {
            for (int i = 0; i < matrix.length; i++) {
                int buff = matrix[i][0];
                for (j = 0; j < matrix.length - 1; j++) {
                    matrix[i][j] = matrix[i][j + 1];
                }
                matrix[i][j] = buff;
            }

        }
        print(matrix);
        return matrix;
    }

    private static int[][] downShift(int[][] matrix) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Please input slide step: ");
        int step = sc1.nextInt();
        int i;
        for (int k = 0; k < step; k++) {
            for (int j = 0; j < matrix.length; j++) {
                int buff = matrix[matrix.length - 1][j];
                for (i = matrix.length - 1; i > 0; i--) {
                    matrix[i][j] = matrix[i - 1][j];
                }
                matrix[i][j] = buff;
            }
        }
        print(matrix);
        return matrix;
    }

    private static int[][] upShift(int[][] matrix) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Please input slide step: ");
        int step = sc1.nextInt();
        int i;
        for (int k = 0; k < step; k++) {
            for (int j = 0; j < matrix.length; j++) {
                int buff = matrix[0][j];
                for (i = 0; i < matrix.length - 1; i++) {
                    matrix[i][j] = matrix[i + 1][j];
                }
                matrix[i][j] = buff;
            }

        }
        print(matrix);
        return matrix;
    }

    private static void findCountOfEvenNumbersAndCountOfNumbersWithEvenEqualOddNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean allIndexes = false;
            String[] str = Integer.toString(array[i]).split("");
            for (int j = 0; j < str.length; j++) {
                if (Integer.parseInt(str[j]) % 2 != 0) {
                    allIndexes = false;
                    break;
                } else {
                    allIndexes = true;
                }
            }
            if (allIndexes == true) {
                count += 1;
            }
        }
        System.out.println(count);

        int count1 = 0;
        for (int i = 0; i < array.length; i++) {
            String[] str = Integer.toString(array[i]).split("");
            int even = 0;
            int odd = 0;
            for (int j = 0; j < str.length; j++) {
                if (Integer.parseInt(str[j]) % 2 == 0) {
                    even += 1;
                } else if (Integer.parseInt(str[j]) % 2 != 0) {
                    odd += 1;
                }
            }
            if (even == odd) {
                count1 += 1;
            }
        }
        System.out.println(count1);
    }

    private static void RowNumbersIncrease() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            String[] str = Integer.toString(array[i]).split("");
            boolean row = false;
            for (int j = 0; j < str.length - 1; j++) {
                if (Integer.parseInt(str[j + 1]) != Integer.parseInt(str[j]) + 1) {
                    row = false;
                    break;
                } else {
                    row = true;
                }
            }
            if (row == true) {
                System.out.println(array[i]);
                break;
            }
        }
    }

    private static void findNumberWithMaxDiffNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            String str = Integer.toString(array[i]);
            String[] arr = Integer.toString(array[i]).split("");
            boolean diff = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (str.substring(j + 1).contains(arr[j])) {
                    diff = false;
                    break;
                } else {
                    diff = true;
                }
            }
            if (diff == true) {
                System.out.println(array[i]);
                break;
            }
        }
    }

    private static void generateMatrixform1toK() {
        Scanner in = new Scanner(System.in);
        System.out.println("input count of numbers");
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            Scanner in1 = new Scanner(System.in);
            System.out.print("Input number #" + (i + 1) + " ");
            array[i] = in1.nextInt();
        }

        //Task 8:
        Scanner in3 = new Scanner(System.in);
        System.out.print("input last matrix number: ");
        int first = 0;
        int last = in3.nextInt();
        int size = (int) Math.sqrt(last);
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                first++;
                matrix[i][j] = first;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
