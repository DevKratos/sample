package com.amansour.sampleapplication.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionsKtTest {

    @Test
    fun testMergeListsEmpty() {
        val listOne = listOf<Int>()
        val listTwo = listOf<Int>()
        assertEquals(listOf<Int>(), mergeLists(listOne, listTwo))
    }

    @Test
    fun testMergeListsSameSize() {
        val listOne = listOf(1, 2)
        val listTwo = listOf(11, 22)
        assertEquals(listOf(1, 11, 2, 22), mergeLists(listOne, listTwo))
    }

    @Test
    fun testMergeListsDifferentSizeOne() {
        val listOne = listOf(1, 2, 3, 4)
        val listTwo = listOf(11, 22)
        assertEquals(listOf(1, 11, 2, 22, 3, 4), mergeLists(listOne, listTwo))
    }

    @Test
    fun testMergeListsDifferentSizeTwo() {
        val listOne = listOf(1, 2)
        val listTwo = listOf(11, 22, 33, 44)
        assertEquals(listOf(1, 11, 2, 22, 33, 44), mergeLists(listOne, listTwo))
    }
}