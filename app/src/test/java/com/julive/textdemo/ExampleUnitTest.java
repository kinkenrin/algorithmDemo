package com.julive.textdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSorted() {
        int times = 1000;
        int maxLength = 50;
        int maxValue = 10000;
        boolean isSorted = true;
        for (int i = 0; i < times; i++) {
            int[] ints = randomArr(maxLength, maxValue);

            SortUtil.bubbleSoft(ints);

            if (!isSorted(ints)) {
                System.out.println("排序错误");
                isSorted = false;
                break;
            }
        }
        assertTrue(isSorted);
    }

    @Test
    public void sss() {

    }

    private void printNum(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


    private static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int tmp = arr[0];
        for (int value : arr) {
            if (tmp > value) {
                return false;
            }
            tmp = value;
        }
        return true;
    }

    private int[] randomArr(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

}