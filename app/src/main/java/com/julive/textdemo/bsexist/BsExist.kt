package com.julive.textdemo.bsexist

/**
 * Created by jinxianlun
 * on 9/8/21
 */
object BsExist {

    fun find(arr: IntArray, num: Int): Boolean {

        var l = 0
        var r = arr.size

        while (l <= r) {
            val mid = (l + r) / 2
            when {
                arr[mid] == num -> {
                    return true
                }
                arr[mid] < num -> {
                    l = mid + 1
                }
                else -> {
                    r = mid - 1
                }
            }
        }
        return false
    }
}