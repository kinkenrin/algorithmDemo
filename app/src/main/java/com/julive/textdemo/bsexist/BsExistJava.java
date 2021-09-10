package com.julive.textdemo.bsexist;

/**
 * Created by jinxianlun
 * on 9/8/21
 */
public class BsExistJava {

    public static int find1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 找到大于等于num的最左边的数
     */
    public static int find2(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= num) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    /**
     * 找到小于等于num的最右边的数
     */
    public static int find3(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int ans = -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= num) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
