package com.ariscdc.coding.problem.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ariscdc
 *
 * Given two numbers represented as an array, compute for the sum by computing
 * digit by digit and not converting it as a number data type as a whole.
 * Return the result as an array.
 *
 * {1,2} + {2,3} = {3,5} --> 12 + 23 = 35
 * {1,9} + {2,3,9} = {2,5,8}  --> 19 + 239 = 258
 *
 * 20160228 1130-1155 (25 mins.)
 * 20160228 1205-1215 (10 mins.)
 * 20160228 1240-1255 (15 mins.)
 *                    (50 mins.)
 */
public class AddNumbersDigitByDigitInArray {

    private static int[] getSum(int[] number1, int[] number2) {

        int digitSum = 0;
        int carry = 0;
        List<Integer> sum = new LinkedList<>();

        for (int i1 = number1.length - 1, i2 = number2.length - 1; i1 >= 0 || i2 >= 0; i1--, i2--) {
            if (i1 >= 0) {
                digitSum += number1[i1];
            }
            if (i2 >= 0) {
                digitSum += number2[i2];
            }
            digitSum += carry;
            sum.add(0, digitSum % 10);
            carry = digitSum / 10;
            digitSum = 0;
        }
        if (carry > 0) {
            sum.add(0, carry);
        }

        int[] result = new int[sum.size()];
        for (int i = 0; i < sum.size(); i++) {
            result[i] = sum.get(i);
        }
        return result;
    }

    private static void printArray(int[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i + 1 < array.length) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    public static void main(String[] args) {

        int[] numbers0 = { 0 };
        int[] numbers1 = { 1 };
        int[] numbers9 = { 9 };
        int[] numbers10 = { 1, 0 };
        int[] numbers19 = { 1, 9 };
        int[] numbers239 = { 2, 3, 9 };

        printArray(getSum(numbers9, numbers0));
        printArray(getSum(numbers10, numbers0));
        printArray(getSum(numbers9, numbers9));
        printArray(getSum(numbers19, numbers1));
        printArray(getSum(numbers19, numbers239));
    }
}
