package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val diff = (date.time - this.time)
    val diffInSeconds = diff / 1000
    val minutes = (diff / (1000 * 60) % 60).toInt()
    val hours = (diff / (1000 * 60 * 60) % 24).toInt()
    val days = (diff / (1000 * 60 * 60 * 24) % 365).toInt()

    return when(diffInSeconds) {
        in 0..1 -> "только что"
        in 2..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 76..2700 -> "$minutes минут назад"
        in 2701..4500 -> "час назад"
        in 4501..79200 -> "$hours часов назад"
        in 79201..93600 -> "день назад"
        in 93601..31104000 -> "$days дней назад"
        else -> "более года назад"
    }
}

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

enum class TimeUnits {
    SECOND, MINUTE, HOUR, DAY
}