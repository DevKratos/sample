package com.amansour.sampleapplication.extensions

fun <T> mergeLists(
    listOne: List<T>,
    listTwo: List<T>
): MutableList<T> {
    return mutableListOf<T>().apply {
        var i = 0
        var j = 0

        while (i < listOne.size && j < listTwo.size) {
            add(listOne[i++])
            add(listTwo[j++])
        }

        while (i < listOne.size) {
            add(listOne[i++])
        }

        while (j < listTwo.size) {
            add(listTwo[j++])
        }
    }
}