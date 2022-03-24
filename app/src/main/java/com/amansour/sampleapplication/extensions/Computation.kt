package com.amansour.sampleapplication.extensions

import java.util.concurrent.TimeUnit


fun Long.getPastDuration(): String {
    val pastTime = System.currentTimeMillis() - this

    val days = TimeUnit.MILLISECONDS.toDays(pastTime)
    val hours = TimeUnit.MILLISECONDS.toHours(pastTime - days * 24 * 60 * 60 * 1000)
    val minutes =
        TimeUnit.MILLISECONDS.toMinutes(pastTime - hours * 60 * 60 * 1000 - days * 24 * 60 * 60 * 1000)

    val duration = (if (days > 0) {
        "$days days, "
    } else "") + (if (hours > 0) "$hours hours, " else "") + ("$minutes minutes ago")
    return duration
}