package com.example.skillcinema.data.queryparam

import android.media.TimedMetaData
import java.text.SimpleDateFormat
import java.util.*

object CurrentDate {
    private val listMonth = listOf(
        "", "JANUARY",
        "FEBRUARY",
        "MARCH",
        "APRIL",
        "MAY",
        "JUNE",
        "JULY",
        "AUGUST",
        "SEPTEMBER",
        "OCTOBER",
        "NOVEMBER",
        "DECEMBER"
    )

private val monthNumber = SimpleDateFormat("M").format(Date())
    val month = listMonth[monthNumber.toInt()]
    val year = SimpleDateFormat("yyyy").format(Date())



}