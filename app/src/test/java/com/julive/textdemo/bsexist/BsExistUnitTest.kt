package com.julive.textdemo.bsexist

import org.junit.Test

/**
 * Created by jinxianlun
 * on 9/8/21
 */
class BsExistUnitTest {

    @Test
    fun testFind1() {
        val arr = intArrayOf(1, 2, 2, 2, 2, 4, 4, 5, 6)
        val find = BsExist.find(arr, 5)
        assert(find)
    }

    @Test
    fun testFind2() {
        val arr = intArrayOf(1, 2, 2, 2, 2, 4, 4, 5, 6)
        val find = BsExistJava.find1(arr, 6)
        println("find:$find")
    }

    @Test
    fun testFind3() {
        val arr = intArrayOf(1, 2, 2, 2, 2, 4, 4, 5, 6)
        val find = BsExistJava.find2(arr, 4)
        println("find:$find")
    }

    @Test
    fun testFind4() {
        val arr = intArrayOf(1, 2, 2, 2, 2, 4, 4, 5, 6)
        val find = BsExistJava.find3(arr, 37)
        println("find:$find")
    }
}